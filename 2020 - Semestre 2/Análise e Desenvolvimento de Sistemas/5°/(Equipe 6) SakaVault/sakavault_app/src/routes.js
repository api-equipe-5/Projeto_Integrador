import React from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';

// Pages import
import Logon from './pages/Logon';
import Register from './pages/Register';
import Profile from './pages/Profile';
import NewSecret from './pages/NewSecret';
import EditSecret from './pages/EditSecret';

import { isAuthenticated } from "./services/auth";

const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route
      {...rest}
      render={props =>
        isAuthenticated() ? (
          <Component {...props} />
        ) : (
          <Redirect to={{ pathname: "/", state: { from: props.location } }} />
        )
      }
    />
);

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path="/" exact component={ Logon }/>
            <Route path="/register" component={ Register }/>
            <PrivateRoute path="/profile" component={ Profile } />
            <PrivateRoute path="/secrets/new" component={ NewSecret } />
            <PrivateRoute path="/secrets/edit/:id?" component={ EditSecret } />
            {/* 404 */}
            <Route path="*" component={() => <h1>Page not found</h1>} />
        </Switch>
    </BrowserRouter>
);

export default Routes;