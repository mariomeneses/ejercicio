# ejercicio
Ejercicio GlobalLogic

Versión Java 11
Para la persistencia se utilizó una base de datos PostgreSQL.

Pasos a seguir:
Descargar proyecto.

Se debe ejecutar el script de creación de base de datos ubicado en la ruta:
src\main\resources\database

Configurar PostgreSQl en archivo "application.properties" ubicado en:
src\main\resources\application.properties
Especificar puerto en "spring.datasource.url"
Especificar usuario en "spring.datasource.username"
Especificar contraseña en "spring.datasource.password"

En eclipse:
Abrir Eclipse y seleccionar File > Import.
En el explorador que se abre, seleccionar Gradle > Existing Gradle Project, y haz click en Next.
Seleccionar el directorio del proyecto.
Click en Finish.

Command Line
Ingrese a la raíz del proyecto
Ejecutar ./gradlew clean build en Linux o gradlew.bat clean build en Windows.
Ejecutar ./gradlew run en Linux/Mac o gradlew.bat run en Windows para ejecutar el proyecto.

El endpoint para consumir el servicio POST es:
http://localhost:8092/user/
