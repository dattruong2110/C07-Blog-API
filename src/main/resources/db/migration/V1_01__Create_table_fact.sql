CREATE TABLE fact
(
    id         binary(16) PRIMARY KEY,
    content    TEXT,
    media      TEXT,
    timestamps DATETIME,
    likes      VARCHAR(5),
    comment    TEXT
)