DROP FUNCTION IF EXISTS getChildrenOrg;
DELIMITER;;
create function getChildrenOrg(orgid INT)
returns varchar(4000)
BEGIN
DECLARE oTemp VARCHAR(4000);
DECLARE oTempChild VARCHAR(4000);

SET oTemp = '';
SET oTempChild = CAST(orgid AS CHAR);

WHILE oTempChild IS NOT NULL
DO
SET oTemp = CONCAT(oTemp,',',oTempChild);
SELECT GROUP_CONCAT(id) INTO oTempChild FROM bm_organization WHERE FIND_IN_SET(parentid,oTempChild) > 0;
END WHILE;
RETURN oTemp;
END
;;
DELIMITER ;