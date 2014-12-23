package com.example.busapplication;

import org.apache.cordova.DroidGap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends DroidGap {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setIntegerProperty("splashscreen", R.drawable.apsrtc);

		final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			buildAlertMessageNoGps();
		} else {

			super.setIntegerProperty("loadUrlTimeoutValue", 60000);
			super.loadUrl("file:///android_asset/www/index.html", 3000);
			//super.loadUrl("file:///android_asset/www/index.html");
		}

	}

	private void buildAlertMessageNoGps() {

		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(
				"Your GPS seems to be disabled, do you want to enable it?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								startActivity(new Intent(
										Settings.ACTION_LOCATION_SOURCE_SETTINGS));

								loadurl();

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(final DialogInterface dialog,
							final int id) {
						dialog.cancel();
						finish();
					}
				});
		final AlertDialog alert = builder.create();
		alert.show();
	}

	private void loadurl() {
		super.setIntegerProperty("loadUrlTimeoutValue", 60000);
		super.loadUrl("file:///android_asset/www/index.html", 3000);
	}

}
