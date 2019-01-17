package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileLineIterable
        implements Iterable<String> {
    private File file;

    FileLineIterable(String fileName)
            throws IOException {
        this(new File(fileName));
    }

    private FileLineIterable(File file) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException("Plik nie istnieje: " + file.getPath());
        if (!file.isFile())
            throw new IOException("Zly typ pliku " + file.getPath());
        this.file = file;
    }

    public FileLineIterator iterator() {
        try {
            return new FileLineIterator(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}