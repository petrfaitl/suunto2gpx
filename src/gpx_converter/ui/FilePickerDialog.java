/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpx_converter.ui;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Petr
 */
public class FilePickerDialog 
{


    public String loadFile(Frame f, String title, String defDir, String fileType)
    {
        FileDialog fd = new FileDialog(f, title, FileDialog.LOAD);
        fd.setFilenameFilter(new ExtensionFilter(fileType));
        fd.setDirectory(defDir);
        fd.setLocation(50, 50);
        fd.setVisible(true);
        
        return fd.getDirectory()+fd.getFile();
    }

}


class ExtensionFilter implements FilenameFilter {
  String extension;

  public ExtensionFilter(String extension) {
    this.extension = "." + extension;
  }

  @Override
  public boolean accept(File dir, String name) {
    return name.endsWith(extension);
  }

    
}
