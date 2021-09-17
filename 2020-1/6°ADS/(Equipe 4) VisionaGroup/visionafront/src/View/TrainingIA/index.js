import React, { useState } from 'react';
import { FlexboxGrid } from 'rsuite';
import { postCatalog, postIds } from '../../api';
import Header from '../../Components/Header';
import SideBar from '../../Components/SideBar';
import Map from '../../Components/Map';
import ModalError from '../../Components/ModalError';
import ModalCatalog from '../../Components/ModalCatalog';
import './style.scss';

const TrainingIA = () => {
  const [polygon, setPolygon] = useState();
  const [geoJSON, setGeoJSON] = useState();
  const [modalErrorVisible, setModalErrorVisible] = useState(false);
  const [modalErrorText, setModalErrorText] = useState('');
  const [catalogVisible, setCatalogVisible] = useState('');
  const [catalogIsLoading, setCatalogIsLoading] = useState(false);
  const [catalogData, setCatalogData] = useState({});
  const [form, setForm] = useState({});

  const saveIds = async (ids) => {
    const listIds = ids.map((id) => ({
      id_scene: id[0],
      satellite_name: id[1],
    }));
    const { cloudCover, dateInit, dateEnd } = form;
    const { data: response } = await postIds({
      cloudCover,
      dateInit,
      dateEnd,
      listIds,
    });
    console.log(response);
  };

  const prepareFilter = (data) => {
    if (!polygon) {
      throw new Error('PolygonNotDefined');
    }
    if (!data.rangedate.startDate || !data.rangedate.endDate) {
      throw new Error('DateRangeNotDefined');
    }

    const {
      cloudCoverage: cloudCover,
      rangedate: { startDate: dateInit, endDate: dateEnd },
    } = data;

    return {
      cloudCover,
      dateInit,
      dateEnd,
      geojson: polygon,
    };
  };

  const getCatalog = async (data) => {
    try {
      setCatalogVisible(true);
      setCatalogIsLoading(true);
      const filter = prepareFilter(data);
      setForm(filter);
      console.log(filter);
      const { data: response } = await postCatalog(filter);
      setCatalogData(response);
      setCatalogIsLoading(false);
    } catch (error) {
      setCatalogVisible(false);
      if (error.message === 'DateRangeNotDefined') {
        setModalErrorText('Série de datas não definido');
      } else if (error.message === 'CoordsNotDefined') {
        setModalErrorText('Area de interesse não definida');
      } else {
        setModalErrorText('Erro interno tente novamente mais tarde');
      }
      setModalErrorVisible(true);
    }
  };

  const handlePagination = async (page) => {
    setCatalogIsLoading(true);
    const { data: response } = await postCatalog({ ...form, page });
    setCatalogData(response);
    setCatalogIsLoading(false);
  };

  const geoJSONFileToGeoJSON = (file) => {
    const reader = new FileReader();
    reader.readAsText(file);
    reader.addEventListener('loadend', () => {
      setGeoJSON(JSON.parse(reader.result));
    });
  };

  return (
    <div className="container">
      <Header />
      <FlexboxGrid style={{ height: '100%', margin: 0 }}>
        <FlexboxGrid.Item colspan={6} className="col">
          <SideBar
            onClickButton={getCatalog}
            onReceiveGeoJSON={geoJSONFileToGeoJSON}
            title="Treinamento IA"
          />
        </FlexboxGrid.Item>
        <FlexboxGrid.Item colspan={18} className="col">
          <Map geoJSON={geoJSON} onChangeGeoJSON={(data) => setPolygon(data)} />
        </FlexboxGrid.Item>
      </FlexboxGrid>
      <ModalError
        isVisible={modalErrorVisible}
        onClose={() => setModalErrorVisible(false)}
        text={modalErrorText}
      />
      <ModalCatalog
        isVisible={catalogVisible}
        isLoading={catalogIsLoading}
        catalog={catalogData}
        SetPagination={handlePagination}
        onClose={() => setCatalogVisible(false)}
        onSave={saveIds}
      />
    </div>
  );
};

export default TrainingIA;
