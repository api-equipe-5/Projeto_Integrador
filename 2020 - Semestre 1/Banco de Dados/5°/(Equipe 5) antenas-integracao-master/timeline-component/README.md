# Timeline Component

Este componente (feito de qualquer jeito para ser implementado o quanto antes) serve para exibir o progresso do projeto

## **Antes de tudo!**

Garanta que o Bootstrap e o jQuery estão sendo importados no projeto.

Caso não tenha certeza, siga os passos:

1. Na sua tag `<head>` importe o css do bootstrap **ANTES DO SEU CSS ORIGINAL**
```HTML
<head>
  ...

  <link rel="stylesheet" type="text/css" media="screen" href="css/seu_css_original.css" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
  ...
</head>
```

2. Importe o Javascript do Bootstrap e o jQuery no final do seu `<body>`
```HTML
<body>
  ...
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
```

## Como usar o Timeline (bolinhas)

1. Copie e cole os arquivos *timeline.css* e *timeline.js* dentro do seu projeto
2. Importe o script na página HTML onde ele será usado. **Certifique-se de que ele está sendo importado antes do arquivo javascript principal**
```html
<head>
  ...
  <!-- Aqui vai estar a importação do estilo (arquivo CSS) do bootstrap -->
  <link rel="stylesheet" type="text/css" media="screen" href="timeline.css" />
  ...
</head>
<body>
  ...
  
  <!-- Aqui vão estar as importações do jQuery e do JS do Bootstrap -->
  
  <script src="timeline.js"></script>
  
  <!-- Aqui vai a importacao do seu arquivo principal de javascript -->
</body>
```

3. Logo no inicio do seu arquivo javascript principal, instancie o componente de timeline passando um endpoint (rota do back-end) de salvamento de projeto.
```javascript
var timeline = new Timeline('/salvar-projeto');
```

4. Insira a timeline na tela indicando para a função *insertTimeline* o elemento HTML onde será adicionada a timeline e o projeto de onde virão as informações da timeline. Garanta que o projeto passado estará igual ao modelo.json
```javascript
var projeto; // Garanta que ele estará igual ao modelo.json
var elementoExemplo = document.querySelector('div');
timeline.insertTimeline(elementoExemplo, projeto);
```

5. Com isso a timeline ja deve estar aparecendo na tela quando carregada.


## Vendo exemplo

Se ainda tiver dúvidas sobre a implementação, olhe o exemplo criado na pasta *demo*.

Para executa-lo, siga os passos:
1. Garanta que você tem node instalado na sua maquina (para ver se tem mesmo, rode `node --version` no seu terminal)
2. Vá até o diretório *demo* pelo terminal
3. Execute `npm install`
4. Rode `npm start`
5. No seu navegador, digite `http://localhost:3548`
6. [OPCIONAL] Se quiser ver todos os projetos cadastrado no *demo*, acesse o link `http://localhost:3548/projetos`