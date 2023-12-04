CREATE TABLE membros
(   id bigserial NOT NULL,
    idprojeto bigint NOT NULL,
    idpessoa bigint NOT NULL,
CONSTRAINT pk_membros PRIMARY KEY (id),
CONSTRAINT fk_membros_projeto FOREIGN KEY (idprojeto)
REFERENCES projeto (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa)
REFERENCES pessoa (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION);