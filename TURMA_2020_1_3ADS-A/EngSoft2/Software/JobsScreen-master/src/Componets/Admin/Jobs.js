import React, {useState, useEffect} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';

import RegisterButton from '../ActionButtons/RegisterButton'

import api from '../../services/api'

const useStyles = makeStyles((theme) => ({
  root: {
    minWidth: 275,
    flexGrow: 1,
  },
  bullet: {
    display: 'inline-block',
    margin: '0 2px',
    transform: 'scale(0.8)',
  },
  title: {
    fontSize: 14,
  },
  pos: {
    marginBottom: 12,
  },
  grid: {
    margin: '10px',
  }
}));

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

  const activeData = (r) => {
    window.console.log(r)   
  }

if(rows){
  return (
    <div>
      <RegisterButton type={'job'}/>
      <Grid container spacing={3} className={classes.grid} style={{width:'auto'}}>
        {rows.map(row => {
          return(
        <Grid item xs={3}>
          <Card style={{ height: '200px' }}>
            <CardContent>
              <Typography variant="h5" component="h2">
                {row.segment}
              </Typography>
              <Typography variant="subtitle1" component="h2">
                {row.position}
              </Typography>
              <br/>
              <Typography className={classes.pos} color="textSecondary">
              {row.city}
              </Typography>
            </CardContent>
            <CardActions >
              <Button size="small" onClick={() => activeData(row.id)}>{row.active ? 'Desativar' : 'Ativar'}</Button>
            </CardActions>
          </Card>
      </Grid>
    );
    })}
    </Grid>
    </div>
  );
}
return (
  <span>Carregando...</span>
)
}
