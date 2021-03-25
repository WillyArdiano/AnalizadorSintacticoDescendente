
package com.mycompany.analizadordescendente;

public class Analizador {
    
    public static final int ID = 1;
    public static final int NUMERO = 2;
    public static final int PARENTESIS_ABRE = 3;
    public static final int PARENTESIS_CIERRA = 4;
    public static final int SUMA = 5;
    public static final int MULTIPLICACION = 6;
    public static final int FIN_CADENA = 6;
    
    int token;
    
    int [] tokens;
    int tokenIndice = 0;

    public Analizador(int [] tokens) {
        this.tokens = tokens;
    }
    
    //metodo principal
    public void analizar() throws ErrorSintacticoException{
        avanzar();
        produccionE();
    }
    
    public void getToken(){
        token = tokens[tokenIndice]; 
        tokenIndice++;
    }
    
    public void avanzar(){
        getToken();
    }
    
    public void consumir(int token1) throws ErrorSintacticoException{
        if(token1 == token){
            avanzar();
        }else{
            throw new ErrorSintacticoException("Cadena no aceptada");
        }
    }
    
    public void produccionE() throws ErrorSintacticoException{
        if(token==ID||token==NUMERO||token==PARENTESIS_ABRE){
            produccionT(); produccionEp();
        }else{
            throw new ErrorSintacticoException("Cadena no aceptada");
        }
        System.out.println("CADENA ACEPTADA");
    }
    
    public void produccionT() throws ErrorSintacticoException{
        if(token==ID||token==NUMERO||token==PARENTESIS_ABRE){
            produccionF(); produccionTp();
        }
    }
    
    public void produccionEp() throws ErrorSintacticoException{
        if(token==PARENTESIS_CIERRA||token==FIN_CADENA){
            //no hacemos nada
        }else if (token==SUMA){
            consumir(SUMA); produccionT(); produccionEp();
        }else{
            throw new ErrorSintacticoException("Cadena no aceptada");
        }
    }
    
    public void produccionF() throws ErrorSintacticoException{
        if(token==ID){
            consumir(ID);
        }else if(token==NUMERO){
            consumir(NUMERO);
        }else if(token==PARENTESIS_ABRE){
            consumir(PARENTESIS_ABRE); produccionE(); consumir(PARENTESIS_CIERRA);
        }else{
            throw new ErrorSintacticoException("Cadena no aceptada");
        }
    }
    
    public void produccionTp() throws ErrorSintacticoException{
        if(token==PARENTESIS_CIERRA||token==SUMA||token==FIN_CADENA){
            //no hacemos nada
        }else if (token==MULTIPLICACION){
            consumir(MULTIPLICACION); produccionT(); produccionEp();
        }else{
            throw new ErrorSintacticoException("Cadena no aceptada");
        }
    }
    
}
