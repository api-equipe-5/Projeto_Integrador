import React, { useState } from 'react';
import { message, Spin } from 'antd';

import api from '../../../../services/api';
import { Container } from './styles';

const DownloadTables = ({ tables }) => {
  const [tableName, setTableName] = useState('');
  const { info, error } = message;

  const [loading, setLoading] = useState(false);

  const handleSelectTable = (table) => {
    setTableName(table);
    info(table);
  };

  async function handleDownload() {
    setLoading(true);
    try {
      const response = await api.post('/recoverFile/', {
        selectedTable: tableName,
        token: localStorage.getItem('token')
      });

      if (response.status === 201) {
        window.location.href = `http://localhost:5000/downloadFile/${tableName}`;
      }

      info(`Baixando table ${tableName}`);
    } catch (err) {
      error('Algo deu errado');
    }
    setLoading(false);
  }

  return (
    <Container>
      <h1>
        TABELAS DISPONÍVEIS
      </h1>
      {loading && <Spin size="large" />}
      <section>
        <ul>
          {tables.map((table) => (
            <li onClick={() => handleSelectTable(table)} key={table}>
              {table}
            </li>
          ))}
        </ul>
      </section>

      <button type="button" onClick={handleDownload}>
        BAIXAR
        {' '}
        <br />
        {' '}
        SHAPEFILE
      </button>
    </Container>
  );
};

export default DownloadTables;
