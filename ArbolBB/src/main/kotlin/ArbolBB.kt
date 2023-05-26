class ArbolBB {
    private var raiz: NodoBB? = null

    fun insertar(contacto: Contacto) {
        raiz = insertarNodo(raiz, contacto)
    }

    private fun insertarNodo(nodo: NodoBB?, contacto: Contacto): NodoBB {
        if (nodo == null) {
            return NodoBB(contacto)
        }

        val comparacion = contacto.nombre.compareTo(nodo.valor.nombre)

        if (comparacion == 0) {
            nodo.addContacto(contacto)
        } else if (comparacion < 0) {
            nodo.izquierdo = insertarNodo(nodo.izquierdo, contacto)
        } else {
            nodo.derecho = insertarNodo(nodo.derecho, contacto)
        }

        return nodo
    }

    fun eliminar(contacto: Contacto) {
        raiz = eliminarNodo(raiz, contacto)
    }

    private fun eliminarNodo(nodo: NodoBB?, contacto: Contacto): NodoBB? {
        if (nodo == null) {
            return null
        }

        val comparacion = contacto.nombre.compareTo(nodo.valor.nombre)

        if (comparacion < 0) {
            nodo.izquierdo = eliminarNodo(nodo.izquierdo, contacto)
        } else if (comparacion > 0) {
            nodo.derecho = eliminarNodo(nodo.derecho, contacto)
        } else {
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null
            } else if (nodo.izquierdo == null) {
                return nodo.derecho
            } else if (nodo.derecho == null) {
                return nodo.izquierdo
            } else {
                val sucesor = encontrarSucesor(nodo.derecho!!)
                nodo.valor = sucesor.valor
                nodo.derecho = eliminarNodo(nodo.derecho, sucesor.valor)
            }
        }

        return nodo
    }

    private fun encontrarSucesor(nodo: NodoBB): NodoBB {
        var actual = nodo
        while (actual.izquierdo != null) {
            actual = actual.izquierdo!!
        }
        return actual
    }

    fun buscar(dato: String): Boolean {
        val contactoBusqueda = Contacto(dato, dato, dato)
        return buscarNodo(raiz, contactoBusqueda)
    }

    private fun buscarNodo(nodo: NodoBB?, contactoBusqueda: Contacto): Boolean {
        if (nodo == null) {
            return false
        }

        val comparacionNombre = contactoBusqueda.nombre.compareTo(nodo.valor.nombre)
        val comparacionApellido = contactoBusqueda.apellido.compareTo(nodo.valor.apellido)
        val comparacionCorreo = contactoBusqueda.correo.compareTo(nodo.valor.correo)

        return if (comparacionNombre == 0 || comparacionApellido == 0 || comparacionCorreo == 0) {
            true
        } else if (comparacionNombre < 0 || comparacionApellido < 0 || comparacionCorreo < 0) {
            buscarNodo(nodo.izquierdo, contactoBusqueda)
        } else {
            buscarNodo(nodo.derecho, contactoBusqueda)
        }
    }

    fun recorrerInorden() {
        recorrerInorden(raiz)
    }

    private fun recorrerInorden(nodo: NodoBB?) {
        if (nodo != null) {
            recorrerInorden(nodo.izquierdo)
            nodo.valores.forEach { contacto ->
                println(contacto)
            }
            recorrerInorden(nodo.derecho)
        }
    }

    fun obtenerElementos(): ArrayList<Contacto> {
        val elementos = ArrayList<Contacto>()
        obtenerElementos(raiz, elementos)
        return elementos
    }

    private fun obtenerElementos(nodo: NodoBB?, elementos: ArrayList<Contacto>) {
        if (nodo != null) {
            obtenerElementos(nodo.izquierdo, elementos)
            elementos.addAll(nodo.valores)
            obtenerElementos(nodo.derecho, elementos)
        }
    }
}
