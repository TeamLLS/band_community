# API

| API | 설명 | DB | 이벤트 |
|-----|------|----|--------|
|[게시글 작성](#게시글-작성)|게시글 작성|Post 생성|PostCreated|
|[게시글 수정](#게시글-수정)|게시글 수정|Post 변경|PostChanged|
|[게시글 삭제](#게시글-삭제)|게시글 삭제|Post 변경|PostDeleted|
|[댓글 작성](#댓글-작성)|댓글 작성|Comment 생성|CommentCreated|
|[댓글 수정](#댓글-수정)|댓글 수정|Comment 변경|CommentChanged|
|[댓글 삭제](#댓글-삭제)|댓글 삭제|Comment 변경|CommentDeleted|
|[게시글 리스트 조회](#게시글-리스트-조회)|모입 내 게시글 리스트 조회|||
|[게시글 조회](#게시글-조회)|게시글 상세 조회|||
|[댓글 조회](#댓글-조회)|게시글 내 댓글 조회|||


## ▶게시글 작성
### POST /board/post
```
header: {  
  Authorization: Bearer ${accessToken value},
}

form-data: {
  clubId: 모임 Id, (Long)
  title: 제목, (String)
  content: 내용, (String)
  image: 첨부 이미지 (MulitPartFile)
} 
```

### 응답
```
```


## ▶게시글 수정
### PATCH /board/post
```
header: {  
  Authorization: Bearer ${accessToken value},
}

form-data: {
  clubId: 모임 Id, (Long)
  postId: 게시글 Id, (Long)
  title: 수정 제목, (String)
  titleChanged: 제목 수정 여부, (Boolean, true or false)
  content: 수정 내용, (String)
  contentChanged: 내용 수정 여부, (Boolean, true or false)
  image: 수정 이미지, (MulitPartFile)
  imageChanged: 이미지 수정 여부 (Boolean, true or false)
} 
```

### 응답
```
```


## ▶게시글 삭제
### DELETE /board/{clubId}/post/{postId}
```
header: {  
  Authorization: Bearer ${accessToken value},
}
```

### 응답
```
```


## ▶댓글 작성
### POST /board/comment

- baseId는 일반 댓글일 경우 포함X, 답글일 경우에 대상 Comment Id를 포함 

```
header: {  
  Authorization: Bearer ${accessToken value},
}

body: {
  clubId: 모임 Id, (Long)
  postId: 게시글 ID, (Long)
  baseId: 댓글 ID, (Long)
  content: 내용, (String)
} 
```

### 응답
```
```


## ▶게시글 수정
### PATCH /board/comment
```
header: {  
  Authorization: Bearer ${accessToken value},
}

body: {
  clubId: 모임 Id, (Long)
  commentId: 댓글 ID, (Long)
  content: 내용, (String)
} 
```

### 응답
```
```


## ▶게시글 삭제
### DELETE /board/{clubId}/post/{commentId}
```
header: {  
  Authorization: Bearer ${accessToken value},
}
```

### 응답
```
```

## ▶게시글 리스트 조회
### GET /board/{clubId}/list?pageNo=0
```
header: {  
  Authorization: Bearer ${accessToken value},
}
```

### 응답
```
body: {
    list: [
        {
            id: 게시글 Id, (Long)
            clubId: 클럽 Id, (Long)
            createdBy: 작성자 username, (String)
            memberName: 작성자 이름, (String)
            createdAt: 작성 시간, (Instant)
            title: 제목, (String)
            image: 이미지 url (String)
        },
        ...
    ]
}
```


## ▶게시글 조회
### GET /board/{postId}
```
header: {  
  Authorization: Bearer ${accessToken value},
}
```

### 응답
```
body: {
      id: 게시글 Id, (Long)
      clubId: 클럽 Id, (Long)
      createdBy: 작성자 username, (String)
      memberId: 작성자 Id, (String)
      memberName: 작성자 이름, (String)
      createdAt: 작성 시간, (Instant)
      title: 제목, (String)
      content: 내용, (String)
      image: 이미지 url (String)
}
```

## ▶댓글 조회
### GET /board/{postId}/comments
```
header: {  
  Authorization: Bearer ${accessToken value},
}
```

### 응답
```
body: {
    list: [
        {
            id: 댓글 ID, (Long)
            postId: 게시글 Id
            createdBy: 작성자 username, (String)
            memberId: 작성자 Id, (String)
            memberName: 작성자 이름, (String)
            createdAt: 작성 시간, (Instant)
            content: 내용, (String)
            comments: 답글 리스트 (List<댓글> [])
        },
        ...
    ]
}
```


