ALTER TABLE `user`
    ADD COLUMN `is_deleted` BOOLEAN NOT NULL DEFAULT FALSE;

INSERT INTO `user` (id, username, password, email, full_name, avatar, is_deleted)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'admin', 'admin', '123@gmail.com', 'admin', 'https://www.google.com', FALSE),
       (UNHEX(REPLACE(UUID(), '-', '')), 'user', 'user', '456@gmail.com', 'user', 'https://www.google.com', FALSE);
