import React from 'react';
import { Switch } from 'react-router-dom';

import Route from './components/Route';

import Login from '../pages/Login';
import Register from '../pages/Register';
import Dashboard from '../pages/Dashboard';

const Routes = () => (
  <Switch>
    <Route path="/" exact component={Login} />
    <Route path="/register" exact component={Register} />
    <Route privateRoute path="/dashboard" exact component={Dashboard} />
  </Switch>
);

export default Routes;
