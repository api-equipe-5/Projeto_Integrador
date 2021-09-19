import React,{useState, useEffect} from 'react';
import { Link } from 'react-router-dom';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import './index.css';
import api from './../../services/api'

function List(props){

    const [route,setRoute]=useState(props.route);
    const [cargo,setCargo]=useState(localStorage.getItem("role"));
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
    async function excluirColab(id){
        var resultado = window.confirm("Você tem certeza que deseja excluir o colaborador?");
        try {
            if (resultado == true) {
                await api.delete("/user/"+id,{
                    headers:{
                        "Authorization":"Bearer "+localStorage.getItem("token")
                    }
                })
                alert("Colaborador excluído com sucesso");    
                window.location.reload()
            }
        } catch (error) {
            console.log(error);
            alert("Colaborador não excluído. Tente novamente");
        }
    }

    return(
        <div className="list">
            <ul>
                {
                    props.data.map(
                        data=>(
                            <li key={data.matricula}>
                                <section>
                                    <h4>{data.nome}</h4>
                                    <h5>{getRole(data.roles[0].name)}</h5>
                                    {(data.type)?(<h5>{data.type}</h5>):(null)}
                                </section>
                                <div>
                                    <Link to={"/dashboard/"+route+"/"+data.matricula}>
                                        <FaEdit/>
                                    </Link>
                                    {((cargo=="ROLE_ADM") || (cargo=="ROLE_GERENTE"))?(
                                        <span onClick={()=>{excluirColab(data.matricula)}}>
                                            <FaTrashAlt/>
                                        </span>
                                    ):(null)}
                                </div>
                            </li>
                        )
                    )
                }
            </ul>
        </div>
    );
}

export default List;