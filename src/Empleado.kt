/**
 * Clase que representa a un empleado, heredando de la clase Persona.
 *
 * @param nombre Nombre del empleado.
 * @param edad Edad del empleado.
 * @param salarioBase Salario base del empleado (número).
 * @param porcentajeImpuestos Porcentaje de impuestos aplicado al salario base (número).
 */
open class Empleado(nombre: String, edad: Int, salarioBase: Number, porcentajeImpuestos: Number = 10.0) :
    Persona(nombre, edad) {

    /**
     * Salario base del empleado (almacenado como Double).
     */
    var salarioBase: Double = salarioBase.toDouble()
        set(value) {
            require(salarioBase > 0.0) { "El salario base no puede ser un valor negativo." }
            field = value
        }

    /**
     * Inicializador que valida las condiciones iniciales del salario base y porcentaje de impuestos.
     */
    init {
        require(salarioBase.toDouble() > 0.0) { "El salario base no puede ser un valor negativo." }
        require(porcentajeImpuestos.toDouble() > 0.0) { "El porcentaje de impuestos no puede ser un valor negativo." }
    }

    /**
     * Porcentaje de impuestos aplicado al salario base (almacenado como Double).
     */
    open var porcentajeImpuestos: Double = porcentajeImpuestos.toDouble()
        set(value) {
            require(porcentajeImpuestos > 0.0) { "El porcentaje de impuestos no puede ser un valor negativo." }
            field = value
        }

    /**
     * Función que calcula el salario neto del empleado después de aplicar impuestos.
     *
     * @return Salario neto calculado.
     */
    open fun calcularSalario(): Double {
        return (salarioBase - (salarioBase * (porcentajeImpuestos / 100)))
    }

    /**
     * Función que representa la acción de trabajar del empleado.
     *
     * @return Mensaje indicando que el empleado está trabajando.
     */
    private fun trabajar(): String {
        return "$nombre está trabajando en la empresa."
    }


    /**
     * Sobrescritura de la función toString para obtener una representación de cadena del empleado.
     *
     * @return Cadena que muestra la información de la persona y el empleado.
     */
    override fun toString(): String {
        return ("${super.toString()}Tiene un salario base de: $salarioBase, con un neto de ${calcularSalario()}. ${trabajar()}")
    }

}