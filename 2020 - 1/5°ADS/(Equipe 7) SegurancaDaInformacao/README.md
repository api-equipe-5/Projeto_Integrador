# Segurança Da Informação

## Integrantes

* Caíque Santos
https://www.linkedin.com/in/caique-rafael-dos-santos-477442195/
* Fabiola Siqueira
https://www.linkedin.com/mwlite/in/fab%C3%ADola-siqueira-874b09192
* Jair Aragão

* Nache Matos

* Rafael Rezende
https://www.linkedin.com/mwlite/in/rafael-rezende-633249143
* Robson Martins
https://www.linkedin.com/in/robsonmartinssilva

## Proposta

Software que mostrará e solicitará permissão quando as políticas de uso de informações forem atualizadas e enviará um documento via email informando de maneira simples o uso e os responsáveis pelos dados assim como exigido na LGPD.
O documento será gerado com base nas informações passadas através de uma interface utilizada pelo responsavél da empresa.
A integridade da informação passada será garantida por um hash.

## 1° Entrega
* Hash ainda não implementado
* Front-end POP-UPs usuário final

## 2° Entrega
* Envio automático de email

## 3° Entrega
* Criação do questionario a ser preenchido pelos controladores de dados

## 4° Entrega
* Alteração do envio automático de emails, passando a usar javax.email

* Algoritmo de hash aplicado a documento PDF

[![Descrição do algoritmo de Hash](http://img.youtube.com/vi/NNC2F3Ef_oI/0.jpg)](http://www.youtube.com/watch?v=NNC2F3Ef_oI "Funcionamento Algoritmo de Hash")

* Passagem de respostas dadas no questionário para arquivo PDF usando PHP
![gifqpdf1](https://github.com/JairAragao/SegurancaDaInformacao/blob/master/imagens/entrega_4/gifqpdf2.gif)
![gifpdf2](https://github.com/JairAragao/SegurancaDaInformacao/blob/master/imagens/entrega_4/gifpdf2.gif)

## 5° Entrega

* Criação de banco de dados de clientes e controladores
![bancos](https://github.com/JairAragao/SegurancaDaInformacao/blob/master/imagens/entrega_5/banco.gif)

* Criação de login para os controladores de dados
![login1](https://github.com/JairAragao/SegurancaDaInformacao/blob/master/imagens/entrega_5/login1.gif)
![login2](https://github.com/JairAragao/SegurancaDaInformacao/blob/master/imagens/entrega_5/login2.gif)

* Adição de condições de preenchimento e interação entre pop-ups
![pop-ups](https://github.com/JairAragao/SegurancaDaInformacao/blob/master/imagens/entrega_5/pop-ups.gif)

## 6° Entrega

* Integração de relatorio com envio de email						
* Integração de pop-up com envio de email						
* Correção de erro na integração de hash						
* Configuração de registro de data e hora											

## Tecnologias e Requisitos necessários para o funcionamento dos códigos

Transformação do questionario html em pdf com PHP
1.	Instalar o composer https://getcomposer.org/download/
2.	Abrir o cmd no diretório da pasta dentro do xampp
3.	No cmd, digitar o comando:  composer require mpdf/mpdf
4.	Adicionar em mpdf.php:  require_once __DIR__ . '/vendor/autoload.php';

