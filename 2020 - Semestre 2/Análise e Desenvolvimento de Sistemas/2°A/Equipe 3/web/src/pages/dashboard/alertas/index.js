import React,{ useState, useEffect } from 'react';
//import List from '../../../components/listVeiculo/index';
import { FaArrowLeft } from 'react-icons/fa';
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import { Link,useHistory } from 'react-router-dom';
import '../dashboard.css';
import './index.css';
import api from './../../../services/api'

function AlertaPage(){

    const [descricao,setDescricao]=useState();
    const [tipo,setTipo]=useState();
    const hist = useHistory()
    async function handleSubmit(e){
        e.preventDefault();
        let d = new Date()
        let data = d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear()+" "+d.getHours()+":"+d.getMinutes() 
        try{
            const alerta = {
                parametro:descricao,
                sigla:tipo,
                ocorrencia:data,
                icone:""
            }

            const res = await api.post("/alerta",alerta,{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            }) 

             await api.post("/jornada/"+localStorage.getItem("jornadaAtual")+"/alerta",{
                 alerta:{
                    id:res.data.id
                 },
                 data:res.data.ocorrencia
                },{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            })
             alert("Alerta enviado");
             hist.push("/dashboard")
                
        }catch(err){
            console.log(err);
        }

    }

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Emitir Alertas"/>
                <div className="createColaborador">
                    <section>
                        <Link to="/dashboard">
                            <FaArrowLeft/>&nbsp;Voltar
                        </Link>
                    </section>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Tipo de Aviso</label>
                            <select type="text" value={tipo} onChange={e => setTipo(e.target.value)} required>
                                <option value="0" defaultValue>Engarrafamento</option>
                                <option value="1">Problema no Veículo</option>
                                <option value="2">Problema de Saúde</option>
                                <option value="3">Outros</option>
                            </select>
                        </div>
                        <div>
                            <label>Descrição</label>
                            <textarea value={descricao} onChange={e => setDescricao(e.target.value)} required className="descricao-emitir-alertas"/>
                        </div>
                        <button type="submit">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default AlertaPage;