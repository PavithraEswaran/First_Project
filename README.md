create table employee(employeeId int not null primary key,employeeName varchar(20) not null,employeeDesignation varchar(20) not null,employeeLocation varchar(20) not null,username varchar(20) not null,password varchar(20),role varchar(20) not null);
Query OK, 0 rows affected (0.07 sec)

mysql> create table questions(questionId int not null primary key auto_increment,questionDescription varchar(20) not null,date date not null,employeeId int not null,foreign key (employeeId) references employee(employeeId));
Query OK, 0 rows affected (0.09 sec)

mysql> create table answers(answerId int not null primary key,questionId int not null,answerDescription varchar(20) not null,date date not null,employeeId int not null,foreign key (questionId) references question(questionId),foreign key (employeeId) references employee(employeeId));
ERROR 1005 (HY000): Can't create table 'vforum.answers' (errno: 150)
mysql> create table answers(answerId int not null primary key,questionId int not null,answerDescription varchar(20) not null,date date not null,employeeId int not null,foreign key (questionId) references question(questionId),foreign key (employeeId) references employee(employeeId));
ERROR 1005 (HY000): Can't create table 'vforum.answers' (errno: 150)
mysql> create table answers(answerId int not null primary key,questionId int not null,answerDescription varchar(20) not null,date date not null,employeeId int not null,foreign key (questionId) references questions(questionId),foreign key (employeeId) references employee(employeeId));
Query OK, 0 rows affected (0.10 sec)

mysql>
mysql> drop table employee;
ERROR 1217 (23000): Cannot delete or update a parent row: a foreign key constraint fails
mysql> delete from employee;
Query OK, 1 row affected (0.03 sec)

mysql> insert into employee values(123456,"admin","admin","chennai","admin","123456","ADMIN");
Query OK, 1 row affected (0.04 sec)
