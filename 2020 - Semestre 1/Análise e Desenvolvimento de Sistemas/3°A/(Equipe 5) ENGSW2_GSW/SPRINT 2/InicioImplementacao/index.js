const customexpress = require('./config/customexpress');
const conexao = require('./infraestrutura/conexao');


conexao.connect(erro => {
    if (erro){
        console.log(erro);
    } else {
        console.log('conectado com sucesso');
        
        const app = customexpress();
        
        app.listen(3000, () => console.log('servidor rodando'));
    }
});