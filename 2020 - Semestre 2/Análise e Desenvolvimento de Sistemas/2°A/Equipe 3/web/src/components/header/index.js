import React from 'react';
import { Link,useHistory } from 'react-router-dom';
import './index.css';

function Header(props){

    const hist = useHistory();

    function handleLogout(){
        localStorage.removeItem("token");
        localStorage.removeItem("role");
        localStorage.removeItem("id");
        hist.push("/");
    }

    return(
        <div className="header">
            <h1>{props.text}</h1>
            <div>
                <p>Bem-vindo | <span onClick={handleLogout}>Sair</span></p>
            </div>
        </div>
    );
}

export default Header;