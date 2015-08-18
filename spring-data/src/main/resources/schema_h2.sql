create table message(id integer, message varchar(1024), recipient varchar(128));

insert into message values (1, 'Hello Ordina!', 'info@ordina.be');
insert into message values (2, 'Hello again, anybody there?', 'info@ordina.be');
insert into message values (3, 'Never mind...', 'info@ordina.be');

commit;