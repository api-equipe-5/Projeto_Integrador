import React, { useState } from 'react';

import { Menu, Dropdown, message } from 'antd';
// eslint-disable-next-line import/no-extraneous-dependencies
import { DownOutlined } from '@ant-design/icons';
import api from '../../../../services/api';

import { Container, ArrowRight, Button } from './styles';

import ModalTables from '../ModalTables';

const Fields = ({ fields, tables }) => {
  const fieldsDebug = ['Campo 1', 'Campo 2', 'Campo 3', 'Campo 4', 'Campo 5', 'Campo 6'];
  const tablesDebug = ['Tabela 1', 'Tabela 2', 'Tabela 3', 'Tabela 4', 'Tabela 5', 'Tabela 6'];

  const [columns, setColumns] = useState([]);
  const [saveLoading, setSaveLoading] = useState(false);
  const [selectedTable, setSelectedTable] = useState('');
  const [openModal, setOpenModal] = useState(false);

  const handleOpenModal = () => {
    setOpenModal(true);
  };

  async function handleSaveDirectly () {
    setSaveLoading(true);
    const filename = localStorage.getItem('filename');

    try {
      await api.post('/saveDirectly', {
        filename,
        token: localStorage.getItem('token')
      });
      message.success('Salvo com sucesso');
    } catch (error) {
      message.error('Falha ao salvar arquivo no banco de dados');
    }
    
    setSaveLoading(false);
  };

  async function handleGetColumns(table) {
    setSelectedTable(table);

    const response = await api.post(`/columns/${table}`, {token: localStorage.getItem('token')});
    setColumns(response.data);
    message.info(`Tabela ${table} selecionada`);
  }

  const menu = (
    <Menu>
      {localStorage.getItem('MODE') === 'production'
        ? tables.map((table) => (
          <Menu.Item
            onClick={() => handleGetColumns(table)}
            key={table}
          >
            {table}
          </Menu.Item>
        ))
        : tablesDebug.map((table) => (
          <Menu.Item
            onClick={() => handleGetColumns(table)}
            key={table}
          >
            {table}
          </Menu.Item>
        ))}
    </Menu>
  );

  return (
    <Container>
      <ModalTables
        selectedTable={selectedTable}
        fields={fields}
        show={openModal}
        columns={columns}
        setShow={setOpenModal}
      />

      <div className="fields-search-container">
        <section>
          <h1>CAMPOS DISPONÍVEIS</h1>
          <div className="fields-container">
            {localStorage.getItem('MODE') === 'production'
              ? fields.map((eachField) => (
                <span className="fields">
                  {eachField}
                </span>
              )) : fieldsDebug.map((eachField) => (
                <span className="fields">
                  {eachField}
                </span>
              ))}
          </div>
        </section>

        <section>
          <div className="fields-container">

            <Dropdown overlay={menu} trigger={['click']}>
              <a className="ant-dropdown-link" href onClick={(e) => e.preventDefault()}>
                {selectedTable || "SELECIONE UMA TABELA"}
                {' '}
                <DownOutlined className="down-arrow-menu" />
              </a>
            </Dropdown>

            <button type="button" onClick={handleOpenModal} className="handle-button">
              Configurar de
              {' '}
              <ArrowRight />
              {' '}
              para

            </button>
          </div>
        </section>
      </div>

      <Button 
        className="saveDirectly"
        type="button"
        loading={saveLoading}
        onClick={handleSaveDirectly}
        title="Criar e salvar o shapefile inteiro em uma nova tabela"
      >
        {saveLoading ? "Enviando arquivos" : "Salvar diretamente"}
      </Button>
    </Container>
  );
};

export default Fields;
