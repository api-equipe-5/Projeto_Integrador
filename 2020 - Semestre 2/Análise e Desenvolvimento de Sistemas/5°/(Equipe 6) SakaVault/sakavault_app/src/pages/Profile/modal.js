import React from 'react';
import { useHistory } from 'react-router-dom';
import { isAuthenticated, logout, getToken } from "services/auth";
import api from 'services/api';

import './modal.css';

export default function Modal( props ){
    const { className, modalRef } = props;
    const history = useHistory();

    // Delete account
    async function handleDeleteAccount(){
        let confirmDelete = prompt("Para confirmar a exclusão da conta digite o nome do seu usuário: ");

        try {
            const user = await api.get(`/account`, {
                headers: {
                    Authorization: 'Bearer ' + getToken(),
                }
            });

            const userName = user.data.name;

            if(confirmDelete === userName && isAuthenticated()){
                if(confirmDelete != null ){                 
                    await api.delete(`/account`, {
                        headers: {
                            Authorization: 'Bearer ' + getToken(),
                        }
                    });

                    logout();
                    localStorage.clear();
                    history.push('/');
                }
            }
        } catch (error) {
            alert('Erro ao excluir caso, tente novamente',error);
        }
    }
    return (
        <div ref={ modalRef } className={ `${className} modal` }>
            <section className="hidden">
                <span className="close" title="Close Modal">×</span>
                <form className="modal-content">
                    <div className="container">
                        <h1>Remover Conta</h1>
                        <span>
                            <p>Tem certeza que deseja deletar sua conta?</p>
                            <p className="strong">
                            Todos os dados serão perdidos permanentemente sem a possibilidade de recuperação.
                            </p>
                        </span>
                        
                        
                        <div className="btn-space">
                            <button className="button-modal cancelbtn" type="button" >Cancelar</button>
                            <button type="button" className="button-modal deletebtn" onClick={ handleDeleteAccount }>Remover</button>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    );
};
