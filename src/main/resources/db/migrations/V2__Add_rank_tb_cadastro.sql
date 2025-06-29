-- V2: Migrations para Adicionar a coluna de RANK na Tabela de Cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
