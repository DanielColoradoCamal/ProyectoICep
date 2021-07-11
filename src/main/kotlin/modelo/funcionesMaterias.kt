package modelo

import controlador.DataAlumnos
import controlador.Materia
import menuInicio



fun alumnosDatos(datosAlumnos: MutableMap<Int,DataAlumnos>) {


    datosAlumnos[1234] = DataAlumnos("Daniel","Colorado", 3131415723,"daniel@icep.edu","Ingenieria en sistemas")
    datosAlumnos[1235] = DataAlumnos("Juan","Colorado",3131415724,"juan@icep.edu","Ingenieria en sistemas")


}

fun cargar(alumnos: MutableMap<Int, MutableList<Materia>>) {
    print("Cuantos alumnos cargará ?:")
    val cant = readLine()!!.toInt()
    for(i in 1..cant) {
        print("Ingrese dni:")
        val dni = readLine()!!.toInt()
        val listaMaterias = mutableListOf<Materia>()
        do {
            print("Ingrese materia del alumno:")
            val nombre = readLine()!!
            print("Ingrese nota:")
            val nota = readLine()!!.toInt()
            listaMaterias.add(Materia(nombre, nota))

            print("Ingrese otra nota (si/no):")
            val opcion = readLine()!!
        } while (opcion == "si")
        alumnos[dni] = listaMaterias

    }


}

fun mostrarPerfil(alumnos: MutableMap<Int, MutableList<Materia>>) {

    var nombre = ""
    val apellido = ""
    val tenefono = 0

    println("Ingresa nombre del alumno: ")
    nombre = readLine()!!.toString()


}

fun imprimirKardex(alumnos: MutableMap<Int, MutableList<Materia>>) {
    for((dni, listaMaterias) in alumnos) {
        println("Dni del alumno: $dni")
        for(materia in listaMaterias) {
            println("Materia: ${materia.nombre}")
            println("Nota: ${materia.nota}")
        }
        println()
    }

    println("Regresar al Inicio")
    println("Inicio : s  Salir: cualquier tecla")
    val opcion = readLine().toString()

    when (opcion) {
        "s"-> menuInicio()
        else -> println("Gracias,sesion cerrada")
    }
}



fun consultaPorDni(alumnos: MutableMap<Int, MutableList<Materia>>) {
    print("Alumno ingresa tu dni:")
    val dni = readLine()!!.toInt()
    if (dni in alumnos) {
        println("Cursa las siguentes materias")
        val lista = alumnos[dni]
        if (lista!=null)
            for((nombre, nota) in lista) {
                println("Nombre de materia: $nombre")
                println("Nota: $nota")
            }
    }

    println("Regresar al Inicio")
    println("Inicio : s  Salir: cualquier tecla")
    val opcion = readLine().toString()

    when (opcion) {
        "s"-> menuInicio()
        else -> println("Gracias,sesion cerrada")
    }
}