FROM nginx:latest
MAINTAINER Messias Batista <mrafaelbatista@gmail.com>

#Atualização do sistema
RUN apt-get update && apt-get upgrade -y

#Instalação do editor Vim
RUN apt-get install vim -y

#Criação de diretório
RUN mkdir /code

#Diretório de trabalho
WORKDIR /code

#Adicionando arquivo de configuração
ADD ./docker_config/site.conf.nginx /etc/nginx/conf.d/default.conf

#Porta exposta para comunicação
EXPOSE 80