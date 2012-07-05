package br.com.fourlinux.maps.location;

import android.os.Bundle;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;


public class MinhaLocalizacaoActivity extends MapActivity {

	private MapView mapView;
	private MyLocationOverlay myLocationOverlay;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // main.xml contendo o MapView
        setContentView(R.layout.main); 
        
        // extrai o MapView do layout
		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);

		// Criando uma camada para mostrar a localiza��o
		myLocationOverlay = new CamadaMinhaPosicao(this, mapView);
		
		// adicionando a camada no MapView e atualizando
		mapView.getOverlays().add(myLocationOverlay);
		mapView.postInvalidate();
		
		// chamando o m�todo para dar zoom na localiza��o
		zoomToMyLocation();
    }

    @Override
	protected void onResume() {
		super.onResume();
		// quando nossa aplica��o � fechada ele registra nossa posi��o
		myLocationOverlay.enableMyLocation();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// quando nossa atividade pausa, removemos o listener para as atualiza��es de localiza��o
		myLocationOverlay.disableMyLocation();
	}
	
	/**
	 * Esse m�todo faz um zoom na localiza��o
	 */
	private void zoomToMyLocation() {
		GeoPoint myLocationGeoPoint = myLocationOverlay.getMyLocation();
		if(myLocationGeoPoint != null) {
			mapView.getController().animateTo(myLocationGeoPoint);
			mapView.getController().setZoom(10);
		}
		else {
			Toast.makeText(this, "Impossivel determinar localiza��o", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}