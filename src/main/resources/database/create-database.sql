create table user (
  id int not null auto_increment,
  name varchar(100) not null,
  email varchar(100) not null,
  birth date,
  PRIMARY KEY (id)
);

create table event (
  id int not null auto_increment,
  name varchar(100) not null,
  rating int,
  price double,
  PRIMARY KEY (id)
);

