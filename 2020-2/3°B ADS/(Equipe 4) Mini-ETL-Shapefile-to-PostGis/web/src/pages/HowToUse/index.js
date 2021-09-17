import React from 'react';
import {Link} from 'react-router-dom';

//Assets
import Background from '../../assets/img/coming-soon.jpg';
import Logo from '../../assets/img/logo.png';
import { FiArrowLeft } from 'react-icons/fi';

import "./styles.css";

const Guide = () => {
    return (
        <div id="main-container">
            <header>
                <Link to="/">
                    <FiArrowLeft />
                    Voltar para página inicial
                </Link>
            </header>
            <div className="spoiler-image">
                <img src={Logo} alt="Logo" />
                <img src={Background} alt="Spoiler-Alert"/>
            </div>
        </div>
    );
}

export default Guide;