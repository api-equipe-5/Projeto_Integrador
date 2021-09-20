import React from 'react';

import { Link } from "react-router-dom";

import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

import Routes from './../../Routes';

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
    },
    appBar: {
        zIndex: theme.zIndex.drawer + 1,
    },
    drawer: {
        width: drawerWidth,
        flexShrink: 0,
    },
    drawerPaper: {
        width: drawerWidth,
    },
    drawerContainer: {
        overflow: 'auto',
    },
    content: {
        flexGrow: 1,
        padding: theme.spacing(3),
    },
}));

export default function ClippedDrawer() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <CssBaseline />
            <AppBar position="fixed" className={classes.appBar}>
                <Toolbar>
                    <Typography variant="h6" noWrap>
                        Safe Share
                    </Typography>
                </Toolbar>
            </AppBar>
            <Drawer
                className={classes.drawer}
                variant="permanent"
                classes={{
                    paper: classes.drawerPaper,
                }}
            >
                <Toolbar />
                <div className={classes.drawerContainer}>
                    <List>
                        <ListItem
                            button
                            component={Link}
                            to="/clientes"
                        >
                            <ListItemText>Clientes</ListItemText>
                        </ListItem>
                        <ListItem
                            button
                            component={Link}
                            to="/log"
                        >
                            <ListItemText>Log</ListItemText>
                        </ListItem>
                        <ListItem
                            button
                            component={Link}
                            to="/solicitar-dados"
                        >
                            <ListItemText>Solicitar Dados</ListItemText>
                        </ListItem>
                    </List>
                    <Divider />
                    <List>
                        <ListItem
                            button
                            component={Link}
                            to="/meus-dados"
                        >
                            <ListItemText>Meus Dados</ListItemText>
                        </ListItem>
                        <ListItem
                            button
                            component={Link}
                            to="/historico-compartilhamento"
                        >
                            <ListItemText>Histórico de Compartilhamento</ListItemText>
                        </ListItem>
                    </List>
                </div>
            </Drawer>
            <main className={classes.content}>
                <Toolbar />
                <Routes />
            </main>
        </div>
    );
}
