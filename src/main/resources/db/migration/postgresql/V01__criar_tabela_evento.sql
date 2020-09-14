CREATE SEQUENCE evento_seq START 1 INCREMENT 1;
CREATE TABLE evento(
    id BIGINT PRIMARY KEY DEFAULT nextval('evento_seq') NOT NULL,
    nome VARCHAR(50) NOT NULL,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    quantidade_pessoas INTEGER NOT NULL,
    descricao VARCHAR,
    imagem_path VARCHAR,
    categoria VARCHAR(30) NOT NULL,
    logradouro VARCHAR(50) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    estado VARCHAR(30) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    cep VARCHAR(10) NOT NULL
);

CREATE SEQUENCE imagem_seq START 1 INCREMENT 1;