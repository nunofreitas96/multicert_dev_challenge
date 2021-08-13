--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-08-13 12:16:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16454)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    client_name character varying NOT NULL,
    client_nif character varying(9) NOT NULL,
    client_address character varying NOT NULL,
    phone_number character varying(9) NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16452)
-- Name: client _id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."client _id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."client _id_seq" OWNER TO postgres;

--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 201
-- Name: client _id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."client _id_seq" OWNED BY public.client.id;


--
-- TOC entry 2851 (class 2604 OID 16457)
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public."client _id_seq"'::regclass);


--
-- TOC entry 2989 (class 0 OID 16454)
-- Dependencies: 202
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (client_name, client_nif, client_address, phone_number, id) FROM stdin;
Ana	123456789	Uma morada	987654321	7
Nuno Freitas	456789123	A Minha Casa	654987321	8
\.


--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 201
-- Name: client _id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."client _id_seq"', 8, true);


--
-- TOC entry 2852 (class 2606 OID 16502)
-- Name: client check_nif_length; Type: CHECK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE public.client
    ADD CONSTRAINT check_nif_length CHECK ((length((client_nif)::text) >= 9)) NOT VALID;


--
-- TOC entry 2853 (class 2606 OID 16503)
-- Name: client check_phone_length; Type: CHECK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE public.client
    ADD CONSTRAINT check_phone_length CHECK ((length((phone_number)::text) >= 9)) NOT VALID;


--
-- TOC entry 2855 (class 2606 OID 16462)
-- Name: client client _pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT "client _pkey" PRIMARY KEY (id);


--
-- TOC entry 2857 (class 2606 OID 16484)
-- Name: client nif_not_null; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT nif_not_null UNIQUE (client_nif);


-- Completed on 2021-08-13 12:16:37

--
-- PostgreSQL database dump complete
--

