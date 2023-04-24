#!/bin/bash

java -version

if [ $? = 0 ]; #se retorno for igual a 0
	then #entao,
		echo "java instalado" #print no terminal

	else #se nao,
		echo "java não instalado" #print no terminal
		echo "gostaria de instalar o java? [s/n]" #print no terminal

		read get #variavel que guarda resposta do usuário

if [ \"$get\" == \"s\" ]; #se retorno for igual a 0

	then #entao
	sudo apt install openjdk-17-jre -y #executa instalacao do java

	fi #fecha o 2o if

fi #fecha o 1o if

if [ -d "login.jar" ]
	then
		rm login.jar

		cd /home/urubu100/Desktop/"login bitbox"/bitbox-backend-java 
		wget https://raw.githubusercontent.com/BITBOX-MONITORING/bitbox-backend-java/main/prototipo-bitbox/target/login.jar
	else
		wget https://raw.githubusercontent.com/BITBOX-MONITORING/bitbox-backend-java/main/prototipo-bitbox/target/login.jar
	fi

java -jar login.jar