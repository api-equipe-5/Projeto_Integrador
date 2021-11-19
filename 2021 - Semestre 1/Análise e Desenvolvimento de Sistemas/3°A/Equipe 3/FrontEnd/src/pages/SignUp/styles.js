import styled, { keyframes } from 'styled-components';

// import { shade } from 'polished';

import LoginImg from '../../assets/Login-Cadastro/SignUp_Img.svg';

export const Container = styled.div`
  height: 100vh;
  display: flex;
  align-items: stretch;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  place-content: center;
  background-color: var(--primary-initial-bg);
  width: 100%;
  max-width: 700px;
  @media screen and (max-width: 798px) {
    max-width: 500px;
  }
`;

const appearFromLeft = keyframes`
  from {
    opacity: 0;
    transform: translateX(-50px);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
`;

export const AnimationContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  animation: ${appearFromLeft} 1s;

  .signup-form {
    max-width: 300px;
  }

  .signup-form-forgot {
    float: right;
  }

  .signup-form-forgot {
    float: left;
  }

  .signup-form-button {
    width: 100%;
  }

  .site-form-item-icon {
    color: rgba(0, 0, 0, 0.35);
  }
  /* img {
    height: 75px;
    width: 75px;
    position: relative;
    right: 20px;
  } */

  @media screen and (max-width: 458px) {
    form {
      width: 350px;
    }
  }
  @media screen and (max-width: 378px) {
    form {
      width: 320px;
    }
  }
  @media screen and (max-width: 328px) {
    form {
      width: 300px;
    }
  }
`;

export const Background = styled.div`
  flex: 1;
  background: url(${LoginImg}) no-repeat center;
  background-color: var(--secondary-initial-bg);
  background-size: 700px;
`;
