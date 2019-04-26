drop table member;

create table member(
	user_id varchar2(20) primary key,
	user_pass varchar2(20) not null,
	username varchar2(20) not null,
	image varchar2(20) not null,
	email varchar2(50) not null,
	favor number not null,
	isadmin number default 0 not null
);

drop table word;

create table word(
	num number primary key,
	word varchar2(50) not null,
	meaning varchar2(4000) not null,
	kind number not null,
);

drop sequence word_num;
create sequence word_num;

drop table kind;

create table kind(
	kind_id number primary key,
	kind varchar2(50) not null
);

drop sequence kind_id;
create sequence kind_id;

drop table word_book;


create table word_book(
    
	user_id varchar2(20) not null,
	wordnum number not null,
	sheet number not null,
	name varchar2(20) not null,
	star number default 0 not null	
);

drop table grade;

create table grade(
    
	id number primary key,
	t_date date not null,   
	user_id varchar2(20) not null,
	name varchar2(20) not null,
	crr number,
	incrr number
	
);

drop sequence grade_id;
create sequence grade_id;

drop table notice;

create table notice(
    
	num number primary key,
	title varchar2(50) not null,   
	content varchar2(4000) not null,
	w_date date not null,
	writer varchar2(50) not null,
	
);

drop table qna;

create table qna(
    
	num number primary key,
	title varchar2(50) not null,   
	content varchar2(4000) not null,
	w_date date not null,
	writer varchar2(50) not null,
	ans varchar2(4000) not null
	check number default 0 not null
);