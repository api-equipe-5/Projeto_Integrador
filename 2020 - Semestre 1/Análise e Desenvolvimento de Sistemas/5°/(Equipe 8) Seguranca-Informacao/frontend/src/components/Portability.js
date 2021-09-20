import React, { Component } from 'react';
import Navbar from './Navbar';
import { connect } from 'react-redux';
import { fetchAccountInfo } from '../actions/accountInfo';
import { fetchDataPortability } from '../actions/account';
import { Button } from 'react-bootstrap';
import { BACKEND, SECOND_APP } from '../config';

class Portability extends Component {
    state = { portabilityState: false };

    get PortabilityView() {
        const { portabilityState } = this.state;
        if (portabilityState === true) {
            return <span>Dados recebidos com sucesso!</span>;
        }
    }
    componentDidMount() {
        this.props.fetchAccountInfo();
    }

    requestDataPort = () => {
        fetch(`${BACKEND.ADDRESS}/account/requestPortData`, {
            method: 'POST',
            body: JSON.stringify({ appURL: `${SECOND_APP.ADDRESS}`, id: this.props.accountInfo.userId}),
            headers: { 'Content-Type': 'application/json' },
            credentials: 'include'
          }).then(response => response.json())
            .then(json => {
              if (json.type === 'error') {
                alert(json.message);
              } else {
                this.setState({ portabilityState: true });
              }
            })
            .catch(error => alert(error.message));
    }

    render() {
        return (
            <div>
                <Navbar></Navbar>
                <br />
                <br />
                <hr />
                <h2>LGPD</h2>
                <Button onClick={this.requestDataPort}>Requisitar portabilidade</Button>
                <br />
                <br />
                { this.PortabilityView }               
            </div>
        );
    }
}


export default connect(
    ({ accountInfo }) => ({ accountInfo }),
    { fetchAccountInfo, fetchDataPortability }
  )(Portability);