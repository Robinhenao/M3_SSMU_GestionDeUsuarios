create table profiles (
      id_profile bigint not null auto_increment,
      name varchar(100) not null,
      image varchar(100) ,
      main_profile TINYINT(1) not null,
      id_user bigint not null,
      pin varchar(10) not null,
      primary key (id_profile),
      FOREIGN KEY (id_user) REFERENCES users(user_code)

)