#!/bin/sh

. /home/ubuntu/cron/docker_prune.sh

docker stop $(docker ps -aq)

docker rm $(docker ps -aq)

docker rmi $(docker images -aq)

cd /home/ubuntu/r4u_application

docker-compose -f docker-compose-migration.yml up -d

docker-compose up -d

cd /home/ubuntu/r4u_application_frontend

docker build . -t my-app

docker run -d -p 8081:80 my-app

sudo chmod 777 /home/ubuntu/r4u_application_frontend/tests

sudo chmod 777 /home/ubuntu/r4u_application_frontend/tests/*

cd tests

robot --nostatusrc --outputdir . robotTests.robot
