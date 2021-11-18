import React from 'react';
import {Link} from 'react-router-dom';
import api from '../../services/api';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';

function ListPagamento(props){

    async function excluirPagamento(id){
        var resultado = window.confirm("Você tem certeza que deseja excluir o pagamento?");
        try {
            if (resultado == true) {
                await api.delete("/pagamento/"+id,{
                    headers:{
                        "Authorization":"Bearer "+localStorage.getItem("token")
                    }
                })
                alert("Pagamento excluído com sucesso");    
                window.location.reload()
            }
        } catch (error) {
            alert("Pagamento não excluído. Tente novamente");
            console.log(error);
        }
    }

    return(
        <div className="list">
            <ul>
                {
                    props.data.map(
                        data=>(
                            <li key={data.id}>
                                <section>
                                    <h3>{data.data}</h3>
                                    <h4><b>Valor:</b> {data.valor}</h4>
                                </section>
                                <div>
                                    <Link to={"/dashboard/pagamento/"+data.id}>
                                        <FaEdit/>
                                    </Link>
                                    <span >
                                        <FaTrashAlt onClick={()=>{excluirPagamento(data.id)}} />
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

export default ListPagamento;