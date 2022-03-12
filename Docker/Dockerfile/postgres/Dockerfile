FROM postgres:9.6
MAINTAINER Messias Batista <mrafaelbatista@gmail.com>

#Atualização do sistema
RUN apt-get update && apt-get upgrade -y

#Instalação do editor Vim
RUN apt-get install vim -y

#Criação de diretório
RUN mkdir /database
RUN mkdir /database/log
RUN mkdir /database/data
RUN mkdir /database/lib
RUN chown -R postgres /database

#Diretório de trabalho
WORKDIR /database

EXPOSE 5432