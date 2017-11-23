package matala0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class readFolder {
	public static void main(String[] args) {




	}
	public static void writeFile(String fileName, File[] listOfFiles){
		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter outs = new PrintWriter(fw);

			outs.print("MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,CurrentLatitude,CurrentLongitude,AltitudeMeters,AccuracyMeters,Type,DeviceName");
			outs.println();

			for (File file : listOfFiles) {
				if (file.isFile() && file.getName().endsWith(".csv")) {

					Wifi[] e = makeWifiArray(file);
					int size =	howManyRaws(file);
					for (int i = 0; i <size-1 ; i++) {


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
				}
			}
			outs.close();
			fw.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
			System.exit(2);

		}
	}




	// make Wifi Array from csv lines

	public static Wifi[] makeWifiArray(File file){
		int raws = howManyRaws(file) ;

		Wifi[] wifiArray = new Wifi[raws];

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;



			str = br.readLine();
			String[] arrDeviceName = str.split(",");
			String deviceName = arrDeviceName[4];

			//we need to skip two lines - they are just titles
			str = br.readLine();
			str = br.readLine();

			for(int i=0; str!=null; i=i+1) {
				String[] arr = str.split(",");
				//System.out.println(arr[1]);
				wifiArray[i] = new Wifi();
				wifiArray[i].setMAC(arr[0]);
				wifiArray[i].setSSID(arr[1]);
				wifiArray[i].setAuthMode(arr[2]);
				wifiArray[i].setFirstSeen(arr[3]);
				wifiArray[i].setChannel(arr[4]);
				wifiArray[i].setRSSI(arr[5]);
				wifiArray[i].setCurrentLatitude(arr[6]);
				wifiArray[i].setCurrentLongitude(arr[7]);
				wifiArray[i].setAltitudeMeters(arr[8]);
				wifiArray[i].setAccuracyMeters(arr[9]);
				wifiArray[i].setType(arr[10]);
				wifiArray[i].setDeviceName(deviceName);

				str = br.readLine();

			}
			br.close();
		}

		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}

		return wifiArray;
	}
	public static int howManyRaws (File file){
		int counter = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			str = br.readLine();
			str = br.readLine();
			while (str != null){
				str = br.readLine();
				counter = counter +1;
			}

			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return counter;
	}
}
