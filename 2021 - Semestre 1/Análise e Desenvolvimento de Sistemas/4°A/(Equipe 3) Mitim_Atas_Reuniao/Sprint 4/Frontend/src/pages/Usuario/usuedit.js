import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotausuario from '../../components/Navbar/rotausuario.json';
import { Button, Input, message, Popconfirm, Table, Modal, Form } from 'antd';
import { usuarios, delusu, ediusu } from '../../services/crudusuario';
import { useHistory } from 'react-router-dom';
import md5 from 'md5';


function EditUsuario() {

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

    const [search,setSearch] = useState('');
    const onChangeSearch = (e) => {
        const search = e.target.value;
        setSearch(search);
      };
    const history = useHistory();

    const selecionarUsr=(usr)=>{
        setUsr(usr);
        abrirModalEditar();
      }

      useEffect(() => {
        if (localStorage.getItem('usr-pass') != md5('Administrador')) {
            history.push('/editmeuperfil');
            nota = 'Sem permissão de acesso para Edição de Usuário';
            error(nota);
        }
      }, [])

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
                    <Button type="primary" onClick={() => selecionarUsr(fila)}>Editar</Button>{'   '}
                    <Popconfirm title="Tem certeza que deseja excluir este usuário?" 
                    okText="Sim" cancelText="Não" 
                    onConfirm={() => ExcluirAdm(fila)}  >
                        <Button  danger  >Excluir</Button>
                    </Popconfirm> 
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

    const { Search } = Input;
    const onSearch = (value) => {
        if(value === "" || value.trim() === ""){
            nota = "Digite algo para ser pesquisado";
            warning(nota);
        }
        else{
            Pesquisar(value);
        }
    };

    function ExcluirAdm(fila){
        if(fila.tipo == "Administrador"){
            nota = 'O Administrador não pode ser excluído';
            error(nota);
        }
        else{
            Excluir(fila);
        }
    }
    async function Excluir(fila) {

        try{
            const response = await delusu(fila.id);
            if(response.data === 'Deleted'){
                nota = 'Usuário Excluído!';
                success(nota);
                onSearch(search);
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

    async function Pesquisar(value){
        try{
            const response = await usuarios();
            setResultado(response.data.filter(function(element) {
                return element.nome.toLowerCase().includes(value.toLowerCase());
            }));
            setTimeout(() => {
                    info('Pesquisa Concluída');
                }, 500);
        }
        catch(err){
            console.log(err);
            nota = 'Erro ao acessar o Banco de Dados..';
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
            <h2>Edição de Usuário</h2>
            <Search placeholder="Buscar por nome"
             allowClear 
             onSearch={onSearch} 
             onChange={onChangeSearch}
             style={{ width: "40%", minWidth: "200px" }} 
             enterButton />
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
                    <Button type="primary" onClick={Editar}>Salvar</Button>,
                ]}
                >
            <Form >
            <Item label="Perfil">
            <select name="tipo" onChange={handleChange} defaultValue={usr.tipo} >
                <option name="tipo" value="Administrador">Administrador</option>
                <option name="tipo" value="Gerente">Gerente</option>
                <option name="tipo" value="Colaborador">Colaborador</option>
            </select>
            </Item>
            </Form>
            </Modal>       
        </>
    );
}

export default EditUsuario;