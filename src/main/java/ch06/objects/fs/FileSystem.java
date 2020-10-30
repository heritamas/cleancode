package ch06.objects.fs;

import java.io.OutputStream;

public interface FileSystem {

    boolean createFile(String fileName);
    OutputStream readFile(String fileName);
}
