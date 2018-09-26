#书本表
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`(
    `id` BIGINT (15)  AUTO_INCREMENT COMMENT 'id',
    `description` MEDIUMTEXT COMMENT 'desc',
    `download_link` VARCHAR (256)  DEFAULT '' COMMENT 'downloadLink',
    `category` VARCHAR (50)  DEFAULT '' COMMENT 'category',
    `title` VARCHAR (50)  DEFAULT '' COMMENT 'title',
    `author` VARCHAR (50)  DEFAULT '' COMMENT 'author',
    `rate` VARCHAR (50)  DEFAULT '' COMMENT 'rate',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UNIQ_IDX_TITLE_AUTHOR`(`title`,`author`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`book`';
