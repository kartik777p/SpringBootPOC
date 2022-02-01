
create database POC3;

use POC3;

create table AUTHOR (AUTHOR_ID INT auto_increment primary key, AUTHOR_NAME VARCHAR(100) not null);
insert into author (author_name) values ("JAMES BOND");
select*from author;

CREATE TABLE POST  (POST_ID INT primary key auto_increment, 
                   POST_NAME varchar(300) not null,
                   AUTHOR_ID int,
                   foreign key(AUTHOR_ID) references AUTHOR (AUTHOR_ID),
                    CREATED_AT datetime);
select*from post;

INSERT INTO POST (POST_ID, POST_NAME, AUTHOR_ID, CREATED_AT) VALUES (
                                                                     1, "FIRST POST",1,current_timestamp()),
                                                                     (2, "SECOND POST",1,current_timestamp()),
                                                                     (3, "THIRD POST",1,current_timestamp()),
                                                                     (4, "FOURTH POST",1,current_timestamp()),
                                                                     (5, "FIFTH POST",1,current_timestamp());

CREATE TABLE COMMENT (COMMENT_ID INT PRIMARY KEY auto_increment,
                      CONTENT varchar(10000),
					  POST_ID INT,
                      foreign key(POST_ID) references POST (POST_ID),
                      CREATED_AT datetime,
					   USER_ID INT,
                       foreign key(USER_ID) references USER (USER_ID));
SELECT*FROM COMMENT;

INSERT INTO COMMENT (COMMENT_ID, CONTENT, POST_ID, CREATED_AT,USER_ID) VALUES (
																	1, "FIRST COMMENT",1,current_timestamp(),1),
                                                                     (2, "SECOND COMMENT",1,current_timestamp(),1),
                                                                     (3, "THIRD COMMENT",1,current_timestamp(),1),
                                                                     (4, "FOURTH COMMENT",2,current_timestamp(),1),
                                                                     (5, "FIFTH COMMENT",1,current_timestamp(),1),
                                                                     (6, "SIXTH COMMENT",2,current_timestamp(),1),
                                                                     (7, "SEVENTH COMMENT",2,current_timestamp(),1),
                                                                     (8, "EIGHTTH COMMENT",2,current_timestamp(),1),
                                                                     (9, "NINETH COMMENT",2,current_timestamp(),1),
                                                                     (10, "TENTH COMMENT",2,current_timestamp(),1);
					
CREATE TABLE USER (USER_ID INT PRIMARY KEY,
				 USER_NAME VARCHAR(100));
                 
insert into user(user_id,user_name) values (1,"Kartik");
                 
SELECT*FROM USER;
                      
/* Query: Get list of Posts with latest 10 comments of each post authored by 'James Bond'*/


select P.POST_ID,P.POST_NAME,P.CREATED_AT,A.AUTHOR_NAME,C.COMMENT_ID,C.CONTENT,C.CREATED_AT
from POST P
right join AUTHOR A ON P.AUTHOR_ID=A.AUTHOR_ID
right join COMMENT C ON C.POST_ID=P.POST_ID  where A.AUTHOR_NAME="JAMES BOND"  ORDER BY C.CREATED_AT DESC;
