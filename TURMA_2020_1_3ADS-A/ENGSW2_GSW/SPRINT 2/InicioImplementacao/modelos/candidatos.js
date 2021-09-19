const conexao = require('../infraestrutura/conexao');

class Candidato {

    adiciona(candidato, res) {
        conexao.query('INSERT INTO candidatos SET ?', candidato, (err) => {
            if (err) {
                res.status(400).json(err);
            } else {
                res.status(201).json(candidato);
            }
        });
    }

    lista(res) {
        const sql = 'SELECT * FROM candidatos';

        conexao.query(sql, (erro, resultados) => {
            if (erro){
                res.status(400).json(erro);
            } else {
                res.status(200).json(resultados);
            }
        })
    }

    buscaCandidatoCpf(cpf, res) {
        const sql = `SELECT * FROM candidatos WHERE cpf =${cpf}`;

        conexao.query(sql, (erro, resultados) => {
            const candidatoResult = resultados[0];
            if (erro){
                res.status(400).json(erro);
            } else if (candidatoResult) {
                res.status(200).json(candidatoResult);
            } else {
                res.status(404).send('Candidato does not exist');
            }
        })
    }

    editar(cpf, candidatoEditado, res) {
        const data = [candidatoEditado, cpf];
        const query = conexao.query('UPDATE candidatos SET ? WHERE cpf = ?', data, (err) => {
            if (err) {
                res.status(400).json(err);
            } else {
                res.status(201).json(candidatoEditado);
            }
        });
    }

    deleta(cpf, res){
        const sql = 'DELETE FROM candidatos WHERE cpf=?';

        conexao.query(sql, cpf, (erro, resultados) => {
            if(erro){
                res.status(400).json(erro);
            } else {
                res.status(200).json({cpf});
            }
        })
    }
}

module.exports = new Candidato;
