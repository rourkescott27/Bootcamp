package book8.ch1;

import javax.swing.*;
import java.io.File;

public class FileChooserTest
{
    public static void main(String[] args)
    {
            FileChooserTest fct = new FileChooserTest();
        System.out.println(fct.getFile());
    }

    private File getFile()
    {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        File file = null;
        if (result == JFileChooser.APPROVE_OPTION)
        {
           file = fc.getSelectedFile();
        }
        return file;
    }
}
