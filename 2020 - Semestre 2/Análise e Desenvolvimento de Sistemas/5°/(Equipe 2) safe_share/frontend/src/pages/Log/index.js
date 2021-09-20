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
        const result = await api.get('log-compartilhamentos');
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
                        <TableCell>ID Cliente</TableCell>
                        <TableCell align="left">Dados Compartilhados</TableCell>
                        <TableCell align="left">Empresa</TableCell>
                        <TableCell align="left">Data Inicio</TableCell>
                        <TableCell align="left">Data Fim</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data.map((row) => (
                        <TableRow key={row.id}>
                            <TableCell align="left">{row.cliente.id}</TableCell>
                            <TableCell align="left">{row.dadoCompartilhado}</TableCell>
                            <TableCell align="left">{row.empresa.nome}</TableCell>
                            <TableCell align="left">{row.dataDeInicio[0] + '/' + row.dataDeInicio[1] + '/' + row.dataDeInicio[2]}</TableCell>
                            <TableCell align="left">{row.dataFinal[0] + '/' + row.dataFinal[1] + '/' + row.dataFinal[2]}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
