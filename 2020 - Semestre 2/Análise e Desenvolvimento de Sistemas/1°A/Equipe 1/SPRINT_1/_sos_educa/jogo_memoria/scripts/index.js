//Deck

let deck = [
  {
    id: 1,
    name: "Fonte",
    color: "#84CFFA",
    imagem: "https://images-na.ssl-images-amazon.com/images/I/713lc7EipEL._AC_SX466_.jpg",
    descricao: ["descricao 1", "descricao 2", "descricao 3"],
    virado: true,
  },
  {
    id: 2,
    name: "Pendrive",
    color: "#FA8484",
    imagem: "https://static3.tcdn.com.br/img/img_prod/49613/180_pendrive_16gb_altomex_al_u_16_5457_1_20191022142618.jpg",
    descricao: ["descricao 1", "descricao 2", "descricao 3"],
    virado: true,
  },
  {
    id: 3,
    name: "monitor",
    color: "#E984FA",
    imagem: "https://images.tcdn.com.br/img/img_prod/740836/monitor_concordia_gamer_curvo_c78_27_led_full_hd_ips_hdmi_vga_1585_1_20201002092005.jpg",
    descricao: ["descricao 1", "descricao 2", "descricao 3"],
    virado: true,
  },
  {
    id: 4,
    name: "gabinete",
    color: "#84FAAC",
    imagem: "https://www.oceanoinformatica.com.br/media/catalog/product/cache/1/thumbnail/2000x2000/9df78eab33525d08d6e5fb8d27136e95/g/a/gabinete_bg-00.jpg",
    descricao: ["descricao 1", "descricao 2", "descricao 3"],
    virado: true,
  },
  {
    id: 5,
    name: "pulseira antiestatica",
    color: "#8684FA",
    imagem: "https://cdn.dooca.store/27/products/pulseira_640x640+fill_ffffff.jpg?v=1596639504&webp=0",
    descricao: ["descricao 1", "descricao 2", "descricao 3"],
    virado: true,
  },
  {
    id: 6,
    name: "mouse",
    color: "#F7FA84",
    imagem: "https://images-na.ssl-images-amazon.com/images/I/613bhsrtc4L._AC_SX466_.jpg",
    descricao: ["descricao 1", "descricao 2", "descricao 3"],
    virado: true,
  },
];

const cards = document.querySelectorAll('.card');

let hasFlippedCard = false;
let lockBoard = false;
let firstCard, secondCard;
let movements = 0;
let winContador = 0;

function flipCard() {
  //this.classList.toggle('flip');
  if (lockBoard) return;
  if (this === firstCard) return;

  this.classList.add('flip');

   if (!hasFlippedCard) {
     hasFlippedCard = true;
     firstCard = this;
     return;
    }

    console.log(winContador)
     
    secondCard = this;
 
    checkForMatch();
}
 
  //Conferindo se é igual

  function checkForMatch() {
    if(firstCard.dataset.nome !== secondCard.dataset.nome) {
      movements++;
    }
    document.getElementById("movimentos").innerHTML = `${movements}`;
    document.getElementById("movimentos2").innerHTML = `${movements}`;
      
    if (firstCard.dataset.nome === secondCard.dataset.nome) {
      winContador++;
      disableCards();
      //ALTERAÇÃO* Confere se o "winContador" é igual a "6", que é o número máximo de vitórias que pode haver no jogo!
      if(winContador == 6) {
        setTimeout(() => {
          document.querySelector('#vitoria').style.display = 'block'
          document.querySelector('#movimentosvitoria').innerHTML = movements
        }, 1000);
      }
      //FIM-ALTERAÇÃO*
      return;
    }

 
    unflipCards();

    console.log(movements);

  }
 
  //Desabilitando o clique nas cartas viradas

  function disableCards() {
    firstCard.removeEventListener('click', flipCard);
    secondCard.removeEventListener('click', flipCard);

    resetBoard();
  }
 
  //Virando as cartas erradas de volta

  function unflipCards() {
    lockBoard = true;

    setTimeout(() => {
      firstCard.classList.remove('flip');
      secondCard.classList.remove('flip');

      resetBoard();

    }, 1500);
  }

  function resetBoard() {
    [hasFlippedCard, lockBoard] = [false, false];
    [firstCard, secondCard] = [null, null];
  }

  //Embaralhando cartas (IIFE) Vai ser executada assim que for lida

  (function shuffle() {
    cards.forEach(card => {
      let ramdomPos = Math.floor(Math.random() * 12);
      card.style.order = ramdomPos;
    });
  })();

cards.forEach(card => card.addEventListener('click', flipCard));


