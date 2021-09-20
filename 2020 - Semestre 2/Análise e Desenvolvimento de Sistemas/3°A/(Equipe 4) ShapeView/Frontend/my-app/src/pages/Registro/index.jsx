import React, { useState } from 'react'
import { useHistory } from 'react-router-dom';

import "../../index.css";

import Fatec from '../../imagem/fatecsjc2.png';
import Visiona from '../../imagem/visiona.png';
import Github from '../../imagem/github.png';
import logo from '../../imagem/logo.png';

function Registro(){

    const history = useHistory();
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');

    function handleRegisterUser() {
        if (!name || !email || !pass) {
            alert('Favor inserir todos os campos');
            return;
        }

        const data = {name, email, pass};

        const registedUsers = JSON.parse(localStorage.getItem('users'));

        if (registedUsers) {
            localStorage.setItem('users', JSON.stringify([...registedUsers, data]));
        } else {
            localStorage.setItem('users', JSON.stringify([data]));
        }

        history.push('/');
    }

    return(
    <div className="regitro">   
        <header class="menu-principal">
        <main>            
            <div class="header-1">
                <div class="logo">
                    <ul>
                        <li>
                        <button 
                            className='fatec'
                            type="button"
                        >
                            <img src={Fatec} />
                        </button>
                        </li>
                        <li>
                            <button 
                                className='visiona'
                                type="button"
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
        <main>
            <div class="entrar">
                <ul>
                    <button
                        className="sing-in"
                        type="button"
                        onClick={() => history.push('/')}
                    >
                        Entrar
                    </button>
                    
                    <button
                        className="register-btn"
                        type="button"
                        onClick={() => history.push('/registro')}
                    >
                        Registrar
                    </button>

                </ul>
            </div>
            <div class="entrada">
            <h2> Registre-se, é rápido e fácil</h2>
            <fieldset>
                <legend>Registro</legend>
                <form name="form">
                    Login <input class="nomer"  onChange={e => setName(e.target.value)} type="text" name="Nome" autocomplete="off"placeholder="Entre com Login" /><br/><br/>
                    Senha <input class="senhar" onChange={e => setPass(e.target.value)}  type="password" name="Senha" autocomplete="off"placeholder="Digite sua senha"  /><br/><br/>
                    E-mail <input class="emailr" onChange={e => setEmail(e.target.value)}  type="text" name="Email" autocomplete="off"placeholder="Digite seu E-mail"  /><br/><br/>

                    <button
                        onClick={handleRegisterUser}
                        type="button"
                    >
                        Enviar
                    </button>

                    <button
                        type="button"
                        onClick={() => history.push('/registro')}
                    >
                        Limpar
                    </button>

                </form>
            </fieldset> 
            </div>
        </main>
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
    )
}

export default Registro;