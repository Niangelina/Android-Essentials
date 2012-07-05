package br.com.fourlinux.services;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class NossoServico extends Service {

	private Timer timer = new Timer();
	private static long UPDATE_INTERVAL = 1 * 60 * 1000; // 1 minuto
	private static long DELAY_INTERVAL = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		startService();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		stopService();
	}

	private void startService() {
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				doServiceWork();
			}
		}, DELAY_INTERVAL, UPDATE_INTERVAL);
	}

	private void doServiceWork() {
		// faca algo
		Log.i("doServiceWork", "Executando o servico.");
	}

	private void stopService() {
		timer.cancel();
		Log.i("doServiceWork", "Parando o servico.");
	}

}
