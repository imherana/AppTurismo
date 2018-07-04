package pe.edu.cibertec.appturismo.Entidades;

public class Usuario {

    private Integer codigo;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private String correo;
    private Empresa tipo_id;

    public Usuario(Integer codigo, String nombre, String apellidos, String usuario, String contraseña, String correo, Empresa tipo_id) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.tipo_id = tipo_id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(Empresa tipo_id) {
        this.tipo_id = tipo_id;
    }
}
