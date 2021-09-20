import React from  'react';
import {
    BrowserRouter,
    Switch,
    Route 
    } from 'react-router-dom';

import Home from './pages/App/index.jsx';
import Registro from './pages/Registro/index.jsx';
import Acesso from './pages/Acesso/index.jsx';
import Criartabela from './pages/Criartabela/index'
import Upload from './pages/Upload/Index';
import download from './pages/Download/index';
function Routes(){
    return (
        <BrowserRouter>
            <Switch>
                <Route  path="/" exact component= {Home}/>
                <Route  path="/registro" exact component= {Registro}/>
                <Route  path="/principal" exact component= {Acesso}/>
                <Route  path="/tabela" exact component={Criartabela}/>                
                <Route  path="/upload" exact component={Upload}/>
                <Route path="/download" exact component={download}/>
            </Switch>
        </BrowserRouter>
    )
}

export default Routes;