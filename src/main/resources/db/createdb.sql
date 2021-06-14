create database if not exists polldb;

create user if not exists 'poller'@'localhost' identified by '#Poller123';
grant  all privileges on polldb.* 'poller'@'localhost';
flush privileges;