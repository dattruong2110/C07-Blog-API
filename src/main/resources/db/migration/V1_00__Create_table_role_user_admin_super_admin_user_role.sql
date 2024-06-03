-- Create Role table
CREATE TABLE role (
                      id binary(16) PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      description VARCHAR(255)
);

-- Create User table
CREATE TABLE user (
                      id binary(16) PRIMARY KEY,
                      username VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      full_name VARCHAR(255),
                      avatar LONGTEXT
);

-- Create User-Role table
CREATE TABLE user_role (
                           id binary(16),
                           user_id binary(16),
                           role_id binary(16),
                           PRIMARY KEY (id),
                           FOREIGN KEY (user_id) REFERENCES user(id),
                           FOREIGN KEY (role_id) REFERENCES role(id)
);

insert into role(id, name, description)
values (unhex(replace(uuid(), '-', '')), 'ROLE_SUPER_ADMIN', 'Super Admin role'),
       (unhex(replace(uuid(), '-', '')), 'ROLE_ADMIN', 'Admin role'),
       (unhex(replace(uuid(), '-', '')), 'ROLE_USER', 'User role');
