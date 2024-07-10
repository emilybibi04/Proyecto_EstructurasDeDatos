package Modelo;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class User {
    private String email;
    private String password;
    private String nombre;
    private String apellido;

    public User(String email, String password, String nombre, String apellido) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public static Set<User> objetoUsuarios(String nombrearchivo) throws IOException{
        
        Set<String> lineas = Readable.leerArchivo(nombrearchivo);
        Set<User> usuarios = new LinkedHashSet<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String correo = elemento[0];
            String contraseña = elemento[1];
            String nombre = elemento[2];
            String apellido = elemento[3];
            usuarios.add(new User(correo, contraseña, nombre, apellido));
        }
        
        return usuarios;
    }
    
    public static boolean verificar(String email, String password, Set <User> lista){
        for (User u : lista) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean reconocerUsuarios(String correo,Set <User> usuarios) throws IOException{
        for(User usuario:usuarios){
            if(usuario.getEmail().equals(correo)){
                return true;
            }
        }
        return false;
    }
    
    //Resolver eso del equals zzz
    public static User crearUsuario(String user, String pass, Set<User> lista){
        User persona = null;
        for (User u : lista) {
            if (u.getEmail().equals(user) && u.getPassword().equals(pass)) {
                persona = new User(u.getEmail(), u.getPassword(), u.getNombre(), u.getApellido());
            }        
        }
        return persona;
    }

}
