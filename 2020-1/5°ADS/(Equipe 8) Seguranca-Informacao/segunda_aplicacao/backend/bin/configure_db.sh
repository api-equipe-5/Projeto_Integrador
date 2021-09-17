#!/bin/bash

export PGPASSWORD='node_password'

echo "Configuring lgpddb2"

dropdb -U node_user lgpddb2
createdb -U node_user lgpddb2

psql -U node_user lgpddb2 < ./bin/sql/account.sql
psql -U node_user lgpddb2 < ./bin/sql/device.sql
psql -U node_user lgpddb2 < ./bin/sql/measurement.sql
psql -U node_user lgpddb2 < ./bin/sql/accountDevice.sql
psql -U node_user lgpddb2 < ./bin/sql/portData.sql


echo "lgpddb2 configured"