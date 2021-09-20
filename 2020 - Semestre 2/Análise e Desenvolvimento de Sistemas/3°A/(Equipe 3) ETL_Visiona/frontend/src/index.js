import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Login from './routes/Login';
import Listar from './routes/Listar';
import ListarBusca from './routes/ListarBusca';
import ListarPonto from './routes/ListarPonto';
import ListarLinha from './routes/ListarLinha';
import ListarPoligono from './routes/ListarPoligono';
import Inserir from './routes/Inserir';
import Extrair from './routes/Extrair';
import Visualizar from './routes/Visualizar';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Login} />
        <Route path='/listar' component={Listar} />
        <Route path='/listarbusca' component={ListarBusca} />
        <Route path='/listarponto' component={ListarPonto} />
        <Route path='/listarlinha' component={ListarLinha} />
        <Route path='/listarpoligono' component={ListarPoligono} />
        <Route path='/inserir' component={Inserir} />
        <Route path='/extrair' component={Extrair} />
        <Route path='/visualizar' component={Visualizar} />
      </Switch>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);


