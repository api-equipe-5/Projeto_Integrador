import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/styles';
import FormControl from '@material-ui/core/FormControl';
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import Select from '@material-ui/core/Select';
import MenuItem from '@material-ui/core/MenuItem';
import api from '../services/http'

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
};

class CadastroComunicado extends Component {
    state = {
      dpos: [],
      nome: "",
      email: "",
      descricao: "",
      dpo: ""
    }

    async componentDidMount () {
      const response = await api.get('dpo');
      const dpos = response.data.retorno.map((item) => {
        return  {
          id: item.cod_dpo,
          nome: item.nome_dpo
        }
      })
      this.setState({dpos: dpos})
    }

    realizarCadastro = async () => {
      try {
        localStorage.setItem('ux', this.state.nome);
        const response = await api.post("comunicado", {
          responsavel_comunicado: this.state.nome, 
          email_comunicado: this.state.email, 
          cod_dpo: this.state.dpo, 
          desc: this.state.descricao
        });
        
        alert("Cadastro realizado com sucesso! Consulte informações no email")
        this.props.history.push(`/chat/${response.data.comunicado.cod_comunicado}`)
      } catch (error) {
        alert("Erro ao fazer Cadastro");
      }
    }

    render () {
      const { classes } = this.props;
      return (
        <FormControl className={classes.root}>
          <h1 className={classes.titulo}>Cadastro de Comunicado</h1>
          <TextField 
            id="nome" 
            label="Nome" 
            className={classes.espaco}
            onChange={event => this.setState({nome: event.target.value})} 
          />
          <TextField 
            id="email" 
            label="E-mail" 
            type="email"
            className={classes.espaco}
            onChange={event => this.setState({email: event.target.value})} 
          />
          <FormControl className={classes.espaco}>
            <InputLabel 
              id="demo-simple-select-label"
            >
              Selecione o DPO
            </InputLabel>
            <Select
              onChange={event => this.setState({dpo: event.target.value})}
            >
              {this.state.dpos.map(item => (
                <MenuItem 
                  key={item.id} 
                  value={item.id}  
                >
                  {item.nome}
                </MenuItem>
              ))}

            </Select>
          </FormControl>
          <TextField 
            className={classes.espaco} 
            id="descricao" 
            label="Descrição" 
            multiline={true} 
            rows={3}
            onChange={event => this.setState({descricao: event.target.value})} 
          />
          <Button 
            variant="contained" 
            color="primary" 
            className={classes.espacobtt}
            onClick={this.realizarCadastro}
          >
            Cadastrar
          </Button>
        </FormControl>
      );
    }
}

export default withStyles(styles)(CadastroComunicado);