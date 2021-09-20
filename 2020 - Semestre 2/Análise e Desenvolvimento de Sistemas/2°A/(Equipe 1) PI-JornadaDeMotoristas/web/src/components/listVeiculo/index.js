import React,{useState,useEffect} from 'react';
import { Link } from 'react-router-dom';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import './index.css';
import api from './../../services/api'

function List(props){

    const [route,setRoute]=useState(props.route);

    async function excluirVeiculo(chassi){
        var resultado = window.confirm("Você tem certeza que deseja excluir o veículo?");
        try {
            if (resultado == true) {
                await api.delete("/veiculo/"+chassi,{
                    headers:{
                        "Authorization":"Bearer "+localStorage.getItem("token")
                    }
                })
                alert("Veículo excluído com sucesso");    
                window.location.reload()
            }
        } catch (error) {
            alert("Veículo não excluído. Tente novamente");
            console.log(error);
        }
    }
    
    return(
        <div className="list">
            <ul>
                {
                    props.data.map(
                        data=>(
                            <li key={data.chassi}>
                                <section>
                                    <h3>{data.modelo}</h3>
                                    <h4><b>Placa:</b> {data.placa} | <b>Chassi:</b> {data.chassi}</h4>
                                </section>
                                <div>
                                    <Link to={"/dashboard/"+route+"/"+data.chassi+""}>
                                        <FaEdit/>
                                    </Link>
                                    <span >
                                        <FaTrashAlt onClick={()=>{excluirVeiculo(data.chassi)}} />
                                    </span>
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