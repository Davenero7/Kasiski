/*
 * @author Jose Antonio
 */
public class SubCriptograma
{
    private String subCriptograma;    
    public SubCriptograma()
    {
    }
    public SubCriptograma( String subCriptograma )
    {
        this.subCriptograma = subCriptograma;        
    }
    public void establecerSubCriptograma( String subCriptograma )
    {
        this.subCriptograma = subCriptograma;
    }
    public String obtenerSubCriptograma()
    {
        return subCriptograma;
    }
}
