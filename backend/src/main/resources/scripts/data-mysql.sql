

insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) values (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, STR_TO_DATE('1-01-2016', '%c-%e-%Y'));
insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, STR_TO_DATE('1-01-2016', '%c-%e-%Y'));
insert into user (id, username, password, firstname, lastname, email, enabled, lastpasswordresetdate) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b2','-','')), 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, STR_TO_DATE('1-01-2016', '%c-%e-%Y'));

insert into authority (id, name) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), 'ROLE_USER');
insert into authority (id, name) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), 'ROLE_ADMIN');

insert into user_authority (user_id, authority_id) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')));
insert into user_authority (user_id, authority_id) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')));
insert into user_authority (user_id, authority_id) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')));
insert into user_authority (user_id, authority_id) VALUES (unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b2','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')));


insert into location( id , latitude , longitude, name ) values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), 44.4565, 45.355646, 'location1');
insert into location( id , latitude , longitude, name ) values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), 45.4565, 46.355646, 'location2');

insert into eventtype(id, name)  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), 'football');
insert into eventtype(id, name)  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), 'tennis');


insert into event( id, start_date , max_players_number  , id_owner, id_eventtype, id_location )  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), STR_TO_DATE('1-01-2016', '%c-%e-%Y'),4,unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')));
insert into event( id, start_date , max_players_number  , id_owner, id_eventtype, id_location )  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), STR_TO_DATE('1-02-2016', '%c-%e-%Y'),5,unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b2','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')));
insert into event( id, start_date , max_players_number  , id_owner, id_eventtype, id_location )  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b2','-','')), STR_TO_DATE('1-03-2016', '%c-%e-%Y'),14,unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')));


insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),2);
insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b1','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),10);
insert into user_event(id, id_joined_user ,id_event , guestsnumber )  values(unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b2','-','')), unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b0','-','')),unhex(replace('99a519f8-bcbd-11e7-b3e3-446d571533b2','-','')),3);

