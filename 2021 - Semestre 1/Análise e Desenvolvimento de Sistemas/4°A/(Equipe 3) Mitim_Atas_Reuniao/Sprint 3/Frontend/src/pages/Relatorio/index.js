import React from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotarelatorio from '../../components/Navbar/rotarelatorio.json';


function Relatorios() {
    return(
        <>
            <Navbar routes={rotarelatorio} />
            <h1>Relatórios</h1>
        </>
    );
}
export default Relatorios;