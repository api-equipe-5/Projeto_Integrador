const conexao = require('../infraestrutura/conexao');

class Login {

    cadastro(candidato, res) {
        // inserir nome, cpf, email
        conexao.query('INSERT INTO contas SET ?', candidato, (err) => {
            if (err) {
                res.status(400).json(err);
            } else {
                res.status(201).json(candidato);
                res.redirect('/login');
            }
        });
    }


    login(req, res) {
        var nome = req.body.nome;
        var cpf = req.body.cpf;
        if (nome && cpf) {
            conexao.query('SELECT * FROM contas WHERE nome = ? AND cpf = ?', [nome, cpf], function(error, resultados, fields) {
                if (resultados.length > 0) {
                    req.session.loggedin = true;
                    req.session.nome = nome;
                    res.redirect('/home');
                } else {
                    res.send("Nome ou Cpf inválidos!");
                }			
                    res.end();
            });
        } else {
            res.send('Por favor coloque nome e cpf!');
            res.end();
        }
    }
}

module.exports = new Login;