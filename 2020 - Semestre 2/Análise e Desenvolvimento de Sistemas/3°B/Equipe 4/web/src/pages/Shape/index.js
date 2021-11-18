import React, { useContext, useState, useEffect } from 'react';

import {Link} from 'react-router-dom';

//Context
import AppContext from '../../context';

//Components
import Header from '../../components/Header';
import Faq from '../../components/Faq';
import Footer from '../../components/Footer';
import Connection from '../../components/Connection';
import UploadShape from '../../components/Upload-Shape';
import MenuItem from '../../components/para-shape';


//Assets
import shapeStep1 from '../../assets/img/shape-post-new.png';
import shapeStep3 from '../../assets/img/de-para-shape.png';

//Styles
import "./styles.css";

import api from '../../services/api';

const Shape = () => {


  const [Files, setFiles] = useState([]);

  const {shapeReturn, setShapeReturn} = useContext(AppContext);

  useEffect(() => {
    console.log('contexto aqui: ', shapeReturn);
  }, [shapeReturn]);

  const listItems = shapeReturn.map(
    (value, index) =>
    <label className="fields" id={index + 1} key={index}>{value}</label>
    );

  function inputFill() {
    console.log('NÃO SE CONFIA EM ANÃO BEBEDOR DE APPIA', shapeReturn.length);
    if (shapeReturn.length > 0){
      return (
        shapeReturn.map(
          (value, index) =>
          <label className="fields" id={index + 1} key={index}>{value}</label>
          )
        )}
        else {
          return (
            <>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
              <label className="fields2">PARA</label>
            </>
          )
        }
    }

  return (
    <>
      <Header />
      <Faq />
      
      <div className="main-container">
        <div className="shape-step1-header">
          <p>1</p>
          <span> Carregue seus arquivos SHAPEFILE para seu banco de dados POSTGRESQL com segurança.</span>
        </div>
        

          <UploadShape />

          <div className="shape-step2-header">
          
          <p>2</p>
          <span>Conecte-se com o seu Banco de Dados.</span>
        </div>
        
        <Connection />

        <div className="shape-step3-header">
          <p>3</p>
          <span>Selecione os campos para a realização do de-para.</span>
        </div>
        
        <div className="shape-step3-de-para">
        
          <h1>DE-PARA</h1>

          <div className="shape-step3-selection">


            <form className="columns">
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
              <label className="fields"><MenuItem/></label>
            </form>

            <form className="columns">
              {inputFill(()=> {

                
              })}
            </form>
          </div>
        </div>

        <Link to="/" className="shape-send-button">
          REALIZAR CARGA
        </Link>
      </div>

      <Footer />
    </>
  );
}

export default Shape;

