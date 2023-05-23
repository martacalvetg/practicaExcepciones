/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.martacalgua.parking;

/**
 *
 * @author Marta
 */
public class ParkingException extends Exception{
    private String matricula;
    private String mensaje;
    
    public ParkingException(String mensaje, String matricula){
        this.mensaje = mensaje;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMensaje() {
        return mensaje;
    }
}
