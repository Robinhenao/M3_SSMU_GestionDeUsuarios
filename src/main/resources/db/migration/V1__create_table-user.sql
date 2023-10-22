create table users (
      user_code bigint not null auto_increment,
      name varchar(100) not null,
      last_name varchar(100) not null,
      id_document varchar(100) not null unique,
      email varchar(100) not null unique,
      password varchar(300) not null,
      primary key (user_code)
)