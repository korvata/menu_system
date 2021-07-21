# 티오더 백엔드개발자 채용 과제

## 0. 시작하기전
### DDL
DDL

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
