package utils.ext;

public class Load {

    public static void loadData(String className, FileType fileType) {
        if(fileType.equals(FileType.SQL)) {
            executeSQLFile(className);
        } else if (fileType.equals(FileType.XML)) {
            executeXMLFile(className);
        }
    }

    //TODO dbconfig
    private static void executeSQLFile(String className) {
//        File f1 = new File(ResourcesConfig.getInitialDataPath() + className + FileType.SQL.getType());
//        if (!f1.exists()) {
//            getInitialDataPath(className, FileType.SQL);
//        } else {
//            f1 = new File(ResourcesConfig.getInitialDataTargetPath() + className + FileType.SQL.getType());
//            if(!f1.exists()) {
//                executeXMLFile(className);
//            } else {
//                getInitialDataTargetPath(className, FileType.SQL);
//            }
//        }
    }

    private static void executeXMLFile(String className) {
//        File f1 = new File(ResourcesConfig.getInitialDataPath() + FileType.XML.getType());
//        if (!f1.exists()) {
//            f1 = new File(ResourcesConfig.getInitialDataTargetPath() + FileType.XML.getType());
//            if (f1.exists()) {
//                getInitialDataTargetPath(className, FileType.XML);
//            }
//        } else {
//            getInitialDataPath(className, FileType.XML);
//        }

    }

    private static void getInitialDataPath(String className, FileType fileType) {
//        System.out.println("Cmd Data (JDBC) from: " + ResourcesConfig.getInitialDataTargetPath() + className + fileType.getType());
//        Cmd.executeSqlScript(ResourcesConfig.getInitialDataTargetPath() + className + fileType.getType());
    }

    private static void getInitialDataTargetPath(String className, FileType fileType) {
//        System.out.println("Cmd Data (JDBC) from: " + ResourcesConfig.getInitialDataPath() + className + fileType.getType());
//        Cmd.executeSqlScript(ResourcesConfig.getInitialDataPath() + className + fileType.getType());
    }
}
