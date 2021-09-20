msgn = 0;

class Validator {

  constructor() {
    this.validations = [
      'data-min-length',
      'data-max-length',
      'data-only-letters',
      'data-email-validate',
      'data-required',
      'data-equal',
      'data-password-validate',
    ]
  }

//inicar a validação
 validate(form) {
   
    // limpa todas as validações antigas
    let currentValidations = document.querySelectorAll('form .error-validation');
    if(currentValidations.length) {
      this.cleanValidations(currentValidations);
    }
    
    //pegar os imputs
    let inputs = form.getElementsByTagName('input');

    //transformar uma htmlcollection para array
    let inputsArray = [...inputs];

    //loop nos inputs para validar
    inputsArray.forEach(function(input, obj) {

      //loop em todas as validações
      for(let i = 0; this.validations.length > i; i++) {

        //verifica se a validação existe no input
        if(input.getAttribute(this.validations[i]) != null) {

          // limpa string para saber o método
          let method = this.validations[i].replace("data-", "").replace("-", "");

          // valor do input
          let value = input.getAttribute(this.validations[i])

          // invoca o método
          this[method](input,value);

        }

      }

    }, this);

  }
  
  // método para validar se tem um mínimo de caracteres
  minlength(input, minValue) {

    let inputLength = input.value.length;

    let errorMessage = `O campo precisa ter pelo menos ${minValue} caracteres`;

    if(inputLength < minValue) {
      this.printMessage(input, errorMessage);
    }
    else{
      msgn = msgn+1
    }

  }

  // método para validar se passou do máximo de caracteres
  maxlength(input, maxValue) {

    let inputLength = input.value.length;

    let errorMessage = `O campo precisa ter menos que ${maxValue} caracteres`;

    if(inputLength > maxValue) {
      this.printMessage(input, errorMessage);
    }
    else if(inputLength < maxValue || inputLength === maxValue){
      msgn = msgn+1
    }

  }

  // método para validar strings que só contem letras
  onlyletters(input) {

    let re = /^[A-Za-z]+$/;;

    let inputValue = input.value;

    let errorMessage = `Insira um sobrenome válido, sem números nem caracteres especiais`;

    if(!re.test(inputValue)) {
      this.printMessage(input, errorMessage); 
    }

  }

  // método para validar e-mail
  emailvalidate(input) {
    let re = /\S+@\S+\.\S+/;

    let email = input.value;

    let errorMessage = `Insira um e-mail no padrão maria@gmail.com`;

    if(!re.test(email)) {
      this.printMessage(input, errorMessage);
    }
    else {
      msgn = msgn+1
    }
  }

  // verificar se um campo está igual o outro
  equal(input, inputName) {

    let inputToCompare = document.getElementsByName(inputName)[0];

    let errorMessage = `As senhas precisam ser iguais`;

    if(input.value != inputToCompare.value) {
      this.printMessage(input, errorMessage);
    }
    else if(input.value === inputToCompare.value){
      msgn = msgn+1
    }
  }
  
  // método para exibir inputs que são necessários
  required(input) {

    let inputValue = input.value;

    if(inputValue === '') {
      let errorMessage = `Campo obrigatório`;

      this.printMessage(input, errorMessage);
    }
    else if(inputValue != ''){
      msgn = msgn+1
    }
  }

  // validando o campo de senha
  passwordvalidate(input) {

    // explodir string em array
    let charArr = input.value.split("");

    let uppercases = 0;
    let numbers = 0;

    for(let i = 0; charArr.length > i; i++) {
      if(charArr[i] === charArr[i].toUpperCase() && isNaN(parseInt(charArr[i]))) {
        uppercases++;
      } else if(!isNaN(parseInt(charArr[i]))) {
        numbers++;
      }
    }

    if(uppercases === 0 || numbers === 0) {
      let errorMessage = `A senha precisa um caractere maiúsculo e um número`;

      this.printMessage(input, errorMessage);
    }
    else if(uppercases != 0 || numbers != 0){
      msgn = msgn+1
    }
  }

  // método para imprimir mensagens de erro
  printMessage(input, msg) {
  
    // checa os erros presentes no input
    let errorsQty = input.parentNode.querySelector('.error-validation');

    // imprimir erro só se não tiver erros
    if(errorsQty === null) {
      let template = document.querySelector('.error-validation').cloneNode(true);

      template.textContent = msg;
  
      let inputParent = input.parentNode;
  
      template.classList.remove('template');
  
      inputParent.appendChild(template);

    }
    else if(errorsQty != null && msgn === 6) {
    alert("Parabéns sua solicitação foi enviada, aguarde a aprovação")
    open("index.html")
  }
  }

  // remove todas as validações para fazer a checagem novamente
  cleanValidations(validations) {
    validations.forEach(el => el.remove());
  }

}

let form = document.getElementById('register-form');
let submit = document.getElementById('btn-submit');

let validator = new Validator();

// evento de envio do form, que valida os inputs

submit.addEventListener('click', function(e) {
  e.preventDefault();

  validator.validate(form);
});

