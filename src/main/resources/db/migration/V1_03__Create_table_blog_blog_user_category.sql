CREATE TABLE category (
                          id binary(16) PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE blog (
    id binary(16) PRIMARY KEY,
    title VARCHAR(255) NOT NULL ,
    content varchar(255) not null ,
    user varchar(255),
    category_id binary(16),
    foreign key (category_id) references category(id)
);
CREATE TABLE blog_user (
    id binary(16) PRIMARY KEY,
    blog_id binary(16),
    user_role_id binary(16),
    foreign key (blog_id) references blog(id),
    foreign key (user_role_id) references user_role(id)
);

insert into category(id, name)
values
    (unhex(replace(uuid(), '-', '')),'sport'),
    (unhex(replace(uuid(), '-', '')),'film');

insert into blog(id, title, content)
VALUES
    (unhex(replace(uuid(), '-', '')),'title1','content1'),
    (unhex(replace(uuid(), '-', '')),'title1','content1');

