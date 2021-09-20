import React from 'react';
import { Nav } from 'rsuite';
import { FaRobot, FaClipboardList } from 'react-icons/fa';
import './style.scss';

const Header = () => {
  return (
    <Nav appearance="tabs" justified style={{ height: '50px' }}>
      <Nav.Item>
        <a href="/" className="link">
          <div className="title">
            <FaClipboardList size={20} color="gray" />
            <span className="text">Catalogo</span>
          </div>
        </a>
      </Nav.Item>
      <Nav.Item>
        <a href="/training" className="link">
          <div className="title">
            <FaRobot size={20} color="gray" />
            <span className="text">Treinamento IA</span>
          </div>
        </a>
      </Nav.Item>
    </Nav>
  );
};

export default Header;
