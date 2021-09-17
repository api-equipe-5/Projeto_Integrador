import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchAccountDevices } from '../actions/accountDevices';
import AccountDeviceRow from './AccountDeviceRow';
import Device from './Device';
import Navbar from './Navbar';

class AccountDevices extends Component {
  componentDidMount() {
    this.props.fetchAccountDevices();
  }

  render() {
    return (
      <div>
        <Navbar></Navbar>
        <br />
        <br />
        <hr />
        <Device />
        <hr />
        <h3>Dispositivos na conta</h3>
        {
          this.props.accountDevices.devices.map(device => {
            return (
              <div key={device.id}>
                <AccountDeviceRow device={device} />
                <hr />
              </div>
            )
          })
        }
      </div>
    );
  }
}

export default connect(
  ({ accountDevices }) => ({ accountDevices }),
  { fetchAccountDevices }
)(AccountDevices);