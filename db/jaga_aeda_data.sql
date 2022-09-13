INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'guest');

INSERT INTO public.user (id, user_name, password, role_id) VALUES (DEFAULT, 'kristiina', '123', 1);
INSERT INTO public.user (id, user_name, password, role_id) VALUES (DEFAULT, 'jaan', '123', 2);
INSERT INTO public.user (id, user_name, password, role_id) VALUES (DEFAULT, 'indrek', '123', 2);

INSERT INTO public.contact (id, e_mail, mobile, first_name, last_name, user_id) VALUES (DEFAULT, 'kristiinakurvits@gmail.com', '+37211111', 'Kristiina', 'Kurvits', 1);
INSERT INTO public.contact (id, e_mail, mobile, first_name, last_name, user_id) VALUES (DEFAULT, 'jaan.varts@gmail.com', '+37222222', 'Jaan', 'Varts', 2);
INSERT INTO public.contact (id, e_mail, mobile, first_name, last_name, user_id) VALUES (DEFAULT, 'indrek.turi@gmail.com', '+37233333', 'Indrek', 'Turi', 3);

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

INSERT INTO public.product (id, seller_user_id, category_id, location_id, name, description, quantity, measure_unit_id, is_active, image_base64, date_added, status) VALUES (DEFAULT, 2, 1, 2,'Vaarikas', 'Värsked', 4, 1, true, null, '2022-09-12', 'A');
INSERT INTO public.product (id, seller_user_id, category_id, location_id, name, description, quantity, measure_unit_id, is_active, image_base64, date_added, status) VALUES (DEFAULT, 2, 2, 2,'Maasikad', 'Värsked', 4, 1, true, null, '2022-09-08', 'A');
INSERT INTO public.product (id, seller_user_id, category_id, location_id, name, description, quantity, measure_unit_id, is_active, image_base64, date_added, status) VALUES (DEFAULT, 3, 2, 2,'Õunad', 'Hapud', 10, 5, true, null, '2022-09-07', 'B');
INSERT INTO public.product (id, seller_user_id, category_id, location_id, name, description, quantity, measure_unit_id, is_active, image_base64, date_added, status) VALUES (DEFAULT, 2, 1, 2,'Herned', 'Ussitanud', 15, 1, false, null, '2022-09-06', 'C');

INSERT INTO public.order (id, buyer_user_id, status, date_time) VALUES (DEFAULT, 2, 'P', '2022-09-08 15:32:25.000000');
INSERT INTO public.order (id, buyer_user_id, status, date_time) VALUES (DEFAULT, 2, 'C', '2022-09-08 15:32:49.000000');
INSERT INTO public.order (id, buyer_user_id, status, date_time) VALUES (DEFAULT, 2, 'F', '2022-09-08 15:32:50.000000');

INSERT INTO public.product_order (id, order_id, product_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.product_order (id, order_id, product_id) VALUES (DEFAULT, 2, 3);
INSERT INTO public.product_order (id, order_id, product_id) VALUES (DEFAULT, 2, 3);
