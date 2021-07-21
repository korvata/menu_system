# 티오더 백엔드개발자 채용 과제

## 0. 시작하기전
### DDL
create table member (
       member_id varchar(255) not null,
        pwd varchar(255),
        primary key (member_id)
    )
	
	
create table menu (
       menu_id bigint not null,
        name varchar(255),
        price integer not null,
        primary key (menu_id)
    )
	
	
create table order_menu (
       order_menu_id bigint not null,
        count integer not null,
        menu_id bigint,
        order_id bigint,
        primary key (order_menu_id)
    ) 
	
create table orders (
       order_id bigint not null,
        order_date_time datetime(6),
        member_id varchar(255),
        payment_id bigint,
        primary key (order_id)
    )
	
create table payment (
       payment_id bigint not null,
        status varchar(255),
        primary key (payment_id)
    )
    
alter table order_menu 
   add constraint menu_id 
   foreign key (menu_id) 
   references menu (menu_id)


alter table order_menu 
   add constraint order_id 
   foreign key (order_id) 
   references orders (order_id)


alter table orders 
   add constraint member_id 
   foreign key (member_id) 
   references member (member_id)


alter table orders 
   add constraint payment_id 
   foreign key (payment_id) 
   references payment (payment_id)

## 1. 설계구조

### 엔티티 구조

![image](https://user-images.githubusercontent.com/45089402/126480792-86769929-c201-4e3b-8fb8-7c22f539e908.png)


### DB 구조

![image](https://user-images.githubusercontent.com/45089402/126485959-4c7aaaee-198b-4aa2-bee4-747455623541.png)


## 2. 코드설명

## 3. 결과 화면

### 홈화면
![image](https://user-images.githubusercontent.com/45089402/126512247-05c0b77b-f96d-4d94-8359-9e501ad553f3.png)

### 로그인
![image](https://user-images.githubusercontent.com/45089402/126512342-3f9da318-bc34-4c2d-b20c-1adf0b98cae0.png)

### 메뉴(로그인 성공시)
![image](https://user-images.githubusercontent.com/45089402/126512641-86d326b0-e2b6-4ebf-978b-acf11ea32729.png)

### 메뉴에서 체크박스 선택 후 장바구니 담기 버튼을 통해 장바구니에 담김(장바구니 담기 버튼 한번 누를때마다 해당 메뉴 수량이 하나씩 증가)
![image](https://user-images.githubusercontent.com/45089402/126513262-ba9009b0-5749-4f07-b132-bf29e21922a0.png)

### 체크된 메뉴에서 장바구니 담기 3번을 누르고 장바구니 이동을 눌렀을 때
![image](https://user-images.githubusercontent.com/45089402/126513362-0f7cd7e5-b9e4-4383-ab1a-6be51a302fdf.png)

