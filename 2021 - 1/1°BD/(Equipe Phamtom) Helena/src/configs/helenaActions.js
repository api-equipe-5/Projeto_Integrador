import React, {usaState} from 'react';
import {navigate} from '../RootNavigation';

export const HelenaActions = [
  {
    name: 'show-Map-Turism',
    words: [
      'Helena pontos turísticos',
      'Helena pontos turisticos',
      'Helena abrir função pontos turísticos',
      'Helena função pontos turísticos',
      'Helena abrir pontos turísticos',
      'Helena abrir os pontos turísticos',
      'Helena mostrar pontos turísticos',
      'Helena mostrar os pontos turísticos',
      'Helena abrir mapa turísticos',
    ],
    handler: () => {
      navigate('Pontos Turisticos');
    },
  },

  {
    name: 'show-Map-SJC',
    words: [
      'Helena abrir pontos turísticos São José dos Campos',
      'Helena pontos turísticos São José dos Campos',
      'Helena pontos turísticos de São José dos Campos',
      'Helena mostrar pontos turísticos de São José dos Campos',
      'Helena mostrar os pontos turísticos São José dos Campos',
    ],
    handler: () => {
      navigate('MapaSJC');
    },
  },

  {
    name: 'show-Map-Jacareí',
    words: [
      'Helena abrir pontos turísticos Jacareí',
      'Helena pontos turísticos Jacareí',
      'Helena pontos turísticos de Jacareí',
      'Helena mostrar pontos turísticos de Jacareí',
      'Helena mostrar os pontos turísticos Jacareí',
    ],
    handler: () => {
      navigate('MapaJacarei');
    },
  },

  {
    name: 'open-maps',
    words: [
      'Helena onde estou',
      'Helena abrir função mapa',
      'Helena abrir a função mapa',
      'Helena função mapa',
      'Helena acessar função mapa',
      'Helena onde eu estou',
      'Helena mostrar localização',
      'Helena mostrar local',
      'Helena abrir localização',
      'Helena abrir local',
      'Helena local',
      'Helena mapa',
    ],
    handler: () => {
      navigate('Localizacao');
    },
  },
  {
    name: 'show-schedule',
    words: [
      'Helena lista de tarefas',
      'Helena abrir função lista de tarefas',
      'Helena abrir a função lista de tarefas',
      'Helena mostar função lista de tarefas',
      'Helena mostar a função lista de tarefas',
      'Helena roteiro',
      'Helena roteiro pessoal',
      'Helena abrir função roteiro',
      'Helena abrir função roteiro pessoal',
      'Helena mostrar função roteiro',
      'Helena mostrar função roteiro pessoal',
      'Helena mostar roteiro pessoal',
      'Helena mostar roteiro',
      'Helena o mostar roteiro',

    ],
    handler: () => {
      navigate('RoteiroPessoal');
    },
  },
//=========================================Adicionar mais açoes=====================================================
  {
    name: 'show-weather',
    words: [
      'Helena clima',
      'Helena abrir função previsão do tempo',
      'Helena abrir a função previsão do tempo',
      'Helena função previsão do tempo',
      'Helena qual é previsão do tempo',
      'Helena qual o clima atual',
      'Helena abrir clima atual',
      'Helena mostrar clima atual',
      'Helena mostrar o clima atual',
      'Helena clima atual',
      'Helena qual o clima',
      'Helena abrir clima',
      'Helena abrir o clima',
      'Helena mostrar clima',
      'Helena mostrar o clima',
    ],
    handler: () => {
      navigate('Weather');
    },
  },
////////////////////////Apresentação////////////
  {
    name: 'open-money-converter',
    words: [
      'Helena conversor de moedas',
      'Helena abrir função conversão de moedas',
      'Helena abrir a função conversão de moeda',
      'Helena mostar função conversão de moedas',
      'Helena mostar a função conversão de moedas',
      'Helena função moedas',
      'Helena moedas',
    ],
    handler: () => {
      navigate('ConversorMoedas');
    },
  },

  {
    name: 'open-know-more',
    words: [
      'Helena saiba mais',
      'Helena abrir função saiba mais',
      'Helena abrir a função saiba mais',
      'Helena mostar função saiba mais',
      'Helena mostar a função saiba mais',
      'Helena função saiba mais',
    ],
    handler: () => {
      navigate('SaibaMais');
    },
  },

  {
      name: 'open-know-more-SJC',
      words: [
        'Helena saiba mais de são josé dos campos',
        'Helena abrir função saiba mais de são josé dos campos',
        'Helena abrir a função saiba mais de são josé dos campos',
        'Helena mostar função saiba mais de são josé dos campos',
        'Helena mostar a função saiba mais de são josé dos campos',
        'Helena função saiba mais de são josé dos campos',
        'Helena saiba mais são josé dos campos',
        'Helena abrir função saiba mais são josé dos campos',
        'Helena abrir a função saiba mais são josé dos campos',
        'Helena mostar função saiba mais são josé dos campos',
        'Helena mostar a função saiba mais são josé dos campos',
        'Helena função saiba mais são josé dos campos',
      ],
      handler: () => {
        navigate('sobreSJCampos');
      },
  },
  {
    name: 'show-hotel-price',
    words: [
      'Helena abrir preço dos hotéis',
      'Helena abrir preço de hotéis',
      'Helena mostrar preço dos hotéis',
      'Helena mostrar lista de hotéis',
      'Helena abrir lista de hotel',
      'Helena abrir lista de hotéis',
      'Helena hotel',


    ],
    handler: () => {
      navigate('Hotel');
    },
  },

  {
    name: 'show-hotel-price-sjc',
    words: [
      'Helena abrir preço dos hotéis em são josé dos campos',
      'Helena abrir lista de hotel em são josé dos campos',
      'Helena abre preço dos hotéis em são josé dos campos',
      'Helena hotéis em são josé dos campos',
      'Helena hotel em são josé dos campos',

    ],
    handler: () => {
      navigate('SjcPreco');
    },
  },

  {
    name: 'show-hotel-price-jacarei',
    words: [
      'Helena abrir preço dos hotéis em jacareí',
      'Helena abrir lista de hotéis em jacareí',
      'Helena abrir preço de hotéis em jacareí',
      'Helena hotéis em jacareí',
    ],
    handler: () => {
      navigate('JacareiPreco');
    },
  },

  {
    name: 'show-hotel-info-ibisSjc',
    words: [
      'Helena abrir informações do hotel ibis',
      'Helena informações do hotel ibis',
      'Helena hotel ibis',
    ],
    handler: () => {
      navigate('ibisSjc');
    },
  }, 

  {
    name: 'show-hotel-info-PlazaHotel',
    words: [
      'Helena abrir informações do hotel Plaza',
      'Helena hotel plaza',
    ],
    handler: () => {
      navigate('PlazaHotel');
    },
  },

  {
    name: 'show-hotel-info-NovoHotel',
    words: [
      'Helena abrir informações do novo hotel',
      'Helena novo hotel',
    ],
    handler: () => {
      navigate('NovoHotel');
    },
  },

  {
    name: 'show-size-measure',
    words: [
      'Helena abrir conversor de medidas',
      'Helena conversor de medidas',
    ],
    handler: () => {
      navigate('ConversorMedidas');
    },
  },

  {
    name: 'open-google-translate',
    words: [
      'Helena abrir google tradutor',
      'Helena abrir tradutor',
      'Helena tradutor'
    ],
    handler: () => {
      navigate('Tradutor');
    },
  },

 // Em Construção _______________________________________________________________
 
  {
    name: 'show-functions',
    words: [
      'Helena abrir lista de funcionalidades',
      'Helena abrir lista de funções',
      'Helena abrir a lista de funções',
      'Helena abrir lista funções',
      'Helena abrir funções',
      'Helena mostrar lista de funções',
      'Helena mostrar a lista de funções',
      'Helena mostrar lista funções',
      'Helena mostrar funções',
      'Helena lista de funções',
      'Helena lista funções',
      'Helena funções',
      'Helena lista de funcionalidades',
      'Helena funcionalidades',
    ],
    handler: () => {
      navigate('ListaFuncoes');
    },
  },


  {
    name: 'function-calculator',
    words: [
      'Helena calculadora',
      'Helena função calculadora',
      'Helena abrir calculadora',
      'Helena abrir a calculadora',
      'Helena mostrar calculadora',
      'Helena mostrar a calculadora',
    ],
    handler: () => {
      navigate('Calculadora');
    },
  },

];
