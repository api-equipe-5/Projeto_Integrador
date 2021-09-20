import React, { useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotausuario from '../../components/Navbar/rotausuario.json';
import { Form, Input, Button, Row, Col, message, Radio } from 'antd';
import { useHistory } from 'react-router-dom';
import { Tipo, Nome, Email, Cargo, Area, Senha } from '../../components/FormUsuario/usuario';
import { cadusu, usuarios } from '../../services/crudusuario';
import md5 from 'md5';


function SaveUsuario() {

    const validateMessages = {
        required: 'Este campo é obrigatório',
        types: {
          email: 'Insira um e-mail válido',
        },
        string: {
          range: 'Insira um telefone válido (com DDD)',
        }
    };

    var dados = JSON.parse(localStorage.getItem('usr-data'));
    var unome = dados.nome;

    const strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,8})");

    const [senha,setSenha] = useState('');
    const onChangeSenha = (e) => {
    const senha = e.target.value;
    setSenha(senha);
    };
    const [email,setEmail] = useState('');
    const onChangeEmail = (e) => {
    const email = e.target.value;
    setEmail(email);
    };
    const [nome,setNome] = useState('');
    const onChangeNome = (e) => {
        const nome = e.target.value;
        setNome(nome);
      };
      const [tipo,setTipo] = useState('');
      const onChangeTipo = (e) => {
          const tipo = e.target.value;
          setTipo(tipo);
        };
    const [cargo,setCargo] = useState('');
    const onChangeCargo = (e) => {
    const cargo = e.target.value;
    setCargo(cargo);
    };
    const [area,setArea] = useState('');
    const onChangeArea = (e) => {
    const area = e.target.value;
    setArea(area);
    };
    const [telefone,setTelefone] = useState();
    const onChangeTelefone = (e) => {
    const telefone = e.target.value;
    setTelefone(telefone);
    };

    function isNumber(n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }
    
    
    var nota;
    var dadosusuario;
    var cadastrado;
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
                if(obj[item].trim() == ''){
                    count = count+1;
                    nota = 'O campo '+ item +' não pode conter somente espaço';
                    warning(nota);
                }
                else{
                }
            });
            if(count === 0){
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

    async function Verificar() {
        try{
            const response = await usuarios()
            response.data.forEach(element => {
                if(element.email == dadosusuario.email){
                    cadastrado = 1;
                }
                else{
                    cadastrado = 0;
                }    
            });
            console.log(cadastrado);
            switch(cadastrado){
                case(1):
                    nota = 'E-mail já cadastrado';
                    warning(nota);
                    break;
                default:
                    Cadastrar();
                    break;
            } 
        }
        catch(err){
          console.log(err);
          nota = 'Erro ao cadastrar.. comunique o Suporte';
          error(nota);
        } 
    }

    async function Cadastrar(){
        try{
            dadosusuario.senha = md5(dadosusuario.senha);
            console.log(dadosusuario);
            const response = await cadusu(dadosusuario)
            switch(response.data){
                case('Saved'):
                    nota = 'Usuário Cadastrado!';
                    success(nota);
                    setTimeout(() => {
                        history.go('/cadusuario')
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
            nota = 'Erro ao cadastrar.. consulte o Suporte';
            error(nota);
        }
    }


    return(
        <>
        <h2>Edição de Usuário</h2>
        <Form  onFinish={onFinish} validateMessages={validateMessages} 
        >
        <Form.Item
            name={['user', 'tipo']}
            rules={[
            {
                required: true,
            },
            ]}
        >
            <Radio.Group onChange={onChangeTipo} >
            <Radio value="Administrador">Administrador</Radio>
            <Radio value="Gerente">Gerente</Radio>
            <Radio value="Colaborador">Colaborador</Radio>
            </Radio.Group>
      </Form.Item>
      <Form.Item
        name={['user', 'nome']}
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder='Nome' onChange={onChangeNome} value={unome}/>
      </Form.Item>
      <Form.Item
        name={['user', 'email']}
        rules={[
          {
            type: 'email',
            required: true,
          },
        ]}
      >
        <Input placeholder='E-mail' onChange={onChangeEmail} />
        </Form.Item>
        <Form.Item name={['user', 'telefone']} 
            rules={[
                {
                max:11,
                min:10,
                required: true,
                },
            ]}
            >
                <Input placeholder='Telefone' onChange={onChangeTelefone} />
        </Form.Item>
        <Form.Item
        name={['user', 'cargo']}
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder='Cargo' onChange={onChangeCargo} />
      </Form.Item>
      <Form.Item
        name={['user', 'area']}
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder='Área' onChange={onChangeArea} />
      </Form.Item>
      <Form.Item
        name={['user', 'senha']}
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input type='password' maxLength='8' placeholder='Senha' onChange={onChangeSenha}  />
      </Form.Item>    
      {unome}
    </Form>
        </>
    );
}
export default SaveUsuario;
{/* <label>Perfil de Acesso</label>
            <Tipo  />
            <Row >
                <Col style={{width:'48%'}}>
            <Nome initialValue={dados.nome} />
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
                <Input placeholder='Telefone' onChange={onChangeTelefone} />
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
                Cadastrar
                </Button>
            </Form.Item> */}