<!DOCTYPE html>
<html lang="pt-br">

<head>

    <link rel="shortcut icon" href="imagens/fav.ico">
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Mr.Academy</title>
    <!--
        CSS
        ============================================= -->
  
  
  





    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="robots" content="noindex">
    <style>
        body {
            font-family: "Arial";
        }

        @media print {
            .no-print,
            .no-print * {
                display: none !important;
            }
        }

        .document {
            margin: auto auto;
            width: 216mm;
            height: 108mm;
            background-color: #fff;
        }

        .headerBtn {
            margin: auto auto;
            width: 216mm;
            background-color: #fff;
            display: none;
        }

        table {
            width: 100%;
            position: relative;
            border-collapse: collapse;
        }

        .bankLogo {
            width: 28%;
        }

        .boletoNumber {
            width: 62%;
            font-weight: bold;
        }

        .center {
            text-align: center;
        }

        .right {
            text-align: right;
            right: 20px;
        }

        td {
            position: relative;
        }

        .title {
            position: absolute;
            left: 0px;
            top: 0px;
            font-size: 12px;
            font-weight: bold;
        }

        .text {
            font-size: 12px;
        }

        p.content {
            padding: 0px;
            width: 100%;
            margin: 0px;
            font-size: 12px;
        }

        .sideBorders {
            border-left: 1px solid black;
            border-right: 1px solid black;
        }

        hr {
            size: 1;
            border: 1px dashed;
        }

        br {
            content: " ";
            display: block;
            margin: 12px 0;
            line-height: 12px;
        }

        .print {
            /* TODO(dbeam): reconcile this with overlay.css' .default-button. */
            background-color: rgb(77, 144, 254);
            background-image: linear-gradient(to bottom, rgb(77, 144, 254), rgb(71, 135, 237));
            border: 1px solid rgb(48, 121, 237);
            color: #fff;
            text-shadow: 0 1px rgba(0, 0, 0, 0.1);
        }

        .btnDefault {
            font-kerning: none;
            font-weight: bold;
        }

        .btnDefault:not(:focus):not(:disabled) {
            border-color: #808080;
        }

        button {
            border: 1px;
            padding: 5px;
            line-height: 20px;
        }


    
    i[class*=icss-]{position:relative;display:inline-block;font-style:normal;background-color:currentColor;-webkit-box-sizing:border-box;box-sizing:border-box;vertical-align:middle}i[class*=icss-]:after,i[class*=icss-]:before{content:"";border-width:0;position:absolute;-webkit-box-sizing:border-box;box-sizing:border-box}i.icss-print{width:.68em;height:1em;border-style:solid;border-color:currentcolor;border-width:.07em;-webkit-border-radius:.05em;border-radius:.05em;background-color:transparent;margin:0 .17em}i.icss-print:before{width:1em;height:.4em;border-width:.07em .21em 0;border-style:solid;border-color:currentColor currentcolor transparent;-webkit-border-radius:.05em .05em 0 0;border-radius:.05em .05em 0 0;top:.25em;left:50%;-webkit-transform:translateX(-50%);-ms-transform:translateX(-50%);transform:translateX(-50%);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(20%,transparent),color-stop(20%,currentcolor),color-stop(60%,currentcolor),color-stop(60%,transparent));background-image:-webkit-linear-gradient(transparent 20%,currentcolor 20%,currentcolor 60%,transparent 60%);background-image:-o-linear-gradient(transparent 20%,currentcolor 20%,currentcolor 60%,transparent 60%);background-image:linear-gradient(transparent 20%,currentcolor 20%,currentcolor 60%,transparent 60%)}i.icss-print:after{width:.45em;height:.065em;background-color:currentColor;left:50%;-webkit-transform:translateX(-50%);-ms-transform:translateX(-50%);transform:translateX(-50%);top:.6em;-webkit-box-shadow:0 .12em,-.1em -.28em 0 .05em;box-shadow:0 .12em,-.1em -.28em 0 .05em}i.icss-files{width:.75em;height:.95em;background-color:transparent;border:.05em solid transparent;border-width:0 .05em .05em 0;-webkit-box-shadow:inset 0 0 0 .065em,.13em .11em 0 -.05em;box-shadow:inset 0 0 0 .065em,.13em .11em 0 -.05em;-webkit-border-radius:0 .3em 0 0;border-radius:0 .3em 0 0;margin:0 .17em .05em .1em}i.icss-files:before{border-style:solid;border-width:.2em;top:.037em;left:.25em;-webkit-border-radius:.1em;border-radius:.1em;border-color:transparent currentColor transparent transparent;-webkit-transform:rotate(-45deg);-ms-transform:rotate(-45deg);transform:rotate(-45deg)}
        </style>

        <script type="text/javascript">
            window.onload = function getUrlParams() {
                var url_string = window.location.href;
                var url = new URL(url_string);
            
                var fmt = url.searchParams.get("fmt");
            
                if(fmt === "html") {
                    document.getElementById("headerBtn").style.display = "block";
                } 
            }
        </script>    
</head>

<body>
     <button onclick="jsvascript:window.print()">Imprimir</button>
    <br/>
    <div class="headerBtn" id="headerBtn">
        <div style="text-align:right;">
            <button class="no-print btnDefault print" onclick="window.print()">
                <i class="icss-print"></i>
                <span class="align">&nbspImprimir</span>
            </button>
            <button class="no-print btnDefault print" onclick="window.location='./boleto?fmt=pdf&id={{bsonMongoToString .View.ID}}&pk={{.View.PublicKey}}'">
                <i class="icss-files"></i>
                <span class="align">&nbspGerar PDF</span>
            </button>            
        </div>
    </div>
    <br/>
    <div class="document">
        <table cellspacing="0" cellpadding="0">
            <tr class="topLine">
                <td class="bankLogo">
                    <img src="imagens/nome.png" alt="imagem" width="200px" height="50px">
                </td>
                <td class="sideBorders center"><span style="font-size:24px;font-weight:bold;">341-7</span></td>
                <td class="boletoNumber center"><span>34191.12345 67890.101112 13141.516171 8 12345678901112</span></td>
            </tr>
        </table>
        <table cellspacing="0" cellpadding="0" border="1">
            <tr>
                <td width="70%" colspan="6">
                    <span class="title">Local de Pagamento</span>
                    <br/>
                    <span class="text">ATÉ O VENCIMENTO EM QUALQUER BANCO OU CORRESPONDENTE NÃO BANCÁRIO, APÓS O VENCIMENTO, PAGUE EM QUALQUER BANCO OU CORRESPONDENTE NÃO BANCÁRIO</span>
                </td>
                <td width="30%">
                    <span class="title">Data de Vencimento</span>
                    <br/>
                    <br/>
                    <p class="content right text" style="font-weight:bold;">00/00/2020</p>
                </td>
            </tr>
            <tr>
                <td width="70%" colspan="6">
                    <span class="title">Nome do Beneficiário / CNPJ / CPF / Endereço:</span>
                    <br/>
                    <table border="0" style="border:none">
                        <tr>
                            <td width="60%"><span class="text">Simulação</span></td>
                            <td><span class="text">CNPJ 01.000.000/0001-00</span></td>
                        </tr>
                    </table>
                    <br/>
                    <span class="text">Avenida Cesare Monsueto Giulio Lattes, 1350 Distrito - Eugênio de Melo, São José dos Campos - SP, 12247-014</span>
                </td>
                <td width="30%">
                    <span class="title">Agência/Código Beneficiário</span>
                    <br/>
                    <br/>
                    <p class="content right">1234/12345-1</p>
                </td>
            </tr>

            <tr>
                <td width="15%">
                    <span class="title">Data do Documento</span>
                    <br/>
                    <p class="content center">01/07/2015</p>
                </td>
                <td width="17%" colspan="2">
                    <span class="title">Num. do Documento</span>
                    <br/>
                    <p class="content center">1</p>
                </td>
                <td width="10%">
                    <span class="title">Espécie doc</span>
                    <br/>
                    <p class="content center">DM</p>
                </td>
                <td width="8%">
                    <span class="title">Aceite</span>
                    <br/>
                    <p class="content center">N</p>
                </td>
                <td>
                    <span class="title">Data Processamento</span>
                    <br/>
                    <p class="content center">01/07/2015</p>
                </td>
                <td width="30%">
                    <span class="title">Carteira/Nosso Número</span>
                    <br/>
                    <br/>
                    <p class="content right">157/12345678-9</p>
                </td>
            </tr>

            <tr>
                <td width="15%">
                    <span class="title">Uso do Banco</span>
                    <br/>
                    <p class="content center">&nbsp;</p>
                </td>
                <td width="10%">
                    <span class="title">Carteira</span>
                    <br/>
                    <p class="content center">157</p>
                </td>
                <td width="10%">
                    <span class="title">Espécie</span>
                    <br/>
                    <p class="content center">R$</p>
                </td>
                <td width="8%" colspan="2">
                    <span class="title">Quantidade</span>
                    <br/>
                    <p class="content center">N</p>
                </td>
                <td>
                    <span class="title">Valor</span>
                    <br/>
                    <p class="content center">10,00</p>
                </td>
                <td width="30%">
                    <span class="title">(=) Valor do Documento</span>
                    <br/>
                    <br/>
                    <p class="content right">10,00</p>
                </td>
            </tr>
            <tr>
                <td colspan="6" rowspan="4">
                    <span class="title">Instruções de responsabilidade do BENEFICIÁRIO. Qualquer dúvida sobre este boleto contate o beneficiário.</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="title">(-) Descontos/Abatimento</span>
                    <br/>
                    <p class="content right">&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="title">(+) Juros/Multa</span>
                    <br/>
                    <p class="content right">&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="title">(=) Valor Pago</span>
                    <br/>
                    <p class="content right">&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td colspan="7">
                    <table border="0" style="border:none">
                        <tr>
                            <td width="60%"><span class="text"><b>Nome do Pagador: </b> Pagador ABC</span></td>
                            <td><span class="text"><b>CNPJ/CPF: </b> 123.121.001-00</span></td>
                        </tr>
                        <tr>
                            <td><span class="text"><b>Endereço: </b> Avenida Brasil 1234 - Jardim Brasil - São Paulo - SP - 9999999-999</span></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td><span class="text"><b>Sacador/Avalista: </b> &nbsp;</span></td>
                            <td><span class="text"><b>CNPJ/CPF: </b> &nbsp;</span></td>
                        </tr>
                    </table>

                </td>

            </tr>
        </table>
    </div>
    <div class="document">
        <hr/>
        <table cellspacing="0" cellpadding="0">
            <tr class="topLine">
                <td class="bankLogo">
                    <img src="imagens/nome.png" alt="imagem" width="200px" height="50px">
                </td>
                <td class="sideBorders center"><span style="font-size:24px;font-weight:bold;">341-7</span></td>
                <td class="boletoNumber center"><span>34191.12345 67890.101112 13141.516171 8 12345678901112</span></td>
            </tr>
        </table>
        <table cellspacing="0" cellpadding="0" border="1">
            <tr>
                <td width="70%" colspan="6">
                    <span class="title">Local de Pagamento</span>
                    <br/>
                    <span class="text">ATÉ O VENCIMENTO EM QUALQUER BANCO OU CORRESPONDENTE NÃO BANCÁRIO, APÓS O VENCIMENTO, PAGUE EM QUALQUER BANCO OU CORRESPONDENTE NÃO BANCÁRIO</span>
                </td>
                <td width="30%">
                    <span class="title">Data de Vencimento</span>
                    <br/>
                    <br/>
                    <p class="content right text" style="font-weight:bold;">01/01/2016</p>
                </td>
            </tr>
            <tr>
                <td width="70%" colspan="6">
                    <span class="title">Nome do Beneficiário / CNPJ / CPF / Endereço:</span>
                    <br/>
                    <table border="0" style="border:none">
                        <tr>
                            <td width="60%"><span class="text">Simulação</span></td>
                            <td><span class="text">CNPJ 01.000.000/0001-00</span></td>
                        </tr>
                    </table>
                    <br/>
                    <span class="text">Rua teste, 1 - FATEC são josé dos campos - São Paulo - SP - 10000-000</span>
                </td>
                <td width="30%">
                    <span class="title">Agência/Código Beneficiário</span>
                    <br/>
                    <br/>
                    <p class="content right">1234/12345-1</p>
                </td>
            </tr>

            <tr>
                <td width="15%">
                    <span class="title">Data do Documento</span>
                    <br/>
                    <p class="content center">01/07/2015</p>
                </td>
                <td width="17%" colspan="2">
                    <span class="title">Num. do Documento</span>
                    <br/>
                    <p class="content center">1</p>
                </td>
                <td width="10%">
                    <span class="title">Espécie doc</span>
                    <br/>
                    <p class="content center">DM</p>
                </td>
                <td width="8%">
                    <span class="title">Aceite</span>
                    <br/>
                    <p class="content center">N</p>
                </td>
                <td>
                    <span class="title">Data Processamento</span>
                    <br/>
                    <p class="content center">01/07/2015</p>
                </td>
                <td width="30%">
                    <span class="title">Carteira/Nosso Número</span>
                    <br/>
                    <br/>
                    <p class="content right">157/12345678-9</p>
                </td>
            </tr>

            <tr>
                <td width="15%">
                    <span class="title">Uso do Banco</span>
                    <br/>
                    <p class="content center">&nbsp;</p>
                </td>
                <td width="10%">
                    <span class="title">Carteira</span>
                    <br/>
                    <p class="content center">157</p>
                </td>
                <td width="10%">
                    <span class="title">Espécie</span>
                    <br/>
                    <p class="content center">R$</p>
                </td>
                <td width="8%" colspan="2">
                    <span class="title">Quantidade</span>
                    <br/>
                    <p class="content center">N</p>
                </td>
                <td>
                    <span class="title">Valor</span>
                    <br/>
                    <p class="content center">10,00</p>
                </td>
                <td width="30%">
                    <span class="title">(=) Valor do Documento</span>
                    <br/>
                    <br/>
                    <p class="content right">10,00</p>
                </td>
            </tr>
            <tr>
                <td colspan="6" rowspan="4">
                    <span class="title">Instruções de responsabilidade do BENEFICIÁRIO. Qualquer dúvida sobre este boleto contate o beneficiário.</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="title">(-) Descontos/Abatimento</span>
                    <br/>
                    <p class="content right">&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="title">(+) Juros/Multa</span>
                    <br/>
                    <p class="content right">&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="title">(=) Valor Pago</span>
                    <br/>
                    <p class="content right">&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td colspan="7">
                    <table border="0" style="border:none">
                        <tr>
                            <td width="60%"><span class="text"><b>Nome do Pagador: </b> Pagador ABC</span></td>
                            <td><span class="text"><b>CNPJ/CPF: </b> 123.121.001-00</span></td>
                        </tr>
                        <tr>
                            <td><span class="text"><b>Endereço: </b> Avenida Brasil 1234 - Jardim Brasil - São Paulo - SP - 9999999-999</span></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td><span class="text"><b>Sacador/Avalista: </b> &nbsp;</span></td>
                            <td><span class="text"><b>CNPJ/CPF: </b> &nbsp;</span></td>
                        </tr>
                    </table>

                </td>

            </tr>
        </table>
        <br/>
        <img src="imagens/barras.png"
            alt="">
        <br/>
        <br/>
        <br/>
    </div>
    
            
</body>

</html>