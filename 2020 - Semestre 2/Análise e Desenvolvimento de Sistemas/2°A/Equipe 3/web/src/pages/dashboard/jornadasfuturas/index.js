import React,{ useState,useEffect } from 'react';
import './index.css';
import '../dashboard.css';
import Sidenav from '../../../components/sidenav/index';
import Header from '../../../components/header/index';
import ListJornada from '../../../components/listJornada/index';
import api from './../../../services/api'

function JornadaMotoristaPage(){

    useEffect(()=>{
        getUser(localStorage.getItem("id"))
     },[])

    const [data,setData]=useState([{id:0,motorista:"teste1",veiculo:"ABC-1234",inicio:"20/10/2020",fim:"21/10/2020",status:"FINALIZADO",alerta:null},{id:1,motorista:"teste2",veiculo:"ABC-1234",inicio:"20/11/2020",fim:"24/11/2020",status:"PENDENTE",alerta:"transito engarrafado"}]);
    const [nome,setNome]=useState();

    var jornadaFuturas = [];
    var dataHoje = new Date();

    for(var i=0;i < data.length;i++){
        for (var [key, value] of data[i]) {
            if(key=="motorista" && value==nome){
                for (var [key2, value2] of data[i]){
                    if(key2=="inicio"){
                        var arrDataExclusao = value2.split('/');
        
                        var dataNova = new Date(arrDataExclusao[2], arrDataExclusao[1] - 1, arrDataExclusao[0]);
                        
                        if(dataNova > dataHoje){
                            jornadaFuturas.push(data[i]);
                        }
                    }
                }
            
            }
        }
    }

    async function getUser(id){
        const res = await api.get("/user/"+id,{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        setNome(res.data.nome);
    }


    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Jornadas Futuras"/>
                <div className="main">
                    <div className='indexJornada'>
                        <ListJornada data={jornadaFuturas}/>
                    </div>
                </div>
            </div>
        </div>
    );
}


export default JornadaMotoristaPage;