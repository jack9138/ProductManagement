USE PRODUCTMANAGEMENT;

#Inserção na tabela USUARIOS#
INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) VALUES('MARCOS OLIVEIRA', '19985252505','MARCO@GMAIL.COM', '45648798812','Supervisor de Estoque', 'SP', 'CAMPINAS', 'CAMBUI', 'RUA CRISTINA 45', 'A');
INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) VALUES('FERNANDA MEDEIROS', '19986958615','MEDEIROSF@GMAIL.COM', '17348509819','Gerente de Estoque', 'SP', 'HORTLANDIA', 'VILA REAL', 'RUA MARGARETH 158', 'A');
INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) VALUES('JOSE RODRIGUES', '19985259547','JOSE89@GMAIL.COM', '56534984830','Estoquista JR', 'SP', 'SUMARE', 'MATAO', 'RUA VILELA 36', 'A');
INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) VALUES('ROBERTA FERNANDES', '19991481309','FERN68@GMAIL.COM', '34539079816','Estoquista SR', 'SP', 'MONTEMOR', 'PAULISTA', 'RUA CARMEM 155', 'A');
INSERT INTO USUARIOS (USR_NOME,USR_TELEFONE,USR_EMAIL,USR_CPF,USR_FUNCAO,USR_ESTADO,USR_CIDADE,USR_BAIRRO,USR_RUA,USR_STATUS) VALUES('RONALDO MAGALHAES', '19997481505','MAGALHAESRO@GMAIL.COM', '44028554896','Auxiliar RH', 'SP', 'HORTOLANDIA', 'JD AMANDA', 'AV.BRASIL 1045', 'A');

#Inserção na tabela GROUPUSSITEMA#
INSERT INTO GROUPUSSISTEMA (GRP_NOMEGRUPO,GRP_DESC,GRP_PERM,GRP_STATUS) VALUES('ADMINISTRADORES', 'Possui todas as permissoes do programa(Gerentes, Supervisores)',1,'A');
INSERT INTO GROUPUSSISTEMA (GRP_NOMEGRUPO,GRP_DESC,GRP_PERM,GRP_STATUS) VALUES('FUNCIONARIOESTOQUE', 'Pode retirar e cadastrar novos produtos, gerar relatorios(Estoquistas todos os niveis)',2 ,'A');
INSERT INTO GROUPUSSISTEMA (GRP_NOMEGRUPO,GRP_DESC,GRP_PERM,GRP_STATUS) VALUES('FUNCIONARIOADMINISTRACAO', 'Permissao para retirada de relatorio apenas',3 ,'A');
INSERT INTO GROUPUSSISTEMA (GRP_NOMEGRUPO,GRP_DESC,GRP_PERM,GRP_STATUS) VALUES('FUNCIONARIO', 'Permissao para retirada de relatorio apenas/Cadastro estoque',4 ,'I');
#Inserção na tabela USSITEMA#
INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) VALUES(1, 'MARC456', '123456', 'A',1);
INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) VALUES(2, 'FERN173', '8615', 'A',1);
INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) VALUES(3, 'RODR565', '5259456', 'A',2);
INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) VALUES(4, 'FERNA345', '1231309', 'A',2);
INSERT INTO USSISTEMA (US_ID,US_LOGIN,US_SENHA,US_STATUS,US_GROUPID) VALUES(5, 'MAGA440', '19481', 'A',3);


#Inserção na tabela MARCA#
INSERT INTO MARCA (NOME_MARCA) VALUES('MOLECA');
INSERT INTO MARCA (NOME_MARCA) VALUES('VIZZANO');
INSERT INTO MARCA (NOME_MARCA) VALUES('AREZZO');
INSERT INTO MARCA (NOME_MARCA) VALUES('VIA MARTE');


#Inserção na tabela MODELO#
INSERT INTO MODELO(NOME_MODELO) VALUES('SANDALIA');
INSERT INTO MODELO(NOME_MODELO) VALUES('BOTAS');
INSERT INTO MODELO(NOME_MODELO) VALUES('TENIS');
INSERT INTO MODELO(NOME_MODELO) VALUES('SAPATILHA');


#Inserção na tabela PRODUTOS#
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Sapatilha Bico Fino Verniz Moleca', 34, 'PRETO', 1,4);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Tênis Vizzano Básico Casual Feminino', 36, 'JEANS', 2,3);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('SANDÁLIA RASTEIRA VIA MARTE', 38, 'PRETO', 4,1);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Sapatilha Feminina Bico Redondo Vizzano', 39, 'BEGE', 2,4);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Bota Preta Couro Cano Curto Salto Bloco', 36, 'PRETO', 3,2);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Bota Coturno Via Marte', 37, 'MARROM', 4,2);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('TÊNIS FEMININO VIA MARTE CASUAL CREMA', 38, 'CREME', 4,3);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Sandália Moleca', 35, 'BEGE', 1,1);
INSERT INTO PRODUTO (PROD_NOME,PROD_TAM,PROD_COR,PROD_MODELO,PROD_MARCA) VALUES('Bota Moleca Salto Alto Napa', 37, 'PRETO', 1,2);

#Inserção na tabela PRECOPRODUTO#
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(1,25.00,'A','2021-03-15');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(2,35.00,'A','2021-03-01');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(3,35.00,'A','2021-02-04');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(4,40.00,'A','2021-01-03');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(5,45.00,'A','2021-03-24');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(6,55.00,'A','2021-02-28');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(7,50.00,'A','2021-03-19');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(8,45.00,'A','2021-04-16');
INSERT INTO PRECOPRODUTO(COD_PRODUTO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(9,30.00,'A','2021-01-30');


#Inserção na tabela ESTOQUE#
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(1,150,3750.00,3,'2021-03-15' );
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(2,100,3500.00,4,'2021-03-01');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(3,250,8750.00,4,'2021-02-04');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(4,350,14000.00,3,'2021-01-03');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(5,200,9000.00,1,'2021-03-24');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(6,150,8250.00,3,'2021-02-28');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(7,200,10000.00,4,'2021-03-19');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(8,250,11250.00,3,'2021-04-16');
INSERT INTO ESTOQUE(COD_PRODUTO,QTD_ENTRADAPRODUTO,VALOR_TOTALEST,USRID_ENTRADA,DATA_ENTRADAES) VALUES(9,170,5100.00,1,'2021-01-30');

#Inserção na tabela SAIDAESTOQUE #
INSERT INTO SAIDAESTOQUE(COD_PRODUTO,QTD_SAIDAPRODUTO,VALOR_SAIDAES,USRID_RETIRADA,DATA_SAIDAES) VALUES(1, 10, 250.00, 3, '2021-04-15' );
INSERT INTO SAIDAESTOQUE(COD_PRODUTO,QTD_SAIDAPRODUTO,VALOR_SAIDAES,USRID_RETIRADA,DATA_SAIDAES) VALUES(4, 100, 4000.00, 2, '2021-05-03');
INSERT INTO SAIDAESTOQUE(COD_PRODUTO,QTD_SAIDAPRODUTO,VALOR_SAIDAES,USRID_RETIRADA,DATA_SAIDAES) VALUES(3, 70, 2450.00, 4, '2021-04-01');
INSERT INTO SAIDAESTOQUE(COD_PRODUTO,QTD_SAIDAPRODUTO,VALOR_SAIDAES,USRID_RETIRADA,DATA_SAIDAES) VALUES(5, 40, 1800.00, 1, '2021-03-30');
