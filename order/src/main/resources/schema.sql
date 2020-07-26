DROP TABLE IF EXISTS orders;
CREATE TABLE orders(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  customer_name varchar(100) DEFAULT NULL,
  order_date date  DEFAULT NULL,
  shipping_address varchar(100) DEFAULT NULL,
  total bigint(20) DEFAULT '0',
  created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);