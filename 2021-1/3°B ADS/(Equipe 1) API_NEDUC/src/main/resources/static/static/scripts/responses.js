function getBotResponse(input) {
    //respostas de entrada
    if (input == "1") {
        return "Para fazer o cadastro clique em 'CADASTRAR-SE' > Selecione como deseja se cadastrar (professor ou aluno) > Insira os seus dados e clique em CADASTRAR. Digite 'MENU' para voltar ao menu de escolhas.";
    } else if (input == "2") {
        return "Para fazer o login clique em 'ENTRAR' na barra superior do site > Selecione como deseja acessar a plataforma > Insira os seus dados e clique em 'ENTRAR'. Digite 'MENU' para voltar ao menu de escolhas.";
    } else if (input == "4") {
        return "Clique em 'AJUDA' na barra superior da página para acessar a documentação de apoio aos usuários. Digite 'MENU' para voltar ao menu de escolhas.";
    } else if (input == "Você é demais, Edu!") {
        return "Você é incrível!"; 
    } else if (input == "3") {
        return "A Neduc.. Digite 'MENU' para voltar ao menu de escolhas."; 
    } else if (input == "menu") {
        return "1 - Se quiser ajuda no seu cadastro 2 - Se precisar de ajuda no acesso 3 - Se quiser saber mais sobre nós 4 - Se quiser acessar a documentação de ajuda ao usuário."; 
    }

    // Respostas simples
    if (input == "Oi") {
        return "Olá, como você está?";
    } else if (input == "obrigado") {
        return "Imagina, qualquer coisa pode me chamar! :)";
    } else if (input == "bem") {
        return "Que ótimo, fico feliz em saber! :)";
    } else if (input == "bem e você?") {
        return "Estou bem, obrigado por perguntar. Como posso te ajudar hoje?";
    } else if (input == "tchau") {
        return "Tchau, até a próxima! :)";
    } else {
        return "Não entendi muito bem sua pergunta! Poderia digitar mais uma vez?";
    }
}