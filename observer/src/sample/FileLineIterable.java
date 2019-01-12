package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileLineIterable
        implements Iterable<String>
{
    private File file;




    public FileLineIterable( String fileName )
            throws IOException
    {
        this( new File( fileName ) );
    }

    public FileLineIterable( File file ) throws IOException
    {
        if( ! file.exists() )
            throw new FileNotFoundException( "File does not exist: " + file.getPath() );
        if( ! file.isFile() )
            throw new IOException( "File is not of type 'file': " + file.getPath() );
        this.file = file;
    }

    public FileLineIterator iterator()
    {
        try
        {
            return new FileLineIterator( file );
        }
        catch( IOException e )
        {
            e.printStackTrace();
            return null;
        }
    }
}