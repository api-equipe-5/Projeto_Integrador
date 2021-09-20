import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';
import { DashboardContainer } from './styles';

import Acess from './components/Acess';
import UploadComponent from './components/UploadComponent';
import DownloadTables from './components/DownloadTables';

import LogoHeader from '../../assets/images/Logo-white-bg.png';

function Dashboard() {
  const [fields, setFields] = useState([]);
  const [tables, setTables] = useState([]);
  const [screen, setScreen] = useState('main');

  const history = useHistory();

  const [tableFromDatabase, setTableFromDatabase] = useState([]);

  const handleSearchTables = () => {
    api.post('/searchTables', {token: localStorage.getItem('token')}).then((response) => {
      setTableFromDatabase(response.data);
    });
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
    sessionStorage.removeItem('isConnected');
    history.push('/');
  }

  // eslint-disable-next-line consistent-return
  const renderScreens = (toScreen) => {
    switch (toScreen) {
      case 'main':

        return (
          <Acess 
            setFields={setFields} 
            setTables={setTables} 
            changeScreen={setScreen} 
            searchTables={handleSearchTables}
          />
        );

      case 'upload':

        return (
          <UploadComponent fields={fields} tables={tables} />
        );

      case 'download':

        return (
          <DownloadTables tables={tableFromDatabase} />
        );

      default:
        break;
    }
  };

  return (
    <>
      <DashboardContainer>
        <header>
          <img
            src={LogoHeader}
            alt="VisGeo"
            className="logo-header"
            onClick={() => setScreen('main')}
          />

          <button 
            className="exit"
            onClick={handleLogout}
          >
            SAIR
          </button>

        </header>

        {
          renderScreens(screen)
        }

      </DashboardContainer>
    </>
  );
}

export default Dashboard;
