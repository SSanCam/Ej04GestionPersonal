open class Persona(nombre: String, edad: Int) {
    var edad: Int = edad
        private set(value) {
            requireEdad()
            field = value
        }

    var nombre: String = nombre
        private set(value) {
            requireNombre()
            field = value
        }

    private fun requireNombre(){
        require(nombre.isNotBlank()) { "El campo nombre no puede quedar en blanco." }
    }
    private fun requireEdad() {
        require(edad >= 0) { "La edad no puede ser negativa" }
    }

    fun celebrarCumple(): String{
        return("Feliz cumpleaños $nombre! Ahora tienes ${++edad} años.")
    }
    override fun toString(): String {
        return ("$nombre tiene $edad años. ")
    }

}