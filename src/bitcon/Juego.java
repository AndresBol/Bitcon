/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitcon;

/**
 *
 * @author Andrés Bolaños
 */
public class Juego {
    private Tablero[] BitconJuego;
    private int tipoTablero;
    
    public final int TABLERO_LINEA_HORIZONTAL = 0;
    public final int TABLERO_LINEA_VERTICAL = 1;
    public final int TABLERO_LINEA_DIAGONAL = 2;
    
    public Juego(int baseNumerica, int tipoTablero){
        
        this.tipoTablero = tipoTablero;
        this.BitconJuego = new Tablero[101];
        
        for(int DIM01 = 0; DIM01 <= 100; DIM01++){
            BitconJuego[DIM01] =  new Tablero(baseNumerica);
            BitconJuego[DIM01].setCodigo(1000 + (DIM01));
            BitconJuego[DIM01].setNombreTablero("Tablero_" + (1000 + (DIM01)));
        }
        
    }
    
    public Tablero ObtenerTablero(int codigo){
        
        for(int DIM01 = 0; DIM01 <= 100; DIM01++){
            if(BitconJuego[DIM01].getCodigo() == codigo){
                return BitconJuego[DIM01];
            }
        }
        
        return null;
    }
    
    public void MarcarTableros(int fichaDigitada){
        for(int DIM01 = 0; DIM01 <= 100; DIM01++){
            BitconJuego[DIM01].marcarFichas(fichaDigitada);
        }
    }
    
    public String ValidarTableros(){
        String Cadena = "";
        
        for(int DIM01 = 0; DIM01 <= 100; DIM01++){
            
            switch (tipoTablero) {
                case TABLERO_LINEA_HORIZONTAL:
                    if(BitconJuego[DIM01].verificarTableroLineaHorizontal()){
                        BitconJuego[DIM01].setTableroGanador(true);
                        Cadena += "¡El tablero con el codigo: " + BitconJuego[DIM01].getCodigo() + " ha ganado!\n";
                    }
                    break;
                case TABLERO_LINEA_VERTICAL:
                    if(BitconJuego[DIM01].verificarTableroLineaVertical()){
                        BitconJuego[DIM01].setTableroGanador(true);
                        Cadena += "¡El tablero con el codigo: " + BitconJuego[DIM01].getCodigo() + " ha ganado!\n";
                    }
                    break;
                case TABLERO_LINEA_DIAGONAL:
                    if(BitconJuego[DIM01].verificarTableroLineasDiagonales()){
                        BitconJuego[DIM01].setTableroGanador(true);
                        Cadena += "¡El tablero con el codigo: " + BitconJuego[DIM01].getCodigo() + " ha ganado!\n";
                    }
                    break;
            }
            
        }
        
        return Cadena;
    }
    
    public int GenerarNumeroDeFichaAleatorio(){
        return (int) ((Math.random() * 95) + 1);
    }
    
    
}
