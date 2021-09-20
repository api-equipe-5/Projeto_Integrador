import React, { useState } from 'react';
import { useHistory } from 'react-router-dom'
import { message } from 'antd';

import {
  RegisterContainer, Lock, LoginIcon, RegisterIcon,
  UserIcon,
} from './styles';

import { api_crud } from '../../services/api';
import Logo from '../../assets/images/Logo.png';

function Register() {
  const history = useHistory();

  const [name, setName] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();

  async function handleRegister () {
    if (!name || !email || !password) {
      message.error("Verifique os campos por favor");
      return;
    }

    try {
      await api_crud.post('/users', {
        name,
        email,
        password
      });

      message.success('Cadastrado com sucesso!');
      history.push('/');
    } catch (error) {
      message.error('Algo deu errado!. Contate o suporte');
    }
  }

  return (
    <>
      <RegisterContainer>
        <div className="form-container">

          <span className="page-title">CRIAR UMA CONTA</span>

          <form>
            <div className="input-container">
              <UserIcon className="user-icon" />
              <input 
                type="text" 
                placeholder="Nome" 
                onChange={e => setName(e?.target?.value)}
              />
            </div>

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

          <button 
            type="button" 
            onClick={handleRegister}
            className="log-in"
          >
            <RegisterIcon />
            CADASTRAR
          </button>

        </div>

        <div className="register-container">
          <img src={Logo} alt="VisGeo" />
          <span className="welcome">JÁ TEM UMA CONTA?</span>

          <p className="welcome-paragraph">Mantenha-se conectado com a gente! preencha suas credênciais de acesso aqui.</p>

          <button
            type="button"
            className="register-btn"
            onClick={() => history.push('/')}
          >
            <LoginIcon className="hover-icon" />
            ENTRAR
          </button>

        </div>
      </RegisterContainer>
    </>
  );
}

export default Register;
