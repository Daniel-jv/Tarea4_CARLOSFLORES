package tarea4_carlosflores;

import java.util.Scanner;

public class Tarea4_CARLOSFLORES {

    static Scanner leer = new Scanner(System.in);
    static int cont_hits_player1;
    static int cont_hits_player2;
    static boolean var = true;        
    static boolean lifeline = true;
    
    public static void main(String[] args) {
        boolean play = true;
        while(play){
            char decis = 's';
            System.out.print("---MENU---\n1.Battleship\n2.Busca minas\n3.Salir\nIngrese una opcion: ");
            int op = leer.nextInt();
            switch(op){

                case 1:{
                    do{
                        do{
                            System.out.println("\nBienvenidos/as a Battleship\nModo: 2 jugadores\nLes deseo suerte...");
                            char tabA[][] = spawn_tabA();//tablero del jugador 1
                            char tabB[][] = spawn_tabB();//tablero del jugador 2
                            cont_hits_player1 = 0;
                            cont_hits_player2 = 0;
                            int var2 = 0;//cree esta variable para terminar el ciclo for unicamente
                            for (int i = 0;var2 == 0;i++) {
                                int turno = 1;
                                if(i % 2 != 0){
                                    turno = 2;
                                }//decision de turno

                                switch(turno){

                                    case 1:{
                                        System.out.println("\n---ES TURNO DEL JUGADOR 1---");
                                        char show [][] = tabB;
                                        System.out.println("TABLERO DEL JUGADOR 2");
                                        for (int j = 0; j < 6; j++) {
                                            if(j == 0){
                                                System.out.print("  ");
                                            }else{
                                                System.out.print(" "+(j-1)+" ");
                                            } 
                                        }
                                        System.out.println();
                                        for (int j = 0; j < show.length; j++) {
                                            System.out.print(j+" ");
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
                                        contador_hits();//imprime aciertos de los jugadores
                                        instrucciones_coordenadas();//imprime instrucciones de coordenadas
                                        int cord [] = coordenas();
                                        tabB = checkforhit(tabB, cord,turno);
                                        var = winner(turno);//muestra mensaje de ganador
                                        break;
                                    }//fin case 1

                                    case 2:{
                                        System.out.println("\n---ES TURNO DEL JUGADOR 2---");
                                        char show [][] = tabA;
                                        System.out.println("TABLERO DEL JUGADOR 1");
                                        for (int j = 0; j < 6; j++) {
                                            if(j == 0){
                                                System.out.print("  ");
                                            }else{
                                                System.out.print(" "+(j-1)+" ");
                                            } 
                                        }
                                        System.out.println();
                                        for (int j = 0; j < show.length; j++) {
                                            System.out.print(j+" ");
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
                                        contador_hits();//imprime aciertos de los jugadores
                                        instrucciones_coordenadas();//imprime instrucciones de coordenadas
                                        int cord [] = coordenas();
                                        tabA = checkforhit(tabA, cord,turno);
                                        var = winner(turno);//muestra mensaje de ganador
                                        break;
                                    }//fin case 2

                                }//fin switch
                                if(cont_hits_player2 == 3 || cont_hits_player1 == 3){
                                    var2 = 1;
                                }
                            }//fin for

                        }while(var);//fin while

                        felicidades();

                        System.out.print("\n¿Desean jugar otra vez?[S/N]: ");
                        decis = leer.next().charAt(0);
                        while(decis != 's' && decis != 'S' && decis != 'n' && decis != 'N'){
                            System.out.print("[S/N]:");
                            decis = leer.next().charAt(0);
                        }
                    }while(decis == 'S' || decis == 's');

                    if(decis == 'N' || decis == 'n'){
                        System.out.println("\nATENCION!!!\nSalieron del juego...");
                    }
                    System.out.println();
                    break;
                }//fin battleship/case1

                case 2:{
                    System.out.println("\nBienvenido/a a Busca Minas\nModo: Dinamico\nTe deseo suerte...");
                    lifeline = true;
                    char tab [][] = spawn_buscaminas();
                    char show [][] = tab;
                    for (int i = 1; i < 11; i++) {
                        System.out.println("\n---TURNO "+i);
                        for (int j = 0; j < 7; j++) {
                            if(j == 0){
                                System.out.print("  ");
                            }else{
                                System.out.print(" "+(j-1)+" ");
                            } 
                        }
                        System.out.println();
                        for (int j = 0; j < show.length; j++) {
                            System.out.print(j+" ");
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
                        instrucciones_coordenadas();
                        int cords [] = coordenas_buscaminas();
                        checkforhit_buscaminas(show,cords);
                        if(lifeline == false){
                            System.out.println("\n¡¡¡ATENCION!!!");
                            System.out.println("Has Perdido");
                            break;
                        }else if(i == 10 && lifeline){
                            System.out.println("\n¡¡¡FELICIDADES JUGADOR!!!");
                            System.out.println("Has Ganado");
                            break;
                        }
                    }
                    System.out.println();
                    break;
                }//fin buscaminas/case2

                case 3:{
                    System.out.println("\nHa salido del programa, nos vemos...");
                    play = false;
                    break;
                }//fin case3

                default:{
                    System.out.println("Opcion no valida\n");
                    break;
                }//fin default

            }//fin switch

        }//fin while
        
    }//fin main
    
    public static int[] coordenas(){//metodo que lee y verifica coordenadas
        int coordenada [] = new int [2];
        int fila = -1;
        while(fila > 5 || fila < 0){
            System.out.print("Fila: ");
            fila = leer.nextInt();
            if(fila > 5){
                System.out.println("La fila tiene que ser menor a 6, intente de nuevo.");
            }
        }
        coordenada[0] = fila;
        int columna = -1;
        while(columna > 4 || columna < 0){
            System.out.print("Columna: ");
            columna = leer.nextInt();
            if(columna > 4){
                System.out.println("La columna tiene que ser menor a 5, intente de nuevo.");
            }
        }
        coordenada[1] = columna;
        return coordenada;
    }//fin coordenadas
    
    public static char [][] checkforhit(char tab [][], int cord [] , int turno){//metodo que verifica si el jugador golpeo un barco
        char show [][] = tab;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == cord[0] && j == cord[1] && show[i][j] == (char) 88){
                    System.out.println("\n---Bomba al agua---");
                    System.out.println("ATENCION!!!");
                    System.out.println("NOTA: Ya habias arrojado una bomba en estas coordenadas, desperdiciaste tu turno, prueba con otras coordenadas.");
                }else if(i == cord[0] && j == cord[1] && show[i][j] == (char) 42){
                    System.out.println("\n---Uy, un barco ha sido dañado---\nAcertaste la ubicacion de uno de los barcos enemigos.");
                    show[i][j] = (char) 88;
                    if(turno == 1 ){
                        cont_hits_player1++;
                    }else{
                        cont_hits_player2++;
                    }
                    break;
                }else if(i == cord[0] && j == cord[1]){
                    System.out.println("\n---Bomba al agua---\nHas fallado, intenta nuevamente en el siguiente turno.");
                    show[i][j] = (char) 88;
                    break;
                }
            }
        }
        return show;
    }//fin checkforhit
    
    public static char[][] spawn_tabA(){//metodo que crea el tablero del jugador 1
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
    }//fin spawn_tabA
    
    public static char[][] spawn_tabB(){//metodo que crea el tablero del jugador 2
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
    }//fin spawn_tabB
    
    public static void felicidades(){
        if(cont_hits_player1 == 3){
            System.out.println("\n¡¡¡FELICIDADES JUGADOR 1!!!");
            System.out.println("Has Ganado");
        }else if(cont_hits_player2 == 3){
            System.out.println("\n¡¡¡FELICIDADES JUGADOR 2!!!");
            System.out.println("Has Ganado");
        }
    }//fin felicidades
    
    public static void contador_hits(){//metodo para imprimir aciertos de jugadores
        if(cont_hits_player1 > 0){
            System.out.println("NOTA: El jugador 1 lleva "+cont_hits_player1+" hits.");
        }
        if(cont_hits_player2 > 0){
            System.out.println("NOTA: El jugador 2 lleva "+cont_hits_player2+" hits.");
        }
    }//fin contador_hits
    
    public static void instrucciones_coordenadas(){//metodo para imprimir intrucciones de coordenadas
        System.out.println("\n---COORDENADAS");
        System.out.println("A continuacion ingrese las coordenadas que desea atacar.");
    }//fin instrucciones_coordenadas
    
    public static boolean winner(int turno){//metodo que muestra el ganador
        boolean winner = true;
        if(cont_hits_player2 > 2 || cont_hits_player1 > 2){
            System.out.println("\nATENCION!!!");
            System.out.println("-El jugador "+turno+" a impactado 3 veces un barco enemigo.");
            winner = false;
        }
        return winner;
    }//fin winner
    
    public static char [][] spawn_buscaminas(){
        char tab [][] = new char [6][6];
        int cont_bombs = 0;
        while(cont_bombs != 5){
            cont_bombs = 0;
            for (int i = 0; i < tab.length; i++) {
                int ver = 0;
                for (int j = 0; j < tab[i].length; j++) {
                    double activate = Math.random();
                    if(activate < 0.3 && cont_bombs < 5 && ver < 1){
                        tab[i][j] = '*';
                        cont_bombs++;
                        ver++;
                    }else{
                        tab[i][j] = ' ';
                    }
                }
            }
        }
        return tab;
    }//spawn_buscaminas
    
    public static int[] coordenas_buscaminas(){//metodo que lee y verifica coordenadas
        int coordenada [] = new int [2];
        int fila = -1;
        while(fila > 5 || fila < 0){
            System.out.print("Fila: ");
            fila = leer.nextInt();
            if(fila > 5){
                System.out.println("La fila tiene que ser menor a 6, intente de nuevo.");
            }
        }
        coordenada[0] = fila;
        int columna = -1;
        while(columna > 5 || columna < 0){
            System.out.print("Columna: ");
            columna = leer.nextInt();
            if(columna > 4){
                System.out.println("La columna tiene que ser menor a 6, intente de nuevo.");
            }
        }
        coordenada[1] = columna;
        return coordenada;
    }//fin coordenadas
    
    public static char [][] checkforhit_buscaminas(char tab [][], int cord []){//metodo que verifica si el jugador golpeo un barco
        char show [][] = tab;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == cord[0] && j == cord[1] && show[i][j] == (char) 88){
                    System.out.println("ATENCION!!!");
                    System.out.println("NOTA: Ya verificaste esa posicion, porfavor ingresa otra coordenada");
                    boolean recheck = true;
                    while(recheck){
                        System.out.println("---Coordenadas\nIngrese nuevas coordenadas");
                        cord = coordenas_buscaminas();
                        if(i == cord[0] && j == cord[1] && show[i][j] == (char) 88){
                            System.out.println("ATENCION!!!");
                            System.out.println("NOTA: Ya verificaste esa posicion, porfavor ingresa otra coordenada");
                        }else{
                            recheck = false;
                        }
                    }
                }else if(i == cord[0] && j == cord[1] && show[i][j] == (char) 42){
                    System.out.println("\n---BOOM---\nQue mala suerte...");
                    show[i][j] = (char) 88;
                    lifeline = false;
                    break;
                }else if(i == cord[0] && j == cord[1]){
                    System.out.println("\n---Uff, no erá una bomba---\nTe salvaste de momento.");
                    show[i][j] = (char) 88;
                    break;
                }
            }
        }
        return show;
    }
    
}//fin class 
