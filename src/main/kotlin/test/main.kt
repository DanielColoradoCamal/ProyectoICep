package test

import controlador.Materia
import modelo.cargar
import modelo.consultaPorDni
import modelo.imprimirKardex

fun main(args: Array<String>) {
    val alumnos: MutableMap<Int, MutableList<Materia>> = mutableMapOf()
    cargar(alumnos)
    imprimirKardex(alumnos)
    consultaPorDni(alumnos)
}