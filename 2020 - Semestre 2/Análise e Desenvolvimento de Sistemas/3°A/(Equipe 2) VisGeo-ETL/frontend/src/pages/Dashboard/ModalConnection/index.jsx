import React, { useState } from 'react';

import { Alert } from 'antd';

import api from '../../../services/api';

import {
  UserIcon, Lock, PortIcon, DatabaseIcon,
  Modal, HostIcon, CloseIcon,
} from './styles';

const ModalConnection = ({ open, close }) => {
  const [error, setError] = useState(false);
  const [errorMessage, setErrorMessage] = useState(false);

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [host, setHost] = useState('');
  const [port, setPort] = useState('');
  const [database, setDatabase] = useState('');

  async function handleConnect() {
    const data = {
      username,
      password,
      host,
      port,
      database,
    };

    if (username && password && host && port && database) {
      try {
        const response = await api.post('/auth', data);
        const { isConnected } = response?.data;

        if (isConnected) close(true);
      } catch (err) {
        setError(true);
        setErrorMessage('Ocorreu um erro ao tentar se conectar com o servidor');
      }
      return;
    }

    setError(true);
    setErrorMessage('Campos não podem estar nulos');
  }

  const handleClose = () => {
    close(true);
  };

  return (
    <Modal show={!open}>
      <Modal.Header>
        <h1>ACESSE O BANCO DE DADOS DESEJADO</h1>
        <CloseIcon onClick={handleClose} />
      </Modal.Header>

      {error && (
        <Alert
          message="Erro"
          description={errorMessage}
          type="error"
          closable
          showIcon
          onClose={() => setError(false)}
        />
      )}

      <div className="cred-info-container">
        <section>
          <span className="cred-meta-info">
            <UserIcon className="white-icon" />
            Username
          </span>

          <span className="cred-meta-info">
            <Lock className="white-icon" />
            Senha
          </span>

          <input onChange={(e) => setUsername(e.target.value)} type="text" className="cred-input-info" />

          <input onChange={(e) => setPassword(e.target.value)} type="password" className="cred-input-info" />
        </section>

        <section>
          <span className="cred-meta-info">
            <HostIcon className="white-icon" />
            Host
          </span>

          <span className="cred-meta-info">
            <PortIcon className="white-icon" />
            Port
          </span>

          <span className="cred-meta-info">
            <DatabaseIcon className="white-icon" />
            Database
          </span>

          <input onChange={(e) => setHost(e.target.value)} type="text" className="cred-input-info" />

          <input onChange={(e) => setPort(e.target.value)} type="text" className="cred-input-info" />

          <input onChange={(e) => setDatabase(e.target.value)} type="text" className="cred-input-info" />
        </section>
      </div>

      <Modal.Footer>
        <button
          type="button"
          onClick={handleConnect}
          className="handle-button"
        >
          Conectar
        </button>
      </Modal.Footer>
    </Modal>
  );
};
export default ModalConnection;
