
package com.mycompany.analizadordescendente;


public class Principal {
    
    public static void main(String[] args) {
        int [] tokens = {Analizador.NUMERO,Analizador.SUMA,Analizador.ID,Analizador.MULTIPLICACION,Analizador.PARENTESIS_ABRE,Analizador.ID,Analizador.MULTIPLICACION,Analizador.PARENTESIS_CIERRA,Analizador.FIN_CADENA};
        Analizador analizador = new Analizador(tokens);
        try {
            analizador.analizar();
        } catch (ErrorSintacticoException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
