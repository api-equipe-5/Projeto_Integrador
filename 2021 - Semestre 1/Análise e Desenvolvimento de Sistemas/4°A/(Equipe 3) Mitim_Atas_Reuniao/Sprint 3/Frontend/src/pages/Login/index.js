import React, { useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { Form, Input, Button, message } from 'antd';
import { MailOutlined, LockOutlined } from '@ant-design/icons';
import './login.css';
import Logo from '../../assets/LogoMitim2-s-fundo.png';
import { login } from '../../services/login';
import md5 from 'md5';



function Login() {

  localStorage.removeItem('usr-pass');
  localStorage.removeItem('usr-iden');
  localStorage.removeItem('usr-name');
  localStorage.removeItem('mail');

  const validateMessages = {
    required: 'Por favor insira seu E-mail!',
    types: {
      email: 'Insira um e-mail válido',
    },
  };

  const info = (mensagem) => {
    message.info(mensagem);
  };
  const error = (mensagem) => {
    message.error(mensagem);
  };
  const warning = (mensagem) => {
    message.warning(mensagem);
  };

  const history = useHistory();
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const onChangeEmail = (e) => {
    const email = e.target.value;
    setEmail(email);
  };

  const onChangeSenha = (e) => {
    const senha = e.target.value;
    setSenha(senha);
  };

  const onFinishLogin = (values) => {
    dadosusuario = values.user;
    Entrar();
  };

  var nota;
  var dadosusuario;

  async function Entrar() {
    try {
      var dadoslogin = { email: email, senha: senha }
      const response = await login(dadoslogin);
      switch (response.data.email) {
        case (email):
          if (response.data.aprovacao == 'false') {
            nota = 'Acesso não aprovado';
            warning(nota);
          }
          else {
            nota = 'Bem-vindo ao Mítim';
            info(nota);
            localStorage.setItem('usr-pass', md5(response.data.tipo));
            localStorage.setItem('usr-name', response.data.nome);
            localStorage.setItem('usr-iden', response.data.id);
            history.push('/home');
          }
          break;
        default:
          nota = 'Credenciais inválidas ou inexistentes';
          warning(nota);
          break;
      }
    }
    catch (err) {
      console.log(err);
      nota = 'Erro de conexão..';
      error(nota);
    }
  }

  return (
    <div className="login-comp">
      <img src={Logo} className="img-logo" alt="Mítim" fluid="true" />
      <div className="labels">Login</div>
      <Form name="normal_login" className="login-form" onFinish={onFinishLogin} validateMessages={validateMessages}>
        <Form.Item
          name={['user', 'email']}
          rules={[
            {
              type: 'email',
              required: true,
            },
          ]}
        >
          <Input prefix={<MailOutlined className="site-form-item-icon" />}
            placeholder="E-mail"
            className="input-login"
            onChange={onChangeEmail} />
        </Form.Item>
        <Form.Item
          name={['user', 'senha']}
          rules={[
            {
              required: true,
              message: 'Por favor insira sua Senha!',
            },
          ]}
        >
          <Input prefix={<LockOutlined className="site-form-item-icon" />}
            type="password"
            placeholder="Senha"
            className="input-login"
            onChange={onChangeSenha} />
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit" className="login-form-button" >
            Entrar
            </Button>
          <div className="labels">Ainda não tem cadastro? <Link to="/solacesso">Solicite seu Acesso</Link></div>
        </Form.Item>
        <div className="labels"><Link to="/redsenha">Esqueceu a senha?</Link></div>
      </Form>
    </div>
  );
}
export default Login;