use db_farmacia;

insert into tb_categorias (tipo, descricao) values ("Anti-inflamatório", "Impede ou ameniza uma reação de inflamação.");
insert into tb_categorias (tipo, descricao) values ("Anti-histamínico", "Trata reações alérgicas reduzindo os sintomas.");
insert into tb_categorias (tipo, descricao) values ("Antidepressivo", "Trata a depressão e outros transtornos psicológicos.");
insert into tb_categorias (tipo, descricao) values ("Antitússico", "Trata e combate a tosse.");
insert into tb_categorias (tipo, descricao) values ("Antibiótico", "Elimina ou impede a multiplicação de bactérias");
insert into tb_categorias (tipo, descricao) values ("Analgésico", "Reduz ou alivia todos os tipos de dores.");

select * from tb_categorias;

insert into tb_produtos (nome, indicacao, quantidade, laboratorio, preco, foto, categoria_id)
values ("Dipirona","Indicado para dor e febre", 246, "Neo Química", 17.67, "https://imgur.com/jmgs94D", 6);
insert into tb_produtos (nome, indicacao, quantidade, laboratorio, preco, foto, categoria_id)
values ("Histamin", "Indicado para o alívio das complicações associadas a processos alérgicos e manifestações alérgicas de doenças respiratórias",
 129, "Neo Química", 10.99, "https://imgur.com/8QqRrw9", 2);
insert into tb_produtos (nome, indicacao, quantidade, laboratorio, preco, foto, categoria_id)
values ("Bisoltussin", "Indicado para o tratamento sintomático da tosse irritativa e seca.", 100, 
"Boehringer", 19.29, "https://imgur.com/vBvnY1f", 4);
insert into tb_produtos (nome, indicacao, quantidade, laboratorio, preco, foto, categoria_id)
values ("Loratadina", "indicado para o alívio dos sintomas associados a rinite alérgica", 320,
"Biosintética", 20.89, "https://imgur.com/yFNZZXv", 2);
insert into tb_produtos (nome, indicacao, quantidade, laboratorio, preco, foto, categoria_id)
values ("Ibuprofeno", "Indicado para febre e dores leves a moderadas, associadas a gripes e resfriados comuns",
280, "Geolab", 6.29, "https://imgur.com/4xsITGA", 6);
insert into tb_produtos (nome, indicacao, quantidade, laboratorio, preco, foto, categoria_id)
values ("Amoxicilina", "Indicado para tratamento de infecções bacterianas causadas por germes sensíveis à ação da amoxicilina.",
250, "Neo Química", 10.69, "https://imgur.com/mzMnEfF", 5);

select * from tb_produtos;