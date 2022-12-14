
create table divisions
(
    divisions_id    serial not null,
    correction_date timestamp(6),
    creation_date   timestamp(6),
    dt_from         timestamp(6),
    dt_till         timestamp(6),
    in_system       boolean,
    divisions_name  varchar(255),
    sort_priority   integer,
    parent_id       integer,
    primary key (divisions_id)
);

alter table if exists divisions
    add constraint FK_PARENT_ID foreign key (parent_id) references divisions on delete cascade