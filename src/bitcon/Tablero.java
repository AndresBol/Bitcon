/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitcon;

/**
 *
 * @author Andrés Bolaños
 */
public class Tablero {
    
    public final int QUINARIO = 0;
    public final int OCTAL = 1;
    public final int DECIMAL = 2;
    public final int DUODECIMAL = 3;
    public final int HEXADECIMAL = 4;
    
    private int codigo;
    private String NombreTablero;
    private Ficha[][] tablero;
    private int baseNumerica;
    private boolean tableroGanador;
    
    
    public Tablero(int baseNumerica){
        
        tablero = new Ficha[6][6];
        
        this.baseNumerica = baseNumerica;
        this.tableroGanador = false;
        
        ConstruirTablero();
        
    }

    public void setNombreTablero(String NombreTablero) {
        this.NombreTablero = NombreTablero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreTablero() {
        return NombreTablero;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isTableroGanador() {
        return tableroGanador;
    }

    public void setTableroGanador(boolean tableroGanador) {
        this.tableroGanador = tableroGanador;
    }

    private void ConstruirTablero(){
        
       int randomMin = 1;
       int randomMax = 15;
       
       int numFicha;
        
        for(int DIM01 = 0; DIM01 < 6; DIM01++){
            for(int DIM02 = 0; DIM02 < 6; DIM02++){
                
                numFicha = (int) ((Math.random() * (randomMax - randomMin + 1)) + randomMin);
                
                tablero[DIM02][DIM01] = new Ficha(TrasladarBaseNumerica(numFicha));
                
            
            }
            randomMin = randomMax + 1;
            randomMax = randomMin + 15;
        }
    }
    
    private String TrasladarBaseNumerica(int numFicha){
        
        String nuevoNum = "" + numFicha;
        
        switch (baseNumerica) {
            case QUINARIO:
                nuevoNum = ToQuinaryString(numFicha);
                break;
            case OCTAL:
                nuevoNum = Integer.toOctalString(numFicha);
                break;
            case DUODECIMAL:
                nuevoNum = ToDuodecimalString(numFicha);
                break;
            case HEXADECIMAL:
                nuevoNum = Integer.toHexString(numFicha);
                break;
        }
        
        return nuevoNum;
        
    }
    
    private String ToQuinaryString(int numero){
        StringBuilder ConstructorQuinario = new StringBuilder();

        while (numero > 0) {
            int residuo = numero % 5;
            ConstructorQuinario.insert(0, residuo); 
            numero /= 5;
        }
        
        return ConstructorQuinario.toString();
    }
    
    private String ToDuodecimalString(int numero){
        StringBuilder ConstructorQuinario = new StringBuilder();
        
        while (numero > 0) {
            int residuo = numero % 12;
            ConstructorQuinario.insert(0, ObtenerDigitoDuodecimal(residuo)); 
            numero /= 12;
        }
        
        return ConstructorQuinario.toString();
    }
    
    private char ObtenerDigitoDuodecimal(int residuo) {
        if (residuo < 10) {
            return (char) ('0' + residuo);
        } else {
            return (char) ('A' + residuo - 10);
        }
    }
    
    public String ImprimirTablero(){
        
        String Cadena = "B\ti\tt\tC\to\tn\t\n";
        
        for(int DIM01 = 0; DIM01 < 6; DIM01++){
            for(int DIM02 = 0; DIM02 < 6; DIM02++){
                
                if(tablero[DIM01][DIM02].isMarcada()){
                    Cadena += "|-" + tablero[DIM01][DIM02].getNumeroFicha() + "-|\t";
                }else{
                    Cadena += tablero[DIM01][DIM02].getNumeroFicha() + "\t";
                }
            
            }
            Cadena += "\n";
        }
        
        return Cadena;
    }
    
    public void marcarFichas(int fichaDigitada){
        
        String fichaDigitadaTraducida = TrasladarBaseNumerica(fichaDigitada);
        
        for(int DIM01 = 0; DIM01 < 6; DIM01++){
            for(int DIM02 = 0; DIM02 < 6; DIM02++){
                
                if(tablero[DIM01][DIM02].getNumeroFicha().equals(fichaDigitadaTraducida)){
                    tablero[DIM01][DIM02].setMarcada(true);
                }
            
            }
        }
    }
    
    public boolean verificarTableroLineaHorizontal(){
        boolean validacionFila;
        
        for(int DIM01 = 0; DIM01 < 6; DIM01++){
            validacionFila = true;
            for(int DIM02 = 0; DIM02 < 6; DIM02++){

                if(!tablero[DIM01][DIM02].isMarcada()){
                    validacionFila = false;
                    break;
                }

            }
            if(validacionFila){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean verificarTableroLineaVertical(){
        boolean validacionFila;
        
        for(int DIM01 = 0; DIM01 < 6; DIM01++){
            validacionFila = true;
            for(int DIM02 = 0; DIM02 < 6; DIM02++){

                if(!tablero[DIM02][DIM01].isMarcada()){
                    validacionFila = false;
                    break;
                }

            }
            if(validacionFila){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean verificarTableroLineasDiagonales(){
        
        return verificarTableroDiagonalPrincipal() || verificarTableroDiagonalPrincipalInversa();
    }
    
    private boolean verificarTableroDiagonalPrincipal(){
        
        boolean validacionFila = true;
        
        for(int DIM01 = 0; DIM01 < 6; DIM01++){
            if(!tablero[DIM01][DIM01].isMarcada()){
                validacionFila = false;
                break;
            }
        }
        
        return validacionFila;
    }
    
    private boolean verificarTableroDiagonalPrincipalInversa(){
        
        boolean validacionFila = true;
        
        for(int DIM01 = 5; DIM01 >= 0; DIM01--){
            if(!tablero[DIM01][5-DIM01].isMarcada()){
                validacionFila = false;
                break;
            }
        }
        
        return validacionFila;
    }
    
}
