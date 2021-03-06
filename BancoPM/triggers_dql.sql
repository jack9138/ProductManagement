USE PRODUCTMANAGEMENT;

#Quando for inserido um novo dado é retirado na quantidade de estoque#
DELIMITER $$
CREATE TRIGGER TRG_ATUALIZA_TABELA_ESTOQUE AFTER INSERT ON SAIDAESTOQUE
FOR EACH ROW
BEGIN
      IF NEW.COD_SAIDA IS NOT NULL THEN
      UPDATE ESTOQUE  
      SET QTD_ENTRADAPRODUTO  = NEW.QTD_SAIDAPRODUTO - QTD_ENTRADAPRODUTO
      AND VALOR_TOTALEST = NEW.VALOR_SAIDAES - VALOR_TOTALEST
      WHERE COD_PRODUTO = NEW.COD_PRODUTO;
      END IF;
END $$
DELIMITER ;

#Quando for deletado algum usuário é feito a deleção primeiro na tabela#
DROP TRIGGER TRG_DEL_TAB_USUARIO;
DELIMITER $$
CREATE TRIGGER TRG_DEL_TAB_USUARIO BEFORE DELETE ON USUARIOS
FOR EACH ROW
BEGIN
      IF OLD.USR_ID IS NOT NULL THEN
		  DELETE FROM USSISTEMA WHERE US_ID = OLD.USR_ID;
      END IF;
END $$
DELIMITER ;


#Deletar antes o preco do produto a ser excluido#
DELIMITER $$
CREATE TRIGGER TRG_DEL_TAB_PRECOPRODUTO BEFORE DELETE ON PRODUTO
FOR EACH ROW
BEGIN
      IF OLD.PROD_ID IS NOT NULL THEN
		  DELETE FROM PRECOPRODUTO WHERE COD_PRODUTO = OLD.PROD_ID;
      END IF;
END $$
DELIMITER ;




