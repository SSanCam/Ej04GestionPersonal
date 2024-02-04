/**
 * Clase que representa a un gerente, heredando de la clase Empleado.
 *
 * @param nombre Nombre del gerente.
 * @param edad Edad del gerente.
 * @param salarioBase Salario base del gerente.
 * @param porcentajeImpuestos Porcentaje de impuestos aplicado al salario base.
 * @param bonus Bono adicional para el gerente.
 * @param exentoImpuestos Indica si el gerente está exento de impuestos (por defecto, falso).
 */
class Gerente(
    nombre: String,
    edad: Int,
    salarioBase: Double,
    porcentajeImpuestos: Double,
    bonus: Double,
    exentoImpuestos: Boolean = false
) : Empleado(nombre, edad, salarioBase, porcentajeImpuestos) {

    /**
     * Bono adicional para el gerente (almacenado como Double).
     */
    private var bonus: Double = bonus
        set(value) {
            require(bonus >= 0.0) { "El valor de bonus no puede ser inferior a 0." }
            field = value
        }

    /**
     * Indica si el gerente está exento de impuestos.
     */
    private var exentoImpuestos: Boolean = exentoImpuestos
        set(value) {
            require(value) { "El genrente o está o no libre de impuestos." }
            field = value
        }

    /**
     * Función que comprueba si el gerente está exento de impuestos.
     *
     * @return Cadena que indica si el gerente está exento de impuestos.
     */
    fun comprobarImpuestos(): String {
        return if (!exentoImpuestos) "Si." else "No."
    }

    /**
     * Porcentaje de impuestos aplicado al salario base (almacenado como Double).
     */
    override var porcentajeImpuestos: Double = porcentajeImpuestos
        set(value) {
            field = if (exentoImpuestos) 0.0 else 33.99
        }

    /**
     * Función que calcula el salario neto del gerente.
     *
     * @return Salario neto calculado.
     */
    override fun calcularSalario(): Double {
        return if (!exentoImpuestos) {
            salarioBase + bonus
        } else {
            (salarioBase - (salarioBase * (porcentajeImpuestos / 100))) + bonus
        }
    }

    /**
     * Función que representa la acción de administrar del gerente.
     *
     * @return Mensaje indicando que el gerente está administrando la empresa.
     */

    private fun administrar(): String {
        return "$nombre está administrando la empresa."
    }

    /**
     * Sobrescritura de la función toString para obtener una representación de cadena del gerente.
     *
     * @return Cadena que muestra la información de la persona, el empleado y el gerente.
     */

    override fun toString(): String {
        return "${super.toString()} - Bonus: $bonus, Exento de impuestos: ${comprobarImpuestos()} ${administrar()}"
    }


}