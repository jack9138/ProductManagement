#Procedure para adicionar dados na tabela USSISTEMA toda vez que tiver cadastro de usuario#
DROP PROCEDURE IF EXISTS PROC_NOVOUSSISTEMA;
DELIMITER $$
CREATE PROCEDURE PROC_NOVOUSSISTEMA
 (IN  P_USLOGIN VARCHAR(20),
      P_USSENHA VARCHAR(20),
      P_USSTATUS VARCHAR(5),
      P_USGRUPID INTEGER,
  OUT P_USCONFIRM INTEGER)
BEGIN
	
	DECLARE EXIT HANDLER FOR SQLEXECEPTION SELECT 'OCORREU UM ERRO AO INSERIR CADASTRO' AS MESSAGE;
    INSERT INTO USSSITEMA(
							US_LOGIN,
                            US_SENHA,
                            US_STATUS,
                            US_GRUPOID)
				VALUES( P_USLOGIN,
						P_USSENHA,
                        P_USSTATUS,
                        P_USGRUPID);
                        
END$$
DELIMITER ;

#Precisa ver se vai funcionar#