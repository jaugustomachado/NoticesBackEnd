CREATE DATABASE IF NOT EXISTS notices_database;

CREATE TABLE IF NOT EXISTS notices_database.notices (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    descriptions VARCHAR(200) NOT NULL,
    publication_date VARCHAR(10),
    viewing_date VARCHAR(10),
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT UNIQUE_title UNIQUE KEY (title)
    );

SELECT * FROM notices_database.notices;

DROP TABLE notices_database.notices;
DROP SCHEMA notices_database;