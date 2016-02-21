create table user (
  id int not null auto_increment,
  name varchar(100) not null,
  email varchar(100) not null,
  birth date,
  primary key (id)
);

create table event (
  id int not null auto_increment,
  name varchar(100) not null,
  rating int,
  price double,
  primary key (id)
);

create table assignment (
  id int not null auto_increment,
  event_id int,
  auditorium_id int,
  assignment_datetime datetime,
  primary key (id)
);

