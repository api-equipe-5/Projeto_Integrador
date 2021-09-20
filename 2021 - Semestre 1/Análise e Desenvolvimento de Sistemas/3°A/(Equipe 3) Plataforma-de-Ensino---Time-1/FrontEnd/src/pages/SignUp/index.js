import React from 'react';

import { Form, Input, Button, Radio } from 'antd';

import { Link } from 'react-router-dom';

import 'antd/dist/antd.css';

import { Helmet } from 'react-helmet';

import { FiUser, FiMail, FiLock } from 'react-icons/fi';

import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer, toast } from 'react-toastify';

import * as styles from './styles';

// import LogoIMG from '../../assets/Only_Icon.svg';

function SignUp() {
  const onFinish = (values) => {
    toast.success('Recebi os valores: ', JSON.stringify(values));
    console.log(values);
  };

  return (
    <styles.Container>
      <Helmet>
        <title>Cadastro</title>
      </Helmet>
      <ToastContainer />
      <styles.Content>
        <styles.AnimationContainer>
          <Form
            name="SignUpForm"
            className="signup-form"
            layout="verfical"
            initialValues={{ remember: true }}
            onFinish={onFinish}
          >
            {/* <img src={LogoGestor} alt="Logo Gestor" /> */}

            <h1>Faça seu Cadastro</h1>
            <p>Preencha os campos e cadastre-se na nossa plataforma.</p>

            <Form.Item
              name="isStudent"
              label="Cadastrar como aluno ou professor?"
            >
              <Radio.Group defaultValue="true">
                <Radio.Button value="true">Aluno</Radio.Button>
                <Radio.Button value="false">Professor</Radio.Button>
              </Radio.Group>
            </Form.Item>

            <Form.Item
              name="name"
              label="Insira seu Nome"
              rules={[{ required: true, message: 'Insira seu Nome!' }]}
            >
              <Input
                prefix={<FiUser className="site-form-item-icon" />}
                placeholder="John Doe"
              />
            </Form.Item>

            <Form.Item
              name="email"
              label="Insira seu E-mail"
              rules={[
                {
                  type: 'email',
                  message: 'O e-mail tem que ser válido!',
                },
                { required: true, message: 'Insira seu E-mail!' },
              ]}
            >
              <Input
                prefix={<FiMail className="site-form-item-icon" />}
                placeholder="example@email.com"
              />
            </Form.Item>

            <Form.Item
              name="password"
              label="Insira sua senha"
              rules={[
                {
                  required: true,
                  message: 'Porfavor insira sua senha!',
                },
              ]}
              hasFeedback
            >
              <Input.Password
                prefix={<FiLock className="site-form-item-icon" />}
                placeholder="******"
              />
            </Form.Item>

            <Form.Item
              name="confirmPassword"
              label="Confirme sua senha"
              dependencies={['password']}
              hasFeedback
              rules={[
                {
                  required: true,
                  message: 'Porfavor confirma sua senha!',
                },
                ({ getFieldValue }) => ({
                  validator(_, value) {
                    if (!value || getFieldValue('password') === value) {
                      return Promise.resolve();
                    }
                    return Promise.reject(new Error('As senhas não combinam!'));
                  },
                }),
              ]}
            >
              <Input.Password
                prefix={<FiLock className="site-form-item-icon" />}
                placeholder="******"
              />
            </Form.Item>

            {/* <Form.Item>
              <Link to="forgot-password" className="signup-form-forgot">
                <FiLock />
                Esqueceu sua senha?
              </Link>
            </Form.Item> */}

            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
                className="signup-form-button"
              >
                Cadastrar
              </Button>
              Já tem uma conta? <Link to="/signin">Faça Login</Link>
            </Form.Item>
          </Form>
        </styles.AnimationContainer>
      </styles.Content>
      <styles.Background />
    </styles.Container>
  );
}

export default SignUp;
