import React from 'react';
import { Link } from 'react-router-dom';

export default function HeaderNoSearch() {

    return (
        <header className='container-headerNosearch'>
            <div className="container-header-content">
                <div className="container-header-content-left">
                    <Link to='/listar'>
                        <img className="jumboLogo" src={require('../assets/jumbo.png')} alt="" />
                        <p className="jumboETL">JumboETL</p>
                    </Link>
                </div>

                <div className="container-header-content-right">
                    <Link to='/' onClick={() => { localStorage.clear() }} >
                        <p className="disconnect-2">Desconectar→</p>
                    </Link>
                </div>
            </div>
        </header>
    );

}   