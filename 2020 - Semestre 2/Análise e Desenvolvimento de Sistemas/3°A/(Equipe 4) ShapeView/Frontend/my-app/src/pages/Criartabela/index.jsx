import React, { useState } from 'react';
import {useHistory} from 'react-router-dom';

import "../../index.css";

import api from '../../utils/api';

import Fatec from '../../imagem/fatecsjc2.png';
import Visiona from '../../imagem/visiona.png';
import Github from '../../imagem/github.png';
import logo from '../../imagem/logo.png';

function Criar() {
    const history = useHistory()
    const [host, setHost] = useState();
    const [port, setPort] = useState();
    const [password, setPassword] = useState();
    const [user, setUser] = useState();
    const [database, setDatabase] = useState();

    async function handleConnectToDatabase() {
        const data = {
            host,
            port,
            password,
            user,
            database
        }

        try {
            await api.post('/con', data);
            alert("Conectado com sucesso !");

            const latests = JSON.parse(localStorage.getItem('latests_connections'));

            if (latests) {
                localStorage.setItem('latests_connections', JSON.stringify([...latests, data]));
            } else {
                localStorage.setItem('latests_connections', JSON.stringify([data]));
            }

            history.push('/principal'); 
        } catch (error) {
            alert("Falha ao conectar com o banco de dados !");
        }        
    }

    return (
    <div className="App">
        <header className="menu-principal">
            
            <main>            
                <div className="header-1">
                    <div className="logo">
                        <ul>
                            <li>
                                <button 
                                    className='fatec'
                                    onClick={() => window.open( 'https://fatecsjc-prd.azurewebsites.net')}
                                >

                                  <img src={Fatec} />
                                  
                                </button>
                                
                                
                            </li>
                            <li>
                                <button 
                                className='visiona'
                                onClick={() => window.open( 'https://fatecsjc-prd.azurewebsites.net')}
                                >
                                  <img src={Visiona}/>

                                </button>
                            </li>
                        </ul>

                    </div>
                    <div className="linkgit">
                    
                        <button 
                        className='github'
                        onClick={() => window.open( 'https://github.com/Mateus-Prestes/Projeto-integrador-3-Semestre')}
                        >

                          <img src={Github}/>

                        </button>
                    
                    </div>
                </div>

            </main>

        </header>
        <main>
            <div className="header-2">


            </div>
        </main>
        <div className="entrada">
            <div className="seleçao">
                <h2> Preencha com as informações necessarias</h2>
                <fieldset className="criatab">
                    <legend>Banco</legend>
                    <form name="form">
                        host:&nbsp;
                        <input 
                            className= "nome" 
                            type="text" 
                            name="host" 
                            onChange={(e)=> setHost(e.target.value)} 
                            autocomplete="off"
                        />
                        <br/><br/>
                        port:&nbsp;
                        <input 
                            className= "senha" 
                            type="text" 
                            name="port" 
                            onChange={(e)=> setPort(e.target.value)} 
                            autocomplete="off"
                        />
                        <br/><br/>

                        database:&nbsp;
                        <input 
                            className= "nome" 
                            type="text" 
                            name="database" 
                            onChange={(e)=> setDatabase(e.target.value)} 
                            autocomplete="off"
                        />
                        <br/><br/>

                        user:&nbsp; 
                        <input 
                            className= "nome" 
                            type="text" 
                            name="user" 
                            onChange={(e)=> setUser(e.target.value)} 
                            autocomplete="off"
                        />
                        <br/><br/>

                        password:&nbsp;
                        <input 
                            className= "nome" 
                            type="password" 
                            name="password" 
                            onChange={(e)=> setPassword(e.target.value)} 
                            autocomplete="off"
                        />
                        <br/><br/>


                        <button
                            onClick={handleConnectToDatabase}
                            type = 'button'
                        >
                            Conectar
                        </button>

                        <input type="reset" name="limpar" value="Limpar" />

                    </form>
                </fieldset>
            </div>
        </div>
        <div className="logono">
            <ul>
                <img src={logo}/>
            </ul>
            <ul>
                <span className="span">
                    <font className="font1">ShapeView</font> 
                    Seu shapefile rápido e fácil
                </span>
            </ul>

        </div>
    </div>
  );
}

export default Criar;
