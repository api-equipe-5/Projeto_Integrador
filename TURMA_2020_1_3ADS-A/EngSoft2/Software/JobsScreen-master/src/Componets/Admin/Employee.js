import React, {useState, useEffect} from 'react';

import { makeStyles } from '@material-ui/core/styles'; 
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

import RegisterButton from '../ActionButtons/RegisterButton'

import api from '../../services/api'


const columns = [
    { id: 'id', label: 'Id', minWidth: 170 },
    { id: 'name', label: 'Nome', minWidth: 170 },
    { id: 'email', label: 'Email', minWidth: 200 },
  ];

  const useStyles = makeStyles({
    root: {
      width: '100%',
    },
    container: {
      maxHeight: 440,
    },
  });
  

export default () => {
    
    const classes = useStyles();
    const [employees, setEmployees] = useState()

    useEffect(() => {
     createData();
    }, [employees])

    const createData = async () => {
        await api.get('http://localhost:5000/api/employee')
            .then(r => {
            setEmployees(r.data.employee)
            })
    }


      if(employees){ 
        return (
            <div>
              <RegisterButton type={'employee'}/>
                <Paper className={classes.root}>
                <TableContainer className={classes.container}>
                    <Table stickyHeader aria-label="sticky table">
                    <TableHead>
                        <TableRow>
                        {columns.map((column) => (
                            <TableCell
                            key={column.id}
                            align={column.align}
                            style={{ minWidth: column.minWidth }}
                            >
                            <strong>{column.label}</strong>
                            </TableCell>
                        ))}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        
                        {employees.map((employee) => {
                        return (
                            <TableRow hover role="checkbox" tabIndex={-1} key={employees.id}>
                            {columns.map((column) => {
                                return (
                                <TableCell key={column.id} align={column.align}>
                                    {column.id === 'id' && employee.id}
                                    {column.id === 'name' && employee.name}
                                    {column.id === 'email' && employee.email}
                                </TableCell>
                                );
                            })}
                            </TableRow>
                        );
                        })}
                    </TableBody>
                    </Table>
                </TableContainer>
                </Paper>
            </div>
            )}
        return(
          <span>Carregando...</span>
        )
      }