import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import {Link} from 'react-router-dom';
import api from '../services/http'

const useStyles = makeStyles({
  root: {
    minWidth: 275,
    marginBottom: 10,
  },
  title: {
    fontSize: 14,
  },
});

function Item(props) {
  const classes = useStyles();
  const conteudo = props.cardList.map((cardList) =>
  <header key={cardList.id}>
    <Link to={`/chat/${cardList.id}`}>
      <Card className={classes.root}>
        <CardContent>
          <div>
            <h3>{cardList.title}</h3>
            <p>{cardList.dia}</p>
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

export default class ListaConversa extends Component {
  state = {
    cardList: [],
  }
  async componentDidMount(){
    const resposta = await api.get('/comunicado')

    const lista = resposta.data.retorno.map((item) => {
      return {
        id: item.cod_comunicado,
        title: item.responsavel_comunicado,
        dia: item.data_atualizacao
      }
    })
    this.setState({cardList: lista})
  }
  
  render () {
    return(
      <Item cardList={this.state.cardList}/>
    );
  }
}