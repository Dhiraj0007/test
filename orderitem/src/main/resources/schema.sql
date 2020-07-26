
CREATE TABLE order_item(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  product_name varchar(100) DEFAULT NULL,
  productCode varchar(100) DEFAULT NULL,
  quantity bigint(20) DEFAULT '0',
  order_id bigint(20) DEFAULT '0',
  created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);