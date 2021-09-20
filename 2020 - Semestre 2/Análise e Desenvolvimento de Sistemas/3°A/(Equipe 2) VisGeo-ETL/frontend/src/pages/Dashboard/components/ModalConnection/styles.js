import styled from 'styled-components';

import { Modal as ModalBoots } from 'react-bootstrap';

import { FaUserAlt } from 'react-icons/fa';
import { IoIosLock, IoIosCloseCircleOutline } from 'react-icons/io';
import { RiLoginBoxFill } from 'react-icons/ri';
import { GoDatabase } from 'react-icons/go';
import { WiCloudyWindy } from 'react-icons/wi';

export const HostIcon = styled(WiCloudyWindy)`
  font-size: 100px;
  color: white;

  transition: ease-in-out 0.2s;
`;

export const CloseIcon = styled(IoIosCloseCircleOutline)`
  cursor: pointer;
  position: absolute;
  right: 20px;
  font-size: 30px;
  color: #FFF;
`;

export const Modal = styled(ModalBoots)`

  .ant-alert-with-description {
    margin-bottom: 40px;
    border-radius: 15px;
  }

  .modal-content {
    width: 800px;
    height: 600px;

    display: flex;
    align-items: center;
    justify-content: center;

    background: rgba(47, 145, 132, 0.65);
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 50px;

    h1 {
      font-family: Quicksand;
      font-weight: bold;
      font-size: 35px;
      line-height: 75px;
      text-align: center;

      color: #FFFFFF;
    }  
    
    .modal-header {
      width: 100%;
      border: none;
      position: absolute;
      top: 0;
      display: flex;
      justify-content: center;
    }

    .modal-footer {
      position: absolute;
      bottom: 20px;
      border: none;
    }

    button.close {
      margin: 0px;
      width: 20px;
      height: 20px;
      position: absolute;
      right: 20px;
      top: 35px;
    }
  }

  .cred-info-container {
    display: flex;
    flex-direction: column;
    justify-items: center;
    align-self: center;

    /* width: 100%; */
    height: max-content;

    padding-right: 250px;
    padding-left: 250px;

    section {
      width: 600px;
      display: grid;
      grid-template-columns: repeat(2, 1fr);
    }

    section + section {
      margin: 40px 0px;
      display: grid;
      grid-template-columns: repeat(3, 1fr);
    }

    .cred-meta-info {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;

      font-size: 20px;
      font-weight: 600;
      color: #FFFFFF;

      .white-icon {
        font-size: 30px;
        color: white;
      }

      .host-icon {
        width: 22px;
        margin-right: 5px;
      }
    }

    .cred-input-info {
      width: 90%;
      height: 45px;

      margin-top: 5px;
      margin-left: 15px;
      padding-left: 15px;

      font-size: 15px;

      border-radius: 50px;
      border: 3px solid #FFFFFF;
      background: #FFFFFF;

      transition: ease-in-out 0.2s;

      &:focus-within {
        border: 3px solid #33AC91;
      }
    }
  }

  .handle-button {
    width: 200px;
    height: 45px;

    margin-top: 50px;

    color: #FFFFFF;
    font-size: 20px;
    font-weight: 600;

    background-color: #43DBB2;
    border: none;
    border-radius: 50px;

    transition: ease-in-out 0.2s;

    &:hover {
      background-color: #33AC91;
    }
  }
`;

export const UserIcon = styled(FaUserAlt)`
  margin-right: 5px;

  font-size: 20px;
  color: #B2B2B2;
`;

export const DatabaseIcon = styled(GoDatabase)`
  margin-right: 5px;

  font-size: 22px;
  color: #B2B2B2;
`;

export const PortIcon = styled(RiLoginBoxFill)`
  margin-right: 5px;

  font-size: 22px;
  color: #B2B2B2;
`;

export const Lock = styled(IoIosLock)`
  margin-right: 5px;

  font-size: 25px;
  color: #B2B2B2;
`;
