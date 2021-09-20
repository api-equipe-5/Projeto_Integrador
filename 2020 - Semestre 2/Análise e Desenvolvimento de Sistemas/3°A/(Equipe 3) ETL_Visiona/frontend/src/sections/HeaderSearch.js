import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { useHistory } from 'react-router-dom';

export default function HeaderSearch() {

    const history = useHistory();

    const [searchWord, setSearchWord] = useState('');

    async function loadListarBusca() {
        localStorage.setItem('jumbo/searchWord', searchWord);
        history.push('/ListarBusca');
    }

    return (
        <header className='container-header'>
            <Link to='/listar'>
                <img className="jumboLogo" src={require('../assets/jumbo.png')} alt="" />
                <p className="jumboETL">JumboETL</p>
            </Link>
            <div className='busca-header'>
                <input type="text" className="txtBusca" placeholder="Digite aqui a sua busca" value={searchWord} onChange={e => setSearchWord(e.target.value)} />
                <button className="btnBusca" onClick={loadListarBusca}>Buscar</button>
            </div>
            <Link to='/' onClick={() => { localStorage.clear() }} >
                <p className="disconnect">Desconectar→</p>
            </Link>
        </header>
    );

}   