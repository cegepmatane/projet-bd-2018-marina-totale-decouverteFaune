--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    notecommentaire double precision,
    coordgpscommentaire integer,
    urlimagecomm character varying(100),
    textecom character varying(100),
    idetreviant integer
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- Name: etrevivant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etrevivant (
    id integer NOT NULL,
    categorie character varying(50),
    urlwiki character varying(50),
    urlimage character varying(50),
    espece character varying(30)
);


ALTER TABLE public.etrevivant OWNER TO postgres;

--
-- Name: etrevivant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.etrevivant_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etrevivant_id_seq OWNER TO postgres;

--
-- Name: etrevivant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.etrevivant_id_seq OWNED BY public.etrevivant.id;


--
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- Name: etrevivant id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etrevivant ALTER COLUMN id SET DEFAULT nextval('public.etrevivant_id_seq'::regclass);


--
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, notecommentaire, coordgpscommentaire, urlimagecomm, textecom, idetreviant) FROM stdin;
\.


--
-- Data for Name: etrevivant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.etrevivant (id, categorie, urlwiki, urlimage, espece) FROM stdin;
\.


--
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 1, false);


--
-- Name: etrevivant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.etrevivant_id_seq', 1, false);


--
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- Name: etrevivant etrevivant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etrevivant
    ADD CONSTRAINT etrevivant_pkey PRIMARY KEY (id);


--
-- Name: TABLE commentaire; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.commentaire TO webmestre;


--
-- Name: TABLE etrevivant; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.etrevivant TO webmestre;


--
-- PostgreSQL database dump complete
--

