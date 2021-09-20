import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import { BACKEND } from '../config';
import {dev_ico } from '../assets';

class AccountDeviceRow extends Component {
  state = {
    macAddress: this.props.device.macAddress,
    nickname: this.props.device.nickname,
    status: this.props.device.status,
    edit: false
  };


  updateNickname = event => {
    this.setState({ nickname: event.target.value });
  }

  updateMacValue = event => {
    this.setState({ macAddress: event.target.value });
  }

  toggleEdit = () => {
    this.setState({ edit: !this.state.edit });
  }

  save = () => {
    fetch(`${BACKEND.ADDRESS}/device/update`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        deviceId: this.props.device.id,
        macAddress: this.state.macAddress,
        nickname: this.state.nickname,
        status: this.state.status
      })
    }).then(response => response.json())
      .then(json => {
        if (json.type === 'error') {
          alert(json.message);
        } else {
          this.toggleEdit();
        }
      })
      .catch(error => alert(error.message));
  }

  delete = () => {
    fetch(`${BACKEND.ADDRESS}/device/delete`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        deviceId: this.props.device.id
      })
    }).then(response => response.json())
      .then(json => {
        if (json.type === 'error') {
          alert(json.message);
        } else {
          window.location.reload(false);
        }
      })
      .catch(error => alert(error.message));
  }

  get SaveButton() {
    return <Button onClick={this.save}>Save</Button>;
  }

  get EditButton() {
    return <Button onClick={this.toggleEdit}>Edit</Button>;
  }

  render() {
    return (
      <div>
        <img src={dev_ico} />
        <br />
        <br />
        Nickname:{' '}
        <input
          type='text'
          value={this.state.nickname}
          onChange={this.updateNickname}
          disabled={!this.state.edit}
        />
        <br />
        <div>
          <span>
            MAC Addr:{' '}
            <input
              type='text'
              disabled={!this.state.edit}
              value={this.state.macAddress}
              onChange={this.updateMacValue}
            />
          </span>
          <br />
          <br />
          {
            this.state.edit ? this.SaveButton : this.EditButton
          }
          {' '}
          <a href="#" onClick={this.delete}>Delete</a>
        </div>
      </div>
    )
  }
}

export default AccountDeviceRow;