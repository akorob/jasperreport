-- connect to reportdb and run
CREATE SCHEMA IF NOT EXISTS report;
GRANT USAGE ON SCHEMA report TO report_rw;
ALTER DEFAULT PRIVILEGES IN SCHEMA report
    GRANT SELECT, INSERT, UPDATE, DELETE, TRUNCATE ON TABLES TO report_rw;
ALTER SCHEMA report OWNER TO report_rw;

CREATE TABLE report.EMPLOYEE(
    ID INT  NOT NULL PRIMARY KEY,
    FIRST_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255),
    SALARY NUMERIC(10,2)
);

CREATE TABLE report.EMAIL(
    ID INT NOT NULL PRIMARY KEY,
    ID_EMPLOYEE INT,
    ADDRESS VARCHAR(255)
);

INSERT INTO report.EMPLOYEE VALUES (1, 'John', 'Doe', 10000.10);
INSERT INTO report.EMPLOYEE VALUES (2, 'Kevin', 'Smith', 20000.20);
INSERT INTO report.EMPLOYEE VALUES (3, 'Kim', 'Smith', 30000.30);
INSERT INTO report.EMPLOYEE VALUES (4, 'Stephen', 'Torvalds', 40000.40);
INSERT INTO report.EMPLOYEE VALUES (5, 'Christian', 'Reynolds', 50000.50);

INSERT INTO report.EMAIL VALUES (1, 1, 'john@baeldung.com');
INSERT INTO report.EMAIL VALUES (2, 1, 'john@gmail.com');
INSERT INTO report.EMAIL VALUES (3, 2, 'kevin@baeldung.com');
INSERT INTO report.EMAIL VALUES (4, 3, 'kim@baeldung.com');
INSERT INTO report.EMAIL VALUES (5, 3, 'kim@gmail.com');
INSERT INTO report.EMAIL VALUES (6, 3, 'kim@outlook.com');
INSERT INTO report.EMAIL VALUES (7, 4, 'stephen@baeldung.com');
INSERT INTO report.EMAIL VALUES (8, 5, 'christian@gmail.com');

ALTER TABLE report.email OWNER TO report_rw;
ALTER TABLE report.employee OWNER TO report_rw;
GRANT SELECT, INSERT, UPDATE, DELETE ON report.email TO report_rw;
GRANT SELECT, INSERT, UPDATE, DELETE ON report.employee TO report_rw;
