import { Col, Menu, Row, Input } from 'antd';
import React from 'react';
import { useHistory } from 'react-router-dom';
import { useAuth } from '~/hooks/AuthContext';

import Logo from '../../assets/logo.svg';
import UserMenu from '../UserMenu';

const colStyle = {
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
};
const { Search } = Input;
const { SubMenu } = Menu;

export default function PrivateNavbar() {
  const history = useHistory();
  const { user } = useAuth();

  return (
    <Row aling="middle" justify="center">
      <Col span="2" />
      <Col span="3" style={colStyle}>
        <img src={Logo} alt="Logo" />
      </Col>
      {user.isStudent === 'aluno' ? (
        <>
          <Col span="3" style={colStyle}>
            <Menu mode="horizontal">
              <SubMenu key="SubMenu" title=" Categorias">
                <Menu.Item key="bio">Biologia</Menu.Item>
                <Menu.Item key="math">Matemática</Menu.Item>
                <Menu.Item key="tech">Tecnologia</Menu.Item>
              </SubMenu>
            </Menu>
          </Col>
          <Col span="6" style={colStyle}>
            <Search
              placeholder="O que você quer aprender?"
              style={{ width: '80%' }}
            />
          </Col>
          <Col span="4" style={colStyle}>
            <Menu mode="horizontal">
              <Menu.Item key="Classes">Meus Cursos</Menu.Item>
            </Menu>
          </Col>
        </>
      ) : (
        <Col span="13" style={colStyle}>
          <Menu
            defaultSelectedKeys={window.location.pathname}
            mode="horizontal"
          >
            <Menu.Item
              key="/dashboard"
              onClick={() => history.push('/dashboard')}
            >
              Meus Cursos
            </Menu.Item>
            <Menu.Item
              key="/newClass"
              onClick={() => history.push('/newClass')}
            >
              Criar Novo Curso
            </Menu.Item>
          </Menu>
        </Col>
      )}

      <Col span="4" style={colStyle}>
        <UserMenu />
      </Col>
      <Col span="2" />
    </Row>
  );
}
