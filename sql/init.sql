--connect to postgres and run
DROP DATABASE IF EXISTS reportdb;
DROP USER IF EXISTS report_rw;
CREATE DATABASE reportdb;
CREATE USER report_rw PASSWORD 'report_rw';
GRANT CONNECT ON DATABASE reportdb TO report_rw;
