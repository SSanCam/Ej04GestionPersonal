fun main() {
    // Instancia de Persona
    val persona1 = Persona("Carlos", 30)
    println(persona1)

    // Instancia de Empleado
    val empleado1 = Empleado("Luis", 28, 3000.0)
    println(empleado1)

    // Instancias de Gerente
    val gerenteExento = Gerente("Laura", 45, 6000.0, 25.0, 1000.0, true)
    println(gerenteExento)

    val gerenteNoExento = Gerente("Miguel", 50, 7000.0, 30.0, 1500.0, false)
    println(gerenteNoExento)

    empleado1.celebrarCumple().also { println("${empleado1.nombre} Ha cumplido añitos. Ahora tiene ${empleado1.edad}") }
}


