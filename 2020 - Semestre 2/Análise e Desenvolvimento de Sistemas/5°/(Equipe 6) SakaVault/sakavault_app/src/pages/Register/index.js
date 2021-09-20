import React, { useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { FiArrowLeft } from 'react-icons/fi';

import api from 'services/api';

// Styles
import './styles.css';

// Import logo
import logo from 'assets/logo.svg';

export default function Resgister() {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const history = useHistory();

    async function handleRegister(event) {
        event.preventDefault();

        const data = { name, email, password};

        try {
            await api.post('/register', data);

            history.push('/');
        } catch (err) {
            alert('Erro ao cadastrar, tente novamente.', err);
        }
    }

    return (
        <div className="register-container">
            <div className="content">
                <section>
                    <img src={ window.location.origin + logo } alt="SakaVault"/>

                    <h1>Cadastro</h1>

                    <Link className="back-link" to="/">
                        <FiArrowLeft size={16} color="#e02041"></FiArrowLeft>
                        Voltar ao início
                    </Link>

                </section>

                <form onSubmit={ handleRegister }>
                <input 
                        placeholder="Nome" 
                        value={ name } 
                        onChange={ event => setName(event.target.value) } 
                    />

                    <input 
                        type="email" 
                        placeholder="E-mail"
                        value={ email } 
                        onChange={ event => setEmail(event.target.value) }
                    />

                    <input
                        type="password"
                        placeholder="Senha" 
                        value={ password } 
                        onChange={ event => setPassword(event.target.value) }
                    />

                    <button className="button" type="submit"> Cadastrar </button>
                </form>
            </div>
        </div>
    );
}
