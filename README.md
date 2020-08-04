# ejercicio
Ejercicio GlobalLogic

1.-Versión Java 11
2.-PostgreSQL 9.4	
3.-Gradle 6.4.1
4.-SpringTool Suite 4.5.1

Pasos a seguir:
1.-Descargar proyecto.

2.-Se debe ejecutar el script de creación de base de datos ubicado en la ruta:
    src\main\resources\database

3.-Configurar PostgreSQl en archivo "application.properties" ubicado en:
    src\main\resources\application.properties
    Especificar puerto en "spring.datasource.url"
    Especificar usuario en "spring.datasource.username"
    Especificar contraseña en "spring.datasource.password"

4.-En eclipse:
    Abrir Eclipse y seleccionar File > Import.
    En el explorador que se abre, seleccionar Gradle > Existing Gradle Project, y haz click en Next.
    Seleccionar el directorio del proyecto.
    Click en Finish.

5.-Command Line
    Ingrese a la raíz del proyecto
    Ejecutar ./gradlew clean build en Linux o gradlew.bat clean build en Windows.
    Ejecutar ./gradlew run en Linux/Mac o gradlew.bat run en Windows para ejecutar el proyecto.

El endpoint para consumir el servicio POST es:
http://localhost:8092/user/
