package matala0;

public class Wifi {
	String DeviceName;
	String MAC;
	String SSID;
	String AuthMode;
	String FirstSeen;
	String Channel;
	String RSSI;
	String CurrentLatitude;
	String CurrentLongitude;
	String AltitudeMeters;
	String AccuracyMeters;
	String Type;

	public Wifi(){
		this.MAC="a";
		this.SSID="a";
		this.AuthMode="a";
		this.FirstSeen="a";
		this.Channel="a";
		this.RSSI="a";
		this.CurrentLatitude="a";
		this.CurrentLongitude="a";
		this.AltitudeMeters="a";
		this.AccuracyMeters="a";
		this.Type="a";	

	}	
	//////////values constractor
	public Wifi (String MAC,String SSID, String AuthMode, String FirstSeen, String Channel,String RSSI,String CurrentLatitude, String CurrentLongitude, String AltitudeMeters, String AccuracyMeters, String Type){
		this.MAC=MAC;
		this.SSID=SSID;
		this.AuthMode=AuthMode;
		this.FirstSeen=FirstSeen;
		this.Channel=Channel;
		this.RSSI=RSSI;
		this.CurrentLatitude=CurrentLatitude;
		this.CurrentLongitude=CurrentLongitude;
		this.AltitudeMeters=AltitudeMeters;
		this.AccuracyMeters=AccuracyMeters;
		this.Type=Type;	

	}
	/////copy constractor
	public Wifi(Wifi c){
		this.MAC=c.MAC;
		this.SSID=c.SSID;
		this.AuthMode=c.AuthMode;
		this.FirstSeen=c.FirstSeen;
		this.Channel=c.Channel;
		this.RSSI=c.RSSI;
		this.CurrentLatitude=c.CurrentLatitude;
		this.CurrentLongitude=c.CurrentLongitude;
		this.AltitudeMeters=c.AltitudeMeters;
		this.AccuracyMeters=c.AccuracyMeters;
		this.Type=c.Type;	
	}
	//////////////////////getters & setters
	public String getMAC() {
		return this.MAC;
	}
	public void setMAC(String MAC) {
		this.MAC = MAC;
	}
	public String getSSID() {
		return this.SSID;
	}
	public void setSSID(String SSID) {
		this.SSID = SSID;
	}
	public String getAuthMode() {
		return this.AuthMode;
	}
	public void setAuthMode(String AuthMode) {
		this.AuthMode = AuthMode;
	}
	public String getFirstSeen() {
		return this.FirstSeen;
	}
	public void setFirstSeen(String FirstSeen) {
		this.FirstSeen = FirstSeen;
	}
	public String getChannel() {
		return this.Channel;
	}
	public void setChannel(String Channel) {
		this.Channel = Channel;
	}
	public String getRSSI() {
		return this.RSSI;
	}
	public void setRSSI(String RSSI) {
		this.RSSI = RSSI;
	}
	public String getCurrentLatitude() {
		return this.CurrentLatitude;
	}
	public void setCurrentLatitude(String CurrentLatitude) {
		this.CurrentLatitude = CurrentLatitude;
	}
	public String getCurrentLongitude() {
		return this.CurrentLongitude;
	}
	public void setCurrentLongitude(String CurrentLongitude) {
		this.CurrentLongitude = CurrentLongitude;
	}
	public String getAltitudeMeters() {
		return this.AltitudeMeters;
	}
	public void setAltitudeMeters(String AltitudeMeters) {
		this.AltitudeMeters = AltitudeMeters;
	}

	public String getAccuracyMeters() {
		return this.AccuracyMeters;
	}
	public void setAccuracyMeters(String AccuracyMeters) {
		this.AccuracyMeters = AccuracyMeters;
	}
	public String getType() {
		return this.Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public void setDeviceName(String DeviceName) {
		this.DeviceName = DeviceName;
	}
}
