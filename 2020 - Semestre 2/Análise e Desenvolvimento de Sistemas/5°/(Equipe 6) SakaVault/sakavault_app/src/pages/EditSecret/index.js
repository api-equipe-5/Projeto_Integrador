import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import { isAuthenticated, getToken, logout } from "services/auth";
import { FiArrowLeft } from 'react-icons/fi';

import api from 'services/api';

import './styles.css';

// // Import logo
import logo from 'assets/logo.svg'

class EditSecret extends Component {
    
    constructor(){
        super();
        this.state = {
            id:'',
            name:'',
            username:'',
            password:'',
            notes:'' 
        }

        this.nameIput = React.createRef();
        this.usernameIput = React.createRef();
        this.passwordIput = React.createRef();
        this.notesIput = React.createRef();

        this.handleInputChange = this.handleInputChange.bind(this);
    }

    componentDidMount(){
        this.getSecretDetails();
    }

    getSecretDetails () {
        if(isAuthenticated) {
            if(typeof this.props.match.params.id !== "undefined") {
                try{
                    api.get(`secrets/${ this.props.match.params.id }`, {
                        headers: {
                            Authorization: 'Bearer ' + getToken(),
                        }
                    }).then(response => {
                        this.setState({
                            id:response.data.data.id,
                            name:response.data.data.name,
                            username:response.data.data.username,
                            password:response.data.data.password,
                            notes:response.data.data.notes,
                        });
                    })
                }catch (error){
                    console.error(error);
                }
            }
        }else{
            logout();
            localStorage.clear();
            this.props.history.push('/');
        }
    };
    
    onSubmit(event){

        const newSecret = {
            name: this.nameIput.current.value,
            username: this.usernameIput.current.value,
            password: this.passwordIput.current.value,
            notes: this.notesIput.current.value,
        }
        this.editSecret(newSecret);
        event.preventDefault();
    }
    
    editSecret(newSecret) {
        //newSecret.preventDefault();

        if(isAuthenticated() != null){
            try {
                api.put(`secrets/${ this.state.id }`, newSecret, {
                    headers: {
                        Authorization: 'Bearer ' + getToken(),
                    }
                });
    
                this.props.history.push('/profile');
            } catch (error) {
                alert('Erro ao atualizar, tente novamente', error);
            }
        }
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    render() {
        return (
            <div className="edit-secret-container">
                <div className="content">
                    <section>
                        <img src={ window.location.origin + logo } alt="SakaVault"/>
    
                        <h1>Atualizar o segredo</h1>
    
                        <Link className="back-link" to="/profile">
                            <FiArrowLeft size={16} color="#e02041"></FiArrowLeft>
                            Voltar
                        </Link>
    
                    </section>
    
                    <form onSubmit={ this.onSubmit.bind(this) }>
                        <input 
                            placeholder="Titulo"
                            name="name"
                            ref={ this.nameIput }
                            value={ this.state.name }
                            onChange={ this.handleInputChange }
                        />
    
                        <input 
                            placeholder="Nome de usuário"
                            name="username"
                            ref={ this.usernameIput }
                            value={ this.state.username }
                            onChange={ this.handleInputChange }
                        />
    
                        <input 
                            placeholder="Senha"
                            name="password"
                            ref={ this.passwordIput }
                            value={ this.state.password }
                            onChange={ this.handleInputChange }
                        />
                        
                        <textarea 
                            placeholder="Descrição"
                            name="notes"
                            ref={ this.notesIput }
                            value={ this.state.notes }
                            onChange={ this.handleInputChange }
                        />
                       
                        <button className="button" type="submit"> Atualizar </button>
                    </form>
                </div>
            </div>
        );
    }
}

export default EditSecret;
