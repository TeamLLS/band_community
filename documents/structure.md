# 1. 패키지 

```
band_community
    ├─board
    │  ├─command
    │  ├─domain
    │  ├─event
    │  └─form
    ├─core
    └─external
        └─kafka
```


# 2. 도메인

| 도메인 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|Post    |      |      |      |      |
|        |id|Long|Post Id|Primary Key|
|        |clubId|Long|Club Id|Club 추적키, NotNull|
|        |title|String|제목||
|        |content|String|내용||
|        |image|String|이미지||
|        |memberId|Long|작성자 회원 Id|Member 추적키, NotNull|
|        |memberName|String|작성자 이름||
|        |createdBy|String|생성자 username|User 추적키, NotNull|
|        |createdAt|Instant|생성일||
|        |deletedAt|Instant|삭제일||


| 도메인 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|Comment |      |      |      |      |
|        |id|Long|Comment Id|Primary Key|
|        |clubId|Long|Club Id|Club 추적키, NotNull|
|        |post|Post|대상 Post|Foreginer Key, NotNull|
|        |base|Comment|대상 Comment|Foreginer Key|
|        |content|String|내용||
|        |memberId|Long|작성자 회원 Id|Member 추적키, NotNull|
|        |memberName|String|작성자 이름||
|        |createdBy|String|생성자 username|User 추적키, NotNull|
|        |createdAt|Instant|생성일||
|        |deletedAt|Instant|삭제일||



# 3. 이벤트

| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|BoardEvent|     |      |      |      |
|          |eventId|String|Event Id|Event 추적키|
|          |triggerdBy|String|생성자||
|          |postId|Long|Post Id|Post 추적키|
|          |memberId|Long|Member Id|Member 추적키|
|          |clubId|Long|Club Id|Club 추적키|
|          |time|Instnat|발생 시간||


## 3-1. Post 이벤트

| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|PostCreated|      |      |발생 API: Post 생성|BoardEvent 상속|
|           |title|String|Post 제목||
|           |image|String|Post 이미지 url||
|           |content|String|Post 내용||
|           |memberName|String|작성 Member 이름||


| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|PostChanged|      |      |발생 API: Post 변경|BoardEvent 상속|
|           |title|String|변경 후 Post 제목||
|           |image|String|변경 후 Post 이미지 url||
|           |content|String|변경 후 Post 내용||

| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|PostDeleted|      |      |발생 API: Post 삭제|BoardEvent 상속|

## 3-2. Comment 이벤트

| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|CommentCreated|      |      |발생 API: Comment 생성|BoardEvent 상속|
|           |commentId|Long|Comment Id|Comment 추적키|
|           |baseId|Long|부모 Comment Id|Comment 추적키|
|           |content|String|Comment 내용||
|           |memberName|String|작성 Member 이름||


| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|CommentChanged|      |      |발생 API: Comment 변경|BoardEvent 상속|
|           |content|String|변경 후 Post 내용||

| 이벤트 | 속성 | 타입 | 설명 | 비고 |  
|--------|------|------|------|------|
|CommentDeleted|      |      |발생 API: Comment 삭제|BoardEvent 상속|



# 4. 주요 컴포넌트

| 컴포넌트 | 설명 | 비고 |  
|----------|------|------|
|KafkaConsumerService|kafka 메시지 소비용 컴포넌트||
|BoardController|Board 관련 엔드포인트||
|BoardService|Board 관련 비즈니스 로직 수행||
|BoardStore|Board 관련 DB 접근||

# 5. ERD
![board](https://github.com/user-attachments/assets/a5293e0e-e84d-4dc9-baa9-f0f026c02c76)

