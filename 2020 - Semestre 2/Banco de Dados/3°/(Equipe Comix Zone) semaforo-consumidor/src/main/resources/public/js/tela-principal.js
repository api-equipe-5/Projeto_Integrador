$(document).ready(function() {
    var score = sessionStorage.getItem("score");
    if (score == 0) {
        var userScore = document.getElementById("userScore")
        userScore.style.color = "red"
        userScore.innerHTML = "<h5>Vermelho</h5>"
        var scoreBar = document.getElementById("scoreBar")
        scoreBar.className = "progress-bar progress-bar-danger"
        scoreBar.style.width = "20%"
        var cardScore = document.getElementById("cardScore")
        cardScore.innerHTML = "Infelizmente, hoje você está no sinal vermelho, mas não desanima! Vamos te ajudar a sair dessa!"
        
        var dica1 = document.getElementById("dica1")
        var dica1Descricao = document.getElementById("dica1Descricao")
        dica1.innerHTML = "Dica Sebrae"
        dica1Descricao.innerHTML = "O Sebrae é o melhor portal de empreendedorismo! Confira aqui uma dica para iniciar o seu negócio"
        
        var dica2 = document.getElementById("dica2")
        var dica2Descricao = document.getElementById("dica2Descricao")
        dica2.innerHTML = "Desconto Marketplace"
        dica2Descricao.innerHTML = "Desconto no marketplace X ,lá você pode criar 3 anúncios premium durante 3 meses"
    }
    else if (score == 1) {
        var userScore = document.getElementById("userScore")
        userScore.style.color = "#ffbf00"
        userScore.innerHTML = "<h5>Amarelo</h5>"
        var scoreBar = document.getElementById("scoreBar")
        scoreBar.className = "progress-bar progress-bar-warning"
        scoreBar.style.width = "60%"
        var cardScore = document.getElementById("cardScore")
        cardScore.innerHTML = "Você está no amarelo, cuidado para não cair no vermelho! Ao lado você encontra várias dicas para melhorar sua saúde financeira!"
        
        var dica1 = document.getElementById("dica1")
        var dica1Descricao = document.getElementById("dica1Descricao")
        dica1.innerHTML = "Mentoria Financeira"
        dica1Descricao.innerHTML = "Quer aprender a administrar melhor o seu dinheiro, faça esse curso de mentoria financeira já!"
        
        var dica2 = document.getElementById("dica2")
        var dica2Descricao = document.getElementById("dica2Descricao")
        dica2.innerHTML = "Comprar Bem e Barato"
        dica2Descricao.innerHTML = "Um dos segredos para não cair no vermelho é comprar com responsabilidade e com bom preço, então clique aqui para conhecer os descontos do nosso parceiro!"
    }
    else if (score == 2) {
        var userScore = document.getElementById("userScore")
        userScore.style.color = "green"
        userScore.innerHTML = "<h5>Verde</h5>"
        var scoreBar = document.getElementById("scoreBar")
        scoreBar.className = "progress-bar progress-bar-success"
        scoreBar.style.width = "100%"
        var cardScore = document.getElementById("cardScore")
        cardScore.innerHTML = "Parabéns! Você está com a saúde financeira em dia! Que tal desfrutar de alguns descontos e poder consumir de forma consciente."
        
        var dica1 = document.getElementById("dica1")
        var dica1Descricao = document.getElementById("dica1Descricao")
        dica1.innerHTML = "Ganhe descontos!"
        dica1Descricao.innerHTML = "Ganhe descontos nos melhores produtos que separamos para você! Porque melhor que comprar é comprar barato!"
        
        var dica2 = document.getElementById("dica2")
        var dica2Descricao = document.getElementById("dica2Descricao")
        dica2.innerHTML = "Cashback no Abastecimento"
        dica2Descricao.innerHTML = "Agora você pode ganhar cashback no abastecimento do seu veículo e ter um retorno do seu dinheiro para próximas compras!"
    }

    $.material.init();

})