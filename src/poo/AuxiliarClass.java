/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.util.ArrayList;
import static poo.Grupo.arr;
import static poo.DatosGrales.mat;

/**
 *
 * @author Emmanu3m
 */
public class AuxiliarClass
{

    public AuxiliarClass()
    {
    }

    public static int obtenerCve2(String cveGpo)
    {
        int salida = 0;
        for (Grupo grupos : arr)
        {
            if (!cveGpo.equals(grupos.getCve()))
            {
                salida = 1;
            } else
            {
                salida = -1;
            }

        }
        return salida;
    }

    public static int obtenerNom2(String name, int posicionv)
    {
        int salida = 0;
        for (DatosGrales persona : mat.get(posicionv))
        {
            if (!name.equals(persona.getNom()))
            {
                salida = 1;
            } else
            {
                salida = -1;
            }
        }
        return salida;
    }

    public static double modPrice()
    {
        DatosGrales gral = new DatosGrales()
        {
            @Override
            public double precio(double costo)
            {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double calcPrecio()
            {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mostrarDatos()
            {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        };
        double costo;
        System.out.println("Ingrese el nuevo costo de registro: ");
        costo = LecturasBuffer.doble(true);
        while (costo <= 0)
        {
            System.out.println("Error...(El costo minimo es 1)\nIngrese el nuevo costo del registro: ");
            costo = LecturasBuffer.doble(true);
        }
        gral.setCosto(costo);
        System.out.println("El costo se modifico correctamente!");
        return 0;
    }

    public void encontrarAlumno(ArrayList<ArrayList<DatosGrales>> mat, String nom)
    {
        boolean b = false;
        for (int i = 0; i < mat.size(); i++)
        {
            for (int j = 0; j < mat.get(i).size(); j++)
            {
                if (mat.get(i).get(j).getNom().equals(nom))
                {
                    System.out.println("El alumno se encuentra en el grupo con clave: " + Grupo.arr.get(i).getCve());
                    System.out.println(Grupo.arr.get(i).consultarGrupos(Grupo.arr.get(i)));
                    b = true;
                    break;
                }
            }
            if (b)
            {
                break;
            }
        }
        if (!b)
        {
            System.out.println("Alumno no encontrado");
        }
    }

    public int determinarGpoConMasAlumnos(ArrayList<ArrayList<DatosGrales>> mat)
    {
        int cantAl = 0;
        int cont;
        int indexGpo = 0;
        for (int i = 0; i < mat.size(); i++)
        {
            cont = 0;
            for (int j = 0; j < mat.get(i).size(); j++)
            {
                cont++;
            }
            if (cont > cantAl)
            {
                cantAl = cont;
                indexGpo = i;
            }
        }
        System.out.println("El grupo con mayor cantidad de alumnos es aquel con clave: " + Grupo.arr.get(indexGpo).getCve() + " con " + cantAl + " alumnos.");
        return cantAl;
    }

    public String imprimirPrecs()
    {
        String s = "";
        for (int i = 0; i < mat.size(); i++)
        {
            s += "Grupo: " + i;
            for (int j = 0; j < mat.get(i).size(); j++)
            {
                s += "\tPrecio alumno  " + j + " " + String.valueOf(mat.get(i).get(j).getPrecio()) + "\n";
            }
        }
        s += "\n";
        return s;
    }

    public void cambiarPrecTodos(ArrayList<ArrayList<DatosGrales>> mat)
    {
        System.out.println("PRECIOS VIEJOS\n" + imprimirPrecs());
        for (int i = 0; i < mat.size(); i++)
        {

            for (int j = 0; j < mat.get(i).size(); j++)
            {
                mat.get(i).get(j).setPrecio(mat.get(i).get(j).calcPrecio());

            }
        }
        System.out.println("Precio actualizado con exito!");
        System.out.println("PRECIOS NUEVOS\n" + imprimirPrecs());
    }

    //MÉTODOS DE DATOSGRALES
    /**
     * Método que obtiene del usuario y valida el nombre.
     *
     * @return Un String con el nombre de la persona.
     */
    public String obtenerNom()
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
    public String obtenerDir()
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
    public int obtenerTel()
    {

        System.out.println("Ingrese su numero telefonico");
        return LecturasBuffer.entero(true);
    }

    /**
     * Método que obtiene el correo electrónico del usuario.
     *
     * @return Un String con la dirección del correo electrónico.
     */
    public String obtenerCorreo()
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
    public char obtenerNivel()
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
    public int tipoPersona()
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
    public void aniadirAdulto(DatosGrales inscrito, int index)
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
    public String consultaInEx(int tipo)
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

    public void despDatosMat()
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

    public Object buscarPersona(String nom, int index)
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
     * @return Retorna el índice de la persona si se encuentra. Si no se
     * encuentra, retorna -1.
     */
    public int buscarIndexPersona(String nom, int indexGpo)
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

    public int menuDesplegarGrupos()
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

    //MÉTODOS DE INTERNOS
    /**
     * Obtiene el número de control del Interno.
     *
     * @return Un String validando que el número de control contenga únicamente
     * números.
     */
    public String obtenerNoCtrl()
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

    public boolean compararNoCtrl(String noCtrl)
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
    public int obtenerSem()
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
    public Grupo seleccionarGrupoAdultos()
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
                obj = buscarGrupoInterno(LecturasBuffer.cadena(true));
                if (obj.getTipo() == 'i')
                {
                    System.out.println("Grupo no disponible para adultos...");
                    b = false;
                }
                if (obj == null)
                {
                    System.out.println("Clave invalida, intente de nuevo...");
                    b = false;
                }
            }
        } while (!b);
        return obj;
    }

    //MÉTODOS DE EXTERNOS
    /**
     * Método que obtiene la edad preguntando al usuario.
     *
     * @return Retorna un int con la edad validando que sea mayor que 1.
     */
    public int obtenerEdad()
    {
        boolean b;
        int edad;
        do
        {
            edad = 0;
            b = false;
            System.out.println("Ingrese la edad: ");
            edad = LecturasBuffer.entero(true);
            if (edad < 1)
            {
                System.out.println("Edad fuera de rango...");
                b = true;
            }
        } while (b);
        return edad;
    }

    //Preguntar primero la edad
    public Grupo seleccionarGrupoNinios()
    {
        String mensaje;
        Grupo obj = null;
        boolean b;
        do
        {
            boolean existenciaGpos = false;
            b = true;
            mensaje = "";
            //Se necesita concatenar esto después del for
            mensaje += "Estos son los grupos disponibles para niños:\n\n";
            for (int i = 0; i < Grupo.arr.size(); i++)
            {
                if (Grupo.arr.get(i).getTipo() == 'i')
                {
                    mensaje += Grupo.arr.get(i).getDatos() + "\n";
                    existenciaGpos = true;
                }
            }
            if (!existenciaGpos)
            {
                mensaje = "Aún no existen grupos para niños";
                System.out.println(mensaje);
                return null;
            } else
            {
                mensaje += "Ingrese la clave del grupo al que desee ingresar:";
                System.out.println(mensaje);
                obj = buscarGrupoInterno(LecturasBuffer.cadena(true));
                if (obj.getTipo() != 'i')
                {
                    System.out.println("Grupo no disponible para niños...");
                    b = false;
                }
                if (obj == null)
                {
                    System.out.println("Clave invalida, intente de nuevo...");
                    b = false;
                }
            }
        } while (!b);
        return obj;
    }

    //MÉTODOS GRUPOS
    /**
     * Método para preguntar al usuario y obtener el día en que tomará clases.
     *
     * @return El día, validando que su valor se encuentre entre 1 y 7.
     */
    public int obtenerDia()
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
    public String obtenerHora()
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
    public char obtenerTipo()
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
    public boolean buscarGpoCve(String cve)
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
    public String buscarGpoCve2(String cve)
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
    public String obtenerCve()
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

    public String obtenerCveSinValidar()
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
    public Grupo buscarGrupoInterno(String cve)
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
    public Grupo buscarGrupoExterno(String cve)
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
    public int encontrarIndexGpo(Grupo obj)
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
    public int encontrarIndex(String cve)
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

    public String retornarTipoStr(char t)
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

    public String desplegarGrupos(char tipo, int indexGpo)
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
    public boolean existenciaGpos(char tipoGpo, int indexGpo)
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
        Grupo g = new Grupo();
        System.out.printf("%-15s %-10s %-10s %-10s%n", g.getCve(), g.getDiaStr(), g.getHora(), g.getTipoStr());
    }

}
