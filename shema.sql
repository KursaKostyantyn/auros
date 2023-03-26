create database testTask;
use testTask;
create table Knowledge_package
(
    id            int           not null primary key auto_increment,
    title         varchar(250)  not null,
    description   varchar(2000) not null,
    creation_date varchar(10)   not null

);
create table Knowledge_package_set
(
    id    int not null primary key auto_increment,
    title varchar(250)
);

create table Knowledge_package_Knowledge_package_set
(
    kPac_id    int not null,
    kPacSet_id int not null,
    primary key (kPac_id, kPacSet_id),
    foreign key (kPac_id) references knowledge_package (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    foreign key (kPacSet_id) references knowledge_package_set (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);