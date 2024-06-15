CREATE TABLE fact
(
    id         binary(16) PRIMARY KEY,
    content    TEXT,
    picture_id binary(16),
    timestamps DATETIME,
    likes      VARCHAR(5),
    comment    TEXT,
    FOREIGN KEY (picture_id) REFERENCES picture(id)
);

CREATE TABLE fact_user (
    id binary(16) PRIMARY KEY,
    fact_id binary(16) ,
    user_role_id binary(16),
    foreign key (fact_id) references fact(id),
    foreign key (user_role_id) references user_role(id)
);

ALTER TABLE fact
        ADD COLUMN fact_user_id binary(16),
        ADD FOREIGN KEY (fact_user_id) REFERENCES fact_user(id);