import React, { useState, useEffect } from 'react';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import TextField from '@material-ui/core/TextField';

import api from '../../services/api';

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

export default function SolicitarDados() {

    const classes = useStyles();

    const [data, setData] = useState([]);

    const [idCliente, setIdCliente] = useState('');
    const [nome, setNome] = useState('');
    const [sobrenome, setSobrenome] = useState('');
    const [email, setEmail] = useState('');
    const [cpf, setCpf] = useState('');
    const [telefone, setTelefone] = useState('');
    const [endereco, setEndereco] = useState('');

    async function getClientes() {
        const result = await api.get('clientes');
        setData(result.data);
    };

    useEffect(() => {
        getClientes();
    }, [])

    async function getMeusDados(id) {
        const result = await api.get('configuracaoCompartilhamento/' + id);
        setNome(result.data.cliente.nome);
        setSobrenome(result.data.cliente.sobrenome);
        setEmail(result.data.cliente.email);
        setCpf(result.data.cliente.nome);
        setTelefone(result.data.cliente.telefone);
        setEndereco(result.data.cliente.endereco);
    };

    return (
        <Grid container spacing={3}>
            <Grid item xs={12}>
                <Button variant="contained" color="primary">
                    Solicitar Dados
                </Button>
            </Grid>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell align="left">Nome</TableCell>
                            <TableCell align="left">Sobrenome</TableCell>
                            <TableCell align="left">Email</TableCell>
                            <TableCell align="left">Telefone</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {data.map((row) => (
                            <TableRow key={row.id}>
                                <TableCell align="left">{row.id}</TableCell>
                                <TableCell align="left">{row.nome}</TableCell>
                                <TableCell align="left">{row.sobrenome}</TableCell>
                                <TableCell align="left">{row.email}</TableCell>
                                <TableCell align="left">{row.telefone}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
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
        </Grid>
    )
}