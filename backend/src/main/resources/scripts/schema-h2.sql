CREATE TABLE IF NOT EXISTS users(ID VARCHAR(36) PRIMARY KEY, userName VARCHAR(30), firstName VARCHAR(30), lastName VARCHAR(30), password VARCHAR(30));



CREATE TABLE IF NOT EXISTS user(id VARCHAR(36) PRIMARY KEY,
                                userName VARCHAR(100),
                                password VARCHAR(100),
                                firstName VARCHAR(100),
                                lastName VARCHAR(100),
                                email VARCHAR(30),
                                enabled boolean,
                                lastpasswordresetdate timestamp);

CREATE TABLE IF NOT EXISTS AUTHORITY(id VARCHAR(36) PRIMARY KEY,
                                name VARCHAR(100));

CREATE TABLE IF NOT EXISTS USER_AUTHORITY(user_id VARCHAR(36), FOREIGN KEY (USER_ID) REFERENCES public.user(ID),
                    authority_id VARCHAR(36), FOREIGN KEY (AUTHORITY_ID) REFERENCES public.AUTHORITY(ID),
                    primary key(user_id, authority_id));


CREATE TABLE IF NOT EXISTS location(id VARCHAR(36),
                                    latitude float,
                                    longitude float,
                                    name VARCHAR(100));




CREATE TABLE IF NOT EXISTS event(id VARCHAR(36) PRIMARY KEY,
                                start_date timestamp,
                                max_players_number int ,
                                id_owner VARCHAR(36), FOREIGN KEY (id_owner) REFERENCES public.user(ID) );



CREATE TABLE IF NOT EXISTS user_event(id VARCHAR(36) PRIMARY KEY,
                                id_joined_user VARCHAR(36), FOREIGN KEY (id_joined_user) REFERENCES public.user(ID) ,
                                id_event VARCHAR(36), FOREIGN KEY (id_event) REFERENCES public.event(ID),
                                guestsnumber int );


CREATE TABLE IF NOT EXISTS event_location(id VARCHAR(36) PRIMARY KEY,
                                id_event VARCHAR(36), FOREIGN KEY (id_event) REFERENCES public.event(ID) ,
                                id_location VARCHAR(36), FOREIGN KEY (id_location) REFERENCES public.location(ID));


