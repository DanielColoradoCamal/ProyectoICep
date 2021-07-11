package models


class Cliente(idUsuario:Int,idCliente:Int,nombre: String,apellidos: String,email:String):Persona(nombre,apellidos) {

     private var idCliente:Int= idCliente
     private var idUsuario: Int = idUsuario
     private var numeroTelefonico: String =""
     private var email: String = email


     fun getIdCliente():Int{
          return idCliente
     }

     fun setIdCliente(idCliente:Int){
          this.idCliente=idCliente
     }

     fun getIdUsuario():Int{
          return idUsuario
     }

     fun setIdUsuario(idUsuario:Int){
          this.idUsuario=idUsuario
     }

     fun getNumeroTelefonico():String{
          return numeroTelefonico
     }

     fun setNumeroTelefonico(numeroTelefonico:String){
          this.numeroTelefonico=numeroTelefonico
     }

     fun getEmail():String{
          return email
     }

     fun setEmail(email:String){
          this.email=email
     }

     fun mostrarDatosNuevoUsuario(usuario: Usuario,cliente: Cliente){
           println("Cliente creado:\n" +
                  "Nombre: ${cliente.getNombre()}\n" +
                  "Apellidos: ${cliente.getApellidos()}\n" +
                  "Email: ${cliente.getEmail()}\n"+
                   "Nombre de Usuario: ${usuario.getUsuario()}\n"+
                    "\nBienvenido: ${cliente.getNombre()}\n")
     }

/*    constructor(idCliente: Int,idUsuario: Int) :this(){
        this.idCliente=idCliente
        this.idUsuario=idUsuario
    }
    constructor(idCliente: Int,idUsuario: Int) :this(){

        this.idCliente=idCliente
        this.idUsuario=idUsuario
    }*/



    /*constructor(idCliente:Int,idUsuario:Int,nombre:String,apellidos:String,sexo: String,edad: Int,direccion: String) : this(idCliente,idUsuario,nombre,apellidos) {

    }
    constructor(idCliente:Int,nombre:String,apellidos:String) : this(idCliente,nombre,apellidos) {

    }*/

    /*constructor(idCliente:Int,idUsuario:Int) : this() {

    }*/

    /*constructor(idCliente:Int,
                nombre:String,
                apellidos:String,
                sexo: String,
                edad: Int,
                direccion: String) : this(idCliente,nombre,apellidos, sexo,edad,direccion) {
    }*/






    /*constructor(nombre:String,apellidos:String,sexo:String,edad:Int,direccion:String) : this(nombre,) {

    }*/


//listado de prodiuto ya comprado
}

