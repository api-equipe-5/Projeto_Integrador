import React, { useState, useEffect } from 'react';

import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

import api from '../../services/api';

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

export default function BasicTable() {
    const classes = useStyles();

    const [data, setData] = useState([]);

    async function getClientes() {
        const result = await api.get('clientes');
        setData(result.data);
    };

    useEffect(() => {
        getClientes();
    }, [])

    return (
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
    );
}
