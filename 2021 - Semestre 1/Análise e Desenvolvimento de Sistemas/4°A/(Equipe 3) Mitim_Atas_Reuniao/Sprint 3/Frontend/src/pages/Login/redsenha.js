import React, { useState } from 'react';
import { LeftOutlined } from '@ant-design/icons';
import { Link } from 'react-router-dom';
import { Form, Button, Row, message } from 'antd';
import { useHistory } from 'react-router-dom';
import { Email } from '../../components/FormUsuario/usuario';
import { usuarios } from '../../services/crudusuario';
import { redsenha } from '../../services/redsenha';



function RedSenha() {

    var nota;
    var cadastrado = 1;
    var dadosusuario;

    const validateMessages = {
        required: 'Este campo é obrigatório',
        types: {
          email: 'Insira um e-mail válido',
        },
    };

    const strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,8})");

    const success = (mensagem) => {
        message.success(mensagem);
    };
    const error = (mensagem) => {
        message.error(mensagem);
    };
    const warning = (mensagem) => {
        message.warning(mensagem);
    };


    const history = useHistory();

    async function Verificar(values) {
        try{
            const response = await usuarios()
            response.data.forEach(element => {
                if(element.email == values.user.email){
                    cadastrado = 0;
                    dadosusuario = element;
                } 
            });
            console.log(cadastrado);
            switch(cadastrado){
                case(0):
                    Envio();
                    cadastrado = 1;
                    localStorage.setItem('mail', values.user.email);
                    break;
                default:
                     nota = 'E-mail não cadastrado';
                    warning(nota);
                    break;
            } 
        }
        catch(err){
          console.log(err);
          nota = 'Erro ao cadastrar..';
          error(nota);
        } 
    }

    async function Envio(){
        try{
            const response = await redsenha(dadosusuario);
            if(response.data === 'Envio de redefinição de senha realizado com sucesso'){
                nota = 'E-mail Enviado!';
                success(nota);
                setTimeout(() => {
                    history.go('/')
                }, 2500);
            }
            console.log(response.data);
        }
        catch(err){
            console.log(err);
            nota = 'Erro ao enviar e-mail..';
            error(nota);
        }
    }

    return(
        <>
        <div style={{marginTop:'auto',marginBottom:'auto'}}>
        <h2>Esqueci minha Senha</h2>
        <Form  onFinish={Verificar} validateMessages={validateMessages} 
        >
            <label>Digite seu E-mail Cadastrado abaixo para receber o link<br></br> de redefinição de senha em sua caixa de mensagens</label>
            
            <Email style={{width:'1000px'}} />
      
            <Form.Item>
                <Row>
                <Button className='login-form-button' type='primary' htmlType="submit">
                Enviar E-mail
                </Button>
                </Row>
            </Form.Item>
    </Form>
    <Link to='/'><LeftOutlined /></Link>
    </div>
        </>
    );
}
export default RedSenha;