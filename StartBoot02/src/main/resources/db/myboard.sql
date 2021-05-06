DROP SEQUENCE MYNOSEQ;

DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(500) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD
VALUES(MYNOSEQ.NEXTVAL, '관리자', '새로만들자', '되요?', SYSDATE);


INSERT INTO MYBOARD
VALUES(MYNOSEQ.NEXTVAL, '관리자', '스프링부트', '재밌다', SYSDATE);


SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD;

UPDATE MYBOARD SET MYTITLE = '스프링스프링', MYCONTENT = '되요?' WHERE MYNO = 1;