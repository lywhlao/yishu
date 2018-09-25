-- auto Generated on 2018-09-25 19:21:06 
-- DROP TABLE IF EXISTS `book_p_o`; 
CREATE TABLE `book`(
    `id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `desc` MEDIUMTEXT NOT NULL DEFAULT '' COMMENT 'desc',
    `download_link` VARCHAR (256) NOT NULL DEFAULT '' COMMENT 'downloadLink',
    `category` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'category',
    `title` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'title',
    `author` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'author',
    `rate` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'rate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`book`';
