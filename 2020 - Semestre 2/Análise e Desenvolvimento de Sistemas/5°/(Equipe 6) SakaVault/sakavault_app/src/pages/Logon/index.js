import React, { useState } from "react";
import { Link } from "react-router-dom";
import { FiLogIn } from 'react-icons/fi';

import Logo from 'assets/logo.svg';
import api from 'services/api';

import './styles.css';
import { login, hasUser } from "services/auth";

export default function SignIn(props) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);

  async function handleSignIn(event) {
    event.preventDefault();

    if(email.length === 0) return;

    if (!email || !password) {
      this.setState({ error: "Preencha o campo usuário e senha para continuar!" });
    } else {
      try {
        const response = await api.post("/login", { email, password });

        login(response.data.token);
        hasUser(response.data.user.name);

        props.history.push("/profile");

      } catch (err) {
        console.log(err);

        setError('Houve um problema com o login, verifique suas credenciais.')
      }
    }
  };

  return (
      <div className="logon-container">
          <div className="content">
              <section className="form">
                  <form  onSubmit={ handleSignIn }>
                      <img className="logo" src={ Logo } alt="SakaVault" />

                      {!!error && <p>{error}</p>}

                      <input
                      type="email"
                      placeholder="E-mail"
                      value={ email }
                      onChange={ event => setEmail(event.target.value) }
                      />

                      <input
                      type="password"
                      placeholder="Senha"
                      value={password}
                      onChange={ event => setPassword(event.target.value) }
                      />

                      <button className="button buttom-margin-top" type="submit">Entrar</button>

                      <Link className="back-link" to="/register">
                      <FiLogIn size={16} color="#e02041"></FiLogIn>
                      Criar uma conta</Link>
                  </form>
              </section>
          </div>
      </div>
  );
}
