package controllers

import iniciarSesion
import menuInicio
import models.Cliente
import models.Usuario
import validate
import java.util.regex.Matcher
import java.util.regex.Pattern


fun cargarUsuariosClientes(usuariosClientes: MutableMap<Usuario, Cliente>): MutableMap<Usuario, Cliente> {
    val usuarioDaniel = Usuario(1, "Daniel","toor")
    val daniel =Cliente(usuarioDaniel.getIdUsuario(),1,"Daniel","Colorado","dani.colorado@icep.edu")
    usuarioDaniel.setUsuario(generarUsuario(daniel.getNombre(),daniel.getApellidos()))
   // println("User: ${usuarioBeto.getUsuario()}")
    val usuarioICep = Usuario(2, "Icep","toor")
    val icep =Cliente(usuarioICep.getIdUsuario(),2,"Icep","tecoman","maestro@icep.edu")
    usuarioICep.setUsuario(generarUsuario(icep.getNombre(),icep.getApellidos()))
    //println("USer: ${usuarioJose.getUsuario()}")
    var usuariosMap: MutableMap<Int, Usuario> = mutableMapOf()
    var clientesMap: MutableMap<Int,Cliente> = mutableMapOf()
    usuariosMap[usuarioDaniel.getIdUsuario()] = usuarioDaniel
    usuariosMap[usuarioICep.getIdUsuario()] = usuarioICep

    clientesMap[daniel.getIdCliente()] = daniel
    clientesMap[icep.getIdCliente()] = icep

    usuariosClientes.put(usuarioDaniel,daniel)
    usuariosClientes.put(usuarioICep,icep)

    /*
    * User: SAB2021
    * User: CACJOJ2021
     */
     return usuariosClientes
}

fun registrarNuevoUsuarioCliente(){
    fun creandoNuevoUsuario(nuevoUsuario:Usuario, nuevoCliente:Cliente, usuariosCliente: MutableMap<Usuario, Cliente>){
        println("Creando usuario........")
        nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
        nuevoCliente.mostrarDatosNuevoUsuario(nuevoUsuario,nuevoCliente)
        usuariosCliente.put(nuevoUsuario,nuevoCliente)
        menuInicio()
    }
    var usuariosCliente: MutableMap<Usuario, Cliente> = mutableMapOf()
    usuariosCliente =  cargarUsuariosClientes(usuariosCliente)
    println("----------Completa tus datos---------:\n")
    var nombre:String =""
    var apellidos:String =""
    var email:String =""
    var clave:String =""
    do {
        println("Nombre:")
        nombre = readLine()!!
    }while(!(validate(nombre)))
    do {
        println("Apellidos:")
        apellidos = readLine()!!
    }while(!(validate(apellidos)))
    do {
        println("Email:")
        email = readLine()!!
    }while(!(validate(email)))

    do {
        println("Clave:")
        clave = readLine()!!
    }while(!(validate(clave)))

    /*Inicio instanciando nuevos objetos*/
     var nuevoUsuario = Usuario(usuariosCliente.size+1, "",clave)
     var nuevoCliente =Cliente(nuevoUsuario.getIdUsuario(),usuariosCliente.size+1,nombre,apellidos,email)
    nuevoUsuario.setUsuario(generarUsuario(nuevoCliente.getNombre(),nuevoCliente.getApellidos()))
    /*Fin instanciando nuevos objetos*/

    if(!isEmailValid(email) || existeCorreo(usuariosCliente, email)) {
        email = verificacionDelEmailDelNuevoUSuario(usuariosCliente, email)
        nuevoCliente.setEmail(email)
        creandoNuevoUsuario(nuevoUsuario, nuevoCliente, usuariosCliente)
    }else{
            creandoNuevoUsuario(nuevoUsuario,nuevoCliente,usuariosCliente)
    }
   println("Tamanio de la dataClass de los usuarios actualmente: ${usuariosCliente.size}")
}

fun verificacionDelEmailDelNuevoUSuario(usuariosCliente :MutableMap<Usuario, Cliente>,emailCorrecto:String):String {
    var email:String = ""
    email = emailCorrecto
    if (!isEmailValid(email)) {
        do {
            println("Usa el formato nombre@ejemplo.com en tu email")
            println("Email:")
            email = readLine()!!
        } while (!isEmailValid(email))
        if (existeCorreo(usuariosCliente, email)) {
            println("*** Ya existe una cuenta con: $email.***")
            println("*  Por favor selecciona una opcion:                    *")
            println("*  1- Ingresa a tu cuenta:                             *")
            println("*  2- Usar otro e-mail:                                *")
            var opcion = readLine()!!
            while(isInt(opcion)=="" || !rangoOpcionValido(opcion)){
                println("Solo puede ingresar un valor numerico, es decir: 1 o 2")
                println("*  Por favor selecciona una opcion:                    *")
                println("*  1- Ingresa a tu cuenta:                             *")
                println("*  2- Usar otro e-mail:                                *")
                opcion = readLine()!!
            }
            when (Integer.parseInt(opcion)) {
                1 -> {
                    iniciarSesion()
                }
                2 -> {
                    do {
                        println("Email:")
                        email = readLine()!!
                    } while (!(validate(email)))
                    if (!isEmailValid(email)) {
                        do {
                            println("Usa el formato nombre@ejemplo.com en tu email")
                            println("Email:")
                            email = readLine()!!
                        } while (!isEmailValid(email))
                        while (!((validate(email))) || (existeCorreo(usuariosCliente, email)) || !isEmailValid(email)) {
                            println(
                                "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                        " o ya existe una cuenta con este e-mail:"
                            )
                            println("Email:")
                            email = readLine()!!
                        }
                    } else {
                        if (existeCorreo(usuariosCliente, email)) {
                            do {
                                println(
                                    "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                            " o ya existe una cuenta con este e-mail:"
                                )
                                println("Email:")
                                email = readLine()!!
                            } while (!validate(email) || existeCorreo(usuariosCliente, email));
                        }
                    }
                }
            }
        }
    } else {
        if (existeCorreo(usuariosCliente, email)) {
            println("*** Ya existe una cuenta con: $email.***")
            println("*  Por favor selecciona una opcion:                    *")
            println("*  1- Ingresa a tu cuenta:                             *")
            println("*  2- Usar otro e-mail:                                *")
            var opcion = readLine()!!
            while(isInt(opcion)=="" || !rangoOpcionValido(opcion)){
                println("Solo puede ingresar un valor numerico, es decir: 1 o 2")
                println("*  Por favor selecciona una opcion:                    *")
                println("*  1- Ingresa a tu cuenta:                             *")
                println("*  2- Usar otro e-mail:                                *")
                opcion = readLine()!!
            }
            when (Integer.parseInt(opcion)) {
                1 -> {
                    iniciarSesion()
                }
                2 -> {
                    do {
                        println("Email:")
                        email = readLine()!!
                    } while (!(validate(email)))
                    if (!isEmailValid(email)) {
                        do {
                            println("Usa el formato nombre@ejemplo.com en tu email")
                            println("Email:")
                            email = readLine()!!
                        } while (!isEmailValid(email))
                        if (existeCorreo(usuariosCliente, email) || !validate(email) || !isEmailValid(email)) {
                            do {
                                println(
                                    "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                            " o ya existe una cuenta con este e-mail:"
                                )
                                println("Email:")
                                email = readLine()!!
                            } while (!validate(email) || existeCorreo(usuariosCliente, email) || !isEmailValid(email));
                        }
                    } else {
                        if (existeCorreo(usuariosCliente, email) || !validate(email) || !isEmailValid(email)) {
                            do {
                                println(
                                    "Revisa tu e-mail. El e-mail no es el formato solicitado" +
                                            " o ya existe una cuenta con este e-mail:"
                                )
                                println("Email:")
                                email = readLine()!!
                            } while (!validate(email) || existeCorreo(usuariosCliente, email) || !isEmailValid(email));
                        }
                    }
                }
            }
        }
    }
    return email
}

fun isInt(valor:String):Any{
    var result:Boolean = false
    try {
        return  valor.toInt()
    } catch(e: Exception){
        return ""
    }
}
fun rangoOpcionValido(valor:String):Boolean{
    var result:Boolean = false
    try {
        if(valor.toInt() in 1..2){
            result = true
        }
    } catch(e: Exception){
    }
    return result
}




fun isEmailValid(email: String): Boolean {
    var isValid = false
    //val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val expression ="(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    val inputStr: CharSequence = email
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher: Matcher = pattern.matcher(inputStr)
    if (matcher.matches()) {
        isValid = true
    }
    return isValid
}

fun existeCorreo(usuariosClientes: MutableMap<Usuario, Cliente>,email:String):Boolean{
    var existe=false

    for ((user, cliente) in usuariosClientes) {
        if (cliente.getEmail().equals(email)) {
            existe=true
        }
    }
    return existe
}

fun existeNumeroTelefonico(usuariosClientes: MutableMap<Usuario, Cliente>,numeroTelefonico:String):Boolean{
    var existe=false
    for ((key, value) in usuariosClientes) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/
        if (value.getNumeroTelefonico().equals(numeroTelefonico)) {
            existe=true
        }
    }
    return existe
}

fun obtenerNombreAmostrar(usuariosClientes: MutableMap<Usuario, Cliente>,user:String):String{
    var nombre: String =""
    for ((key, value) in usuariosClientes) {
        /*println("IdUsuario: $key")
        println("Usuario: ${value.getUsuario()}")*/
        if (key.getUsuario().equals(user) || value.getEmail().equals(user)||value.getNumeroTelefonico().equals(user)) {
            nombre=value.getNombre()
        }
    }
    return nombre
}