import React from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';


function CriATA() {
    return(
        <>
            <Navbar routes={rotaata} />
            <h1>Criação de ATAS</h1>
        </>
    );
}
export default CriATA;