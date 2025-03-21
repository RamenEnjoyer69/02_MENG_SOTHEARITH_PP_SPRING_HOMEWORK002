CREATE Table if not exists students (
    student_id Serial PRIMARY KEY,
    student_name varchar(255) not null,
    email varchar(255) not null,
    phone_number varchar(50) not null
);

CREATE TABLE if not exists instructors (
    instructor_id Serial PRIMARY KEY,
    instructor_name varchar(255) not null ,
    email varchar(50) not null
);

CREATE table if not exists Courses (
    course_id SERIAL PRIMARY KEY ,
    course_name varchar(255) not null,
    description varchar(500),
    instructor_id INT not null,
    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) references instructors (instructor_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE table if not exists student_course (
    id SERIAL PRIMARY KEY,
    student_id int not null,
    course_id int not null,
    CONSTRAINT fk_student FOREIGN KEY (student_id) references students(student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (course_id) references courses(course_id) ON DELETE CASCADE ON UPDATE CASCADE
)