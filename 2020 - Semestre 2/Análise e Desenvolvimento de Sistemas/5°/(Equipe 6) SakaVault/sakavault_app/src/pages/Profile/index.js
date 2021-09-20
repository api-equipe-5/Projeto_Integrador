import React, { useState, useEffect } from 'react';
import { Link,useHistory, generatePath } from 'react-router-dom';
import { FiPower, FiTrash2, FiAlertTriangle, FiEdit } from 'react-icons/fi';
import { isAuthenticated, logout, getToken } from "services/auth";
import Tooltip from 'react-tooltip-lite';

import api from 'services/api';
import Modal from './modal.js';

import logo from 'assets/logo.svg';

// Styles
import './styles.css'

export default function Profile() {

    const [secrets, setSecrets] = useState([]);
    const [dropdown, setDropdown] = useState("");

    const history = useHistory();

    const showDropdown = () => {
        setDropdown("show");
        document.body.addEventListener("click", closeDropdown);
    }

    const closeDropdown = event => {
        setDropdown("");
        document.body.removeEventListener("click", closeDropdown);
    };

    useEffect( () => {
        if(isAuthenticated()){
            api.get('secrets', {
                headers: {
                    Authorization: 'Bearer ' + getToken(),
                }
            }).then(response => {
                setSecrets(response.data.data);
            })
        }else{
            logout();
            localStorage.clear();
            history.push('/');
        }
    }, [history]);

    async function handleDeleteSecretItem(id) {
        try {
            await api.delete(`secrets/${ id }`, {
                headers: {
                    Authorization: 'Bearer ' + getToken(),
                }
            });

            setSecrets(secrets.filter(secrets => secrets.id !== id));
        } catch (error) {
            alert('Erro ao excluir caso, tente novamente',error);
        }
    }

    function handleLogout() {
        logout();
        localStorage.clear();
        history.push('/');
    }

    return (
        <div className="profile-container">
            <header>
                <img src={ window.location.origin + logo } alt="SakaVault"/>

                <Link className="button" to="/secrets/new">
                    Cadastrar novo segredo
                </Link>

                <Tooltip content="Excluir conta">
                    <button
                        onClick={ showDropdown }>
                        <FiAlertTriangle color="#e02041"></FiAlertTriangle>
                    </button>
                </Tooltip>

                <Tooltip content="Sair">
                    <button onClick={ handleLogout } type="submit"><FiPower size={ 18 } color="#e02041" /></button>
                </Tooltip>
            </header>

            <h1>Segredos cadastrados</h1>

            <ul>
               { secrets.map(secrets => (
                    <li key={ secrets.id }>
                        <strong>Nome</strong>
                        <p>{ secrets.name }</p>
                        <strong>Usuário</strong>
                        <p>{ secrets.username }</p>
                        <strong>Password</strong>
                        <p>{ secrets.password }</p>
                        <strong>Notas</strong>
                        <p>{ secrets.notes }</p>

                        <Link to={ generatePath("secrets/edit/:id?", { id: secrets.id } ) } >
                            <button
                            className="btn-space"
                            type="button">
                                <FiEdit size={20} color="#a8a8b3" />
                            </button>
                        </Link>

                        <button
                        onClick={ () => {
                                if (window.confirm('Are you sure you wish to delete this item?')){
                                    handleDeleteSecretItem(secrets.id)
                                }
                            }
                        }
                        type="button">
                          <FiTrash2 size={20} color="#a8a8b3"/>
                        </button>

                    </li>
               )) }
            </ul>

            <Modal className={ dropdown }/>
        </div>
    );
}
