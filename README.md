# PizziSalle (DesignPatterns)
La Pizzeria “PizziSalle” ha decidido registrar su actividad diaria mediante un programa informático, este programa se ha desarrollado en Java y utiliza una base de datos MySQL. Permite a los clientes realizar pedidos telefónicos, solicitando primero los datos del cliente y luego los detalles del pedido. El proyecto se centra en la aplicación de varios patrones de diseño, como MVC, Singleton, Builder y Decorator, para estructurar eficientemente el código y facilitar futuras extensiones y mantenimiento.

## Ejecución:
1. Asegúrese de tener una conexión a la base de datos MySQL proporcionada.
2. Ejecute el programa Java desde el Main del proyecto.El programa solicitará primero los datos del cliente.
3. Luego, solicitará el pedido con los campos requeridos por el enunciado.
4. Una vez que todos los campos estén completos, se realizará la inserción en la base de datos.
5. El programa finaliza aquí; si desea realizar otro pedido, debe volver a ejecutar el código.

## Patrones Aplicados:
### MVC (Modelo-Vista-Controlador):
El proyecto está estructurado con el patrón de diseño Modelo-Vista-Controlador. Se han separado los datos de manera que en la vista tenemos todo lo relacionado con la interfaz de usuario, en el modelo se estructura toda la información y los accesos (como la base de datos y también los objetos requeridos por la práctica), y finalmente en el controlador que actúa como intermediario entre la vista y el modelo.

### Singleton:
Se ha aplicado el patrón Singleton para restringir la creación de objetos pertenecientes a una clase y limitar el valor de un tipo a un solo objeto. Resultó muy útil para la parte de la base de datos.

### Builder:
El patrón Builder se ha utilizado para construir el objeto 'Pizza' de cada pizza que el usuario solicita por pedido. Finalmente, solo fue necesario tener una AbstractClass que tendría un solo ConcreteBuilder ya que con uno solo pude construir cualquier tipo de pizza.

### Decorator:
El patrón Decorator ha sido útil para tener en cuenta los ingredientes extras. Como al final deben ser como un ingrediente más de la pizza además de los que ya tiene apriori, con este patrón se ha podido modificar el objeto de pizza original sin cambiar la base de los demás objetos del mismo tipo.

##
@author: Oscar Julian
@date: 09 de Enero 2022
