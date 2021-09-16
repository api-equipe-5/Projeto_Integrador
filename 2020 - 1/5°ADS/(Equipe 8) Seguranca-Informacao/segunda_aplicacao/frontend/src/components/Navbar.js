import '../index.css'
import React, { Component, useState, useEffect, useRef } from 'react';
import { DevicesIcon, DataTransferIcon, HomeIcon, LogoutIcon } from '../assets/index'
import { connect } from 'react-redux';
import { logout } from '../actions/account';

class Navbar extends Component {
    logout = () => {
        this.props.logout();
    } 

    render() {
        return (
            <div className="navigation">
                <ul>
                    <li>
                        <a href="#" onClick={() => window.location = '/'}>
                            <HomeIcon></HomeIcon>
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="#" onClick={() => window.location = '/account-devices'}>
                            <DevicesIcon></DevicesIcon>
                            Dispositivos
                        </a>
                    </li>
                    <li>
                        <a href="#" onClick={() => window.location = '/data-portability'}>
                            <DataTransferIcon></DataTransferIcon>
                            Portabilidade
                        </a>
                    </li>
                    <li>
                        <a href="#" onClick={this.logout}>
                            <LogoutIcon></LogoutIcon>
                            Logout
                        </a>
                    </li>
                </ul>
            </div>
        )
    }
}
export default connect(null, { logout })(Navbar);