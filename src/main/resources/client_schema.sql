DROP TABLE IF EXISTS TBL_CLIENT;

CREATE TABLE TBL_CLIENT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(70) NOT NULL,
  password VARCHAR(100) NOT NULL
);