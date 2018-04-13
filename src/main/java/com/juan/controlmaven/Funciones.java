/*Algunos de los tutoriales que encontré de utilidad fueron los siguientes:
    *https://www.tutorialspoint.com/jsoup/jsoup_load_url.htm Que me sirvió para capturar el html.

 */
package com.juan.controlmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {

    /**
     * Metodo estatico que no devuelve nada.Se encargada de visualizar.
     */
    

    public static void visualizacion() {
        try {
            JOptionPane.showMessageDialog(null, Funciones.tiempo2()+"  "+Funciones.tiempo()+" "+Funciones.capturar());
        } catch (IOException ex) {
            System.out.println("Error al mostrar titulo");
        }

    }

    /**
     * Metodo estatico que devuelve un string con el Titulo de la url. Este
     * metodo captura todo el html de la url insertada.
     *
     * @return el titulo del html.
     * @throws IOException
     */
    public static String capturar() throws IOException {
        String url = "https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP";
        Document document = Jsoup.connect(url).get();
        String titulo = document.title();
        return titulo;
    }
    /***
     * Metodo estatico que devuelve un String con el tiempo en grados.
     * @return el tiempo.
     * @throws IOException 
     */
    public static String tiempo() throws IOException {
        String url = "https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP";
        Document document = Jsoup.connect(url).get();
        String tiempo=document.select("div.today_nowcard-temp").text();
        return tiempo;
    }
    /**
     * Metodo estatico que devuelve un String con el tipo de tiempo que hace.
     * @return devuelve el estado del tiempo.
     * @throws IOException 
     */
    public static String tiempo2() throws IOException{
        String url = "https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP";
        Document document = Jsoup.connect(url).get();
        String tiempo=document.select("div.today_nowcard-phrase").text();
        return tiempo;
    }

}
