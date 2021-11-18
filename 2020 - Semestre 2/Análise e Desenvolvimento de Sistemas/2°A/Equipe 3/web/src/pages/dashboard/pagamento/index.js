import React,{useState,useEffect} from 'react';
import ListPagamento from '../../../components/listPagamento/index';
import { FaPlus } from 'react-icons/fa';
import api from './../../../services/api'
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import './index.css';
import '../dashboard.css';
import { Link } from 'react-router-dom';

function PagamentoPage(){

    const [data,setData]=useState([]);
    async function getPagamentos() {
        const res = await api.get("/pagamento/index",{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        setData(res.data)
        
    }

    useEffect(()=>{
        getPagamentos()
    },[])

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Pagamentos"/>
                <div className="main">
                    <div className="indexColaboradores">
                        <section className="listHeader">
                            <h5>Total de {data.length} {(data.length==1)?"pagamento":"pagamentos"}</h5>
                            <Link to="/dashboard/pagamento/create">
                                <FaPlus/>&nbsp;Adicionar pagamento
                            </Link>
                        </section>
                         <ListPagamento data={data}/>
                   
                    </div>
                </div>
            </div>
        </div>
    );   
}

export default PagamentoPage;