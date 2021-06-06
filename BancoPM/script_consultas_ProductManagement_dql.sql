#Consultas#
USE PRODUCTMANAGEMENT;

#Retorna todos os produtos retirados em estoque por determinado periodo e com valor igual ou maior que 150.00(4.1)
SELECT * 
     FROM SAIDAESTOQUE
     WHERE DATA_SAIDAES BETWEEN DATE('2021-01-01') 
     AND DATE('2021-04-01') 
     AND VALOR_SAIDAES >= 150;
     
#Retorna todos os produtos colocados em estoque por determinado periodo (4.1)    
SELECT * 
     FROM ESTOQUE
     WHERE DATA_ENTRADAES BETWEEN DATE('2021-01-01')
     AND DATE('2021-04-20');    

#Retorna produtos com preços ativos (4.1)
SELECT PROD_ID, PROD_NOME, PROD_TAM,PROD_COR, PROD_MODELO,PROD_MARCA
	   FROM PRODUTO
       WHERE PROD_ID IN (SELECT COD_PRODUTO 
								FROM PRECOPRODUTO
                                WHERE PREC_STATUS = 'A');#Funciona
                                
#Retorna os usuários ativos no sistema  (4.2)                               
SELECT USR.USR_ID,
	   USR.USR_NOME NOME,
       USR.USR_CPF CPF,
       USR.USR_FUNCAO FUNCAO,
       GRP.GRP_NOMEGRUPO GRUPO,
	   GRP_PERM PERMISSAO,
       US.US_LOGIN 
       FROM USUARIOS AS USR
       INNER JOIN USSISTEMA AS US
       ON USR.USR_ID = US.US_ID
       INNER JOIN GROUPUSSISTEMA AS GRP
       ON GRP.GRP_ID = US.US_GROUPID
       WHERE US.US_STATUS = 'A'
       ORDER BY USR_ID ASC;
       
       
 #Retornar os dados do produto e o preço atual que esta sendo vendido a unidade (4.2)     
SELECT PROD.PROD_ID, 
	   PROD.PROD_NOME PRODUTO,
       MD.NOME_MODELO MODELO,
       MR.NOME_MARCA MARCA,
       PP.PREC_UNIDADE VALOR_UNIDADE,
       PP.PREC_STATUS STATUS_PRECO,
       DATE_FORMAT(PP.DATA_REGISTRO, '%d-%m-%y')
       FROM PRODUTO AS PROD
       LEFT JOIN MARCA AS MR #tentar usar o left ou right
       ON PROD.PROD_MARCA = MR.ID_MARCA
       LEFT JOIN MODELO AS MD
       ON PROD.PROD_MODELO = MD.ID_MODELO
       LEFT JOIN PRECOPRODUTO AS PP
       ON PROD.PROD_ID = PP.COD_PRODUTO
       WHERE PP.PREC_STATUS = 'A' 
       ORDER BY PROD.PROD_ID ASC;  
       
 #Retorna a quantidade de produtos com preço ativo e com quantidade de estoque maior que 110.00 (4.3)                              
SELECT COD_ESTOQUE N_ESTOQUE,
	   COD_PRODUTO N_PRODUTO,
       COD_MARCA N_MARCA,
       COD_MODELO N_MODELO,
       SUM(QTD_ENTRADAPRODUTO) QUANTIDA_PRODUTO,
       USRID_ENTRADA USUARIO,
       DATE_FORMAT(DATA_ENTRADAES, '%d-%m-%y') DATA_ENTRADA
       FROM ESTOQUE 
       WHERE COD_PRODUTO IN (SELECT COD_PRODUTO 
								FROM PRECOPRODUTO
                                WHERE PREC_STATUS = 'A'
                                )
      GROUP BY COD_PRODUTO                          
	  HAVING SUM(QTD_ENTRADAPRODUTO) >= 110
      ORDER BY COD_ESTOQUE ASC;

SELECT * FROM SAIDAESTOQUE;

#Retorna o produto com a maior quantidade de entrada no estoque e a quantidade de saida (4.3)                                
SELECT COD_ESTOQUE N_ESTOQUE,
	   COD_PRODUTO N_PRODUTO, 
       COD_MARCA N_MARCA,
       COD_MODELO N_MODELO,
       MAX(QTD_ENTRADAPRODUTO) QUANTIDA_PRODUTO,
       USRID_ENTRADA USUARIO,
       DATE_FORMAT(DATA_ENTRADAES, '%d-%m-%y') DATA_ENTRADA
       FROM ESTOQUE 
       WHERE COD_PRODUTO IN (SELECT COD_PRODUTO 
								FROM PRECOPRODUTO
                                WHERE PREC_STATUS = 'A'
                                )
      AND QTD_ENTRADAPRODUTO = (SELECT MAX(QTD_ENTRADAPRODUTO)
										FROM ESTOQUE
                                        )                          
      GROUP BY COD_PRODUTO                          
	  HAVING  MAX(QTD_ENTRADAPRODUTO)
      ORDER BY COD_ESTOQUE ASC;
                                
                                
     
       
       
