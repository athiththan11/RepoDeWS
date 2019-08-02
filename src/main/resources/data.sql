-- add developers
INSERT INTO DEVELOPER (username, name, email) VALUES ('athiththan11', 'Athiththan', 'athiththan@demo.com');
INSERT INTO DEVELOPER (username, name, email) VALUES ('combatOstrich', 'Combat Ostrich', 'ostrich@combat.com');
INSERT INTO DEVELOPER (username, name, email) VALUES ('crudestVoyage', 'Crudest Voyage', 'crudest@demo.com');

-- add repos
INSERT INTO REPO (name, username, forks) VALUES ('stackcheats', 'athiththan11', 0);
INSERT INTO REPO (name, username, forks) VALUES ('event-handler-archetype', 'athiththan11', 1);
INSERT INTO REPO (name, username, forks) VALUES ('angular-locus', 'athiththan11', 0);