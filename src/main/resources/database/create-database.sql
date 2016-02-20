create table user (
  id bigint not null auto_increment,
  name varchar(45) not null,
  email varchar(45) not null,
  birth date,
  PRIMARY KEY (id)
);

