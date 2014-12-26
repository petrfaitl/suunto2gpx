/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gpx_converter.domain;

/**
 *
 * @author Petr
 */
public enum FileSource
{
    SUUNTO(System.getProperty("user.home") + "/Library/Application Support/Suunto/Moveslink2", System.getProperty("user.home") + "\\AppData\\Roaming\\Suunto\\Moveslink2", "Suunto workout files", "sml"),
    OTHER(System.getProperty("user.home"),System.getProperty("user.home"), "Other workout files", "xml");
    
    private String macPath;
    private String winPath;
    private String label;
    private String extension;
    
    
    private FileSource(String macPath, String winPath, String label, String extension)
    {
        this.macPath = macPath;
        this.winPath = winPath;
        this.label = label;
        this.extension = extension;
    }
    public String getMacPath()
    {
        return macPath;
    }
    
    public String getWinPath()
    {
        return winPath;
    }

    public String getLabel()
    {
        return label;
    }

    public String getExtension()
    {
        return extension;
    }
}
