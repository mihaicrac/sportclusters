
/*
INSERT INTO users VALUES (RANDOM_UUID(), 'unu', '1', '11', '1111');
INSERT INTO users VALUES (RANDOM_UUID(), 'doi', '2', '22', '2222');
INSERT INTO users VALUES (RANDOM_UUID(), 'trei', '3','33', '3333');
*/

insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB0', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));
insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB1', 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB2', 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));

INSERT INTO authority (id, name) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB0', 'ROLE_USER');
INSERT INTO authority (id, name) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB1', 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB0', '2D1EBC5B7D2741979CF0E84451C5BBB0');
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB0', '2D1EBC5B7D2741979CF0E84451C5BBB1');
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB1', '2D1EBC5B7D2741979CF0E84451C5BBB1');
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES ('2D1EBC5B7D2741979CF0E84451C5BBB2', '2D1EBC5B7D2741979CF0E84451C5BBB1');


insert into location( id , latitude , longitude, name ) values('2D1EBC5B7D2741979CF0E84451C5BBB0', 44.4565, 45.355646, 'location1');
insert into location( id , latitude , longitude, name ) values('2D1EBC5B7D2741979CF0E84451C5BBB1', 45.4565, 46.355646, 'location2');

insert into eventtype(id, name)  values('2D1EBC5B7D2741979CF0E84451C5BBB0', 'football');
insert into eventtype(id, name)  values('2D1EBC5B7D2741979CF0E84451C5BBB1', 'tennis');


insert into event( id, start_date , max_players_number  , id_owner, id_eventtype, id_location )  values('2D1EBC5B7D2741979CF0E84451C5BBB0', PARSEDATETIME('01-01-2016','dd-MM-yyyy'),4,'2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB0');
insert into event( id, start_date , max_players_number  , id_owner, id_eventtype, id_location )  values('2D1EBC5B7D2741979CF0E84451C5BBB1', PARSEDATETIME('01-01-2016','dd-MM-yyyy'),5,'2D1EBC5B7D2741979CF0E84451C5BBB2','2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB0');
insert into event( id, start_date , max_players_number  , id_owner, id_eventtype, id_location )  values('2D1EBC5B7D2741979CF0E84451C5BBB2', PARSEDATETIME('01-02-2016','dd-MM-yyyy'),14,'2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB1','2D1EBC5B7D2741979CF0E84451C5BBB1');


insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values('2D1EBC5B7D2741979CF0E84451C5BBB0', '2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB0',2);
insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values('2D1EBC5B7D2741979CF0E84451C5BBB1', '2D1EBC5B7D2741979CF0E84451C5BBB1','2D1EBC5B7D2741979CF0E84451C5BBB0',10);
insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values('2D1EBC5B7D2741979CF0E84451C5BBB2', '2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB2',3);



insert into event_location(id, id_event ,id_location)  values('2D1EBC5B7D2741979CF0E84451C5BBB0', '2D1EBC5B7D2741979CF0E84451C5BBB0','2D1EBC5B7D2741979CF0E84451C5BBB0');
insert into event_location(id, id_event ,id_location)  values('2D1EBC5B7D2741979CF0E84451C5BBB1', '2D1EBC5B7D2741979CF0E84451C5BBB1','2D1EBC5B7D2741979CF0E84451C5BBB0');













