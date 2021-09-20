import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from 'axios'
import imagens from "../assets/images/logo.png"

class Login extends Component {
  state = {
    email: "",
    senha: "",
    nome: "",
    perfil: "",
  };

  handleLogin = async e => {
    e.preventDefault();
    const { email, senha } = this.state;
    if (!email || !senha) {
      this.setState({ error: "Preencha e-mail e senha para continuar!" });
    } else {
      try {
        const response = await axios.post("http://localhost:8080/auth", { email, senha });

        const {token, nome, perfil} = response.data;

        localStorage.setItem('token', token);
        localStorage.setItem('nome', JSON.stringify(nome));
        localStorage.setItem('perfil', JSON.stringify(perfil));

        this.props.history.push("/Index");
      } catch (err) {
        this.setState(
          alert("E-mail e/ou senha inválidos")
        );
      }
    }
  };

  render() {
    return (
        <div className="container shadow">
            <div className="row no-gutter centered">   
            {/*aqui vem a parte esquerda*/}
            <div className="col-md-7 bg-esquerda">
                <div className="login d-none d-md-flex align-items-center py-5">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-10 col-xl-8 mx-auto welcome">
                                <form>
                                    <div className="mb-3">
                                      <img src={imagens} height="100%" width="100%"/>
                                    </div>
                                    <div className="mb-3">
                                      <p className="welcomeEA">Seja bem vindo ao EasyATA!</p>
                                    </div>
                                </form>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
            {/*aqui vem a parte direita*/}
            <div className="col-md-5" style={{background:"#F0F1F3"}}>
                <div className="login d-flex align-items-center py-5">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-10 col-xl-8 mx-auto">
                                <div className="mb-5 text-center">
                                    <p className="tituloAutenticacao">Login</p>
                                </div>
                                <form onSubmit={this.handleLogin}>
                                    <div className="form-group mb-4">
                                      <input id="email" type="email" placeholder="Email" className="form-control"
                                      
                                      onChange={e => this.setState({ email: e.target.value })}   
                                      />
                                    </div>
                                    <div className="form-group mb-2">
                                      <input id="senha" type="password" placeholder="Senha" className="form-control" 
                                
                                      onChange={e => this.setState({ senha: e.target.value })}
                                      />
                                    </div>
                                    <div className="custom-control custom-checkbox mb-4">
                                      {/* <a href="#" style={{float:"right", fontSize:"12px"}}>Esqueceu a senha?</a> */}
                                    </div>
                                    <button type="submit" className="btn btn-primary btn-block">Entrar</button>
                                  
                                    <div className="sign-up">
                                      Não Possui uma conta? <Link to="/cadastro">Cadastre-se!</Link>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
    </div>   
    )
  }
}

export default Login;