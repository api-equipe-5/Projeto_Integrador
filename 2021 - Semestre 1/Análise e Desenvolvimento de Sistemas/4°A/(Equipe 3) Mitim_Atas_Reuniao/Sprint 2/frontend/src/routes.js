import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Login from './pages/Login/index';
import Home from './pages/Home/index';
import CadUsuario from './pages/Usuario/index';
import CriATA from './pages/Ata/index';
import Relatorios from './pages/Relatorio/index';
import SolAcesso from './pages/Login/acesso';
import EditUsuario from './pages/Usuario/usuedit';



const Routes = () => (
    <BrowserRouter>
        <Switch>
           
            <Route path={["/login","/"]} exact={true} component={Login} />
            <Route path="/home" component={Home} />
            <Route path="/cadusuario" component={CadUsuario} />
            <Route path="/criata" component={CriATA} />
            <Route path="/atasger" component={Relatorios} />
            <Route path="/solacesso" component={SolAcesso} />
            <Route path="/editusuario" component={EditUsuario} />
            

            
        </Switch>
    </BrowserRouter>
);

export default Routes;