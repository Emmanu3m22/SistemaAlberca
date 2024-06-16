/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author camac
 */
public class GuardarUsuario
{

    private String usuario;
    private String pass;

    public GuardarUsuario()
    {
    }

    public GuardarUsuario(String user, String pass)
    {
        this.usuario = user;
        this.pass = pass;
    }

    public GuardarUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    

    /**
     * @return the user
     */
    public String getUser()
    {
        return usuario;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user)
    {
        this.usuario = user;
    }

    /**
     * @return the pass
     */
    public String getPass()
    {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String desp()
    {
        return  
                ajuste(String.valueOf(usuario)) + "\t"
                + ajuste(String.valueOf(pass));
    }

    public String ajuste(String s)
    {
        String cad = "";
        for (int i = 0; i < 20; i++)
        {
            if (i < s.length())
            {
                cad += s.charAt(i);
            }else
            {
                cad = " "+ cad;
            }
        }
        return cad;
    }
    
}
