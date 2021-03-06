PGDMP                 	        y            postgres    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13442    postgres    DATABASE     l   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3070                        2615    24663    bankapp    SCHEMA        CREATE SCHEMA bankapp;
    DROP SCHEMA bankapp;
                postgres    false            �            1255    32955    new_balance()    FUNCTION     }  CREATE FUNCTION bankapp.new_balance() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	-- check that new balance is above 0
	if new.ending_balace is null then
		raise exception 'new_balance cannot be null';
	end if;
	if new.ending_balance < 0 then
		raise exception 'cannot have a negative balance';
	end if;

	new.date := current_timestamp;
	return new;
end
$$;
 %   DROP FUNCTION bankapp.new_balance();
       bankapp          postgres    false    6            �            1259    32935    accounts    TABLE     m   CREATE TABLE bankapp.accounts (
    account_id integer NOT NULL,
    user_id integer,
    balance numeric
);
    DROP TABLE bankapp.accounts;
       bankapp         heap    postgres    false    6            �            1259    32945    transactions    TABLE     �   CREATE TABLE bankapp.transactions (
    account_id integer,
    user_id integer,
    transaction_id integer NOT NULL,
    transaction_type text,
    amount numeric,
    opening_balance numeric,
    ending_balance numeric
);
 !   DROP TABLE bankapp.transactions;
       bankapp         heap    postgres    false    6            �            1259    32943    transactions_transaction_id_seq    SEQUENCE     �   CREATE SEQUENCE bankapp.transactions_transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE bankapp.transactions_transaction_id_seq;
       bankapp          postgres    false    226    6                        0    0    transactions_transaction_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE bankapp.transactions_transaction_id_seq OWNED BY bankapp.transactions.transaction_id;
          bankapp          postgres    false    225            �            1259    32926    users    TABLE     �   CREATE TABLE bankapp.users (
    user_id integer NOT NULL,
    first_name text,
    last_name text,
    username text,
    pword text
);
    DROP TABLE bankapp.users;
       bankapp         heap    postgres    false    6            �            1259    32924    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE bankapp.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE bankapp.users_user_id_seq;
       bankapp          postgres    false    6    223                       0    0    users_user_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE bankapp.users_user_id_seq OWNED BY bankapp.users.user_id;
          bankapp          postgres    false    222            j           2604    32948    transactions transaction_id    DEFAULT     �   ALTER TABLE ONLY bankapp.transactions ALTER COLUMN transaction_id SET DEFAULT nextval('bankapp.transactions_transaction_id_seq'::regclass);
 K   ALTER TABLE bankapp.transactions ALTER COLUMN transaction_id DROP DEFAULT;
       bankapp          postgres    false    226    225    226            i           2604    32929    users user_id    DEFAULT     p   ALTER TABLE ONLY bankapp.users ALTER COLUMN user_id SET DEFAULT nextval('bankapp.users_user_id_seq'::regclass);
 =   ALTER TABLE bankapp.users ALTER COLUMN user_id DROP DEFAULT;
       bankapp          postgres    false    223    222    223            �          0    32935    accounts 
   TABLE DATA           A   COPY bankapp.accounts (account_id, user_id, balance) FROM stdin;
    bankapp          postgres    false    224            �          0    32945    transactions 
   TABLE DATA           �   COPY bankapp.transactions (account_id, user_id, transaction_id, transaction_type, amount, opening_balance, ending_balance) FROM stdin;
    bankapp          postgres    false    226            �          0    32926    users 
   TABLE DATA           Q   COPY bankapp.users (user_id, first_name, last_name, username, pword) FROM stdin;
    bankapp          postgres    false    223                       0    0    transactions_transaction_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('bankapp.transactions_transaction_id_seq', 1, false);
          bankapp          postgres    false    225                       0    0    users_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('bankapp.users_user_id_seq', 1, false);
          bankapp          postgres    false    222            n           2606    32942    accounts accounts_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY bankapp.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (account_id);
 A   ALTER TABLE ONLY bankapp.accounts DROP CONSTRAINT accounts_pkey;
       bankapp            postgres    false    224            p           2606    32953    transactions transactions_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY bankapp.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);
 I   ALTER TABLE ONLY bankapp.transactions DROP CONSTRAINT transactions_pkey;
       bankapp            postgres    false    226            l           2606    32934    users users_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY bankapp.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 ;   ALTER TABLE ONLY bankapp.users DROP CONSTRAINT users_pkey;
       bankapp            postgres    false    223            q           2620    32956    transactions new_balance    TRIGGER     u   CREATE TRIGGER new_balance AFTER INSERT ON bankapp.transactions FOR EACH ROW EXECUTE FUNCTION bankapp.new_balance();
 2   DROP TRIGGER new_balance ON bankapp.transactions;
       bankapp          postgres    false    227    226            �      x������ � �      �      x������ � �      �      x������ � �          �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13442    postgres    DATABASE     l   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3070                        2615    24663    bankapp    SCHEMA        CREATE SCHEMA bankapp;
    DROP SCHEMA bankapp;
                postgres    false            �            1255    32955    new_balance()    FUNCTION     }  CREATE FUNCTION bankapp.new_balance() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	-- check that new balance is above 0
	if new.ending_balace is null then
		raise exception 'new_balance cannot be null';
	end if;
	if new.ending_balance < 0 then
		raise exception 'cannot have a negative balance';
	end if;

	new.date := current_timestamp;
	return new;
end
$$;
 %   DROP FUNCTION bankapp.new_balance();
       bankapp          postgres    false    6            �            1259    32935    accounts    TABLE     m   CREATE TABLE bankapp.accounts (
    account_id integer NOT NULL,
    user_id integer,
    balance numeric
);
    DROP TABLE bankapp.accounts;
       bankapp         heap    postgres    false    6            �            1259    32945    transactions    TABLE     �   CREATE TABLE bankapp.transactions (
    account_id integer,
    user_id integer,
    transaction_id integer NOT NULL,
    transaction_type text,
    amount numeric,
    opening_balance numeric,
    ending_balance numeric
);
 !   DROP TABLE bankapp.transactions;
       bankapp         heap    postgres    false    6            �            1259    32943    transactions_transaction_id_seq    SEQUENCE     �   CREATE SEQUENCE bankapp.transactions_transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE bankapp.transactions_transaction_id_seq;
       bankapp          postgres    false    226    6                        0    0    transactions_transaction_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE bankapp.transactions_transaction_id_seq OWNED BY bankapp.transactions.transaction_id;
          bankapp          postgres    false    225            �            1259    32926    users    TABLE     �   CREATE TABLE bankapp.users (
    user_id integer NOT NULL,
    first_name text,
    last_name text,
    username text,
    pword text
);
    DROP TABLE bankapp.users;
       bankapp         heap    postgres    false    6            �            1259    32924    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE bankapp.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE bankapp.users_user_id_seq;
       bankapp          postgres    false    6    223                       0    0    users_user_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE bankapp.users_user_id_seq OWNED BY bankapp.users.user_id;
          bankapp          postgres    false    222            j           2604    32948    transactions transaction_id    DEFAULT     �   ALTER TABLE ONLY bankapp.transactions ALTER COLUMN transaction_id SET DEFAULT nextval('bankapp.transactions_transaction_id_seq'::regclass);
 K   ALTER TABLE bankapp.transactions ALTER COLUMN transaction_id DROP DEFAULT;
       bankapp          postgres    false    226    225    226            i           2604    32929    users user_id    DEFAULT     p   ALTER TABLE ONLY bankapp.users ALTER COLUMN user_id SET DEFAULT nextval('bankapp.users_user_id_seq'::regclass);
 =   ALTER TABLE bankapp.users ALTER COLUMN user_id DROP DEFAULT;
       bankapp          postgres    false    223    222    223            �          0    32935    accounts 
   TABLE DATA           A   COPY bankapp.accounts (account_id, user_id, balance) FROM stdin;
    bankapp          postgres    false    224   �       �          0    32945    transactions 
   TABLE DATA           �   COPY bankapp.transactions (account_id, user_id, transaction_id, transaction_type, amount, opening_balance, ending_balance) FROM stdin;
    bankapp          postgres    false    226           �          0    32926    users 
   TABLE DATA           Q   COPY bankapp.users (user_id, first_name, last_name, username, pword) FROM stdin;
    bankapp          postgres    false    223                      0    0    transactions_transaction_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('bankapp.transactions_transaction_id_seq', 1, false);
          bankapp          postgres    false    225                       0    0    users_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('bankapp.users_user_id_seq', 1, false);
          bankapp          postgres    false    222            n           2606    32942    accounts accounts_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY bankapp.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (account_id);
 A   ALTER TABLE ONLY bankapp.accounts DROP CONSTRAINT accounts_pkey;
       bankapp            postgres    false    224            p           2606    32953    transactions transactions_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY bankapp.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);
 I   ALTER TABLE ONLY bankapp.transactions DROP CONSTRAINT transactions_pkey;
       bankapp            postgres    false    226            l           2606    32934    users users_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY bankapp.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 ;   ALTER TABLE ONLY bankapp.users DROP CONSTRAINT users_pkey;
       bankapp            postgres    false    223            q           2620    32956    transactions new_balance    TRIGGER     u   CREATE TRIGGER new_balance AFTER INSERT ON bankapp.transactions FOR EACH ROW EXECUTE FUNCTION bankapp.new_balance();
 2   DROP TRIGGER new_balance ON bankapp.transactions;
       bankapp          postgres    false    227    226           