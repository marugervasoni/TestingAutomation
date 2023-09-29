# TestingAutomation
Proyecto evaluativo, llevado a cabo en la materia Testing 2, dónde pusimos en práctica los conocimientos aprendidos sobre Testing automatizado en front-end como en back-end. 

## Table of Contents
1. [Información general](#general-info)
2. [Tecnologías](#technologies)

### Información general
***
Proyecto creado en arquitectura monolítica, donde llevamos a la práctica el testeo automatizado tanto desde el front-end como el back-end de una pagina web bancaria (https://parabank.parasoft.com/parabank/index.htm).
Utilizamos lenguaje de programación Java, y para la realización de los tests Selenium y Rest Assured.

PRUEBAS
- de Front-end:
    Realizadas utilizando patrón de diseño Page Object Model y centralizando todos los pasos en un solo test, aplicando suites de prueba y generando reportes con Extent Reports. 

    Título del caso de prueba: Proceso de registro, apertura de una nueva cuenta, visión general de la cuenta, transferencia de fondos, actividad de la cuenta, para todas las etapas de las pruebas frontales Pruebas Front-end:
    ● Registro
        ○ Haga clic en <Registro>
        ○ Rellene el formulario de registro con los datos requeridos
        ○ Pulse de nuevo en <Registro>.
        ○ Compruebe que el texto "Su cuenta se ha creado correctamente. En la pantalla se puede ver "You are now logged in".
    ● Abrir una nueva cuenta
        ○ Haga clic en <Abrir nueva cuenta>.
        ○ En el apartado "¿Qué tipo de cuenta desea abrir?" seleccione la opción <SAVINGS>.
        ○ Haga clic en <Abrir nueva cuenta>
        ○ Compruebe si el texto "Congratulations, your account is now open." está visible en la pantalla
    ● Resumen de las cuentas
        ○ Haga clic en <Resumen de cuentas>
        ○ Compruebe si el texto "*El saldo incluye depósitos que pueden estar sujetos a retenciones" está visible en la pantalla
    ● Transferir Fondos
        ○ Haga clic en <Transferencia de fondos>
        ○ Compruebe que el texto "Transferir fondos" es visible en la pantalla
        ○ En el campo <Importe: $> introduzca el importe a transferir
        ○ En el campo <De la cuenta #> seleccione una cuenta
        ○ En el campo <a la cuenta #> seleccione una cuenta distinta a la anterior
        ○ Haga clic en <Transferencia>
        ○ Compruebe que el texto "¡Transferencia completa!" es visible en la pantalla
    ● Actividad de la cuenta (cada mes)
        ○ Haga clic en <Resumen de cuentas>
        ○ Compruebe que el texto "*El saldo incluye depósitos que pueden estar sujetos a retenciones" es visible en la pantalla
        ○ Haga clic en una cuenta en la columna <Cuenta>.
        ○ Compruebe que el texto "Detalles de la cuenta" es visible en la pantalla
        ○ En "Actividad de la cuenta" haga clic en <Periodo de actividad:> y seleccione "Todo"
        ○ En "Actividad de la cuenta" haga clic en <Tipo:> y seleccione "Todo"
        ○ Haga clic en <Ir>

- de Back-end:
    Pruebas de la API Rest, utilizando Rest Assured y TestNG.
   
    ● Validación del código de estado 200 para todas las etapas de las pruebas frontales
        ○ Registro URL: https://parabank.parasoft.com/parabank/register.htm
        ○ Abrir una nueva cuenta URL: https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=xxxxx
        ○ Resumen de las cuentas URL: https://parabank.parasoft.com/parabank/overview.htm
        ○ Descarga de fondos URL: https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx
        ○ Actividad de la cuenta (cada mes) URL: https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All


## Technologías
***
Lista de tecnologías usadas en el proyecto:
* ChromeDriver
* Dependencias POM:
    - junit-jupiter-api
    - junit-jupiter-engine
    - selenium-java
    - extentreports
    - rest-assured
    - testng