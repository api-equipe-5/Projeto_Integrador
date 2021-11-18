import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';


import "./styles.css";


const useStyles = makeStyles((theme) => ({
  button: {
    display: 'block',
    marginTop: theme.spacing(2),
    className: 'fields',
  },
  formControl: {
    margin: theme.spacing(1),
    minWidth: 300,
  },
}));

export default function ControlledOpenSelect() {
  const classes = useStyles();
  const [campos, setCampos] = React.useState('');
  const [open, setOpen] = React.useState(false);


  const handleChange = (event) => {
    setCampos(event.target.value);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    setOpen(true);
  };

  return (
    <div>
      <FormControl className={classes.formControl}>
        <InputLabel id="demo-controlled-open-select-label">DE</InputLabel>
        <Select
          
          open={open}
          onClose={handleClose}
          onOpen={handleOpen}
          value={campos}
          onChange={handleChange}
        >
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value={1}>the_geom</MenuItem>
          <MenuItem value={2}>fid</MenuItem>
          <MenuItem value={3}>wtc_pk</MenuItem>
          <MenuItem value={4}>idcda</MenuItem>
          <MenuItem value={5}>cocursodag</MenuItem>
          <MenuItem value={6}>nudistbacc</MenuItem>
          <MenuItem value={7}>nucompcda</MenuItem>
          <MenuItem value={8}>nuareabacc</MenuItem>
          <MenuItem value={9}>cocdadesag</MenuItem>
          <MenuItem value={10}>nunivotcda</MenuItem>
          <MenuItem value={11}>nuordemcda</MenuItem>
          <MenuItem value={12}>dedominial</MenuItem>
          <MenuItem value={13}>dsversao</MenuItem>
        </Select>
      </FormControl>
    </div>
  );
}
