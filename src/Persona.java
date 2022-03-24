
public class Persona {
    private byte elegido;//0 = no tiene amigo, 1 = si tiene amigo
    private byte cogido;//0 = no esta asignado a nadie, 1 = esta asignado a una persona
    private String correo;
    private String nombre;

    public Persona(byte elegido ,byte cogido, String correo, String nombre) {
        super();

        this.elegido = elegido;
        this.cogido = cogido;
        this.correo = correo;
        this.nombre = nombre;
    }

    public Persona() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Persona(String correo, String nombre) {
    }

    public byte getElegido() {
        return elegido;
    }

    public void setElegido(byte elegido) {
        this.elegido = elegido;
    }

    public byte getCogido() {
        return cogido;
    }

    public void setCogido(byte cogido) {
        this.cogido = cogido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "elegido=" + elegido +
                ", cogido=" + cogido +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
