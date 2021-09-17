import React from "react";
import {Link} from 'react-router-dom';

import "./styles.css";

import Logo from '../../assets/img/logo.png'


function Header () {
    return (
        <div className="header-container">
            <Link to="/" className="logo-container">
              <img src={Logo} alt="Logo" />
            </Link>
            <div className="buttons-container">
              <Link to="/" className="converter">CONVERSOR</Link>
              <Link to="/how-to-use" className="use-guide">COMO USAR</Link>
            </div>
        </div>
    )
}

export default Header;