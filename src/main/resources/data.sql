INSERT INTO professors (name) VALUES ('Juan Perez'), ('Maria Rodriguez'), ('Carlos Gomez'), ('Ana Martinez'), ('Luis Hernandez');

INSERT INTO courses (name, credits, professor_id) VALUES ('Introduccion a la Programacion', 4, 1);
INSERT INTO courses (name, credits, professor_id) VALUES ('Estructuras de Datos', 4, 1);
INSERT INTO courses (name, credits, professor_id) VALUES ('Anatomia Humana', 5, 2);
INSERT INTO courses (name, credits, professor_id) VALUES ('Fisiologia', 5, 2);
INSERT INTO courses (name, credits, professor_id) VALUES ('Derecho Penal', 3, 3);
INSERT INTO courses (name, credits, professor_id) VALUES ('Derecho Civil', 3, 3);
INSERT INTO courses (name, credits, professor_id) VALUES ('Dibujo Tecnico', 2, 4);
INSERT INTO courses (name, credits, professor_id) VALUES ('Historia del Arte', 3, 5);

INSERT INTO students (name, code, program) VALUES ('Laura Garcia', '2021102001', 'Ingenieria de Sistemas');
INSERT INTO students (name, code, program) VALUES ('Pedro Pascal', '2021102006', 'Ingenieria de Sistemas');
INSERT INTO students (name, code, program) VALUES ('Andres Lopez', '2021102002', 'Medicina');
INSERT INTO students (name, code, program) VALUES ('Sofia Torres', '2021102003', 'Derecho');
INSERT INTO students (name, code, program) VALUES ('David Ramirez', '2021102004', 'Arquitectura');
INSERT INTO students (name, code, program) VALUES ('Valentina Diaz', '2021102005', 'Diseno Grafico');
INSERT INTO students (name, code, program) VALUES ('Camila Velez', '2022102007', 'Medicina');

INSERT INTO students_courses (student_id, course_id) VALUES (1, 1), (1, 2); -- Laura (Sistemas) en 2 cursos de Sistemas
INSERT INTO students_courses (student_id, course_id) VALUES (2, 1); -- Pedro (Sistemas) en 1 curso de Sistemas
INSERT INTO students_courses (student_id, course_id) VALUES (3, 3), (3, 4); -- Andres (Medicina) en 2 cursos de Medicina
INSERT INTO students_courses (student_id, course_id) VALUES (4, 5), (4, 8); -- Sofia (Derecho) en Derecho Penal e Historia del Arte
INSERT INTO students_courses (student_id, course_id) VALUES (5, 7); -- David (Arquitectura) en Dibujo Tecnico
INSERT INTO students_courses (student_id, course_id) VALUES (6, 8); -- Valentina (Diseño) en Historia del Arte
INSERT INTO students_courses (student_id, course_id) VALUES (7, 3); -- Camila (Medicina) en Anatomia

-- Roles
INSERT INTO roles (name) VALUES ( 'ROLE_STUDENT'), ( 'ROLE_PROFESSOR');

-- Permissions
INSERT INTO permissions (name) VALUES ('VIEW_COURSES'), ( 'VIEW_OWN_COURSES'), ( 'EDIT_COURSES'), ( 'VIEW_STUDENTS');

-- Users
INSERT INTO users (username, password) VALUES ( 'estudiante1@gmail.com', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506'), ( 'profesor1@gmail.com', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506');

-- User-Roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1), (2, 2);

-- Role-Permissions
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 2);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 1), (2, 3), (2, 4);

-- ==============================================
-- AUTORES Y LIBROS
-- ==============================================

-- Autores
INSERT INTO authors (name, nationality) VALUES
                                            ('Gabriel Garcia Marquez', 'Colombiana'),
                                            ('Isabel Allende', 'Chilena'),
                                            ('Haruki Murakami', 'Japonesa'),
                                            ('Jane Austen', 'Británica'),
                                            ('George Orwell', 'Británica');

-- Libros de Gabriel Garcia Marquez (author_id = 1)
INSERT INTO books (title, publication_year, genre, author_id) VALUES
                                                                  ('Cien años de soledad', 1967, 'Realismo mágico', 1),
                                                                  ('El amor en los tiempos del cólera', 1985, 'Romance', 1),
                                                                  ('Crónica de una muerte anunciada', 1981, 'Novela corta', 1),
                                                                  ('El coronel no tiene quien le escriba', 1961, 'Ficción', 1),
                                                                  ('Del amor y otros demonios', 1994, 'Ficción', 1);

-- Libros de Isabel Allende (author_id = 2)
INSERT INTO books (title, publication_year, genre, author_id) VALUES
                                                                  ('La casa de los espíritus', 1982, 'Realismo mágico', 2),
                                                                  ('De amor y de sombra', 1984, 'Drama', 2),
                                                                  ('Eva Luna', 1987, 'Narrativa', 2),
                                                                  ('Paula', 1994, 'Memorias', 2),
                                                                  ('Inés del alma mía', 2006, 'Histórica', 2);

-- Libros de Haruki Murakami (author_id = 3)
INSERT INTO books (title, publication_year, genre, author_id) VALUES
                                                                  ('Tokio Blues (Norwegian Wood)', 1987, 'Ficción contemporánea', 3),
                                                                  ('Kafka en la orilla', 2002, 'Fantasía', 3),
                                                                  ('1Q84', 2009, 'Distopía', 3),
                                                                  ('Crónica del pájaro que da cuerda al mundo', 1994, 'Ficción surrealista', 3),
                                                                  ('Hombres sin mujeres', 2014, 'Cuentos', 3);

-- Libros de Jane Austen (author_id = 4)
INSERT INTO books (title, publication_year, genre, author_id) VALUES
                                                                  ('Orgullo y prejuicio', 1813, 'Romance', 4),
                                                                  ('Sentido y sensibilidad', 1811, 'Romance', 4),
                                                                  ('Emma', 1815, 'Comedia romántica', 4),
                                                                  ('Persuasión', 1817, 'Romance', 4),
                                                                  ('Mansfield Park', 1814, 'Drama social', 4);

-- Libros de George Orwell (author_id = 5)
INSERT INTO books (title, publication_year, genre, author_id) VALUES
                                                                  ('1984', 1949, 'Distopía', 5),
                                                                  ('Rebelión en la granja', 1945, 'Sátira política', 5),
                                                                  ('Homenaje a Cataluña', 1938, 'Memorias', 5),
                                                                  ('Sin blanca en París y Londres', 1933, 'Autobiografía', 5),
                                                                  ('Los días de Birmania', 1934, 'Ficción histórica', 5);
