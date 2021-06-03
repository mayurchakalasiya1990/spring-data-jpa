
insert into passport values(10,"F1233212");
insert into passport values(2,"A1233212");
insert into passport values(3,"B1233212");
insert into passport values(4,"C1233212");
insert into passport values(5,"E1233212");

--insert into student values(1,18,"test1@email.com","Mayur","Chakalasiya");
--insert into student values(2,22,"test2@email.com","Ramesh","Pawar");
--insert into student values(3,21,"test3@email.com","James","Parker");
--insert into student values(4,25,"test4@email.com","Steve","Smith");
--insert into student values(5,27,"test5@email.com","Robert","Robert");


--insert into review(ID,rating,description) values(1,5,"Best");
--insert into review(ID,rating,description) values(2,3,"Average");
--insert into review(ID,rating,description) values(3,4,"Good");
--insert into review(ID,rating,description) values(4,2,"need to improve audio");
--insert into review(ID,rating,description) values(5,1,"Irrelevant information");

update passport set passportNo='A1233212' where ID=10;
update passport set passportNo='B1233212' where ID=2;
update passport set passportNo='C1233212' where ID=3;
update passport set passportNo='E1233212' where ID=4;
update passport set passportNo='F1233212' where ID=5;

update student set passport_id='A1233212' where id=1;
update student set passport_id='B1233212' where id=2;
update student set passport_id='C1233212' where id=3;
update student set passport_id='E1233212' where id=4;
update student set passport_id='F1233212' where id=5;
