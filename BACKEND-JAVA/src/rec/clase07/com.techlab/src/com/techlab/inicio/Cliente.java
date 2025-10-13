package com.techlab.inicio;

public class Cliente {
    private String nombre;
    private String email;

    public  Cliente(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        if(email.contains("@")){
            this.email = email;
        }
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }


}
