CREATE TABLE category (
                          id binary(16) PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE picture (
                         id binary(16) PRIMARY KEY,
                         url varchar(255),
                         description varchar(255) NOT NULL
);

CREATE TABLE blog (
      id binary(16) PRIMARY KEY,
      title VARCHAR(255) NOT NULL,
      picture_id binary(16),
      content TEXT NOT NULL ,
      timestamps DATETIME,
      category_id binary(16),
      FOREIGN KEY (picture_id) REFERENCES picture(id),
      FOREIGN KEY (category_id) REFERENCES category(id)

);

CREATE TABLE blog_user (
       id binary(16) PRIMARY KEY,
       blog_id binary(16),
       user_role_id binary(16),
       FOREIGN KEY (blog_id) REFERENCES blog(id),
       FOREIGN KEY (user_role_id) REFERENCES user_role(id)
);

ALTER TABLE blog
        ADD COLUMN blog_user_id binary(16),
        ADD COLUMN is_delete boolean default false,
        ADD FOREIGN KEY (blog_user_id) REFERENCES blog_user(id);

insert into category(id, name)
values
    (unhex(replace(uuid(), '-', '')),'sport'),
    (unhex(replace(uuid(), '-', '')),'film');

insert into blog(id, title,content, timestamps)
VALUES
    (unhex(replace(uuid(), '-', '')),'title1','content1', CURRENT_TIMESTAMP),
    (unhex(replace(uuid(), '-', '')),'title2','content2', CURRENT_TIMESTAMP);
insert into blog_user (id)
VALUES
    (unhex(replace(uuid(), '-', ''))),
    (unhex(replace(uuid(), '-', '')));



