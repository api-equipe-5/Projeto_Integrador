import React, { useState, useEffect } from 'react';
import { Card, Row, Col, message } from 'antd';
import { useHistory } from 'react-router-dom';
import{ IdcardFilled, FileFilled, ProjectFilled, BookFilled } from '@ant-design/icons';
import './home.css';
import Navbar from '../../components/Navbar/navbar';
import rotausuario from '../../components/Navbar/rotausuario.json';
import rotaata from '../../components/Navbar/rotaata.json';
import rotarelatorio from '../../components/Navbar/rotarelatorio.json';
import home from '../../components/Navbar/home.json';
import { usuarios } from '../../services/crudusuario';
import md5 from 'md5';



function Home() {
    var nome = localStorage.getItem('usr-name');
    var nota;

    const info = (mensagem) => {
        message.info(mensagem);
      };
    const error = (mensagem) => {
        message.error(mensagem);
      };

    const [rota] = useState(home);
    const [resultado,setResultado] = useState();
    const history = useHistory();
    const { Meta } = Card;

    useEffect(() => {
        async function Listar(){
            const response = await usuarios();
            if(response.data.filter(function(element) {
                return element.aprovacao.includes(false);
            }) != 0 && localStorage.getItem('usr-pass') == md5('Administrador')){
                setResultado(response.data.filter(function(element) {
                    return element.aprovacao.includes(false);}).length)
                nota = 'Solicitações de aprovação pendentes: ' + (response.data.filter(function(element) {
                    return element.aprovacao.includes(false);}).length);
                info(nota);
            }
        }
        Listar();
    },[])

    async function handleDepartment(rota){
        switch(rota[1].path){
            case '/editusuario':
                if(localStorage.getItem('usr-pass') === md5('Administrador')){
                    history.push(rota[1].path);
                }
                else{
                    rota = home;
                    nota = 'Acesso permitido somente ao Administrador';
                    error(nota);   
                }
                break;
            case '/criata':
                history.push(rota[1].path);
                break;
            case '/atasger':
                if(localStorage.getItem('usr-pass') === md5('Colaborador')){
                    rota = home;
                    nota = 'Sem permissão de acesso para Relatórios';
                    error(nota);
                }
                else{
                    history.push(rota[1].path);   
                }
                break;
        }
    }
    
    return(
        <>
        <Navbar routes={rota} />
        <h3>Bem-vindo, {nome}!</h3>
        <Row>
            <Col>
            <Card
            hoverable
            className="panel-options"
            onClick={() => handleDepartment(rotausuario)}
            cover={<IdcardFilled className="site-form-item-ico" />}
            >
                <Meta title="USUÁRIOS" />
            </Card>
            </Col>
            <Col>
            <Card
            hoverable
            className="panel-options"
            onClick={() => handleDepartment(rotaata)}
            cover={<FileFilled className="site-form-item-ico" />}
            >
                <Meta title="ATAS" />
            </Card>
            </Col>
        </Row>
        <Row>
            <Col>
            <Card
            hoverable
            className="panel-options"
            onClick={() => handleDepartment(rotarelatorio)}
            cover={<ProjectFilled className="site-form-item-ico" />}
            >
                <Meta title="RELATÓRIOS" />
            </Card>
            </Col>
            <Col>
            <Card
            hoverable
            className="panel-options"
            cover={<BookFilled className="site-form-item-ico" />}
            >
                <Meta title="MANUAL DO USUÁRIO" />
            </Card >
            </Col>
        </Row>
        </>
    )
}
export default Home;