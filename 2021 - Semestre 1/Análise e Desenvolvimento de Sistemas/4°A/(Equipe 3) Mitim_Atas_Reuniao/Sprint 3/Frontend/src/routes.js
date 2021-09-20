import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Login from './pages/Login/index';
import Home from './pages/Home/index';
import CadUsuario from './pages/Usuario/index';
import CriATA from './pages/Ata/index';
import Relatorios from './pages/Relatorio/index';
import SolAcesso from './pages/Login/acesso';
import EditUsuario from './pages/Usuario/usuedit';
import RedSenha from './pages/Login/redsenha';
import RedSenhaFinal from './pages/Login/redsenhafinal';
import ImprimirAta from './pages/Ata/imprimir';
import MonitorarAta from './pages/Ata/monitorar';
import Revisoes from './pages/Ata/revisoes';
import Aprovacao from './pages/Ata/aprovacao';
import RevisarAta from './pages/Ata/revisar';
import AprovarAta from './pages/Ata/aprovar';



const Routes = () => (
    <BrowserRouter>
        <Switch>
           
            <Route path={["/login","/"]} exact={true} component={Login} />
            <Route path="/home" component={Home} />
            <Route path="/aprusuario" component={CadUsuario} />
            <Route path="/criata" component={CriATA} />
            <Route path="/atasger" component={Relatorios} />
            <Route path="/solacesso" component={SolAcesso} />
            <Route path="/editusuario" component={EditUsuario} />
            <Route path="/redsenha" component={RedSenha} />
            <Route path="/redsenhafinal" component={RedSenhaFinal} />
            <Route path="/impata" component={ImprimirAta} />
            <Route path="/monata" component={MonitorarAta} />
            <Route path="/revisoes" component={Revisoes} />
            <Route path="/aprata" component={Aprovacao} />
            <Route path="/revata" component={RevisarAta} />
            <Route path="/aprovar" component={AprovarAta} />
            
        </Switch>
    </BrowserRouter>
);

export default Routes;