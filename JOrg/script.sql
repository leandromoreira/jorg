--/////////////////////////////////////////////////////
-- create the container structure
--/////////////////////////////////////////////////////

create table container(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
description VARCHAR(400),
id_pai INTEGER,
insert_date DATE,
CONSTRAINT fk_container  FOREIGN KEY (id_pai)  REFERENCES container (id)
);
create index container_description on container(description);

--/////////////////////////////////////////////////////
-- create the unit structure
--/////////////////////////////////////////////////////

create table unit(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
name VARCHAR(400),
rented_to VARCHAR(400),
rented_date DATE,
capacity DOUBLE,
id_container INTEGER,
type VARCHAR(30),
creation_date DATE,
keywords VARCHAR(800),
CONSTRAINT fk_unit  FOREIGN KEY (id_container)  REFERENCES container (id)
);
create index unit_name on unit(name);
create index unit_keyword on unit(keywords);

--/////////////////////////////////////////////////////
-- create the file structure
--/////////////////////////////////////////////////////

create table file(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
name VARCHAR(500),
path VARCHAR(500),
size DOUBLE,
id_unit INTEGER,
extension VARCHAR(20),
size_in_bytes BIGINT,
time_last_modified TIME,
date_last_modified DATE
);
create index file_name on file(name);
create index file_path on file(path);

--/////////////////////////////////////////////////////
-- create the word structure
--/////////////////////////////////////////////////////

create table word(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
name VARCHAR(500) not null
);
create UNIQUE index word_index on word(name);

--/////////////////////////////////////////////////////
-- create the word_weight structure
--/////////////////////////////////////////////////////

create table word_weight(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
word_id INTEGER NOT NULL,
file_id INTEGER NOT NULL,
frequence INTEGER NOT NULL,
CONSTRAINT fk_ww_word  FOREIGN KEY (word_id)  REFERENCES word(id),
CONSTRAINT fk_ww_file  FOREIGN KEY (file_id)  REFERENCES file(id)
);
create index word_freq on word_weight(frequence);

