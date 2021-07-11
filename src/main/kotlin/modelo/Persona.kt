package models
/*
 abstract class Product(var price: Float, var name: String, var sku: String) {
    abstract fun getTotalPrice(quantity: Int): Float
}
* */
open class Persona(nombre: String,apellidos:String){

    private var nombre: String = nombre
    private var apellidos: String = apellidos
    private var sexo: String = ""
    private var edad: Int = 0
    private var codigoPostal: Int =0
    private var direccion: String = ""

    constructor (nombre:String,apellidos:String,sexo: String,edad: Int) : this(nombre,apellidos) {
        this.sexo=sexo
        this.edad=edad
    }


    constructor (nombre:String,apellidos:String,sexo: String,edad: Int,codigoPostal: Int, direccion: String) : this(nombre,apellidos) {
        this.sexo=sexo
        this.edad=edad
        this.codigoPostal=codigoPostal
        this.direccion=direccion
    }


    fun getNombre(): String {
     //   println("Llamado desde el getNombre() $nombre")
        return this.nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getApellidos(): String {
      //  println("Llamado desde el getNombre() $nombre")
        return this.apellidos
    }

    fun setApellidos(apellidos: String) {
        this.apellidos = apellidos
    }

    fun getSexo(): String {
      //  println("Llamado desde el getSexo() $sexo")
        return this.sexo
    }

    fun setSexo(sexo: String) {
        this.sexo = sexo
    }

    fun getCodigoPostal(): Int {
        //println("Llamado desde el getCodigoPostal() $codigoPostal")
        return this.codigoPostal
    }

    fun setCodigoPostal(codigoPostal: Int) {
        this.codigoPostal = codigoPostal
    }

    fun getDireccion(): String {
      //  println("Llamado desde el getCodigoPostal() $direccion")
        return this.direccion
    }

    fun setDireccion(direccion: String) {
        this.direccion = direccion
    }

}