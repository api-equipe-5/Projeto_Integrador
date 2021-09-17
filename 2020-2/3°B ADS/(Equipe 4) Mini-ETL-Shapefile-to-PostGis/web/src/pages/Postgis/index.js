import React, { useContext, useState, useEffect } from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';

//Context
import AppContext from '../../context';

//API
import api from '../../services/api';

//Components
import Header from '../../components/Header';
import Faq from '../../components/Faq';
import Footer from '../../components/Footer';
import Connection from '../../components/Connection';
import UploadPost from '../../components/Upload-Post';

//Assets
import postStep2 from '../../assets/img/post-shape-new.png';

//Style
import "./styles.css";

const Post = () => {
  
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
              <label className="fields">DE</label>
              <label className="fields">DE</label>
              <label className="fields">DE</label>
              <label className="fields">DE</label>
              <label className="fields">DE</label>
              <label className="fields">DE</label>
              <label className="fields">DE</label>
              <label className="fields">DE</label>
            </>
          )
        }
    }
  

  return (
    <>
      <Header />
      <Faq />
      
      <div className="main-container">
      <div className="post-step1-header">
          <p>1</p>
          <span>Conecte-se com o seu Banco de Dados.</span>
        </div>
        
        <Connection />

        <div className="post-step2-header">
          <p>2</p>
          <span> Gere arquivos SHAPEFILE do seu banco de dados POSTGRESQL com segurança e confiabilidade.</span>
        </div>
        
        <UploadPost/>

        <div className="post-step3-header">
          <p>3</p>
          <span>Selecione os campos para a realização do de-para.</span>
        </div>
        
        <div className="post-step3-de-para">
        
          <h1>DE-PARA</h1>

          <div className="shape-step3-selection">
            <form className="columns">
              {inputFill()}
            </form>

            <form className="columns">
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
              <label className="fields">PARA</label>
            </form>
          </div>
            
        </div>

        <Link to="/" className="post-send-button">
          REALIZAR CARGA
        </Link>
      </div>

      <Footer/>
      
    </>
  );
}

export default Post;