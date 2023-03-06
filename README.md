## Setup

Ir a la rama /pruebaSetup del repositorio: https://github.com/cromeoli/kata-API

Clonar proyecto
```bash
git clone https://github.com/cromeoli/kata-API
```

El proyecto está hecho con el **SDK amazon-coretto 11** y lenguaje level **"SDK Default 11"**.

Hay que ejecutar directamente la clase principal, sin uso de docker.

## Archivo aplication.properties

Aparte de la configuración básica para conectar la BD, tenemos esta configuración:

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect  
spring.mvc.pathmatch.matching-strategy=ant-path-matcher  
server.port=3009
```

Hemos cambiado el puerto al 3009, y la línea:

```
spring.mvc.pathmatch.matching-strategy=ant-path-matcher  
```

Es necesaria para que funcione swagger. La ruta de swagger es:

[http://localhost:3009/swagger-ui/index.html#/](http://localhost:3009/swagger-ui/index.html#/ "http://localhost:3009/swagger-ui/index.html#/")

## Como probar la API

Para probar directamente los endpoints, se puede acceder a este enlace de postman que te lleva al espacio de trabajo donde hemos guardado todas las peticiones:

[https://charizard-kata-api.postman.co/workspace/Team-kata-API~918cd76b-4034-4808-81ce-cbee309d0cb3/request/25995884-9c5b84eb-536c-4899-9abc-b623e610a2b7](https://charizard-kata-api.postman.co/workspace/Team-kata-API~918cd76b-4034-4808-81ce-cbee309d0cb3/request/25995884-9c5b84eb-536c-4899-9abc-b623e610a2b7 "https://charizard-kata-api.postman.co/workspace/Team-kata-API~918cd76b-4034-4808-81ce-cbee309d0cb3/request/25995884-9c5b84eb-536c-4899-9abc-b623e610a2b7")

Por si acaso, hemos adjuntado también un export de la colección de peticiones de postman, 
es el archivo:

**exportsPostman.json**

## Endpoints

Nuestros endpoints son exactamente los mismos que los establecidos en el repositorio original de kata-api:

| Endpoint         | Resultado                               | Método   |
|----------------- |-----------------------------------------|:--------:|
|`/beers`          | Muestra todas las cervezas              | GET      |
|`/beer`           | Añadir una cerveza                      | POST     |
|`/beer/{id}`      | Mostrar la cerveza con el id `{id}`     | GET      |
|`/beer/{id}`      | Eliminar una cerveza                    | DELETE   |
|`/beer/{id}`      | Modificar una cerveza                   | PUT      |
|`/beer/{id}`      | Modificar parcialmente una cerveza      | PATCH    |
|`/breweries`      | Listar todas las cerveceras             | GET      |
|`/brewerie/{id}`  | Mostrar la cervecera `{id}`             | GET      |
|`/categories`     | Listar todas las categorías             | GET      |
|`/categorie/{id}` | Mostrar la categoría `{id}`             | GET      |
|`/styles`         | Listar todos los estilos -style-        | GET      |
|`/style/{id}`     | Mostrar el estilo -style- `{id}`        | GET      |

