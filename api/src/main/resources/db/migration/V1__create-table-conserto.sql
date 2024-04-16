CREATE TABLE conserto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_entrada VARCHAR(12) NOT NULL,
    data_saida VARCHAR(12),

    nome VARCHAR(100) NOT NULL,
    anos_experiencia INT NOT NULL,

    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano INT NOT NULL,

    PRIMARY KEY(id)
);