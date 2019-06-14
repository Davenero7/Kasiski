/*
 * @author Jose Antonio
 */
public class Letra
{
    private String letra[];
    public Letra()
    {}
    public Letra( String letra[] )
    {
        this.letra = letra;
    }
    public void establecerLetra( String letra[] )
    {
        this.letra = letra;
    }
    public String[] obtenerLetra()
    {
        return letra;
    }
}