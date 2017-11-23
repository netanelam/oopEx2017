package matala0;


import java.io.File;
import java.io.FileNotFoundException;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

public class kmlWriter {

	public static void writer(Wifi[] er) throws FileNotFoundException {
		
		// creating new kml file 
		
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("C:\\Users\\netanel\\Desktop\\location");
		

	        for (int i = 0; i <10 ; i++) {
			
				
					doc.createAndAddPlacemark().withTimePrimitive(createTimeLine(er[i].FirstSeen))			
			        .withName(er[i].SSID).withDescription(er[i].MAC)
			        .createAndSetPoint().addToCoordinates(Double.parseDouble(er[i].CurrentLongitude),Double.parseDouble(er[i].CurrentLatitude));
					
					try {
						// ********************it is very IMPORTANT to CHANGE THE DIRECTORY to the real one on your computer***************
			            kml.marshal(new File("C:\\Users\\netanel\\Desktop\\wifiLOCATTION.kml"));
			        } catch (FileNotFoundException ex) {
			        	ex.printStackTrace();
			        }         
					
				}
			}
	
	// function that add a time stamp to the time line in the kml file.
	public static TimeStamp createTimeLine(String time) {
		 
		String str = time;
		String[] arrStr = str.split(" ");
		String updatedTime = arrStr[0] +"T"+arrStr[1] +"Z"; 
		TimeStamp timeStamp = new TimeStamp ();
	    timeStamp.setWhen(updatedTime);
	    return timeStamp;
	}

	
}