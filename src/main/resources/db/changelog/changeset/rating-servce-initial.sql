create table ratings
(
    id         serial    primary key,
    rating     int          not null,
    comment    varchar(255) not null,
    author     varchar(255) not null,
    post_id    serial       not null,
    created_at timestamp    not null
);

ALTER TABLE ratings
    ADD CONSTRAINT fk_ratings_author FOREIGN KEY (author) REFERENCES users (username);

ALTER TABLE ratings
    ADD CONSTRAINT fk_ratings_post FOREIGN KEY (post_id) REFERENCES posts (id);