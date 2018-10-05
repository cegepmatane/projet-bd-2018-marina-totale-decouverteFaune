--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)
-- Dumped by pg_dump version 10.4

-- Started on 2018-10-05 02:43:04

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
-- TOC entry 1 (class 3079 OID 13007)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16555)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: webmestre
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    notecommentaire double precision,
    coordgpscommentaire integer,
    urlimagecomm character varying(100),
    textecom character varying(100),
    idetreviant integer
);


ALTER TABLE public.commentaire OWNER TO webmestre;

--
-- TOC entry 198 (class 1259 OID 16553)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: webmestre
--

CREATE SEQUENCE public.commentaire_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO webmestre;

--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 198
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webmestre
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- TOC entry 197 (class 1259 OID 16547)
-- Name: etrevivant; Type: TABLE; Schema: public; Owner: webmestre
--

CREATE TABLE public.etrevivant (
    id integer NOT NULL,
    categorie character varying(50),
    urlwiki character varying(50),
    urlimage character varying(50),
    espece character varying(30)
);


ALTER TABLE public.etrevivant OWNER TO webmestre;

--
-- TOC entry 196 (class 1259 OID 16545)
-- Name: etrevivant_id_seq; Type: SEQUENCE; Schema: public; Owner: webmestre
--

CREATE SEQUENCE public.etrevivant_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.etrevivant_id_seq OWNER TO webmestre;

--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 196
-- Name: etrevivant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: webmestre
--

ALTER SEQUENCE public.etrevivant_id_seq OWNED BY public.etrevivant.id;


--
-- TOC entry 200 (class 1259 OID 16569)
-- Name: votes; Type: TABLE; Schema: public; Owner: webmestre
--

CREATE TABLE public.votes (
    id integer NOT NULL,
    idcommentaire integer,
    total_values double precision,
    total_votes integer
);


ALTER TABLE public.votes OWNER TO webmestre;

--
-- TOC entry 2763 (class 2604 OID 16558)
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: webmestre
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 2762 (class 2604 OID 16550)
-- Name: etrevivant id; Type: DEFAULT; Schema: public; Owner: webmestre
--

ALTER TABLE ONLY public.etrevivant ALTER COLUMN id SET DEFAULT nextval('public.etrevivant_id_seq'::regclass);


--
-- TOC entry 2895 (class 0 OID 16555)
-- Dependencies: 199
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: webmestre
--

COPY public.commentaire (id, notecommentaire, coordgpscommentaire, urlimagecomm, textecom, idetreviant) FROM stdin;
\.


--
-- TOC entry 2893 (class 0 OID 16547)
-- Dependencies: 197
-- Data for Name: etrevivant; Type: TABLE DATA; Schema: public; Owner: webmestre
--

COPY public.etrevivant (id, categorie, urlwiki, urlimage, espece) FROM stdin;
1	test	test	test	test
2	marin	test.com	test.com	dauphin
3	fdf	dfdf	dfdf	dfdf
\.


--
-- TOC entry 2896 (class 0 OID 16569)
-- Dependencies: 200
-- Data for Name: votes; Type: TABLE DATA; Schema: public; Owner: webmestre
--

COPY public.votes (id, idcommentaire, total_values, total_votes) FROM stdin;
\.


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 198
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webmestre
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 1, false);


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 196
-- Name: etrevivant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: webmestre
--

SELECT pg_catalog.setval('public.etrevivant_id_seq', 2, true);


--
-- TOC entry 2767 (class 2606 OID 16560)
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: webmestre
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 16552)
-- Name: etrevivant etrevivant_pkey; Type: CONSTRAINT; Schema: public; Owner: webmestre
--

ALTER TABLE ONLY public.etrevivant
    ADD CONSTRAINT etrevivant_pkey PRIMARY KEY (id);


--
-- TOC entry 2769 (class 2606 OID 16573)
-- Name: votes votes_pkey; Type: CONSTRAINT; Schema: public; Owner: webmestre
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT votes_pkey PRIMARY KEY (id);


--
-- TOC entry 2770 (class 2606 OID 16574)
-- Name: votes votes_idcommentaire_fkey; Type: FK CONSTRAINT; Schema: public; Owner: webmestre
--

ALTER TABLE ONLY public.votes
    ADD CONSTRAINT votes_idcommentaire_fkey FOREIGN KEY (idcommentaire) REFERENCES public.commentaire(id);


-- Completed on 2018-10-05 02:43:07

--
-- PostgreSQL database dump complete
--

