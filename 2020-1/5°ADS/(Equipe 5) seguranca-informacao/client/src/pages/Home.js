import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import { withStyles } from '@material-ui/styles';
import Grid from '@material-ui/core/Grid';


const classes = makeStyles((theme) => ({
    heroContent: {
      padding: theme.spacing(8, 0, 6),
    }
  }));

class Home extends Component {

    render () {
        return (
            <Container maxWidth="sm" component="main" className={classes.heroContent}>
                <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom>
                Plataforma para DPOs
                </Typography>
                <Typography variant="h5" align="center" color="textSecondary" component="p">
                Cansado de atender chamados em diversas plataformas? Use nossa plataforma e tenha todos os chamados centralizado
                </Typography>
                <Container maxWidth="md" component="main">
                    <Grid container spacing={5} >
                        <Grid item xs={12} sm={6} md={4}>
                            <Button variant="contained" color="primary" href="/cadastre-se">
                                Cadastre-se
                            </Button>
                            <Button variant="contained" color="primary" href="/login">
                                Login
                            </Button>
                        </Grid>
                    </Grid>
                </Container>
            </Container>
        )
    }
}

export default withStyles(classes)(Home);