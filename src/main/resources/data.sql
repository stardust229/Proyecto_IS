insert into disciplina (nombre) values ('atletismo');
insert into disciplina (nombre) values ('natación');
insert into disciplina (nombre) values ('gimnasia');
insert into disciplina (nombre) values ('taekwondo');
insert into disciplina (nombre) values ('tiro con arco');

/* Ingresamos eventos */
insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Prueba combinada de atletismo que comprende diez pruebas (cuatro carreras, tres lanzamientos y tres saltos)','2022-06-20','Decatlón',1);
insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Prueba del atletismo que consiste en recorrer la máxima distancia posible en el plano horizontal a partir de un salto tras una carrera','2022-06-20','Salto de longitud',1);
insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Los 800 metros lisos u 800 metros planos es una prueba de medio fondo del actual atletismo en la que cada atleta corre por su respectiva calle durante los primeros 100 metros, pasando a partir de ese momento a la denominada calle libre','2022-06-22', 'Carrera 800 metros', 1);

insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Carrera de 400 metros usando la técnica de su preferencia','2022-06-23','400 metros estilo libre',2);
insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Carrera de 100 metros usando la técnica de mariposa','2022-06-23','100 metros mariposa',2);

insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Consiste en el uso de unas barras distantes del suelo como instrumento en el cual los gimnastas deben ejecutar sus rutinas artísticas','2022-06-26','Barras paralelas',3);

insert into evento (descripcion, fecha, nombre, disciplina_id) values ('Enfrentamiento en la categoría de 80kg','2022-06-26','Peso 80kg',4);

/*Registramos jueces */
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (110987875, 'Nathan', 'Boards', 'Lumbers', 'nlumbers0@merriam-webster.com', 'ssYdwN', 'Facultad de Ingeniería', 5, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (291855493, 'Kirsten', 'Iacobini', 'Whyler', 'kwhyler1@nba.com', 'RC8AQZj', 'Facultad de Ciencias', 5, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (256135624, 'Rori', 'Dast', 'Acklands', 'racklands2@163.com', 'yRZufgX', 'Facultad de Ciencias', 1, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (205709047, 'Laughton', 'Edgington', 'Landsbury', 'llandsbury3@instagram.com', 'bH7NqId6LGx', 'Facultad de Ciencias', 5, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (382465624, 'Susette', 'Maffini', 'McDowell', 'smcdowell4@godaddy.com', '0ZW95FiV', 'Facultad de Ingeniería', 2, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (262280074, 'Lorna', 'Chimenti', 'Earnshaw', 'learnshaw5@photobucket.com', 'uQvZBlTqUO', 'Facultad de Arquitectura', 5, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (175992478, 'Nikaniki', 'Hassewell', 'Guilloneau', 'nguilloneau6@apple.com', 'xRbpDDv', 'Facultad de Ingeniería', 5, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (337232921, 'Barton', 'O''Cannavan', 'Ingerman', 'bingerman7@theatlantic.com', 'wMaNZcv', 'Facultad de Ciencias', 5, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (158517005, 'Peri', 'Jurczyk', 'Dagleas', 'pdagleas8@wired.com', 'ggE7aoi', 'Facultad de Psicología', 4, true, 'JUEZ');
insert into juez (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (323773124, 'Adeline', 'Egdal', 'Hadingham', 'ahadingham9@deviantart.com', 'JzrAIolK6', 'Facultad de Filosofía', 5, true, 'JUEZ');

/* Registramos entrenadores */
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (373056603, 'Blanch', 'Greenalf', 'Willbond', 'bwillbond0@cocolog-nifty.com', 'AmnOrAG', 'Facultad de Artes y Diseño', 1, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (379642307, 'Gail', 'Horbart', 'McLeoid', 'gmcleoid1@miitbeian.gov.cn', '3edCXr', 'Facultad de Filosofía', 2, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (424499350, 'Alejandrina', 'Jaycock', 'Dannatt', 'adannatt2@nba.com', '7L5PGU6iGxf', 'Facultad de Medicina', 1, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (369876589, 'Mischa', 'Trahearn', 'Mosdall', 'mmosdall3@columbia.edu', 'I6imYtM92PW', 'Facultad de Medicina', 3, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (316836267, 'Oneida', 'Gow', 'Bollard', 'obollard4@opensource.org', 'lFIC7CNX8jNf', 'Facultad de Psicología', 4, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (142060818, 'Velvet', 'Robb', 'Monget', 'vmonget5@sitemeter.com', 'BaJ0btTJ', 'Facultad de Filosofía', 5, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (376715240, 'Cherida', 'Mickan', 'Conville', 'cconville6@earthlink.net', 'ak7ZaN6', 'Facultad de Medicina', 2, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (112199048, 'Dennet', 'Dubble', 'Brahmer', 'dbrahmer7@java.com', 'JspJzYLBvI5g', 'Facultad de Ciencias', 1, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (355857532, 'Grove', 'Colquite', 'Zuann', 'gzuann8@biglobe.ne.jp', 'xkHrIcM', 'Facultad de Ingeniería', 1, true, 'ENTRENADOR');
insert into entrenador (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol) values (189147366, 'Raul', 'Emmerson', 'Blazdell', 'rblazdell9@cnn.com', 'UG8qrL55', 'Facultad de Filosofía', 4, true, 'ENTRENADOR');

/* Competidores de disciplina 1: */
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (206752499, 'Colby', 'Frape', 'Elsdon', 'celsdon0@ox.ac.uk', 'iEwbkwYfut8l', 'Facultad de Medicina', 1, true, 'COMPETIDOR', 373056603);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (213631659, 'Stanly', 'Harman', 'Eatock', 'seatock1@discuz.net', 'io0JsGsjdvs9', 'Facultad de Artes y Diseño', 1, true, 'COMPETIDOR', 373056603);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (157492145, 'Florentia', 'Hulson', 'Pemble', 'fpemble2@google.co.jp', 'wNUrWASExCGG', 'Facultad de Ciencias', 1, true, 'COMPETIDOR', 373056603);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (390330054, 'Regina', 'Harsum', 'Enever', 'renever3@census.gov', 'MeBpdcKQ3l1E', 'Facultad de Psicología', 1, true, 'COMPETIDOR', 424499350);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (362209564, 'Eb', 'Valeri', 'Kellegher', 'ekellegher4@aboutads.info', 'lEVTInW93bQA', 'Facultad de Ciencias', 1, true, 'COMPETIDOR', 424499350);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (121624771, 'Savina', 'Batthew', 'Coils', 'scoils5@sogou.com', 'qK8EDwG', 'Facultad de Medicina', 1, true, 'COMPETIDOR', 424499350);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (110148057, 'Ogdan', 'Drydale', 'Loker', 'oloker6@shinystat.com', 'eEihxuz', 'Facultad de Artes y Diseño', 1, true, 'COMPETIDOR', 424499350);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (344549425, 'Bertine', 'Limb', 'Emblen', 'bemblen7@unblog.fr', 'qGY09f9LZVpi', 'Facultad de Ciencias', 1, true, 'COMPETIDOR', 112199048);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (206938205, 'Oralia', 'Roelvink', 'Burrel', 'oburrel8@europa.eu', 'dt2IrXldu', 'Facultad de Filosofía', 1, true, 'COMPETIDOR', 112199048);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (393128676, 'Dinny', 'Skillman', 'Panton', 'dpanton9@t-online.de', 'k3reGytKL', 'Facultad de Filosofía', 1, true, 'COMPETIDOR', 355857532);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (396788390, 'Garwin', 'Le Marquis', 'Balassi', 'gbalassia@flickr.com', 'ERZzpb', 'Facultad de Artes y Diseño', 1, true, 'COMPETIDOR', 355857532);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (191986762, 'Rickert', 'Shearstone', 'Havers', 'rhaversb@usatoday.com', 'sgPRY5pNtnwd', 'Facultad de Filosofía', 1, true, 'COMPETIDOR', 355857532);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (262704884, 'Fifi', 'Blune', 'Lifsey', 'flifseyc@theatlantic.com', 'pIpTOBeS', 'Facultad de Ciencias', 1, true, 'COMPETIDOR', 355857532);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (270851503, 'Harley', 'McIlwrath', 'Luckey', 'hluckeyd@microsoft.com', 'XzkraDJ7', 'Facultad de Medicina', 1, true, 'COMPETIDOR', 355857532);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (175611759, 'Emmery', 'Devil', 'Pavese', 'epavesee@a8.net', '0AbUFGVjPYGv', 'Facultad de Artes y Diseño', 1, true, 'COMPETIDOR', 355857532);

/* Competidores de disciplina 2: */
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (308191760, 'Stephanie', 'Jorger', 'Kleine', 'skleine0@nationalgeographic.com', 'ynd7rtxSt', 'Facultad de Medicina', 2, true, 'COMPETIDOR', 379642307);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (240480671, 'Cassandry', 'Gladbach', 'Nyland', 'cnyland1@msu.edu', 'Tj2R3338yS', 'Facultad de Filosofía', 2, true, 'COMPETIDOR', 379642307);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (105232613, 'Arlene', 'MacDermid', 'Checchetelli', 'achecchetelli2@cbslocal.com', 'rh5r5ww', 'Facultad de Psicología', 2, true, 'COMPETIDOR', 379642307);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (196586685, 'Annabella', 'Kohneke', 'Hartill', 'ahartill3@spiegel.de', 'c8vSovTksHBJ', 'Facultad de Psicología', 2, true, 'COMPETIDOR', 379642307);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (197105376, 'Janeczka', 'McLeary', 'Boole', 'jboole4@desdev.cn', '6tbIbCP1gI5w', 'Facultad de Psicología', 2, true, 'COMPETIDOR', 376715240);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (348854645, 'Jdavie', 'Eede', 'Willwood', 'jwillwood5@ebay.co.uk', 'dKGY3NJwK', 'Facultad de Filosofía', 2, true, 'COMPETIDOR', 376715240);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (375959877, 'Geno', 'Bearn', 'O''Hagirtie', 'gohagirtie6@time.com', '3tF3IJ', 'Facultad de Psicología', 2, true, 'COMPETIDOR', 376715240);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (280011531, 'Roxine', 'Mordan', 'Dabnor', 'rdabnor7@stanford.edu', '51KR1WR7n', 'Facultad de Ingeniería', 2, true, 'COMPETIDOR', 376715240);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (149425691, 'Kit', 'Allon', 'Frayne', 'kfrayne8@kickstarter.com', 'sENwEQWH', 'Facultad de Psicología', 2, true, 'COMPETIDOR', 376715240);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (208742015, 'Lorene', 'Vern', 'McPartling', 'lmcpartling9@51.la', 'nF66FQm4LD', 'Facultad de Ingeniería', 2, true, 'COMPETIDOR', 376715240);

/* Competidores de disciplina 3: */
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (252465249, 'Fields', 'Albro', 'Beagen', 'fbeagen0@yellowpages.com', 'ajgmRsr8qo', 'Facultad de Ciencias', 3, true, 'COMPETIDOR', 369876589);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (236990629, 'Edi', 'Martinon', 'Booker', 'ebooker1@howstuffworks.com', 'm74sjuC0hBhz', 'Facultad de Medicina', 3, true, 'COMPETIDOR', 369876589);

/* Competidores de disciplina 4: */
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (181213433, 'Jaye', 'Christophersen', 'Otham', 'jotham0@acquirethisname.com', 'Kj0Ce8Qqsx', 'Facultad de Psicología', 4, true, 'COMPETIDOR', 189147366);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (247814269, 'Alano', 'Waszczykowski', 'Dunn', 'adunn1@foxnews.com', 'cWxEtUucJ9V', 'Facultad de Ciencias', 4, true, 'COMPETIDOR', 189147366);
insert into competidor (num_cuenta, nombre, apellido_paterno, apellido_materno, correo, contrasenia, facultad, disciplina_id, enabled, rol, entrenador_num_cuenta) values (125780869, 'Marilin', 'Dory', 'Lamasna', 'mlamasna2@mozilla.com', 'I6p29E', 'Facultad de Medicina', 4, true, 'COMPETIDOR', 316836267);

/* Disciplina 5 no tiene competidores registrados */

/* Agregamos competidores a eventos: */
/* disciplina 1: */
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 206752499, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 206752499, 2);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 206752499, 3);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 213631659, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 213631659, 2);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 157492145, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 157492145, 3);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 390330054, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 390330054, 2);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 390330054, 3);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 362209564, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 362209564, 2);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 362209564, 3);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 121624771, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 121624771, 2);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 110148057, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 110148057, 2);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 344549425, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 206938205, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 393128676, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 396788390, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 191986762, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 262704884, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 270851503, 1);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 175611759, 1);

/* disciplina 2: */
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 308191760, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 240480671, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 105232613, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 196586685, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 197105376, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 348854645, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 348854645, 5);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 375959877, 4);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 375959877, 5);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 280011531, 5);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 149425691, 5);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 208742015, 5);

/* disciplina 3: */
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 252465249, 6);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 236990629, 6);

/* disciplina 4: */
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 181213433, 7);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 247814269, 7);
insert into competir (comentarios, puntaje, competidor_num_cuenta, evento_idevento) values ('-', null, 125780869, 7);



