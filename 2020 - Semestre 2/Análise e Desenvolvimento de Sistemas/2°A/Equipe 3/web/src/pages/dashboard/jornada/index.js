import React,{ useState,useEffect } from 'react';
import './index.css';
import '../dashboard.css';
import {Link} from 'react-router-dom'
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import ListJornada from '../../../components/listJornada/index';
import api from './../../../services/api'
import {FaPlus} from 'react-icons/fa'

function JornadaPage(){

    const [data,setData]=useState([]);
    async function getJornadasAtuais(){
        try {
            const res = await api.get("/jornada/index/", {
              headers: {
                Authorization: "Bearer " + localStorage.getItem("token"),
              },
            });
            setData(res.data);
          } catch (error) {
            alert("Algum erro ocorreu,tente novamente mais tarde.");
            console.log(error);
          }
    }

    useEffect(()=>{
        getJornadasAtuais()
    },[])
    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Jornadas"/>
                <div className="main">
                    
                    <div className='indexJornada'>
                        <section className="listHeader">
                            <h5>Total de {data.length} {(data.length==1)?"jornada ativa":"jornadas ativas"}</h5>
                            <Link to="/dashboard/jornada/create">
                                <FaPlus/>&nbsp;Adicionar jornada
                            </Link>

                        </section>
                        <ListJornada data={data}/>

                    </div>
                </div>
            </div>
        </div>
    );
}

export default JornadaPage;