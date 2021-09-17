#!/bin/bash

export PGPASSWORD='node_password'

echo "Configuring lgpddb"

dropdb -U node_user lgpddb
createdb -U node_user lgpddb

psql -U node_user lgpddb < ./bin/sql/account.sql
psql -U node_user lgpddb < ./bin/sql/device.sql
psql -U node_user lgpddb < ./bin/sql/measurement.sql
psql -U node_user lgpddb < ./bin/sql/accountDevice.sql
psql -U node_user lgpddb < ./bin/sql/portData.sql


echo "lgpddb configured"