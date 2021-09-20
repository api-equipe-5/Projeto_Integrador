import React, { useState } from 'react';
import { Spin, Alert } from 'antd';

import api from '../../../../services/api';

import RenderColumnsAndFields from './components/RenderColumnsAndFields';

import { Modal, ArrowRight } from './styles';

const ModalTable = ({
  show, 
  setShow, 
  fields, 
  columns,
  selectedTable,
}) => {
  /* CODIGO PARA DEBUG */
  const mode = localStorage.getItem('MODE');
  const filename = localStorage.getItem('filename');

  const columnsDebug = ['Coluna 1', 'Coluna 2', 'Coluna 3', 'Coluna 4', 'Coluna 5', 'Coluna 6'];
  const fieldsDebug = ['Campo 1', 'Campo 2', 'Campo 3', 'Campo 4', 'Campo 5', 'Campo 6'];

  /* CODIGO PARA DEBUG */

  const [success, setSuccess] = useState(false);
  const [error, setError] = useState(false);
  const [message, setMessage] = useState('');
  const [spin, setSpin] = useState(false);

  async function handleSend() {
    const data = [];
    setSpin(true);

    columns.forEach((column) => {
      const field = document.querySelector(`#${column}`);
      if (field.value !== 'Escolha um campo') {
        data.push(field.value);
      }
    });

    try {
      const response = await api.post('/save', { 
        message: data, 
        filename: filename,
        tableName: selectedTable,
        token: localStorage.getItem('token')
      });
      setMessage(response?.data?.message);

      setSuccess(true);
    } catch (a) {
      setError(true);
    }

    setSpin(false);
  }

  return (
    <>
      <Modal show={show} onHide={() => setShow(false)}>
        <Modal.Header>
          CONFIGURAÇÃO DE
          {' '}
          <ArrowRight />
          {' '}
          PARA
        </Modal.Header>
        <section className="center">
          {spin && <Spin size="large" />}

          {error && (
            <Alert
              message="Erro"
              description="Falha ao comunicar com o servidor"
              type="error"
              closable
              showIcon
              onClose={() => setError(false)}
            />
          )}

          {success && (
            <Alert
              message="Sucesso"
              description={message || 'Arquivos enviados com sucesso'}
              type="success"
              closable
              showIcon
              onClose={() => setSuccess(false)}
            />
          )}

          {mode === 'production'
            ? <RenderColumnsAndFields columns={columns} fields={fields} />
            : <RenderColumnsAndFields columns={columnsDebug} fields={fieldsDebug} />}

        </section>
        <Modal.Footer>
          <button type="button" onClick={handleSend}>Enviar campos</button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default ModalTable;
