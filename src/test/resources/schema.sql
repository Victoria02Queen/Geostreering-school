CREATE TABLE `role`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);
INSERT INTO `role` (name) VALUES
                            ('admin'),
                            ('listener');

CREATE TABLE `user`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255),
    position VARCHAR(255),
    organization VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255),
    login VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE SET NULL ON UPDATE CASCADE
);
INSERT INTO `user`(full_name, position, organization, phone, email, login, password, role_id) VALUES
                                                                                                ('Ivanov',
                                                                                                 'boss',
                                                                                                 'OOO IGIRGI',
                                                                                                 '89288763123',
                                                                                                 'akewd@mail.ru',
                                                                                                 'login1',
                                                                                                 '123',
                                                                                                 1),
                                                                                                (
                                                                                                    'Petrov',
                                                                                                    'worker',
                                                                                                    'OOO igirgi',
                                                                                                    '82998872',
                                                                                                    'hayev@mail.ru',
                                                                                                    'login2',
                                                                                                    '111',
                                                                                                    2);

CREATE TABLE `training`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description VARCHAR(255),
    trainer VARCHAR(255),
    count_place INT
);
INSERT INTO `training`(title, description, trainer, count_place) VALUES
                                                                   (
                                                                       'Геология суши',
                                                                       'Изучение суши',
                                                                       'Petrov Ivan',
                                                                       25
                                                                   ),
                                                                   ('Геология мест',
                                                                    'мест',
                                                                    'Igrin Ilia',
                                                                    40);
CREATE TABLE `test`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(80),
    training_id INT,
    FOREIGN KEY (training_id) REFERENCES training(id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `Test`(title, training_id) VALUES
    (
        'Геология суши',
        1
    );
CREATE TABLE `question`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(255),
    test_id INT,
    FOREIGN KEY (test_id) REFERENCES test(id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `question`(question, test_id) VALUES
                                            (
                                                'Какого цвета неба?',
                                                1
                                            ),
                                            (
                                                'Сколько углов в квадрате?',
                                                1
                                            );
CREATE TABLE `answer`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    correct BOOL,
    question_id INT,
    FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `answer`(title, correct, question_id) VALUES
                                                    ('Голубое',
                                                     true,
                                                     1
                                                    ),
                                                    (
                                                        'Серое',
                                                        false,
                                                        1
                                                    ),
                                                    (
                                                        'Розовое',
                                                        false,
                                                        1
                                                    ),
                                                    (
                                                        '2',
                                                        false,
                                                        2
                                                    ),
                                                    (
                                                        '4',
                                                        true,
                                                        2
                                                    ),
                                                    (
                                                        '1',
                                                        false,
                                                        2
                                                    );

CREATE TABLE `completed_training` (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    user_id INT,
                                    training_id INT,
                                    FOREIGN KEY (user_id) REFERENCES `user`(id) ON DELETE CASCADE ON UPDATE CASCADE,
                                    FOREIGN KEY (training_id) REFERENCES training(id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `completed_training` (user_id, training_id) VALUES
    (
        2,
        1
    );
CREATE TABLE `active_training` (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 user_id INT,
                                 training_id INT,
                                 FOREIGN KEY (user_id) REFERENCES `user`(id) ON DELETE CASCADE ON UPDATE CASCADE,
                                 FOREIGN KEY (training_id) REFERENCES training(id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `active_training` (user_id, training_id) VALUES
    (
        2,
        2
    );

