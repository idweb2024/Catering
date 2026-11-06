package ar.edu.unahur.obj2.catering.Propuestas;

public interface Propuesta {
    public String getDescripcion();
    public Double getPrecio();
    public Boolean propuestaIncluye(String nombre);
    public Integer getCantidadServicios();
     
   
}
