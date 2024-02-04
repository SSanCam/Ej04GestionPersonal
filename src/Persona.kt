/**
 * Clase que representa a una persona con nombre y edad.
 *
 * @property nombre Nombre de la persona.
 * @property edad Edad de la persona.
 */
open class Persona(nombre: String, edad: Int) {
    /**
     * Propiedad privada que almacena la edad de la persona.
     * Se puede acceder desde las clases derivadas, pero su set es privado.
     */
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

    /**
     * Función que valida que el nombre no esté en blanco.
     * Lanza una excepción si el nombre es una cadena vacía o nula.
     */
    private fun requireNombre() {
        require(nombre.isNotBlank()) { "El campo nombre no puede quedar en blanco." }
    }

    /**
     * Función que valida que la edad sea no negativa.
     * Lanza una excepción si la edad es negativa.
     */
    private fun requireEdad() {
        require(edad >= 0) { "La edad no puede ser negativa" }
    }

    /**
     * Función que celebra el cumpleaños de la persona, incrementando la edad.
     *
     * @return Mensaje de celebración.
     */
    fun celebrarCumple(): String {
        return ("Feliz cumpleaños $nombre! Ahora tienes ${++edad} años.")
    }

    /**
     * Sobrescritura de la función toString para obtener una representación de cadena de la persona.
     *
     * @return Cadena que muestra el nombre y la edad de la persona.
     */
    override fun toString(): String {
        return ("$nombre tiene $edad años. ")
    }

}