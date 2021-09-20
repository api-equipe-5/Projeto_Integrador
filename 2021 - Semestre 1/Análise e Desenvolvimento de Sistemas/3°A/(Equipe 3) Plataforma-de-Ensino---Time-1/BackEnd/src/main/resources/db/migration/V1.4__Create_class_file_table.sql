CREATE TABLE IF NOT EXISTS "user_account_class"
(
    "user_account_id" INT NOT NULL REFERENCES user_account (id),
    "class_id"        INT NOT NULL REFERENCES class (id),

    CONSTRAINT "user_account_class_pk" PRIMARY KEY (user_account_id, class_id)
);
