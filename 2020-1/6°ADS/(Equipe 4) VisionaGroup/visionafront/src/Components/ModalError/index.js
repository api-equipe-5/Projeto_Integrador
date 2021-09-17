import React from 'react';
import { Modal, Button } from 'rsuite';

const ModalError = (props) => {
  const { onClose = () => {}, isVisible = false, text = '' } = props;
  return (
    <Modal show={isVisible}>
      <Modal.Header>
        <h3>Atenção</h3>
      </Modal.Header>
      <Modal.Body>{text}</Modal.Body>
      <Modal.Footer>
        <Button onClick={onClose} color="red">
          Entendido
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default ModalError;
