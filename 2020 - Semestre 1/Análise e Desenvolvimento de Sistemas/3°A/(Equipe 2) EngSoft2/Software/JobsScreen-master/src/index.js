import React from 'react';
import ReactDOM from 'react-dom';
import { Route, BrowserRouter as Router } from 'react-router-dom';
import Body from './Componets/Home/body';
import Jobs from './Componets/Admin/Jobs';
import Employee from './Componets/Admin/Employee';
import AdminHome from './Componets/Admin/AdminHome';
import Welcome from './Componets/Welcome';
import Header from './Componets/Header/header';
import Footer from './Componets/Footer/footer';



ReactDOM.render(
  <React.StrictMode>
      <Header />
    <Router>
      <div>
        <Route path="/" exact component={Welcome} />
        <Route path="/vagas" component={Body} />
        <Route path="/admin/painel" component={AdminHome} />
        <Route path="/admin/vagas" component={Jobs} />
        <Route path="/admin/funcionarios" component={Employee} />
      </div>
    </Router>
    <Footer/>
  </React.StrictMode>,
  document.getElementById('root')
);


