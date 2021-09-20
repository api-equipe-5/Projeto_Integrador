import React from 'react'
import "../assets/css/style.css"
import ListaATA from './components/ListaATA';   

import Menu from './Menu';

function ListaDocumento() {
    return (
        <div>
            <div><Menu/></div>
            <div className="container">
                <div className="card shadow" style={{margin:'5%'}}>
                    <ListaATA />
                </div>
            </div>
        </div>
        
    )
}

export default ListaDocumento