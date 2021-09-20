import React, { useState, useEffect } from 'react';

import api from '../../services/api';

import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import Button from '@material-ui/core/Button';

export default function MeusDados() {

    const [idCliente, setIdCliente] = useState('');
    const [nome, setNome] = useState('');
    const [sobrenome, setSobrenome] = useState('');
    const [email, setEmail] = useState('');
    const [cpf, setCpf] = useState('');
    const [telefone, setTelefone] = useState('');
    const [endereco, setEndereco] = useState('');
    // const [compartilhaDadosPessoais, setCompartilhaDadosPessoais] = useState(false);
    // const [compartilhaDadosCompras, setCompartilhaDadosCompras] = useState(false);

    const [state, setState] = React.useState({
        checkedA: false,
        checkedB: false,
    });

    const handleChange = (event) => {
        setState({ ...state, [event.target.name]: event.target.checked });
    };

    async function getMeusDados(id) {
        const result = await api.get('configuracaoCompartilhamento/' + id);
        setNome(result.data.cliente.nome);
        setSobrenome(result.data.cliente.sobrenome);
        setEmail(result.data.cliente.email);
        setCpf(result.data.cliente.nome);
        setTelefone(result.data.cliente.telefone);
        setEndereco(result.data.cliente.endereco);
        setState({ ...state, checkedA: result.data.compartilha_dados_pessoais });
        console.log(result.data.compartilha_dados_pessoais)
        setState({ ...state, checkedB: result.data.compartilha_dados_compras });
        console.log(result.data)
    };

    return (
        <Grid container spacing={3}>
            <Grid item xs={12}>
                <TextField
                    id="idCliente"
                    label="Digite a ID do cliente"
                    value={idCliente}
                    onChange={(e) => setIdCliente(e.target.value)} />

                <Button variant="contained" color="primary" onClick={() => getMeusDados(idCliente)}>
                    Buscar
                </Button>
            </Grid>
            <Grid item xs={4}>
                <form noValidate autoComplete="off">
                    <TextField
                        fullWidth
                        id="nome"
                        label="Nome"
                        value={nome}
                        onChange={(e) => setNome(e.target.value)} />

                    <TextField
                        fullWidth
                        id="sobrenome"
                        label="Sobrenome"
                        value={sobrenome}
                        onChange={(e) => setSobrenome(e.target.value)} />

                    <TextField
                        fullWidth
                        id="email"
                        label="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)} />

                    <TextField
                        fullWidth
                        id="cpf"
                        label="CPF"
                        value={cpf}
                        onChange={(e) => setCpf(e.target.value)} />

                    <TextField
                        fullWidth
                        id="telefone"
                        label="Telefone"
                        value={telefone}
                        onChange={(e) => setTelefone(e.target.value)} />

                    <TextField
                        fullWidth
                        id="endereco"
                        label="Endereço"
                        value={endereco}
                        onChange={(e) => setEndereco(e.target.value)} />
                </form>
            </Grid>
            <Grid item xs={12}>
                <FormControlLabel
                    control={
                        <Switch
                            checked={state.checkedA}
                            onChange={handleChange}
                            name="checkedA"
                            color="primary"
                        />
                    }
                    label="Compartilhar Dados Pessoais"
                />

                <FormControlLabel
                    control={
                        <Switch
                            checked={state.checkedB}
                            onChange={handleChange}
                            name="checkedB"
                            color="primary"
                        />
                    }
                    label="Compartilhar Dados Compras"
                />
            </Grid>
        </Grid>
    )
}