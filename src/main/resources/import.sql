INSERT into pascalbardeau."public".authority (name) VALUES ('ROLE_UTILISATEUR');
INSERT into "public"."user" ( email, password, username) VALUES ('bardeaupascal@gmail.com','password','pascal');
INSERT into "public".user_authority (user_id, authority_id) VALUES (1,1);