class Gerente(
    nombre: String,
    edad: Int,
    salarioBase: Double,
    porcentajeImpuestos: Double,
    bonus: Double,
    exentoImpuestos: Boolean = false
) : Empleado(nombre, edad, salarioBase, porcentajeImpuestos) {

    private var bonus: Double = bonus
        set(value) {
            require(bonus >= 0.0) { "El valor de bonus no puede ser inferior a 0." }
            field = value
        }

    private var exentoImpuestos: Boolean = exentoImpuestos
        set(value) {
            require(value) { "El genrente o está o no libre de impuestos." }
            field = value
        }
    fun comprobarImpuestos():String {
        return if (!exentoImpuestos) "Si." else "No."
    }
    override var porcentajeImpuestos: Double = porcentajeImpuestos
        set(value) {
            field = if (exentoImpuestos) 0.0 else 33.99
        }

    override fun calcularSalario(): Double {
        return if (!exentoImpuestos) {
            salarioBase + bonus
        } else {
            (salarioBase - (salarioBase * (porcentajeImpuestos/100))) + bonus
        }
    }

    private fun administrar(): String {
        return "$nombre está administrando la empresa."
    }

    override fun toString(): String {
        return "${super.toString()} - Bonus: $bonus, Exento de impuestos: ${comprobarImpuestos()} ${administrar()}"
    }


}