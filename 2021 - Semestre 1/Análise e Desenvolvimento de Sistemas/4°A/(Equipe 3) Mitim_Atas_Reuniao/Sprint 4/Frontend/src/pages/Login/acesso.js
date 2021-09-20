import React, { useState } from 'react';
import { LeftOutlined } from '@ant-design/icons';
import { Link } from 'react-router-dom';
import { Form, Input, Button, Row, Col, message } from 'antd';
import { useHistory } from 'react-router-dom';
import { Tipo, Nome, Email, Cargo, Area, Senha } from '../../components/FormUsuario/usuario';
import { cadusu, usuarios } from '../../services/crudusuario';
import { LoadingScreen } from '../../components/Loading/loading';



function SolAcesso() {

    const [loading, setLoading] = useState(false);

    var nota;
    var dadosusuario;
    var cadastrado = 0;

    const validateMessages = {
        required: 'Este campo é obrigatório',
        types: {
          email: 'Insira um e-mail válido',
        },
        string: {
          range: 'Insira um telefone válido (com DDD)',
        }
    };

    const strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,8})");
    const [telefone,setTelefone] = useState('');
    const onChangeTelefone = (e) => {
    const telefone = e.target.value;
    setTelefone(telefone);
    };

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
    const onFinish = (values) => {
        if(isNumber(telefone)===false){
            nota = 'O campo Telefone deve conter somente números';
            error(nota);
        }
        else{
            dadosusuario = values.user;
            
            var obj = values.user;
            var count = 0;
            Object.keys(obj).forEach(function(item){
                if(obj[item].trim() != obj[item]){
                    count = count+1;
                    nota = 'O campo '+ item +' não pode conter espaço em branco';
                    warning(nota);
                }
                else{
                }
            });
            if(count === 0){
                dadosusuario.aprovacao = false;
                if(strongRegex.test(obj.senha)){
                    Verificar();
                }
                else{
                    nota = 'A senha deve conter de 6 a 8 caracteres com letras maiúsculas, minúsculas, números e caracter especial';
                    warning(nota);
                }
            }     
        }
    };

    function isNumber(n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }

    async function Verificar() {
        try{
            setLoading(true);
            const response = await usuarios();
            response.data.forEach(element => {
                if(element.email == dadosusuario.email){
                    cadastrado = 1;
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
                    Cadastrar();
                    break;
            } 
        }
        catch(err){
          console.log(err);
          nota = 'Erro ao solicitar..';
          error(nota);
        } 
    }

    async function Cadastrar(){
        try{
            console.log(dadosusuario);
            const response = await cadusu(dadosusuario)
            setLoading(false);
            switch(response.data){
                case('Saved'):
                    nota = 'Solicitação Realizada!';
                    success(nota);
                    setTimeout(() => {
                        history.go('/solacesso')
                    }, 4000);
                    break;
                default:
                    nota = 'Usuário já existente';
                    warning(nota);
                    break;
            }
        }
        catch(err){
            console.log(err);
            nota = 'Erro ao solicitar..';
            error(nota);
        }
    }

    return(
        <>
        {loading === false ? (
        <div style={{marginTop:'auto',marginBottom:'auto'}}>
        <h2>Solicitação de Acesso</h2>
        <Form  onFinish={onFinish} validateMessages={validateMessages} 
        >
            <label>Perfil de Acesso</label>
            <Tipo />
            <Row >
                <Col style={{width:'48%'}}>
            <Nome />
            <Email />
            <Form.Item name={['user', 'telefone']} 
            rules={[
                {
                max:11,
                min:10,
                required: true,
                },
            ]}
            >
                <Input  placeholder='Telefone' onChange={onChangeTelefone} />
            </Form.Item>
            </Col>
            <Col style={{width:'4%'}}></Col>
            <Col style={{width:'48%'}}>
            <Cargo />
            <Area />
            <Senha />
            </Col>
            </Row>
            <Form.Item>
                <Button className='login-form-button' type='primary' htmlType="submit">
                Solicitar Acesso
                </Button>
            </Form.Item>
    </Form>
    <Link to='/'><LeftOutlined /></Link>
    </div>) : (<><LoadingScreen/></>)}
        </>
    );
}
export default SolAcesso;