package br.com.fourlinux.gps;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends Activity implements LocationListener {


	static final String tag = "Usando GPS";

	TextView txtInfo;
	LocationManager lm;
	StringBuilder sb;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//TextView que vai mostrar todos os dados de localiza�‹o
		txtInfo = (TextView) findViewById(R.id.textView2);

		// o location manager Ž a parte mais vital que permite o acesso
		lm = (LocationManager) getSystemService(LOCATION_SERVICE);
	}

	@Override
	protected void onResume() {
		
		//aqui determinamos o tempo de atualiza�‹o dos dados 1000ms
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this);
		super.onResume();
	}

	@Override
	protected void onPause() {
		//Aqui a gente desliga o GPS sen‹o a bateria vai embora
		lm.removeUpdates(this);
		super.onResume();
	}

	
	
	
	public void onLocationChanged(Location location) {
		Log.v(tag, "Mudan�a de Localiza�ˆo");

		sb = new StringBuilder(512);

		//conteudo que ser‡ mostrado
		sb.append("Long.: ");
		sb.append(location.getLongitude());
		sb.append('\n');

		sb.append("Lat.: ");
		sb.append(location.getLatitude());
		sb.append('\n');

		sb.append("Altitude: ");
		sb.append(location.getAltitude());
		sb.append('\n');

		sb.append("Precis‹o: ");
		sb.append(location.getAccuracy());
		sb.append('\n');

		txtInfo.setText(sb.toString());
	}

	
	public void onProviderDisabled(String provider) {
		//s— serve para nos avisar se o gps n‹o est‡ habilitado no aparelho
		Log.v(tag, "GPS Desligado");

		//Carrega as configura�›es do GPS
		Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivity(intent);
	}

	
	public void onProviderEnabled(String provider) {
		Log.v(tag, "GPS Ligado");
		Toast.makeText(this, "GPS Ligado", Toast.LENGTH_SHORT).show();

	}
	
	
	

	
	public void onStatusChanged(String provider, int status, Bundle extras) {
		//Isso Ž chamado quando o GPS Cai durante o uso
		switch (status) {
		case LocationProvider.OUT_OF_SERVICE:
			Log.v(tag, "Mudan�a de Status: Sem Servi�o");
			Toast.makeText(this, "Mudan�a de Status: Sem Servi�o",
					Toast.LENGTH_SHORT).show();
			break;
		case LocationProvider.TEMPORARILY_UNAVAILABLE:
			Log.v(tag, "Mudan�a de Status: Temporariamente Indisponivel");
			Toast.makeText(this, "Mudan�a de Status: Temporariamente Indisponivel",
					Toast.LENGTH_SHORT).show();
			break;
		case LocationProvider.AVAILABLE:
			Log.v(tag, "Mudan�a de Status: Disponivel");
			Toast.makeText(this, "Mudan�a de Status: Disponivel",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	protected void onStop() {
		//fecha o aplicativo salvar o estado n‹o Ž importatnte nesse exemplo
		finish();
		super.onStop();
	}
}