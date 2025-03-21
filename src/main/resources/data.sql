INSERT INTO students (student_name, email, phone_number) VALUES
    ('Alice Johnson', 'alice.johnson@example.com', '123-456-7890'),
    ('Bob Smith', 'bob.smith@example.com', '234-567-8901'),
    ('Charlie Davis', 'charlie.davis@example.com', '345-678-9012'),
    ('Diana Evans', 'diana.evans@example.com', '456-789-0123'),
    ('Ethan Brown', 'ethan.brown@example.com', '567-890-1234');


INSERT INTO instructors (instructor_name, email) VALUES
    ('Dr. Emily Carter', 'emily.carter@example.com'),
    ('Prof. John Miller', 'john.miller@example.com'),
    ('Dr. Sarah Thompson', 'sarah.thompson@example.com'),
    ('Prof. David Wilson', 'david.wilson@example.com'),
    ('Dr. Laura Martinez', 'laura.martinez@example.com');


INSERT INTO Courses (course_name, description, instructor_id)
VALUES
    ('Java Programming', 'Comprehensive Java course covering OOP, streams, and collections.', 1),
    ('Database Management', 'Learn PostgreSQL, MySQL, and database design principles.', 2),
    ('Web Development', 'Covers HTML, CSS, JavaScript, and modern frameworks.', 3),
    ('Data Structures & Algorithms', 'In-depth study of algorithms and data structures using Java.', 4),
    ('Software Engineering', 'Covers SDLC, Agile methodologies, and software design patterns.', 5);
