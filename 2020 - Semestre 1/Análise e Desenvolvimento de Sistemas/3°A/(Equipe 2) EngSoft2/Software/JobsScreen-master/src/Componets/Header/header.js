import React, { useState } from 'react';

import { fade, makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import InputBase from '@material-ui/core/InputBase';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';

import MenuIcon from '@material-ui/icons/Menu';
import SearchIcon from '@material-ui/icons/Search';

import LogInButton from '../ActionButtons/LogInButton'


const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    display: 'none',
    [theme.breakpoints.up('sm')]: {
      display: 'block',
    },
  },
  search: {
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: fade(theme.palette.common.white, 0.15),
    '&:hover': {
      backgroundColor: fade(theme.palette.common.white, 0.25),
    },
    marginRight: theme.spacing(2),
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      marginLeft: theme.spacing(3),
      width: 'auto',
    },
  },
  searchIcon: {
    padding: theme.spacing(0, 2),
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  inputRoot: {
    color: 'inherit',
  },
  inputInput: {
    padding: theme.spacing(1, 1, 1, 0),
    paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
    width: '100%',
  },
  section: {
    display: 'none',
    [theme.breakpoints.up('md')]: {
      display: 'flex',
    },
    nested: {
      paddingLeft: theme.spacing(4),
    },
  },
}));



const Header = () => {
  const [anchorEl, setAnchorEl] = useState(null);
  const classes = useStyles();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };
  return (
    <div className={classes.grow}>
      <AppBar position="static">
        <Toolbar>
          {window.location.pathname.includes('/admin') && 
            <div>
              <IconButton
                  edge="start"
                  className={classes.menuButton}
                  color="inherit"
                  aria-controls="simple-menu"
                  aria-haspopup="true"
                  onClick={handleClick}
                >
                  <MenuIcon/>
              </IconButton>
              <Menu
                  id="simple-menu"
                  anchorEl={anchorEl}
                  keepMounted
                  open={Boolean(anchorEl)}
                  onClose={handleClose}
              >
                 <MenuItem onClick={() =>{
                   handleClose();
                   window.location.replace("/admin/painel")
                  }
                  }>Painel</MenuItem>
                 <MenuItem onClick={() =>{
                   handleClose();
                   window.location.replace("/admin/vagas")
                  }
                }>Vagas</MenuItem>
                 <MenuItem onClick={handleClose}>Banco de talentos</MenuItem>
                 <MenuItem onClick={() => {
                   handleClose();
                   window.location.replace("/admin/funcionarios")
                  }
                   }>Funcionários</MenuItem>
                 <MenuItem onClick={handleClose}>Entrevistas</MenuItem>
              </Menu>
            </div>
            }
          <a style={{textDecoration:'none', color:'#ffff'}} href='/'>
            Logo 
          </a>
          
          <div className={classes.search}>
            <div className={classes.searchIcon}>
              <SearchIcon />
            </div>
            <InputBase
              placeholder="Procurar..."
              classes={{
                root: classes.inputRoot,
                input: classes.inputInput,
              }}
              inputProps={{ 'aria-label': 'search' }}
            />
          </div>
          <div className={classes.grow} />
          <div className={classes.section}>
            {window.location.pathname === '/' &&
            <IconButton
              color="inherit"
            >
              <LogInButton type={'user'}/>
            </IconButton>
            }
          </div>
        </Toolbar>
      </AppBar>
    </div>
  );
}

export default Header;