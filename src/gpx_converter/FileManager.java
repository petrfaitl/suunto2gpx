/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpx_converter;

import gpx_converter.domain.OSFinder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

/**
 *
 * @author Petr
 */
public class FileManager
{

    private File fileIn;
    private StringBuilder sb;
    private File fileOut;
    private boolean fileSaved;
    private boolean correctFileFormat;
    private Scanner reader;
    private OSFinder os;
    private String activityName;
    private BufferedReader br;

    public FileManager(String filename)
    {
        
        this();
        //setFileName(filename);
        //this.correctFileFormat = false;

        

    }

    public FileManager()
    {
        this.sb = new StringBuilder();
        this.os = new OSFinder();
        this.activityName = "Workout-";
        
    }
    
    public void clear()
    {
        this.sb = new StringBuilder();
    }

    public void setInputFileName(String filename)
    {
        this.fileIn = new File(filename);
        
    }
    private void setOutputFileName()
    {
        File dir = new File(System.getProperty ("user.home")+ System.getProperty("file.separator")+"Downloads");
        dir.mkdir();
        this.fileOut = new File(dir, fileOutName(fileIn.toString()));
    }

    public void processFile()
    {
        readFile();
        writeFile();
    }

    private void readFile()
    {
        int lineCounter = 0;
        try
        {
            
            String headPattern = Regex.HEAD.getPattern();
            String namePattern = Regex.NAME.getPattern();
            String footerPattern = Regex.FOOTER.getPattern();
            String lonPattern = Regex.LON.getPattern();
            String latPattern = Regex.LAT.getPattern();
            String utcPattern = Regex.UTC.getPattern();
            String elePattern = Regex.ELE.getPattern();
            String gpsElePattern = Regex.GPSELE.getPattern();
            String activityNamePattern = Regex.ACTIVITY.getPattern();
            String sampleStartPattern = Regex.SAMPLE_START.getPattern();
            String sampleEndPattern = Regex.SAMPLE_START.getPattern();
            String ele = "0";
            

            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            sb.append("<gpx creator=\"GPX Converter\" version=\"1.1\" xmlns=\"http://www.topografix.com/GPX/1/1\">\n");
            sb.append("  <trk>\n").append("    <trkseg>\n");
            
           // reader = new Scanner(fileIn);
            br = new BufferedReader(new FileReader(fileIn));
            //while (reader.hasNextLine())
            String line = "";
            while((line=br.readLine())!=null)
            {
                lineCounter++;
               // String line = reader.nextLine();
                if (Pattern.matches(activityNamePattern, line))
                {

                    activityName = contentExtractor("Activity", line);
                    

                }

                if (Pattern.matches(sampleStartPattern, line))
                {

                    String lat = "";
                    String lon = "";
                    String time = "";
                    
                    boolean hasLocation = false;
                    while (!Pattern.matches(sampleEndPattern, line=br.readLine()))
                    {
                        
                        if (Pattern.matches(lonPattern, line))
                        {
                            hasLocation = true;
                            lon = contentExtractor("Longitude", line);
                        } else if(Pattern.matches(latPattern, line))
                        {
                            lat = contentExtractor("Longitude", line);
                        }else if(Pattern.matches(utcPattern, line))
                        {
                            time = contentExtractor("UTC", line);
                        }else if(Pattern.matches(elePattern, line))
                        {
                            ele = contentExtractor("Altitude", line);
                        }
                        else if(Pattern.matches(gpsElePattern, line))
                        {
                            ele = contentExtractor("GPSAltitude", line);
                        }else
                        {
                            continue;
                        }
                     
                    }
                    if(hasLocation)
                    {
                        sb.append("      <trkpt lat=\"").append(lat).append("\" lon=\"").append(lon).append("\">\n");
                        sb.append("        <ele>").append(ele).append("</ele>\n");
                        sb.append("        <time>").append(time).append("</time>\n");
                        sb.append("      </trkpt>\n");
                    }
                }
//                if(Pattern.matches(footerPattern, line))
//                {
//                    sb.append("    </trkseg>\n").append("  </trk>\n").append("</gpx>");
//                    break;
//                }
                

            }
            sb.append("    </trkseg>\n").append("  </trk>\n").append("</gpx>");
            
            br.close();
            reader.close();
                     
        } catch (Exception e)
        {
            System.out.println("Error reading file, at line "+ lineCounter);
            e.printStackTrace();
            System.out.println("Exception Bluck");

        }
    }

    private String contentExtractor(String tagName, String line)
    {
        int startBracketIndex = line.indexOf('>');
        int endBracketIndex = line.substring(startBracketIndex).indexOf("<");
        return (line.substring(startBracketIndex + 1, startBracketIndex + endBracketIndex));
    }

    private void copyFile()
    {
        while (reader.hasNextLine())
        {
            String line = reader.nextLine();

            sb.append(line);
            sb.append("\n");
        }
    }

    private String fileOutName(String filename)
    {
        int dotIndex = filename.indexOf('.');
        String name = filename.substring(dotIndex - 21);
        String outSuffix = name.replace(".sml", ".gpx");

        return activityName + outSuffix;
    }

    private void writeFile()
    {
        try
        {
            setOutputFileName();
            FileWriter writer = new FileWriter(fileOut);
            writer.write(sb.toString());
            writer.close();
            this.fileSaved = true;
        } catch (IOException ex)
        {
            //Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something is up with output file or folder.");
        }
    }

    public boolean getFileSaved()
    {
        return this.fileSaved;
    }

}
