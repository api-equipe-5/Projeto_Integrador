import React, { useState } from 'react';
import { FlexboxGrid } from 'rsuite';
import { getCatalog as apiGetCatalog } from '../../api';
import Header from '../../Components/Header';
import SideBar from '../../Components/SideBar';
import Map from '../../Components/Map';
import ModalError from '../../Components/ModalError';
import ModalCatalog from '../../Components/ModalCatalog';
import './style.scss';

const WebGis = () => {
  const [coords, setCoords] = useState();
  const [geoJSON, setGeoJSON] = useState();
  const [modalErrorVisible, setModalErrorVisible] = useState(false);
  const [modalErrorText, setModalErrorText] = useState('');
  const [catalogVisible, setCatalogVisible] = useState(false);
  const [catalogIsLoading, setCatalogIsLoading] = useState(false);
  const [catalogData, setCatalogData] = useState({});
  const [form, setForm] = useState({});

  const normalizeBbox = (bbox) => [
    bbox.lngSW,
    bbox.latSW,
    bbox.lngNE,
    bbox.latNE,
  ];

  const prepareFilter = (data) => {
    if (!coords) {
      throw new Error('CoordsNotDefined');
    }
    if (!data.rangedate.startDate || !data.rangedate.endDate) {
      throw new Error('DateRangeNotDefined');
    }

    const bbox = normalizeBbox(coords.bbox);

    const {
      cloudCoverage: cloudCover,
      rangedate: { startDate: dateInit, endDate: dateEnd },
    } = data;
    return {
      cloudCover,
      dateInit,
      dateEnd,
      bbox,
    };
  };

  const getCatalog = async (data) => {
    try {
      setCatalogVisible(true);
      setCatalogIsLoading(true);
      const filter = prepareFilter(data);
      setForm(filter);
      const { data: response } = await apiGetCatalog(filter);
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
    const { data: response } = await apiGetCatalog({ ...form, page });
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
            title="Configurações Catálogo"
          />
        </FlexboxGrid.Item>
        <FlexboxGrid.Item colspan={18} className="col">
          <Map GetBBox={(data) => setCoords(data)} geoJSON={geoJSON} />
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
        showConfig
      />
    </div>
  );
};

export default WebGis;
