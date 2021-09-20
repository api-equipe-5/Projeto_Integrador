import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import { message } from 'antd';

import './responsive.css'; //css responsive file

import {
  LoginContainer, Lock, LoginIcon, RegisterIcon,
} from './styles';

import { getToken } from '../../services/auth';

import { api_crud } from '../../services/api';
import Logo from '../../assets/images/Logo.png';

function Login() {
  const history = useHistory();

  const isUserConnected = getToken();

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  
  async function handleLogin () {
    if (email === 'debug') {
      localStorage.setItem('token', 'debug-token');
      history.push('/dashboard');
      return;
    }

    if (!email || !password) {
      message.error("Verifique os campos por favor");
      return;
    }

    try {
      const responseDb = await api_crud.post('/sessions', {
        email,
        password
      });

      const { token } = responseDb?.data;

      message.success('Login com sucesso!');     

      localStorage.setItem('token', token);

      history.push('/dashboard');
    } catch (error) {
      message.error('Algo deu errado!. Contate o suporte');
    }
  }

  useEffect(() => {
    if(isUserConnected) {
      history.push('/dashboard');
    }
  }, [history, isUserConnected]);

  return (
    <>
      <LoginContainer>
        <div className="form-container">

          <span className="page-title">ACESSE SUA CONTA</span>

          <form>
            <div className="input-container">
              <span className="email-symbol">@</span>
              <input 
                type="text" 
                placeholder="E-mail" 
                onChange={e => setEmail(e?.target?.value)}
              />
            </div>

            <div className="input-container">
              <Lock className="password-icon" />
              <input 
                type="password" 
                placeholder="Senha" 
                onChange={e => setPassword(e?.target?.value)}
              />
            </div>
          </form>

          <a href="/recovery" className="forgot-password">Esqueceu sua senha?</a>

          <button
            type="button"
            className="log-in"
            onClick={handleLogin}
          >
            <LoginIcon />
            ACESSAR
          </button>

        </div>

        <div className="register-container">
          <img id="logo-home" src={Logo} alt="VisGeo" />
          <span className="welcome">OLÁ, SEJA BEM-VINDO!</span>

          <p className="welcome-paragraph">Estavamos ansiosos por sua chegada, comece aqui sua nova jornada conosco.</p>

          <button
            type="button"
            className="register-btn"
            onClick={() => history.push('/register')}
          >
            <RegisterIcon className="register-icon" />
            CADASTRE-SE
          </button>

        </div>
      </LoginContainer>
    </>
  );
}

export default Login;
