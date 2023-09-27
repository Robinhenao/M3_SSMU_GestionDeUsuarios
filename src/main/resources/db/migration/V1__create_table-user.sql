create table users (
      code_user bigint not null auto_increment,
      name varchar(100) not null,
      last_name varchar(100) not null,
      identity_card varchar(100) not null unique,
      email varchar(100) not null unique,
      primary key (code_user)
)