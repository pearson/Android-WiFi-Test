package pearson.wifitest;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WiFiTestActivity extends Activity implements OnClickListener {
	private Button theButton;
	private TextView theTextView1;
	private TextView theTextView2;
	private WifiManager theWiFi;
	private ConnectivityManager theNetwork;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Get a reference to the button in the layout
		theButton = (Button) findViewById(R.id.button1);
		// Tell the button to call this activity's onClick() method when clicked
		theButton.setOnClickListener(this);
		
		// Get a reference to the text view in the layout
		theTextView1 = (TextView) findViewById(R.id.text1);
		theTextView2 = (TextView) findViewById(R.id.text2);
		
		// reference to the WiFi connection
		theWiFi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		theNetwork = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	}


	@Override
	public void onClick(View v) {
		theTextView1.setText("Checking the SupplicantState. Tell Chris if this hangs.");
		SupplicantState supplicantState = theWiFi.getConnectionInfo().getSupplicantState();
		theTextView1.setText("SupplicantState: " + supplicantState);
		
		theTextView2.setText("Checking the NetworkInfo.DetailedState. Tell Chris if this hangs.");
		NetworkInfo.DetailedState networkState = theNetwork.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getDetailedState();
		theTextView2.setText("NetworkInfo.DetailedState: " + networkState);
	}
}