import React, { useState, useEffect } from 'react';
import { useHistory, Redirect } from 'react-router-dom';
import api from '../services/api';
import Alert from 'rsuite/lib/Alert';
import 'rsuite/es/Alert/styles/themes/dark.less';
import '../styles/style.css';

export default function Login() {

    const [isLogged, setIsLogged] = useState(false);
    const [user, setUser] = useState('');
    const [password, setPassword] = useState('');
    const [host, setHost] = useState('');
    const [port, setPorta] = useState('');
    const [database, setDatabase] = useState('');

    const history = useHistory();

    async function requestConnection(e) {
        e.preventDefault();

        const dados = {
            user,
            password,
            host,
            port,
            database,
        };

        localStorage.setItem('jumbo/user', dados.user);
        localStorage.setItem('jumbo/password', dados.password);
        localStorage.setItem('jumbo/host', dados.host);
        localStorage.setItem('jumbo/port', dados.port);
        localStorage.setItem('jumbo/database', dados.database);

        try {
            const response = await api.post('login', dados);
            if (response.data.isConnected === "Conectado") {
                Alert.success(`${response.data.isConnected}`);
                history.push('/Listar');
            } else {
                Alert.success(`${response.data.isConnected}`);
            }
        } catch (err) {
            if (err.response) {
                Alert.error(`${err.response.data.isConnected}`);
            } else if (err.request) {
                Alert.error(`Não foi possível conectar`);
            } else {
                Alert.error(`Não foi possível conectar`);
            }
        }

    }

    useEffect(() => {
        const userOn = localStorage.getItem('jumbo/user');
        if (userOn !== null || '') {
            setIsLogged(true)
        }
    }, []);

    if (isLogged) {
        return <Redirect to='/listar' />;
    }

    return (
        <div className="container-login">
            <div className="container-login-content">
                <section className="leftLogin">
                    <img src={require('../assets/login-banner.svg')} alt='Clique para visualizar o mapa' />
                </section>
                <section className="rightLogin">
                    <form onSubmit={requestConnection}>
                        <div className="login-form-topside">
                            <div className="login-form-topside-user">
                                <label>Usuário</label>
                                <input value={user} onChange={e => setUser(e.target.value)} />
                            </div>
                            <div className="login-form-topside-pw">
                                <label>Senha</label>
                                <input type="password" value={password} onChange={e => setPassword(e.target.value)}></input>
                            </div>
                        </div>
                        <div className="login-form-botside">
                            <div className="login-form-botside-label">
                                <label>Host</label>
                                <label>Porta</label>
                                <label>Database</label>
                            </div>
                            <div className="login-form-botside-input">
                                <input value={host} onChange={e => setHost(e.target.value)}></input>
                                <input value={port} onChange={e => setPorta(e.target.value)}></input>
                                <input value={database} onChange={e => setDatabase(e.target.value)}></input>
                            </div>
                        </div>
                        <div className="login-form-button">
                            <button className='btnLogin' type='submit'>Conectar</button>
                        </div>
                    </form>
                </section>

            </div>
        </div>
    );
}