import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotausuario from '../../components/Navbar/rotausuario.json';
import { Button, Input, message, Popconfirm, Table, Modal, Form } from 'antd';
import { usuarios, delusu } from '../../services/crudusuario';
import { apracesso } from '../../services/apracesso';
import { useHistory } from 'react-router-dom';


 function EditUsuario() {
    
  
    var mail;
    var emailinicial;
    var tel;
    var nota;
    var dadosusuario;
    var cadastrado = 0;

    const emailRegex = new RegExp(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
    const telRegex = new RegExp(/^[\d]{2}[\d]{4,5}[\d]{4}$/);
    const [modalEditar, setModalEditar]=useState(false);
    const [usr,setUsr] = useState({id:'',nome:'',email:'',telefone:'',cargo:'',area:'',tipo:''});
    const abrirModalEditar=()=>{
        setModalEditar(!modalEditar);
      }

    const history = useHistory();

    const selecionarUsr=(usr)=>{
        setUsr(usr);
        Aprovar(usr);
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
                    <Button type="primary" onClick={() => Aprovar(fila)}>Aprovar</Button>{'   '}
                    <Popconfirm title="Tem certeza que deseja excluir esta solicitação?" 
                    okText="Sim" cancelText="Não" 
                    onConfirm={() => Excluir(fila)}  >
                        <Button  type="default"  danger >X</Button>
                    </Popconfirm> 
                </>
            )
        }
    ];

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


    async function Excluir(fila) {

        try{
            const response = await delusu(fila.id);
            if(response.data === 'Deleted'){
                nota = 'Solicitação Excluída!';
                success(nota);
                setTimeout(() => {
                    history.go('/aprusuario')
                }, 2000);
            }
            else{
                nota = 'Usuário não encontrado para exclusão';
                error(nota);
            } 
        } 
        catch(err){
            console.log(err);
            nota = 'Erro ao excluir..';
            error(nota);
        }
    }

    useEffect(() => {
        async function Listar(){
            const response = await usuarios();
            setResultado(response.data.filter(function(element) {
                return element.aprovacao.includes(false);
            }));
        }
        Listar();
        
    },[])
   

    function Aprovar(fila){
        fila.aprovacao = true;
        Editar(fila);
        }
    
    async function Editar(fila){
        try{
            const response = await apracesso(fila);
            if(response.data === 'Aprovado'){
                nota = 'Usuário Aprovado!';
                success(nota);
                setTimeout(() => {
                    history.go('/aprusuario')
                }, 2500);
            }
            console.log(response.data);
        }
        catch(err){
            nota = 'Erro ao aprovar..';
            error(nota);
            console.log(err);
        }
    }
    
    return(
        <>
            <Navbar routes={rotausuario} />
            <h2>Aprovação de Usuário</h2>
            
             <Table columns={columns} dataSource={resultado}
             scroll={{ x: 700 }} 
             style={{width:"80%", minWidth:"200px", marginTop:"5%"}} >
            </Table>
       
        </>
    );
}

export default EditUsuario;