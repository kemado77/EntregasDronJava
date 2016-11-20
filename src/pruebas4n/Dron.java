/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas4n;

import java.util.*;

/**
 *
 * @author PC
 */
public class Dron {
    private String comandos;
    private List<PosicionDron> listaposiciones = new ArrayList<PosicionDron>();
   
    public Dron()
    {
		
    }
    public Dron(String comandos)
    {
	this.comandos = comandos;
		
    }
    public void setComandos(String comandos)
    {   
        this.comandos=comandos;
    }
    public void despachar()
    {
        int pos_act_x=0;
        int pos_act_y=0;
        char direccion_act='N';
        PosicionDron dpos = new PosicionDron();
        listaposiciones.add(dpos);
        System.out.println("Iniciando despacho");
        for (int i = 0; i < comandos.length(); i++)
        {
            char comando = comandos.charAt(i);
            switch (comando)
            {
                case 'I':
                    direccion_act = girarIzq(direccion_act);
                    dpos = new PosicionDron(pos_act_x, pos_act_y, direccion_act);
                break;
                case 'D':
                    direccion_act = girarDer(direccion_act);
                    dpos = new PosicionDron(pos_act_x, pos_act_y, direccion_act);
                break;
                case 'A':
                    dpos = Avanzar(dpos);
                    direccion_act = dpos.getdireccion();
                    pos_act_x=dpos.getX();
                    pos_act_y=dpos.getY();
                break;
            }
            listaposiciones.add(dpos);
            
        }
    }
    private PosicionDron Avanzar(final PosicionDron dpos)
    {
        PosicionDron nuevapos = new PosicionDron(dpos.getX(), dpos.getY(),dpos.getdireccion());
	switch (nuevapos.getdireccion())
        {
            case 'N':
                int y = nuevapos.getY() + 1;
                nuevapos.setY(y);
            break;
            case 'S':
		y = nuevapos.getY() - 1;
		nuevapos.setY(y);
            break;
            case 'E':
		int x = nuevapos.getX() + 1;
		nuevapos.setX(x);
            break;
            case 'O':
		x = nuevapos.getX() - 1;
		nuevapos.setX(x);
	    break;
	}
	return nuevapos;
    }
    private char girarIzq(char direact)
    {
        char dirfin = direact;
        switch (direact) {
        case 'N':
                dirfin = 'O';
                break;
        case 'O':
                dirfin = 'S';
                break;
        case 'S':
                dirfin = 'E';
                break;
        case 'E':
                dirfin = 'N';
                break;
        }
        return dirfin;
    }
    private char girarDer(char direact)
    {
        char dirfin = direact;
        switch (direact)
        {
            case 'N':
                dirfin = 'E';
            break;
            case 'E':
                dirfin = 'S';
            break;
            case 'S':
                dirfin = 'O';
            break;
            case 'O':
                dirfin = 'N';
            break;
        }
        return dirfin;
    }
    public List<PosicionDron> obtenerPosicionesDron()
    {
	return listaposiciones;
    }
    

}
