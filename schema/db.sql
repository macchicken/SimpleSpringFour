CREATE TABLE comp5347shop.person(
  id varchar(50) NOT NULL,
  firstName varchar(100) NOT NULL,
  lastName varchar(100) DEFAULT NULL,
  email varchar(100) NOT NULL,
  age int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;