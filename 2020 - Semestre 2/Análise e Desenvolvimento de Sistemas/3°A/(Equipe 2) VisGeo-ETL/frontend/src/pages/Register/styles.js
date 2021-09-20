import styled from 'styled-components';

import { IoIosLock } from 'react-icons/io';
import { AiOutlineLogin } from 'react-icons/ai';
import { BsPersonPlusFill } from 'react-icons/bs';
import { FaUserAlt } from 'react-icons/fa';
import LoginBG from '../../assets/images/VisGeoBG.png';

export const UserIcon = styled(FaUserAlt)`
  font-size: 25px;
  color: #B2B2B2;

  transition: ease-in-out 0.2s;
`;

export const RegisterIcon = styled(BsPersonPlusFill)`
  margin-right: 10px;

  font-size: 30px;
  color: #FFFFFF;
`;

export const Lock = styled(IoIosLock)`
  font-size: 30px;
  color: #B2B2B2;

  transition: ease-in-out 0.2s;
`;

export const LoginIcon = styled(AiOutlineLogin)`
  margin-right: 10px;

  font-size: 30px;
  color: #FFFFFF;

  transition: ease-in-out 0.2s;
`;

export const RegisterContainer = styled.div`
  display: flex;
  flex-direction: row-reverse;
  justify-content: center;
  align-items: center;

  width: 100vw;
  height: 100vh;

  .form-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    width: 1300px;
    height: 100vh;

    .page-title {
      margin-bottom: 100px;

      font-size: 40px;
      color: #33AC91;
      font-weight: bold;
    }

    form {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      .input-container {
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        align-items: center;

        width: 550px;
        height: 60px;

        margin-bottom: 30px;

        background: rgba(153, 154, 154, 0.27);
        border-radius: 50px;

        transition: ease-in-out 0.2s;

        &:focus-within {
          border: 3px solid #33AC91;
          transition: ease-in-out 0.2s;

          padding-left: 10px;

          .password-icon {
            color: #33AC91;
          }

          .email-symbol {
            color: #33AC91;
          }
          
          .user-icon {
            color: #33AC91;
          }
        }

        .input-icon {
          width: 25px;
        }

        .email-symbol {
          margin-bottom: 5px;

          font-size: 30px;
          color: #B2B2B2;
          font-weight: 700;

          transition: ease-in-out 0.2s;
        }

        input {
          width: 85%;
          height: 60px;

          color: #5a5a5a;

          border: none;
          background: transparent;

          ::placeholder {
            font-size: 20px;
            font-weight: bold;
            color: #B2B2B2;
          }
        }
      }
    }

    .log-in {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;

      width: 300px;
      height: 60px;

      margin-top: 100px;

      font-size: 25px;
      font-weight: 600;
      color: #FFFFFF;

      background: #43DBB2;
      border-radius: 50px;
      border: none;

      transition: ease-in-out 0.2s;

      &:hover {
        background: #33AC91;
      }
    }
  }

  .register-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    width: 700px;
    height: 100vh;

    background-image: url(${LoginBG});
    background-size: cover;
    background-repeat: no-repeat;
    background-position-x: -0px;

    img {
      width: 240px;

      margin-top: -120px;
      margin-bottom: 100px;
    }

    .welcome {
      width: 300px;

      margin-bottom: 20px;

      text-align: center;
      font-size: 45px;
      font-weight: bold;
      color: #FFFFFF;
    }

    .welcome-paragraph {
      width: 400px;

      margin-bottom: 100px;

      font-weight: 500;
      text-align: center;
      color: #FFFFFF;
    }

    .register-btn {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;

      width: 300px;
      height: 60px;

      font-size: 25px;
      font-weight: 600;
      color: #FFFFFF;

      background: transparent;
      border-radius: 50px;
      border: 2px solid #FFFFFF;

      transition: ease-in-out 0.2s;

      &:hover {
        background: #FFFFFF;
        color: #33AC91;

        .hover-icon {
          transition: ease-in-out 0.2s;
          color: #33AC91;
        }
      }
    }
  }
`;
