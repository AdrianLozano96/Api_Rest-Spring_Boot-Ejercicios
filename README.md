# Api-Rest-Spring-Boot

### DemoSpring

Creando mi primera Api Rest básca con Spring y segurizada con JWT

### JavaSoft

Se nos pide realizar un Servicio REST en base a la plantilla que nos han ofrecido para resolver el siguiente problema.
Queremos que con nuestro servicio REST poder gestionar el conjunto de proyectos que tiene nuestra empresa de desarrollo JAVASOFT. 
En JAVASFOT trabajan una serie de usuarios programadores, de los cuales almacenamos su nombre completo, nombre de usuario, su correo electrónico y avatar. Además almacenaremos una lista de tecnologías que utilizan para desarrollar sus proyectos: JAVA, JAVASCRIPT, PYTHON y KOTLIN. Por ahora no vamos a considerar más tecnologías. 
De los proyectos necesitamos saber el nombre de proyecto, fecha de inicio, fecha de fin y coste total. El coste total, vendrá dado por la suma del coste de las tareas que lo forman. El proyecto estará formado una serie de tareas. Una tarea es realizada por un solo usuario de la empresa. De la tarea necesitamos conocer la fecha de inicio, fecha de fin, coste de la misma, así como el tipo de actividad de la misma: análisis, diseño, implementación, pruebas y mantenimiento. Debemos tener en cuenta que pueden aparecer nuevos tipos de tareas y así debemos recogerlo. Además, todo proyecto tiene un único responsable que es uno de los usuarios de la empresa.
A la hora de consultar los datos debemos tener en cuenta que si consultamos el proyecto debemos obtener información completa del proyecto, es decir, datos del proyecto, responsable, listado de tareas y por cada tarea datos de la persona asignada. Si consultamos una tarea debemos obtener información del usuario al cual está asignada.



### Notas

De los dos ejercicios se han realizado las entidades con sus relaciones y anotaciones JPA correspondientes, dtos y mappers de cada clase, realización de repositorios con JPARepository y los controladores de cada clase realizando en ellos su CRUD completo, haciendo paginación en alguna clase, consultas personalizadas y Test de Repositorio y Controlador. La conexión se ha realizado mediante una base de datos H2.
