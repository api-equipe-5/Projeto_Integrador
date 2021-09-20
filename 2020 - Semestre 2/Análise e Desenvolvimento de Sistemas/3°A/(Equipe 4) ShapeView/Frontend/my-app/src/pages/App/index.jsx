import React, { useState } from 'react'
import {useHistory} from 'react-router-dom';

import "../../index.css";

import Fatec from '../../imagem/fatecsjc2.png';
import Visiona from '../../imagem/visiona.png';
import Github from '../../imagem/github.png';
import logo from '../../imagem/logo.png';

function App() {
    const history = useHistory();
    const [login, setLogin] = useState('');
    const [pass, setPass] = useState('');

    function handleLogin() {
        const localUsers = JSON.parse(localStorage.getItem('users'));

        if (!localUsers) {
            alert('Nenhum usuário foi encontrado no banco de dados');
            return;
        }


        const filteredUser = localUsers.filter(user => user.name === login && user.pass === pass);
        
        if (filteredUser[0]) {
            alert('Logado com sucesso');
            history.push('/principal');
        } else {            
            alert('Nenhum usuário foi encontrado no banco de dados');
        }
    }

    return (
    <div className="App">
        <header class="menu-principal">
            <main>            
                <div class="header-1">
                    <div class="logo">
                        <ul>
                            <li>
                                <button 
                                    className='fatec'
                                    type="button"
                                    onClick={() => window.open( 'https://fatecsjc-prd.azurewebsites.net')}
                                >

                                  <img src={Fatec} />
                                  
                                </button>
                                
                                
                            </li>
                            <li>
                                <button 
                                    className='visiona'
                                    type="button"
                                    onClick={() => window.open( 'https://fatecsjc-prd.azurewebsites.net')}
                                >
                                  <img src={Visiona}/>

                                </button>
                            </li>
                        </ul>

                    </div>
                    <div class="linkgit">
                    
                        <button 
                            className='github'
                            type="button"
                            onClick={() => window.open( 'https://github.com/Mateus-Prestes/Projeto-integrador-3-Semestre')}
                        >

                          <img src={Github}/>

                        </button>
                    
                    </div>
                </div>

            </main>

        </header>
        <main>
            <div class="header-2">


            </div>
        </main>

        <div class="entrar">
            <ul>
                <button
                    type="button"
                    className="sing-in"
                    onClick={() => history.push('/')}
                >
                    Entrar
                </button>

                <button
                    type="button"
                    className="register-btn"
                    onClick={() => history.push('/registro')}
                >
                    Registrar
                </button>

            </ul>
        </div >
        <div class="entrada">
        <h2> Preencha com o Login e a senha</h2>
        <fieldset className="arq">
            <legend>Login</legend>
            <form name="form">
                Login <input onChange={(e) => setLogin(e.target.value)} class= "nome" type="text" name="Nome" autocomplete="off" placeholder='Entre com Login'/><br/><br/>
                Senha <input onChange={(e) => setPass(e.target.value)} class= "senha" type="password" name="Senha" autocomplete="off"placeholder ='Informe a Senha'/><br/><br/>

                <button
                    type="button"
                    onClick={handleLogin}
                >
                    Enviar
                </button>

                <input type="reset" name="limpar" value="Limpar" />

            </form>
        </fieldset>
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

export default App;
