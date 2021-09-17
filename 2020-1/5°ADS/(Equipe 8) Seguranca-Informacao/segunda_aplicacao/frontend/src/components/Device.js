import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Button } from 'react-bootstrap';
import { fetchDevice } from '../actions/device';
import fetchStates from '../reducers/fetchStates';
import { dev_ico } from '../assets/dev_ico.png';

class Device extends Component {
  state = { macAddress: '', nickname: '' };
  get DeviceView() {
    const { device } = this.props;
    if (device.status === fetchStates.error) {
      return <span>{device.message}</span>;
    }
    else if (device.status === fetchStates.success) {
      window.location.reload(false);
    }

    return <img src={dev_ico} />;
  }

  updateMacAddress = event => {
    this.setState({ macAddress: event.target.value });
  }

  updateNickname = event => {
    this.setState({ nickname: event.target.value });
  }

  new_device = () => {
    const { macAddress, nickname } = this.state;
    this.props.fetchDevice( macAddress, nickname );
  }

  render() {
    return (
      <div>
        Nickname:{' '}
        <input 
          type='text' 
          value={this.state.nickname}
          onChange={this.updateNickname}/>
        <br />
        <br />
        MAC Addr:{' '}
        <input 
          type='text' 
          value={this.state.username}
          onChange={this.updateMacAddress}/>
        <br />
        <br />
        <Button onClick={this.new_device}>Novo dispositivo</Button>
        <br />
        { this.DeviceView }
      </div>
    )
  }
}

export default connect(
  ({ device }) => ({ device }),
  { fetchDevice }
)(Device);