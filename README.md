# delivEatAPI
 ----
 배달 어플리케이션을 위한 API

 ## 목표 기능
Service for customer
* 음식 주문
* 주문 상태 조회 (접수중 / 거절 / 접수완료 / 배달중 / 배달완료)

Service for Owner
* 음식 등록/수정/삭제
* 주문 조회
* 주문 접수 처리
* 주문 거절 처리
* 배달 시작 처리
* 배달 완료 처리

## 기술 스텍
* Backend : Spring, JPA
* DB : MySQL
 
## 프로젝트 구조
DDD를 지향하여 도메인단위로 패키지를 구성합니다.
---
delivEatAPI
└───src
│   └───main
│   │   └───java
│   │   │   └───com.example.delivEatAPI
│   │   │       └───domain
│   │   │       │   |───food
│   │   │       │   └───Restairant
│   │   │       └───BookclubApplication.java
│   │   └───resources
│   │       │   application.properties
│   │       │   static
│   │       └──templates
│   └───test
│       └───java
│           └───com.example.delivEatAPI
│               └───DelivEatApiApplicationTests.java
│   .gitignore
│   build.gradle
│   gradlew
│   gradlew.bat
│   README.md
└──settings.gradle
```
