--
-- PostgreSQL database dump
--

\restrict 43aCysyh3YihEvoqeyUfBm8JpEVZDWHA14sh0yJsQi7A5ngu0ca9BHcKVDperF5

-- Dumped from database version 18.1
-- Dumped by pg_dump version 18.1

-- Started on 2026-01-27 16:33:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 21003)
-- Name: prestamolibros; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA prestamolibros;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 225 (class 1259 OID 21027)
-- Name: asignatura; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.asignatura (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


--
-- TOC entry 224 (class 1259 OID 21026)
-- Name: asignatura_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.asignatura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5113 (class 0 OID 0)
-- Dependencies: 224
-- Name: asignatura_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.asignatura_id_seq OWNED BY prestamolibros.asignatura.id;


--
-- TOC entry 227 (class 1259 OID 21038)
-- Name: aula; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.aula (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


--
-- TOC entry 226 (class 1259 OID 21037)
-- Name: aula_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.aula_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5114 (class 0 OID 0)
-- Dependencies: 226
-- Name: aula_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.aula_id_seq OWNED BY prestamolibros.aula.id;


--
-- TOC entry 233 (class 1259 OID 21071)
-- Name: col_profe; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.col_profe (
    id integer NOT NULL,
    id_colegio integer NOT NULL,
    id_profesor integer NOT NULL
);


--
-- TOC entry 232 (class 1259 OID 21070)
-- Name: col_profe_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.col_profe_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5115 (class 0 OID 0)
-- Dependencies: 232
-- Name: col_profe_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.col_profe_id_seq OWNED BY prestamolibros.col_profe.id;


--
-- TOC entry 221 (class 1259 OID 21005)
-- Name: colegio; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.colegio (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


--
-- TOC entry 220 (class 1259 OID 21004)
-- Name: colegio_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.colegio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5116 (class 0 OID 0)
-- Dependencies: 220
-- Name: colegio_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.colegio_id_seq OWNED BY prestamolibros.colegio.id;


--
-- TOC entry 229 (class 1259 OID 21049)
-- Name: curso; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.curso (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


--
-- TOC entry 228 (class 1259 OID 21048)
-- Name: curso_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.curso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5117 (class 0 OID 0)
-- Dependencies: 228
-- Name: curso_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.curso_id_seq OWNED BY prestamolibros.curso.id;


--
-- TOC entry 239 (class 1259 OID 21141)
-- Name: detalle_prestamo; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.detalle_prestamo (
    id integer NOT NULL,
    id_libro integer NOT NULL,
    id_prestamo integer NOT NULL
);


--
-- TOC entry 238 (class 1259 OID 21140)
-- Name: detalle_prestamo_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.detalle_prestamo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5118 (class 0 OID 0)
-- Dependencies: 238
-- Name: detalle_prestamo_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.detalle_prestamo_id_seq OWNED BY prestamolibros.detalle_prestamo.id;


--
-- TOC entry 231 (class 1259 OID 21060)
-- Name: editorial; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.editorial (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


--
-- TOC entry 230 (class 1259 OID 21059)
-- Name: editorial_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.editorial_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5119 (class 0 OID 0)
-- Dependencies: 230
-- Name: editorial_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.editorial_id_seq OWNED BY prestamolibros.editorial.id;


--
-- TOC entry 235 (class 1259 OID 21091)
-- Name: libro; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.libro (
    id integer NOT NULL,
    nombre character varying NOT NULL,
    id_editorial integer NOT NULL
);


--
-- TOC entry 234 (class 1259 OID 21090)
-- Name: libro_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.libro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5120 (class 0 OID 0)
-- Dependencies: 234
-- Name: libro_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.libro_id_seq OWNED BY prestamolibros.libro.id;


--
-- TOC entry 237 (class 1259 OID 21108)
-- Name: prestamo_libro; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.prestamo_libro (
    id integer NOT NULL,
    id_colprofe integer NOT NULL,
    id_asignatura integer NOT NULL,
    id_aula integer NOT NULL,
    id_curso integer NOT NULL,
    fecha_prestamo date NOT NULL
);


--
-- TOC entry 236 (class 1259 OID 21107)
-- Name: prestamo_libro_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.prestamo_libro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5121 (class 0 OID 0)
-- Dependencies: 236
-- Name: prestamo_libro_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.prestamo_libro_id_seq OWNED BY prestamolibros.prestamo_libro.id;


--
-- TOC entry 223 (class 1259 OID 21016)
-- Name: profesor; Type: TABLE; Schema: prestamolibros; Owner: -
--

CREATE TABLE prestamolibros.profesor (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


--
-- TOC entry 222 (class 1259 OID 21015)
-- Name: profesor_id_seq; Type: SEQUENCE; Schema: prestamolibros; Owner: -
--

CREATE SEQUENCE prestamolibros.profesor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5122 (class 0 OID 0)
-- Dependencies: 222
-- Name: profesor_id_seq; Type: SEQUENCE OWNED BY; Schema: prestamolibros; Owner: -
--

ALTER SEQUENCE prestamolibros.profesor_id_seq OWNED BY prestamolibros.profesor.id;


--
-- TOC entry 4904 (class 2604 OID 21030)
-- Name: asignatura id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.asignatura ALTER COLUMN id SET DEFAULT nextval('prestamolibros.asignatura_id_seq'::regclass);


--
-- TOC entry 4905 (class 2604 OID 21041)
-- Name: aula id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.aula ALTER COLUMN id SET DEFAULT nextval('prestamolibros.aula_id_seq'::regclass);


--
-- TOC entry 4908 (class 2604 OID 21074)
-- Name: col_profe id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.col_profe ALTER COLUMN id SET DEFAULT nextval('prestamolibros.col_profe_id_seq'::regclass);


--
-- TOC entry 4902 (class 2604 OID 21008)
-- Name: colegio id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.colegio ALTER COLUMN id SET DEFAULT nextval('prestamolibros.colegio_id_seq'::regclass);


--
-- TOC entry 4906 (class 2604 OID 21052)
-- Name: curso id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.curso ALTER COLUMN id SET DEFAULT nextval('prestamolibros.curso_id_seq'::regclass);


--
-- TOC entry 4911 (class 2604 OID 21144)
-- Name: detalle_prestamo id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.detalle_prestamo ALTER COLUMN id SET DEFAULT nextval('prestamolibros.detalle_prestamo_id_seq'::regclass);


--
-- TOC entry 4907 (class 2604 OID 21063)
-- Name: editorial id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.editorial ALTER COLUMN id SET DEFAULT nextval('prestamolibros.editorial_id_seq'::regclass);


--
-- TOC entry 4909 (class 2604 OID 21094)
-- Name: libro id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.libro ALTER COLUMN id SET DEFAULT nextval('prestamolibros.libro_id_seq'::regclass);


--
-- TOC entry 4910 (class 2604 OID 21111)
-- Name: prestamo_libro id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.prestamo_libro ALTER COLUMN id SET DEFAULT nextval('prestamolibros.prestamo_libro_id_seq'::regclass);


--
-- TOC entry 4903 (class 2604 OID 21019)
-- Name: profesor id; Type: DEFAULT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.profesor ALTER COLUMN id SET DEFAULT nextval('prestamolibros.profesor_id_seq'::regclass);


--
-- TOC entry 5093 (class 0 OID 21027)
-- Dependencies: 225
-- Data for Name: asignatura; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.asignatura VALUES (1, 'Matematica');
INSERT INTO prestamolibros.asignatura VALUES (2, 'Matematica');
INSERT INTO prestamolibros.asignatura VALUES (3, 'Matematica');
INSERT INTO prestamolibros.asignatura VALUES (4, 'Matematica');


--
-- TOC entry 5095 (class 0 OID 21038)
-- Dependencies: 227
-- Data for Name: aula; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.aula VALUES (1, 'Aula A1 Editada');
INSERT INTO prestamolibros.aula VALUES (2, 'Aula A2');


--
-- TOC entry 5101 (class 0 OID 21071)
-- Dependencies: 233
-- Data for Name: col_profe; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.col_profe VALUES (1, 1, 1);
INSERT INTO prestamolibros.col_profe VALUES (2, 2, 2);


--
-- TOC entry 5089 (class 0 OID 21005)
-- Dependencies: 221
-- Data for Name: colegio; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.colegio VALUES (2, 'Colegio Nacional Asuncion');
INSERT INTO prestamolibros.colegio VALUES (1, 'Colegio Las Mercedes');
INSERT INTO prestamolibros.colegio VALUES (3, 'Colegio CEPSA');


--
-- TOC entry 5097 (class 0 OID 21049)
-- Dependencies: 229
-- Data for Name: curso; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.curso VALUES (1, '1er Grado');
INSERT INTO prestamolibros.curso VALUES (2, '2do Grado');


--
-- TOC entry 5107 (class 0 OID 21141)
-- Dependencies: 239
-- Data for Name: detalle_prestamo; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.detalle_prestamo VALUES (1, 9, 1);
INSERT INTO prestamolibros.detalle_prestamo VALUES (2, 10, 1);
INSERT INTO prestamolibros.detalle_prestamo VALUES (3, 11, 2);
INSERT INTO prestamolibros.detalle_prestamo VALUES (4, 12, 2);
INSERT INTO prestamolibros.detalle_prestamo VALUES (5, 9, 3);
INSERT INTO prestamolibros.detalle_prestamo VALUES (6, 10, 3);
INSERT INTO prestamolibros.detalle_prestamo VALUES (7, 1, 4);
INSERT INTO prestamolibros.detalle_prestamo VALUES (8, 2, 4);
INSERT INTO prestamolibros.detalle_prestamo VALUES (9, 1, 5);
INSERT INTO prestamolibros.detalle_prestamo VALUES (10, 2, 5);
INSERT INTO prestamolibros.detalle_prestamo VALUES (11, 1, 6);
INSERT INTO prestamolibros.detalle_prestamo VALUES (12, 2, 6);
INSERT INTO prestamolibros.detalle_prestamo VALUES (13, 1, 7);
INSERT INTO prestamolibros.detalle_prestamo VALUES (14, 2, 7);
INSERT INTO prestamolibros.detalle_prestamo VALUES (15, 1, 8);
INSERT INTO prestamolibros.detalle_prestamo VALUES (16, 2, 8);
INSERT INTO prestamolibros.detalle_prestamo VALUES (19, 1, 10);
INSERT INTO prestamolibros.detalle_prestamo VALUES (20, 2, 10);
INSERT INTO prestamolibros.detalle_prestamo VALUES (21, 1, 11);
INSERT INTO prestamolibros.detalle_prestamo VALUES (22, 2, 11);
INSERT INTO prestamolibros.detalle_prestamo VALUES (23, 1, 12);
INSERT INTO prestamolibros.detalle_prestamo VALUES (24, 2, 12);
INSERT INTO prestamolibros.detalle_prestamo VALUES (25, 1, 13);
INSERT INTO prestamolibros.detalle_prestamo VALUES (26, 2, 13);
INSERT INTO prestamolibros.detalle_prestamo VALUES (27, 1, 14);
INSERT INTO prestamolibros.detalle_prestamo VALUES (28, 2, 14);
INSERT INTO prestamolibros.detalle_prestamo VALUES (29, 1, 15);
INSERT INTO prestamolibros.detalle_prestamo VALUES (30, 2, 15);
INSERT INTO prestamolibros.detalle_prestamo VALUES (31, 1, 16);
INSERT INTO prestamolibros.detalle_prestamo VALUES (32, 2, 16);
INSERT INTO prestamolibros.detalle_prestamo VALUES (33, 1, 17);
INSERT INTO prestamolibros.detalle_prestamo VALUES (34, 2, 17);
INSERT INTO prestamolibros.detalle_prestamo VALUES (35, 1, 18);
INSERT INTO prestamolibros.detalle_prestamo VALUES (36, 2, 18);
INSERT INTO prestamolibros.detalle_prestamo VALUES (37, 1, 19);
INSERT INTO prestamolibros.detalle_prestamo VALUES (38, 2, 19);
INSERT INTO prestamolibros.detalle_prestamo VALUES (39, 1, 20);
INSERT INTO prestamolibros.detalle_prestamo VALUES (40, 2, 20);
INSERT INTO prestamolibros.detalle_prestamo VALUES (41, 1, 21);
INSERT INTO prestamolibros.detalle_prestamo VALUES (42, 2, 21);
INSERT INTO prestamolibros.detalle_prestamo VALUES (43, 1, 22);
INSERT INTO prestamolibros.detalle_prestamo VALUES (44, 2, 22);
INSERT INTO prestamolibros.detalle_prestamo VALUES (45, 1, 23);
INSERT INTO prestamolibros.detalle_prestamo VALUES (46, 2, 23);
INSERT INTO prestamolibros.detalle_prestamo VALUES (47, 1, 24);
INSERT INTO prestamolibros.detalle_prestamo VALUES (48, 2, 24);
INSERT INTO prestamolibros.detalle_prestamo VALUES (49, 1, 25);
INSERT INTO prestamolibros.detalle_prestamo VALUES (50, 2, 25);
INSERT INTO prestamolibros.detalle_prestamo VALUES (53, 1, 27);
INSERT INTO prestamolibros.detalle_prestamo VALUES (54, 2, 27);
INSERT INTO prestamolibros.detalle_prestamo VALUES (55, 1, 28);
INSERT INTO prestamolibros.detalle_prestamo VALUES (56, 2, 28);
INSERT INTO prestamolibros.detalle_prestamo VALUES (57, 1, 29);
INSERT INTO prestamolibros.detalle_prestamo VALUES (58, 2, 29);
INSERT INTO prestamolibros.detalle_prestamo VALUES (59, 1, 30);
INSERT INTO prestamolibros.detalle_prestamo VALUES (60, 2, 30);
INSERT INTO prestamolibros.detalle_prestamo VALUES (61, 1, 31);
INSERT INTO prestamolibros.detalle_prestamo VALUES (62, 2, 31);
INSERT INTO prestamolibros.detalle_prestamo VALUES (63, 1, 32);
INSERT INTO prestamolibros.detalle_prestamo VALUES (64, 2, 32);
INSERT INTO prestamolibros.detalle_prestamo VALUES (65, 1, 33);
INSERT INTO prestamolibros.detalle_prestamo VALUES (66, 2, 33);
INSERT INTO prestamolibros.detalle_prestamo VALUES (67, 1, 34);
INSERT INTO prestamolibros.detalle_prestamo VALUES (68, 2, 34);
INSERT INTO prestamolibros.detalle_prestamo VALUES (69, 1, 35);
INSERT INTO prestamolibros.detalle_prestamo VALUES (70, 2, 35);


--
-- TOC entry 5099 (class 0 OID 21060)
-- Dependencies: 231
-- Data for Name: editorial; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.editorial VALUES (1, 'Planeta');
INSERT INTO prestamolibros.editorial VALUES (6, 'Planeta');
INSERT INTO prestamolibros.editorial VALUES (7, 'Planeta');
INSERT INTO prestamolibros.editorial VALUES (8, 'Planeta');
INSERT INTO prestamolibros.editorial VALUES (9, 'Planeta');
INSERT INTO prestamolibros.editorial VALUES (5, 'Artes');
INSERT INTO prestamolibros.editorial VALUES (3, 'Matematica');
INSERT INTO prestamolibros.editorial VALUES (4, 'Filosofia');
INSERT INTO prestamolibros.editorial VALUES (2, 'Planeta (Editado)');
INSERT INTO prestamolibros.editorial VALUES (10, 'Comunicacion editado');
INSERT INTO prestamolibros.editorial VALUES (12, 'Psicologia inversa');
INSERT INTO prestamolibros.editorial VALUES (13, 'Biologia Marina');


--
-- TOC entry 5103 (class 0 OID 21091)
-- Dependencies: 235
-- Data for Name: libro; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.libro VALUES (2, 'El Quijote', 2);
INSERT INTO prestamolibros.libro VALUES (4, 'El Quijote', 4);
INSERT INTO prestamolibros.libro VALUES (5, 'El Quijote', 5);
INSERT INTO prestamolibros.libro VALUES (6, 'El Quijote', 6);
INSERT INTO prestamolibros.libro VALUES (7, 'El Quijote', 7);
INSERT INTO prestamolibros.libro VALUES (8, 'El Quijote', 8);
INSERT INTO prestamolibros.libro VALUES (9, 'Don Quijote', 9);
INSERT INTO prestamolibros.libro VALUES (10, 'El Principito', 9);
INSERT INTO prestamolibros.libro VALUES (11, 'Don Quijote', 10);
INSERT INTO prestamolibros.libro VALUES (12, 'El Principito', 10);
INSERT INTO prestamolibros.libro VALUES (28, 'Clean Code', 1);
INSERT INTO prestamolibros.libro VALUES (1, 'Clean Code Methods', 1);
INSERT INTO prestamolibros.libro VALUES (29, 'Matematica Aplicada a la Mecanica', 3);


--
-- TOC entry 5105 (class 0 OID 21108)
-- Dependencies: 237
-- Data for Name: prestamo_libro; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.prestamo_libro VALUES (1, 1, 3, 1, 1, '2026-01-20');
INSERT INTO prestamolibros.prestamo_libro VALUES (2, 2, 4, 2, 2, '2026-01-20');
INSERT INTO prestamolibros.prestamo_libro VALUES (3, 1, 1, 1, 1, '2026-01-20');
INSERT INTO prestamolibros.prestamo_libro VALUES (4, 1, 1, 1, 1, '2026-01-21');
INSERT INTO prestamolibros.prestamo_libro VALUES (5, 1, 1, 1, 1, '2026-01-21');
INSERT INTO prestamolibros.prestamo_libro VALUES (6, 1, 1, 1, 1, '2026-01-21');
INSERT INTO prestamolibros.prestamo_libro VALUES (7, 1, 1, 1, 1, '2026-01-21');
INSERT INTO prestamolibros.prestamo_libro VALUES (8, 1, 1, 1, 1, '2026-01-22');
INSERT INTO prestamolibros.prestamo_libro VALUES (10, 1, 1, 1, 1, '2026-01-22');
INSERT INTO prestamolibros.prestamo_libro VALUES (11, 1, 1, 1, 1, '2026-01-22');
INSERT INTO prestamolibros.prestamo_libro VALUES (12, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (13, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (14, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (15, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (16, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (17, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (18, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (19, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (20, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (21, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (22, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (23, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (24, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (25, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (27, 2, 2, 2, 2, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (28, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (29, 1, 1, 1, 1, '2026-01-23');
INSERT INTO prestamolibros.prestamo_libro VALUES (30, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (31, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (32, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (33, 1, 1, 1, 1, '2026-01-26');
INSERT INTO prestamolibros.prestamo_libro VALUES (34, 1, 1, 1, 1, '2026-01-27');
INSERT INTO prestamolibros.prestamo_libro VALUES (35, 1, 1, 1, 1, '2026-01-27');


--
-- TOC entry 5091 (class 0 OID 21016)
-- Dependencies: 223
-- Data for Name: profesor; Type: TABLE DATA; Schema: prestamolibros; Owner: -
--

INSERT INTO prestamolibros.profesor VALUES (1, 'Prof. Juan Perez');
INSERT INTO prestamolibros.profesor VALUES (2, 'Prof. Juan Perez');
INSERT INTO prestamolibros.profesor VALUES (3, 'Prof. Gilberto Gonzales');


--
-- TOC entry 5123 (class 0 OID 0)
-- Dependencies: 224
-- Name: asignatura_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.asignatura_id_seq', 5, true);


--
-- TOC entry 5124 (class 0 OID 0)
-- Dependencies: 226
-- Name: aula_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.aula_id_seq', 3, true);


--
-- TOC entry 5125 (class 0 OID 0)
-- Dependencies: 232
-- Name: col_profe_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.col_profe_id_seq', 3, true);


--
-- TOC entry 5126 (class 0 OID 0)
-- Dependencies: 220
-- Name: colegio_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.colegio_id_seq', 3, true);


--
-- TOC entry 5127 (class 0 OID 0)
-- Dependencies: 228
-- Name: curso_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.curso_id_seq', 3, true);


--
-- TOC entry 5128 (class 0 OID 0)
-- Dependencies: 238
-- Name: detalle_prestamo_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.detalle_prestamo_id_seq', 70, true);


--
-- TOC entry 5129 (class 0 OID 0)
-- Dependencies: 230
-- Name: editorial_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.editorial_id_seq', 13, true);


--
-- TOC entry 5130 (class 0 OID 0)
-- Dependencies: 234
-- Name: libro_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.libro_id_seq', 39, true);


--
-- TOC entry 5131 (class 0 OID 0)
-- Dependencies: 236
-- Name: prestamo_libro_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.prestamo_libro_id_seq', 35, true);


--
-- TOC entry 5132 (class 0 OID 0)
-- Dependencies: 222
-- Name: profesor_id_seq; Type: SEQUENCE SET; Schema: prestamolibros; Owner: -
--

SELECT pg_catalog.setval('prestamolibros.profesor_id_seq', 2, true);


--
-- TOC entry 4917 (class 2606 OID 21036)
-- Name: asignatura asignatura_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.asignatura
    ADD CONSTRAINT asignatura_pkey PRIMARY KEY (id);


--
-- TOC entry 4919 (class 2606 OID 21047)
-- Name: aula aula_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.aula
    ADD CONSTRAINT aula_pkey PRIMARY KEY (id);


--
-- TOC entry 4925 (class 2606 OID 21079)
-- Name: col_profe col_profe_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.col_profe
    ADD CONSTRAINT col_profe_pkey PRIMARY KEY (id);


--
-- TOC entry 4913 (class 2606 OID 21014)
-- Name: colegio colegio_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.colegio
    ADD CONSTRAINT colegio_pkey PRIMARY KEY (id);


--
-- TOC entry 4921 (class 2606 OID 21058)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id);


--
-- TOC entry 4931 (class 2606 OID 21149)
-- Name: detalle_prestamo detalle_prestamo_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.detalle_prestamo
    ADD CONSTRAINT detalle_prestamo_pkey PRIMARY KEY (id);


--
-- TOC entry 4923 (class 2606 OID 21069)
-- Name: editorial editorial_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.editorial
    ADD CONSTRAINT editorial_pkey PRIMARY KEY (id);


--
-- TOC entry 4927 (class 2606 OID 21101)
-- Name: libro libro_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id);


--
-- TOC entry 4929 (class 2606 OID 21119)
-- Name: prestamo_libro prestamo_libro_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.prestamo_libro
    ADD CONSTRAINT prestamo_libro_pkey PRIMARY KEY (id);


--
-- TOC entry 4915 (class 2606 OID 21025)
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (id);


--
-- TOC entry 4932 (class 2606 OID 21080)
-- Name: col_profe fk_colprofe_colegio; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.col_profe
    ADD CONSTRAINT fk_colprofe_colegio FOREIGN KEY (id_colegio) REFERENCES prestamolibros.colegio(id);


--
-- TOC entry 4933 (class 2606 OID 21085)
-- Name: col_profe fk_colprofe_profesor; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.col_profe
    ADD CONSTRAINT fk_colprofe_profesor FOREIGN KEY (id_profesor) REFERENCES prestamolibros.profesor(id);


--
-- TOC entry 4939 (class 2606 OID 21150)
-- Name: detalle_prestamo fk_detalle_libro; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.detalle_prestamo
    ADD CONSTRAINT fk_detalle_libro FOREIGN KEY (id_libro) REFERENCES prestamolibros.libro(id);


--
-- TOC entry 4940 (class 2606 OID 21155)
-- Name: detalle_prestamo fk_detalle_prestamo; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.detalle_prestamo
    ADD CONSTRAINT fk_detalle_prestamo FOREIGN KEY (id_prestamo) REFERENCES prestamolibros.prestamo_libro(id);


--
-- TOC entry 4934 (class 2606 OID 21102)
-- Name: libro fk_libro_editorial; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.libro
    ADD CONSTRAINT fk_libro_editorial FOREIGN KEY (id_editorial) REFERENCES prestamolibros.editorial(id);


--
-- TOC entry 4935 (class 2606 OID 21125)
-- Name: prestamo_libro fk_prestamo_asignatura; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.prestamo_libro
    ADD CONSTRAINT fk_prestamo_asignatura FOREIGN KEY (id_asignatura) REFERENCES prestamolibros.asignatura(id);


--
-- TOC entry 4936 (class 2606 OID 21130)
-- Name: prestamo_libro fk_prestamo_aula; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.prestamo_libro
    ADD CONSTRAINT fk_prestamo_aula FOREIGN KEY (id_aula) REFERENCES prestamolibros.aula(id);


--
-- TOC entry 4937 (class 2606 OID 21120)
-- Name: prestamo_libro fk_prestamo_colprofe; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.prestamo_libro
    ADD CONSTRAINT fk_prestamo_colprofe FOREIGN KEY (id_colprofe) REFERENCES prestamolibros.col_profe(id);


--
-- TOC entry 4938 (class 2606 OID 21135)
-- Name: prestamo_libro fk_prestamo_curso; Type: FK CONSTRAINT; Schema: prestamolibros; Owner: -
--

ALTER TABLE ONLY prestamolibros.prestamo_libro
    ADD CONSTRAINT fk_prestamo_curso FOREIGN KEY (id_curso) REFERENCES prestamolibros.curso(id);


-- Completed on 2026-01-27 16:33:46

--
-- PostgreSQL database dump complete
--

\unrestrict 43aCysyh3YihEvoqeyUfBm8JpEVZDWHA14sh0yJsQi7A5ngu0ca9BHcKVDperF5

