fun main() {
    val arbol = ArbolBB()

    arbol.insertar(Contacto("Daniel", "Vallado", "danievallado@gmail.com"))
    arbol.insertar(Contacto("Ana", "González", "ana.gonzalez@example.com"))
    arbol.insertar(Contacto("Pedro", "López", "pedro.lopez@example.com"))
    arbol.insertar(Contacto("María", "Martínez", "maria.martinez@example.com"))
    arbol.insertar(Contacto("María", "Martínez", "maria.martinez@example.com"))
    arbol.insertar(Contacto("Carlos", "Sánchez", "carlos.sanchez@example.com"))
    arbol.insertar(Contacto("Laura", "García", "laura.garcia@example.com"))
    arbol.insertar(Contacto("Laura", "García", "laura.garcia@example.com"))
    arbol.insertar(Contacto("Juan", "Hernández", "juan.hernandez@example.com"))
    arbol.insertar(Contacto("Sofía", "Pérez", "sofia.perez@example.com"))
    arbol.insertar(Contacto("Sofía", "Pérez", "sofia.perez@example.com"))
    arbol.insertar(Contacto("Luis", "Ramírez", "luis.ramirez@example.com"))
    arbol.insertar(Contacto("Luis", "Ramírez", "luis.ramirez@example.com"))
    arbol.insertar(Contacto("Patricia", "Torres", "patricia.torres@example.com"))

    println("Buscar contacto: " + arbol.buscar("Daniel"))

    println("\nElementos leídos inorden: ")
    arbol.recorrerInorden()

    val elementosArbol = arbol.obtenerElementos()
    println("\nElementos obtenidos del árbol: ")
    for (elemento in elementosArbol) {
        println(elemento)
    }
}