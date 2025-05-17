import java.util.Scanner;

class Node {
    int valor;
    Node izquierda;
    Node derecha;
    int altura;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 0;
    }
}

class AVLTree {
    Node raiz;

    public int getAltura(Node nodo) {
        if (nodo == null) {
            return -1;
        }
        return nodo.altura;
    }

    public int getFactorBalance(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    public void actualizarAltura(Node nodo) {
        if (nodo != null) {
            nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
        }
    }

    public Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    public Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    public Node insertar(Node nodo, int valor) {
        if (nodo == null) {
            return new Node(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertar(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertar(nodo.derecha, valor);
        } else {
            return nodo; // Duplicados no permitidos
        }

        actualizarAltura(nodo);

        int balance = getFactorBalance(nodo);

        // Rotaciones LL
        if (balance > 1 && valor < nodo.izquierda.valor) {
            return rotarDerecha(nodo);
        }

        // Rotaciones RR
        if (balance < -1 && valor > nodo.derecha.valor) {
            return rotarIzquierda(nodo);
        }

        // Rotaciones LR
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        // Rotaciones RL
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public void printTree(Node raiz) {
        imprimir(raiz, 0);
    }

    private void imprimir(Node nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        imprimir(nodo.derecha, nivel + 1);

        for (int i = 0; i < 4 * nivel; i++) {
            System.out.print(" ");
        }
        System.out.println(nodo.valor);

        imprimir(nodo.izquierda, nivel + 1);
    }
}

public class Main {

    public static void main(String[] args) {
        AVLTree arbol = new AVLTree();
        Scanner scanner = new Scanner(System.in);
        int valor;

        System.out.println("Ingrese números enteros para insertar en el árbol AVL (o 'exit' para terminar):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                valor = Integer.parseInt(input);
                if (valor == -1){
                    break;
                }
                arbol.raiz = arbol.insertar(arbol.raiz, valor);
                System.out.println("Árbol AVL:");
                arbol.printTree(arbol.raiz);
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero o 'exit'.");
            }
        }

        System.out.println("Programa terminado.");
        scanner.close();
    }
}