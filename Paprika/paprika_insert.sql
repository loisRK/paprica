use mydb;

DELETE FROM store;
DELETE FROM product;
DELETE FROM customer;
DELETE FROM purchase;

DESC store;
DESC product;
DESC customer;
DESC purchase;

-- store insert
DESC store;
INSERT INTO store VALUES('1021-22-6162', "한입먹은사과",  "최민기", "대전광역시 서원구 희린2길 33-4", "045-642-3389");
INSERT INTO store VALUES('0325-07-6825', "도련감귤나무숲",  "이나현", "제주 제주시 도련남3길 81", "045-642-3389");
INSERT INTO store VALUES('0410-02-6162', "부산싸나이",  "신용기", "부산광역시 서구 백석7길 73-2", "081-423-5611");
INSERT INTO store VALUES('1217-16-0050', "맛깔나는채소들",  "김연지", "충청남도 아산시 동구 배방4길 12-8", "041-231-9775");

SELECT * FROM store;

-- product insert
DESC product;
INSERT INTO product VALUES(1001, "1021-22-6162",  "사과", "과일", 800, 1500);
INSERT INTO product VALUES(1002, "1021-22-6162",  "샤인머스켓", "과일", 1200, 2400);
INSERT INTO product VALUES(1003, "1021-22-6162",  "복숭아", "과일", 1000, 1100);
INSERT INTO product VALUES(2001, "0325-07-6825",  "감귤", "과일", 700, 2500);
INSERT INTO product VALUES(2002, "0325-07-6825",  "한라봉", "과일", 1300, 1800);
INSERT INTO product VALUES(2003, "0325-07-6825",  "천해향", "과일", 1500, 1500);
INSERT INTO product VALUES(3001, "0410-02-6162",  "고등어", "생선", 3000, 500);
INSERT INTO product VALUES(3002, "0410-02-6162",  "우럭", "생선", 2500, 700);
INSERT INTO product VALUES(4001, "1217-16-0050",  "파프리카", "채소", 800, 3000);
INSERT INTO product VALUES(4002, "1217-16-0050",  "양파", "채소", 600, 2200);

SELECT * FROM product;

-- customer insert
DESC customer;

INSERT INTO customer VALUES("lois", "LLLL",  "김륜경", "서울시 샌프란시스코 북한산 입구", 0, "010-1111-2222", "lois@daum.com");
INSERT INTO customer VALUES("riccess", "RRRR",  "장우성", "인천광역시 남동구 간석동", 0, "010-6800-5221", "riccess@naver.net");

INSERT INTO customer VALUES("a123", "A123",  "이현지", "수원시 팔달구 고등동", 2, "010-2352-2222", "a123@daum.com");
INSERT INTO customer VALUES("b123", "B123",  "박기나", "서울 어딘가에 삶", 3, "010-1245-1245", "b123@naver.net");
INSERT INTO customer VALUES("c123", "C123",  "박형규", "대전은 노잼도시", 1, "010-4367-1222", "c123@daum.com");
INSERT INTO customer VALUES("d123", "D123",  "김민수", "전라도는 너무 멀어", 1, "010-3437-5734", "d123@naver.net");

SELECT * FROM customer;

-- purchase insert
DESC purchase;
INSERT INTO purchase VALUES(1, 1001, "a123", 5, "이현지", "전라도는 너무 멀어", "010-3437-5734", "배송중", '2022-10-21',  "무료배송");
INSERT INTO purchase VALUES(2, 1001, "lois", 3, "김륜경", "서울시 샌프란시스코 북한산 입구", "010-1111-2222", "배송중", '2022-10-22',  "무료배송");
INSERT INTO purchase VALUES(3, 1001, "lois", 2, "김륜경", "서울시 샌프란시스코 북한산 입구", "010-1111-2222", "주문 접수", '2022-10-23',  "무료배송");
INSERT INTO purchase VALUES( 1001, "lois", 2, "김륜경", "서울시 샌프란시스코 북한산 입구", "010-1111-2222", "주문 접수", '2022-10-23',  "무료배송");

update purchase set order_status="배송완료" where order_id = 1;

SELECT * FROM purchase;

-- order_date 컬럼 타입 변경
ALTER TABLE purchase MODIFY order_date VARCHAR(50);

-- 마지막 행 읽어오기
 SELECT * FROM purchase ORDER BY order_ID DESC LIMIT 1;
 SELECT order_id FROM purchase ORDER BY order_ID DESC LIMIT 1;

select * from customer where cus_id = "lois";