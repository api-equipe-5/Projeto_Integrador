import React, { useState, useEffect } from 'react';
import '../dashboard.css';
import './index.css';
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import api from './../../../services/api';
import ListJornada from './../../../components/listJornada/index';
import { FaEdit, FaCheck, FaExclamationTriangle, FaTimes } from 'react-icons/fa';

function Dashboard() {

    const [cargo, setCargo] = useState("");
    const [nome, setNome] = useState("");
    const [matricula, setMatricula] = useState("");
    const [cpf, setCpf] = useState("");
    const [jornada, setJornada] = useState([]);
    const [status, setStatus] = useState();

    function getIcone(sigla) {
        switch (sigla) {
            case "0":
                return (<FaCheck style={{ color: "green" }} />);
            case "2":
                return (<FaTimes style={{ color: "red" }} />);
            default:
                return (<FaExclamationTriangle style={{ color: "yellow" }} />);
        }
    }

    function lastStatus(status) {
        var order = {};
        for (let i of status) {
            order[i.id] = i;
        }
        var last = Object.keys(order).pop();
        console.log(last);
        return order[last].status.id;
    }

    async function getColaborador(id) {
        const res = await api.get("/user/" + id, {
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }
        })
        setNome(res.data.nome)
        setCpf(res.data.cpf)
        setMatricula(res.data.matricula)
        setCargo(getRole(res.data.roles[0].name))
    }

    async function getJornada() {
        const res = await api.get("/jornada/current", {
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }
        })
        if (localStorage.getItem("role") == "ROLE_MOTORISTA") {
            for (let j of res.data) {
                if (j.motorista[0].matricula === localStorage.getItem("id")) {
                    setJornada(j);
                    localStorage.setItem("jornadaAtual", j.id);
                    break;
                }
            }
        }
        else {
            setJornada(res.data)
        }
    }
    function getRole(role_name) {
        // eslint-disable-next-line default-case
        switch (role_name) {
            case "ROLE_ADM":
                return "Administrador";
            case "ROLE_FINANCEIRO":
                return "Financeiro";
            case "ROLE_GERENTE":
                return "Gerente";
            case "ROLE_MOTORISTA":
                return "Motorista";
        }
    }

    useEffect(() => {
        getColaborador(localStorage.getItem("id"))
        getJornada();
        console.log(jornada);
    }, [])

    async function changeStatus() {
        try {
            let d = new Date()
            let da = d.getDate() + "/" + (d.getMonth() + 1) + "/" + d.getFullYear() + " " + d.toLocaleTimeString().slice(0, 5)
            await api.post("/jornada/" + jornada.id + "/status", {
                "status": {
                    "id": status
                },
                "data": da
            }, {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            });
            alert("Status atualizado");
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <div className="dashboard">
            <Sidenav />
            <div className="content">
                <Header text="Home" />
                <div className="main">
                    <div className="homeUser">
                        <section>
                            <b>Função</b> {cargo}
                            <br />
                            <b>Nome: </b> {nome}
                            <br />
                            <b>Matrícula: </b> {matricula}
                            <br />
                            <b>CPF: </b> {cpf}
                            <center>
                                <hr style={{ width: '85%' }}></hr>
                            </center>
                            <div className="current">
                                {
                                    (localStorage.getItem("role") == "ROLE_MOTORISTA") ?
                                        (<section>
                                            <center><h5>Jornada atual</h5></center>
                                            <div className='descricao'>
                                                <div>
                                                    <h5><b>Data inicio: </b>{jornada.data_inicio}</h5>
                                                    <h5><b>Data conclusão: </b>{jornada.data_final}</h5>
                                                </div>
                                                {
                                                    (jornada.alerta !== undefined
                                                        ?
                                                        (jornada.alerta.length > 0) ? (
                                                            <h5>{getIcone(jornada.alerta[jornada.alerta.length - 1].alerta.sigla)}&nbsp;&nbsp;{jornada.alerta[jornada.alerta.length - 1].alerta.parametro}</h5>
                                                        ) : null
                                                        :
                                                        null
                                                    )

                                                }

                                            </div>
                                            <form>
                                                <div>
                                                    <label>Status</label>
                                                    <select value={status} onChange={(e) => { setStatus(e.target.value); changeStatus() }}>
                                                        <option value={1} >JORNADA NÂO ENTREGUE</option>
                                                        <option value={2} >DESCANSO</option>
                                                        <option value={3} >ALMOÇO</option>
                                                        <option value={4} >ENTREGE</option>
                                                        <option value={5} >CANCELADA</option>
                                                        <option value={6}>A CAMINHO</option>
                                                        <option value={7}>ATRASADO</option>
                                                        <option value={8}>EM ANDAMENTO</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </section>) :
                                        <ListJornada data={jornada} />
                                }
                            </div>
                        </section>


                    </div>
                </div>
            </div>
        </div>
    );
}

export default Dashboard;