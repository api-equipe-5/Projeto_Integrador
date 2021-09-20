import React, { Component } from 'react';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import FormControl from '@material-ui/core/FormControl';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Comment from '@material-ui/icons/Comment';
import ChatCard from '../components/ChatCard';
import api from '../services/http'

export default class Chat extends Component {

    state = {
        list: [],
        dpo: [],
        message: '',
        open: false,
        hash: '',
        text: '',
        hash_comunicado: ''
    }

    handleClickOpen = () => {
        this.setState({open: true});
     };
    
    handleClose = () => {
        this.setState({open: false});
    };

    handleDialog = async () => {
        var hash = this.state.hash
        var id = this.props.match.params.id
        id = id.replace(':', '')
        
        try {
            await api.get(`validar?token=${hash}&id=${id}`)
        } catch (error) {
            this.setState({text: 'Chave inválida'})
            return ;
        }

        this.setState({open: false})
    }

    async componentDidMount (){
        const hash = localStorage.getItem("xxx");
        const token = localStorage.getItem("ax");
        if (hash || token) {
            this.setState({hash: hash})
        } else {
            this.setState({open: true})
        }
        const id = this.props.match.params.id;
        const response = await api.get(`comunicado/${id}`);
        this.setState({list: response.data.lista_comunicados.respostas})
        this.setState({dpo: response.data.lista_comunicados.nome_dpo});
        this.setState({hash_comunicado: response.data.lista_comunicados.hash_comunicado});
    }
    handleChange = (event) => {
        this.setState({message: event.target.value});
    }
    handleSubmit = (event) => {
        var list = this.state.list;
        var user = localStorage.getItem('ux');

        list.push({author: user, conteudo: this.state.message});
        this.setState({list: list});
        this.setState({message: ''});

        api.post('resposta/', {
            conteudo: this.state.message,
            autor: user,
            cod_comunicado: this.props.match.params.id
        })
    }

    handleLog = (event) => {
        this.props.history.push(`/logs/${this.state.hash_comunicado}`);
    }

    render () {
        return (
            <section>
                <Grid container spacing={3}>
                    <Grid item xs={12}>
                    {
                        this.state.list.map((msg, index) => {
                            return <ChatCard
                                    key={index} 
                                    author={msg.author}
                                    content={msg.conteudo}
                                    date={msg.data}
                                    dpo={this.state.dpo}
                                 />
                        })
                    }
                    </Grid>
                    <Grid item xs={10}>
                        <form autoComplete="off">
                            <FormControl fullWidth>
                                <TextField
                                    id="standard-textarea"
                                    placeholder="Mensagem"
                                    rows="3"
                                    multiline
                                    value={this.state.message}
                                    onChange={this.handleChange}
                                />
                            </FormControl>
                        </form>
                    </Grid>
                    <Grid item xs={2}>
                        <Button onClick={this.handleSubmit}> Enviar </Button>
                        <Button 
                            color="primary"
                            endIcon={<Comment />}
                            onClick={this.handleLog}
                        > 
                            Logs 
                        </Button>
                    </Grid>
                </Grid>
                <Dialog 
                    open={this.state.open} 
                    onClose={this.handleClose} 
                    disableBackdropClick
                    disableEscapeKeyDown  
                    aria-labelledby="form-dialog-title"
                >
                    <DialogTitle id="form-dialog-title">Autenticação</DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            Para ter acesso ao chat por favor insira a chave que te enviamos por email.
                            {this.state.text}
                        </DialogContentText>
                        <TextField
                        autoFocus
                        margin="dense"
                        id="hash"
                        label="Hash"
                        type="text"
                        fullWidth
                        value={this.state.hash}
                        onChange={event => this.setState({hash: event.target.value})}
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={this.handleDialog} color="primary">
                        Enviar
                        </Button>
                    </DialogActions>
                </Dialog>

            </section>
        );
    }
}