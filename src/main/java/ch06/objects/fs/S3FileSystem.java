package ch06.objects.fs;

import java.io.OutputStream;

public class S3FileSystem extends NetworkFileSystem {
    private String s3Bucket;

    @Override
    public boolean createFile(String fileName) {
        // do some AWS magic with s3Bucket
        return true;
    }

    @Override
    public OutputStream readFile(String fileName) {
        return null;
    }
}
