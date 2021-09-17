import React, { Component } from 'react';
import Navbar from './Navbar';
import AccountInfo from './AccountInfo';

class Home extends Component {
  render() {
    return (
      <div>
        <Navbar></Navbar>
        <br />
        <br />
        <hr />
        <h2>LGPD - Segunda Aplicação</h2>
        <AccountInfo />
      </div>
    );
  }
}

export default Home;