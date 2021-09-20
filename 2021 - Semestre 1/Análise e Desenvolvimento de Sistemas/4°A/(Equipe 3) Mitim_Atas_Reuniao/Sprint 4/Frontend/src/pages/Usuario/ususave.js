import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotausuario from '../../components/Navbar/rotausuario.json';
import { Button, Input, message, Popconfirm, Table, Modal, Form } from 'antd';
import { usuarios, delusu, ediusu } from '../../services/crudusuario';
import { useHistory } from 'react-router-dom';


function EditMeuPerfil() {

    var mail;
    var emailinicial;
    var tel;
    var nota;
    var dadosusuario;
    var cadastrado = 0;

    const emailRegex = new RegExp(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
    const telRegex = new RegExp(/^[\d]{2}[\d]{4,5}[\d]{4}$/);
    const { Item } = Form;
    const [modalEditar, setModalEditar]=useState(false);
    const [usr,setUsr] = useState({nome:'',email:'',telefone:'',cargo:'',area:'',senha:'',tipo:''});
    const abrirModalEditar=()=>{
        setModalEditar(!modalEditar);
      }
    
    const history = useHistory();

    const selecionarUsr=(usr)=>{
        setUsr(usr);
        abrirModalEditar();
      }

    const columns = [
        {title: 'ID',dataIndex: 'id',key: 'id'},
        {title: 'Nome',dataIndex: 'nome',key: 'nome'},
        {title: 'E-mail',dataIndex: 'email',key: 'email'},
        {title: 'Telefone',dataIndex: 'telefone',key: 'telefone'},
        {title: 'Cargo',dataIndex: 'cargo',key: 'cargo'},
        {title: 'Área',dataIndex: 'area',key: 'area'},
        {title: 'Perfil',dataIndex: 'tipo',key: 'tipo'},
        {title: 'Ações',key: 'acoes',
            render: (fila)=>(
                <>
                    <Button type="primary" onClick={() => selecionarUsr(fila)}>Editar</Button>
                </>
            )
        }
    ];

    const validateMessages = {
        required: 'Este campo é obrigatório',
        types: {
          email: 'Insira um e-mail válido',
        },
        string: {
          range: 'Insira um telefone válido (com DDD)',
        }
    };

    const handleChange=e=>{
        const {name, value}=e.target;
        setUsr({...usr,
        [name]: value});
        console.log(usr);
      }

    const [resultado,setResultado] = useState([]);
    const warning = (mensagem) => {
        message.warning(mensagem);
    };
    const success = (mensagem) => {
        message.success(mensagem);
    };
    const error = (mensagem) => {
        message.error(mensagem);
    };
    const info = (mensagem) => {
        message.info(mensagem);
    };

    
useEffect(() => {
  BuscarUsr();
}, [])
  

    async function BuscarUsr(){
        try{
            const response = await usuarios();
            setResultado(response.data.filter(function(element) {
                return element.id == localStorage.getItem('usr-iden');
            }));
        }
        catch(err){
            console.log(err);
            nota = 'Erro ao acessar o Banco de Dados..';
            error(nota);
        }
    }

    function Ver(){
        dadosusuario = usr;
         mail = usr.email
         tel = usr.telefone
        if(emailRegex.test(mail)){
            if(telRegex.test(tel)){
                Editar();
           } 
           else{
                nota = 'Telefone inválido';
                error(nota);
           }
            }
            else{
                nota = 'E-mail inválido';
                error(nota);
            }
        }
    
    async function Editar(){
        try{
            const response = await ediusu(usr);
            if(response.data === 'Saved'){
                nota = 'Alterações salvas!';
                success(nota);
                setTimeout(() => {
                    history.go('/editusuario')
                }, 2500);
            }
            console.log(response.data);
        }
        catch(err){
            console.log(err);
        }
    }
    
    return(
        <>
            <Navbar routes={rotausuario} />
            <h2>Meu Perfil</h2>
             <Table columns={columns} dataSource={resultado}
             scroll={{ x: 700 }} 
             style={{width:"80%", minWidth:"200px", marginTop:"5%"}} >
            </Table>

            <Modal
                visible={modalEditar}
                title="Editar Usuário"
                onCancel={abrirModalEditar}
                centered
                footer={[
                    <Button onClick={abrirModalEditar}>Cancelar</Button>,
                    <Button type="primary" onClick={Ver}>Salvar</Button>,
                ]}
                >
            <Form >
            <Item label="Nome">
                <Input name="nome" onChange={handleChange} value={usr && usr.nome}/>
            </Item>

            <Item label="E-mail">
                <Input name="email" onChange={handleChange} value={usr && usr.email}/>
            </Item>

            <Item label="Telefone">
                <Input name="telefone" onChange={handleChange} value={usr && usr.telefone}/>
            </Item>

            <Item label="Cargo">
                <Input name="cargo" onChange={handleChange} value={usr && usr.cargo}/>
            </Item>

            <Item label="Área">
                <Input name="area" onChange={handleChange} value={usr && usr.area}/>
            </Item>
            </Form>
            </Modal>       
        </>
    );
}

export default EditMeuPerfil;