import React, { Component } from 'react';
import { connect } from 'react-redux';
import Home from './Home';
import AuthForm from './AuthForm';
import { fetchAuthenticated } from '../actions/account';

class Root extends Component {
  render() {
    if(window.location.pathname == '/auth-redirect')
    {
      fetchAuthenticated();
    }
    return (
      this.props.account.loggedIn ? <Home /> : <AuthForm />
    )
  }
};

export default connect(
  ({ account }) => ({ account }),
  null
)(Root);