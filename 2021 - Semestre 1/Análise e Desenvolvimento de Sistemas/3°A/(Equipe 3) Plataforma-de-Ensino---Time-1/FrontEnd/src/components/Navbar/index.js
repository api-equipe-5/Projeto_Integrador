import React, { useState } from 'react';

import { Menu, Button, Row, Col } from 'antd';

import { Link } from 'react-router-dom';

import { FiHome, FiPhone, FiUsers, FiHelpCircle } from 'react-icons/fi';

import Logo from '../../assets/logo.svg';

const colStyle = {
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
};

export function Navbar() {
  const [current, setCurrent] = useState('home');

  function handleMenuClick(e) {
    setCurrent(e.key);
  }

  return (
    <Row>
      <Col span="2" />
      <Col span="3" style={colStyle}>
        <img src={Logo} alt="Logo" />
      </Col>
      <Col span="13">
        <Menu
          onClick={handleMenuClick}
          selectedKeys={[current]}
          mode="horizontal"
        >
          <Menu.Item key="home" icon={<FiHome />}>
            Home
          </Menu.Item>

          <Menu.Item key="sobre" icon={<FiHelpCircle />}>
            Sobre
          </Menu.Item>

          <Menu.Item key="quem somos" icon={<FiUsers />}>
            Quem Somos?
          </Menu.Item>

          <Menu.Item key="contato" icon={<FiPhone />}>
            Contato
          </Menu.Item>
        </Menu>
      </Col>
      <Col span="4">
        <Button type="link">
          <Link to="/signin">Entrar</Link>
        </Button>

        <Button type="primary">
          <Link to="/signup">Cadastrar</Link>
        </Button>
      </Col>
      <Col span="2" />
    </Row>
  );
}
