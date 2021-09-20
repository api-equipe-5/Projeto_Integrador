import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';

import "../../index.css";
import api from '../../utils/api';

import Fatec from '../../imagem/fatecsjc2.png';
import Visiona from '../../imagem/visiona.png';
import Github from '../../imagem/github.png';
import logo from '../../imagem/logo.png';

function Access() {

  const history = useHistory();
  const [latestsConnections, setLatestsConnections] = useState([]);
  const [selectedDatabase, setSelectedDatabase] = useState({});

  useEffect(() => {
    const storagedConnections = JSON.parse(localStorage.getItem('latests_connections'));

    setLatestsConnections(storagedConnections);
  }, []);

  // useEffect é uma função que vai disparar cada vez que a variaval que estiver 
  // No array de dependências [] for atualizada
  // Quando estiver vazio a função será disparada somente uma vez quando
  // Todos os componentes renderizarem em tela

  async function handleConnectDirectly() {
    if (!selectedDatabase || selectedDatabase?.length < 1) {
      alert('Nenhuma database selecionada');
      return;
    }

    try {
      await api.post('/con', selectedDatabase[0]);
      alert("Conectado com sucesso !");

      history.push('/download'); 
    } catch (error) {
      alert("Falha ao conectar com o banco de dados !");
    }        
  }

  function handleChangeConnection(e) {
    const [user, database] = e?.target?.value?.split('|');

    setSelectedDatabase(latestsConnections?.filter(connection => 
      connection.user === user && 
      connection.database === database)
    );      
  }

  return(
    <>
      <header class="menu-principal">
            <main>            
                <div class="header-1">
                    <div class="logo">
                        <ul>
                            <li>
                            <button className='fatec'>
                                <img src={Fatec} />
                            </button>
                            </li>
                            <li>
                            <button className='visiona'>
                                <img src={Visiona}/>
                            </button>
                            </li>
                        </ul>

                    </div>
                    <div class="linkgit">
                    
                    <button className='github'>
                        <img src={Github}/>
                    </button>
                    
                    </div>
                </div>

            </main>

        </header>
        
        <div class="entrar">
        </div>
        <div class="entrada">
            <h1> Bem-Vindo </h1>
            <h3>Selecione um Banco de Dados</h3>
            <select 
                className="nomtab"
                onChange={handleChangeConnection}
            >
                <option>
                    Selecionar conexão
                </option>

                {(latestsConnections && latestsConnections.length > 0)
                    ? latestsConnections.map(connection => (
                        <option
                            key={connection.user}
                            value={`${connection.user}|${connection.database}`}
                        >
                            {connection.database}
                        </option>
                    )) 
                    : (
                        <option>
                            Nenhuma conexão salva previamente
                        </option>
                    )
                }
            </select>
            <br/>
            <br/>
            <button className="criartabela"
            onClick={() => history.push('/tabela')}
            >
              Criar uma conexão
          </button>
          <a></a>

          <button 
            className="criartabela"
            onClick={handleConnectDirectly}          
          >
              Confirmar
          </button>
          

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