# Gestión de Información de Vuelos Espaciales

## Requisitos Funcionales

### RF-0: Menú Principal

Al iniciar la aplicación, se debe presentar un menú textual con las siguientes opciones:

1. Agregar naves
2. Agregar directores/as
3. Agregar vuelos o misiones
4. Consultar un vuelo o misión
5. Marcar vuelos fallidos
6. Consultar todos los vuelos de la lista original
7. Procesar vuelo fallido
8. Consultar todos los vuelos fallidos
9. Elegir estructura de almacenamiento de vuelos fallidos

### RF-1: Ingreso de Información de Naves Espaciales

El usuario debe poder ingresar la información de naves espaciales (placa, nombre, tipo de nave) tantas veces como desee
sin regresar al menú principal.

### RF-2: Ingreso de Información de Directores/as de Vuelos

El usuario debe poder ingresar la información de directores/as de vuelos (identificación, nombre, apellido) tantas veces
como desee sin regresar al menú principal.

### RF-3: Agregar Vuelos o Misiones

El usuario debe poder agregar vuelos o misiones (número de misión, nombre, fecha, identificador de director/a,
identificador de nave) tantas veces como desee sin regresar al menú principal. **Criterio de validación**: la placa de
la nave y el identificador del director/a deben existir.

### RF-4: Consultar un Vuelo o Misión

El usuario debe poder consultar un vuelo o misión por el número de vuelo o misión tantas veces como desee sin salir de
la opción de consulta.

### RF-5: Elección de Estructura de Almacenamiento para Vuelos Fallidos

Al ingresar a la opción "Elegir estructura de almacenamiento de vuelos fallidos", el usuario debe indicar si los vuelos
fallidos serán almacenados en una pila o en una cola. Esto debe hacerse antes de marcar vuelos fallidos.

### RF-6: Marcar un Vuelo como Fallido

Marcar un vuelo como fallido consiste en eliminar un vuelo o misión de la lista original y pasarlo a una pila o cola de
vuelos o misiones fallidos, según el deseo del usuario. **Criterio de validación**: debe estar elegida una estructura de
almacenamiento.

### RF-7: Procesar Vuelo Fallido

El usuario debe poder eliminar un vuelo fallido según la estructura de almacenamiento elegida (pila o cola).

## Requisitos No Funcionales

### RNF-1: Almacenamiento de Naves

Las naves deben ser almacenadas en un arreglo de objetos.

### RNF-2: Almacenamiento de Directores/as

Los/Las directores/as deben ser almacenados en un arreglo de objetos.

### RNF-3: Almacenamiento de Vuelos o Misiones

Los vuelos o misiones deben ser almacenados en una lista ordenada doblemente enlazada, ordenada por número de misión.

### RNF-4: Almacenamiento de Vuelos o Misiones Fallidas

Los vuelos o misiones fallidos deben ser almacenados en una lista no ordenada simple, respetando los conceptos de pila o
cola según la elección del usuario.

### RNF-5: Estructura de Almacenamiento de Vuelos Fallidos

Los vuelos fallidos deben ser almacenados en una pila o en una cola según la elección del usuario.

### RNF-6: Eliminación de Vuelos Fallidos

La eliminación de vuelos fallidos debe seguir el concepto de pila o cola. Es decir, si es pila, se elimina por la cabeza
y si es cola, se elimina por la cola.

### RNF-7: Clases Necesarias

- Clase principal
- Clase nave
- Clase vuelo o misión
- Clase director/a
- Clase lista original
- Clase pila fallidos
- Clase cola fallidos
- Clase ArrayObjBDnave
- Clase ArrayObjBDdirectores

### RNF-8: Uso de ArrayList

ArrayList solo se puede usar para almacenar naves y directores.

## Estructuras de Datos Utilizadas

En este proyecto, se utilizan varias estructuras de datos para gestionar la información de vuelos espaciales y su
estado. A continuación, se detallan las estructuras de datos utilizadas:

1. **Arreglo de Objetos**:

    - **Naves Espaciales**: Las naves deben ser almacenadas en un arreglo de objetos.
    - **Directores/as de Vuelos**: Los/Las directores/as deben ser almacenados en un arreglo de objetos.

2. **Lista Ordenada Doblemente Enlazada**:

    - **Vuelos o Misiones**: Los vuelos o misiones deben ser almacenados en una lista ordenada doblemente enlazada,
      ordenada por número de misión.

3. **Lista No Ordenada Simple**:

    - **Vuelos o Misiones Fallidos**: Los vuelos o misiones fallidos deben ser almacenados en una lista no ordenada
      simple, respetando los conceptos de pila o cola según la elección del usuario.

4. **Pila**:

    - **Vuelos Fallidos**: Si el usuario elige almacenar los vuelos fallidos en una pila, se debe implementar esta
      estructura de datos para manejar los vuelos fallidos.

5. **Cola**:

    - **Vuelos Fallidos**: Si el usuario elige almacenar los vuelos fallidos en una cola, se debe implementar esta
      estructura de datos para manejar los vuelos fallidos.

6. **ArrayList**:
    - **Naves y Directores/as**: Se permite el uso de `ArrayList` específicamente para almacenar naves y directores.

En resumen, las estructuras de datos utilizadas son:

- Arreglo de objetos (para naves y directores/as)
- Lista ordenada doblemente enlazada (para vuelos o misiones)
- Lista no ordenada simple (para vuelos o misiones fallidos)
- Pila (para vuelos fallidos, si el usuario así lo elige)
- Cola (para vuelos fallidos, si el usuario así lo elige)
- ArrayList (para naves y directores/as)
