## 1. 앱의 종류
+ 네이티브 앱 : 우리가 흔히 아는 안드로이드로 만들어진 앱 (설치해서 사용하는 앱)
+ 웹 앱  : PC에서 접속하는 웹페이지를 스마트폰 화면 사이즈로 줄여서 만든 모바일 웹(브라우저로 접속)
+ 하이브리드 앱 : 네이티브 앱과 웹앱의 장점을 합친 앱 ex)크롬, 네이버 등

## 2. 클라이언트와 서버의 이해

### 2-1. 클라이언트
+ 서버측에 요청하고 데이터를 받음

### 2-2. 서버
+ 요청받은 서비스를 처리하고 결과값을 클라이언트에게 반환

### 2-3. 동작 방식, 예시
+ 클라이언트가 서버에 요청 -> 서버에서 요청응답 처리 수행 -> 서버에서 처리결과 반환 -> 클라이언트 처리정보 받음
```
예시1. 웹 브라우저와 웹 서버

클라이언트: 웹 브라우저 (크롬 등)
서버 : 웹 서버 (톰캣 등)

과정:
1. 사용자가 웹 브라우저에서 URL 입력
2. 웹 브라우저가 웹 서버에 HTTP 요청을 보냄
3. 웹 서버는 요청된 웹 페이지를 찾아서 HTML, CSS 등의 파일을 클라이언트에게 응답으로 보냠
4. 웹 브라우저는 서버로부터 받은 데이터를 이용해 웹 페이지를 랜더링
```
```
예시2. 데이터 베이스 클라이언트와 데이터 베이스 서버

클라이언트 : 데이터베이스 클라이언트 애플리케이션 (pgAdmin 등)
서버 : 데이터 베이스 서버(MYSQL 서버, PostgreSQL 서버 등)

과정:
1. 사용자가 데이터 베이스 클라이언트에서 SQL 쿼리 입력
2. 데이터베이스 클라이언트가 데이터 베이스 서버에 SQL 요청
3. 서버는 요청된 SQL쿼리를 실행 및 결과를 응답
4. 클라이언트는 결과를 사용자에게 표시

```

## 3. Spring 프레임 워크
+ 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임 워크
+ 프레임 워크 : 라이브러리와 비슷하지만 라이브러리는 필요한 기능들을 직접 가져와 사용하는 것이고, 프레임워크도 기본 기능이 미리 구현 되어있긴 하지만 라이브러리와 달리 기본 틀이 정해져 있으며 이 흐름을 따라 개발하는것이다

## 4. 스프링 부트
+ 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임 워크
+ 스프링을 보다 쉽게 사용할 수 있도록 만든 프레임워크
+ WAS가 내장되어 있어서 따로 WAS를 설치하지 않아도 독립적으로 사용가능

## 5. Lombok
+ 자바 라이브러리로 반복되는 코드를 줄여주는 코드 다이어트 라이브러리
+ 많은 멤버변수와 많은 생성자를 만들어야 하는 경우 유용
+ 코드의 가독성과 생산성을 높일 수 있음 

## 6. 스프링 부트 체험해보기
```
//오늘 체험 해본것

@Controller 
public class hello{

@GetMapping("hello")

@ResponseBody
public String hello(){
  return "helloWorld";

}
}
```





