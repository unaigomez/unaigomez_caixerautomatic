# Proyecto M03 El Cajero Automático FX - Unai Gómez DAW1

**Descripción general**

El Cajero Automático FX es una aplicación de gestión bancaria desarrollada en Java con JavaFX. La aplicación permite a los clientes de un banco realizar operaciones como consultar el saldo de sus cuentas, realizar transferencias, retirar dinero de un cajero automático, etc. Además, también incluye una funcionalidad para la conversión de divisas. 

---------------------------------------------

**Funcionalidades implementadas**

    Login: el usuario puede iniciar sesión en el sistema proporcionando su nombre de usuario y contraseña. Se valida que el usuario exista en la base de datos y que la contraseña coincida con la almacenada en la base de datos. Una vez iniciada la sesión, se muestra la página de inicio correspondiente.

    Cambio de contraseña: el usuario puede cambiar su contraseña proporcionando la contraseña antigua y la nueva. Se valida que la contraseña antigua sea correcta y que la nueva cumpla con los requisitos de complejidad (longitud mínima, uso de caracteres especiales, etc.).

    Cambio de usuario: el usuario puede cambiar su nombre de usuario proporcionando el nuevo nombre de usuario. Se valida que el nuevo nombre de usuario no esté en uso por otro usuario.

    Consulta de saldo: el usuario puede consultar el saldo de sus cuentas bancarias.

    Retiro de efectivo: el usuario puede retirar efectivo de una de sus cuentas bancarias. Se valida que el usuario tenga suficiente saldo en la cuenta y que el cajero tenga suficiente efectivo.

    Transferencia: el usuario puede transferir dinero entre dos de sus cuentas bancarias. Se valida que el usuario tenga suficiente saldo en la cuenta de origen y que el número de cuenta de destino sea válido.

    Conversión de divisas: el usuario puede convertir una cantidad de euros a otra divisa (USD, GBP, MXN, ARS) utilizando un tipo de cambio fijo.

    Gestión de billetes del cajero automático: el cajero automático dispone de una cantidad limitada de billetes de diferentes denominaciones. El cajero automático puede ser recargado con billetes y puede dispensar billetes al usuario al realizar un retiro de efectivo. Se valida que el cajero tenga suficientes billetes para dispensar y que la cantidad a retirar sea un valor válido.

    Gestión de clientes y cuentas bancarias: se pueden agregar nuevos clientes y cuentas bancarias a la base de datos del sistema. Se pueden consultar los clientes y sus cuentas bancarias existentes. Se valida que los datos del cliente y de la cuenta bancaria sean válidos antes de agregarlos a la base de datos.

    Registro de movimientos: se registra cada movimiento que se realiza en el sistema (inicio de sesión, cambio de contraseña, retiro de efectivo, transferencia, etc.). Los movimientos registrados se pueden consultar en un historial de movimientos.
    
---------------------------------------------

**Diagrama de clases**

Podrás encontrar el png del diagrama de clases en el github con el nombre diagramaUMLcaixer_unaigomez.png
    
    
    
