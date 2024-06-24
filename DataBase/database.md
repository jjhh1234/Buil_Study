## 1.데이터 베이스 언어
+ DDL : 데이터 정의어 - 테이블 구조 정의 (속성, 데이터 형 정의) : CREATE, ALTER, DROP 등 
+ DML : 데이터 조작어 - 데이터를 검색, 삽입, 삭제, 수정 : SELECT,INSERT,DELETE 등
+ DCL : 데이터 제어어 - 데이터 사용 권한 관리(보안) : GRANT,REVOKE 등

## 2. 키
+ 기본키 (primaryKey) : 유일한 식별값 (not null)
+ 왜래키 (foreignKey) : 현재 테이블 에서 참조하는 다른 테이블의 기본키 (not null)
+ 슈퍼키
+ 후보키 : 기본키가 되지 못한 속성

## 3. 릴레이션 용어
+ 릴레이션 = 테이블 = 파일
+ 속성     = 열     = 필드
+ 튜플     = 행     = 레코드

## 4. SQL 개요
+ SELECT : 추출될 속성 리스트
+ FROM : 속성을 가져올 테이블
+ WHERE : 가져올 속성의 조건

```
SELECT publisher, price //출력할 속성

FROM Book //데이터를 가져올 테이블

WHERE bookname LIKE "축구의 역사" //가져올 데이터의 조건

```

### 4-1. SELECT 문 개요
```
SELECT [ALL(*) | DISTINCT] + 속성 이름 // DISTINCT : 중복을 제거하고 가지고 와라 , All : *

FROM + 테이블이름(들)

WHERE + 검색조건(들)

GROUP BY + 속성이름 // 그룹으로 묶을 속성 이름  

HAVING + 검색조건(들) // GROUB BY 와 쌍을 이룸

ORDER BY + 속성이름 [ASC | DES]  // 해당 속성을 오름차순, 내림차순 정렬, 기본값은 오름차순(ASC) 정렬

```

#### Quiz 1 ) 모든 도서의 이름 과 가격을 검색 하시오
```

SELECT name, price 

FROM Book;

```

#### Quiz 2 ) 도서 테이블에 있는 모든 출판사를 검색하라 단, 중복을 제거하고
```

SELECT DISTINCT price //DISTINCT 로 중복 제거

FROM Book;

```

### 4-2. SELECT 문 짝꿍 WHERE 조건 종류
+ **비교연산자는 거의 동일 , CF) MySQL 에서는 not 비교 연산자는 '<>' 를 사용**
+ 범위 : BETWEEN , ex) price BETWEEN 10000 AND 20000
+ 집합 : IN, NOT IN , ex) price IN(10000,20000,30000) - 이중에 포함 되어 지는 값들
+ 패턴 : LIKE(문자열 비교 문) ex) bookname LIKE '축구의 역사'
+ NULL : IS NULL , IS NOT NULL , ex)price IS NULL - price가 NULL 인 값들
+ 복합 조건 : AND,OR,NOT ex) (price<20000) AND (bookname LIKE '축구의 역사')

#### Quiz 3 ) 가격이 10000원 이상 20000원 이하인 도서를 검색 하세요
```
SELECT price, bookname
FROME Book
WHERE price BETWEEN 10000 AND 20000;


SELECT *
FROM Book
WHERE price>=10000 AND price<=20000;
```

#### Quiz 4 ) 출판사가 굿 스포츠 또는 대한 미디어인 도서를 검색하세여
```
SELECT *
FROM Book
WHERE publisher IN('굿스포츠' , '대한미디어')

SELECT *
FROM Book
WHERE publisher LIKE '굿 스포츠' OR publisher = '대한미디어' 
```

### 4-3. WHERE 조건 - 패턴(LIKE)
+ 문자열 검색시 LIKE와 함께 사용할 수 있는 와일드 문자
```
% - ex) %축구% : 어느 위치에든지 '축구' 를 포함하는 문자열

[] - ex) [0-5]% : 0-5 사이의 숫자로 시작하는 문자열

[^] - ex) [^0-5]% : 0-5 사이의 숫자로 시작하지 않는 문자열

- : 특정 위치에 있는 1개의 문자와 일치
 ex) '_구%' : 두번쨰 위치에 '구'가 들어가는 문자열 
```

#### Quiz 5) 도서 이름에 '축구' 가 포함된 문자열을 검색하시오
```
SELECT *
FROM Book
WHERE bookname LIKE '%축구%';
```

#### Quiz 6) 도서이름의 왼쪽 두번쨰 위치에 '구' 라는 문자열을 갖는 도서를 검색 하시오
```
SELECT *
FROM Book
WHERE bookname LIKE '_구%';
```

### 5. ORDER BY
+ SQL의 실행 결과를 특정 순서대로 출력하고 싶을 때 사용
+ ASC ,DESC : 오름차순과 내림차순 존재
+ 기본 값은 ASC
+ 복합 조건에서 적힌 순서대로 조건 적용

#### Quiz 7 ) 도서를 이름순으로 검색 하시오
```
SELECT *
FROM Book
ORDER BY bookname;

```

#### Quiz 8) 도서를 가격순으로 검색하고, 가격이 같으면 이름순으로 검색하시오
```
SELECT *
FROM Book
ORDER BY price, bookname //price가 먼저 정렬되어 지기 때문에 자연스럽게 bookname은 정렬된 가격 안에서 이름 순으로 정렬 된다(가격이 같으면 이름 순 정렬 됨)
```

#### Quiz 9) 도서를 가격의 내림차순으로 검색하시오. 가격이 같다면 출판사를 오름 차순으로 출려 하시오.
```
SELECT *
FROM Book
ORDER BY price DESC, publisher ASC; //price가 먼저 내림차순으로 정렬 되어지고 그 안에서 가격이 같은 값들의 출판사가 오름 차순으로 되어진다.
```


### 6. GROUP BY
+ 테이블의 각 열에 대해 계산하는 함수
+ HAVING 과 짝으로 이어짐
```
// 집계 함수 : 테이블의 각 열에 대해서 계산하는 함수  - () 안의 값은 숫자형태만 가능
 
SUM  = SUM(* | DISTINCT  + 속성이름) , ex) SUM(price)



```


