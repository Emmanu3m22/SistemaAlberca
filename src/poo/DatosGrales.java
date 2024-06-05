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
     * Método que obtiene del usuario y valida el nombre.
     *
     * @return Un String con el nombre de la persona.
     */
    public static String obtenerNom()
    {
        do
        {
            System.out.println("Ingrese el nombre");
            String s = LecturasBuffer.cadena(true);
            if (!s.equals(""))
            {
                return s;
            } else
            {
                System.out.println("Entrada incorrecta...");
            }
        } while (true);
    }

    /**
     * Método que obtiene la dirección del usuario y lo valida.
     *
     * @return Un String con la dirección de la persona.
     */
    public static String obtenerDir()
    {
        do
        {
            System.out.println("Ingrese su dirección");
            String s = LecturasBuffer.cadena(true);
            if (!s.equals("\n") && !s.equals(""))
            {
                return s;
            } else
            {
                System.out.println("Entrada incorrecta...");
            }
        } while (true);
    }

    /**
     * Método que obtiene el teléfono del usuario.
     *
     * @return Un int con el teléfono de la persona.
     */
    public static int obtenerTel()
    {

        System.out.println("Ingrese su numero telefonico");
        return LecturasBuffer.entero(true);
    }

    /**
     * Método que obtiene el correo electrónico del usuario.
     *
     * @return Un String con la dirección del correo electrónico.
     */
    public static String obtenerCorreo()
    {
        do
        {
            System.out.println("Ingrese la direccion de su correo electronico");
            String s = LecturasBuffer.cadena(true);
            if (s != null)
            {
                if (!s.equals("\n") && !s.equals(""))
                {
                    return s;
                }
            }
            System.out.println("Entrada incorrecta... ");
        } while (true);

    }

    /**
     * Obtiene el nivel de la persona.
     *
     * @return Retorna un char, validando que sea o 'a' o 'b' o 'i'.
     */
    public static char obtenerNivel()
    {
        boolean b = true;
        char n = ' ';
        do
        {
            b = true;
            System.out.println("Ingrese \"b\", si su nivel es básico; \"i\", si su nivel es intermedio; o \"a\", si es avanzado:");
            n = LecturasBuffer.caracter(true);
            if (n != 'a' && n != 'b' && n != 'i')
            {
                b = false;
                System.out.println("Entrada incorrecta, intente de nuevo...");
            }
        } while (!b);
        return n;
    }

    /**
     * Método que obtiene el tipo de alumno que es la persona: Interno o
     * Externo, retornando 1 si es Interno, y 2 si es Externo.
     *
     * @return Retorna 1 si es Externo o 2 si es Interno.
     */
    public static int tipoPersona()
    {
        int res = 0;
        do
        {
            System.out.println("Si usted es alumno, administrativo o docente del ITTOL, escriba 1; de lo contrario, escriba 2");
            res = LecturasBuffer.entero(true);
            if (res != 1 && res != 2)
            {
                System.out.println("Entrada inválida, intente de nuevo...");
            }
        } while (res != 1 && res != 2);
        return res;
    }

    /**
     * Método que añade un inscrito a la matriz de DatosGrales.
     *
     * @param inscrito El objeto por añadir (puede ser interno o externo).
     * @param index El índice donde se agregará.
     */
    public static void aniadirAdulto(DatosGrales inscrito, int index)
    {
        mat.get(index).add(inscrito);
    }

    /**
     * Función que retorna un String con los datos de los inscritos, pueden ser
     * internos o externos.
     *
     * @param tipo El tipo de personas que requieren obtenerse.
     * @return Un String en forma de lista que contiene todos los alumnos
     * inscritos del tipo requerido. En caso de no haber alumnos inscritos del
     * tipo requerido, retorna un mensaje de no inscritos.
     */
    public static String consultaInEx(int tipo)
    {
        String s = "";
        if (mat != null)
        {
            for (int i = 0; i < mat.size(); i++)
            {
                for (int j = 0; j < mat.get(i).size(); j++)
                {
                    if (tipo == 1)
                    {
                        if (mat.get(i).get(j) instanceof Internos)
                        {
                            Internos in = (Internos) mat.get(i).get(j);
                            s += in.obtenerDatos();
                        }
                    } else
                    {
                        if (mat.get(i).get(j) instanceof Externos)
                        {
                            Externos in = (Externos) mat.get(i).get(j);
                            s += in.obtenerDatos();
                        }
                    }
                }
            }
        } else
        {
            return "Aún no hay personas inscritas";
        }
        if (s.equals("") && tipo == 1)
        {
            return "Aún no hay internos inscritos";
        }
        if (s.equals("") && tipo != 1)
        {
            return "Aún no hay externos inscritos";
        }
        return s;
    }

    public static void despDatosMat()
    {
        for (int i = 0; i < Grupo.arr.size(); i++)
        {
            System.out.println("Grupo: " + Grupo.arr.get(i).getCve());
            for (int j = 0; j < mat.get(i).size(); j++)
            {
                System.out.println("\tPersona: " + mat.get(i).get(j).obtenerDatos());
            }
        }
    }

    public static Object buscarPersona(String nom, int index)
    {
        for (int i = 0; i < DatosGrales.mat.get(index).size(); i++)
        {
            if (DatosGrales.mat.get(index).get(i).getNom().equals(nom))
            {
                return DatosGrales.mat.get(index).get(i);
            }
        }
        return null;
    }
    
    /**
     * 
     * @param nom
     * @param indexGpo
     * @return Retorna el índice de la persona si se encuentra. Si no se encuentra, retorna -1.
     */
    public static int buscarIndexPersona(String nom, int indexGpo)
    {
        for (int i = 0; i < DatosGrales.mat.get(indexGpo).size(); i++)
        {
            if (DatosGrales.mat.get(indexGpo).get(i).getNom().equals(nom))
            {
                return i;
            }
        }
        return -1;
    }

    public static int menuDesplegarGrupos()
    {
        int op;
        do
        {
            System.out.println("A continuación debe ingresar la clave del grupo al que desee cambiarse. Desea mostrar todos los grupos?\n1 = si\n2 = no:");
            op = LecturasBuffer.entero(true);
            if (op < 1 && op > 2)
            {
                System.out.println("Opcion incorrecta...");
            }
        } while (op < 1 && op > 2);
        return op;
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
