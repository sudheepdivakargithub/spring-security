INSERT INTO USERS (USERNAME,PASSWORD,ENABLED) VALUES ('sudheep','sudheep',true);
INSERT INTO USERS (USERNAME,PASSWORD,ENABLED) VALUES ('soumya','soumya',true);

INSERT INTO AUTHORITIES (username,authority) values ('sudheep','ROLE_USER');
INSERT INTO AUTHORITIES (username,authority) values ('soumya','ROLE_ADMIN');