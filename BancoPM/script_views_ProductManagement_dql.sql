#Views#
USE PRODUCTMANAGEMENT; 

#View para verificar a quantidade de saida de determinado produto por um periodo de tempo
CREATE VIEW SAIDA_DE_PRODUTO_POR_DATA(CODIGO_PRODUTO, QUANTIDADE,VALOR_TOTAL,DATA_SAIDA,USUARIO) AS
			SELECT 
            PROD.PROD_ID,
            SUM(SE.QTD_SAIDAPRODUTO),
            SUM(SE.VALOR_SAIDAES),
            DATE_FORMAT(SE.DATA_SAIDAES, '%d-%m-%y'),
            SE.USRID_RETIRADA 
            FROM SAIDAESTOQUE AS SE 
            INNER JOIN PRODUTO AS PROD
            ON PROD.PROD_ID = SE.COD_PRODUTO
            WHERE SE.DATA_SAIDAES BETWEEN DATE('2021-01-01')
             AND DATE('2021-05-01')
             GROUP BY PROD.PROD_ID;
             
 SELECT * FROM SAIDA_DE_PRODUTO_POR_DATA;            
             
 #View para verificar a quantidade de entrada de um produto por determinado periodo de data            
CREATE VIEW ENTRADA_DE_PRODUTO_POR_DATA(CODIGO_PRODUTO,QUANTIDADE,VALOR_UNID, VALOR_TOTAL,DATA_ENTRADA,USUARIO) AS
			SELECT 
            PROD.PROD_ID,
            ES.QTD_ENTRADAPRODUTO,
            PR.PREC_UNIDADE,
            ES.VALOR_TOTALEST,
            DATE_FORMAT(ES.DATA_ENTRADAES, '%d-%m-%y'),
            ES.USRID_ENTRADA 
            FROM ESTOQUE AS ES 
            INNER JOIN PRODUTO AS PROD
            ON PROD.PROD_ID = ES.COD_PRODUTO
            INNER JOIN PRECOPRODUTO AS PR
            ON PROD.PROD_ID = PR.COD_PRODUTO
            WHERE PR.PREC_STATUS = 'A' 
            AND ES.DATA_ENTRADAES BETWEEN DATE('2021-01-01')
			AND DATE('2021-05-01')
            GROUP BY PROD.PROD_ID;
            
            
   SELECT * FROM ENTRADA_DE_PRODUTO_POR_DATA;         
            
#View para verificar dados de preços alterados durante um periodo de tempo#
CREATE VIEW ALTERACAO_PRECO_POR_DATA(PRODUTO, PRECO, STATUS_PRECO,DATA_REGISTRO) AS 
			SELECT 
             PROD.PROD_ID,
             PR.PREC_UNIDADE,
             PR.PREC_STATUS,
             DATE_FORMAT(PR.DATA_REGISTRO, '%d-%m-%y')
             FROM PRECOPRODUTO AS PR
             INNER JOIN PRODUTO AS PROD
             ON PR.COD_PRODUTO = PROD.PROD_ID
			WHERE PR.DATA_REGISTRO BETWEEN DATE('2021-01-01')
			AND DATE('2021-05-01')
            ORDER BY PROD.PROD_ID ASC;

#antes de alterar retorna todos os valores e status            
SELECT * FROM ALTERACAO_PRECO_POR_DATA;  

#Altera o status do preco par a inativo   
UPDATE PRECOPRODUTO
SET PREC_STATUS = 'I'
WHERE COD_PRODUTO = 3; 
 #Insere um novo preco para o produto
INSERT INTO PRECOPRODUTO(COD_PRODUTO,COD_MARCA,COD_MODELO,PREC_UNIDADE,PREC_STATUS,DATA_REGISTRO) VALUES(3,4,1,40.00,'A','2021-03-01');

#Retorna os dados depois da alteração
SELECT * FROM ALTERACAO_PRECO_POR_DATA;