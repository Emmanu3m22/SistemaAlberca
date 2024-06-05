/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import archivos.Archivos;
import java.io.Serializable;
import java.util.ArrayList;
import static poo.DatosGrales.mat;
import static poo.Grupo.arr;
import poo.LecturasBuffer;
import static poo.DatosGrales.obtenerNom;
import static poo.Grupo.obtenerCve;
import static poo.AuxiliarClass.obtenerCve2;
import static poo.AuxiliarClass.obtenerNom2;

/**
 *
 * @author Emmanu3m
 */
public class PrbPE implements Serializable
{

    private static final long serialVersionUID = 1L;
    static Boolean firsTime;
    static Boolean case1;

    public static void main(String[] args)
    {
        firsTime = (Boolean) Archivos.cargarFirst("firsTime");
        if (!firsTime)
        {
            cargarDatos();
        } else
        {
            firsTime = true;
            case1 = false;
            DatosGrales.costo = 500;
        }
        int op;
        do
        {
            op = menu();
            switch (op)
            {
                case 1 ->
                {
                    int dia = Grupo.obtenerDia();
                    String hora = Grupo.obtenerHora();
                    char tipo = Grupo.obtenerTipo();
                    String cve = Grupo.obtenerCve();
                    //Creación del grupo
                    Grupo g = new Grupo(dia, hora, tipo, cve);
                    if (Grupo.arr == null)
                    {
                        Grupo.arr = new ArrayList<>();
                        DatosGrales.mat = new ArrayList<ArrayList<DatosGrales>>();
                    }
                    Grupo.arr.add(g);
                    ArrayList<DatosGrales> a = new ArrayList<DatosGrales>();
                    DatosGrales.mat.add(a);
                    case1 = true;
                }
                case 2 ->
                {
                    if (!case1)
                    {
                        System.out.println("Primero cree un grupo");
                    } else
                    {
                        int tipoPersona = DatosGrales.tipoPersona();
                        System.out.println("Todos los datos requeridos serán del o la interesada en inscribirse al servicio");
                        if (tipoPersona == 1)
                        {
                            //Internos
                            Grupo g = Internos.seleccionarGrupoAdultos();
                            if (g != null)
                            {
                                Internos in = new Internos();
                                //Obtención de datos
                                String noCtrl = Internos.obtenerNoCtrl();
                                int sem = Internos.obtenerSem();
                                String nom = DatosGrales.obtenerNom();
                                String dir = DatosGrales.obtenerDir();
                                int tel = DatosGrales.obtenerTel();
                                String correo = DatosGrales.obtenerCorreo();
                                char nivel = DatosGrales.obtenerNivel();
                                //Creación de interno
                                Internos i = new Internos(noCtrl, sem, nom, dir, tel, correo, nivel, g.getCve(), in.calcPrecio());
                                int index = g.encontrarIndexGpo(g);
                                DatosGrales.mat.get(index).add(i);
                                System.out.println(i.obtenerDatos());
                            }
                        } else
                        {
                            //Externos
                            Grupo g;
                            Externos ex = new Externos();
                            int edad = Externos.obtenerEdad();
                            if (edad >= 18)
                            {
                                g = Internos.seleccionarGrupoAdultos();
                            } else
                            {
                                g = Externos.seleccionarGrupoNinios();
                            }
                            if (g != null)
                            {
                                String nom = DatosGrales.obtenerNom();
                                String dir = DatosGrales.obtenerDir();
                                int tel = DatosGrales.obtenerTel();
                                String correo = DatosGrales.obtenerCorreo();
                                char nivel = DatosGrales.obtenerNivel();
                                Externos e = new Externos(edad, nom, dir, tel, correo, nivel, g.getCve(), ex.calcPrecio());
                                int index = g.encontrarIndexGpo(g);
                                System.out.println(e.obtenerDatos());
                                DatosGrales.mat.get(index).add(e);
                            }
                        }
                    }
                }
                case 3 ->
                {
                    //Código EMMA.
//                    double cost;
//                    do
//                    {
//                        System.out.println("Ingrese el costo nuevo: ");
//                        cost = LecturasBuffer.doble(true);
//                        if (cost <= 0)
//                        {
//                            System.out.println("El costo debe ser mayor que cero");
//                        }
//                    } while (cost <= 0);
//                    DatosGrales.costo = cost;
                    //Código FRAN.
                    System.out.println(AuxiliarClass.modPrice());
                }
                case 4 ->
                {
                    //Código emma
                    if (Grupo.arr == null || !case1)
                    {
                        System.out.println("Primero cree un grupo");
                    } else
                    {
                        System.out.println(Grupo.consultaGrupos());
                    }
                    //Códifo fran
//                    String s = "";
//                    if (!Grupo.arr.isEmpty())
//                    {
//                        s += "_";
//                        s += "\nClave\tDia\tHora\tTipo";
//                        for (Grupo grupos : Grupo.arr)
//                        {
//                            s += "\n" + grupos.toString();
//                        }
//                        s += "\n_\n";
//                    } else
//                    {
//                        System.err.println("No hay ningun grupo registrado");
//                    }
//                    System.out.println(s);
                }
                case 5 ->
                {
                    //Código EMMA
                    //Validar que existan grupos
                    if (Grupo.arr != null || case1)
                    {
                        boolean b;
                        do
                        {
                            //Solicitar grupo viejo.
                            b = false;
                            String nom;
                            String cve = Grupo.obtenerCveSinValidar();
                            if (Grupo.buscarGpoCve(cve))
                            {
                                Grupo gpo = Grupo.buscarGrupoInterno(cve);
                                int indexGpoViejo = Grupo.encontrarIndex(cve);
                                //Validar que el grupo no esté vacío
                                if (!DatosGrales.mat.get(indexGpoViejo).isEmpty())
                                {
                                    //Obtener nombre
                                    Object persona;
                                    do
                                    {
                                        nom = DatosGrales.obtenerNom();
                                        persona = DatosGrales.buscarPersona(nom, indexGpoViejo);
                                        if (persona == null)
                                        {
                                            System.out.println("No hay alguna persona con ese nombre...");
                                        }
                                    } while (persona == null);
                                    int indexPersona = DatosGrales.buscarIndexPersona(nom, indexGpoViejo);
                                    if (persona != null)
                                    {
                                        //Impresión de datos de la persona.
                                        if (persona instanceof Internos)
                                        {
                                            System.out.println("Sus datos son:");
                                            System.out.println(((Internos) persona).obtenerDatos());
                                        }
                                        if (persona instanceof Externos)
                                        {
                                            System.out.println("Sus datos son:");
                                            System.out.println(((Externos) persona).obtenerDatos());
                                        }

                                        char tipoGrupoViejo = gpo.getTipo();
                                        //Desplegar información de grupos.
                                        if (tipoGrupoViejo == 'a')
                                        {
                                            System.out.println(Grupo.desplegarGrupos('a', indexGpoViejo));
                                        } else
                                        {
                                            System.out.println(Grupo.desplegarGrupos('i', indexGpoViejo));
                                        }
                                        //Validar que existan grupos distintos para cambiarse de grupo.
                                        if (Grupo.existenciaGpos(tipoGrupoViejo, indexGpoViejo))
                                        {
                                            //Dowhile para pedir clave del nuevo grupo
                                            int b1;
                                            do
                                            {
                                                b1 = 0;
                                                int indexGpoNvo;
                                                String nvaCve;
                                                boolean b3;

                                                b3 = false;
                                                nvaCve = Grupo.obtenerCveSinValidar();
                                                indexGpoNvo = Grupo.encontrarIndex(nvaCve);
                                                Grupo nvoGpo;
                                                if (indexGpoNvo != -1)
                                                {
                                                    nvoGpo = Grupo.buscarGrupoInterno(nvaCve);
                                                    if (nvoGpo.getTipo() == tipoGrupoViejo)
                                                    {
                                                        //Cambio de grupo
                                                        ((DatosGrales) persona).setCveGrupo(nvoGpo.getCve());
                                                        DatosGrales.mat.get(indexGpoViejo).remove(persona);
                                                        DatosGrales.mat.get(indexGpoNvo).add((DatosGrales) persona);
                                                        System.out.println("Usted ha sido cambiado al grupo con clave \"" + nvoGpo.getCve() + "\" exitosamente!");
                                                    } else
                                                    {
                                                        System.out.println("No puede ingresar al grupo seleccionado, pues no corresponde a su edad...");
                                                        b1 = 1;
                                                    }
                                                } else
                                                {
                                                    System.out.println("No se encontro el grupo...");
                                                    b1 = 1;
                                                }
                                            } while (b1 != 0);
                                        } else
                                        {
                                            break;
                                        }
                                    } else
                                    {
                                        System.out.println("No hay alguna persona con ese nombre...");
                                        b = true;
                                    }
                                } else
                                {
                                    System.out.println("El grupo no contiene ningún alumno registrado");
                                }
                            } else
                            {
                                //Validación grupo viejo
                                System.out.println("No hay grupos con esa clave...");
                                b = true;
                            }
                        } while (b);

                    } else
                    {
                        System.out.println("No hay grupos registrados aun...");
                    }
                    //Código FRAN
//                    String cveGpo, name, nuevGpo;
//                    char tgpo = ' ';
//                    boolean busqueda = true, valid = true;
//                    int posicionv = 0, posicion = 0;
//                    if (!mat.isEmpty() && arr.size() > 1)
//                    {
//                        cveGpo = LecturasBuffer.entradaCadena("Ingrese su grupo actual: ");
//                        //Localizar Grupo
//                        while (busqueda)
//                        {
//
//                            if (obtenerCve2(cveGpo) == 1)
//                            {
//                                System.err.println("Clave de grupo no existente");
//                                cveGpo = LecturasBuffer.entradaCadena("Error...Dame otra clave de grupo: ");
//                                busqueda = true;
//                            }
//
//                            for (Grupo grupos : arr)
//                            {
//                                if (obtenerCve2(cveGpo) == -1)
//                                {
//                                    busqueda = false;
//                                    tgpo = grupos.getTipo();
//                                    break;
//                                }
//                            }
//                        }//fin while
//
//                        //Obtener posicion
//                        for (int i = 0; i < arr.size(); i++)
//                        {
//                            if (arr.get(i).getCve().equals(cveGpo))
//                            {
//                                posicionv = i;
//                                break;
//                            }
//                        }
//                        name = LecturasBuffer.entradaCadena("Ingrese su nombre: ");
//                        //Localizar Persona
//                        busqueda = true;
//                        while (busqueda)
//                        {
//
//                            if (AuxiliarClass.obtenerNom2(name, posicionv) == 1)
//                            {
//                                System.err.println("Nombre no existente");
//                                name = LecturasBuffer.entradaCadena("Error");
//                                busqueda = true;
//                            }
//
//                            for (DatosGrales persona : mat.get(posicionv))
//                            {
//                                if (obtenerNom2(name, posicionv) == -1)
//                                {
//                                    System.out.println("Grupo actual: \n");
//                                    System.out.println("\nClave\tDia\tHora\tTipo");
//                                    System.out.println(arr.get(posicionv).toString() + "\n");
//                                    System.out.println(persona.toString() + "\n");
//                                    busqueda = false;
//                                    break;
//                                }
//                            }
//                        }//fin while
//
//                        nuevGpo = LecturasBuffer.entradaCadena("Ingresa la clave del grupo nuevo: ");
//                        //Localizar Grupo nuevo
//                        while (busqueda && valid)
//                        {
//
//                            if (obtenerCve2(nuevGpo) == 1)
//                            {
//                                System.err.println("No existente");
//                                nuevGpo = LecturasBuffer.entradaCadena("Error");
//                                busqueda = true;
//                            }
//
//                            for (Grupo grupos : arr)
//                            {
//                                if (obtenerCve2(nuevGpo) == -1 && tgpo != grupos.getTipo())
//                                {
//                                    System.err.println("Clave de grupo no valida");
//                                    nuevGpo = LecturasBuffer.entradaCadena("Error");
//                                    valid = true;
//                                }
//                            }
//                            for (Grupo grupos : arr)
//                            {
//                                if (nuevGpo.equals(grupos.getCve()) && tgpo == grupos.getTipo())
//                                {
//                                    busqueda = false;
//                                    valid = false;
//                                    break;
//                                }
//                            }
//                        }//fin while
//
//                        //Obtener posicion
//                        for (int i = 0; i < arr.size(); i++)
//                        {
//                            if (arr.get(i).getCve().equals(nuevGpo))
//                            {
//                                posicion = i;
//                                break;
//                            }
//                        }
//                        //Registrar al usuario en el nuevo grupo
//                        for (DatosGrales persona : mat.get(posicion + 1))
//                        {
//                            if (persona instanceof Internos)
//                            {
//                                mat.get(posicion).add(persona);
//                                System.out.println("Registro Exitoso! en el grupo " + nuevGpo);
//                                break;
//                            }
//                            if (persona instanceof Externos)
//                            {
//                                mat.get(posicion).add(persona);
//                                System.out.println("Registro Exitoso! en el grupo " + nuevGpo);
//                                break;
//                            }
//                        }
//
//                        //Eliminar usuario del grupo anterior 
//                        for (DatosGrales persona : mat.get(posicionv))
//                        {
//                            if (persona instanceof Internos && persona.getCveGrupo().equals(cveGpo))
//                            {
//                                mat.get(posicionv).remove(persona);
//                                System.out.println("Cambio de grupo aplicado");
//                                break;
//                            }
//                        }
//                        for (DatosGrales persona : mat.get(posicionv))
//                        {
//                            if (persona instanceof Externos && persona.getCveGrupo().equals(cveGpo))
//                            {
//                                mat.get(posicionv).remove(persona);
//                                System.out.println("Cambio de grupo aplicado");
//                                break;
//                            }
//                        }
//                    } else
//                    {
//                        System.err.println("No es posible cambiar de grupo en este momento");
//                    }
                }
                case 6 ->
                {
                    if (Grupo.arr != null || case1)
                    {
                        boolean b;
                        String clave;
                        do
                        {
                            clave = "";
                            b = false;
                            //Pedir clave
                            clave = Grupo.obtenerCveSinValidar();
                            if (Grupo.buscarGpoCve(clave))
                            {
                                int index = Grupo.encontrarIndex(clave);
                                Grupo nvoGrupo;
                                nvoGrupo = Grupo.arr.get(index);
                                System.out.println(Grupo.consultarGrupos(nvoGrupo));
                                System.out.println(Grupo.consultarInternosGpo(index));
                                System.out.println(Grupo.consultarExternosGpo(index));
                            } else
                            {
                                System.out.println("No hay algun grupo con esa clave... ");
                                b = true;
                            }
                        } while (b);
                    } else
                    {
                        System.out.println("No hay grupos registrados aun...");
                    }
                }
                case 7 ->
                {
                    if (Grupo.arr != null || case1)
                    {
                        boolean b;
                        String clave;
                        do
                        {
                            clave = "";
                            b = false;
                            System.out.println("Ingresa la clave del grupo");
                            clave = LecturasBuffer.cadena(true);
                            Grupo g = Grupo.buscarGrupoInterno(clave);
                            if (g != null)
                            {
                                int index = Grupo.encontrarIndex(clave);
                                Grupo nvoGrupo;
                                nvoGrupo = Grupo.arr.get(index);
                                System.out.println(Grupo.consultarGrupos(nvoGrupo));
                                System.out.println(Grupo.consultarInternosGpo(index) + "\n");
                            } else
                            {
                                System.out.println("No hay algun grupo con esa clave... ");
                                b = true;
                            }
                        } while (b);
                    } else
                    {
                        System.out.println("No hay grupos registrados aun...");
                    }
                }
                case 8 ->
                {
                    if (case1)
                    {
                        boolean b;
                        String clave;
                        do
                        {
                            clave = "";
                            b = false;
                            System.out.println("Ingresa la clave del grupo");
                            clave = LecturasBuffer.cadena(true);
                            if (Grupo.buscarGpoCve(clave))
                            {
                                int index = Grupo.encontrarIndex(clave);
                                Grupo nvoGrupo;
                                nvoGrupo = Grupo.arr.get(index);
                                System.out.println(Grupo.consultarGrupos(nvoGrupo));
                                System.out.println(Grupo.consultarExternosGpo(index));
                            } else
                            {
                                System.out.println("No hay algun grupo con esa clave... ");
                                b = true;
                            }
                        } while (b);
                    } else
                    {
                        System.out.println("No hay grupos registrados aun...");
                    }
                }
                case 9 ->
                {
                    AuxiliarClass obj = new AuxiliarClass();
                    System.out.println("Ingrese el nombre de quien desee encontrar:");
                    String nom = LecturasBuffer.cadena(true);
                    obj.encontrarAlumno(mat, nom);
                }
                case 10 ->
                {
                    AuxiliarClass obj = new AuxiliarClass();
                    int x = obj.determinarGpoConMasAlumnos(mat);
                    System.out.println("x = " + x);
                }
                case 11 ->
                {
                    
                }
                case 12 ->
                {
                    System.out.println("Saliendo del sistema... ");
                    guardarDatos();
                }
                default ->
                {
                    System.out.println("Opcion incorrecta del menu...");
                }
            }

        } while (op
                != 12);
    }

    public static int menu()
    {
        System.out.println("//// MENU \\\\\\\\");
        System.out.println("1. Registrar grupo");
        System.out.println("2. Inscribir usuarios");
        System.out.println("3. Modificar precio");
        System.out.println("4. Consultar grupos");
        System.out.println("5. Cambio de grupo");
        System.out.println("6. Consulta por grupo");
        System.out.println("7. Consulta internos");
        System.out.println("8. Consulta externos");
        System.out.println("9. Encontrar grupo");
        System.out.println("10. Grupo con mas alumnos");
        System.out.println("11. En construccion...");
        System.out.println("12. Salir del programa");
        System.out.println("Seleccione una opcion");
        return LecturasBuffer.entero(true);
    }

    public static void cargarDatos()
    {
        Grupo.arr = (ArrayList<Grupo>) Archivos.cargar("arr");
        DatosGrales.mat = (ArrayList<ArrayList<DatosGrales>>) Archivos.cargar("mat");
        case1 = (Boolean) Archivos.cargar("case1");
        DatosGrales.costo = (double) Archivos.cargar("costo");
        Externos.consecutivo = (Integer) Archivos.cargar("consecutivo");
    }

    public static void guardarDatos()
    {
        Archivos.guardar(firsTime, "firsTime");
        Archivos.guardar(Grupo.arr, "arr");
        Archivos.guardar(DatosGrales.mat, "mat");
        Archivos.guardar(case1, "case1");
        Archivos.guardar(DatosGrales.costo, "costo");
        Archivos.guardar(Externos.consecutivo, "consecutivo");
    }
}
