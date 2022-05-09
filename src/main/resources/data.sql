-- noinspection SqlNoDataSourceInspectionForFile
CREATE TABLE IF NOT EXISTS `ngo` (
                       `ngo_id` bigint NOT NULL AUTO_INCREMENT,
                       `address1` varchar(255) NOT NULL,
                       `address2` varchar(255) NOT NULL,
                       `city` varchar(255) NOT NULL,
                       `details` varchar(255) NOT NULL,
                       `email_id` varchar(255) NOT NULL,
                       `mobile` varchar(255) NOT NULL,
                       `name` varchar(255) NOT NULL,
                       `pin_code` int NOT NULL,
                       PRIMARY KEY (`ngo_id`)
);
DELETE FROM ngo;
INSERT INTO ngo (`ngo_id`,`address1`, `address2`, `city`, `details`, `email_id`, `mobile`, `name`, `pin_code`) VALUES (1,'yamuna park', 'kamrej', 'surat', 'Food NGO', 'dradadiya990@gmail.com', '9909859936', 'Yamuna', '395005');
INSERT INTO ngo (`ngo_id`,`address1`, `address2`, `city`, `details`, `email_id`, `mobile`, `name`, `pin_code`) VALUES (2,'Lakhan park', 'citylight', 'surat', 'NGO', 'dradadiya0002@gmail.com', '9773180438', 'Narayan', '395006');