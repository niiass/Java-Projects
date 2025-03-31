CREATE TABLE IF NOT EXISTS mcdonalds.products (
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(45) NOT NULL,
  name VARCHAR(200) NOT NULL,
  img VARCHAR(200),
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id)
);
