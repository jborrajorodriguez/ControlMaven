package com.juan.controlmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {
    /**
     * Metodo estatico que no devuelve nada encargado de visualizar.
     */
    public static void visualizacion(){
        try {
            JOptionPane.showMessageDialog(null,Funciones.capturar());
        } catch (IOException ex) {
            System.out.println("Error al mostrar titulo");
        }
        
    }
    /**
     * Metodo estatico que devuelve un string con el Titulo de la url.
     * Este metodo captura todo el html de la url insertada.
     * @return el titulo del html.
     * @throws IOException 
     */
    public static String capturar() throws IOException{
        String url="https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP";
        Document document = Jsoup.connect(url).get();
        String titulo=document.title();
        return titulo;
    }

}
