/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas4n;

/**
 *
 * @author PC
 */
public class PosicionDron {
    private int x;
    private int y;
    private char direccion;
    public PosicionDron()
    {
	this.x = 0;
	this.y = 0;
        this.direccion = 'N';
    }
    public PosicionDron(int x,int y,char direccion)
    {
	this.x = x;
	this.y = y;
        this.direccion = direccion;
    }
    
    public int getX()
    {
        return x;
    }
    public void setX(int x)
    {
	this.x = x;
    }
    public int getY()
    {
	return y;
    }
    public void setY(int y)
    {
	this.y = y;
    }
    public char getdireccion()
    {
	return direccion;
    }

    public void setCardinalPos(char direccion)
    {
        this.direccion = direccion;
    }

    
}
