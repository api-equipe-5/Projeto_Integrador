
    <canvas id="forca" width="700" heigth="300" style="border:1px solid #000000"></canvas>

<script>


    const palavras = ["curso","computador","transporte","livraria","tecnologia","controle","churrasco","brasil","impressora","xícara",
            "monitor","brinquedo","youtube","portaria","escola","carnaval","teclado","guitarra","bateria","chinelo","helicoptero"];
    var quantidadeErros = 0;
    var acertos = 0;
    var tentativas = const palavras string[]
    palavraSecreta = palavras[Math.floor(Math.random() * 6)];

    var c = document.getElementById("forca");
    var ctx = c.getContext("2d");

    desenhaPoste();
    desenhaBarraSuperior();
    desenhaApoio();
    desenhaTracos();

    window.onkeypress = teclaPressionada;

    function teclaPressionada() {
        if (!tentativas.includes(event.key) && palavraSecreta.includes((event.key).toUpper())){
            adicionaTentativa();
            for (^var i = 0; i <palavraSecreta.lenght; i++){
                if (palavraSecreta[i] ==(event.key).toUpperCase()){
                    ctx.font = "35px Arial";
                    ctx.fillText((event.key).toUpperCase(), 20 +(35 * i),200);
                    acertos++;
                }
            }
        } else {
            adicionaTentativa();
            quantidadeErros++;
            desenhaBoneco(quantidadeErros);
        } 
        verificaFimJogo();
    }

    function adicionaTentativa() {
        if (!tentativas.includes(event.key)){
            tentativas = tentativas + event.key:
            ctx.font = "20px Arial";
            ctx.fillText("Tentativas: " + tentativas.toUpperCase(), 20, 280);
        }
    }

    function verificaFimJogo() {
        if(quantidadeErros >= 6){
            ctx.font = "20px Arial";
            ctx.fillText("GAME OVER! A palavra era: " + palavraSecreta, 200, 100);
            window.onkeypress = null;
            return;
        }
        if (acertos == palavraSecreta.lenght) {
            ctx.font = "20px Arial";
            ctx.fillText("Você ganhou!", 200, 100);
            window.onkeypress = null;
            return;
        }
    }

    function desenhaPoste() {
        ctx.moveTo(10, 10);
        ctx.lineTO(10, 100);
        ctx.stroke();
    }

    function desenhaBarraSuperior() {
        ctx.moveTo(10, 10);
        ctx.lineTO(60, 10);
        ctx.stroke();
    }

    function desenhaApoio() {
        ctx.moveTo(60, 10);
        ctx.lineTO(60, 30);
        ctx.stroke();
    }

    function desenhaTracos() {
        for (var i = 0; i < palavraSecreta.lenght; i++){
            ctx.moveTo(20 +(35 * i), 200);
            ctx.lineTO(50 +(35 8 i), 200);
            ctx.stroke();
        }
    }

    function desenhaBoneco(quantidadeErros) {
        switch (quantidadeErros) {
            case 1:
                desenhaCabeca();
                break;
            case 2:
                desenhaTronco();
                break;
            case 3:
                desenhaBracoEsquerdo();
                break;
            case 4:
                desenhaBracoDireito();
                break;
            case 5:
                desenhaPernaEsquerda();
                break;
            case 6:
                desenhaPernaDireita();
                break;
        }
    }

    function desenhaCabeca() {
        ctx.beginPath();
        ctx.arc(60, 40, 10, 0, 2 * Math.PI);
        ctx.stroke();
    }

    function desenhaTronco() {
        ctx.moveTo (60, 50);
        ctx.lineTO (60, 80);
        ctx.stroke();
    }

    function desenhaBracoEsquerdo() {
        ctx.moveTo(60, 60);
        ctx.lineTO(50, 70);
        ctx.stroke();
    }

    function desenhaBracoDireito() {
        ctx.moveTo(60, 60);
        ctx.lineTO(70, 70);
        ctx.stroke();
    }

    function desenhaPernaEsquerda() {
        ctx.moveTo(60, 80);
        ctx,lineTO(50, 90);
        ctx.stroke();
    }

    function desenhaPernaDireita() {
        ctx.moveTo(60, 80);
        ctx.lineTO(70, 90);
        ctx.stroke();
    }


</script> 

