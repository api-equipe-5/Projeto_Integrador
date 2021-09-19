import React, {useState, useEffect} from 'react';

import ShareIcon from '@material-ui/icons/Share';
import { makeStyles } from '@material-ui/core/styles'; 
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import FavoriteBorderIcon from '@material-ui/icons/FavoriteBorder';
import FavoriteIcon from '@material-ui/icons/Favorite';
import image from '../banner-01.jpg'

import api from '../../services/api'


const useStyles = makeStyles({
  root: {
    width: '100%',
  },
  container: {
    maxHeight: 440,
  },
});

const columns = [
    { id: 'city', label: 'Cidade', minWidth: 170 },
    { id: 'position', label: 'Posição', minWidth: 200 },
    {
      id: 'segment',
      label: 'Segmento',
      minWidth: 170,
      align: 'right',
    },
    {
      id: 'like',
      label: 'Vagas\u00a0salvas',
      minWidth: 100,
      align: 'center',
    },
    {
      id: 'share',
      label: '',
      minWidth: 100,
      align: 'center',
    },
  ];
  


export default () => {
    const classes = useStyles();
    const [rows, setRows] = useState()
    
    useEffect(() => {
      createData();
    }, [])

    const createData = async () => {
      await api.get('http://localhost:5000/api/jobs')
        .then(r => {
          setRows(r.data.jobs)  
        })
    }
     return(
        <>
         <div >
            <img src={image} alt="Banner" style={{minWidth:"100%", maxWidth:"100%"}}/>
         </div>
         <div style={{padding: "50px 100px"}}>
            <select/>
            <Tables classes={classes} rows={rows}/>
         </div>
        </> 
     )
};

const Tables = ({classes, rows}) =>
  { 
    if(rows){ 
      return (
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
              
              {rows.map((row) => {
                return (
                  <TableRow hover role="checkbox" tabIndex={-1} key={row.position}>
                    {columns.map((column) => {
                      const value = row[column.id];
                      return (
                        <TableCell key={column.id} align={column.align}>
                            {column.id === "like" && <LikeButton />}
                            {column.id === "share" && <ShareButton row={row} /> }
                          {column.format && typeof value === 'number' ? column.format(value) : value}
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
      )}
      return(
        <span>Carregando...</span>
      )
    }

const ShareButton = ({row}) => {
  return (
    <ShareIcon onClick={() => window.console.log(row.position)}/>

  )
}

const LikeButton = () => {
  const [like, setLike] = useState(false) 
  if(like) return <FavoriteIcon onClick={() => setLike(!like) }/>
  return (
    <FavoriteBorderIcon onClick={() => setLike(!like)}/>
  )

}


