CREATE TABLE tb_schedule_attr_quartz (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  cron_expression VARCHAR(45) NOT NULL,
  enabled CHAR(1) NOT NULL,
  processed CHAR(1) NOT NULL,
  className VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tb_schedule_attr_quartz (id,name,cron_expression,enabled,processed,className) VALUES 
 (1,'Prueba 01','0/6 * * * * ?','N','Y','com.cron.scheduller.Prueba01'),
 (2,'Prueba 02','0/5 * * * * ?','Y','Y','com.cron.scheduller.Prueba02');