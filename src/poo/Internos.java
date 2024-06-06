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

    /**
     * Obtiene el número de control del Interno.
     *
     * @return Un String validando que el número de control contenga únicamente
     * números.
     */
    public static String obtenerNoCtrl()
    {
        String noCtrl = "";
        int bandera;
        do
        {
            bandera = 0;
            System.out.println("Ingrese su numero de control");
            noCtrl = LecturasBuffer.cadena(true);

            for (int i = 0; i < noCtrl.length(); i++)
            {
                switch (noCtrl.charAt(i))
                {
                    case '0' ->
                    {
                    }
                    case '1' ->
                    {
                    }
                    case '2' ->
                    {
                    }
                    case '3' ->
                    {
                    }
                    case '4' ->
                    {
                    }
                    case '5' ->
                    {
                    }
                    case '6' ->
                    {
                    }
                    case '7' ->
                    {
                    }
                    case '8' ->
                    {
                    }
                    case '9' ->
                    {
                    }
                    default ->
                    {
                        bandera = 2;
                        System.out.println("El numero de control debe contener únicamente numeros...");
                    }
                }
                if (bandera == 2)
                {
                    break;
                }
                if (compararNoCtrl(noCtrl))
                {
                    System.out.println("El numero de control ya ha sido ocupado por alguien mas...");
                    bandera = 1;
                    break;
                }
            }
        } while (bandera != 0);
        return noCtrl;
    }

    public static boolean compararNoCtrl(String noCtrl)
    {
        for (int i = 0; i < DatosGrales.mat.size(); i++)
        {
            for (int j = 0; j < DatosGrales.mat.get(i).size(); j++)
            {
                DatosGrales per = DatosGrales.mat.get(i).get(j);
                if (per instanceof Internos)
                {
                    if (((Internos) per).getNoCtrl().equals(noCtrl))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Obtiene el número de semestre del usuario.
     *
     * @return Un int entre 1 y 13 (inclusivo), del semestre proporcionado por
     * el usuario.
     */
    public static int obtenerSem()
    {
        int ns;
        do
        {
            ns = 0;
            System.out.println("Ingrese el número del semestre");
            ns = LecturasBuffer.entero(true);
            if (!(ns > 0 && ns <= 13))
            {
                System.out.println("Semestre fuera de rango...");
            }
        } while (!(ns > 0 && ns <= 13));
        return ns;
    }

    /**
     * Función que permite al usuario seleccionar el grupo de tipo adulto que
     * desee ingresando la clave deseada. Primero se revisa que hayan grupos de
     * adultos creados para poder mostrarlos. Una vez validando que existan
     * grupos, con ayuda de un for y del método getDatos() de los Grupos, se
     * concatenan todos los grupos que cumplan con la condición de que el tipo
     * sea igual a 'a'.
     *
     * @return Si existen grupos de adultos registrados, retorna el grupo
     * elegido (como objeto); si no existen grupos de adultos registrados,
     * retorna null.
     */
    public static Grupo seleccionarGrupoAdultos()
    {
        String mensaje;
        Grupo obj = null;
        boolean b;
        do
        {
            boolean existenciaGpos = false;
            b = true;
            mensaje = "";
            mensaje += "Estos son los grupos disponibles para Adultos:\n";
            for (int i = 0; i < Grupo.arr.size(); i++)
            {
                if (Grupo.arr.get(i).getTipo() == 'a')
                {
                    mensaje += Grupo.arr.get(i).getDatos();
                    existenciaGpos = true;
                }
            }
            if (!existenciaGpos)
            {
                mensaje = "Aún no existen grupos para adultos";
                System.out.println(mensaje);
                return null;
            } else
            {
                mensaje += "\nIngrese la clave del grupo al que desee ingresar:";
                System.out.println(mensaje);
                obj = Grupo.buscarGrupoInterno(LecturasBuffer.cadena(true));
                if (obj == null)
                {
                    System.out.println("Clave invalida, intente de nuevo...");
                    b = false;
                }
            }
        } while (!b);
        return obj;
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
