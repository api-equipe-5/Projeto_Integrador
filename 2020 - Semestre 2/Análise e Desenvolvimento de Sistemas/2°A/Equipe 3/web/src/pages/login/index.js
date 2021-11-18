import React,{useState} from 'react';
import './index.css';
import { Link, useHistory } from 'react-router-dom';
import api from '../../services/api';

function LoginPage(){

    const [login,setLogin]=useState();
    const [senha,setSenha]=useState();

    const hist = useHistory();

    async function handleLogin(e){
        e.preventDefault();
        var data = {
            login:login,
            senha:senha
        }
        await api.post("/session",data)
        .then((res)=>{
            localStorage.setItem("token", res.data.Token);
            localStorage.setItem("id",res.data.Id);
            localStorage.setItem("role",res.data.Role);
            alert("Bem-vindo");
            hist.push("/dashboard");
        })
        .catch((err)=>alert("Login/Senha inválidos"))
    }

    return(
        <div className="login">
            <div className="loginBox">
                <form onSubmit={handleLogin}>
                    <div>
                        <label>Login:</label>
                        <input type="text" value={login} onChange={(e)=>setLogin(e.target.value)}/>
                    </div>
                    <div>
                        <label>Senha:</label>
                        <input type="password" value={senha} onChange={(e)=>setSenha(e.target.value)}/>
                    </div>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    );
}

export default LoginPage;