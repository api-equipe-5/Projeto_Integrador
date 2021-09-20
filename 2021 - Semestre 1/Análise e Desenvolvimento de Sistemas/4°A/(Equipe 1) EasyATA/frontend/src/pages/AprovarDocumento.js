import React, { useState } from 'react'
import "../assets/css/style.css"
import AprovaATA from "./components/AprovaATA"

import Menu from './Menu';

function SituacaoDocumento() {
    return (
        <div>
            <div><Menu/></div>
            <div className="container">
                <div className="card shadow" style={{margin:'5%'}}>
                    <AprovaATA />
                    <br></br>
                    <br></br>
                    <br></br>
                </div>
            </div>
        </div>
        
    )
}

export default SituacaoDocumento