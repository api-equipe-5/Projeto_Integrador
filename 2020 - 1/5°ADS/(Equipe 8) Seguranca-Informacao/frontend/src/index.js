import React from 'react';
import { createStore, applyMiddleware, compose } from 'redux';
import { Provider } from 'react-redux';
import { Router, Switch, Route, Redirect } from 'react-router-dom';
import { render } from 'react-dom';
import thunk from 'redux-thunk';
import rootReducer from './reducers';
import history from './history';
import Root from './components/Root';
import AccountDevices from './components/AccountDevices';
import { fetchAuthenticated } from './actions/account';
import Portability from './components/Portability'
import './index.css';

const enhancers = [
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
  applyMiddleware(thunk)
]
const store = createStore(
  rootReducer,
  applyMiddleware(thunk)
);

const AuthRoute = props => {
  if (!store.getState().account.loggedIn) {
    return <Redirect to={{ pathname: '/' }} />
  }

  const { component, path } = props;

  return <Route path={path} component={component} />;
}

store.dispatch(fetchAuthenticated())
  .then(() => {
    render(
      <Provider store={store}>
        <Router history={history}>
          <Switch>
            <Route exact path='/' component={Root} />
            <Route exact path='/auth-redirect' component={Root}/>
            <AuthRoute path='/account-devices' component={AccountDevices} />
            <AuthRoute path='/data-portability' component={Portability} />
          </Switch>
        </Router>
      </Provider>,
      document.getElementById('root')
    );
  });
