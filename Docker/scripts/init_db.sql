CREATE USER testuser WITH PASSWORD 'testpass';

CREATE USER qa_user WITH PASSWORD 'qa_user';

CREATE DATABASE comparus;
GRANT ALL PRIVILEGES ON DATABASE comparus TO testuser;

CREATE DATABASE comparus2;
GRANT ALL PRIVILEGES ON DATABASE comparus2 TO testuser;

CREATE DATABASE comparus3;
GRANT ALL PRIVILEGES ON DATABASE comparus3 TO testuser;

CREATE DATABASE comparus_test;
GRANT ALL PRIVILEGES ON DATABASE comparus_test to qa_user;

CREATE DATABASE comparus_test_1;
GRANT ALL PRIVILEGES ON DATABASE comparus_test_1 to qa_user;
