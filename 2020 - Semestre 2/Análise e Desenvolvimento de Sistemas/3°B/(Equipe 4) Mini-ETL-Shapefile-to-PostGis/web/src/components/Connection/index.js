import React, { useContext, useState, useEffect } from 'react';

//API
import api from '../../services/api';
import AppContext from '../../context';

import postStep1 from '../../assets/img/notebook-background.png';

import './styles.css';

const Connection = () => {

  const [local, setLocal] = useState();
  const [portal, setPortal] = useState();
  const [table, setTable] = useState();
  const [user, setUser] = useState();
  const [password, setPassword] = useState();
  const [loading, setLoading] = useState(false);
  const {shapeReturn, setShapeReturn} = useContext(AppContext);

  useEffect(() => {
    console.log('context here: ', shapeReturn);
  }, [shapeReturn]);

//  const url = "/bomdia"; // site that doesn’t send Access-Control-*

//  fetch(url)
//  .then((response) => response.text())
//  .then((data) => console.log('This is your data', data));
//  {

  const bdConnect = () => {
    setLoading(true);
    api({
      method: 'post',
      url: '/tables',
      data: {
        "host": local,
        "porta": portal,
        "bd": table,
        "usuario": user,
        "senha": password
      }
    })
    .then(response => {
        setShapeReturn(response.data);
      }
    )
    .catch(err => {
      console.log('deu ruim bb', err);
    });

  } 
    return (
        <div className="db-container" width="100%">
              <div className="db-container-title" width="100%">
                <h1>CONEXÃO COM O BANCO DE DADOS</h1>
              </div>


          
          <form className="forms-content-label-text-box" width="100%">
        
          <div className="post-step1-button" width="100%">
                  <img src={postStep1} alt="Shape-Button" width="80%"/>
          </div>
          
                  <form className="forms-content-label">
                      <label htmlFor="">Local</label>
                      <label htmlFor="">Porta</label>
                      <label htmlFor="">Banco</label>
                      <label htmlFor="">Usuário</label>
                      <label htmlFor="">Senha</label>

                  </form>

                  <form className="forms-content-text-box">

                    <input type="text" className="txtbox" 
                      onChange={event => setLocal(event.target.value)}
                    />
                    
                    <input type="text" className="txtbox" 
                      onChange={event => setPortal(event.target.value)}
                    />
                    
                    <input type="text" className="txtbox" 
                      onChange={event => setTable(event.target.value)}
                    />

                    <input type="text" className="txtbox" 
                      onChange={event => setUser(event.target.value)}
                    />

                    <input type="password" className="txtbox" 
                      onChange={event => setPassword(event.target.value)}
                    />
                  </form> 

                </form>
                
              <button type="button" onClick={bdConnect}>  
                CONECTAR
              </button>   

      </div>

    )
}


export default Connection;