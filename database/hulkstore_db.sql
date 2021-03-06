PGDMP                 	        y            hulkstore_db    13.2    13.2      ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16394    hulkstore_db    DATABASE     h   CREATE DATABASE hulkstore_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE hulkstore_db;
                postgres    false            ?            1259    16397 	   inventory    TABLE     ?   CREATE TABLE public.inventory (
    idinventory integer NOT NULL,
    idproduct integer,
    code character varying(50),
    quantity numeric(50,0),
    provider character varying(100),
    date date,
    totalprice numeric(50,0),
    status boolean
);
    DROP TABLE public.inventory;
       public         heap    postgres    false            ?            1259    16395    inventory_idinventory_seq    SEQUENCE     ?   CREATE SEQUENCE public.inventory_idinventory_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.inventory_idinventory_seq;
       public          postgres    false    201            ?           0    0    inventory_idinventory_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.inventory_idinventory_seq OWNED BY public.inventory.idinventory;
          public          postgres    false    200            ?            1259    16407    product    TABLE     ?   CREATE TABLE public.product (
    idproduct integer NOT NULL,
    code character varying(50) NOT NULL,
    name character varying(100),
    unitprice numeric(50,0)
);
    DROP TABLE public.product;
       public         heap    postgres    false            ?            1259    16405    product_idproduct_seq    SEQUENCE     ?   CREATE SEQUENCE public.product_idproduct_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.product_idproduct_seq;
       public          postgres    false    203            ?           0    0    product_idproduct_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.product_idproduct_seq OWNED BY public.product.idproduct;
          public          postgres    false    202            ?            1259    16416    stock    TABLE     ?   CREATE TABLE public.stock (
    idstock integer NOT NULL,
    idproduct integer,
    code character varying(50),
    available integer,
    sold integer,
    purchased numeric(16,1)
);
    DROP TABLE public.stock;
       public         heap    postgres    false            ?            1259    16414    stock_idstock_seq    SEQUENCE     ?   CREATE SEQUENCE public.stock_idstock_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.stock_idstock_seq;
       public          postgres    false    205            ?           0    0    stock_idstock_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.stock_idstock_seq OWNED BY public.stock.idstock;
          public          postgres    false    204            .           2604    16400    inventory idinventory    DEFAULT     ~   ALTER TABLE ONLY public.inventory ALTER COLUMN idinventory SET DEFAULT nextval('public.inventory_idinventory_seq'::regclass);
 D   ALTER TABLE public.inventory ALTER COLUMN idinventory DROP DEFAULT;
       public          postgres    false    201    200    201            /           2604    16410    product idproduct    DEFAULT     v   ALTER TABLE ONLY public.product ALTER COLUMN idproduct SET DEFAULT nextval('public.product_idproduct_seq'::regclass);
 @   ALTER TABLE public.product ALTER COLUMN idproduct DROP DEFAULT;
       public          postgres    false    203    202    203            0           2604    16419    stock idstock    DEFAULT     n   ALTER TABLE ONLY public.stock ALTER COLUMN idstock SET DEFAULT nextval('public.stock_idstock_seq'::regclass);
 <   ALTER TABLE public.stock ALTER COLUMN idstock DROP DEFAULT;
       public          postgres    false    205    204    205            ?          0    16397 	   inventory 
   TABLE DATA           o   COPY public.inventory (idinventory, idproduct, code, quantity, provider, date, totalprice, status) FROM stdin;
    public          postgres    false    201   ?#       ?          0    16407    product 
   TABLE DATA           C   COPY public.product (idproduct, code, name, unitprice) FROM stdin;
    public          postgres    false    203   \$       ?          0    16416    stock 
   TABLE DATA           U   COPY public.stock (idstock, idproduct, code, available, sold, purchased) FROM stdin;
    public          postgres    false    205   ?$       ?           0    0    inventory_idinventory_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.inventory_idinventory_seq', 8, true);
          public          postgres    false    200            ?           0    0    product_idproduct_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.product_idproduct_seq', 10, true);
          public          postgres    false    202            ?           0    0    stock_idstock_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.stock_idstock_seq', 7, true);
          public          postgres    false    204            3           2606    16402    inventory pk_inventory 
   CONSTRAINT     ]   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT pk_inventory PRIMARY KEY (idinventory);
 @   ALTER TABLE ONLY public.inventory DROP CONSTRAINT pk_inventory;
       public            postgres    false    201            6           2606    16412    product pk_product 
   CONSTRAINT     ]   ALTER TABLE ONLY public.product
    ADD CONSTRAINT pk_product PRIMARY KEY (idproduct, code);
 <   ALTER TABLE ONLY public.product DROP CONSTRAINT pk_product;
       public            postgres    false    203    203            9           2606    16421    stock pk_stock 
   CONSTRAINT     Q   ALTER TABLE ONLY public.stock
    ADD CONSTRAINT pk_stock PRIMARY KEY (idstock);
 8   ALTER TABLE ONLY public.stock DROP CONSTRAINT pk_stock;
       public            postgres    false    205            1           1259    16403    inventory_pk    INDEX     P   CREATE UNIQUE INDEX inventory_pk ON public.inventory USING btree (idinventory);
     DROP INDEX public.inventory_pk;
       public            postgres    false    201            4           1259    16404    product_inventory_fk    INDEX     U   CREATE INDEX product_inventory_fk ON public.inventory USING btree (idproduct, code);
 (   DROP INDEX public.product_inventory_fk;
       public            postgres    false    201    201            7           1259    16413 
   product_pk    INDEX     P   CREATE UNIQUE INDEX product_pk ON public.product USING btree (idproduct, code);
    DROP INDEX public.product_pk;
       public            postgres    false    203    203            :           1259    16423    product_stock_fk    INDEX     M   CREATE INDEX product_stock_fk ON public.stock USING btree (idproduct, code);
 $   DROP INDEX public.product_stock_fk;
       public            postgres    false    205    205            ;           1259    16422    stock_pk    INDEX     D   CREATE UNIQUE INDEX stock_pk ON public.stock USING btree (idstock);
    DROP INDEX public.stock_pk;
       public            postgres    false    205            <           2606    16424 '   inventory fk_inventor_product_i_product    FK CONSTRAINT     ?   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT fk_inventor_product_i_product FOREIGN KEY (idproduct, code) REFERENCES public.product(idproduct, code) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Q   ALTER TABLE ONLY public.inventory DROP CONSTRAINT fk_inventor_product_i_product;
       public          postgres    false    2870    203    203    201    201            =           2606    16429     stock fk_stock_product_s_product    FK CONSTRAINT     ?   ALTER TABLE ONLY public.stock
    ADD CONSTRAINT fk_stock_product_s_product FOREIGN KEY (idproduct, code) REFERENCES public.product(idproduct, code) ON UPDATE RESTRICT ON DELETE RESTRICT;
 J   ALTER TABLE ONLY public.stock DROP CONSTRAINT fk_stock_product_s_product;
       public          postgres    false    203    205    203    2870    205            ?   |   x?3?4?t?642?4400??L?KI????4?b??L89???
L8M?B??E?%?yHJLQ???$???+??CUp?p?!??X??W	QRe
Vd?p?)?
#?
G?)1?X???? ??4      ?   B   x?3?tLJ6426?,I-.1?450?2?t??q:'?f??$r?q?s?q?yz?Y\1z\\\ ?<{      ?   8   x?3?4?tLJ6426?4??4?444 z\??f?ξ?@IN??)'H,F??? f	$     