import React, { useEffect, useState} from 'react';
import { useHistory } from 'react-router-dom';


import api from '../../utils/api';
import "../../index.css";

import Fatec from '../../imagem/fatecsjc2.png';
import Visiona from '../../imagem/visiona.png';
import Github from '../../imagem/github.png';
import logo from '../../imagem/logo.png';

var tabget = ["a", "b", "c"]
function Access() {

  const history = useHistory();
  const [tables, setTables] = useState([]);
  const [tableName, setTableName] = useState('');
  const [shpName, setShpName] = useState('');
  const [columnsDb, setColumnsDb] = useState([]);
  const [columnsShp, setColumnsShp] = useState([]);

  useEffect(()=> {
    api.get('/getTablesDB').then(response => {
        setTables(response?.data?.tablesDB);
    });
  }, []);

  function handleGetTableColumns(table) {
    setTableName(table);
    api.post('/getColumnsDB', { tableName: table}).then(response => (
        setColumnsDb(response?.data?.ColumnsDB)
    ));
  }

  function handleUpload(table) {
    setShpName(table)
    api.post('/getColumns', { shapefile: table}).then(response => (
        setColumnsShp(response?.data?.columns)
    ));
  }

  function handleSend() {
    const data = [];

    alert("Enviando dados ao banco, aguarde...")

    columnsDb?.forEach((column) => {
      const field = document.querySelector(`#${column}`);
      if (field.value !== 'Escolha um campo') {
        data.push(field.value);
      }
    });



    try {
        api.post('/upload', {
            tableName,
            shp_adress: shpName,
            list_columnsDB: columnsDb,
            list_columnsSHP: data,
        }).then(response => console.log(response.data));
    } catch (error) {
        console.log(error)     
    }

    console.log(data)
  }

    async function handleRunGeometricImage() {
      if (!shpName) {
          alert('Envie um arquivo antes');
          return;
      }
      try {
        await api.post('/getGeometric', {
            geom: shpName,
        });
      } catch (error) {
        alert('Não foi possível carregar a imagem');
      }
  }

  return(
    <>
      <header class="menu-principal">
            <main>            
                <div class="header-1">
                    <div class="logo">
                        <ul>
                            <li>
                            <button
                                className='fatec'
                                type="button"
                            >
                                <img src={Fatec} />
                            </button>
                            </li>
                            <li>
                            <button 
                                className='visiona'
                                type="button"
                            >
                                <img src={Visiona}/>
                            </button>
                            </li>
                        </ul>

                    </div>
                    <div class="linkgit">
                    
                    <button
                        type="button" 
                        className='github'
                    >
                        <img src={Github}/>
                    </button>
                    
                    </div>
                </div>

            </main>

        </header>
        
        <div class="entrar">
            
        </div>
        <div class="entrada">
          <div class="seleçao">    
            <ul>
                <li>
                    <fieldset class="arq">
                        <legend class="central">
                            <button
                                type="button" 
                                class="botaosb" 
                                onClick={() => history.push('/download')}
                            >    
                                Download   
                            </button>
                            <span classname="barra">/</span>
                            <button
                                type="button" 
                                class="botaosb"
                            >    
                                Upload    
                            </button>
                        </legend>
                        <form name="form">
                            <input 
                                class="arvo" 
                                type="file" 
                                onChange={e => handleUpload(e.target.value?.split(/(\\|\/)/g).pop())}
                            />
                            <br/>
                            
                            <button
                                type="button" 
                                class="grafico"
                                onClick={handleRunGeometricImage}
                            >
                                Veja o formato geométrico
                            </button>

                            <br/><br/>
                            <legend class="central">Selecione a tabela do banco</legend>
                            <select onChange={(e)=> handleGetTableColumns(e.target.value)} class="nomtab">
                                <option value={null}>
                                    Selecione uma tabela
                                </option>
                                {tables && tables?.map(each => (
                                    <option value={each} key={each}> 
                                        {each} 
                                    </option>
                                ))}
                            </select><br/><br/>
                            <legend class="central">Vizualização de dados</legend>
                            <br/>
                            
                            <img src=""/>
                            <legend></legend>

                            {columnsDb?.length > 0 && (
                                <>
                                    {columnsDb.map(columnDb => (
                                        <div className="divFromTo" key={columnDb}>
                                            <span>
                                                {columnDb}   
                                            </span>

                                            <select id={`${columnDb}`}>
                                                {columnsShp.map(columnsShp => (
                                                    <option key={columnsShp} value={columnsShp}>
                                                        {columnsShp}
                                                    </option>
                                                ))}
                                            </select>
                                        </div>
                                    ))}
                                </>
                            )}
                            <button
                                className='Enviaraqv'
                                type="button"
                                onClick={handleSend}
                            >
                                ENVIAR
                                
                            </button>
                        </form>
                    </fieldset> 
                </li>
            </ul> 

            <section class="render">

            </section>
        </div>
        </div>
        <div className="logono">
            <ul>
                <img src={logo}/>
            </ul>
            <ul>
                <span className="span">
                    <font className="font1">ShapeView</font> 
                    Seu shapefile rápido e fácil
                </span>
            </ul>

        </div>
    </>
  );
}

export default Access;