CREATE TABLE h2_test (
    h2Id Long auto_increment,
    title varchar (30) not null ,
    content varchar (30) not null ,
    primary key(h2Id)
);

INSERT INTO h2_test(title, content, name)
VALUES('테스트 제목', '테스트 내용', '이름')