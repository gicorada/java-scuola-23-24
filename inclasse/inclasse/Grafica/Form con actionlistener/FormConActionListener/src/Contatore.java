/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author radaelli11353
 */
public class Contatore {
    private int n;
    
    public Contatore() {
        n = 0;
    }
    
    public void incrementa() {
        n++;
    }
    
    public void decrementa() {
        n--;
    }
    
    public void reset() {
        n = 0;
    }
    
    public int getContatore() {
        return n;
    }
    
    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
