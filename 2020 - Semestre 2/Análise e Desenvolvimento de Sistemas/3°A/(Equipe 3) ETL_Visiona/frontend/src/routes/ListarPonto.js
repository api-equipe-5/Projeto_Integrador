import React, { useState, Fragment, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import '../styles/style.css';
import HeaderSearch from '../sections/HeaderSearch';
import api from '../services/api';

export default function Listar() {

  const [tables, setTables] = useState([]);

  const history = useHistory();

  const user = localStorage.getItem('jumbo/user');
  const password = localStorage.getItem('jumbo/password');
  const host = localStorage.getItem('jumbo/host');
  const port = localStorage.getItem('jumbo/port');
  const database = localStorage.getItem('jumbo/database');

  const dados = {
    user,
    password,
    host,
    port,
    database
  };

  async function loadInsert(table) {
    localStorage.setItem('jumbo/table', table);
    history.push("/inserir");
  }

  async function loadExtract(table) {
    localStorage.setItem('jumbo/table', table);
    history.push("/extrair");
  }

  async function loadTableType(e) {
    history.push(`/${e.target.value}`);
  }

  async function loadViewer(table) {
    localStorage.setItem('jumbo/table', table);
    history.push("/visualizar")
  };

  useEffect(() => {
    api.post('get_multipolygon_tables', dados).then(response => {
      setTables(response.data.tables)
    });
  }, []);

  return (
    <div className='container-list'>
      <Fragment>
        <HeaderSearch />
        <div className='container-list-content'>
          <div className='container-list-header'>
            <table>
              <tbody>
                <tr>
                  <td className="list-tables">Tabelas</td>
                  <td className="list-filter">Filtrar por:</td>
                  <td className="list-dropbox">
                    <div className="select-wrapper2">
                      <select onChange={e => loadTableType(e)}>
                        <option value="listarponto"> Ponto </option>
                        <option value="listar"> Todos </option>
                        <option value="listarlinha"> Linha </option>
                        <option value="listarpoligono"> Polígono </option>
                      </select>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div className='container-list-table'>
            <table>
              <tbody>
                {tables.map(table => (
                  <tr key={table}>
                    <td className='list-icon'><div onClick={() => loadViewer(table)} className="multipoint"></div></td>
                    <td className='list-text'>{table}</td>
                    <td className='list-button'><button type='submit' onClick={() => loadInsert(table)}>Inserir</button></td>
                    <td className='list-button'> <button type='submit' onClick={() => loadExtract(table)}>Extrair</button></td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </Fragment>
    </div>
  );
}