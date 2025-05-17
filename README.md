# Implementación de Árbol AVL en Java

Este proyecto contiene una implementación en Java de un árbol AVL (Adelson-Velsky and Landis). Un árbol AVL es un árbol de búsqueda binaria auto-balanceable, lo que significa que mantiene una altura logarítmica, asegurando así que las operaciones básicas como búsqueda, inserción y eliminación tengan una complejidad temporal de $O(\log n)$ en el peor caso.

### Video en YouTube 
[Video] (https://youtu.be/ApUgZQg7cH8)

## Funcionamiento

El programa permite al usuario insertar números enteros de forma interactiva en un árbol AVL. Después de cada inserción, el programa imprime una representación visual del árbol en la terminal. El árbol se balancea automáticamente mediante rotaciones (rotación simple izquierda, rotación simple derecha, rotación doble izquierda-derecha y rotación doble derecha-izquierda) cuando se detecta un desbalance, manteniendo así su propiedad de auto-balanceo.

El programa finaliza cuando el usuario ingresa la palabra "exit" o el número "-1".

## Estructura del Código

El proyecto se compone de tres clases principales:

* **`Node`:**
    * Representa un nodo individual en el árbol AVL.
    * Contiene los siguientes atributos:
        * `valor`: El valor entero almacenado en el nodo.
        * `izquierda`: Una referencia al hijo izquierdo del nodo.
        * `derecha`: Una referencia al hijo derecho del nodo.
        * `altura`: La altura del nodo en el árbol. La altura de un nodo hoja es 0, y la altura de un nodo interno es 1 más la altura máxima de sus hijos.
    * El constructor `Node(int valor)` inicializa un nuevo nodo con el valor proporcionado y establece su altura en 0.

* **`AVLTree`:**
    * Contiene la lógica para la manipulación del árbol AVL.
    * Atributos principales:
        * `raiz`: El nodo raíz del árbol.
    * Métodos importantes:
        * `getAltura(Node nodo)`: Retorna la altura de un nodo (o -1 si el nodo es nulo).
        * `getFactorBalance(Node nodo)`: Calcula el factor de balance de un nodo, que es la diferencia entre la altura de su subárbol izquierdo y la de su subárbol derecho. Un árbol AVL está balanceado si el factor de balance de cada nodo está entre -1 y 1.
        * `actualizarAltura(Node nodo)`: Actualiza la altura de un nodo basándose en la altura de sus hijos.
        * `rotarDerecha(Node y)`: Realiza una rotación simple a la derecha en el subárbol con raíz en `y`.
        * `rotarIzquierda(Node x)`: Realiza una rotación simple a la izquierda en el subárbol con raíz en `x`.
        * `insertar(Node nodo, int valor)`: Inserta un nuevo valor en el árbol de forma recursiva. Después de la inserción, verifica si el árbol se ha desbalanceado y realiza las rotaciones necesarias para mantener el balance.
        * `printTree(Node raiz)`: Imprime una representación visual del árbol en la terminal.
        * `imprimir(Node nodo, int nivel)`: Un método auxiliar recursivo utilizado por `printTree` para realizar la impresión formateada del árbol.

* **`Main`:**
    * Contiene el método `main`, el punto de entrada del programa.
    * Crea una instancia de `AVLTree`.
    * Utiliza la clase `Scanner` para leer la entrada del usuario.
    * Permite al usuario ingresar números enteros para ser insertados en el árbol AVL.
    * Después de cada inserción exitosa, llama al método `printTree` para mostrar la estructura actual del árbol.
    * El programa termina cuando el usuario ingresa "exit" o "-1".
    * Incluye manejo de excepciones para entradas no válidas (no enteros).

## Aspectos Importantes del Código

* **Auto-Balanceo:** La característica principal del árbol AVL es su capacidad de auto-balancearse después de cada inserción. Esto se logra mediante la verificación del factor de balance de cada nodo y la aplicación de rotaciones si el factor de balance se vuelve mayor que 1 o menor que -1.
* **Factor de Balance:** El factor de balance es crucial para determinar si un subárbol está desequilibrado. Un factor de balance de 2 o -2 indica la necesidad de una rotación.
* **Tipos de Rotaciones:** El código implementa cuatro tipos de rotaciones para mantener el balance:
    * **Rotación Simple a la Derecha (LL):** Se aplica cuando el desbalance ocurre en el subárbol izquierdo del hijo izquierdo.
    * **Rotación Simple a la Izquierda (RR):** Se aplica cuando el desbalance ocurre en el subárbol derecho del hijo derecho.
    * **Rotación Doble Izquierda-Derecha (LR):** Se aplica cuando el desbalance ocurre en el subárbol derecho del hijo izquierdo.
    * **Rotación Doble Derecha-Izquierda (RL):** Se aplica cuando el desbalance ocurre en el subárbol izquierdo del hijo derecho.
* **Representación Visual:** La función `printTree` proporciona una forma sencilla de visualizar la estructura del árbol en la terminal, donde la indentación indica la profundidad de los nodos.

## Explicación de Entradas y Salidas

### Entradas

El programa espera que el usuario ingrese números enteros a través de la terminal. Cada número ingresado (seguido de la tecla Enter) se intentará insertar en el árbol AVL.

* **Entrada Válida:** Cualquier número entero. Este número se insertará en el árbol, manteniendo la propiedad de árbol de búsqueda binaria y realizando rotaciones si es necesario para mantener el balance AVL.
* **Entrada de Terminación:**
    * `exit` (sin distinción de mayúsculas o minúsculas): Al ingresar "exit", el programa dejará de solicitar entradas y finalizará.
    * `-1`: Al ingresar "-1", el programa también dejará de solicitar entradas y finalizará.
* **Entrada Inválida:** Cualquier entrada que no pueda ser convertida a un número entero (por ejemplo, letras, símbolos, cadenas de texto). En este caso, el programa mostrará un mensaje de error: "Entrada inválida. Por favor, ingrese un número entero o 'exit'." y volverá a solicitar una entrada.

### Salidas

Después de cada inserción válida, el programa imprimirá una representación visual del árbol AVL actual en la terminal. La salida muestra los nodos del árbol dispuestos de forma que se pueda apreciar su estructura jerárquica:

* **Representación del Árbol:** Los nodos se imprimen con una cierta cantidad de espacios de indentación a la izquierda, lo que indica su nivel de profundidad en el árbol. El nodo más a la derecha en la salida visual suele ser el nodo más profundo en el subárbol derecho, y viceversa para el subárbol izquierdo. La raíz del árbol tendrá la menor indentación.

    ```
        40
    20
        30
    ```

    En este ejemplo simplificado, `10` sería la raíz, `20` su hijo derecho, `30` el hijo derecho de `20`, y `25` el hijo izquierdo de `20`, mientras que `40` sería un hijo del subárbol derecho (la orientación real puede variar ligeramente según la implementación de la impresión).

* **Mensajes Informativos:**
    * `Ingrese números enteros para insertar en el árbol AVL (o 'exit' para terminar):`: Mensaje inicial que solicita la entrada del usuario.
    * `Árbol AVL:`: Mensaje que precede a la impresión visual del árbol después de cada inserción.
    * `Entrada inválida. Por favor, ingrese un número entero o 'exit'.`: Mensaje que se muestra cuando la entrada del usuario no es un entero válido.
    * `Programa terminado.`: Mensaje que se muestra al finalizar la ejecución del programa.
* **Ejemplo de Ejecucion en Visual Studio Code**
![Imagen Ejemplo](/arbolAVLJava.png)
