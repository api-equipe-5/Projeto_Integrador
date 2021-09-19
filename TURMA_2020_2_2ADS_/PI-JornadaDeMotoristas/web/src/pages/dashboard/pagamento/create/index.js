import React, { useState, useEffect } from 'react';
import './index.css';
import { FaArrowLeft } from 'react-icons/fa';
import { Link,useHistory } from 'react-router-dom';
import InputMask from 'react-input-mask';
import Sidenav from '../../../../components/sidenav/index';
import Header from '../../../../components/header/index';
import api from './../../../../services/api'

function CreatePagamento(){

    const hist = useHistory();

    const [valor,setValor]=useState();
    const [obs,setObs]=useState();
    const [data,setData]=useState();
    const [status,setStatus]=useState();
    const [user,setUser]=useState();
    const [motoristas,setMotoristas]=useState([]);

    var inputRules = {
        '9': '[0-9]','a': '[A-Za-z]','*': '[A-Za-z0-9]'
    }

    useEffect(()=>{
        getMotoristas();
    },[])

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

    async function handleSubmit(e){
        e.preventDefault();
        try{
            await api.post("pagamento",{
                "valor":valor,
                "observacao":obs,
                "data":data,
                "status":status,
                "usuario":{
                    "matricula":user
                }
            },{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            });
            alert("Novo pagamento criado");
            hist.push("/dashboard/pagamento");
        }catch(err){
            console.log(err);
        }
    }

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Pagamentos"/>
                <div className="main">
                    <div className="createColaborador">
                        <section>
                            <Link to="/dashboard/pagamento">
                                <FaArrowLeft/>&nbsp;Voltar
                            </Link>
                        </section>
                        <form onSubmit={handleSubmit}>
                            <div>
                                <label>Valor</label>
                                <input type="number" value={valor} onChange={e => setValor(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Observação</label>
                                <input type="text" value={obs} onChange={e => setObs(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Data</label>
                                <InputMask type="text" mask="99/99/9999" formatChars={inputRules} value={data} onChange={e => setData(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Status</label>
                                <select value={status} onChange={e => setStatus(e.target.value)}>
                                    <option disabled selected>status</option>
                                    <option value='pago'>Pago</option>
                                    <option value='pendente'>Pendente</option>
                                    <option value='cancelado'>Cancelado</option>
                                </select>
                            </div>
                            <div>
                                <label>Usuário</label>
                                <select value={user} onChange={e => setUser(e.target.value)}>
                                    <option disabled selected>usuário</option>
                                    {
                                        motoristas.map(m=>(
                                            <option value={m.matricula}>{m.nome}, cpf: {m.cpf}</option>
                                        ))
                                    }
                                </select>
                            </div>
                            <button type="submit">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CreatePagamento;