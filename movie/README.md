# HIBERNATE 사용해서 간단하게 만들어보기
> 10/1 : [ERD](https://www.erdcloud.com/d/LhfvnY2HRQCg8xgiH) 작성, hibernate와 연결  
> 10/2 : hibernate, queryDSL로 나머지 쿼리 작성(vsCODE는 qClass가 간헐적으로 지워지는 현상이 있음), mustache의 비즈니스 로직 지원 안하는 관계로 노선을 살짝 수정 + js로 테이블 내용이 바뀌지 않아서 방향을 선회.   
> 10/3 : 작업 끝. 추가적으로 jacksonbinder에서 순환참조 시 @JsonIgnore로 해결



```
10/3작성

 아쉬운 점 :  
  1. mustache로 만들어서 비즈니스 로직을 필요한 부분에 구현을 하지 못한 것.
  2. 조금 더 다양한 쿼리문을 사용하지 못한 것
  3. mapper(mybatis)로 구현 할 떄랑 구조가 조금 달라지는데 이를 염두하지 못한 것
  4. 도메인 모델 사용이 많지 않아서 익숙하지 않은 점
  5. '자바 ORM 표준 JPA ~' 책을 주로 참고 했는데 DTO를 사용할 일이 아직까지 없었던 점 
  
긍정적인 점 : 
  1. HIBERNATE와 QUERYDSL은 이번에 처음 책으로 공부했는데 그래도 매끄럽게 사용했다는 점
  2. 중간 중간의 오류를 구글링으로 검색하면서 이것 저것 익혔다는 점
    
```

# [완성 페이지](http://newkayak.myqnapcloud.com:9080/movie/) (NAS)



