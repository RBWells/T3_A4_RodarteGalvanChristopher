import java.util.Scanner;
class Nodo {
    private int dato;
    private Nodo nodoSiguiente;

    public Nodo(int dato) {
        this.dato = dato;
    }

    // Getters y setters=====================================
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    // ------------------------------------------------------
    @Override
    public String toString() {
        return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
    }
}

/*
 * OPERACIONES PARA LISTA ENLAZADA
 * 1) Crear
 * 2) Agregar
 * 2.1) Al inicio
 * 2.2) Al final
 * 2.3) En posicion especifica
 * 
 * 3) Eliminar
 * 3.1) Al inicio
 * 3.2) Al final
 * 3.3) En posicion especifica (Dato Especifico)
 * 
 * 4) Mostrar Datos (Recorrer)
 * 
 * 
 * 
 */
class ListaEnlazada {
    Nodo nodoInicio, nodoFin;

    // 1) Crear
    public ListaEnlazada() {
        nodoInicio = null;
        nodoFin = null;
    }

    // 2.1) Agregar Al inicio
    public void agregarElementoAlInicio(int dato) {

        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInicio == null) { // Lista Vacia
            // System.out.println("La lista esta vacia");
            nodoInicio = nodoFin = nuevoNodo;
        } else {// Yuea existen nodos o elementos en la lista
            nuevoNodo.setNodoSiguiente(nodoInicio);
            nodoInicio = nuevoNodo;
        }
    }

    public void agregarElementoAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInicio == null) {
            nodoInicio = nodoFin = nuevoNodo;
        } else {
            nodoFin.setNodoSiguiente(nuevoNodo);
            nodoFin = nuevoNodo;

        }
    }

    // Eliminar Elemento al inicio
    public void eliminarElementoAlInicio() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que nunca a existido");
        } else {
            nodoInicio = nodoInicio.getNodoSiguiente();
        }
    }

    // Eliminar elemento al Final
    public void eleminarElementoAlFinal() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que no ha sido ingresado");
        } else {
            nodoFin = nodoInicio.getNodoSiguiente();
        }
    }

    // Eliminar Elemento al Final
    public void eliminarElementoAlFinal() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que no existe");
        } else if (nodoInicio == nodoFin) {
            // La lista tiene un solo nodo
            nodoInicio = null;
            nodoFin = null;
        } else {
            Nodo nodoAnterior = nodoInicio;
            Nodo nodoPosterior = nodoInicio.getNodoSiguiente();

            while (nodoPosterior.getNodoSiguiente() != null) {
                nodoAnterior = nodoPosterior;
                nodoPosterior = nodoPosterior.getNodoSiguiente();
            }
            nodoAnterior.setNodoSiguiente(null);
            nodoFin = nodoAnterior;
        }
    }

    // Elimar elemento buscado
    public void eliminarDatoEspecifico(int dataFind) {

        // Si la lista esta vacia
        if (nodoInicio == null) {
            System.out.println("Lista vacia");
        } else if (dataFind == nodoInicio.getDato()) {
            System.out.println("Dato encontrado en el primer NODO: ");
            nodoInicio = nodoInicio.getNodoSiguiente();
            System.out.println("Elemento eliminado correctamente...");
        } else {
            Nodo anterior, nodoQueSigue;
            anterior = nodoInicio;
            nodoQueSigue = nodoInicio.getNodoSiguiente();

            // Buscar el dato mientras que no se acabe la lista
            while (dataFind != nodoQueSigue.getDato() && nodoQueSigue.getNodoSiguiente() != null) {
                anterior = nodoQueSigue;
                nodoQueSigue = anterior.getNodoSiguiente();

            }
            if (dataFind == nodoQueSigue.getDato()) {
                anterior.setNodoSiguiente((nodoQueSigue.getNodoSiguiente()));
                nodoQueSigue = nodoQueSigue.getNodoSiguiente();
                System.out.println("Nodo eliminado correctamente");
            } else {
                System.out.println("No se encontro");
            }

        }
    }
    public void eliminarPosicionEspecifica(int pos){
       if (nodoInicio == null) {
            System.out.println("La lista esta vacia, no puedes eliminar");

       }else if (pos<0) {
        System.out.println("Esa posicion no es valida");
       }else if(pos ==0){
            nodoInicio=nodoInicio.getNodoSiguiente();

            if (nodoInicio==null) {
                nodoFin=null;
            }
            System.out.println("Nodo eliminado...");
       }
       Nodo anterior=nodoInicio;
       Nodo nodoSiguiente=nodoInicio.getNodoSiguiente();
       int contador =1;

       while (nodoSiguiente !=null && contador<pos) {
        anterior=nodoSiguiente;
        nodoSiguiente=nodoSiguiente.getNodoSiguiente();
        contador++;
       }
       if (nodoSiguiente == null) {
        System.out.println("Esa posicion no existe en la lista");
       }
       anterior.setNodoSiguiente(nodoSiguiente.getNodoSiguiente());

       if (nodoSiguiente==nodoFin) {
        nodoFin=anterior;
       }
       System.out.println("Se ha eliminado el nodo de la listA");
    }

    // 4) Mostrar Elementos
    public void mostrarElementos() {
        Nodo NodoActual = nodoInicio;

        while (NodoActual != null) {
            System.out.print("[ " + NodoActual.getDato() + " ]===>");
            NodoActual = NodoActual.getNodoSiguiente();
        }
        System.out.println();
    }

}
public class PruevaListaEnlazada{
    public static void main(String[] args) throws Exception {
        Scanner nrg=new Scanner(System.in);
       ListaEnlazada le = new ListaEnlazada();
       int op;

       do {
        System.out.println("== MENU DE LISTAS ==");
        System.out.println("1. Agregar elemento al inicio");
        System.out.println("2. Agregar elemento al final");
        System.out.println("3. Eliminar elemento al inicio");
        System.out.println("4. Eliminar elemento al final");
        System.out.println("5. Eliminar dato especifico");
        System.out.println("6. Eliminar elemento en posicion especifica");
        System.out.println("7. Mostrar elementos");
        System.out.println("-----------------------------------------------");
        System.out.println("0. Salir.....");
        op=nrg.nextInt();

        switch (op) {
            case 1:
                System.out.println("Dime que elemento quieres ingresar al inicio");
                int e=nrg.nextInt();
                le.agregarElementoAlInicio(e);
                break;
            case 2:
                System.out.println("Dime que elemento quieres ingresar al final");
                int ef=nrg.nextInt();
                le.agregarElementoAlFinal(ef);
                break;
            case 3:
                le.eliminarElementoAlInicio();
                break;
            case 4:
                le.eliminarElementoAlFinal();
                break;
            case 5:
                System.out.println("Que dato quieres eliminar");
                int dato=nrg.nextInt();
                le.eliminarDatoEspecifico(dato);
                break;
            case 6:
                System.out.println("Dime la posicion que quieres eliminar");
                int pos=nrg.nextInt();
                le.eliminarPosicionEspecifica(pos);
                break;
            case 7:
                le.mostrarElementos();
                break;
            case 0:
                System.out.println("Saliste....");
                break;
            default:
                System.out.println("Esa no es una opsion valida");
                break;
        }
       } while (op!=0);
       nrg.close();
    }
}
