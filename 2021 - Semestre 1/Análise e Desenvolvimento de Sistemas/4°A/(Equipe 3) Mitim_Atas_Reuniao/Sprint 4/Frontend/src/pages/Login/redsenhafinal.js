import React, { useState } from 'react';
import { LeftOutlined } from '@ant-design/icons';
import { Link } from 'react-router-dom';
import { Form, Button, Row, Input, message } from 'antd';
import { useHistory } from 'react-router-dom';
import { ediusu, usuarios } from '../../services/crudusuario';



function RedSenhaFinal() {

    var nota;
    var dadosusuario;
    var cadastrado = 1;

    var mail = localStorage.getItem('mail');

    const validateMessages = {
        required: 'Este campo é obrigatório',
    };

    const [senha,setSenha] = useState('');
    const onChangeSenha = (e) => {
        const senha = e.target.value;
        setSenha(senha);
    };

    const [senhaConfirm,setSenhaConfirm] = useState('');
    const onChangeSenhaConfirm = (e) => {
        const senhaConfirm = e.target.value;
        setSenhaConfirm(senhaConfirm);
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

    async function Verificar() {
        try{
            const response = await usuarios()
            response.data.forEach(element => {
                if(element.email == mail){
                    cadastrado = 0;
                    dadosusuario = element;
                } 
            });
            console.log(cadastrado);
            switch(cadastrado){
                case(1):
                    nota = 'E-mail já cadastrado';
                    warning(nota);
                    cadastrado = 0;
                    break;
                default:
                    if(strongRegex.test(senha) && strongRegex.test(senhaConfirm)){
                        if(senha == senhaConfirm){
                            if(senha.trim() != senha){
                                nota = 'A senha não pode conter espaço em branco';
                                warning(nota);
                            }
                            else{
                                dadosusuario.senha = senha;
                                Editar();
                            }
                        }
                        else{
                            nota = 'Os dois campos não tem o mesmo conteúdo';
                            warning(nota); 
                        }
                    }
                    else{
                        nota = 'A senha deve conter de 6 a 8 caracteres com letras maiúsculas, minúsculas, números e caracter especial';
                        warning(nota);
                    }
                    break;
            } 
        }
        catch(err){
          console.log(err);
          nota = 'Erro ao redefinir..';
          error(nota);
        } 
    }

    async function Editar(){
        try{
            console.log(dadosusuario);
            const response = await ediusu(dadosusuario)
            switch(response.data){
                case('Saved'):
                    nota = 'Senha Redefinida!';
                    success(nota);
                    setTimeout(() => {
                        history.go('/')
                    }, 100);
                    break;
                default:
                    nota = 'Usuário já existente';
                    warning(nota);
                    break;
            }
        }
        catch(err){
            console.log(err);
            nota = 'Erro ao redefinir..';
            error(nota);
        }
    }

    return(
        <>
        <div style={{marginTop:'auto',marginBottom:'auto'}}>
        <h2>Redefinição de Senha</h2>
        <Form  onFinish={Verificar} validateMessages={validateMessages} 
        >
            <label>Defina sua nova senha e confirme-a no campo abaixo</label>
            
            <Form.Item
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input type='password' maxLength='8' placeholder='Senha' onChange={onChangeSenha}  />
        </Form.Item>
        <Form.Item
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input type='password' maxLength='8' placeholder='Confrimar Senha' onChange={onChangeSenhaConfirm}  />
        </Form.Item>
      
            <Form.Item>
                <Row>
                <Button className='login-form-button' type='primary' htmlType="submit">
                Redefinir
                </Button>
                </Row>
            </Form.Item>
    </Form>
    <Link to='/'><LeftOutlined /></Link>
    </div>
        </>
    );
}
export default RedSenhaFinal;