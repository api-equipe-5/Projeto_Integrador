import React from 'react'
import "../assets/css/style.css"    

import Menu from './Menu';

function Index() {
    var nome = localStorage.getItem('nome').replace(/['"]+/g, '');
    var perfil = localStorage.getItem('perfil').replace(/['"]+/g, '');

    return (
        <div>
            <Menu/>
            <div className="container">
                <h2 style={{margin:'5%'}}>Bem vindo, {nome}!</h2>
            </div>
        </div>
    )
}

export default Index