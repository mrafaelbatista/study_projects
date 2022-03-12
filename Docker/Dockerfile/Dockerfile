FROM php:7.0.20-apache
MAINTAINER Messias Batista <mrafaelbatista@gmail.com>

#Atualização do sistema
RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y apt-utils

#Instalação do editor Vim
RUN apt-get install vim -y

#Instalação extensões PHP
RUN apt install -y libmcrypt-dev
RUN docker-php-ext-install mcrypt 
RUN docker-php-ext-install pdo
RUN docker-php-ext-install pdo_mysql 
RUN docker-php-ext-install mysqli

#Instalações de extensões do php internet
RUN docker-php-ext-install session
RUN docker-php-ext-install json
RUN docker-php-ext-install hash
RUN docker-php-ext-install sockets
RUN docker-php-ext-install pcntl

#Criação de diretório
RUN mkdir /code

#Diretório de trabalho
WORKDIR /code