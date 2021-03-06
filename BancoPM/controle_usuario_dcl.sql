#Criação de Usuário do Banco#

#Cria usuario com senha e limitação de queries e senha com validade
CREATE user IF NOT EXISTS ‘BDPRODMG’@localhost IDENTIFIED BY "PRODMG123"
WITH MAX_QUERIES_PER_HOUR 500
PASSWORD EXPIRE INTERVAL 360 DAY;

#Mostra usuário criado
SELECT * FROM mysql.user WHERE User='BDPRODMG';

#Mostra as concessões do usuário
SHOW GRANTS FOR 'BDPRODMG'@'localhost';

#Abaixo realiza a implementação das permissões para o usuário
GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.ESTOQUE
	TO 'BDPRODMG'@localhost;

GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.MARCA
	TO 'BDPRODMG'@localhost;
    
GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.MODELO
	TO 'BDPRODMG'@localhost;    

GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.PRECOPRODUTO
	TO 'BDPRODMG'@localhost;

GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.PRODUTO
	TO 'BDPRODMG'@localhost;

GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.SAIDAESTOQUE
	TO 'BDPRODMG'@localhost;

GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.USSISTEMA
	TO 'BDPRODMG'@localhost;
    
GRANT SELECT, UPDATE, DELETE,INSERT  ON PRODUCTMANAGEMENT.USUARIOS
	TO 'BDPRODMG'@localhost;
    
GRANT SELECT, UPDATE, DELETE,INSERT ON PRODUCTMANAGEMENT.GROUPUSSISTEMA
	TO 'BDPRODMG'@localhost;
    



