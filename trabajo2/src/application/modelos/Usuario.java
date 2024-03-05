package application.modelos;

import application.Main;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String username;
    private String password;

    public void crearUsuario(String nombre, String apellido, String telefono, String username, String password) {
        // Crear un nuevo usuario con la información proporcionada
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(password);

        // Agregar el nuevo usuario a la lista de usuarios
        Main.listaUsuarios.add(nuevoUsuario);
    }

	public boolean iniciarSesion(String username, String password) {
        for (Usuario usuarios : Main.listaUsuarios) {
            if (usuarios.getUsername().equals(username) && usuarios.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    
	private void setNombre(String nombre2) {
		nombre = nombre2;
		
	}

	private void setApellido(String apellido2) {
		apellido = apellido2;
		
	}
	
	private void setTelefono(String telefono2) {
		telefono = telefono2;
		
	}
	
	private void setUsername(String username2) {
		username = username2;
		
	}
    private void setPassword(String password2) {
    	password = password2;
		
	}


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
