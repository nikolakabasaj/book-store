INSERT INTO rating (rating_num, star) VALUES (1, '*');
INSERT INTO rating (rating_num, star) VALUES (2, '**');
INSERT INTO rating (rating_num, star) VALUES (3, '***');
INSERT INTO rating (rating_num, star) VALUES (4, '****');
INSERT INTO rating (rating_num, star) VALUES (5, '*****');

INSERT INTO author (first_name, last_name) VALUES ('Josh', 'Long');
INSERT INTO author (first_name, last_name) VALUES ('Mark', 'Heckler');
INSERT INTO author (first_name, last_name) VALUES ('Greg', 'Turnquist');

INSERT INTO book (title, pages, rating_id, author_id) VALUES ('Reactive Spring', 484, 1, 1);
INSERT INTO book (title, pages, rating_id, author_id) VALUES ('Spring Boot Up & Running', 328, 2, 2);
INSERT INTO book (title, pages, rating_id, author_id) VALUES ('Hacking with Spring Boot 2.3', 392, 3, 3);
