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
public class OSFinder
{
    private final String lcOSName;
    private final boolean IS_MAC;
    private final boolean IS_WIN;
    
    public OSFinder()
    {
        this.lcOSName = System.getProperty("os.name").toLowerCase();
        this.IS_MAC = lcOSName.startsWith("mac os x");
        this.IS_WIN = lcOSName.contains("win");
    }
    
    public String getOS()
    {
        return lcOSName;
    }
    
    public boolean IS_MAC()
    {
        return IS_MAC;
    }
    public boolean IS_WIN()
    {
        return IS_WIN;
    }
}
