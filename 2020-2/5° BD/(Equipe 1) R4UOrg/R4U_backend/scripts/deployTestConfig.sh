#!/bin/sh

. /home/ubuntu/cron/docker_prune.sh

docker stop $(docker ps -aq)

docker rm $(docker ps -aq)

docker rmi $(docker images -aq)

cd /home/ubuntu/r4u_application

docker-compose -f docker-compose-migration.yml up -d

docker-compose up -d

sudo robot --nostatusrc --outputdir /home/ubuntu/robotLogs tests/robotTests.robot
