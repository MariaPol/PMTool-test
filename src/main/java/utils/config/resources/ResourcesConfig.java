package utils.config.resources;

import utils.ext.FileType;
import java.io.File;
import java.nio.file.Paths;

public class ResourcesConfig {

    public static String getResourcesPath() {
        String filePathString = getAbsolutePath() + "/src/main/resources";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath();
        return filePathString;
    }

    public static String getTargetPath() {
        return getAbsolutePath();
    }

    public static String getUITTPropertyFilePath() {
        return getPropertyFile("uitt");
    }

    public static String getPropertyFile(String propertyFilename) {
        return getResourcesPath() + "/" + propertyFilename + FileType.PROPERTIES.getType();
    }

    private static String getAbsolutePath() {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        return absPath.replace("\\", "/");
    }

    public static String getTools() {
        String filePathString = getAbsolutePath() + "/tools";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath() + "/../tools";
        return filePathString;
    }
}
