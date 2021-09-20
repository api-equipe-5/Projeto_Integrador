import React from 'react';
import { useHistory } from 'react-router-dom';

import { Container } from './styles';

const OnlyAuthenticated = () => {
  const history = useHistory();

  const handleLogin = () => {
    history.push('/');
  }

  const handleRegister = () => {
    history.push('/register');
  }

  return (
    <Container>

      <section className="modalUnAuthUser">
        <h1>Faça login para acessar</h1>

        <section className="buttons">
          <button onClick={handleLogin}>
            Fazer login
          </button>

          <button onClick={handleRegister}>
            Registar
          </button>
        </section>
      </section>
      
    </Container>
  );
}

export default OnlyAuthenticated;