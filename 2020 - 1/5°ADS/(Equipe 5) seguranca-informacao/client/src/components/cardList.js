import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import {Link} from 'react-router-dom';

const useStyles = makeStyles({
    root: {
      minWidth: 275,
      marginBottom: 10,
    },
    title: {
      fontSize: 14,
    },
  });
  
function Blog(props) {
  const classes = useStyles();
  const conteudo = props.cardList.map((cardList) =>
  <header>
    <Link to="/chat">
    <Card className={classes.root}>
      <CardContent>
        <div key={cardList.id}>
          <h3>{cardList.title}</h3>
          <p>{cardList.dia} - {cardList.hora}</p>
        </div>
      </CardContent>
    </Card>
    </Link>
  </header>
  );
  return (
      <div>
        {conteudo}
      </div>
  );
}


  