DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;
CREATE TABLE MYBOARD(
	MYNO NUMBER NOT NULL,
	MYNAME VARCHAR2(1000) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(1000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD 
VALUES(MYNOSEQ.NEXTVAL, '관리자', '새로만들자', '되는가?', SYSDATE);

SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;