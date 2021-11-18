import React,{ useState, useEffect } from 'react';
import List from '../../../components/listVeiculo/index';
import { FaPlus } from 'react-icons/fa';
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import { Link } from 'react-router-dom';
import '../dashboard.css';
import './index.css';
import api from './../../../services/api'

function VeiculoPage(){

    const [data,setData]=useState([]);

    async function getVeiculos() {
        const res = await api.get("/veiculo/index",{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        console.log(res.data);
        setData(res.data)
        
    }
    useEffect(()=>{
        getVeiculos()
     },[])
    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Veículos"/>
                <div className="main">
                    <div className="indexVeículo">
                        <section className="listHeader">
                            <h5>Total de {data.length} {(data.length===1)?"veículo":"veículos"}</h5>
                            <Link to="/dashboard/veiculo/create">
                                <FaPlus/>&nbsp;Adicionar veículo
                            </Link>
                        </section>
                        <List data={data} route="veiculo"/>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default VeiculoPage;