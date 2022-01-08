Nunca vuelva a escribir otro método getter o equals, con una anotación su clase tiene un generador con todas las funciones, automatice sus variables de registro y mucho más.

## Instalación

PatentApi requiere Docker en su versión 20.10 y Docker compose en su versión 1.27.4

Para inicializar los contenedores y el API ejecute el siguiente comando:
```sh
sh app_start.sh
```
Sabrá que los contenedores se inicializaron correctamente cuando visualice en Bash el siguiente mensaje:
```sh
La aplicación se inició correctamente
```

## Cómo usar PatentApi?

Asumiendo que "localhost" será su host.
- Para visualizar las patentes según su ID:
    GET http://localhost:8080/patent/{id}
- Para visualizar las patentes según su patente
    GET http://localhost:8080/patent/name/{patente}