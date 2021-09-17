import React, { Component } from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import api from '../services/http'

export default class Chat extends Component {

    state = {
        array_log: []
    }

    async componentDidMount (){
        const hash = this.props.match.params.hash;
        // const hash = '99728418fe78'
        const response = await api.get(`log/${hash}`);
        const logs = response.data.data.split('\n');
        this.setState({array_log: logs})
    }

    render () {
        return (
            <section>
                <List>
                    {this.state.array_log.map((item, index) => {
                        let dados = item.split(' ')
                        let primary = dados.slice(3,dados.lenght).toString().replaceAll(",", " ")
                        let second = dados.slice(0,2).toString()
                        return (
                            <ListItem key={index}>
                                <ListItemText primary={primary} secondary={second} />
                            </ListItem>
                        )
                    })}
                </List>
            </section>
        );
    }
}