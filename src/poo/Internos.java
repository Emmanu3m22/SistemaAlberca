/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.io.Serializable;

/**
 *
 * @author Emmanu3m
 */
public class Internos extends DatosGrales implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String noCtrl;
    private int semestre;

    public Internos()
    {
    }

    public Internos(String noCtrl, int semestre)
    {
        this.noCtrl = noCtrl;
        this.semestre = semestre;
    }

    public Internos(String noCtrl, int semestre, String nom, String dir, int tel, String correo, char nivel, String cveGrupo, double precio)
    {
        super(nom, dir, tel, correo, nivel, cveGrupo, precio);
        this.noCtrl = noCtrl;
        this.semestre = semestre;
    }

    /**
     * @return the noCtrl
     */
    public String getNoCtrl()
    {
        return noCtrl;
    }

    /**
     * @param noCtrl the noCtrl to set
     */
    public void setNoCtrl(String noCtrl)
    {
        this.noCtrl = noCtrl;
    }

    /**
     * @return the semestre
     */
    public int getSemestre()
    {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre)
    {
        this.semestre = semestre;
    }

    @Override
    public String obtenerDatos()
    {
        return super.obtenerDatos()
                + "\tNo. de Control: " + this.noCtrl + "\n"
                + "\tSemestre: " + this.semestre + "\n";
    }

    

    @Override
    public double calcPrecio()
    {
        return DatosGrales.costo * 0.5;
    }

    @Override
    public double precio(double precio)
    {
        return precio - (precio * .50);
    }

    @Override
    public void mostrarDatos()
    {
        System.out.printf("%-10s %-15s %-10s %-20s %-15s %-15s %-15s%n", noCtrl, getNom(), semestre, getDir(), getTel(), getNivelStr(), getCveGrupo());
    }

}
