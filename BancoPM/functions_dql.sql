USE PRODUCTMANAGEMENT;

#Funcções#

#FUNCTION QUE RETORNA VALOR TOTAL DE ENTRADA#
DROP FUNCTION IF EXISTS F_VALOR_ENTRADA;
DELIMITER $$
CREATE FUNCTION F_VALOR_ENTRADA (F_QTDENTRADA INT , F_CODPRODUTO INT )
RETURNS DECIMAL (10.2)
DETERMINISTIC
BEGIN
 
 DECLARE V_PRECO DECIMAL(10.2);
 
	SELECT 
      PP.PREC_UNIDADE 
      INTO V_PRECO 
      FROM PRECOPRODUTO AS PP 
      WHERE PP.COD_PRODUTO = F_CODPRODUTO
      AND PP.PREC_STATUS = 'A';
   
   RETURN V_PRECO * F_QTDENTRADA;
   
END $$
DELIMITER ;

#Executa a FUNCTION#
SELECT F_VALOR_ENTRADA (4 , 1) AS F_VALORTOTAL; # 100


#FUNCTION QUE RETORNA VALOR TOTAL DE SAIDA#
DROP FUNCTION IF EXISTS F_VALOR_SAIDA;
DELIMITER $$
CREATE FUNCTION F_VALOR_SAIDA (F_QTDSAIDA INT , F_CODPRODUTO INT )
RETURNS DECIMAL (10.2)
DETERMINISTIC
BEGIN
 
 DECLARE V_PRECO DECIMAL(10.2);
 
	SELECT 
      PP.PREC_UNIDADE 
      INTO V_PRECO 
      FROM PRECOPRODUTO AS PP 
      WHERE PP.COD_PRODUTO = F_CODPRODUTO
	  AND PP.PREC_STATUS = 'A';
      
   RETURN V_PRECO * F_QTDSAIDA;
   
END $$
DELIMITER ;

#Executa a FUNCTION#
SELECT F_VALOR_SAIDA (4 , 1) AS F_VALORTOTAL; # 100
