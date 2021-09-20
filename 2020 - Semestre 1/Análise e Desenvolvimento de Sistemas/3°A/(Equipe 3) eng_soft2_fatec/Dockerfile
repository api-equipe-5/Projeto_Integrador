# sempre defina uma versao específica
FROM python:3.7-slim-buster

##############################
# DOCKER CONTAINER PTYHON 3.7
##############################

# Adicionando argumentos
ARG APP_NAME
ARG REQUIREMENTS_FILE=dev

ENV APP_NAME=project

ENV REQUIREMENTS_PATH=./requirements
ENV WORK_DIR=/usr/src/app

# Copiando o arquivo de requirements para dentro do Docker
COPY ${REQUIREMENTS_PATH} ${WORK_DIR}/requirements

# Workdir é a pasta no qual o docker irá "funcionar"
WORKDIR ${WORK_DIR}

RUN apt-get update && apt-get install -y \
            build-essential libssl-dev \
            libffi-dev libxml2-dev libxslt1-dev zlib1g-dev \
            libxml2 \
            libxslt1-dev \
            git \
            ssh \
            nano

RUN pip install -r ${WORK_DIR}/requirements/${REQUIREMENTS_FILE}.txt

# Copiando a pasta da aplicação para dentro do Docker
COPY ./${APP_NAME}/ ${WORK_DIR}

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

EXPOSE 8080

CMD ["bash"]
