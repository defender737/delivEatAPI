# delivEatAPI
배달 어플리케이션을 위한 API

## 목표 기능
### Service for customer
* 음식 주문
* 주문 상태 조회 (접수중 / 거절 / 접수완료 / 배달중 / 배달완료)

### Service for Owner
* 음식 등록/수정/삭제
* 주문 조회
* 주문 접수 처리
* 주문 거절 처리
* 배달 시작 처리
* 배달 완료 처리

## URL

| 기능           | HTTP 메서드 | 엔드포인트                        |
|--------------|------------|---------------------------------|
| 유저           | POST       | /v1/user                         |
| 유저           | GET        | /v1/user/{user_id}               |
| 유저           | PUT        | /v1/user                         |
| 유저           | DELETE     | /v1/user/{user_id}               |
| 메뉴           | POST       | /v1/shop/{shop_id}/menu          |
| 메뉴           | GET        | /v1/shop/{shop_id}/menu          |
| 메뉴           | GET        | /v1/shop/{shop_id}/menu/{menu_id}|
| 메뉴           | PUT        | /v1/shop/{shop_id}/menu/{menu_id}|
| 메뉴           | DELETE     | /v1/shop/{shop_id}/menu          |
| 메뉴           | DELETE     | /v1/shop/{shop_id}/menu/{menu_id}|
| 주문           | POST       | /v1/user/{user_id}/order         |
| 주문           | GET        | /v1/order/{order_id}             |
| 주문           | GET        | /v1/user/{user_id}/order         |
| 주문           | PUT        | /v1/order/{order_id}/{status}    |
| 매장           | POST       | /v1/shop                         |
| 매장           | GET        | /v1/shop/{shop_id}               |
| 매장           | PUT        | /v1/shop                         |
| 매장           | DELETE     | /v1/shop/{shop_id}               |
| 매장           | PUT        | /v1/shop/{shop_id}/{status}      |
| 주문 내부 메뉴     | POST  | /v1/order/{order_id}/cart       |
| 주문 내부 메뉴 | PUT   | /v1/order/{order_id}/cart/{cart_id}/{quantity} |
| 주문 내부 메뉴  | DELETE| /v1/order/{order_id}/cart/{cart_id} |
| 배달           | POST       | /v1/delivery                     |
| 배달           | GET        | /v1/delivery/{delivery_id}       |
| 배달           | PUT        | /v1/delivery/{delivery_id}       |




## 기술 스텍
* Backend : Spring, JPA
* DB : MySQL

## 현재 프로젝트 구조
DDD를 지향하며 도메인 단위로 패키지를 구성합니다.
```
delivEatAPI
└───src
│   └───main
│   │   └───java
│   │   │   └───com.example.delivEatAPI
│   │   │       └───domain
│   │   │       │   └───shop
│   │   │       │   │    └───Shop.java
│   │   │       │   │    └───ShopDto.java
│   │   │       │   │    └───ShopController.java
│   │   │       │   │    └───ShopService.java
│   │   │       │   │    └───ShopServiceImpl.java
│   │   │       │   │    └───ShopMenuRepository.java
│   │   │       │   │    └───ShopMapper.java
│   │   │       │   │    └───ShopCategoryEnum.java
│   │   │       │   └───menu
│   │   │       │   └───order
│   │   │       │   └───cart
│   │   │       │   └───user
│   │   │       │   └───delivey
│   │   │       └───error
│   │   │       │   └───MenuNotFoundException.java
│   │   │       │   └───ShopNotFoundException.java
│   │   │       └───global
│   │   │       │   └───config
│   │   │       │       └───GenericMapper.java
│   │   │       └───delivEatApiApplication.java
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

## 도메인 클래스 다이어그램(ex. menu도메인)

![](images/ClassDiagram4.png)

## ERD

![](images/ERD4.png)