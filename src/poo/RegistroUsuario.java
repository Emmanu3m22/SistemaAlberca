/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import interfaz.vtnUsuario;

/**
 *
 * @author camac
 */
public class RegistroUsuario
       
{
    GuardarUsuario u[] = null;
   public void insertaUsuario(GuardarUsuario use)
    {
        if (u == null)
        {
            u = new GuardarUsuario[1];
            u[0] = use;
        } else
        {
            GuardarUsuario nvo[] = new GuardarUsuario[u.length + 1];
            System.arraycopy(u, 0, nvo, 0, u.length);
            nvo[u.length] = use;
            u = nvo;
        }
        
    }
   public String despUsuario()
    {
        String s = "";
        if (u != null)
        {
            s += ajuste("Usuario\t") + ajuste("Contraseña\t")+"\n";
            for (int i = 0; i < u.length; i++)
            {
                s += u[i].desp();
            }
        } else
        {
            s = "no hay datos que mostrar";
        }
        return s;
}
       private String ajuste(String s)
    {
        String cad = "";
        for (int i = 0; i < 20; i++)
        {
            if (i < s.length())
            {
                cad += s.charAt(i);
            } else
            {
                cad = " "+ cad;
            }
        }
        return cad;
    }
}
