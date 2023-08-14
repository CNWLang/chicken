CREATE TABLE Course
(
    course_id              BIGINT AUTO_INCREMENT NOT NULL,
    course_no              VARCHAR(255)          NULL,
    start_date             VARCHAR(255)          NULL,
    end_date               VARCHAR(255)          NULL,
    course_state           INT                   NOT NULL,
    course_money           DOUBLE                NOT NULL,
    course_student_name    VARCHAR(255)          NULL,
    course_student_usertel VARCHAR(255)          NULL,
    course_teacher         VARCHAR(255)          NULL,
    CONSTRAINT pk_course PRIMARY KEY (course_id)
);