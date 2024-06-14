/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import archivos.Archivos;

/**
 *
 * @author Emmanu3m
 */
public class Externos extends DatosGrales
{

    private String folio;
    private int edad;
    public static Integer consecutivo;

    public Externos()
    {
    }

    public Externos(int edad)
    {

        this.edad = edad;
    }

    /**
     * Constructor para crear una persona de tipo Externo, con todos los datos
     * proporcionados por el usuario
     *
     * @param edad
     * @param nom
     * @param dir
     * @param tel
     * @param correo
     * @param nivel
     * @param cveGrupo
     * @param precio
     */
    public Externos(int edad, String nom, String dir, int tel, String correo, char nivel, String cveGrupo, double precio)
    {
        super(nom, dir, tel, correo, nivel, cveGrupo, precio);
        if (Externos.consecutivo == null)
        {
            Externos.consecutivo = 0;
        }
        Externos.consecutivo++;
        String s = Externos.consecutivo.toString();
        //Falta asignación de precio
        String folio = "";
        int contLength = Externos.consecutivo.toString().length();
        switch (contLength)
        {
            case 1:
                folio += "0000";
                break;
            case 2:
                folio += "000";
                break;
            case 3:
                folio += "00";
                break;
            case 4:
                folio += "0";
                break;
        }
        folio += s;
        this.folio = folio;
        this.edad = edad;
    }

    /**
     * @return the folio
     */
    public String getFolio()
    {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio)
    {
        this.folio = folio;
    }

    /**
     * @return the edad
     */
    public int getEdad()
    {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    /**
     * Método que retorna los datos de cualquier Externo.
     *
     * @return Retorna los datos obtenidos de la clase madre (DatosGrales), más
     * los datos específicos de Externos; los datos ya están tabulados y con
     * saltos de línea.
     */
    @Override
    public String obtenerDatos()
    {
        return super.obtenerDatos()
                + "\tFolio: " + getFolio() + "\n"
                + "\tEdad: " + getEdad() + "\n";
    }

    @Override
    public double calcPrecio()
    {
        return DatosGrales.costo * 1.5;
    }

    @Override
    public double precio(double precio)
    {
        return precio + (precio * .50);
    }

    @Override
    public void mostrarDatos()
    {
        System.out.printf("%-10s %-15s %-5s %-20s %-15s %-15s %-15s%n", folio, getNom(), edad, getDir(), getTel(), getNivelStr(), getCveGrupo());
    }

}
