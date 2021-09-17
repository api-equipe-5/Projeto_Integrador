import React, { Component, useState } from 'react';
import Button from '@material-ui/core/Button';
import { makeStyles } from '@material-ui/core/styles';
import FormControl from '@material-ui/core/FormControl';
import TextField from '@material-ui/core/TextField';
import api from '../services/http';
import { useHistory } from 'react-router-dom';

const useStyles = makeStyles({
    root: {
      flex: 1, 
      fontSize: 15, 
      display: 'flex',
      alignItems: 'center',
      textAlign: "center",
    },
    espaco: {
      marginTop:30,
      width: '50vw'
    },
    titulo: {
      fontSize:30, 
    },
    espacobtt: {
        marginTop:40,
        textAlign: "center",
        height: 50
      },
});

function Item(props){
  const history = useHistory();

    const classes = useStyles();
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

     async function realizarLogin(){
      try {
        const resposta = await api.post("login", {email: email, senha: senha})
        localStorage.setItem('ax', resposta.data.session.token);
        localStorage.setItem('ux', resposta.data.session.nome_dpo);
        history.push("/list")
      } catch (error) {
        alert("Erro ao fazer login");
      }
    }
    
    return (
        <FormControl className={classes.root}>
            <h1 className={classes.titulo}>Login</h1>
            <TextField 
              id="email" 
              label="E-mail" 
              className={classes.espaco}
              onChange={evento => setEmail(evento.target.value)} 
            />
            <TextField 
              id="senha" 
              label="Senha" 
              type="password" 
              className={classes.espaco}
              onChange={evento => setSenha(evento.target.value)}
            />
            <Button 
              variant="contained" 
              color="primary" 
              className={classes.espacobtt}
              onClick={realizarLogin}
            >
              Entrar
            </Button>
        </FormControl>
    )
}
export default class Home extends Component {
    render () {
        return (
            <Item />
        );
    }
}