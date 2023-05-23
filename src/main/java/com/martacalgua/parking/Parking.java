/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.martacalgua.parking;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author martacalgua
 */
public class Parking {
    private final ArrayList<String> matriculas;
    private final String nombre;
    
    public Parking(String nombre, int plazas){
        this.nombre = nombre;
        matriculas = new ArrayList<>();
        for(int i=0;i<plazas;i++){
            matriculas.add(null);
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public void entrada(String matricula, int plaza) throws ParkingException{
        if (plaza > matriculas.size() || plaza < 0)
            throw new ParkingException("La plaza seleccionada no existe. \n Matricula introducida: ", matricula);
        if(matricula==null || matricula.length()<4)
            throw new ParkingException("Matricula incorrecta: ", matricula);
        if (matriculas.get(plaza)!=null)
            throw new ParkingException("La plaza ya esta ocupada. \n Matricula introducida:  ", matricula);
        if (matriculas.contains(matricula))
            throw new ParkingException("Matricula repetida: ", matricula);
        
        matriculas.set(plaza, matricula);
    }
    
    public int salida(String matricula) throws ParkingException{
        if (!matricula.contains(matricula))
            throw new ParkingException("Matricula no existente: " , matricula);
        
        int plaza = matriculas.indexOf(matricula);
        matriculas.set(plaza, null);
        return plaza;
    }
    
    public int getPlazasTotales(){
        return matriculas.size();
    }
    
    public int getPlazasOcupadas(){
        return getPlazasTotales()- getPlazasLibres();
    }
    
    public int getPlazasLibres(){
        
        int plazasLibres=0;
        for(int i=0; i<matriculas.size();i++){
            if(matriculas.get(i)==null){
                plazasLibres++;
            }
        }
        
        return plazasLibres;
    }
    
    @Override
    public String toString(){
        
        
        String info = nombre + "\n"
                + "----------------------------------\n";
        for (int i=0; i<matriculas.size(); i++){
            info += "Plaza " + i + ": ";
            if (matriculas.get(i) == null)
                info += "vacia\n";
            else
                info += matriculas.get(i)+"\n";
        }
        return info;
        
    }
}
