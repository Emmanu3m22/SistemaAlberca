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
public class Grupo implements Serializable
{

    private static final long serialVersionUID = 1L;
    public static ArrayList<Grupo> arr;
    private int dia;
    private String hora;
    private char tipo;
    private String cve;

    public Grupo()
    {

    }

    public Grupo(int dia, String hora, char tipo, String cve)
    {
        this.dia = dia;
        this.hora = hora;
        this.tipo = tipo;
        this.cve = cve;
    }

    /**
     * @return the dia
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia)
    {
        this.dia = dia;
    }

    /**
     * @return the hora
     */
    public String getHora()
    {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora)
    {
        this.hora = hora;
    }

    /**
     * @return the tipo
     */
    public char getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }

    /**
     * @return the cve
     */
    public String getCve()
    {
        return cve;
    }

    /**
     * @param cve the cve to set
     */
    public void setCve(String cve)
    {
        this.cve = cve;
    }
    
    /**
     * Método que retorna el nombre del día de acuerdo con el número.
     *
     * @return El día en formato String.
     */
    public String getDiaStr()
    {
        switch (this.dia)
        {
            case 1 ->
            {
                return "Domingo";
            }
            case 2 ->
            {
                return "Lunes";
            }
            case 3 ->
            {
                return "Martes";
            }
            case 4 ->
            {
                return "Miercoles";
            }
            case 5 ->
            {
                return "Jueves";
            }
            case 6 ->
            {
                return "Viernes";
            }
            case 7 ->
            {
                return "Sabado";
            }
        }
        return "";
    }

    public String getTipoStr()
    {
        switch (tipo)
        {
            case 'a' ->
            {
                return "Adultos";
            }
            case 'i' ->
            {
                return "Infantil";
            }
            default ->
            {
                return "Error. Tipo = " + tipo;
            }
        }
    }

    /**
     * Método para obtener los datos de cualquier grupo.
     *
     * @return Un String con todos los datos, tabulados y con saltos de línea.
     */
    public String getDatos()
    {
        return "\tDia: " + getDiaStr() + "\n"
                + "\tHora: " + hora + "\n"
                + "\tClave: " + cve + "\n";
    }
    /**
     * Método que concatena un String caracter por caracter y rellenando el
     * restante con espacios hasta conformar una celda de la longitud
     * establecida, concatenando al principio un |
     *
     * @param cad variable de tipo String que concatenará
     * @param longitudColumna longitud que se requiere para la celda
     * @return String que tiene todos los elementos concatenados de la celda
     */
    public static String concatenar(String cad, String relleno, int longitudColumna)
    {
        String s = "| ";
        for (int i = 0; i < longitudColumna; i++)
        {
            if (i < cad.length())
            {
                s += cad.charAt(i);
            } else
            {
                s += relleno;
            }
        }
        s += " ";
        return s;
    }

    public static String concatenarStr(String cad, int iteraciones)
    {
        String s = "";
        for (int i = 0; i < iteraciones; i++)
        {
            s = s.concat(cad);
        }
        return s;
    }

    public static String consultaGrupos()
    {
        String s = "";
        int lonCve = 5,
                lonDia = 9,
                lonHora = 10,
                lonTipo = 8;

        for (int i = 0; i < arr.size() + 1; i++)
        {
            //Concatenación de títulos
            if (i == 0)
            {
                s += " " + concatenarStr("_", 43) + "\n"
                        + concatenar("            Grupos disponibles", " ", 41) + "|\n"
                        + concatenar("Cve", " ", lonCve)
                        + concatenar("Dia", " ", lonDia)
                        + concatenar("Hora", " ", lonHora)
                        + concatenar("Tipo", " ", lonTipo) + "|";
            } else
            {
                for (int j = 1; j <= 4; j++)
                {
                    switch (j)
                    {
                        case 1 ->
                        {
                            s += concatenar(arr.get(i - 1).getCve(), " ", lonCve);
                        }
                        case 2 ->
                        {
                            s += concatenar(arr.get(i - 1).getDiaStr(), " ", lonDia);
                        }
                        case 3 ->
                        {
                            s += concatenar(arr.get(i - 1).getHora(), " ", lonHora);
                        }
                        case 4 ->
                        {
                            s += concatenar(arr.get(i - 1).getTipoStr(), " ", lonTipo) + "|";
                        }
                    }
                }
            }
            s = s.concat("\n");
        }
        return s;
    }
    
    public static String consultarGrupos(Grupo obj)
    {
        String s = "";
        int lonColumna1 = 5,
                lonColumna2 = 10;

        for (int i = 0; i < 5; i++)
        {
            if (i == 0)
            {
                s += concatenar("  Info. del grupo", " ", 18) + "|";
            } else
            {
                for (int j = 0; j < 1; j++)
                {
                    int i2 = i - 1;
                    switch (i2)
                    {
                        case 0 ->
                        {
                            s += concatenar("Clave", " ", lonColumna1) + concatenar(obj.getCve(), " ", lonColumna2) + "|";
                        }
                        case 1 ->
                        {
                            s += concatenar("Dia", " ", lonColumna1) + concatenar(obj.getDiaStr(), " ", lonColumna2) + "|";
                        }
                        case 2 ->
                        {
                            s += concatenar("Hora", " ", lonColumna1) + concatenar(obj.getHora(), " ", lonColumna2) + "|";
                        }
                        case 3 ->
                        {
                            s += concatenar("Tipo", " ", lonColumna1) + concatenar(obj.getTipoStr(), " ", lonColumna2) + "|";
                        }
                    }
                }
            }
            s += "\n";
        }
        return s;
    }
    
    public static String consultarInternosGpo(int index)
    {
        int cantAlumnos = DatosGrales.mat.get(index).size();
        int cont = 0;
        String s = "";
        for (int i = 0; i < cantAlumnos; i++)
        {
            Object persona = DatosGrales.mat.get(index).get(i);
            if (persona instanceof Internos)
            {
                cont++;
                if (cont == 1)
                {
                    s += concatenar("   Internos", " ", 14) + "|\n"
                            + ((Internos) persona).obtenerDatos();
                } else
                {
                    s += ((Internos) persona).obtenerDatos();
                }
            }
        }
        if (cont == 0)
        {
            return "| No hay internos |";
        }
        return s;
    }

    public static String consultarExternosGpo(int index)
    {
        int cantAlumnos = DatosGrales.mat.get(index).size();
        int cont = 0;
        String s = "";
        for (int i = 0; i < cantAlumnos; i++)
        {
            Object persona = DatosGrales.mat.get(index).get(i);
            if (persona instanceof Externos)
            {
                cont++;
                if (cont == 1)
                {
                    s += concatenar("   Externos", " ", 14) + "|\n"
                            + ((Externos) persona).obtenerDatos();
                } else
                {
                    s += ((Externos) persona).obtenerDatos();
                }
            }
        }
        if (cont == 0)
        {
            return "| No hay alumnos externos |";
        }
        return s;
    }
}