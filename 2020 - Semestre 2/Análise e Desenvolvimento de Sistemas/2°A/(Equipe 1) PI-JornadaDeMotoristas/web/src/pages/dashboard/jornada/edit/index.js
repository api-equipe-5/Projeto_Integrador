import React,{useEffect,useState} from 'react';
import './index.css';
import { FaArrowLeft } from 'react-icons/fa';
import InputMask from 'react-input-mask';
import { Link,useParams,useHistory } from 'react-router-dom';
import Sidenav from '../../../../components/sidenav/index';
import Header from '../../../../components/header/index';
import api from "./../../../../services/api";
import { FaEdit,FaCheck,FaExclamationTriangle,FaTimes } from 'react-icons/fa';

function EditJornada(props){

    let {id} = useParams();
 
    const hist = useHistory()
    const [dataInicio,setDataInicio]=useState();
    const [dataFim,setDataFim]=useState();
    const [endereco,setEndereco]=useState();
    const [motorista,setMotorista]=useState([]);
    const [veiculo,setVeiculo]=useState([]);
    const [carga,setCarga]=useState([]);
    const [status,setStatus]=useState([]);
    const [alerta,setAlerta]=useState([]);

    var inputRules = {
        '9': '[0-9]','a': '[A-Za-z]','*': '[A-Za-z0-9]'
    }

    async function getJornada(){
        const res = await api.get("/jornada/"+id,{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        setEndereco(res.data.destino);
        setDataFim(res.data.data_final);
        setDataInicio(res.data.data_inicio);
        setMotorista(res.data.motorista[0]);
        setVeiculo(res.data.veiculo[0]);
        setCarga(res.data.carga);
        setStatus(res.data.status);
        setAlerta(res.data.alerta);
    }
    async function handleSubmit(e){
        e.preventDefault();
        try{
            const jornada = {
                data_inicio:dataInicio,
                data_final:dataFim,
                destino:endereco,
                motorista:[{
                    matricula:motorista.matricula
                }],
                veiculo:[{
                    chassi:veiculo.chassi
                }]
            }
                
            await api.put("/jornada/"+id,jornada,{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            })
            alert("Jornada editada com sucesso!");
            hist.push("/dashboard/jornada")
                
        }catch(err){
            console.log(err);
        }
    }

    useEffect(()=>{
        getJornada();
        console.log(carga);
    },[])

    function getIcone(sigla){
        switch(sigla){
            case "0":
                return(<FaCheck style={{color:"green"}}/>);
            case "2":
                return(<FaTimes style={{color:"red"}}/>);
            default:
                return(<FaExclamationTriangle style={{color:"yellow"}}/>);
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
                    <div className="descricao">
                        <div>
                            <h5><b>Motorista: </b>{motorista.nome}</h5>
                            <h5><b>Veículo: </b>{veiculo.placa}</h5>
                            {(carga.length>0)?(
                                <div>
                                    <h5><b>Carga</b></h5>
                                    <ul className="cargaList">
                                        {
                                            carga.map(c=>(
                                            <li>{c.nome}</li>
                                            ))
                                        }
                                    </ul>
                                </div>
                            ):null}
                        </div>
                        {
                            (alerta.length>0)?(
                                <h5>
                                    {getIcone(alerta[alerta.length-1].alerta.sigla)}&nbsp;&nbsp;{alerta[alerta.length-1].alerta.ocorrencia}
                                </h5>
                            ):null
                        }
                    </div>
                    <br></br>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Data e hora de início</label>
                            <InputMask type="text" mask="99/99/9999 99:99" formatChars={inputRules} value={dataInicio} onChange={e => setDataInicio(e.target.value)}/>
                        </div>
                        <div>
                            <label>Data e hora de chegada</label>
                            <InputMask type="text" mask="99/99/9999 99:99" formatChars={inputRules} value={dataFim} onChange={e => setDataFim(e.target.value)}/>
                        </div>
                        <div>
                            <label>Endereço</label>
                            <input type="text" value={endereco} onChange={e => setEndereco(e.target.value)}/>
                        </div>

                        <button type="submit">Editar</button>
                    </form>
                    <br></br>
                    {
                        (status.length>0)?(
                            <div className="timeline">
                                <h5><b>Timeline</b></h5>
                                <ul>
                                    {
                                        status.map(s=>(
                                            <li>
                                                <h5>{s.status.status} - {s.data}</h5>
                                            </li>
                                        ))
                                    }
                                </ul>
                            </div>
                        ):null
                    }
                </div>
            </div>
        </div>
    </div>
    );
}

export default EditJornada;