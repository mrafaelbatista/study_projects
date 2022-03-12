# Apresentando o Dockerfile
# Acessem www.mrafaelbatista.com.br
# Curtam o vídeo e se inscrevam no canal mrafaelbatista

FROM mysql:latest

RUN apt-get update && apt-get upgrade -y && apt-get clean

EXPOSE 3306

ENV MYSQL_ROOT_PASSWORD="123456"

LABEL decription="database_mrb"