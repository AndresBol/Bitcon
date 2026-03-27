/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitcon;

/**
 *
 * @author Andrés Bolaños
 */
public class Ficha {
    
    private String numeroFicha;
    private boolean marcada;
    
    public Ficha(String num){
        
        this.numeroFicha = num;
        this.marcada = false;
        
    }
    
    public String getNumeroFicha() {
        return numeroFicha;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }
}
