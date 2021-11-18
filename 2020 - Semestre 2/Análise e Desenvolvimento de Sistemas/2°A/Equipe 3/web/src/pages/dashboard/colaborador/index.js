import React,{useEffect, useState} from 'react';
import List from '../../../components/listColab/index';
import { FaPlus } from 'react-icons/fa';
import api from './../../../services/api'
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import './index.css';
import '../dashboard.css';
import { Link } from 'react-router-dom';

function ColaboradorPage(){

    const [data,setData]=useState([]);
    async function getColaboradores() {
        const res = await api.get("/user/index",{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        setData(res.data)
        
    }

    useEffect(()=>{
       getColaboradores()
    },[])

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Colaboradores"/>
                <div className="main">
                    <div className="indexColaboradores">
                        <section className="listHeader">
                            <h5>Total de {data.length} {(data.length==1)?"colaborador":"colaboradores"}</h5>
                            <Link to="/dashboard/colaborador/create">
                                <FaPlus/>&nbsp;Adicionar colaborador
                            </Link>
                        </section>
                         <List data={data} route="colaborador"/>
                   
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ColaboradorPage;