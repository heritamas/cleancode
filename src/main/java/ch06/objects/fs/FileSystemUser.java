package ch06.objects.fs;

public class FileSystemUser {



    public static void main(String[] args) {
        // we get an S3 filesystem here !!!!
        NetworkFileSystem nfs = getNetworkFileSystem();

        // is host up?  <<<<<----- this is totally wrong, we abuse the public member "remoteHost" here
        if (checkNetwork(nfs.remoteHost)) {
            // create file
            nfs.createFile("foo");
        }

    }

    private static boolean checkNetwork(String remoteHost) {
        /* ==== SERIOUS ISSUE ====
           public member "remoteHost" is not even used, we always get an S3FileSystem,
           where it does not have a relevant role!!!!
         */

        // do some network checking ....
        return true;
    }

    private static NetworkFileSystem getNetworkFileSystem() {
        return new S3FileSystem();
    }
}
