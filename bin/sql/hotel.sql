create database hotel;

-- Criação da tabela hotel.reservas
CREATE TABLE hotel.reservas (
    id VARCHAR(8) PRIMARY KEY NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    forma_pagamento VARCHAR(30) NOT NULL
);

-- Criação da tabela hotel.hospedes
CREATE TABLE hotel.hospedes (
    id_hospede VARCHAR(8) PRIMARY KEY NOT NULL,
    nome VARCHAR(35) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    nacionalidade VARCHAR(50) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    id_reserva VARCHAR(8) NOT NULL,
    FOREIGN KEY (id_reserva) REFERENCES hotel.reservas(id) ON DELETE CASCADE
);


-- Inserir valores na tabela RESERVAS
insert into hotel.reservas (id, data_entrada, data_saida, valor, forma_pagamento) 
values
('RES0001', '2024-02-22', '2024-02-25', 500.00, 'Cartão de Crédito'),
('RES0002', '2024-03-10', '2024-03-15', 800.00, 'Cartão de Débito'),
('RES0003', '2024-04-05', '2024-04-10', 600.00, 'Dinheiro');

-- Inserir valores na tabela HOSPEDES
insert into hotel.hospedes (id_hospede, nome, sobrenome, data_nascimento, nacionalidade, telefone, id_reserva) 
values
('HOS0001', 'João', 'Silva', '1990-05-15', 'Brasileira', '5551234567', 'RES0001'),
('HOS0002', 'Maria', 'Santos', '1985-08-20', 'Portuguesa', '5559876543', 'RES0002'),
('HOS0003', 'Pedro', 'Lima', '1978-11-10', 'Argentina', '5552223333', 'RES0003');