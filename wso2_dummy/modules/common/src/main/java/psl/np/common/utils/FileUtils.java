package psl.np.common.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.UUID;

public class FileUtils {

    private static final Encoder ENCODER = Base64.getEncoder();

    public static String fileExtensionWithoutDot(String fileName) {
        String ext = "";
        int index = fileName.lastIndexOf(".");
        if (index > 0) {
            ext = fileName.substring(index + 1);
        }
        return ext;
    }

    public static String fileExtension(String fileName) {
        String ext = fileExtensionWithoutDot(fileName);
        if (ext.length() > 0) {
            ext = "." + ext;
        }
        return ext;
    }

    public static String fileExtension(String fileName, String deafult) {
        String ext = fileExtension(fileName);
        if (Strings.isNullOrEmpty(ext)) {
            return deafult;
        }
        return ext;
    }

    /**
     * Check if a directory exists or not. If not exists then create that directory and its all
     * parent directory if needed
     * @param dir Directory to be created
     * @return true if new directory created otherwise false
     * @throws IOException If directory can not be created
     */
    public static boolean ensureDirectoryExists(Path dir) throws IOException {
        if (Files.isSymbolicLink(dir)) {
            return false;
        }
        if (!Files.isDirectory(dir)) {
            dir = dir.getParent();
        }
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
            return true;
        }
        return false;
    }

    public static String randomFileName() {
        UUID uuid = UUID.randomUUID();
        String str = ENCODER.encodeToString(UuidUtils.asBytes(uuid));
        str = str.replace("/", "").replace("+", "");
        return Strings.trimEnd(str, '=');
    }

    public static String randomFileNameWithDir(String dirName) {
        String fileName = randomFileName();
        return Paths.get(dirName, fileName).toString();
    }

    public static String randomFileNameWithDir(String dir1, String dir2) {
        String fileName = randomFileName();
        return Paths.get(dir1, dir2, fileName).toString();
    }
}
