import React, { useState } from 'react';
import { Modal, Button } from 'rsuite';
import { BsCloudUpload } from 'react-icons/bs';
import Dropzone from '../Dropzone';

const ModalGeoJSON = (props) => {
  const [modalState, setModalState] = useState(false);
  const [file, setFile] = useState(null);
  const { onClose = () => {} } = props;
  const handleModalClose = () => {
    onClose(file);
  };

  const closeModal = () => {
    setModalState(false);
    handleModalClose();
  };

  const closeAndRemoveFile = () => {
    setFile(null);
    closeModal();
  };

  const onGetFile = (fileArray) => {
    if (fileArray && fileArray.length) {
      setFile(fileArray[0]);
    } else {
      setFile(null);
    }
  };
  return (
    <div className="upload">
      <div className="title-container">
        <span className="title">Área de interesse por upload de arquivo:</span>
      </div>
      <div
        style={{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
        }}
      >
        <BsCloudUpload size={25} style={{ marginRight: 10 }} />
        <Button
          color="blue"
          appearance="ghost"
          onClick={() => setModalState(true)}
        >
          Importar GeoJSON
        </Button>
      </div>
      <Modal show={modalState} onHide={closeAndRemoveFile}>
        <Modal.Header>
          <Modal.Title>Selecione um GeoJSON</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Dropzone
            onGetFile={onGetFile}
            mimeTypes={['application/geo+json', 'application/json']}
          />
        </Modal.Body>
        <Modal.Footer>
          <Button appearance="subtle" onClick={closeAndRemoveFile}>
            Cancel
          </Button>
          <Button appearance="primary" onClick={closeModal}>
            Ok
          </Button>
        </Modal.Footer>
      </Modal>
      <div className="border" />
    </div>
  );
};

export default ModalGeoJSON;
