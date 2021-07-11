import controlador.Materia
import controllers.*
import modelo.cargar
import modelo.consultaPorDni
import modelo.imprimirKardex
import models.*


fun main(){






   // A continucacion se manda a llamar la funcion principal de la Aplicacion
    menu()

}

fun verificarUsuario(user: String, password: String) {
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)

    var mensaje = false

    if(existeUsuario(usuariosCliente,user) || existeCorreo(usuariosCliente,user) || existeNumeroTelefonico(usuariosCliente,user)){
        if(isContraseniaCorrecta(usuariosCliente,password)){
            println("Hola! ${obtenerNombreAmostrar(usuariosCliente,user)}")
            menuInicio()
        }else{
            do {
                println("Revisa tu clave.\n")
                println("Clave")
                val passwordActual = readLine()!!
            }while(!(isContraseniaCorrecta(usuariosCliente,passwordActual)))
            println("Hola! ${obtenerNombreAmostrar(usuariosCliente,user)}")
            menuInicio()
        }
    }else{
        println("Revisa tu e-mail o usuario.\n")
        iniciarSesion()
    }

}

fun menu(){

    val opcion: Int?
    try {


        println("****************MENU***************")
        println("* Por favor selecciona una opcion:*")
        println("*  1- Iniciar sesion alumno:      *")
        println("*  2- Entrar como maestro:        *")
        println("*  3- Crea tu cuenta:             *")
        println("*  4- Salir:                      *")
        println("***********************************")

        println("\nIngresa un digito:")
        opcion = readLine()?.toInt()

    } catch(e: NumberFormatException) {
        println("************************************************************")
        println("La opcion solo acepta valor numerico,es decir del 1 al 4 ")
        println("************************************************************")
        return menu()
    }
    when (opcion) {
        1 -> iniciarSesion()
        2 -> iniciarSesionMaestro()
        3 -> registrarNuevoUsuarioCliente()//funcion para crear un nuevo usuario y cliente
        4 -> print("GRACIAS; REGRESA PRONTO")
    }
}



fun iniciarSesion(){

    println("----------!Hola! Para seguir, ingresa tu teléfono, e-mail o usuario---------:")

    println("Teléfono, e-mail o usuario:")
    val usuarioActual = readLine()!!

    println("Clave:")
    val passwordActual = readLine()!!

    val userValidated = validate(usuarioActual)
    val passValidate = validate(passwordActual)

    if(userValidated&&passValidate) {
        verificarUsuario(usuarioActual, passwordActual)
          //  println("BIENVENID@ $usuarioActual\n")
    }else{
        println("Los campos no pueden estar vacíos \n")
        iniciarSesion()
    }
}

fun iniciarSesionMaestro(){

    println("----------!Hola! Para seguir, ingresa tu teléfono, e-mail o usuario---------:")

    println("Teléfono, e-mail o usuario:")
    val usuarioActual = readLine()!!

    println("Clave:")
    val passwordActual = readLine()!!

    val userValidated = validate(usuarioActual)
    val passValidate = validate(passwordActual)

    if(userValidated&&passValidate) {
        verificarUsuario(usuarioActual, passwordActual)
        //  println("BIENVENID@ $usuarioActual\n")
            menuInicioMaestro()
    }else{
        println("Los campos no pueden estar vacíos \n")
        iniciarSesionMaestro()
    }
}

fun validate(input: String): Boolean{
    if(input.isEmpty()){
        return false
    }
    return true
}

fun menuInicioMaestro() {
    val alumnos: MutableMap<Int, MutableList<Materia>> = mutableMapOf()

    val opcion: Int?

    try {


        println("************      Bienvenido a Icep   ************")
        println("* Por favor selecciona una opcion:               *")
        println("*  1- Agregar alumnos:                           *")
        println("*  2- Consultar alumnos:                         *")
        println("*  3- Chat:                                      *")
        println("*  4- Cerrar sesion:                             *")
        println("*  5- Salir  :                                   *")
        println("**************************************************")
        opcion = readLine()?.toInt()

    } catch (e: NumberFormatException) {
        println("************************************************************")
        println("La opcion solo acepta valor numerico, es decir del 1 al 5 ")
        println("************************************************************")
        return menuInicioMaestro()
    }
    when (opcion) {
        1 -> cargar(alumnos)
        2 -> consultaPorDni(alumnos)
        3 -> println("en mantenimiento")
        4 -> menu()
        5 -> print("GRACIAS; REGRESA PRONTO")
    }
}

fun menuInicio() {
    val alumnos: MutableMap<Int, MutableList<Materia>> = mutableMapOf()

    val opcion: Int?

    try {


        println("************      Bienvenido a Icep   ************")
        println("* Por favor selecciona una opcion:               *")
        println("*  1- Ver contenido:                             *")
        println("*  2- Consultar kardex:                         *")
        println("*  3- Chat:                                      *")
        println("*  4- Cerrar sesion:                             *")
        println("*  5- Salir  :                                   *")
        println("**************************************************")
        opcion = readLine()?.toInt()

    } catch (e: NumberFormatException) {
        println("************************************************************")
        println("La opcion solo acepta valor numerico, es decir del 1 al 5 ")
        println("************************************************************")
        return menuInicioMaestro()
    }
    when (opcion) {
        1 -> println("Aun no se ha cargado material")
        2 -> imprimirKardex(alumnos)
        3 -> println("en mantenimiento")
        4 -> menu()
        5 -> print("GRACIAS; REGRESA PRONTO")
    }
}


