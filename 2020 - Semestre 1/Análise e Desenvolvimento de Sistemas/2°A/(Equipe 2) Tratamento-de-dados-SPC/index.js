const { app, BrowserWindow } = require('electron');

let mainWindow;

app.on('ready', () => { // Quando a aplicação estiver pronta ela roda o que tem dentro dessa função

  mainWindow = new BrowserWindow ({ // criando janela
    width: 1360,
    height: 768,
    resizable: false,
    webPreferences: {
      nodeIntegration: true
    }

  });

  mainWindow.loadURL(`file://${__dirname}/src/pages/login/login.html`) // rodar o index.html na janela

}); 
