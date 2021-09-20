import React from 'react';
import { Button, PageHeader } from 'antd';
import Logo from '../../assets/LogoMitim2-s-fundo.png';
import { Link, useHistory } from 'react-router-dom';
import './navbar.css';
import { ArrowLeftOutlined } from '@ant-design/icons';



const Navbar = ({routes}) => {

    const history = useHistory();
    function Logout(){
        localStorage.clear();
        history.push('/');
    }
    
    return(
        <PageHeader
            className="site-page-header"
            title={<img src={Logo} className="img-logo-nav" alt="Mítim" fluid="true"/>}
            subTitle={<Button type="primary"><ArrowLeftOutlined /><a className="logout-link" onClick={Logout} >  Sair</a></Button>}
        >
            <table><tr>{routes.map(r => (<Link to={r.path}><td>&nbsp;&nbsp;&nbsp;&nbsp;{r.breadcrumbName}</td></Link>))}</tr></table>
        </PageHeader> 
    ); 
}
export default Navbar;