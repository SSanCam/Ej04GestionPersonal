open class Empleado(nombre: String, edad: Int, salarioBase: Number, porcentajeImpuestos: Number = 10.0) : Persona(nombre, edad) {

    var salarioBase: Double = salarioBase.toDouble()
        set(value) {
            require(salarioBase > 0.0) { "El salario base no puede ser un valor negativo." }
            field = value
        }

    init {
        require(salarioBase.toDouble() > 0.0) { "El salario base no puede ser un valor negativo." }
        require(porcentajeImpuestos.toDouble() > 0.0) { "El porcentaje de impuestos no puede ser un valor negativo." }
    }

    open var porcentajeImpuestos: Double = porcentajeImpuestos.toDouble()
        set(value) {
            require(porcentajeImpuestos > 0.0) { "El porcentaje de impuestos no puede ser un valor negativo." }
            field = value
        }

    open fun calcularSalario(): Double{
        return (salarioBase - (salarioBase * (porcentajeImpuestos/100)))
    }

    private fun trabajar(): String{
        return "$nombre está trabajando en la empresa."
    }

    override fun toString(): String {
        return ("${super.toString()}Tiene un salario base de: $salarioBase, con un neto de ${calcularSalario()}. ${trabajar()}")
    }

}