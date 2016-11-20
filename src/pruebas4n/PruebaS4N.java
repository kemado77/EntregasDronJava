/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas4n;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PruebaS4N {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      FileWriter fichero = null;
      PrintWriter pw = null;
      List<String> rutas=new ArrayList<String>();
      List<PosicionDron> movimientos = new ArrayList<PosicionDron>();
      try {
         
         archivo = new File ("C:\\in.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

        
         String linea;
         while((linea=br.readLine())!=null)
            //System.out.println(linea);
            rutas.add(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally
      {
          try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
       }
      
      if(rutas.size()>0 )
      {
        System.out.println("Rutas Cargads: "+rutas.size());
        fichero = new FileWriter("c:\\out.txt");
        try
        {
            pw = new PrintWriter(fichero);
             pw.println("== Reporte de entregas == ");
             Dron d=new Dron();
             d.setInicialx(0);
             d.setInicialy(0);
             d.setDirinicial('N');
            for (int i = 0; i < rutas.size();i++)
            {
                String comandos = rutas.get(i);
                System.out.println("Nueva Ruta: "+ comandos);
                d.setComandos(comandos);                
                System.out.println("Posicion de Inicio: ("+d.getInicialx()+","+d.getInicialy()+","+d.getDirinicial()+")" );
                d.despachar();
               
                movimientos=d.obtenerPosicionesDron();
                /*for(int j=0;j<movimientos.size();j++)
                {   
                    PosicionDron mov = new PosicionDron();
                    mov=movimientos.get(j);
                    System.out.println("(" + mov.getX() + ","+ mov.getY() + "," + mov.getdireccion()+ ")");
                }*/
                PosicionDron mov = new PosicionDron();
                mov=movimientos.get(movimientos.size()-1);
                System.out.println("Posicion final: ");
                System.out.println("(" + mov.getX() + ","+ mov.getY() + "," + mov.getdireccion()+ ")");
                pw.println("(" + mov.getX() + ","+ mov.getY() + "," + mov.getdireccion()+ ")"); 
                d.setInicialx(mov.getX());
                d.setInicialy(mov.getY());
                d.setDirinicial(mov.getdireccion());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
           try
           {           
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
      }
      else
      {
        System.out.println("No hay rutas en el archivo");
       }
        
    }
      
    
}
