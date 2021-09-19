import React, {useState} from 'react';
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
import image from './banner-01.jpg'

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
  
const createData = (city, position, segment) => {
    return { city, position, segment };
  }
  
  const rows = [
    createData('São José dos Campos', 'Analista de Sistemas Junior', "TI"),
    createData('São José dos Campos', 'Engenheiro de Softwere', "TI"),
    createData('São José dos Campos', 'Assistente Administrativa', "Administracao"),
    createData('São José dos Campos', 'Estagiario de TI', "TI"),
    createData('São José dos Campos', 'Producao de video', "Audio visual"),
    createData('São José dos Campos', 'Editor de Imagem', "Audio visual"),
    createData('São José dos Campos', 'Engenheiro da Computacao', "TI"),
    createData('São José dos Campos', 'Analista de Sistemas Senior', "TI"),
    createData('São José dos Campos', 'Desenvolvedor Front End', "TI"),
    createData('São José dos Campos', 'Desenvolvedor Back End', "TI"),
    createData('São José dos Campos', 'Desenvolvedor FullStack', "TI"),
  ];

const Body = () => {
    const classes = useStyles();

     return(
        <>
         <div >
            <img src={image} alt="Banner" style={{minWidth:"100%", maxWidth:"100%"}}/>
         </div>
         <div style={{padding: "50px 100px"}}>
            <select/>
            <Tables classes={classes} />
         </div>
        </> 
     )
};

const Tables = ({classes}) =>
  { 
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


export default Body;

