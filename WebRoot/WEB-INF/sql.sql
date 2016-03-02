
 create database shop;
 
 CREATE TABLE t_user (                                  
          `id` int(6) NOT NULL,                                  
          `serial` varchar(100) COLLATE utf8_bin NOT NULL,       
          `username` varchar(15) COLLATE utf8_bin DEFAULT NULL,  
          `password` varchar(15) COLLATE utf8_bin DEFAULT NULL,  
          `status` int(1) DEFAULT NULL,                          
          PRIMARY KEY (`serial`)                                 
 )
 
 CREATE TABLE t_goods (                                                 
           `id` int(3) NOT NULL AUTO_INCREMENT,                                   
           `serial` varchar(10) COLLATE utf8_bin NOT NULL,                        
           `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,                      
           `type` varchar(20) COLLATE utf8_bin DEFAULT NULL,                      
           `introduce` varchar(100) COLLATE utf8_bin DEFAULT NULL,                
           `maker` varchar(20) COLLATE utf8_bin DEFAULT NULL,                     
           `price` float DEFAULT NULL,                                            
           `picture` varchar(50) COLLATE utf8_bin DEFAULT NULL,                   
           `user_serial` varchar(50) COLLATE utf8_bin DEFAULT NULL,               
           PRIMARY KEY (`id`,`serial`)                                            
 )
 
 CREATE TABLE `t_order` (                                   
           `userserial` varchar(50) COLLATE utf8_bin DEFAULT NULL,  
           `goodsserial` varchar(50) COLLATE utf8_bin DEFAULT NULL  
 )        
    