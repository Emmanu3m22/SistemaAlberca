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
     * Método para preguntar al usuario y obtener el día en que tomará clases.
     *
     * @return El día, validando que su valor se encuentre entre 1 y 7.
     */
    public static int obtenerDia()
    {
        int bandera = 0;
        int dia = 0;
        do
        {
            bandera = 0;
            System.out.println("Ingrese el numero del dia en que tomara clases (1 = Domingo, 2 = Lunes, etc.)");
            dia = LecturasBuffer.entero(true);
            //Validación del día
            if (dia < 1 || dia > 7)
            {
                System.out.println("Dia fuera de rango...");
            }
        } while (dia < 1 || dia > 7);
        return dia;
    }

    /**
     * Método para obtener la hora de clase del grupo.
     *
     * @return Retorna un int con la hora validada que se encuentre entre las 8
     * y 21 horas.
     */
    public static String obtenerHora()
    {
        String hora;

        System.out.println("Ingrese la hora de clase del grupo: ");
        return LecturasBuffer.cadena(true);
    }

    /**
     * Función que obtiene el tipo de grupo que requiera el usuario.
     *
     * @return Retorna un char con 'a' o 'i', dependiendo del tipo requerido por
     * el usuario.
     */
    public static char obtenerTipo()
    {
        int bandera = 0;
        char grupo = ' ';
        do
        {
            bandera = 0;
            System.out.println("Ingrese \"i\" si el grupo es infantil, ingrese \"a\" si es grupo de adultos:");
            grupo = LecturasBuffer.caracterScanner();
            if (grupo != 'i' && grupo != 'a')
            {
                System.out.println("Entrada inválida...");
                bandera = 1;
            }
        } while (bandera != 0);
        return grupo;
    }

    /**
     * Con la clave proporcionada, busca en el arreglo de Grupos si un Grupo
     * tiene la misma clave
     *
     * @param cve Clave proporcionada por el usuario
     * @return Retorna true si la clave es igual a la clave de otro grupo, en
     * otro caso, retorna false.
     */
    public static boolean buscarGpoCve(String cve)
    {
        if (arr == null)
        {
            return false;
        } else
        {
            for (int i = 0; i < Grupo.arr.size(); i++)
            {
                if (Grupo.arr.get(i).getCve().equals(cve))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Con la clave proporcionada, busca en el arreglo de Grupos si un Grupo
     * tiene la misma clave
     *
     * @param cve Clave proporcionada por el usuario
     * @return Retorna true si la clave es igual a la clave de otro grupo, en
     * otro caso, retorna false.
     */
    public static String buscarGpoCve2(String cve)
    {
        if (arr == null)
        {
            return "";
        } else
        {
            for (int i = 0; i < Grupo.arr.size(); i++)
            {
                if (Grupo.arr.get(i).getCve().equals(cve))
                {
                    return cve;
                }
            }
        }
        return "";
    }

    /**
     * Función para obtener el String con la clave por asignarse al grupo.
     *
     * @return Retorna la clave precisada por el usuario.
     */
    public static String obtenerCve()
    {
        String cve = "";
        boolean b;
        do
        {
            b = false;
            cve = obtenerCveSinValidar();
            //Método para buscar si ya existe la clave
            b = buscarGpoCve(cve);
            //Validación de la clave
            if (b)
            {
                System.out.println("La clave ya ha sido ocupada...");
            }
        } while (b);
        return cve;
    }

    public static String obtenerCveSinValidar()
    {
        System.out.println("Ingrese la clave del grupo");
        return LecturasBuffer.cadena(true);
    }

    /**
     * ERROR DE NOMBRE: debería llamarse buscarGrupo, pues no valida que sea
     * interno. Busca si existe algún grupo con la clave proporcionada
     *
     * @param cve clave proporcionada por el usuario para buscar el grupo
     * @return Retorna el Grupo (como objeto) si es que se encuentra algún grupo
     * con la clave solicitada, en otro caso, retorna null;
     */
    public static Grupo buscarGrupoInterno(String cve)
    {
        Grupo obj;
        for (int i = 0; i < arr.size(); i++)
        {
            obj = arr.get(i);
            if (obj.getCve().equals(cve))
            {
                return obj;
            }
        }
        return null;
    }

    /**
     * ERROR DE NOMBRE: debería llamarse buscarGrupoInfantil Busca si existe
     * algún grupo de tipo infantil con la clave proporcionada
     *
     * @param cve clave proporcionada por el usuario para buscar el grupo
     * @return Retorna el Grupo (como objeto) si es que se encuentra algún grupo
     * con la clave solicitada, en otro caso, retorna null;
     */
    public static Grupo buscarGrupoExterno(String cve)
    {
        Grupo obj = null;
        for (int i = 0; i < arr.size(); i++)
        {
            obj = arr.get(i);
            if (obj.getCve().equals(cve) && obj.getTipo() == 'i')
            {
                return obj;
            }
        }
        return obj;
    }

    /**
     * Retorna el indice que ocupa el objeto Grupo en el arreglo arr
     *
     * @param obj
     * @return Si se encuentra el grupo especificado, retorna el índice que
     * ocupa en el arreglo. Si no se encuentra, retorna -1
     */
    public static int encontrarIndexGpo(Grupo obj)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).equals(obj))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna el indice que ocupa el String en el arreglo arr
     *
     * @param obj
     * @return Si se encuentra el grupo especificado, retorna el índice que
     * ocupa en el arreglo. Si no se encuentra, retorna -1
     */
    public static int encontrarIndex(String cve)
    {
        System.out.println("//EncontrarIndex");
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).getCve().equals(cve))
            {
                return i;
            }
        }
        return -1;
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

    public static String retornarTipoStr(char t)
    {
        if (t == 'a')
        {
            return "adultos";
        }
        if (t == 'i')
        {
            return "infantes";
        }
        return "";
    }

    public static String desplegarGrupos(char tipo, int indexGpo)
    {
        boolean existenciaGpos = false;
        boolean b = true;
        String mensaje = "";
        mensaje += "Estos son los grupos de " + retornarTipoStr(tipo) + " disponibles a los que cambiar:\n";
        for (int i = 0; i < arr.size(); i++)
        {
            if (i != indexGpo)
            {
                if (Grupo.arr.get(i).getTipo() == tipo)
                {
                    mensaje += arr.get(i).getDatos();
                    existenciaGpos = true;
                }
            }
        }
        if (!existenciaGpos)
        {
            mensaje = "Aún no existen más grupos de " + retornarTipoStr(tipo) + " disponibles para cambiarse";
        }
        return mensaje;
    }

    /**
     *
     * @param tipoGpo
     * @return Retorna true, si se encuentra algún grupo con el tipoGpo; en otro
     * caso, retorna false.s
     */
    public static boolean existenciaGpos(char tipoGpo, int indexGpo)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            if (i != indexGpo)
            {
                if (arr.get(i).getTipo() == tipoGpo)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void mostrarDatos()
    {
        System.out.printf("%-15s %-10s %-10s %-10s%n", getCve(), getDiaStr(), getHora(), getTipoStr());
    }

}
