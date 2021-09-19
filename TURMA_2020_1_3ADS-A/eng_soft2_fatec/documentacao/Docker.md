# Instalando Docker-CE


## Passo 1 - Instalando Docker

	$ sudo apt update
	$ sudo apt install apt-transport-https ca-certificates curl software-properties-common
	$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
	$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"
	$ sudo apt update
	$ sudo apt install docker-ce

#### Para checar se o docker está funcionando:

	$ sudo systemctl status docker


## Passo 2 - Utilizar docker sem SUDO

	$ sudo usermod -aG docker ${USER}
	$ su - ${USER}
	$ id -nG

## Passo 3 - Instalar docker-compose

	$ sudo curl -L "https://github.com/docker/compose/releases/download/1.25.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
	$ sudo chmod +x /usr/local/bin/docker-compose

Verificando a versão do docker-compose:

	$ docker-compose --version