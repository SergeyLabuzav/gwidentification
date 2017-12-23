CREATE TABLE image (
    PRIMARY KEY (id),
    id BIGINT NOT NULL IDENTITY(1,1),
    created DATETIME NOT NULL,
    description VARCHAR(255),
    path VARCHAR(255) NOT NULL
);