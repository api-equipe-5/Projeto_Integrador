## Este projeto segue as diretrizes e metodologias da Open Web Application Security Project (OWASP) para senhas e criptografia:

   - [x] Usar "senhas fortes" baseadas em algoritmos AES;
   - [x] Usar o modo GCM de operações para criptografias de chaves simétricas;
   - [x] Chaves para criptografias devem ser rotacionadas pelo menos uma vez ao ano;
   - [x] Somente usar algoritmos tipo **SHA-256** publicamente aprovados ou melhor para hashing;
   - [x] Argon2 é o vencedor da competição de hashing e deve ser sua primeira escolha para novas aplicações.
   
Veja: 
* https://www.owasp.org/index.php/Cryptographic_Storage_Cheat_Sheet
* https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet
