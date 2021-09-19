import React,{useState,useEffect} from 'react';
import './index.css';
import { FaArrowLeft } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import InputMask from 'react-input-mask';
import Sidenav from '../../../../components/sidenav/index';
import Header from '../../../../components/header/index';
import api from './../../../../services/api'
import {useHistory} from 'react-router-dom'

function CreateJornada(){

    const hist = useHistory();
    const [dataInicio,setDataInicio]=useState();
    const [dataFim,setDataFim]=useState();
    const [endereco,setEndereco]=useState();
    const [matricula,setMatricula]=useState();
    const [chassi,setChassi]=useState();
    const [motoristas,setMotoristas]=useState([]);
    const [veiculos,setVeiculos]=useState([]);
    const [carga,setCarga]=useState();

    var inputRules = {
        '9': '[0-9]','a': '[A-Za-z]','*': '[A-Za-z0-9]'
    }

    useEffect(()=>{
        getMotoristas();
        getVeiculos();
    },[])

    async function handleSubmit(e){
        e.preventDefault();
        try{
            const jornada = {
                data_inicio:dataInicio,
                data_final:dataFim,
                destino:endereco,
                motorista:[{
                    matricula:matricula
                }],
                veiculo:[{
                    chassi:chassi
                }]
            }
            let d = new Date()
            let data = d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear()+" "+ d.toLocaleTimeString().slice(0,5)
            const status = {
                status:{
                    id:1
                },
                data: data
            }        
            const res = await api.post("/jornada",jornada,{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            });
            var cargas = carga.split(/\n/);
            for(let i of cargas){
                await api.post("/carga",{
                    "nome":i,
                    "jornada":{
                        "id":res.data.id
                    }
                },{
                    headers:{
                        "Authorization":"Bearer "+localStorage.getItem("token") 
                    }
                })
            }
            await api.post("/jornada/"+res.data.id+"/status",status,{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            });
            alert("Nova jornada cadastrada");
            hist.push("/dashboard/jornada")        
        }catch(err){
            console.log(err);
        }
    }

    async function getMotoristas(){
        try {
            const res = await api.get("/user/index",{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            });
            var m = [];
            for(let i of res.data){
                if(i.roles[0].name=="ROLE_MOTORISTA"){
                    m.push(i);
                }
            }
            setMotoristas(m);
        } catch (err) {
            console.log(err);
        }
    }

    async function getVeiculos(){
        try {
            const res = await api.get("/veiculo/index",{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            });
            setVeiculos(res.data);
        } catch (err) {
            console.log(err);
        }
    }

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Jornadas"/>
                <div className="main">
                    <div className="createJornada">
                        <section>
                            <Link to="/dashboard/jornada">
                                <FaArrowLeft/>&nbsp;Voltar
                            </Link>
                        </section>
                        <form onSubmit={handleSubmit}>
                            <div>
                                <label>Data e hora de início</label>
                                <InputMask type="text" mask="99/99/9999 99:99" formatChars={inputRules} value={dataInicio} onChange={e => setDataInicio(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Data e hora de chegada</label>
                                <InputMask type="text" mask="99/99/9999 99:99" formatChars={inputRules} value={dataFim} onChange={e => setDataFim(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Endereço</label>
                                <input type="text" value={endereco} onChange={e => setEndereco(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Motorista</label>
                                <select onChange={e => setMatricula(e.target.value)} required>
                                    <option disabled selected>Motorista</option>
                                    {
                                        motoristas.map(motorista=>(
                                            <option value={motorista.matricula}>{motorista.nome}, cpf:{motorista.cpf}</option>
                                        ))
                                    }
                                </select>
                            </div>
                            <div>
                                <label>Veículo</label>
                                <select onChange={e => setChassi(e.target.value)} required>
                                    <option disabled selected>veículo</option>
                                    {
                                        veiculos.map(veiculo=>(
                                            <option value={veiculo.chassi}>{veiculo.placa}, {veiculo.modelo}</option>
                                        ))
                                    }
                                </select>
                            </div>
                            <div>
                                <label>Carga</label>
                                <textarea cols="4" value={carga} onChange={e => setCarga(e.target.value)}/>
                            </div>

                            <button type="submit">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CreateJornada