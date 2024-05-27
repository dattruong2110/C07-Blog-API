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

insert into category(id, name)
values
    (unhex(replace(uuid(), '-', '')),"sport"),
    (unhex(replace(uuid(), '-', '')),"film");

