Create database Crownpass_user_db;
use Crownpass_user_db;

create table C_User(
id int not null,
Name varchar(255),
age int,
email varchar(255),
citizen_card varchar(255),
primary key(id)

);

Insert into C_User(id, Name, age, email, citizen_card) values(1, 'Kim Tae', 25, 'abc@gmail.com', '123456765467');