import React, { Component } from 'react';
import { withStyles } from '@material-ui/styles';
import Button from '@material-ui/core/Button';
import FormControl from '@material-ui/core/FormControl';
import TextField from '@material-ui/core/TextField';
import api from '../services/http';

const styles = {
    root: {
      fontSize: 15, 
      textAlign: "center",
      display: 'flex',
      alignItems: 'center'
    },
    espaco: {
      marginTop:20,
      width:'50vw',
    },
    titulo: {
        fontSize:30, 
      },
    espacobtt: {
        marginTop:40,
        textAlign: "center",
        height: 50
      },
}

class CadastroDPO extends Component {

    state = {
        nome : '',
        email: '',
        senha: '',
        bio: '',
        telefone: ''
    }
    handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await api.post('dpo', {
                nome_dpo: this.state.nome,
                email_dpo: this.state.email,
                senha: this.state.senha,
                desc_dpo: this.state.bio,
                telefone_dpo: this.state.telefone
            })
    
            this.props.history.push("/login");
        } catch (error) {
            alert('Erro ao realizar cadastro');
        }
    }

    render () {
        const { classes } = this.props;
        return (
            <section>
                <FormControl className={classes.root}>
                    <h1 className={classes.titulo}>Cadastre-se</h1>
                    <p>Utilize a plataforma para ter todas as suas tarefas centralizadas</p>
                    <TextField 
                        id="nome" 
                        label="Nome" 
                        className={classes.espaco}
                        onChange={ event => this.setState({nome: event.target.value})}
                    />
                    <TextField 
                        id="email" 
                        label="E-mail" 
                        className={classes.espaco}
                        onChange={ event => this.setState({email: event.target.value})}
                    />
                    <TextField 
                        id="senha" 
                        label="Senha" 
                        type="password" 
                        className={classes.espaco}
                        onChange={ event => this.setState({senha: event.target.value})}
                    />
                    <TextField 
                        id="telefone" 
                        label="Telefone"
                        className={classes.espaco}
                        onChange={ event => this.setState({telefone: event.target.value})}
                    />
                    <TextField 
                        id="sobre" 
                        label="Biografia"
                        multiline={true} 
                        rows={3}
                        className={classes.espaco}
                        onChange={ event => this.setState({bio: event.target.value})}
                    />
                    <Button 
                        variant="contained" 
                        color="primary" 
                        className={classes.espacobtt}
                        onClick={this.handleSubmit}
                    >
                        Cadastrar
                    </Button>
                </FormControl>
            </section>
        );
    }
}


export default withStyles(styles)(CadastroDPO);