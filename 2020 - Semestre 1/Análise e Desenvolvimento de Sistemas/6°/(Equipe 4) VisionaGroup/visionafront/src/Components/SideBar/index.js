import React, { useState } from 'react';
import { DiAptana } from 'react-icons/di';
import { Button, Sidenav, Nav } from 'rsuite';
import ModalGeoJSON from './modalGeoJSON';
import CloudCoverage from './cloudCoverage';
import Date from './date';
import './style.scss';

const SideBar = (props) => {
  const [cloud, setCloud] = useState(50);
  const [rangedate, setDate] = useState({});
  const { onClickButton = () => {}, onReceiveGeoJSON = () => {} } = props;
  const data = {
    cloudCoverage: cloud,
    rangedate,
  };

  const { title } = props;

  function getSideBarData() {
    onClickButton(data);
  }

  return (
    <div className="container-nav">
      <Sidenav defaultOpenKeys={['3', '4']} style={{ height: '100%' }}>
        <Sidenav.Header className="nav-header">
          <DiAptana size={30} />
          <span className="title">{title}</span>
        </Sidenav.Header>
        <Sidenav.Body className="nav-body">
          <Nav className="nav">
            <Date RangeDate={(date) => setDate(date)} />
          </Nav>
          <hr />
          <Nav className="nav">
            <CloudCoverage CloudChange={(e) => setCloud(e)} />
          </Nav>
          <hr />
          <Nav className="nav">
            <ModalGeoJSON
              onClose={(f) => {
                if (f) {
                  onReceiveGeoJSON(f);
                }
              }}
            />
          </Nav>
          <hr />
          <Nav className="nav">
            <div className="button">
              <Button size="lg" onClick={getSideBarData} appearance="primary">
                Verificar catálogo
              </Button>
            </div>
          </Nav>
        </Sidenav.Body>
      </Sidenav>
    </div>
  );
};

export default SideBar;
