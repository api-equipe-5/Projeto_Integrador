/* eslint-disable react/prop-types */
/* eslint-disable react/destructuring-assignment */
import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';

const useStyles = makeStyles((theme) => ({
  root: {
    height: 300,
    flexGrow: 1,
    minWidth: 300,
    transform: 'translateZ(0)',
    '@media all and (-ms-high-contrast: none)': {
      display: 'none'
    }
  },
  modal: {
    display: 'flex',
    padding: theme.spacing(1),
    alignItems: 'center',
    justifyContent: 'center'
  },
  paper: {
    width: 400,
    height: 500,
    backgroundColor: theme.palette.background.paper,
    borderRadius: 5,
    boxShadow: theme.shadows[5],
    padding: theme.spacing(2, 4, 3),
    zIndex: 9
  }
}));

const FormModal = (props) => {
  const classes = useStyles();
  const rootRef = React.useRef(null);

  const [modalState, setModalState] = useState(props.modalState);

  return (
    <Modal
      disablePortal
      onClose={props.handleClose}
      open={modalState}
      disableEnforceFocus
      disableAutoFocus
      aria-labelledby="server-modal-title"
      aria-describedby="server-modal-description"
      className={classes.modal}
      container={() => rootRef.current}
    >
      <div className={classes.paper}>
        <h2 id="server-modal-title">Criar nova tarefa</h2>
        <p id="server-modal-description">
          If you disable JavaScript, you will still see me.
        </p>
      </div>
    </Modal>
  );
};

export default FormModal;
