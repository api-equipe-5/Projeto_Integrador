// Opções que o usuário pode digitar
pg = "\n\na. Como posso ajudar a Ong?\nb. Não consigo entrar em contato\nc. O que eu preciso para cadastrar um projeto?\nd. Qual o objetivo da Ong?\ne. Outra pergunta\n\nEscolha uma letra."

const prompts = [
  ["oi", "eae", "ola", "salve", "bom dia", "boa tarde", "boa noite"],
  ["tudo bem", "você esta bem", "tudo certo", "como voce esta"],
  ["quem te criou", "quem te desenvolveu"],
  ["seu nome", "me fala seu nome", "humano ou robo", "como posso te chamar"],
  ["ah", "sim", "okay", "ok", "legal", "obrigada", "obrigado", "tudo bem", "valeu", "tchau", "adeus", "até logo"],
  ["a"], 
  ["b"], 
  ["c"], 
  ["d"], 
  ["e"],
  ["nem uma", "nenhuma"],
]

// Respostas possíveis, na ordem correspondente

const replies = [
  ["Olá, como posso te ajudar?" + pg, "Oi, posso te ajudar?" + pg],
  ["Tudo certo, em que posso ser útil?", "Tudo bem sim, está precisando de ajuda?",],
  ["Eu fui codada pela Deskware, em que posso te ajudar?"],
  ["Sou a engime da página, estou aqui para te ajudar. Qual sua dúvida?"],
  ["Estou aqui para te ajudar, chame-me quando precisar!"],
  ["Você pode se voluntariar ou doar alguma quantia. Confira mais informações na aba ajude."], 
  ["Tente ligar novamente para o número (12)3966-2823 dentre algumas horas. Outras informações de contato podem ser encontradas no rodapé."], 
  ["Você precisa enviar e aguardar a aprovação pela Ong."],
  ["Contribuir para o bem-estar, a valorização pessoal e a plena integração social das crianças. Confira mais informações na página sobre."], 
  ["Tente contatar nossa Ong via e-mail ou telefonema."],
  ["Ok, chame-me quando precisar!"],
]

// Aleatório para qualquer outra entrada do usuário

const alternative = [
  "Em que posso te ajudar?" + pg, 
  "Qual sua pergunta?" + pg,
  "Diga-me sua pergunta" + pg,
]

// oq vc quiser:

const coronavirus = [
  "Devemos tomar todos os cuidados até passar", 
  "Se apresentar sintomas procure ajuda médica",
  "Cuide-se, vai passar",
]

const help = [
  "Encontre ajuda, fale com alguém de sua confiança ou com a cvv, 188",
]

const who = [
  "Eu fui codada pela Deskware, em que posso te ajudar?",
]