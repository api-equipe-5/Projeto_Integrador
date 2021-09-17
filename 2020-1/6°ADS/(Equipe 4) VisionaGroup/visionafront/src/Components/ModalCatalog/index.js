import React, { useState } from 'react';
import {
  Modal,
  Button,
  Placeholder,
  PanelGroup,
  Panel,
  Tag,
  FlexboxGrid,
  Checkbox,
} from 'rsuite';
import { FaCloud, FaExternalLinkAlt } from 'react-icons/fa';
import { MdDateRange } from 'react-icons/md';
import { BsCaretRightFill, BsCaretLeftFill } from 'react-icons/bs';

import './style.scss';

const BANDS_NAMES = ['B02', 'B03', 'B04', 'B08'];
const { REACT_APP_API_URL } = process.env;

const ModalCatalog = (props) => {
  const [configSattelite, setConfigSatellite] = useState();
  const [ids] = useState([]);
  const { SetPagination = () => {}, showConfig } = props;
  const {
    onClose = () => {},
    isVisible = false,
    isLoading = false,
    catalog = {},
    onSave = () => {},
  } = props;

  async function getIdSatellite(value) {
    const id = value.split(',');
    ids.push(id);
    const unique = [...new Set(ids)];
    await setConfigSatellite(unique);
  }

  function handleClose() {
    onClose();
  }

  function handleSave() {
    handleClose();
    onSave(configSattelite);
  }

  const catalogList = () =>
    catalog.list && (
      <PanelGroup>
        {catalog.list.map((c) => (
          <Panel
            header={
              <span>
                {c.id}&nbsp;<Tag>{c.collection}</Tag>
              </span>
            }
          >
            <p>
              <FaCloud />
              &nbsp;{c.cloudCover}%
            </p>
            <p>
              <MdDateRange />
              &nbsp;
              {new Date(c.datetime).toLocaleString()}
            </p>
            <p>
              <a href={c.thumbnail} target="_blank" rel="noopener noreferrer">
                <FaExternalLinkAlt />
                &nbsp;
                {c.thumbnail}
              </a>
            </p>
            <p>
              <strong>Downloads</strong>
            </p>
            {BANDS_NAMES.map((band) => (
              <p>
                <a
                  target="_blank"
                  rel="noopener noreferrer"
                  href={`${REACT_APP_API_URL}api/v1/catalog/${c.collection}/${c.id}/${band}`}
                >
                  {`${REACT_APP_API_URL}api/v1/catalog/${c.collection}/${c.id}/${band}`}
                </a>
              </p>
            ))}
          </Panel>
        ))}
      </PanelGroup>
    );

  const Preview = () =>
    catalog.list && (
      <PanelGroup>
        {catalog.list.map((c) => (
          <FlexboxGrid style={{ height: '100%', margin: 0 }}>
            <FlexboxGrid.Item colspan={20} className="col">
              <Panel
                header={
                  <span>
                    <p>
                      Satélite: <span>{c.collection}</span>
                    </p>
                  </span>
                }
              >
                <p>
                  <span>
                    <FaCloud />
                    <span> Cobertura de nuvem: </span>
                    {c.cloudCover}%
                  </span>
                </p>
                <p>
                  <span>
                    <MdDateRange />
                    <span> Imagem registrada dia: </span>
                    {new Date(c.datetime).toLocaleString()}
                  </span>
                </p>
                <p>
                  <span>Link para visualizar: </span>
                  <a
                    href={c.thumbnail}
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    <FaExternalLinkAlt />
                    {c.thumbnail}
                  </a>
                </p>
              </Panel>
            </FlexboxGrid.Item>
            <FlexboxGrid.Item colspan={4} className="col">
              <div
                style={{
                  height: '100%',
                  minHeight: '150px',
                  display: 'flex',
                  alignItems: 'center',
                  justifyContent: 'center',
                }}
              >
                <Checkbox
                  onChange={(value) => getIdSatellite(value)}
                  value={`${c.id}, ${c.collection}`}
                />
              </div>
            </FlexboxGrid.Item>
          </FlexboxGrid>
        ))}
      </PanelGroup>
    );

  function next() {
    SetPagination(
      Math.min(catalog.pagination.page + 1, catalog.pagination.pages)
    );
  }

  function prev() {
    SetPagination(Math.max(catalog.pagination.page - 1, 1));
  }

  function Pagination() {
    return (
      <div style={{ display: 'flex', alignItems: 'center' }}>
        <span style={{ marginRight: 10 }}> Página: </span>

        <div style={{ width: '115px', display: 'flex', alignItems: 'center' }}>
          <Button onClick={prev}>
            <BsCaretLeftFill />
          </Button>
          <div
            style={{
              marginLeft: '5px',
              marginRight: '5px',
              backgroundColor: 'gray',
              width: '30px',
              height: '30px',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              borderRadius: '20px',
            }}
          >
            <span style={{ color: 'white' }}>
              {catalog.pagination && catalog.pagination.page}
            </span>
          </div>
          <Button size="lg" onClick={next}>
            <BsCaretRightFill />
          </Button>
        </div>
      </div>
    );
  }

  function ShowCatalogOrPreview() {
    if (showConfig) {
      return catalogList();
    }

    return Preview();
  }

  return (
    <Modal show={isVisible} onHide={onClose} className="modal-container">
      <Modal.Header className="header">
        <p>
          {showConfig
            ? 'Catálogo de imagens'
            : 'Lista de imagens dos Satélites'}
        </p>
      </Modal.Header>
      <Modal.Body>
        <p>
          {!showConfig
            ? 'Selecione somente uma das imagens para ser enviado ao treinamento'
            : null}
        </p>
        {isLoading ? (
          <Placeholder.Paragraph rows={5} />
        ) : (
          ShowCatalogOrPreview()
        )}
      </Modal.Body>
      <Modal.Footer
        style={{ display: 'flex', justifyContent: 'space-between' }}
      >
        {Pagination()}
        <Button onClick={handleSave} color="green">
          Ok
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default ModalCatalog;
