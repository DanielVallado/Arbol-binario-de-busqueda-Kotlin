data class NodoBB(private var _valor: Contacto) {
    private var _valores: ArrayList<Contacto> = ArrayList()
    private var _izquierdo: NodoBB? = null
    private var _derecho: NodoBB? = null

    init {
        _valores.add(_valor)
    }

    fun addContacto(contacto: Contacto) {
        _valores.add(contacto)
    }

    var valores: ArrayList<Contacto>
        get() = _valores
        set(valores) {
            _valores = valores
        }

    var valor: Contacto
        get() = _valor
        set(value) {
            _valor = value
        }

    var izquierdo: NodoBB?
        get() = _izquierdo
        set(value) {
            _izquierdo = value
        }

    var derecho: NodoBB?
        get() = _derecho
        set(value) {
            _derecho = value
        }
}
