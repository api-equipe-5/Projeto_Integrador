// CONFIGURANDO EXPRESS
let express = require('express');
let app = express();

let bodyParser = require('body-parser');
let cors = require('cors');

app.use(cors());

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use(express.static('./'));

// CONFIGURANDO ROTAS
let projetos = [
  {
    _id: '1o23u1io2jdpasd',
    titulo: 'Um projeto na fase 2',
    'descricao-breve': 'Nesta fase o usuário tem que esperar uma avaliação detalhada',
    'descricao-completa': '',
    'descricao-tecnologias': '',
    'link-externo-1': '',
    'link-externo-2': '',
    fase: 2,
    reuniao: {
      data: '',
      horario: '',
      local: '',
      'datas-possiveis': []
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': 'flromeiroc@gmail.com'
  },
  {
    _id: 'pjpinih321djs',
    titulo: 'Um projeto na fase 3',
    'descricao-breve': 'Nesta fase o usuário tem que esperar uma avaliação detalhada',
    'descricao-completa': 'Descricao completa lindissima',
    'descricao-tecnologias': 'Tem até descricao de tecnologia',
    'link-externo-1': 'http://www.fabioromeiro.com.br',
    'link-externo-2': '',
    fase: 3,
    reuniao: {
      data: '',
      horario: '',
      local: '',
      'datas-possiveis': []
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': 'flromeiroc@gmail.com'
  },
  {
    _id: 'ioeoqromksc812',
    titulo: 'Um projeto na fase 4',
    'descricao-breve': 'Nesta fase o usuário tem que esperar uma avaliação detalhada',
    'descricao-completa': 'Descricao completa lindissima',
    'descricao-tecnologias': 'Tem até descricao de tecnologia',
    'link-externo-1': 'http://www.fabioromeiro.com.br',
    'link-externo-2': '',
    fase: 4,
    reuniao: {
      data: '',
      horario: '',
      local: '',
      'datas-possiveis': [
        {
          "data": "05/04/2019",
          "hora": "15:50"
        },
        {
          "data": "24/04/2019",
          "hora": "10:20"
        },
        {
          "data": "09/05/2019",
          "hora": "13:15"
        }
      ]
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': 'flromeiroc@gmail.com'
  },
  {
    _id: 'qowiu3oiqew521',
    titulo: 'Um projeto na fase 5 pendente',
    'descricao-breve': 'Nesta fase o usuário tem que esperar uma avaliação detalhada',
    'descricao-completa': 'Descricao completa lindissima',
    'descricao-tecnologias': 'Tem até descricao de tecnologia',
    'link-externo-1': 'http://www.fabioromeiro.com.br',
    'link-externo-2': '',
    fase: 5,
    reuniao: {
      data: '05/04/2019',
      horario: '15:50',
      local: 'Rua Barbosa',
      'datas-possiveis': [
        {
          "data": "05/04/2019",
          "hora": "15:50"
        },
        {
          "data": "24/04/2019",
          "hora": "10:20"
        },
        {
          "data": "09/05/2019",
          "hora": "13:15"
        }
      ]
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': 'flromeiroc@gmail.com'
  },
  {
    _id: 'rotejhroncasd51',
    titulo: 'Um projeto na fase 5',
    'descricao-breve': 'Nesta fase o usuário tem que esperar uma avaliação detalhada',
    'descricao-completa': 'Descricao completa lindissima',
    'descricao-tecnologias': 'Tem até descricao de tecnologia',
    'link-externo-1': 'http://www.fabioromeiro.com.br',
    'link-externo-2': '',
    fase: 5,
    reuniao: {
      data: '05/04/2019',
      horario: '15:50',
      local: 'Rua Barbosa',
      'datas-possiveis': [
        {
          "data": "05/04/2019",
          "hora": "15:50"
        },
        {
          "data": "24/04/2019",
          "hora": "10:20"
        },
        {
          "data": "09/05/2019",
          "hora": "13:15"
        }
      ]
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [
      {
        "aluno-responsavel": "flromeiroc@gmail.com",
        "alunos": [
          "outros@email.com"
        ],
        "link-repositorio": "https://github.com/projeto-antena/antena-empresario",
        "link-cloud": "http://github.com/FabioRomeiro",
        "comentario": "Nos esforçamos bastante nesse projeto mesmo tendo zilhões de provas pra fazer :D"
      }
    ],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': 'flromeiroc@gmail.com'
  },
  {
    _id: 'opijsdonaxsd512',
    titulo: 'Um projeto negado',
    'descricao-breve': 'Nesta fase o usuário tem que esperar uma avaliação detalhada',
    'descricao-completa': 'Descricao completa lindissima',
    'descricao-tecnologias': 'Tem até descricao de tecnologia',
    'link-externo-1': 'http://www.fabioromeiro.com.br',
    'link-externo-2': '',
    fase: 5,
    reuniao: {
      data: '05/04/2019',
      horario: '15:50',
      local: 'Rua Barbosa',
      'datas-possiveis': [
        {
          "data": "05/04/2019",
          "hora": "15:50"
        },
        {
          "data": "24/04/2019",
          "hora": "10:20"
        },
        {
          "data": "09/05/2019",
          "hora": "13:15"
        }
      ]
    },
    status: {
      negado: true,
      motivo: 'Não cumpriu com os requisitos para ser um dos projetos dentro do antenas'
    },
    entregas: [
      {
        "aluno-responsavel": "flromeiroc@gmail.com",
        "alunos": [
          "outros@email.com"
        ],
        "link-repositorio": "https://github.com/projeto-antena/antena-empresario",
        "link-cloud": "http://github.com/FabioRomeiro",
        "comentario": "Nos esforçamos bastante nesse projeto mesmo tendo zilhões de provas pra fazer :D"
      }
    ],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': 'flromeiroc@gmail.com'
  }
];

app.get('/projetos', (req,res) => {
  res.status(200).json(projetos);
});

app.post('/update-projeto', (req,res) => {
  console.log('Chegou');
  console.log(req.body);
  let projeto = req.body;
  
  projetos.some((item,index) => {
    if(item._id == projeto._id) {
      projetos[index] = projeto;    
      return true;
    }
  });

  res.status(200).send();
});

// RODANDO SERVIDOR
app.listen(3548, () => {
  console.log('Rodando na porta 3548');
});