package matala0;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class writeSortedCsv {
	public static void writeFile(String fileName, Wifi[] e){
		// try write to the file
		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter outs = new PrintWriter(fw);

			outs.print("MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,CurrentLatitude,CurrentLongitude,AltitudeMeters,AccuracyMeters,Type,DeviceName");
			outs.println();
			for (int i = 0; i <10 ; i++) {


				outs.print(e[i].MAC+",");	 
				outs.print(e[i].SSID+",");
				outs.print(e[i].AuthMode+",");
				outs.print(e[i].FirstSeen+",");
				outs.print(e[i].Channel+",");
				outs.print(e[i].RSSI+",");
				outs.print(e[i].CurrentLatitude+",");
				outs.print(e[i].CurrentLongitude+",");
				outs.print(e[i].AltitudeMeters+",");
				outs.print(e[i].AccuracyMeters+",");
				outs.print(e[i].Type+",");
				outs.print(e[i].DeviceName);
				outs.println();




			}
			outs.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
			System.exit(2);

		}
	}
}
