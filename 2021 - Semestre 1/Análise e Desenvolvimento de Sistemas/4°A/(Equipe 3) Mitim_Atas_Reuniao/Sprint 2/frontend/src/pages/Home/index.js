import React, { useState } from 'react';
import { Card, Row, Col, message } from 'antd';
import { useHistory } from 'react-router-dom';
import{ IdcardFilled, FileFilled, ProjectFilled, BookFilled } from '@ant-design/icons';
import './home.css';
import Navbar from '../../components/Navbar/navbar';
import rotausuario from '../../components/Navbar/rotausuario.json';
import rotaata from '../../components/Navbar/rotaata.json';
import rotarelatorio from '../../components/Navbar/rotarelatorio.json';
import home from '../../components/Navbar/home.json';
import md5 from 'md5';



function Home() {
    var nome = localStorage.getItem('usr-name');
    var nota;
    const error = (mensagem) => {
        message.error(mensagem);
      };

    const [rota] = useState(home);
    const history = useHistory();
    const { Meta } = Card;

    async function handleDepartment(rota){
        switch(rota[1].path){
            case '/cadusuario':
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
                history.push(rota[1].path);
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