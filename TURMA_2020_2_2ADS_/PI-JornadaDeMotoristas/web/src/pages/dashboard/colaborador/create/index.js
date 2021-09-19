import React,{useState} from 'react';
import './index.css';
import { FaArrowLeft } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import InputMask from 'react-input-mask';
import Sidenav from '../../../../components/sidenav/index';
import Header from '../../../../components/header/index';
import api from './../../../../services/api'
import {useHistory} from 'react-router-dom'

function CreateColaborador(){

    const hist = useHistory();
    const [nome,setNome]=useState();
    const [cpf,setCpf]=useState();
    const [email,setEmail]=useState();
    const [matricula,setMatricula]=useState();
    const [telefone,setTelefone]=useState();
    const [endereco,setEndereco]=useState();
    const [login,setLogin]=useState();
    const [senha,setSenha]=useState();
    const [confirmaSenha,setConfirmaSenha]=useState();
    const [cargo,setCargo]=useState(1);

    var inputRules = {
        '9': '[0-9]','a': '[A-Za-z]','*': '[A-Za-z0-9]'
    }


    async function handleSubmit(e){
        e.preventDefault();
        if(senha==confirmaSenha){
            try{
                const user = {
                    matricula:matricula,
                    cpf:cpf,
                    email:email,
                    endereco:endereco,
                    login:login,
                    nome:nome,
                    senha:senha,
                    telefone:telefone,
                    roles: [{
                        id: Number(cargo)
                    }]
                }

                console.log(user);
    
                
                await api.post("/user",user,{
                    headers:{
                        "Authorization":"Bearer "+localStorage.getItem("token")
                    }
                })
                alert("Novo "+cargo+" cadastrado");
                hist.push("/dashboard/colaborador")
                
            }catch(err){
                console.log(err);
            }
        }
        else{
            alert("As senha não se coincidem!")
        }

    }

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Colaboradores"/>
                <div className="main">
                    <div className="createColaborador">
                        <section>
                            <Link to="/dashboard/colaborador">
                                <FaArrowLeft/>&nbsp;Voltar
                            </Link>
                        </section>
                        <form onSubmit={handleSubmit}>
                            <div>
                                <label>Matrícula</label>
                                <input type="number" value={matricula} onChange={e => setMatricula(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Nome</label>
                                <input type="text" value={nome} onChange={e => setNome(e.target.value)} required/>
                            </div>
                            <div>
                                <label>CPF</label>
                                <InputMask type="text" mask="999.999.999-99" formatChars={inputRules} value={cpf} onChange={e => setCpf(e.target.value)} required/>
                            </div>
                            <div>
                                <label>E-mail</label>
                                <input type="email" value={email} onChange={e => setEmail(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Celular</label>
                                <InputMask type="text" mask="(99) 99999-9999" formatChars={inputRules} value={telefone} onChange={e => setTelefone(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Endereço</label>
                                <input type="text" value={endereco} onChange={e => setEndereco(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Cargo</label>
                                <select type="text" value={cargo} onChange={e => setCargo(e.target.value)} required>
                                    <option value="1" defaultValue>Administrador</option>
                                    <option value="2">Financeiro</option>
                                    <option value="3">Gerente</option>
                                    <option value="4">Motorista</option>
                                </select>
                            </div>
                            <div>
                                <label>Login</label>
                                <input type="text" value={login} onChange={e => setLogin(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Senha</label>
                                <input type="password" value={senha} onChange={e => setSenha(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Confirmar senha</label>
                                <input type="password" value={confirmaSenha} onChange={e => setConfirmaSenha(e.target.value)} required/>
                            </div>
                            <button type="submit">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CreateColaborador