INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'kristiina', '123');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'jaan', '123');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'indrek', '123');

INSERT INTO public.contact (id, e_mail, mobile, first_name, last_name, user_id) VALUES (DEFAULT, 'kristiinakurvits@gmail.com', '+37211111', 'Kristiina', 'Kurvits', 1);
INSERT INTO public.contact (id, e_mail, mobile, first_name, last_name, user_id) VALUES (DEFAULT, 'jaan.varts@gmail.com', '+37222222', 'Jaan', 'Varts', 2);
INSERT INTO public.contact (id, e_mail, mobile, first_name, last_name, user_id) VALUES (DEFAULT, 'indrek.turi@gmail.com', '+37233333', 'Indrek', 'Turi', 3);

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'guest');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Juurviljad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Köögiviljad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Puuviljad');

INSERT INTO public.measure_unit (id, unit) VALUES (DEFAULT, 'kg');
INSERT INTO public.measure_unit (id, unit) VALUES (DEFAULT, 'g');
INSERT INTO public.measure_unit (id, unit) VALUES (DEFAULT, 'l');
INSERT INTO public.measure_unit (id, unit) VALUES (DEFAULT, 'ml');
INSERT INTO public.measure_unit (id, unit) VALUES (DEFAULT, 'tk');

INSERT INTO public.region (id, county) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.region (id, county) VALUES (DEFAULT, 'Tartumaa');
INSERT INTO public.region (id, county) VALUES (DEFAULT, 'Pärnumaa');

INSERT INTO public.location (id, contact_id, region_id, name, latitude, longtitude, address) VALUES (DEFAULT, 1, 1, 'Kodu', null, null, 'Tondi, Tallinn');
INSERT INTO public.location (id, contact_id, region_id, name, latitude, longtitude, address) VALUES (DEFAULT, 2, 2, 'Käbi talu', null, null, 'Talutee, Tartu');
INSERT INTO public.location (id, contact_id, region_id, name, latitude, longtitude, address) VALUES (DEFAULT, 3, 3, 'Tamme talu', null, null, 'Tammetee, Lihula');









