//setInterval(ContarSegundos, 1000);
        
        //MOVER IMAGENS//
        
        
$(window).ready(function(){
              
        });
  
  
  window.onload = function (){
     telaInicial();
  }
  
  function telaInicial(){
      document.getElementById("div_conteudo").innerHTML = "";
      
      recebeHtml = `
              <div id="div_conteudotopo">
                  <div class="form-row">
                      <div class="form-group col-md-3">
                          
                          
                      </div>
                      <div class="form-group col-md-6">
                          
                          
                               </div>
                      <div class="form-group col-md-3">
                          
                          
                      </div>
                      
                  </div>
          </div>
          <div id="div_conteudocentral">
              <div class="form-row">
                      <div class="form-group col-md-10">
                          <div id="div_conteudocentraldinamico">
                              <div id="div_imageminicial">
                                  <img id="img_bruxo" src="img/ico_bruxo.jpeg">
                              </div>
                          </div>  
                      </div>
                </div>                                     
          </div>
              
          <div id="div_conteudorodape">
              <div class="form-row">
                      <div class="form-group col-md-11">
                          <div id="div_botoes">
                              <button type="button" class="btn btn-warning" onclick="passo1();" id="btn_facasimulacao">Faça Sua Simulação</button>
                          </div>
                          
                      </div>
                      
                  </div>
      </div>
  



          
      `;
      document.getElementById("div_conteudo").innerHTML += recebeHtml;
  }

  function passo1(){
      document.getElementById("div_conteudo").innerHTML = "";
      
      recebeHtml = `
              <div id="div_conteudotopo">
                  <div class="form-row">
                      <div class="form-group col-md-3">
                          <div id="div_conteudotopoScoreAtual">
                             <span id="span_score"  class="badge badge-primary">Score</span>
                          </div>
                          
                      </div>
                      <div class="form-group col-md-6">
                          
                          
                               </div>
                      <div class="form-group col-md-3">
                          <div id="div_conteudotopoXP">
                              <span id="span_xp" class="badge badge-primary">XP</span>
                          </div>
                          
                      </div>
                      
                  </div>
          </div>
          <div id="div_conteudocentral">
               <div class="form-row">
                      <div class="form-group col-md-5">
                          <div id="div_conteudocentraldinamico">
                              <div id="div_selectobjetivo">
                                  <label for="id_objetivo">Escolha objetivo: </label>
                                  <select name="objetivo" class="form-control" title="" required="" id="id_objetivo">
                                      <option value="">----------</option>
                                      <option value="Empréstimo" >Empréstimo</option>
                                      <option value="Cartão de Crédito" >Cartão de Crédito</option>
                                      <option value="Financiamento" >Financiamento</option>
                                      <option value="Apenas consulta score" >Apenas consulta score</option>
                                 </select>
                              </div>
                          </div>  
                      </div>
                  
                  <div class="form-group col-md-5">

                              <div id="div_imagemobjetivo">
                                  <img id="img_objetivo" src="img/ico_pessoasfelizes1.jpg">
                                 
                              </div>

                      </div>
                      
                  </div>                             
          </div>
              
          <div id="div_conteudorodape">
              <div class="form-row">
                      <div class="form-group col-md-11">
                          <div id="div_botoes">
                              <button type="button" class="btn btn-outline-success" id="btn_avancar" onclick="passo2();">Avançar</button>
                              <button type="button" class="btn btn-outline-danger" id="btn_voltar" onclick="telaInicial();">Voltar a tela inicial</button>
                          </div>
                         
                          
                      </div>
                      
                  </div>
      </div>



             
          `;
      document.getElementById("div_conteudo").innerHTML += recebeHtml;
      
  }
  
  function passo2(){
      
       document.getElementById("div_conteudo").innerHTML = "";
      recebeHtml = `
                  <div id="div_conteudotopo">
                  <div class="form-row">
                      <div class="form-group col-md-3">
                          <div id="div_conteudotopoScoreAtual">
                             <span id="span_score"  class="badge badge-primary">Score</span>
                          </div>
                          
                      </div>
                      <div class="form-group col-md-6">
                          
                          
                               </div>
                      <div class="form-group col-md-3">
                          <div id="div_conteudotopoXP">
                              <span id="span_xp" class="badge badge-primary">XP</span>
                          </div>
                          
                      </div>
                      
                  </div>
          </div>
          <div id="div_conteudocentral">
               <div class="form-row">
                    <div class="form-group col-md-6">
                              <div id="div_imagemmetas">
                                  <img id="img_metas" src="img/ico_metas.jpg">
                                 
                              </div>
                      </div>
                      <div class="form-group col-md-5">
                          <div id="div_conteudocentraldinamico">
                             
                              <span id="span_metas" class="badge badge-info">Escolha suas metas: </span>
                              <div id="div_metas">
                                      <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Quitar cartão de crédito" aria-label="Text input with checkbox">
                                          </div>
                                  <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar 2 parcelas atrasadas de empréstimo" aria-label="Text input with checkbox">
                                          </div>
                                  
                                  <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar 3 faturas atrasadas financiamento" aria-label="Text input with checkbox">
                                          </div>
                                  
                                  <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar ultima fatura do cartão de crédito." aria-label="Text input with checkbox">
                                          </div>
                                   <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar ultima fatura do cartão de crédito." aria-label="Text input with checkbox">
                                          </div>
                                   <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar ultima fatura do cartão de crédito." aria-label="Text input with checkbox">
                                          </div>
                                   <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar ultima fatura do cartão de crédito." aria-label="Text input with checkbox">
                                          </div>
                                   <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar ultima fatura do cartão de crédito." aria-label="Text input with checkbox">
                                          </div>
                                   <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                              <div class="input-group-text">
                                                <input type="checkbox" aria-label="Checkbox for following text input">
                                              </div>
                                            </div>
                                            <input type="text" readonly="true" class="form-control" value="Pagar ultima fatura do cartão de crédito." aria-label="Text input with checkbox">
                                          </div>
                                  
                                  
                                  
                                      
                              </div>
                          </div>  
                      </div>
                  
                 
                      
                  </div>                             
          </div>
              
          <div id="div_conteudorodape">
              <div class="form-row">
                      <div class="form-group col-md-11">
                          <div id="div_botoes">
                              <button type="button" class="btn btn-outline-success" id="btn_avancar" onclick="telaResultado();">Avançar</button>
                              <button type="button" class="btn btn-outline-danger" id="btn_voltar" onclick="passo1();">Voltar</button>
                          </div>
                         
                          
                      </div>
                      
                  </div>
      </div>

          `;
      
      document.getElementById("div_conteudo").innerHTML += recebeHtml;
  }
  
  
  function telaResultado(){
      
      document.getElementById("div_conteudo").innerHTML = "";
      
      recebeHtml = `<div id="div_conteudotopo">
                  <div class="form-row">
                      <div class="form-group col-md-3">
                          
                          
                      </div>
                      <div class="form-group col-md-6">
                          
                          
                               </div>
                      <div class="form-group col-md-3">
                          
                          
                      </div>
                      
                  </div>
          </div>
          <div id="div_conteudocentral">
              <div class="form-row">
                      <div class="form-group col-md-6">
                          
                              <div id="div_imagemOriginal">
                                  <img id="img_bruxoOriginal" src="img/ico_bruxoOriginal.jpeg">
                              </div>
                              
                      </div>
                  <div class="form-group col-md-4">
                          
                              <div id="div_resultado">
                                 
                                  
                                  
                                  
                              </div>
                              
                      </div>
                </div>                                     
          </div>
              
          <div id="div_conteudorodape">
              
      </div>
  `;
      
      document.getElementById("div_conteudo").innerHTML += recebeHtml;
      
      $("#img_bruxoOriginal").animate({ 
          // distancia da margem a esquerda
          marginRight: "240px",
          // distância do topo
          width: "300px"
          // tempo de execucao - milissegundos
          }, 1000, function() {
           textoResultado();
          botaoNovaSimulacao();
          });
      
      
  }
  
  function textoResultado(){
      
      
      recebeHtml = ` <div class="form-col">
          <div class="form-group row-md-4">
              <label class="letraResultado">Seu Score será de 760!</label>
          </div>
           <div class="form-group row-md-4">
               <label class="letraResultado">Você terá 80% de atingir "objetivo" com as metas selecionadas! </label>
          </div>
          <div class="form-group row-md-4">
               <label class="letraResultadoParabens">Parabéns!!! </label>
          </div>

      </div>`;
      
      document.getElementById("div_resultado").innerHTML += recebeHtml;
      
  }
  
  function botaoNovaSimulacao(){
      
      recebeHtml = `<div class="form-row">
                      <div class="form-group col-md-11">
                         <button type="button" class="btn btn-success" onclick="telaInicial();" id="btn_novasimulacao">Nova simulação</button>
                          
                      </div>
                      
                  </div>`;
      
      document.getElementById("div_conteudorodape").innerHTML += recebeHtml;
  };

