package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class FileLineIterator
        implements Iterator<String> {
    private FileReader reader;
    private BufferedReader buff_in = null;
    private String string = null;

    public FileLineIterator(File file)
            throws IOException {
        try {
            reader = new FileReader(file);
            buff_in = new BufferedReader(reader);
            string = buff_in.readLine();
            if (string == null) {
                buff_in.close();
                buff_in = null;
            }
        } catch (IOException ex) {
            string = null;
            if (buff_in != null) try {
                buff_in.close();
            } catch (IOException ex2) {
            }
            buff_in = null;
            throw ex;
        }
    }

    @Override
    public boolean hasNext() {
        return string != null;
    }

    @Override
    public String next()
            throws NoSuchElementException {
        String returnString = string;
        try {
            if (string == null) {
                throw new NoSuchElementException("Brakuje następnej linii");
            } else {
                string = buff_in.readLine();
                if (string == null && buff_in != null) {
                    buff_in.close();
                    buff_in = null;
                }
            }
        } catch (Exception ex) {
            throw new NoSuchElementException("Wyjątek w buff_in FileLineIterator.next() " + ex);
        }
        return returnString;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("FileLineIterator.remove() nie jest obsługiwane");
    }

    @Override
    protected void finalize()
            throws Throwable {
        try {
            string = null;
            if (buff_in != null)
                try {
                    buff_in.close();
                } catch (Exception ex) {
                }
            buff_in = null;
        } finally {
            super.finalize();
        }
    }
}