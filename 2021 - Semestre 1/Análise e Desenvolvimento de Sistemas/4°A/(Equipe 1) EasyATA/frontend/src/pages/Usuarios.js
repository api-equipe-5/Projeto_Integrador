import React from 'react'
import "../assets/css/style.css"

import UserComponent from './components/UserComponent.js';

import Menu from './Menu';  


function Usuarios(){
    return(
        <div>
            <div><Menu/></div>
            <div className="container">
                <div className="card shadow" style={{margin:'5%'}}>
                    <UserComponent/>
                </div>
            </div>
        </div>
    )

}
export default Usuarios
