import React, { Component } from 'react';
import PDF from './PDF';
import "../assets/css/style.css"
import Menu from '../pages/Menu'

class Post extends Component {
    state = {
        projeto: '', pauta: '', data_inicio: '', data_fim: '', hora_inicio: '', hora_fim: '', local: '',
         participante: '', area: '', email: '', telefone: '',
        assunto: '', responsavel: '', prazo: '', distribuicao: '',
         representante: '', nome: '', assinatura: '',
        postSubmitted: false
    }

    onChange = input => e => {
        this.setState({
            [input]: e.target.value
        });
    }

    sunmitPost = (e) => {
        
        if(!this.state.assinatura || !this.state.assunto){
            alert('All fields are required!');
            e.preventDefault();
        }else{
            this.setState({
                postSubmitted: true
            });
        }
    }

    render(){
        return(
            <>
            
            <div className="container">
                {  !this.state.postSubmitted ? 
                    (
                            // <Menu />


                            <div className="card shadow" style={{margin:'5%'}} onSubmit={this.sunmitPost}>
                <div className="card-header">
                    <h4>Formulário <small>da ATA</small></h4>        
                </div>
                <div className="card-body">
                    <form>                       
                        
                           
                                <div className="form-group row">
                                    <div class="col-2">Tema da Reunião:</div>
                                    <div class="col-4">
                                        <input type="text" class="form-control" name="projeto" onChange={this.onChange('projeto')} />       
                                    </div>  
                                    <div class="col-2">Pauta da Reunião:</div>
                                    <div class="col-4">
                                        <input type="text" class="form-control" name="pauta" onChange={this.onChange('pauta')} />       
                                    </div>  
                                </div> 
                                <div className="form-group row">
                                    <div class="col-2">Data:</div>
                                    <div class="col-2">
                                        <input type="date" class="form-control" name="dataInicio" placeholder="Inicio" onChange={this.onChange('data_inicio')} />       
                                    </div>  
                                    <div class="col-2">
                                        <input type="date" class="form-control" name="dataFim" placeholder="Fim" onChange={this.onChange('data_fim')} />       
                                    </div>  

                                    <div class="col-2">Horário:</div>
                                    <div class="col-2">
                                        <input type="time" class="form-control" name="horaInicio" placeholder="Início" onChange={this.onChange('hora_inicio')} />       
                                    </div>  
                                    <div class="col-2">
                                        <input type="time" class="form-control" name="horaFim" placeholder="Fim" onChange={this.onChange('hora_fim')} />       
                                    </div> 
                                </div>
                                <div className="form-group row">
                                    <div class="col-2">Local da Reunião:</div>
                                    <div class="col-4">
                                        <input type="text" class="form-control" name="local" onChange={this.onChange('local')} />       
                                    </div>                    
                                </div>
                        
                        
                    </form>                                       
                </div>

                <div class="alert alert-danger" role="alert">
                    Todos os campos abaixo devem ser preenchidos da seguinte forma:
                    <b> Item1, Item2, Item3...</b> 
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Adicionar Participantes</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            
                               
                                    <div className="form-group row">                                      
                                        <div class="col-3">
                                            <textarea type="text" class="form-control" name="participante" placeholder="Participante1, Participante2..." onChange={this.onChange('participante')} />       
                                        </div> 
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="area" placeholder="Área1, Área2..." onChange={this.onChange('area')} />       
                                        </div>
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="email" placeholder="E-mail1, E-mail2..." onChange={this.onChange('email')} />       
                                        </div> 
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="telefone" placeholder="Telefone1, Telefone2" onChange={this.onChange('telefone')} />       
                                        </div>                                     
                                    </div>             
                                
                                                                                                                   
                        </form>
                    </div>
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Adicionar Assunto</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                           
                                
                                    <div className="form-group row">                                      
                                        <div class="col">
                                            <textarea class="form-control" name="assunto" placeholder="Assunto1, Assunto2" onChange={this.onChange('assunto')} />       
                                        </div>
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="responsavel" placeholder="Responsável1, Responsável2" onChange={this.onChange('responsavel')} />       
                                        </div> 
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="prazo" placeholder="Prazo1, Prazo2" onChange={this.onChange('prazo')} />       
                                        </div> 
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="distribuicao" placeholder="Distribuição1, Distribuição2" onChange={this.onChange('distribuicao')} />       
                                        </div>              
                                    </div>             
                                
                                                                                                                    
                        </form>
                    </div>    
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Assinaturas</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            
                                
                                    <div className="form-group row">                                      
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="representante" placeholder="Representante1, Representante2" onChange={this.onChange('representante')} />       
                                        </div> 
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="nome" placeholder="Nome1, Nome2" onChange={this.onChange('nome')} />       
                                        </div> 
                                        <div class="col">
                                            <textarea type="text" class="form-control" name="assinatura" placeholder="Assinatura, Assinatura2" onChange={this.onChange('assinatura')} />       
                                        </div>             
                                    </div>             
                                
                                                                                                       
                        </form>
                    </div>    
                </div>

                <div className="card-body">
                    <div class="row justify-content-center align-items-center">
                        <button className='btn btn-success' onClick={this.sunmitPost}>Cadastrar</button>
                    </div>     
                </div>
            </div>

                    ) : (
                        <PDF projeto={this.state.projeto} pauta={this.state.pauta} data_inicio={this.state.data_inicio}
                        data_fim={this.state.data_fim} data_inicio={this.state.data_inicio} hora_inicio={this.state.hora_inicio}
                        hora_fim={this.state.hora_fim} local={this.state.local} participante={this.state.participante}
                        area={this.state.area} email={this.state.email} telefone={this.state.telefone}
                        assunto={this.state.assunto} responsavel={this.state.responsavel} prazo={this.state.prazo}
                        distribuicao={this.state.distribuicao} representante={this.state.representante} nome={this.state.nome}
                        assinatura={this.state.assinatura}
                        />
                    )
                }
                </div>
            </>
        );
    }
}

export default Post;



