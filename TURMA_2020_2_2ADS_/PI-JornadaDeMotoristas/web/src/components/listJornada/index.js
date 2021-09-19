import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./index.css";
import api from './../../services/api'
import { FaEdit,FaCheck,FaExclamationTriangle,FaTimes } from 'react-icons/fa'

function ListJornada(props) {
    const [status, setStatus] = useState();

    console.log(props.data);

    function lastStatus(status){
        var order = {};
        for(let i of status){
            order[i.id]=i;
        }
        var last = Object.keys(order).pop();
        console.log(last);
        return order[last].status.status;
    }

    async function mudarStatus(data, st) {
        try {
            console.log(status);
            let d = new Date()
            let da = d.getDate() + "/" + (d.getMonth() + 1) + "/" + d.getFullYear() + " " + d.toLocaleTimeString().slice(0,5)
            console.log(da);
            const postData = {
                "status": {
                    "id": st
                },
                "data": da //aqui pode dar erro
            }


            const res = await api.post("/jornada/" + data.id + "/status", postData, {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            })
        } catch (error) {
            console.log(error);
        }

    }

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

    return (
        <div className="jornadaList">
            <ul>
                {props.data.map((data) => (
                    (status == undefined) ?

                        setStatus(data.status[0].status.id)
                        :
                        <li key={data.id}>
                            <Link to={"/dashboard/jornada/" + data.id} className="data">

                                {localStorage.getItem("role") == "ROLE_MOTORISTA" ? (
                                    <>
                                    <div style={{ display: 'inline' }}>
                                        <section>
                                            <h5>{data.destino}</h5>
                                            <br />
                                            <p>Início: {data.data_inicio}</p>
                                            <p>Final: {data.data_final}</p>
                                            <br />
                                            <p>{data.alerta[0].alerta}</p>
                                        </section>
                                        
                                        <h5><b>STATUS: </b>{lastStatus(data.status)}</h5>
                                           
                                    </div>
                                    {
                                        data.alerta.length>0?
                                        (
                                        <h5>{getIcone(data.alerta[data.alerta.length-1].alerta.sigla)}{data.alerta[data.alerta.length-1].alerta.ocorrencia}</h5>
                                        ):null
                                    }
                                    
                                    </>
                                ) : (
                                        <>
                                        <div>
                                            <section>
                                                <h5>
                                                    {data.motorista[0].nome} | {data.veiculo[0].placa}
                                                </h5>
                                                <br />
                                                <p>Início: {data.data_inicio}</p>
                                                <p>Final: {data.data_final}</p>
                                            </section>
                                            <h5><b>STATUS: </b>{lastStatus(data.status)}</h5>
                                        </div>
                                        {
                                            data.alerta.length>0?
                                            (
                                                <h5>{getIcone(data.alerta[data.alerta.length-1].alerta.sigla)}&nbsp;&nbsp;{data.alerta[data.alerta.length-1].alerta.ocorrencia}</h5>
                                            ):null
                                        }
                                        </>
                                    )}
                            </Link>
                        </li>
                ))}
            </ul>
        </div>
    );
}

export default ListJornada;
