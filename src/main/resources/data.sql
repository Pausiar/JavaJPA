-- Insertar Països
INSERT INTO pais (nom) VALUES ('Espanya');
INSERT INTO pais (nom) VALUES ('França');
INSERT INTO pais (nom) VALUES ('Itàlia');

-- Insertar Províncies (amb relació a País)
-- Espanya (id=1)
INSERT INTO provincia (nom, pais_id) VALUES ('Barcelona', 1);
INSERT INTO provincia (nom, pais_id) VALUES ('València', 1);
INSERT INTO provincia (nom, pais_id) VALUES ('Madrid', 1);
INSERT INTO provincia (nom, pais_id) VALUES ('Alacant', 1);

-- França (id=2)
INSERT INTO provincia (nom, pais_id) VALUES ('Île-de-France', 2);
INSERT INTO provincia (nom, pais_id) VALUES ('Provence-Alpes-Côte d''Azur', 2);

-- Itàlia (id=3)
INSERT INTO provincia (nom, pais_id) VALUES ('Lazio', 3);
INSERT INTO provincia (nom, pais_id) VALUES ('Lombardia', 3);

-- Insertar Ciutats (amb relació a Província)
-- Barcelona (id=1)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Barcelona', 1620343, 'Capital de Catalunya', '/img/barcelona.jpg', 1);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Hospitalet de Llobregat', 264923, 'Segona ciutat de Catalunya', '/img/hospitalet.jpg', 1);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Badalona', 223166, 'Ciutat costanera', '/img/badalona.jpg', 1);

-- València (id=2)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('València', 791413, 'Capital del País Valencià', '/img/valencia.jpg', 2);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Torrent', 83193, 'Ciutat de l''Horta Sud', '/img/torrent.jpg', 2);

-- Madrid (id=3)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Madrid', 3223334, 'Capital d''Espanya', '/img/madrid.jpg', 3);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Alcalá de Henares', 195649, 'Ciutat Patrimoni de la Humanitat', '/img/alcala.jpg', 3);

-- Alacant (id=4)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Alacant', 337304, 'Capital de la Costa Blanca', '/img/alacant.jpg', 4);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Elx', 233058, 'Ciutat del Palmerar', '/img/elx.jpg', 4);

-- Île-de-France (id=5)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('París', 2161000, 'Capital de França', '/img/paris.jpg', 5);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Versailles', 85205, 'Ciutat del Palau', '/img/versailles.jpg', 5);

-- Provence-Alpes-Côte d'Azur (id=6)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Marsella', 870018, 'Ciutat portuària', '/img/marsella.jpg', 6);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Niça', 342637, 'Ciutat de la Costa Blava', '/img/nica.jpg', 6);

-- Lazio (id=7)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Roma', 2872800, 'Capital d''Itàlia', '/img/roma.jpg', 7);

-- Lombardia (id=8)
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Milà', 1378689, 'Capital de la moda', '/img/mila.jpg', 8);
INSERT INTO ciutat (nom, poblacio, descripcio, imatge, provincia_id) VALUES ('Bèrgam', 121639, 'Ciutat alta', '/img/bergam.jpg', 8);

-- Insertar Festes i Events
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('La Mercè', 'Festa major de Barcelona amb correfocs, castells i concerts', 'merce.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('Falles', 'Festa tradicional valenciana amb monuments de falla i mascletàs', 'falles.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('San Fermín', 'Festes de Pamplona famoses pels encierros', 'sanfermin.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('Tomatina', 'Batalla de tomàquets a Bunyol', 'tomatina.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('Carnaval de Venècia', 'Carnaval famós per les màscares i disfresses', 'carnaval_venecia.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('Festa de la Vendimia', 'Celebració de la collita del raïm', 'vendimia.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('Sant Joan', 'Revetlla amb fogueres i petards', 'santjoan.jpg');
INSERT INTO festes_events (nom, descripcio, imatge) VALUES ('Oktoberfest', 'Festival de la cervesa', 'oktoberfest.jpg');

