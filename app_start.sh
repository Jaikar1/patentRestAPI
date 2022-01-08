#!bin/bash
docker-compose -f docker-compose.yml up --detach --build;
wait;
sleep 10;
http_response=$(curl -s -o response.txt -w "%{http_code}" http://localhost:8080/patent)
if [ $http_response != "200" ]; then
	docker-compose stop;
	docker-compose rm -f;
	echo "Ocurri� un error durante la inicializaci�n de la aplicaci�n, intentelo nuevamente";
else
	echo "La aplicaci�n se inici� correctamente";
fi
exit;

