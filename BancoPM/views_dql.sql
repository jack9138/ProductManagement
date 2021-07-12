USE PRODUCTMANAGEMENT;
#Lista todos os produtos cadastrado no banco#
CREATE VIEW V_LIST_PRODUTOS(P_ID, P_NOME,P_TAM,P_COR,P_MODELO,P_MARCA,M_NOMEMODELO,M_NOMEMARCA) AS
			SELECT 
            PD.PROD_ID,
            PD.PROD_NOME,
            PD.PROD_TAM,
            PD.PROD_COR,
            PD.PROD_MODELO,
            PD.PROD_MARCA,
            MO.NOME_MODELO,
            MA.NOME_MARCA
            FROM PRODUTO AS PD
            INNER JOIN MARCA AS MA
            ON PD.PROD_MARCA = MA.ID_MARCA
            INNER JOIN MODELO AS MO
            ON PD.PROD_MODELO = MO.ID_MODELO
            ORDER BY PROD_ID ASC;
            
 SELECT * FROM V_LIST_PRODUTOS;            
             
#Lista todos os produtos e preço com preço ativo#
CREATE VIEW V_LIST_PRODUTOS_PRECO(P_NOME,P_TAM,P_COR,P_MODELO,P_MARCA,P_PRECO,P_DATAREGISTRO) AS
			SELECT PD.PROD_NOME,PD.PROD_TAM,PD.PROD_COR,MO.NOME_MODELO,MA.NOME_MARCA,PP.PREC_UNIDADE,PP.DATA_REGISTRO
            FROM PRODUTO AS PD
            INNER JOIN MARCA AS MA
            ON PD.PROD_MARCA = MA.ID_MARCA
            INNER JOIN MODELO AS MO
            ON PD.PROD_MODELO = MO.ID_MODELO
            CROSS JOIN PRECOPRODUTO AS PP
            ON PD.PROD_ID = PP.COD_PRODUTO
            WHERE PP.PREC_STATUS = 'A'
			GROUP BY PD.PROD_ID
            ORDER BY PROD_ID ASC;
            
SELECT * FROM V_LIST_PRODUTOS_PRECO;



			
            