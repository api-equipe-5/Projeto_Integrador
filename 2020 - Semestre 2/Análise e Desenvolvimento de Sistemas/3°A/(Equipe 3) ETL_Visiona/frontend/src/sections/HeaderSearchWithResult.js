import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

export default function HeaderSearchWithResult() {

    var [searchWord, setSearchWord] = useState('');

    async function loadListarBusca() {
        localStorage.setItem('jumbo/searchWord', searchWord);
        window.location.reload();
    }

    useEffect(() => {
        setSearchWord(localStorage.getItem('jumbo/searchWord'));
    }, []);

    return (
        <header className='container-header'>
            <Link to='/listar'>
                <img className="jumboLogo" src={require('../assets/jumbo.png')} alt="" />
                <p className="jumboETL">JumboETL</p>
            </Link>
            <div className='busca-header'>
                <input
                    value={searchWord}
                    type="text"
                    className="txtBusca"
                    onChange={e => setSearchWord(e.target.value)}
                />
                <button className="btnBusca" onClick={loadListarBusca}>Buscar</button>
            </div>
            <Link to='/' onClick={() => { localStorage.clear() }} >
                <p className="disconnect">Desconectar→</p>
            </Link>
        </header>
    );

}   