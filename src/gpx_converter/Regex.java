/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpx_converter;

/**
 *
 * @author Petr
 */
public enum Regex
{

    //HEAD("<gpx.*>");
    HEAD("^[\t ]*?<Samples>$"),
    FOOTER("^[\t ]*?</Samples>$"),
    NAME("^[\t ]*<name>.*</name>$"),
    SAMPLE_START("^[\t ]*?<Sample>$"),
    SAMPLE_END("[\t ]*?</Sample>$"),
    LAT("^[\t ]*?<Latitude>.*</Latitude>$"),
    LON("^[\t ]*?<Longitude>.*</Longitude>$"),
    UTC("^[\t ]*?<UTC>.*</UTC>$"),
    ELE("^[\t ]*?<Altitude>.*</Altitude>$"),
    GPSELE("^[\t ]*?<GPSAltitude>.*</GPSAltitude>$"),
    ACTIVITY("^[\t ]*<Activity>.*</Activity>$");

    private String pattern;

    private Regex(String pattern)
    {
        this.pattern = pattern;
    }

    public String getPattern()
    {
        return this.pattern;
    }

}
