import styled from 'styled-components';

import { Modal as ModalBoots } from 'react-bootstrap';

import { BsArrowRight } from 'react-icons/bs';

export const ArrowRight = styled(BsArrowRight)`
  margin-top: -2px
`;

export const Modal = styled(ModalBoots)`
  width: 100%;
  height: 100vh;

  .ant-alert-with-description {
    margin-bottom: 40px;
    border-radius: 15px;
    width: 500px;
    align-self: center;

    .ant-alert-close-icon {
      position: absolute;
      top: 16px;
      right: 16px;
      font-size: 14px;
      cursor: pointer;

      background: none;
      display: flex;
      align-items: center;
    }
  }

  .ant-spin-dot-item {
    background-color: white;
  }

  .modal-content {
    width: 800px;
    height: 600px;
     
    background: rgba(47, 145, 132, 0.65);
    box-shadow: 0px 4px 4px rgba(0,0,0,0.25);
    border-radius: 50px;


    .center {
      display: flex;
      flex-direction: column;
      height: 400px;
      overflow: scroll;

      ::-webkit-scrollbar, 
      ::-webkit-scrollbar-track, 
      ::-webkit-scrollbar-thumb {
        display: none;
      }
    }
  }

  .modal-header {
    align-items: center;
    justify-content: center;
    border: none;

    font-family: Quicksand;
    font-style: normal;
    font-weight: bold;
    font-size: 40px;
    line-height: 75px;
    text-align: center;
    color: #FFFFFF;
  }

  .modal-dialog {
    max-width: 100%;
  }

  .modal-footer {
    justify-content: center;
    border: none;
  }

  button {
    padding: 10px 40px;
    border: none;
    border-radius: 50px;

    color: #FFFFFF;
    font-size: 20px;
    font-weight: 600;
    background-color: #43DBB2;
  }

  ul {
    list-style-type: none;
  }
`;
