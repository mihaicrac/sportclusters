/*

INSERT INTO users VALUES (RANDOM_UUID(), 'unu', '1', '11', '1111');
INSERT INTO users VALUES (RANDOM_UUID(), 'doi', '2', '22', '2222');
INSERT INTO users VALUES (RANDOM_UUID(), 'trei', '3','33', '3333');
*/




insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) values ('99a519f8-bcbd-11e7-b3e3-446d571533b0', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, STR_TO_DATE('1-01-2016', '%c-%e-%Y'));
insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b1', 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, STR_TO_DATE('1-01-2016', '%c-%e-%Y'));
insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b2', 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, STR_TO_DATE('1-01-2016', '%c-%e-%Y'));

insert into authority (id, name) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b0', 'ROLE_USER');
insert into authority (id, name) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b1', 'ROLE_ADMIN');

insert into user_authority ( user_id, authority_id) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b0', '99a519f8-bcbd-11e7-b3e3-446d571533b0');
insert into user_authority ( user_id, authority_id) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b0', '99a519f8-bcbd-11e7-b3e3-446d571533b1');
insert into user_authority ( user_id, authority_id) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b1', '99a519f8-bcbd-11e7-b3e3-446d571533b1');
insert into user_authority ( user_id, authority_id) VALUES ('99a519f8-bcbd-11e7-b3e3-446d571533b2', '99a519f8-bcbd-11e7-b3e3-446d571533b1');


insert into location( id , latitude , longitude, name ) values('99a519f8-bcbd-11e7-b3e3-446d571533b0', 44.4565, 45.355646, 'location1');
insert into location( id , latitude , longitude, name ) values('99a519f8-bcbd-11e7-b3e3-446d571533b1', 45.4565, 46.355646, 'location2');


insert into event( id, start_date , max_players_number  , id_owner )  values('99a519f8-bcbd-11e7-b3e3-446d571533b0', STR_TO_DATE('1-01-2016', '%c-%e-%Y'),4,'99a519f8-bcbd-11e7-b3e3-446d571533b0');
insert into event( id, start_date , max_players_number  , id_owner )  values('99a519f8-bcbd-11e7-b3e3-446d571533b1', STR_TO_DATE('1-02-2016', '%c-%e-%Y'),5,'99a519f8-bcbd-11e7-b3e3-446d571533b2');
insert into event( id, start_date , max_players_number  , id_owner )  values('99a519f8-bcbd-11e7-b3e3-446d571533b2', STR_TO_DATE('1-03-2016', '%c-%e-%Y'),14,'99a519f8-bcbd-11e7-b3e3-446d571533b0');


insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values('99a519f8-bcbd-11e7-b3e3-446d571533b0', '99a519f8-bcbd-11e7-b3e3-446d571533b0','99a519f8-bcbd-11e7-b3e3-446d571533b0',2);
insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values('99a519f8-bcbd-11e7-b3e3-446d571533b1', '99a519f8-bcbd-11e7-b3e3-446d571533b1','99a519f8-bcbd-11e7-b3e3-446d571533b0',10);
insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values('99a519f8-bcbd-11e7-b3e3-446d571533b2', '99a519f8-bcbd-11e7-b3e3-446d571533b0','99a519f8-bcbd-11e7-b3e3-446d571533b2',3);



insert into event_location(id, id_event ,id_location)  values('99a519f8-bcbd-11e7-b3e3-446d571533b0', '99a519f8-bcbd-11e7-b3e3-446d571533b0','99a519f8-bcbd-11e7-b3e3-446d571533b0');
insert into event_location(id, id_event ,id_location)  values('99a519f8-bcbd-11e7-b3e3-446d571533b1', '99a519f8-bcbd-11e7-b3e3-446d571533b1','99a519f8-bcbd-11e7-b3e3-446d571533b0');













