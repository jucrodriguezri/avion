/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaavion;

/**
 *
 * @author juanka
 */
public class Problemaavion {
    public static boolean[] crearArgBool(int n){
      boolean[] B= new boolean[n];
      return B;
    }
    
    public static String[] crearArrStr(int n){
      String[] A= new String[n];
      return A;
    }
    
    public static int[] crearArrInt(int n){
      int[] A= new int[n];
      return A;
    }
    
    public static boolean[][] crearMtzBool(int n, int m){
      boolean[][] A= new boolean[n][m];
      for(int i=0; i<n; i++){
        A[i]=crearArgBool(m);    
      }
      return A;
    }
    
    public static int[][] crearMtzInt(int n, int m){
      int[][] A= new int[n][m];
      for(int i=0; i<n; i++){
        A[i]=crearArrInt(m);    
      }
      return A;
    }
    
    public static String[][] crearMtzStr(int n, int m){
      String[][] A= new String[n][m];
      for(int i=0; i<n; i++){
        A[i]=crearArrStr(m);    
      }
      return A;
    }
    
    public static void matrizV(boolean[][] A, int n, int m){
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          A[i][j]= true;
        }    
      } 
    }
   
    
    public static void llenarelPuesto(int pos, int fila, boolean[][] A){
      A[fila][pos]=false;    
    }

    public static void llenarPuestoCedula(int pos, int fila, int[][] A, int cedula){
      A[fila][pos]=cedula;    
    }
    
    public static void llenarPuestoNombre(int pos, int fila, String[][] A, String nombre){
      A[fila][pos]=nombre;    
    }
    
    public static int[] asignarPuestoEjec(boolean[][] A, int[][] B, String[][] C, int n, int m){
      int[] puesto= crearArrInt(2);
      puesto[0]=-1;
      puesto[1]=-1;
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      System.out.println("Digite 1 para ventana o 2 para pasillo");
      int posicion= lectura.nextInt();
      System.out.println("Digite cedula");
      int cedula=lectura.nextInt();
      System.out.println("Digite nombre");
      String nombre=lectura.next();
      if(posicion==1){
        for(int i=0; i<n; i++){
          if(A[i][0]==true){
            puesto[0]= i;
            puesto[1]= 0; 
          }
          if(A[i][n-1]==true){
            puesto[0]= i;
            puesto[1]= n-1;      
          }
        }    
      }else{
       for(int i=0; i<n; i++){
          if(A[i][1]==true){
            puesto[0]= i;
            puesto[1]= 1; 
          }
          if(A[i][2]==true){
            puesto[0]= i;
            puesto[1]= 2;      
          }      
      }
    }
      llenarelPuesto(puesto[1],puesto[0],A);
      llenarPuestoCedula(puesto[1],puesto[0],B,cedula);
      llenarPuestoNombre(puesto[1],puesto[0],C,nombre);
      return puesto;
    }     
          
    public static int[] asignarPuestoeconomico(boolean[][] A, int[][] B, String[][] C, int n, int m){
      int[] puesto= crearArrInt(2);
      puesto[0]=-1;
      puesto[1]=-1;
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      System.out.println("Digite 1 para ventana, 2 para centro, 3 para pasillo");
      int posicion= lectura.nextInt();
      System.out.println("Digite cedula");
      int cedula=lectura.nextInt();
      System.out.println("Digite nombre");
      String nombre=lectura.next();    
      if(posicion==1){
        for(int i=0; i<n; i++){
          if(A[i][0]==true){
            puesto[0]= i;
            puesto[1]= 0;         
          }
          if(A[i][n-1]==true){
            puesto[0]= i;
            puesto[1]= n-1;         
          }
        }
      }
      if(posicion==2){
        for(int i=0; i<n; i++){
          if(A[i][1]==true){
            puesto[0]= i;
            puesto[1]= 1; 
          }
          if(A[i][n-2]==true){
            puesto[0]= i;
            puesto[1]= n-2;                  
          }  
        }
      
      }
      if(posicion==3){
        for(int i=0; i<n ; i++){
          if(A[i][0]==true){
            puesto[0]= i;
            puesto[1]= 0;          
          }
          if(A[i][n-1]==true){
            puesto[0]= i;
            puesto[1]= n-1;                       
          }
        }
      }
      llenarelPuesto(puesto[1],puesto[0],A);
      llenarPuestoCedula(puesto[1],puesto[0],B,cedula);
      llenarPuestoNombre(puesto[1],puesto[0],C,nombre);           
      return puesto;
    }
    
    public static int sillasEjecutivasLlenas(boolean[][] A, int n, int m){
      int c=0;
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(A[i][j]==false){
            c++;    
          }    
        }    
      }
      return c;  
    }
    
    public static int[] EncontrardondeestaCedula(int[][] A, int n, int m, int cedula){
      int[] puesto= crearArrInt(2);
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(A[i][j]==cedula){
            puesto[0]=i;
            puesto[1]=j;
          }    
        }    
      }
     return puesto;   
    }
    
    public static int[] sillaEconomicaVacia(boolean[][] A, int n, int m){
      int[] puesto= crearArrInt(2);
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(A[i][j]==true){
            puesto[0]=i;
            puesto[1]=j;
          }    
        }    
      }
      return puesto;  
    }
    
    public static void anularReserva(boolean[][] A, int fila, int posicion){
      A[fila][posicion]= true;      
    }
    
    public static int numeroSillasVentanaEco(boolean[][] A, int n, int m){
      int c=0;
      for(int i=0; i<n; i++){
        if((A[i][1]==true)||(A[i][n-1]==true))
          c++;    
        }    
      return c;  
    }
    
    public static boolean revisarNombresIguales(String[][] A, int n, int m){
      boolean c= false;    
      for(int i=0; i<n && !c; i++){
        for(int j=0; j<m; j++){
          for(int h=1; h<n; h++){
            for(int k=1; k<m; k++){
             c|=((A[i][j]).equals(A[h][k]));    
            }  
          }    
        }     
      }    
      return c;
    }
    
    public static String grafica(boolean[][] A, boolean[][] B){
      String os= "";
      for(int i=0; i<2; i++){
        for(int j=0; j<2; j++){
          if(A[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }     
      os+= "     ";
        for(int j=2; j<4; j++){
          if(A[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }
      os+="\n";
    }
    os+= "\n" + "\n";
    for(int i=0; i<7; i++){
        for(int j=0; j<3; j++){
          if(B[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }     
      os+= " ";
        for(int j=3; j<6; j++){
          if(B[i][j]==true){
            os+= (i+1) + "." + (j+1) + " ";    
          }else{
            os+= "[" + (i+1) + "." + (j+1) + "]";    
          }    
        }
      os+="\n";
    }
      return os;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
    }
    
}
