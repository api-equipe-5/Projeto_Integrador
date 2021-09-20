import React from 'react';
import globo from './Globo_Atual.png';
import {Col} from 'react-bootstrap';
import {Row} from 'react-bootstrap';
import {Form} from 'react-bootstrap';
import {Button} from 'react-bootstrap';
import logo from './Logo Real.png';
import './css/Logon.css';

//<img src={logo} style={{marginBottom:"100px",marginTop:"50px"}}/>

const Formlogon = () => (


    <formlogon style={{backgroundColor:"#EDEDED",height:"789px",width:"500px"}} class="mh-100">
        
      <Form style={{height:"100%"}}>
          <img src={logo} style={{marginBottom:"10px",marginTop:"50px"}}/>
          <Form.Text style={{color:"grey",marginBottom:"80px"}}>
      Análise de Dados Espaciais
    </Form.Text>
  <Form.Group controlId="formGroupEmail" style={{textAlign:"left",marginLeft:"100px"}}>
    <Form.Label>Email:</Form.Label>
    <Form.Control type="email" placeholder="Digite seu Email" style={{width:"298px"}}/>
  </Form.Group>
  <Form.Group controlId="formGroupPassword" style={{textAlign:"left",marginLeft:"100px"}}>
    <Form.Label>Senha:</Form.Label>
    <Form.Control type="password" placeholder="Digite sua Senha" style={{width:"298px"}}/>
  </Form.Group>
  <Button variant="primary" type="submit" style={{backgroundColor:"rgb(255, 115, 0)",width:"298px",marginTop:"70px"}}>
   <strong>Entrar</strong>
  </Button>
  <Form.Text style={{color:"darkGrey", marginTop:"20px"}}>
      Não possui uma conta?   <a href="#login" style={{color:"rgb(255, 115, 0)"}}>Cadastrar</a>
    </Form.Text>
    <Form.Text style={{ marginTop:"70px",textAlign:"left",marginLeft:"100px"}}>
     <a href="#login" style={{color:"grey"}}>Sobre o Sistema</a>
    </Form.Text>
</Form>



    </formlogon>
);
export default Formlogon;