# Spring Boot, Docker, Kubernetes y MySQL

Proyecto de implementacion una aplicación Spring Boot (microservicio) con una base de datos MySQL en Kubernetes.

## Prerrequisitos

- Docker with kubernetes enabled
- Kubernetes command-line tool(kubectl)
- JRE 20
- Install Gradle
- Install Curl

## Ejecución de la aplicación

- Crear secrets (contraseñas) y levantar la base de datos mysql

```sh
kubectl apply -f deployment/secrets.yaml
kubectl apply -f deployment/mysql-deployment.yaml

```

- Construir la aplicación y desplegarlo en Kubernetes

```sh
gradle clean dockerTag
kubectl apply -f deployment/app-k8s.yaml

```

- Probar la aplicacion en Command Prompt (CMD) :

```curl
curl -X GET ^
  http://localhost:31371/api/v1/pets ^
  -H "Accept: application/json" ^
  -H "Content-Type: application/json"  
```

La respuesta debería ser la siguiente :

```json
[
  {
    "name": "Max",
    "owner": "Steep",
    "species": "perro",
    "sex": "m",
    "birth": "2012-04-15",
    "death": null
  }
]
```
- Verificación de pods en ejecución :

```curl
kubectl get pods --all-namespaces
```

### Eliminar el despliegue, servicio, secretos y el volumen persistente (PVC)

```sh
kubectl delete -f deployment/app-k8s.yaml
kubectl delete -f deployment/mysql-deployment.yaml
kubectl delete -f deployment/secrets.yaml

```
### Referencias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Gradle Docker image build plugin](https://plugins.gradle.org/plugin/com.palantir.docker)
- [OpenJDK Docker](https://hub.docker.com/_/openjdk)
- [MySQL Docker](https://hub.docker.com/_/mysql)
- [Curl](https://curl.se/windows/)