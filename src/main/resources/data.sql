INSERT INTO login (id, ativo, data_atualizacao, data_criacao, senha, usuario) VALUES
('ef931612-7704-11eb-9439-0242ac130002', 
TRUE,
 '2019-05-05 18:00:00',
 '2019-05-05 18:00:00',
 '$2a$10$gWdzOgU4KwOyvqs40jxqyuhTCH2jhYoLFOY3/59IbftT22PnOJCtu',
 'filipececcon');


INSERT INTO cliente 
(id, ativo, data_atualizacao, data_criacao, email, nome, sobrenome, telefone)
 VALUES
(
'20658f54-7705-11eb-9439-0242ac130002', 
TRUE, 
'2019-05-05 18:00:00', 
'2019-05-05 18:00:00', 
'filipececcon@gmail.com',
'Filipe',
'Ceccon',
'999999999'
);

INSERT INTO conta_corrente
(id, ativo, data_atualizacao, data_criacao, saldo, cliente_id)
VALUES
('20658f54-7705-11eb-9439-0242ac130002',TRUE,'2019-05-05 18:00:00','2019-05-05 18:00:00',0,'20658f54-7705-11eb-9439-0242ac130002')