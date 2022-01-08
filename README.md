# PatentApi

Patent es un API desarrollada con Spring Framework para el consumo de patentes.

## Caracteristicas

- Redis como software de persistencia de datos
- Integración modular con Docker y Docker compose
- Facil inicialización mediante Docker compose y Shell
- Solamente disponible en Linux

## Tecnologías

PatentAPI usa un gran número de proyectos OpenSource como:

- [Spring framework](https://spring.io/) - Spring Framework es una plataforma que nos proporciona una infrastuctura que actúa de soporte para desarrollar aplicaciones Java!
- [Redis](https://redis.io/) - Redis es un almacén de estructura de datos en memoria de código abierto (con licencia BSD), que se utiliza como base de datos, caché y agente de mensajes
- [JUnit](https://junit.org/junit5/) - La versión principal de framework de pruebas fácil de usar para programadores en Java y JVM
- [AssertJ](https://assertj.github.io/doc/) - AssertJ es una biblioteca de Java que proporciona un amplio conjunto de aserciones y mensajes de error verdaderamente útiles, mejora la legibilidad del código de prueba y es fácil de usar.
- [Lombok](https://projectlombok.org/) - Lombok es una biblioteca de Java que se conecta automáticamente a su editor y herramientas de compilación, minimizando su código java. 
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
