package br.com.android;

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

		// Criando uma camada para mostrar a localização
		myLocationOverlay = new CamadaMinhaPosicao(this, mapView);
		
		// adicionando a camada no MapView e atualizando
		mapView.getOverlays().add(myLocationOverlay);
		mapView.postInvalidate();
		
		// chamando o método para dar zoom na localização
		zoomToMyLocation();
    }

    @Override
	protected void onResume() {
		super.onResume();
		// quando nossa aplicação é fechada ele registra nossa posição
		myLocationOverlay.enableMyLocation();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// quando nossa atividade pausa, removemos o listener para as atualizações de localização
		myLocationOverlay.disableMyLocation();
	}
	
	/**
	 * Esse método faz um zoom na localização
	 */
	private void zoomToMyLocation() {
		GeoPoint myLocationGeoPoint = myLocationOverlay.getMyLocation();
		if(myLocationGeoPoint != null) {
			mapView.getController().animateTo(myLocationGeoPoint);
			mapView.getController().setZoom(10);
		}
		else {
			Toast.makeText(this, "Impossivel determinar localização", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}