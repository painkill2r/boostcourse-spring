#### 최초 작성일 : 2021.08.10(화)

# Boostcourse Java Back-end 과정 학습

여기서는 Boostcourse Spring Framework DI/IoC, AOP, JUnit Test 학습을 진행한다.

## 학습 환경

1. OS : MacOS
2. JDK : OpenJDK 11.0.5
4. Build Tools : Maven
5. Database : MySQL
6. IDE: IntelliJ IDEA Ultimate

## IntelliJ Spring Framework 프로젝트 설정 방법

### Maven 프로젝트 설정

### Spring Framework 프로젝트로 변경

## Spring Framework

![Spring Framework](./images/spring01.png)

1. 엔터프라이즈급 어플리케이션을 구축할 수 있는 가벼운 솔루션이자, 원스-스탑-숍(One-Stop-Shop).
    - One-Stop-Shop: 모든 과정을 한꺼번에 해결할 수 있다.
2. 원하는 부분만 가져다 사용할 수 있도록 모듈화가 잘 되어 있음.
3. IoC 컨테이너.
4. 선언적으로 트랜잭션을 관리할 수 있음.
5. 완전한 기능을 갖춘 MVC Framework를 제공.
6. AOP 지원
7. 스프링은 도메인 논리 코드와 쉽게 분리될 수 있는 구조로 되어 있음.

### 프레임워크 모듈

1. 스프링은 약 20개의 모듈로 구성되어 있음.
2. 필요한 모듈만 가져다 사용할 수 있음.

### AOP 와 인스트루멘테이션 (Instrumentation)

1. `spring-AOP` : AOP 얼라이언스(Alliance)와 호환되는 방법으로 AOP를 지원.
2. spring-aspects : AspectJ와의 통합을 제공.
3. spring-instrument : 인스트루멘테이션을 지원하는 클래스와 특정 WAS에서 사용하는 클래스로 더 구현체를 제공.
    - 참고로 BCI(Byte Code Instrumentations)은 런타임이나 로드(Load) 때 클래스의 바이트 코드에 변경을 가하는 방법을 말함.

### 메시징(Messaging)

1. `spring-messaging` : 스프링 프레임워크 4는 메시지 기반 어플리케이션을 작성할 수 있는 Message, MessageChannel, MessageHandler 등을 제공.
2. 또한, 해당 모듈에는 메소드에 메시지를 맵핑하기 위한 어노테이션도 포함되어 있으며, Spring MVC 어노테이션과 유사함.

### 데이터 엑서스(Data Access) / 통합(Integration)

1. 데이터 엑세스/통합 계층은 JDBC, ORM, OXM, JMS 및 트랜잭션 모듈로 구성되어 있다.
2. `spring-jdbc` : 자바 JDBC프로그래밍을 쉽게 할 수 있도록 기능을 제공.
3. `spring-tx` : 선언적 트랜잭션 관리를 할 수 있는 기능을 제공.
4. spring-orm : JPA, JDO및 Hibernate를 포함한 ORM API를 위한 통합 레이어를 제공.
5. spring-oxm : JAXB, Castor, XMLBeans, JiBX 및 XStream과 같은 Object/XML 맵핑을 지원.
6. spring-jms : 메시지 생성(producing) 및 사용(consuming)을 위한 기능을 제공, Spring Framework 4.1부터 spring-messaging모듈과의 통합을 제공.

### 웹(Web)

1. 웹 계층은 spring-web, spring-webmvc, spring-websocket, spring-webmvc-portlet 모듈로 구성됨.
2. `spring-web` : 멀티 파트 파일 업로드, 서블릿 리스너 등 웹 지향 통합 기능을 제공한다. HTTP클라이언트와 Spring의 원격 지원을 위한 웹 관련 부분을 제공.
3. `spring-webmvc` : Web-Servlet 모듈이라고도 불리며, Spring MVC 및 REST 웹 서비스 구현을 포함.
4. spring-websocket : 웹 소켓을 지원.
5. spring-webmvc-portlet : 포틀릿 환경에서 사용할 MVC 구현을 제공.

## Spring IoC/DI 컨테이너

### 컨테이너

1. `컨테이너`란 컨테이너는 `인스턴스의 생명주기를 관리`하며, `생성된 인스턴스에게 추가적인 기능을 제공`한다.
    - 예를 들어, Servlet을 실행해주는 WAS는 Servlet 컨테이너를 가지고 있다고 말한다.
        - WAS는 웹 브라우저로부터 서블릿 URL에 해당하는 요청을 받으면, 서블릿을 메모리에 올린 후 실행한다.
        - 개발자가 서블릿 클래스를 작성했지만, 실제로 메모리에 올리고 실행하는 것은 WAS가 가지고 있는 `Servlet 컨테이너`이다.

### IoC(Inversion of Control, 제어의 역전)

1. 컨테이너가 코드 대신 오브젝트의 제어권을 갖고 있어 IoC(제어의 역전)이라 한다.
    - 예를 들어, 서블릿 클래스는 개발자가 만들지만, 그 서블릿의 메소드를 알맞게 호출하는 것은 WAS이다.
    - 이렇게 개발자가 만든 어떤 클래스나 메소드를 `다른 프로그램이 대신 실행해주는 것을 제어의 역전`이라고 한다.

### DI(Dependency Injection, 의존성 주입)

1. DI는 의존성 주입이란 뜻을 가지고 있으며, `클래스 사이의 의존 관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결`해주는 것을 말한다.
    - DI가 적용 안된 (예)
      ```java
      class 엔진 {
      
      }
      
      class 자동차 {
           엔진 v5 = new 엔진();
      }
       ```
      ![DI가 적용 안된 예](./images/di01.png)
    - DI가 적용된 (예)
      ```java
      @Component
      class 엔진 {
      
      }
      
      @Component
      class 자동차 {
           @Autowired
           엔진 v5;
      }
      ```
      ![DI가 적용된 예](./images/di02.png)

### Spring에서 제공하는 IoC/DI 컨테이너

1. BeanFactory : IoC/DI에 대한 기본 기능을 가지고 있음.
2. ApplicationContext : BeanFactory의 모든 기능을 포함하며, 일반적으로 BeanFactory보다 추천된다.
    - 트랜잭션처리, AOP등에 대한 처리를 할 수 있음.
    - `BeanPostProcessor`, `BeanFactoryPostProcessor`등을 자동으로 등록하고, 국제화 처리, 어플리케이션 이벤트 등을 처리할 수 있음.
        - BeanPostProcessor : 컨테이너의 기본 로직을 오버라이딩하여 인스턴스화와 의존성 처리 로직 등을 개발자가 원하는 대로 구현 할 수 있도록 한다.
        - BeanFactoryPostProcessor : 설정된 메타 데이터를 커스터마이징 할 수 있음.