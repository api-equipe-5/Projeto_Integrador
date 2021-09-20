-- Clientes

insert into cliente (cpf, email, endereco, nome, senha, sobrenome, telefone) values ('345.678.901-12', 'maria@gmail.com', 'Rua Quinze De Novembro, 105 - São Paulo - SP', 'Maria', '123123', 'da Silva', '1194544666');
insert into cliente (cpf, email, endereco, nome, senha, sobrenome, telefone) values ('245.578.701-30', 'joao@gmail.com', 'Rua Tiradentes, Apto 13 - São Paulo - SP', 'João', '321321', 'de Paula', '1194765345');
insert into cliente (cpf, email, endereco, nome, senha, sobrenome, telefone) values ('432.123.421-20', 'joana@gmail.com', 'Rua Amazonas, 570 - São Paulo - SP', 'Joana', '456456', 'de Sousa', '1192231543');
insert into cliente (cpf, email, endereco, nome, senha, sobrenome, telefone) values ('231.532.123-11', 'marcos@gmail.com', 'Rua Sao Sebastiao, 70 - São Paulo - SP', 'Marcos', '789789', 'de Jesus', '1198234233');
insert into cliente (cpf, email, endereco, nome, senha, sobrenome, telefone) values ('412.322.321-08', 'pedro@gmail.com', 'Rua Bela Vista, 372 - São Paulo - SP', 'Pedro', '789789', 'Castro', '1195675433');

-- Empresas (Hardware)

-- Placas-mãe (empresas)
insert into empresa (nome) values ('Asus');
insert into empresa (nome) values ('Aorus');
insert into empresa (nome) values ('Gigabyte');

-- HDs (empresas)

insert into empresa (nome) values ('Seagate');
insert into empresa (nome) values ('Toshiba');
insert into empresa (nome) values ('Western Digital');

-- Memória RAM (empresas)

insert into empresa (nome) values ('Hyperx');
insert into empresa (nome) values ('Kingston');
insert into empresa (nome) values ('Corsair');

-- Processadores (empresas)

insert into empresa (nome) values ('Intel');
insert into empresa (nome) values ('AMD');


-- Categoria

insert into categoria (descricao) values ('Placas-mãe');
insert into categoria (descricao) values ('Memória RAM');
insert into categoria (descricao) values ('Disco Rígido');
insert into categoria (descricao) values ('Processadores');

-- Produto

-- Placas-mãe (Produto)
insert into produto (categoria_id, descricao, valor) values ('1', 'Placa-Mãe Gigabyte GA-AB350M-DS3H V2, AMD AM4, mATX, DDR4', '700');
insert into produto (categoria_id, descricao, valor) values ('1', 'Placa-Mãe Asus Prime A320M-K/BR, AMD AM4, mATX, DDR4', '540');
insert into produto (categoria_id, descricao, valor) values ('1', 'Placa-Mãe Gigabyte Aorus B360 Aorus Gaming 3, Intel LGA 1151, ATX, DDR4', '1300');

-- Memória RAM (Produto)

insert into produto (categoria_id, descricao, valor) values ('2', 'Memória HyperX Fury, 8GB, 2666MHz, DDR4, CL16, Preto - HX426C16FB3/8', '269');
insert into produto (categoria_id, descricao, valor) values ('2', 'Memória Corsair Vengeance LPX, 8GB, 2400MHz, DDR4, CL16, Preto - CMK8GX4M1A2400C16', '239');
insert into produto (categoria_id, descricao, valor) values ('2', 'Memória Kingston 4GB, 1333MHz, DDR3, Notebook, CL9 - KCP313SS8/4', '166');

-- HDs (Produto)
insert into produto (categoria_id, descricao, valor) values ('3', 'HD WD Blue, 1TB, 3.5, SATA - WD10EZEX', '220');
insert into produto (categoria_id, descricao, valor) values ('3', 'HD Seagate BarraCuda, 1TB, 3.5, SATA - ST1000DM010', '200');
insert into produto (categoria_id, descricao, valor) values ('3', 'HD Toshiba P300, 1TB, 3.5, SATA - HDWD110UZSVA', '280');

-- Processadores (Produto)
insert into produto (categoria_id, descricao, valor) values ('4', 'Processador AMD Ryzen 5 1600, Cache 19MB, 3.2GHz (3.6GHz Max Turbo), AM4 - YD1600BBAFBOX', '800');
insert into produto (categoria_id, descricao, valor) values ('4', 'Processador Intel Core i5-9400F Coffee Lake, Cache 9MB, 2.9GHz (4.1GHz Max Turbo), LGA 1151, Sem Vídeo - BX80684I59400F', '990');


-- Configuração-compartilhamento

insert into configuracao_compartilhamento (compartilha_dados_compras, compartilha_dados_pessoais, cliente_id) values (true,true,'1');
insert into configuracao_compartilhamento (compartilha_dados_compras, compartilha_dados_pessoais, cliente_id) values (true,false,'2');
insert into configuracao_compartilhamento (compartilha_dados_compras, compartilha_dados_pessoais, cliente_id) values (false,false,'3');
insert into configuracao_compartilhamento (compartilha_dados_compras, compartilha_dados_pessoais, cliente_id) values (false,true,'4');
insert into configuracao_compartilhamento (compartilha_dados_compras, compartilha_dados_pessoais, cliente_id) values (true,true,'5');

-- Carrinho

insert into carrinho (cliente_id) values ('1');
insert into carrinho (cliente_id) values ('1');
insert into carrinho (cliente_id) values ('2');
insert into carrinho (cliente_id) values ('2');
insert into carrinho (cliente_id) values ('3');
insert into carrinho (cliente_id) values ('3');
insert into carrinho (cliente_id) values ('4');
insert into carrinho (cliente_id) values ('4');
insert into carrinho (cliente_id) values ('5');
insert into carrinho (cliente_id) values ('5');

--Cliente 1 (Carrinho 1)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('1', '1');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('1', '4');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('1', '7');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('1', '11');

--Cliente 1 (Carrinho 2)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('2', '2');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('2', '5');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('2', '9');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('2', '10');


--Cliente 2 (Carrinho 1)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('3', '2');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('3', '5');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('3', '6');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('3', '9');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('3', '10');

--Cliente 2 (Carrinho 2)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('4', '2');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('4', '5');

--Cliente 3 (Carrinho 1)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('5', '3');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('5', '6');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('5', '8');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('5', '10');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('5', '11');

--Cliente 3 (Carrinho 2)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('6', '1');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('6', '5');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('6', '7');

--Cliente 4 (Carrinho 1)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('7', '1');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('7', '4');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('7', '9');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('7', '10');

--Cliente 4 (Carrinho 2)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('8', '3');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('8', '4');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('8', '8');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('8', '11');

--Cliente 5 (Carrinho 1)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('9', '1');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('9', '11');

--Cliente 5 (Carrinho 2)
insert into carrinho_produtos (carrinho_id, produtos_id) values ('10', '1');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('10', '4');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('10', '5');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('10', '6');
insert into carrinho_produtos (carrinho_id, produtos_id) values ('10', '10');


-- Pedido

-- Cliente 1
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-05-10', '2179', '1', '1');
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-05-10', '1859', '2', '1');
-- Cliente 2
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-06-27', '2025', '3', '2');
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-06-27', '779', '4', '2');
-- Cliente 3
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-02-02', '3456', '5', '3');
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-02-02', '1159', '6', '3');
--Cliente 4
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-04-17', '2049', '7', '4');
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-04-17', '2759', '8', '4');
--Cliente 5
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-08-03', '1690', '9', '5');
Insert into pedido (data_do_pedido, valor_total, carrinho_id, cliente_id) values ('2020-08-03', '2174', '10', '5');

-- Log-Compartilhamento

Insert into log_compartilhamento (dado_compartilhado, data_de_inicio, data_final, cliente_id, empresa_id) values ('dadospessoais dadoscompras', '2020-06-05', '2020-07-05', '1', '1');
Insert into log_compartilhamento (dado_compartilhado, data_de_inicio, data_final, cliente_id, empresa_id) values ('dadoscompras', '2020-06-01', '2020-07-01', '2', '1');
Insert into log_compartilhamento (dado_compartilhado, data_de_inicio, data_final, cliente_id, empresa_id) values ('dadospessoais', '2020-03-20', '2020-04-20', '4', '7');
Insert into log_compartilhamento (dado_compartilhado, data_de_inicio, data_final, cliente_id, empresa_id) values ('dadospessoais dadoscompras', '2020-07-20', '2020-08-20', '5', '11');

