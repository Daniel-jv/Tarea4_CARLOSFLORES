package tarea4_carlosflores;

import java.util.Scanner;

public class Tarea4_CARLOSFLORES {

    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean var = true;
        char tab1 [][] = new char[6][5];
        char tab2 [][] = new char[6][5];
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                if((j == 0 && (i == 0 || i == 1 || i == 2)) || (j == 4 && (i == 3 || i == 4 || i == 5)) || (i == 1 && (j == 2 || j == 3))){
                    tab1[i][j] = (char) 42;
                }else{
                    tab1[i][j] = (char) 32;
                }
            }
        }
        System.out.println("\nTABLERO A");
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                System.out.print("["+tab1[i][j]+"]");
            }
            System.out.println();
        }
        for (int i = 0; i < tab2.length; i++) {
            for (int j = 0; j < tab2[i].length; j++) {
                if((j == 1 && (i == 3 || i == 4|| i == 5)) || (j == 3 && (i == 1 || i == 2 || i == 3)) || (i == 5 && (j == 3 || j == 4))){
                    tab2[i][j] = (char) 42;
                }else{
                    tab2[i][j] = (char) 32;
                }
            }
        }
        System.out.println("\nTABLERO B");
        for (int i = 0; i < tab2.length; i++) {
            for (int j = 0; j < tab2[i].length; j++) {
                System.out.print("["+tab2[i][j]+"]");
            }
            System.out.println();
        }
        /*do{
            System.out.println("Bienvenidos/as Battleship\nModo: 2 jugadores\n");
        }while(var);*/
        
    }//fin main
    
}//fin class 
