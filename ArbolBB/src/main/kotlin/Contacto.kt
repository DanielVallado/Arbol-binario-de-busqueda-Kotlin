data class Contacto(private var _nombre: String, private var _apellido: String, private var _correo: String) {
    var nombre: String
        get() = _nombre
        set(value) {
            _nombre = value
        }

    var apellido: String
        get() = _apellido
        set(value) {
            _apellido = value
        }

    var correo: String
        get() = _correo
        set(value) {
            _correo = value
        }

    override fun toString(): String {
        return "Nombre: $_nombre $_apellido | Correo: $_correo')"
    }
}
