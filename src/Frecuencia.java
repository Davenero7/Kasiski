/*
 * @author Jose Antonio
 */
public class Frecuencia
{
    private int frecuencia[];
    public Frecuencia()
    {}
    public Frecuencia( int frecuencia[] )
    {
        this.frecuencia = frecuencia;
    }
    public void establecerFrecuencia( int frecuencia[] )
    {
        this.frecuencia = frecuencia;
    }
    public int[] obtenerFrecuencia()
    {
        return frecuencia;
    }
}