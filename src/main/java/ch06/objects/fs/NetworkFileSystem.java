package ch06.objects.fs;

import java.io.OutputStream;

public class NetworkFileSystem  implements FileSystem {

    public String remoteHost;

    @Override
    public boolean createFile(String fileName) {
        // we have access to "remoteHost", use FTP/SFTP here to create a file
        return true;
    }

    @Override
    public OutputStream readFile(String fileName) {
        return null;
    }
}
