DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS stipend CASCADE;
CREATE TABLE student (
  id BIGINT NOT NULL ,
  name VARCHAR(255) ,
  group_name VARCHAR(255) ,
  PRIMARY KEY (id )
);
CREATE TABLE stipend (
  id BIGINT NOT NULL ,
  value INT ,
  student_id BIGINT ,
  PRIMARY KEY ( id ),
  CONSTRAINT FK_STUDENT FOREIGN KEY (student_id) REFERENCES student(id)
);

INSERT INTO student(id,name,group_name) VALUES (0,'SIDR SIDOROV','1204');
INSERT INTO student(id,name,group_name) VALUES (1,'PETR SIDOROV','1205');
INSERT INTO student(id,name,group_name) VALUES (2,'PETR IVANOV','1206');

INSERT INTO stipend(id,value,student_id) VALUES (0,100,0);
INSERT INTO stipend(id,value,student_id) VALUES (1,0,1);
INSERT INTO stipend(id,value,student_id) VALUES (2,200,2);