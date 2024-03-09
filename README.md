### clone project
- https://github.com/seohaebada/2021to2022/tree/master/jpa/studyolle_jpa
  - 위 프로젝트를 JAVA -> Kotlin으로 전환하는 프로젝트

## Account
|               |                                   | 
|---------------|-----------------------------------|
| API           | info                              |
| 회원가입          | post /account                     |
| 이메일 토큰 유효성 체크 | get /account/check-email-token    |
| 이메일 토큰 재발송    | get /account/resend-confirm-email |
| 유저의 프로필 정보 조회 | get /account/profile/{nickname}   |
| 패스워드 변경       | put /account/password             |


## Account Login
|                 |                                      | 
|-----------------|--------------------------------------|
| API             | info                                 |
| 로그인 히스토리 단건 등록  | post /account-login                  |
| 로그인 히스토리 리스트 조회 | get /account-login                   |
| 로그인 히스토리 단건조회   | get /account-login/{accountLoginIdx} |


## Study
|            |                       | 
|------------|-----------------------|
| API        | info                  |
| 스터디 등록     | post /study           |
| 스터디 단건조회   | get /study/{studyIdx} |
| 스터디 리스트 조회 | get /study            |


## Tag
|           |               | 
|-----------|---------------|
| API       | info          |
| 태그 등록     | post /tag     |
| 태그 삭제     | delete /tag   |
| 태그 리스트 조회 | get /tag/list |
| 태그 정보 조회  | get /tag      |


## Zone
|             |                 | 
|-------------|-----------------|
| API         | info            |
| zone 초기화    | post /zone/init |
| zone 등록     | post /zone      |
| zone 삭제     | delete zone     |
| zone 리스트 조회 | get /zone/list  |
| zone 정보 조회  | get /zone       |


## Notification
|     |      | 
|-----|------|
| API | info |


## Event
|     |      | 
|-----|------|
| API | info |


## Profile
|     |      | 
|-----|------|
| API | info |
