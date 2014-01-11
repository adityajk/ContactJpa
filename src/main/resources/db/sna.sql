
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `summary` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `event_when` date DEFAULT NULL,
  `owner_id` int(11) unsigned NOT NULL,
  `attendee_id` int(11) unsigned NOT NULL,
    
  CONSTRAINT events_account_fk
  FOREIGN KEY (owner_id)
  REFERENCES sna_account(id) ON DELETE CASCADE,
  
  CONSTRAINT events_sna_account_fk
  FOREIGN KEY (attendee_id)
  REFERENCES sna_account(id) ON DELETE CASCADE  
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;



CREATE TABLE IF NOT EXISTS `sna_account` (
  `id` int(11) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` varchar(250) COLLATE utf8_unicode_ci NOT NULL unique,
  `email` varchar(75) COLLATE utf8_unicode_ci NOT NULL unique,
  `password` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `language` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime NOT NULL,
  `first_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `is_active` int(1) NOT NULL,
  `date_joined` datetime NOT NULL,
  role_id int(11) unsigned not null,
    
  CONSTRAINT account_authority_fk
  FOREIGN KEY (role_id)
  REFERENCES sna_authorities(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;



CREATE TABLE IF NOT EXISTS `sna_authorities` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `authority` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;




