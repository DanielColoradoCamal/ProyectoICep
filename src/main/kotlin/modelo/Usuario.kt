package models

import java.util.*


class Usuario(idUsuario:Int, usuario:String,contrasenia:String) {
    private val idUsuario: Int = idUsuario
    private var usuario: String =usuario
    private var contrasenia: String = contrasenia

    fun mostrarNombreUsuario(){
        println("Nombre de usuario: $usuario\n")
    }

   fun getIdUsuario():Int{
        return idUsuario
    }

    fun getUsuario():String{
        return usuario
    }

    fun setUsuario(usuario: String){
        this.usuario=usuario
    }

    fun getContrasenia():String{
        return contrasenia
    }

    fun setContrasenia(contrasenia: String){
        this.contrasenia=contrasenia
    }



}