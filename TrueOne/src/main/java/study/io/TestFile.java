package study.io;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File filePath = new File("F:\\TrueOne\\FileTest");
        File filePath2 = new File("F:\\TrueOne\\FileTest\\test\\test.test");
        File filePath3 = new File("F:\\TrueOne\\FileTest\\tes00t.test");
        System.out.println(filePath);
        System.out.println(filePath2);

            if (!filePath2.getParentFile().exists()){
                filePath2.getParentFile().mkdir();
            }
            try {
                filePath2.createNewFile();
                filePath3.createNewFile();
                filePath3.renameTo(filePath2);
            } catch (Exception e) {
                e.printStackTrace();
            }




    }
}
