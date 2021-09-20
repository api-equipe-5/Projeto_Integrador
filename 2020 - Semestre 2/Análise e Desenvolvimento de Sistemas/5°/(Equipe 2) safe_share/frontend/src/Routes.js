import React from 'react';

import { Route, Switch } from 'react-router-dom';

import Clientes from './pages/Clientes/index';
import Log from './pages/Log/index';
import MeusDados from './pages/MeusDados/index';
import SolicitarDados from './pages/SolicitarDados/index';

export default function Routes() {

    return (
        <Switch>
            <Route exact path='/clientes' component={Clientes} />
            <Route exact path='/log' component={Log} />
            <Route exact path="/meus-dados" component={MeusDados} />
            <Route exact path="/solicitar-dados" component={SolicitarDados} />
        </Switch>
    )
}