/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author camac
 */
public class ValidacionesVentanas
{

    /**
     * @author MauriCam Valida la longitud y que la contraseña incluya un
     * caracter especial.
     *
     * @param contrasenia Es el campo que va en el textfield de contraseña.
     * @param fr Es el JFrame que se referencia en este caso la ventana de
     * Usuario.
     */
    public static void validarContrasenia(String contrasenia, JFrame fr)
    {
        if (contrasenia.length() != 0)
        {
            if (contrasenia.length() >= 8)
            {
                if (contrasenia.matches(".*\\d.*") && contrasenia.matches(".*[!@#$%^&*()-+=].*"))
                {
                    JOptionPane.showMessageDialog(fr, "Contraseña Segura");
                } else
                {
                    JOptionPane.showMessageDialog(fr, "La contraseña debe contener un caracter especial");
                }
            } else
            {
                JOptionPane.showMessageDialog(fr, "La contraseña debe tener un longitud minima de 8 caracteres");
            }
        } else
        {
            JOptionPane.showMessageDialog(fr, "La contraseña no puede estar vacia");
        }

    }
    /**
     * @author MauriCam Valida la longitud del campo usuario
     *
     * @param user Es el campo que va en el textfield de user.
     * @param fr Es el JFrame que se referencia en este caso la ventana de
     * Usuario.
     */
    public static void validarUsuario(String user, JFrame fr)
    {
        if (user.length() != 0)
        {
            JOptionPane.showConfirmDialog(fr, "Usuario Permitido");
        } else
        {
            JOptionPane.showMessageDialog(fr, "El usuario no puede ir vacio");
        }
    }
}
