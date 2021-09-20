var app = new Vue({
  el: "#address_inputs",
  data: {
    message: "Busque o endereço do seu CEP!",
    cep: "",
    erro: false,
    resultado: {},
    ceps: []
  },
  methods: {
    send: function (e) {
      e.preventDefault();
      this.$http
        .get("https://viacep.com.br/ws/" + this.cep + "/json/")
        .then(function (result) {
          this.resultado = result.data;
          console.log(this.resultado);
          this.erro = false;
          if (this.resultado.logradouro) {
            this.ceps.push(self.resultado);
          }
        })
        .catch(function (err) {
          this.erro = true;
          this.resultado = {};
        })
        .finally(function () {
          $("#numero").focus();
        });
    },
    limpar: function (e) {
      e.preventDefault();
      this.ceps = [];
      this.status = false;
      this.cep = "123";
      this.resultado = {};
    }
  }
});
