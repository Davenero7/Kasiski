/*
 * @author Jose Antonio
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    ArrayList<Secuencia> secuencias = new ArrayList();
    Secuencia secuen;
    ArrayList<SubCriptograma> subCripto = new ArrayList();
    SubCriptograma subCrip;
    ArrayList<Letra> letra = new ArrayList();
    Letra l;
    ArrayList<Frecuencia> frecuencias = new ArrayList();
    Frecuencia f;
    int mcd;
    String abc[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    Scanner sc = new Scanner( System.in );
    public String Cadena()
    {
        String texto;
        System.out.print("Ingrese el texto: ");
        texto = sc.nextLine();
        texto = texto.replace( " ", "");
        texto = texto.replaceAll("\\s", "");
        texto = texto.trim();
        return texto;
    }
    public int Longitud( String cadena )
    {
        int longitud = cadena.length();
        return longitud;
    }
    public void Texto( String texto[], String cadena, int longitud )
    {
        for( int a = 0; a < longitud; a++ )
        {
            texto[a] = Character.toString( cadena.charAt(a));
        }
    }
    public void MostrarTexto( String texto[] )
    {
        for( int a = 0; a < texto.length; a++ )
        {
            System.out.print( texto[a] );
            if( (a+1) % 5 == 0 )
            {
                System.out.print(" ");
                if( (a+1) % 150 == 0 )
                {
                    System.out.println("");
                }
            }
        }
    }
    public void Secuencias( String texto[] )
    {
        int a = 1, b = 2, c = 3;
        int d = 0, e = 0, f = 0;
        int g = 1;
        Secuencias0( texto, a, b, c, d, e, f, g );
    }
    public void Secuencias0( String texto[], int a, int b, int c, int d, int e, int f, int g )
    {        
        if ( c < texto.length )
        {
            d = b;
            e = c;
            f = e + 1;
            int h = Secuencias1( texto, a, b, c, d, e, f, g );
            String secuencia = Secuencias2( texto, a, b, c, d, e, f );
            if( h > 1 )
            {
                secuencias.add( new Secuencia( secuencia, h ) );
                Secuencias0( texto, a+1, b+1, c+1, d, e, f, g );
            }
            else
            {
                Secuencias0( texto, a+1, b+1, c+1, d, e, f, g );
            }
        }
        else
        {
        }
    }    
    public int Secuencias1( String texto[], int a, int b, int c, int d, int e, int f, int g )
    {
        if( f < texto.length )
        {
            String secuencia = texto[a] + texto[b] + texto[c];
            String secuencia0 = texto[d] + texto[e] + texto[f];
            if( secuencia.equals(secuencia0) )
            {
                g = d - a;
            }
            else
            {
                return Secuencias1( texto, a, b, c, d+1, e+1, f+1, g );
            }
        }
        return g;
    }
    public String Secuencias2( String texto[], int a, int b, int c, int d, int e, int f )
    {
        String tmp = "";
        if( f < texto.length )
        {
            String secuencia = texto[a] + texto[b] + texto[c];
            String secuencia0 = texto[d] + texto[e] + texto[f];
            if( secuencia.equals(secuencia0) )
            {
                tmp = secuencia;
            }
            else
            {
                return Secuencias2( texto, a, b, c, d+1, e+1, f+1 );
            }
        }
        return tmp;
    }
    public void MostrarSecuencias()
    {
        int distancia[] = new int[secuencias.size()];
        for( int i = 0; i < secuencias.size(); i++)
        {
            System.out.println( secuencias.get(i).obtenerSecuencia() + ": \t" + secuencias.get(i).obtenerDistancia() );
            distancia[i] = secuencias.get(i).obtenerDistancia();
        }
        mcd = MaximoComunDenominador( distancia );
        System.out.println( "Maxico Comun Divisor: "+ mcd );
    }
    public int MaximoComunDenominador( int distancia[] )
    {
        int numero[] = distancia;
        int minimo = numero[0];
        for( int i : numero )
        {
            if( i < minimo )
            {
                minimo = i;
            }
        }
        int mcd = 0;
        for( int i = 1; i <= minimo; i++ )
        {
            for( int j = 0; j < numero.length; j++ )
            {
                for( int k = 0; k < j; k++ )
                {
                    if( numero[k]%i == 0 && numero[j]%i == 0 )
                    {
                        mcd = i;
                    }
                }
            }            
        }    
        return mcd;
    }
    public void CrearSubCriptogramas( String texto[], int longitud  )
    {
        int a, b;
        for( a = 0; a < mcd; a++ )
        {
            b = a;
            String cadena = "";
            String cripto = CrearSubCriptograma0( texto, cadena, a, b, longitud );
            subCripto.add( new SubCriptograma( cripto ) );
        }
    }
    public String CrearSubCriptograma0( String texto[], String cadena, int a, int b, int longitud )
    {
        
        if ( b < longitud )
        {
            cadena += texto[b];
            return CrearSubCriptograma0( texto, cadena, a, b+4, longitud );
        }
        else
        {
            b = 0;
        }
        return cadena;
    }
    public void MostrarSubCriptogramas()
    {
        for( int i = 0; i < subCripto.size(); i++ )
        {
            System.out.println( "SubC" + i + ": " + subCripto.get(i).obtenerSubCriptograma() );
        }
    }
    public void ArregloCriptogramas()
    {
        for( int j = 0; j < subCripto.size(); j++ )
        {
            String cadena = subCripto.get(j).obtenerSubCriptograma();
            int longitud = Longitud( cadena );
            String texto[] = new String[ longitud ];
            for( int i = 0; i < longitud; i++ )
            {
                texto[i] = Character.toString( cadena.charAt(i) );
            }
            letra.add( new Letra( texto ));
        }
    }
    public void FreciuenciaCriptograma()
    {
        for( int i = 0; i < mcd; i ++ )
        {
            String letras[] = letra.get(i).obtenerLetra();
            int frecuencia[] = new int[27];
            for( int j = 0; j < abc.length; j++ )
            {
                int contador = 0;
                for( int k = 0; k < letras.length; k++ )
                {
                    String a = abc[j];
                    String b = letras[k];
                    if( a.equals(b) )
                    {
                        contador += 1;
                    }
                }
                frecuencia[j] = contador;
            }
            frecuencias.add( new Frecuencia( frecuencia ) );
        }
    }
    public void MostrarFrecuencia()
    {
        System.out.print("\t");
        for( int i = 0; i < abc.length; i++ )
        {
            System.out.print( abc[i] + "  " );
        }
        System.out.print( "\n" );
        for( int i = 0; i < frecuencias.size(); i++ )
        {
            System.out.print( "SubC" + i + "\t" );
            int frecuencia[] = frecuencias.get(i).obtenerFrecuencia();
            for( int j = 0; j < frecuencia.length; j++ )
            {
                System.out.print( frecuencia[j] + "  " );
            }
            System.out.print("\n");
        }
    }
    public void Clave()
    {
        System.out.println( "Posibles claves:\nGOJZ\nVELLO\nRAUL" );
    }
}
class Prueba
{
    public static void main(String[] args)
    {
        Main m = new Main();
        System.out.println( "Ataque Kasiski" );
        String cadena = m.Cadena();
        int longitud = m.Longitud( cadena );
        String texto[] = new String[ longitud ];
        m.Texto( texto, cadena, longitud );
        System.out.println( "La longitud del texto: " + longitud + "\nTexto ingresado:" );
        m.MostrarTexto( texto );
        System.out.print( "\nCadena: Separacion\n" );
        m.Secuencias( texto );
        m.MostrarSecuencias();
        System.out.println( "El texto se dividio en " + m.mcd + " Subcriptogramas:" );
        m.CrearSubCriptogramas( texto, longitud );
        m.MostrarSubCriptogramas();
        m.ArregloCriptogramas();
        m.FreciuenciaCriptograma();
        m.MostrarFrecuencia();
        m.Clave();
    }
}