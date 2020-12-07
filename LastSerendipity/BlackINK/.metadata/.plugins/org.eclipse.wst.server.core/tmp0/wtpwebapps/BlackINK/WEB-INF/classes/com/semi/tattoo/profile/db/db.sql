SELECT * FROM PROFILE;
SELECT * FROM MEMBER;
SELECT * FROM IMG;
SELECT * FROM TAG;
SELECT * FROM TATTOOSHARE;

DROP TABLE PROFILE;

CREATE TABLE PROFILE(
	ME_NO NUMBER NOT NULL,
	PR_SHOPNAME VARCHAR2(50) NOT NULL,
	PR_OPEN VARCHAR2(10) NOT NULL,
	PR_CLOSE VARCHAR2(10) NOT NULL,
	PR_POST VARCHAR2(10) NOT NULL,
	PR_ADR_MAIN VARCHAR2(50) NOT NULL,
	PR_ADR_D1 VARCHAR2(50) NOT NULL,
	PR_ADR_D2 VARCHAR2(50) NOT NULL,
	PR_CONTENT VARCHAR2(1000) NOT NULL
);

ALTER TABLE PROFILE ADD FOREIGN KEY(ME_NO) REFERENCES MEMBER(ME_NO); 

INSERT INTO MEMBER
VALUES(2, 'pp@admin.com', '1234', '관리자', '블랙잉크', '1992-04-14',
	'010-0000-0000', 'Y', 'A', NULL, NULL);
	
SELECT PR_ADR_MAIN
FROM MEMBER JOIN PROFILE USING(ME_NO)
WHERE ME_NIC = '블랙잉크' OR
PR_SHOPNAME = '블랙잉크' ;

--**회원가입하면 자동으로 프로필생성되도록 연동 

DELETE FROM PROFILE WHERE ME_NO = 2;

SELECT * FROM MEMBER
WHERE ME_ENABLED IN ('Y')
AND ME_ROLE IN ('U', 'A', 'T');

SELECT T.ME_NO, IM_NO, IM_FILENAME, IM_SERVERNAME, IM_FILEPATH, IM_REGDATE, TS_TITLE, TS_NO
		FROM IMG I INNER JOIN TATTOOSHARE T USING(IM_NO)
		WHERE T.ME_NO = 1
		ORDER BY IM_SERVERNAME DESC
		
		SELECT TS_WRITER,
		TS_TITLE, IM_SERVERNAME, IM_FILEPATH
		FROM TATTOOSHARE T JOIN IMG I
		USING(IM_NO)
		WHERE T.ME_NO = 1 
		ORDER BY IM_SERVERNAME DESC
		
SELECT IM_FILEPATH
FROM IMG;
select * from tag;
SELECT * FROM MEMBER;
SELECT * FROM TATTOOSHARE;
SELECT * FROM PROFILE;
DELETE FROM profile WHERE ME_NO = 132;
DELETE FROM MEMBER WHERE ME_NO = 132;


UPDATE profile SET me_no = 1 WHERE pr_shopname = 'RedLine';

UPDATE TATTOOSHARE SET TS_TITLE = '작성 중', TS_CONTENT = '작성 중' WHERE TS_NO BETWEEN 7 AND 11;
SELECT ME_NO FROM MEMBER WHERE ME_EMAIL = 'tattoo@tattoo.com';
select * from img order by im_servername;





