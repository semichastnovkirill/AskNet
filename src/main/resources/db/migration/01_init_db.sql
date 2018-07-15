CREATE TABLE supported_data_type (
  id                  CHARACTER VARYING NOT NULL,     --
  name                CHARACTER VARYING NOT NULL,            --
  PRIMARY KEY (id)
);

CREATE TABLE supported_view (
  id                       CHARACTER VARYING NOT NULL,     --
  name                     CHARACTER VARYING NOT NULL,            --
  grouping                 CHARACTER VARYING NOT NULL,            --
  default_use              BOOLEAN NOT NULL DEFAULT FALSE,        --
  PRIMARY KEY (id)
);

CREATE TABLE supported_view_cfg (
  id                       BIGINT AUTO_INCREMENT NOT NULL,     --
  code                     CHARACTER VARYING NOT NULL,            --
  title                    CHARACTER VARYING NOT NULL,            --
  desc                     CHARACTER VARYING,            --
  required                 BOOLEAN NOT NULL DEFAULT FALSE,        --
  id_data_type             CHARACTER VARYING NOT NULL,        --
  id_view                  CHARACTER VARYING NOT NULL,        --
  PRIMARY KEY (id)
);

INSERT INTO supported_data_type (id, name) VALUES ('string', 'Строка');
INSERT INTO supported_data_type (id, name) VALUES ('int', 'Целое число');
INSERT INTO supported_data_type (id, name) VALUES ('date', 'Дата');
INSERT INTO supported_data_type (id, name) VALUES ('list', 'Список');
INSERT INTO supported_data_type (id, name) VALUES ('file', 'Файл');
INSERT INTO supported_data_type (id, name) VALUES ('object', 'Объект');

INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('string', 'string', 'Строка', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('int', 'int', 'Целое число', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('date', 'date', 'Дата', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('list', 'list', 'Список', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('file', 'file', 'Файл', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('object', 'object', 'Объект', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('button', 'button', 'Кнопка', TRUE);
INSERT INTO supported_view (id, grouping, name, default_use) VALUES ('reestr', 'reestr', 'Реестр', TRUE);

INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('view_add', 'View Add', 'string', 'reestr');
INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('view_edit', 'View Edit', 'string', 'reestr');
INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('id_data', 'ID Data', 'string', 'reestr');
INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('table_header', 'Table Header', 'string', 'reestr');
INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('table_data', 'Table Data', 'string', 'reestr');
INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('filter', 'Object Filter', 'object', 'reestr');
INSERT INTO supported_view_cfg (code, title, id_data_type, id_view) VALUES ('page', 'Object Page', 'object', 'reestr');

CREATE TABLE data_value (
  id                  BIGINT AUTO_INCREMENT NOT NULL,        --
  date_open           TIMESTAMP NOT NULL,                    --
  date_edit           TIMESTAMP NOT NULL,                    --
  date_close          TIMESTAMP,                             --
  card                CHARACTER VARYING NOT NULL,            --
  PRIMARY KEY (id)
);

CREATE TABLE data_field_value (
  id                  BIGINT AUTO_INCREMENT NOT NULL,        --
  id_data_value       BIGINT NOT NULL,        --
  name                CHARACTER VARYING NOT NULL,     --
  value               CHARACTER VARYING NOT NULL,     --
  PRIMARY KEY (id)
);

CREATE TABLE issues (
  id                  BIGINT AUTO_INCREMENT NOT NULL,        --
  date_open           TIMESTAMP NOT NULL,                    --
  date_edit           TIMESTAMP NOT NULL,                    --
  date_close          TIMESTAMP,                             --
  title               CHARACTER VARYING NOT NULL,     --
  PRIMARY KEY (id)
);

CREATE TABLE fields (
  id                  BIGINT AUTO_INCREMENT NOT NULL,        --
  date_open           TIMESTAMP NOT NULL,                    --
  date_edit           TIMESTAMP NOT NULL,                    --
  date_close          TIMESTAMP,                             --
  id_type             CHARACTER VARYING NOT NULL,        --
  title               CHARACTER VARYING NOT NULL,     --
  FOREIGN KEY (id_type) REFERENCES supported_data_type (id),
  PRIMARY KEY (id)
);

CREATE TABLE issue_fields (
  id_issue            BIGINT NOT NULL,        --
  id_field            BIGINT NOT NULL,
  FOREIGN KEY (id_issue) REFERENCES issues (id),
  FOREIGN KEY (id_field) REFERENCES fields (id)
);

CREATE TABLE views (
  id                  BIGINT AUTO_INCREMENT NOT NULL,        --
  date_open           TIMESTAMP NOT NULL,                    --
  date_edit           TIMESTAMP NOT NULL,                    --
  date_close          TIMESTAMP,                             --
  title               CHARACTER VARYING NOT NULL,     --
  PRIMARY KEY (id)
);

CREATE TABLE rules (
  id                  BIGINT AUTO_INCREMENT NOT NULL,        --
  date_open           TIMESTAMP NOT NULL,                    --
  date_edit           TIMESTAMP NOT NULL,                    --
  date_close          TIMESTAMP,                             --
  title               CHARACTER VARYING NOT NULL,     --
  PRIMARY KEY (id)
);
