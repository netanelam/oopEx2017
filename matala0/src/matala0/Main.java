package matala0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Main {


	public static void main(String[] args) throws FileNotFoundException {

		// ********************it is very IMPORTANT to CHANGE THE DIRECTORY to the real one on your computer***************
		System.out.println("***reading the files from the folder");
		File folder = new File("C:\\Users\\netanel\\Desktop\\Matala0");
		File[] listOfFiles = folder.listFiles();
		String uniteCsvFile = "C:\\Users\\netanel\\Desktop\\UniteCsv.csv";
		System.out.println("***making UniteCsvFile.csv from all the files");
		readFolder.writeFile(uniteCsvFile, listOfFiles);
		System.out.println("***sort by RSSI and choose ten strongest wifi's -> TenSortedWifi.csv");
		String fileName = "C:\\Users\\netanel\\Desktop\\TenSortedWifi.csv";
		writeSortedCsv.writeFile(fileName, chooseStrongest(uniteCsvFile));
		System.out.println("***make location.kml file");
	    kmlWriter.writer(chooseStrongestKml(fileName));
		
		System.out.println("Done!");
	}

	/// chooseStrongest is function that take the path of .csv file and turn it to objects array - > Wifi[] and sort the 10 strongest wifi

	public static Wifi[] chooseStrongest(String file){
		int raws = howManyRaws(file) ;

		Wifi[] wifiArray = new Wifi[raws];

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;

			str = br.readLine();

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
				wifiArray[i].setDeviceName(arr[11]);

				str = br.readLine();

			}
			br.close();
		}

		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		//sort(wifiArray);

		//for(int i = 0 ;i < raws-1 ; i++ ){
		//System.out.println(wifiArray[i].RSSI);


		sort(wifiArray);
		return wifiArray;
	}

	public static Wifi[] chooseStrongestKml(String file){
		int raws = howManyRaws(file) ;

		Wifi[] wifiArray = new Wifi[raws];

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;

			//we need to skip to lines - they are just titles

			//str = br.readLine();
			//str = br.readLine();
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


				str = br.readLine();

			}
			br.close();
		}

		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		//sort(wifiArray);

		//for(int i = 0 ;i < raws-1 ; i++ ){
		//System.out.println(wifiArray[i].RSSI);


		sort(wifiArray);
		return wifiArray;
	}


	// calculate how many raws in the csv file, we needed it to the size of the objects array
	public static int howManyRaws (String fileName){
		int counter = 0;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			str = br.readLine();

			//System.out.println(0+") "+str);

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
	// selection sort of objects array -> Wifi[]
	static void sort(Wifi[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length-1; j++) {
				Wifi p =a[j];
				Wifi next =  a[min];
				double pp =Double.parseDouble(p.getRSSI());
				double nextnext =Double.parseDouble(next.getRSSI());
				if (pp < nextnext) {
					min = j;
				}
			}
			if (i != min) {
				Wifi swap = a[i];
				a[i] = a[min];
				a[min] = swap;
			}
		}
	}

}
