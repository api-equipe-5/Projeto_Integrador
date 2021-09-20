const conexao = require('../infraestrutura/conexao');

class Vagas {

    adiciona(vaga, res) {
        const query = conexao.query('INSERT INTO vagas SET ?', vaga, (err) => {
            if (err) {
                res.status(400).json(err);
            } else {
                res.status(201).json(vaga);
            }
        });
    }

    lista(res){
        const sql = 'SELECT * FROM vagas'

        conexao.query(sql, (erro, resultados) => {
            if (erro){
                res.status(400).json(erro);
            } else {
                res.status(200).json(resultados);
            }
        })
    }

    buscaporId(id, res){
        const sql = `SELECT * FROM vagas WHERE id =${id}`;

        conexao.query(sql, (erro, resultados) => {
            const vagaResultado = resultados[0];
            if(erro){
                res.status(400).json(erro);
            } else {
                res.status(200).json(vagaResultado);
            }
        })
    }

    editar(id, vagaEditada, res) {
        const data = [vagaEditada, id];
        const query = conexao.query('UPDATE vagas SET ? WHERE id = ?', data, (err) => {
            if (err) {
                res.status(400).json(err);
            } else {
                res.status(201).json(vagaEditada);
            }
        });
    }

    atualizarInscritos(id, candidatos, res) {
        const returnInscritos = conexao.query('SELECT inscritos FROM vagas WHERE id = ?', id, (err, data) => {
            const storedInscritos = data[0].inscritos;
            let subs;
            if (err) {
                res.status(400).json(err);
            } else if (storedInscritos) {
                subs = this.concatNewSubs(storedInscritos, candidatos);
            } else {
                subs = JSON.stringify(candidatos);
            }

            const queryData = [subs, id];
            const query = conexao.query('UPDATE vagas SET inscritos = ? WHERE id = ?', queryData, (err) => {
                if (err) {
                    res.status(400).json(err);
                } else {
                    res.status(201).json(subs);
                }
            });
        })
    }

    deleta(id, res){
        const sql = 'DELETE FROM vagas WHERE id=?';

        conexao.query(sql, id, (erro, resultados) => {
            if(erro){
                res.status(400).json(erro);
            } else {
                res.status(200).json({id});
            }
        })
    }

/*Os filtros a gente faz no front, é mais custoso, mas é o que tem*/

//---------------------------tratamentos-----------------------
    concatNewSubs(storedSubs, newSubs) {
        newSubs = JSON.stringify(newSubs);
        newSubs = newSubs.slice(1, newSubs.length - 1);
        storedSubs = storedSubs.slice(1, storedSubs.length - 1);
        const concatSubs = storedSubs.concat(',' + newSubs);
        return '[' + concatSubs + ']';
    }
}

module.exports = new Vagas;
