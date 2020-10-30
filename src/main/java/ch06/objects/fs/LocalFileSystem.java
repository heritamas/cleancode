package ch06.objects.fs;

import java.io.OutputStream;

public class LocalFileSystem implements FileSystem {

    private String baseDirectory;

    @Override
    public boolean createFile(String fileName) {
        return false;
    }

    @Override
    public OutputStream readFile(String fileName) {
        return null;
    }
}
