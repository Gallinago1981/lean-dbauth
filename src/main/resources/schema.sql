CREATE TABLE user_data (
    seq INTEGER PRIMARY KEY
    , id VARCHAR(10) NOT NULL
    , password TEXT NOT NULL
    , name VARCHAR(20) NOT NULL
    , expire_date date NOT NULL
    , invalid_flg CHAR(1) NOT NULL default '0'
    , reg_date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP
    , mod_date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP
);