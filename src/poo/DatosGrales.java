/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Emmanu3m
 */
public abstract class DatosGrales implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String nom;
    private String dir;
    private int tel;
    private String correo;
    private char nivel;
    private String cveGrupo;
    public static double costo;
    private double precio;
    public static ArrayList<ArrayList<DatosGrales>> mat;

    public DatosGrales(String nom, String dir, int tel, String correo, char nivel, String cveGrupo, double precio)
    {
        this.nom = nom;
        this.dir = dir;
        this.tel = tel;
        this.correo = correo;
        this.nivel = nivel;
        this.cveGrupo = cveGrupo;
        this.precio = precio;
    }

    public DatosGrales()
    {
    }

    /**
     * @return the nom
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    /**
     * @return the dir
     */
    public String getDir()
    {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir)
    {
        this.dir = dir;
    }

    /**
     * @return the tel
     */
    public int getTel()
    {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(int tel)
    {
        this.tel = tel;
    }

    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the nivel
     */
    public char getNivel()
    {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(char nivel)
    {
        this.nivel = nivel;
    }

    /**
     * @return the cveGrupo
     */
    public String getCveGrupo()
    {
        return cveGrupo;
    }

    /**
     * @param cveGrupo the cveGrupo to set
     */
    public void setCveGrupo(String cveGrupo)
    {
        this.cveGrupo = cveGrupo;
    }

    /**
     * @return the costo
     */
    public double getPrecio()
    {
        return precio;
    }

    /**
     * @param precio the costo to set
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public static double getCosto()
    {
        return costo;
    }

    public static void setCosto(double costo)
    {
        DatosGrales.costo = costo;
    }

    public String getNivelStr()
    {
        switch (this.nivel)
        {
            case 'a' ->
            {
                return "avanzado";
            }
            case 'i' ->
            {
                return "intermedio";
            }
            case 'b' ->
            {
                return "basico";
            }
        }
        return "";
    }

    /**
     * Método para obtener los datos generales de cualquier persona.
     *
     * @return Un String con los datos generales tabulados y con saltos de línea
     * de cualquier persona.
     */
    public String obtenerDatos()
    {
        String datos = "";
        datos
                += "\n\t" + "Nombre: " + this.nom + "\n"
                + "\tDirección: " + this.dir + "\n"
                + "\tTeléfono: " + this.tel + "\n"
                + "\tCorreo: " + this.correo + "\n"
                + "\tNivel: " + getNivelStr() + "\n"
                + "\tClave de grupo: " + this.cveGrupo + "\n"
                + "\tPrecio: $" + this.precio + "\n";
        return datos;
    }

    

    /**
     * Método abstracto para calcular el precio que le corresponde pagar a una
     * persona.
     *
     * @return Un double con el precio calculado de acuerdo con las pautas
     * indicadas.
     */
    public abstract double calcPrecio();

    public abstract double precio(double precio);

    public abstract void mostrarDatos();
}
