  var ok = document.getElementById('ok');
  input2 = document.getElementById("input");
  ok.addEventListener("click", function() {
    if (input2.value !==  "") {
      let input = input2.value;
      input2.value = "";
      output(input);
    }
  });


function output(input) {
  let product;


  // Regex remove caracteres sem palavra / espaço
  // Cortar o whitespce à direita

  let text = input.toLowerCase().replace(/[^\w\s]/gi, "").replace(/[\d]/gi, "").trim();
  text = text
    .replace(/ olá /g, "ola")   
    .replace(/você /g, "voce")
    .replace(/vc/g, "voce")
    .replace(/obg/g, "obrigada")
    .replace(/está/g, "esta")
    .replace(/td/g, "tudo")
    .replace(/vlw/g, "obrigada")

    if (compare(prompts, replies, text)) { 
      // Procure por correspondência exata em `prompts`
      product = compare(prompts, replies, text);
    } else if (text.match(/thank/gi)) {
      product = "You're welcome!"
    } else if (text.match(/(corona|covid|virus)/gi)) {
      // Se não houver correspondência, verifique se a mensagem contém `coronavirus`
      product = coronavirus[Math.floor(Math.random() * coronavirus.length)];
    } else if (text.match(/(criou|fez|desenvolveu)/gi)) {
      // Se não houver correspondência, verifique se a mensagem contém algo que indique curiosidade sobre a criação
      product = who[Math.floor(Math.random() * who.length)];
    } else if (text.match(/(morrer|suicidio|matar)/gi)) {
      // Se não houver correspondência, verifique se a mensagem contém algo que necessite outra ajuda
      product = help[Math.floor(Math.random() * help.length)];
    } else {
      // Se não houver ainda, alternativa aleatória
      product = alternative[Math.floor(Math.random() * alternative.length)];
    }

  // Atualizar DOM
  addChat(input, product);
}

function compare(promptsArray, repliesArray, string) {
  let reply;
  let replyFound = false;
  for (let x = 0; x < promptsArray.length; x++) {
    for (let y = 0; y < promptsArray[x].length; y++) {
      if (promptsArray[x][y] === string) {
        let replies = repliesArray[x];
        reply = replies[Math.floor(Math.random() * replies.length)];
        replyFound = true;  
  // para o loop interno quando o valor de entrada corresponde aos prompts
        break;
      }
    }
    if (replyFound) {
  // Pare o loop externo quando a resposta for encontrada, em vez de interagir com toda a matriz
      break;
    }
  }
  return reply;
}

function addChat(input, product) {
  const messagesContainer3 = document.getElementById("messages");

  let userDiv = document.createElement("div");
  userDiv.id = "user";
  userDiv.className = "user response";
  userDiv.innerHTML = `<span>${input}</span><img src="user.png" class="avatar">`;
  messagesContainer3.appendChild(userDiv);

  let botDiv = document.createElement("div");
  let botText = document.createElement("span");
  let botImg = document.createElement("img");
  botImg.src = "ilustras-chatbot.png";
  botImg.className = "avatar";
  botDiv.className = "bot response";
  botText.innerText = "Digitando...";
  botDiv.appendChild(botImg);
  botDiv.appendChild(botText);
  messagesContainer3.appendChild(botDiv);
  // Manter as mensagens mais recentes
  messagesContainer3.scrollTop = messagesContainer3.scrollHeight - messagesContainer3.clientHeight;

// Atraso falso para parecer mais "real"
  setTimeout(() => {
    botText.innerText = `${product}`;
    textToSpeech(product)
  }, 1500
  )

}