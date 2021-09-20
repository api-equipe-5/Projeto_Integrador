/* eslint-disable object-curly-newline */
import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { Helmet } from 'react-helmet';
import * as Yup from 'yup';
import { Formik } from 'formik';
import {
  Box,
  Button,
  Container,
  TextField,
  Typography,
  Card
} from '@material-ui/core';
import { api } from '../services/api';
import AuthContext from '../contexts/auth';
import './styles.css';

const Login = () => {
  const navigation = useNavigate();

  const { signIn } = useContext(AuthContext);

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSignIn = async (e) => {
    e.preventDefault();

    const data = {
      email,
      senha: password
    };

    const response = await api.post('/login', data);
    signIn(response.data.token, response.data.user);
    navigation('/app/dashboard');
  };

  return (
    <>
      <Helmet>
        <title>DashW</title>
      </Helmet>
      <Box
        sx={{
          backgroundColor: '#000',
          display: 'flex',
          flexDirection: 'column',
          height: '100%',
          justifyContent: 'center',
          alignItems: 'center'
        }}
      >
        <Card className="card-login">
          <Container
            maxWidth="xl"
            sx={{
              padding: 0
            }}
            className="container-login"
          >
            <Formik
              validationSchema={Yup.object().shape({
                email: Yup.string()
                  .email('Must be a valid email')
                  .max(255)
                  .required('Email is required'),
                password: Yup.string().max(255).required('Password is required')
              })}
            >
              {({ handleBlur, isSubmitting }) => (
                <form onSubmit={(e) => handleSignIn(e)}>
                  <Box sx={{ mb: 3 }}>
                    <Typography color="textPrimary" variant="h2">
                      Autenticação
                    </Typography>
                  </Box>
                  <Box
                    sx={{
                      pb: 1,
                      pt: 3
                    }}
                  />
                  <TextField
                    className="login-fields"
                    fullWidth
                    label="E-mail"
                    margin="normal"
                    name="email"
                    onBlur={handleBlur}
                    onChange={(event) => setEmail(event.target.value)}
                    type="email"
                    variant="outlined"
                  />
                  <TextField
                    className="login-fields"
                    fullWidth
                    label="Senha"
                    margin="normal"
                    name="password"
                    onBlur={handleBlur}
                    onChange={(event) => setPassword(event.target.value)}
                    type="password"
                    variant="outlined"
                  />
                  <Box sx={{ py: 2 }}>
                    <Button
                      color="primary"
                      disabled={isSubmitting}
                      fullWidth
                      size="large"
                      type="submit"
                      variant="contained"
                    >
                      Entrar
                    </Button>
                  </Box>
                </form>
              )}
            </Formik>
          </Container>
        </Card>
      </Box>
    </>
  );
};

export default Login;
