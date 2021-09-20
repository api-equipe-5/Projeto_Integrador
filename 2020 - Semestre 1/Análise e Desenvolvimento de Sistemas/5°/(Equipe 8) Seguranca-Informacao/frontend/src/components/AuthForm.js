import React, { Component } from 'react';
import { connect } from 'react-redux';
import { login } from '../actions/account';
import fetchStates from '../reducers/fetchStates';
import { GoogleIcon } from '../assets/index';

class AuthForm extends Component {
  state = { buttonClicked: false };

  login = () => {
    this.setState({ buttonClicked: true });
    this.props.login();
  }

  get Error() {
    if (
      this.state.buttonClicked &&
      this.props.account.status === fetchStates.error
    ) {
      return <div>{this.props.account.message}</div>
    }
  }

  render() {
    return (
      <div>
        <div id="auth-form">
          <h2>LGPD</h2>
          <a className="login" href="#" onClick={this.login}>
            <GoogleIcon />
            Log In
          </a>
        </div>
        <br />
        {this.Error}
      </div>
    );
  }
}

export default connect(
  ({ account }) => ({ account }),
  { login }
)(AuthForm);