CREATE TABLE users_course (
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    date_enrolled VARCHAR(255),
    grade VARCHAR(255),
    PRIMARY KEY (user_id, course_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);
