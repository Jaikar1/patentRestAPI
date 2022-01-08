#!bin/bash
docker-compose -f docker-compose.yml up --detach --build;
wait;
sleep 10;
http_response=$(curl -s -o response.txt -w "%{http_code}" http://localhost:8080/patent)
if [ $http_response != "200" ]; then
	docker-compose stop;
	docker-compose rm -f;
	echo "Ocurrió un error durante la inicialización de la aplicación, intentelo nuevamente";
else
	echo "La aplicación se inició correctamente";
fi
exit;

