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
                }
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
     //hola
        System.out.println("El grupo con mayor cantidad de alumnos es aquel con clave: " + Grupo.arr.get(indexGpo).getCve() + " con " + cantAl + " alumnos.");
        return cantAl;
    }

    public void cambiarPrecTodos(ArrayList<ArrayList<DatosGrales>> mat)
    {
        for (int i = 0; i < mat.size(); i++)
        {
            for (int j = 0; j < mat.get(i).size(); j++)
            {
                mat.get(i).get(j).calcPrecio();
            }
        }
        System.out.println("Precio actualizado con exito!");
    }

}
