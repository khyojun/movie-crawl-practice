## Spring 활용해서 영화 포스터 크롤링하는 간단한 예제


**아직 정한 영화에 대해서 크롤링 해오는 것에 대해서는 공부를 해야해서 일단 한 사이트에 존재하는 최상단 영화 30개만 크롤링**


- 📌 Controller
  - "/hello" -> 템플릿 잘 작동하는지 확인해보는 코드
  - "/v" -> 크롤링하고 크롤링한 내용 index.html로 Model에 담아서 보내는 기능

- 📌 Service
  - crawl() 메서드에서 https://www.imdb.com/movies-in-theaters/ 에 들어가면 표시되는 영화 포스터 크롤링
  - `loadlate`라는 클래스 속성으로 img들에 대한 url이 묶여있어서 크롤링해옴.
  - `alt` 속성은 제목, `loadlate` 속성은 img url에 대한 정보가 있으므로 (엔티티)`MoviePoster` 객체에 크롤링한 내용들을 담는다.
  - 이후 담는 작업이 완료되면 `MoviePostRepository`에 담는다.

- 📌 Repository
  - Spring Data Jpa 사용하여 DB와 연결

- 📌 Entity
  - id(PK) autoincrement 방식 사용
  - title: 영화 제목
  - imageUrl: 영화 포스터 url


- 추가 확인 사항
  - `application.properties` 속성을 확인하고 `h2-console`을 열어서 url 맞춰줘야함.
  - 꼭 h2를 실행시킨 후 실행하셔야 DB에 표시가 됩니다. 


