import React,{useEffect, useState} from 'react';
import './index.css';
import { Link } from 'react-router-dom';
import api from '../../services/api';
import { FaHome, FaUserAlt, FaTruck, FaRoad, FaComment, FaRegClipboard, FaClipboardList,FaMoneyBillAlt } from 'react-icons/fa';
import jquery from 'jquery'

function Sidenav(){

    const [cargo,setCargo]=useState();

    async function getColaborador(id){
        const res = await api.get("/user/"+id,{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })

        setCargo(getRole(res.data.roles[0].name))
    }

    function getRole(role_name){
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
    function toogleRelatorios(){
        jquery( "#relatorios" ).toggle();
    }

    useEffect(()=>{
        getColaborador(localStorage.getItem("id"))
    },[])

    return(
        <div className='sidenav'>
            <section>
                <Link to="/dashboard">
                    IACIT Transporte
                </Link>
            </section>
            <ul>
                <li>
                    <Link to="/dashboard">
                        <FaHome/>&nbsp;&nbsp;Home
                    </Link>
                </li>
                {(cargo=="Gerente" || cargo == "Administrador" || cargo == "Financeiro")?(
                    <li>
                        <Link to="/dashboard/colaborador">
                            <FaUserAlt/>&nbsp;&nbsp;Colaboradores
                        </Link>
                    </li>
                ):(null)}
                {(cargo=="Gerente" || cargo == "Administrador")?(
                    <li>
                        <Link to="/dashboard/veiculo">
                            <FaTruck/>&nbsp;&nbsp;Veículos
                        </Link>
                    </li>
                ):(null)}
                {(cargo=="Motorista")?(
                    <li>
                        <Link to="/dashboard/alerta">
                            <FaComment/>&nbsp;&nbsp;Emitir Alerta
                        </Link>
                    </li>
                ):(null)}
                {(cargo=="Motorista")?(
                    <li>
                        <Link to="/dashboard/jornadas_futuras">
                            <FaClipboardList/>&nbsp;&nbsp;Jornadas Futuras
                        </Link>
                    </li>
                ):(null)}
                {(cargo=="Gerente" || cargo == "Administrador" || cargo == "Financeiro")?(
                    <li>
                        <Link to="/dashboard/jornada">
                            <FaRoad/>&nbsp;&nbsp;Jornadas
                        </Link>
                    </li>

  
                ):(null)}
                {(cargo=="Gerente" || cargo == "Administrador" || cargo == "Financeiro")?(
                    <li>
                        <Link to="/dashboard/pagamento">
                            <FaMoneyBillAlt/>&nbsp;&nbsp;Pagamentos
                        </Link>
                    </li>

  
                ):(null)}
                {(cargo=="Gerente" || cargo == "Administrador" || cargo == "Financeiro")?(
                    <li onMouseOver={toogleRelatorios} onMouseOut={toogleRelatorios}>
                        <Link to="/dashboard">
                            <FaRegClipboard/>&nbsp;&nbsp;Relatórios
                        </Link>
                        
                            <ul style={{display:'none'}} id="relatorios">
                                <li>
                                    <Link to="/dashboard/relatorios/extratoDiario" style={{fontSize:'1rem'}}>
                                        &nbsp;&nbsp;&nbsp;&nbsp;<p style={{margin:'0'}}>Extrato diário</p>
                                    </Link>
                                </li>
                                <li>
                                    <Link to="/dashboard/relatorios/extratoMensal" style={{fontSize:'1rem'}}> 
                                        &nbsp;&nbsp;&nbsp;&nbsp;<p style={{margin:'0'}}>Extrato mensal</p>
                                    </Link>
                                </li>
                                <li>
                                    <Link to="/dashboard/relatorios/jornadasDescumpridas" style={{fontSize:'1rem'}}>
                                        &nbsp;&nbsp;&nbsp;&nbsp;<p style={{margin:'0'}}>Jornadas não cumpridas</p>
                                    </Link>
                                </li>
                            </ul>
                    </li>

                ):(null)}
            </ul>
        </div>
    );
}

export default Sidenav;