CREATE TABLE secret_name (
  uuid BINARY(16) NOT NULL,
  name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE secret_name
  ADD CONSTRAINT secret_name_pkey PRIMARY KEY(uuid);

ALTER TABLE secret_name
  ADD CONSTRAINT name_unique UNIQUE(name);
