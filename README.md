# Arquitectura de Microservicios
## Dependencias utilizadas <a name = "dependencies"></a>
- [Spring Cloud Config](#config)
- [Netfilx Eureka](#eureka)
- [Resilience4j](#resilience)
- [Spring Load Balancer](#balancer)
- [Feign](#feign)
- [Zuul](#zuul)
- [Spring Security OAuth](#security)

## Spring Cloud Config <a name = "config"></a>
Todos los archivos de configuración de lso microservicios se encuentran centralizados en un repositorio Git. Dentro de la carpeta config-data.

## Netfilx Eureka <a name = "eureka"></a>
Para el registro y descubrimiento de microsericios

## Resilience4j <a name = "resilience"></a>
Para la implementación de tolerancia a fallos. Configurado en microservicio-curso

## Spring Load Balancer <a name = "balancer"></a>
Para el balanceo de carga. Se implementó una clase CustomLoadBalancer en el microservicio microservice-curso, el cual se encarga de seleccionar la instancia de microservice-alumno que se encuentra en el puerto mayor.
## Feign <a name = "feign"></a>
Utilizado en el microservicio microservice-curso para invocar a microservice-alumno, y también en composer para invocar a los microservicios microservice-curso y microservice-alumno.
## Zuul <a name = "zuul"></a>
Enrutador para el manejo de peticiones. Se implementó un fallback personalizado, 2 pre filter y 1 post filter. Solo se permite el acceso mediante los métodos GET, HEADER, OPTION, POST, PUT, PATCH, DELETE. Los roles permitidos son USER y ADMIN. Se debe setear en el header el parámetro "app : web", de lo contrario arrojará error 400 Bad Request.
## Spring Security OAuth <a name = "security"></a>
Implementación de un servidor UAA. Securiza todos los microservicios, permitiendo las peticiones solo mediante un token de autenticación (Bearer)

