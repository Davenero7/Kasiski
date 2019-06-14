/**
 *
 * @author JoseAntonio
 */
public class Secuencia
{
    private String secuencia;
    private int distancia;
    public Secuencia()
    {}
    public Secuencia( String secuencia, int distancia )
    {
        this.secuencia = secuencia;
        this.distancia = distancia;
    }
    public void establecerSecuencia( String secuencia )
    {
        this.secuencia = secuencia;
    }
    public String obtenerSecuencia()
    {
        return secuencia;
    }
    public void establecerDistancia( int distancia )
    {
        this.distancia = distancia;
    }
    public int obtenerDistancia()
    {
        return distancia;
    }
}