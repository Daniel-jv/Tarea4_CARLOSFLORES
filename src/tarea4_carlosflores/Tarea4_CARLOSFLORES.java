package tarea4_carlosflores;

import java.util.Scanner;

public class Tarea4_CARLOSFLORES {

    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean var = true;
        
        /*ESTRUCTURA DEL JUEGO
        
        -JUGADOR EN TURNO INGRESA COORDENADAS <--------|
        -VALIDAR SI LAS COORDENADAS SON VALIDAS        |
        -MOSTRAR MENSAJE                               | 
        -MARCAR X EN EL LUGAR ATACADO                  |
        -MOSTRAR TABLERO                               |
        -SIGUIENTE TURNO ------------------------------|
        -SI SE GOLPEAN 3 PARTES DE LOS BARCOS EL JUGADOR GANA
        */
        
        do{
            System.out.println("Bienvenidos/as Battleship\nModo: 2 jugadores");
            char tabA[][] = spawn_tabA();
            char tabB[][] = spawn_tabB();
            
            for (int i = 0; i < 100; i++) {
                int turno = 1;
                if(i % 2 != 0){
                    turno = 2;
                }
                System.out.println("\nAL ATAQUE!!!");
                
                switch(turno){
                    
                    case 1:{
                        System.out.println("Es turno del jugador 1");
                        System.out.println("COORDENADAS");
                        System.out.println("NOTA: las fila y columnas se cuentan desde 0");
                        int cord [] = coordenas();
                        tabB = checkforhit(tabB, cord);
                        /*for (int j = 0; j < tabB.length; j++) {
                            for (int k = 0; k < tabB[j].length; k++) {
                                System.out.print("["+tabB[j][k]+"]");
                            }
                            System.out.println("");
                        }*/
                        char show [][] = tabB;
                        for (int j = 0; j < show.length; j++) {
                            for (int k = 0; k < show[j].length; k++) {
                                if(show[j][k] == (char) 42){
                                    char esp = (char) 32;
                                    System.out.print("["+esp+"]");
                                }else{
                                    System.out.print("["+show[j][k]+"]");
                                }
                            }
                            System.out.println("");
                        }
                        break;
                    }
                    
                    case 2:{
                        System.out.println("Es turno del jugador 2");
                        System.out.println("COORDENADAS");
                        int cord [] = coordenas();
                        tabA = checkforhit(tabA, cord);
                        char show [][] = tabA;
                        for (int j = 0; j < show.length; j++) {
                            for (int k = 0; k < show[j].length; k++) {
                                if(show[j][k] == (char) 42){
                                    char esp = (char) 32;
                                    System.out.print("["+esp+"]");
                                }else{
                                    System.out.print("["+show[j][k]+"]");
                                }
                            }
                            System.out.println("");
                        }
                        break;
                    }
                    
                }
                
            }
            
        }while(var);
        
    }//fin main
    
    public static int[] coordenas(){
        int coordenada [] = new int [2];
        int fila = -1;
        while(fila > 5 || fila < 0){
            System.out.print("Fila: ");
            fila = leer.nextInt();
            if(fila > 5){
                System.out.println("La fila tiene que ser menor a 5, intente de nuevo.");
            }
        }
        coordenada[0] = fila;
        int columna = -1;
        while(columna > 4 || columna < 0){
            System.out.print("Columna: ");
            columna = leer.nextInt();
            if(columna > 4){
                System.out.println("La columna tiene que ser menor a 4, intente de nuevo.");
            }
        }
        coordenada[1] = columna;
        return coordenada;
    }
    
    public static char [][] checkforhit(char tab [][], int cord [] ){
        char show [][] = tab;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == cord[0] && j == cord[1] && show[i][j] == (char) 42){
                    System.out.println("Uy, un barco ha sido dañado");
                    show[i][j] = (char) 88;
                    break;
                }else if(i == cord[0] && j == cord[1]){
                    System.out.println("Bomba al agua");
                    show[i][j] = (char) 88;
                    break;
                }
            }
        }
        return show;
    }
    
    public static char[][] spawn_tabA(){
        char tabA [][] = new char[6][5];
        for (int i = 0; i < tabA.length; i++) {
            for (int j = 0; j < tabA[i].length; j++) {
                if((j == 0 && (i == 0 || i == 1 || i == 2)) || (j == 4 && (i == 3 || i == 4 || i == 5)) || (i == 1 && (j == 2 || j == 3))){
                    tabA[i][j] = (char) 42;
                }else{
                    tabA[i][j] = (char) 32;
                }
            }
        }
        return tabA;
    }
    
    public static char[][] spawn_tabB(){
        char tabB [][] = new char[6][5];
        for (int i = 0; i < tabB.length; i++) {
            for (int j = 0; j < tabB[i].length; j++) {
                if((j == 1 && (i == 3 || i == 4|| i == 5)) || (j == 3 && (i == 1 || i == 2 || i == 3)) || (i == 5 && (j == 3 || j == 4))){
                    tabB[i][j] = (char) 42;
                }else{
                    tabB[i][j] = (char) 32;
                }
            }
        }
        return tabB;
    }
    
}//fin class 
