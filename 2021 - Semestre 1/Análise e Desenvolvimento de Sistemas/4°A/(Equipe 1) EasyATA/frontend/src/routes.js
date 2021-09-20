import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';

import Cadastro from './pages/Cadastro';
import Formulario from './pages/Formulario';
import Login from './pages/Login';
import Menu from './pages/Menu';
import Index from './pages/Index';
import Usuarios from './pages/Usuarios';
import Administrador from './pages/Administrador';
import ListaDocumento from './pages/ListaDocumento';
import AprovarDocumento from './pages/AprovarDocumento'
import Revisao from './pages/components/Revisao'
import Assinatura from './pages/components/Assinatura';

export default function Routes(){
    return(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login}></Route>
                <Route path="/cadastro" component={Cadastro}></Route>
                <Route path="/formulario" component={Formulario}></Route>
                <Route path="/menu" component={Menu}></Route>
                <Route path="/index" component={Index}></Route>
                <Route path="/administrador/usuarios" component={Usuarios}></Route>
                <Route path="/administrador" component={Administrador}></Route>
                <Route path="/listaDocumento" component={ListaDocumento}></Route>
                <Route path="/aprovarDocumento" component={AprovarDocumento}></Route>
                <Route path="/revisao" component={Revisao}></Route>
                <Route path="/assinatura" component={Assinatura}></Route>
                
            </Switch>
        </BrowserRouter>
    )
}