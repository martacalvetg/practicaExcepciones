/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.martacalgua.test;

import com.martacalgua.parking.Parking;
import com.martacalgua.parking.ParkingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martacalgua
 */

public class PracticaExcepciones {

    static Parking parking  = new Parking("Parking Centro", 10);
    static int opcion;
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        do{
            menu();
            opcion();
        } while (opcion!=4); 
    }
    
    public static void menu(){
        System.out.println("Que opcion quieres realizar?\n"
            + "1) Entrada de coche\n"
            + "2) Salida de coche\n"
            + "3) Mostrar parking\n"
            + "4) Salir del programa\n"
            + "Opcion: \n");
        try{
            opcion = s.nextInt();
        } catch (Exception ex){
            opcion = 0;
        }
        
    }
    
    public static void opcion(){
        switch(opcion){
            case 1:
                entradaCoche();
                break;
            case 2:
                salidaCoche();
                break;
            case 3:
                System.out.println(parking.toString() + "\n\n");
            case 4:
                System.out.println("FIN DEL PROGRAMA");
            default:
                System.out.println("Esta opción no existe");
                
        }
    }
    
    public static void salidaCoche(){
        String matricula = null;
        boolean correcto = false;
            try {
                System.out.print("Introduce la matrícula: ");
                matricula = s.next();
                parking.salida(matricula);
                
                System.out.println("Plazas totales: " + parking.getPlazasTotales());
                System.out.println("Plazas libres: " + parking.getPlazasLibres());
                System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
                
            } catch (ParkingException ex) {
                System.out.println("No ha sido posible sacar el coche con matricula: " + ex.getMatricula());
                System.out.println("ERROR: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("ERROR DESCONOCIDO.");
            } finally {
                if(!correcto)
                    System.out.println("Se produjo un error");
            }
    }
    
    public static void entradaCoche(){
        String matricula = "";
        int plaza;
        
        try {       
            System.out.print("Introduce la matricula del coche: ");
            matricula = s.next();
            
            System.out.print("Introduce la plaza: ");
            plaza = s.nextInt();
            parking.entrada(matricula, plaza);
        } catch (ParkingException ex) {
            System.out.println("No ha sido posible introducir el coche "  + ex.getMatricula());
            System.out.println("ERROR: " + ex.getMessage());
        } catch (NumberFormatException ex){
            System.out.println("Formatio de texto incorrecto");
        } catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
