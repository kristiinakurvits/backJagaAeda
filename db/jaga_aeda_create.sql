-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA public CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA public
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-09 07:41:02.037

-- tables
-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          name varchar(255)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         e_mail varchar(255)  NOT NULL,
                         mobile varchar(255)  NULL,
                         first_name varchar(255)  NULL,
                         last_name varchar(255)  NULL,
                         user_id int  NULL,
                         CONSTRAINT contact_ak_1 UNIQUE (e_mail) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          contact_id int  NOT NULL,
                          region_id int  NOT NULL,
                          name varchar(255)  NOT NULL,
                          latitude decimal(8,6)  NULL,
                          longtitude decimal(8,6)  NULL,
                          address varchar(255)  NOT NULL,
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: measure_unit
CREATE TABLE measure_unit (
                              id serial  NOT NULL,
                              unit varchar(255)  NOT NULL,
                              CONSTRAINT measure_unit_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
                         id serial  NOT NULL,
                         status char(1)  NOT NULL,
                         date_time timestamp  NOT NULL,
                         CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         description varchar(510)  NULL,
                         quantity int  NOT NULL,
                         measure_unit_id int  NOT NULL,
                         is_active boolean  NOT NULL,
                         image_base64 bytea  NULL,
                         date_added date  NOT NULL,
                         status char(1)  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: product_category
CREATE TABLE product_category (
                                  id serial  NOT NULL,
                                  product_id int  NOT NULL,
                                  category_id int  NOT NULL,
                                  CONSTRAINT product_category_pk PRIMARY KEY (id)
);

-- Table: product_order
CREATE TABLE product_order (
                               id serial  NOT NULL,
                               order_id int  NOT NULL,
                               product_id int  NOT NULL,
                               CONSTRAINT product_order_pk PRIMARY KEY (id)
);

-- Table: region
CREATE TABLE region (
                        id serial  NOT NULL,
                        county varchar(255)  NOT NULL,
                        CONSTRAINT region_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        user_name varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        role_id int  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (user_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_order
CREATE TABLE user_order (
                            id serial  NOT NULL,
                            order_id int  NOT NULL,
                            product_user_id int  NOT NULL,
                            order_user_id int  NOT NULL,
                            CONSTRAINT user_order_pk PRIMARY KEY (id)
);

-- Table: user_product
CREATE TABLE user_product (
                              id serial  NOT NULL,
                              user_id int  NOT NULL,
                              product_id int  NOT NULL,
                              CONSTRAINT user_product_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_contact (table: location)
ALTER TABLE location ADD CONSTRAINT location_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_region (table: location)
ALTER TABLE location ADD CONSTRAINT location_region
    FOREIGN KEY (region_id)
        REFERENCES region (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_user_order (table: user_order)
ALTER TABLE user_order ADD CONSTRAINT order_user_order
    FOREIGN KEY (order_user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_measure_unit (table: product)
ALTER TABLE product ADD CONSTRAINT product_measure_unit
    FOREIGN KEY (measure_unit_id)
        REFERENCES measure_unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_order_order (table: product_order)
ALTER TABLE product_order ADD CONSTRAINT product_order_order
    FOREIGN KEY (order_id)
        REFERENCES "order" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_order_product (table: product_order)
ALTER TABLE product_order ADD CONSTRAINT product_order_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_user_order (table: user_order)
ALTER TABLE user_order ADD CONSTRAINT product_user_order
    FOREIGN KEY (product_user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: prodyct_category_category (table: product_category)
ALTER TABLE product_category ADD CONSTRAINT prodyct_category_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: prodyct_category_product (table: product_category)
ALTER TABLE product_category ADD CONSTRAINT prodyct_category_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_order_order (table: user_order)
ALTER TABLE user_order ADD CONSTRAINT user_order_order
    FOREIGN KEY (order_id)
        REFERENCES "order" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_product_product (table: user_product)
ALTER TABLE user_product ADD CONSTRAINT user_product_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_product_user (table: user_product)
ALTER TABLE user_product ADD CONSTRAINT user_product_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.