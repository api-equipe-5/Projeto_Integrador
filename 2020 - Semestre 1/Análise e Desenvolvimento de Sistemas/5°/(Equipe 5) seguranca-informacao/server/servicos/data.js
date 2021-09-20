function dataAtual() {
    const d = new Date();
    const data_atual = d.toLocaleString(); 

    return data_atual;
}

module.exports = dataAtual