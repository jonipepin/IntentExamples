package edu.usna.mobileos.intentsexample;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class IntentsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void dialPhone(View view) {
        Uri sampleNumber = Uri.parse("tel:+8002752273");
        Intent i = new Intent(Intent.ACTION_DIAL, sampleNumber);
        startActivity(i);
	}

    public void placeCall(View view) {
        Uri sampleNumber = Uri.parse("tel:+8002752273");
        Intent i = new Intent(Intent.ACTION_CALL, sampleNumber);
        startActivity(i);
    }

    public void openWebBrowser(View view) {
		/*
		Intent i = new
				Intent(android.content.Intent.ACTION_VIEW,
						Uri.parse("http://www.usna.edu/Users/cs/pepin/courses/mobileos/"));
		*/
		/*
		Intent i = new
				Intent("android.intent.action.VIEW",
						Uri.parse("http://www.usna.edu/Users/cs/pepin/courses/mobileos/"));
		*/

        Intent i = new
                Intent("android.intent.action.VIEW");
        i.setData(Uri.parse("http://www.usna.edu/Users/cs/pepin/courses/mobileos/"));
        startActivity(i);
    }

	public void showMap(View view) {
		Intent i = new 
				Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:36.593920,-121.875661?z=16"));
		startActivity(i);

	}
	
	public void launchMyBrowser(View view) {
		Intent i = new
				Intent("edu.usna.mobileos.MyBrowser");
        i.setData(Uri.parse("http://www.usna.edu/Users/cs/pepin/courses/mobileos/"));
        startActivity(i);
	}

    public void showChooser(View view) {

        Intent i = new
                Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://www.usna.edu/Users/cs/pepin/courses/mobileos/"));
        //i.addCategory("edu.usna.mobileos.Apps");
        //---this category does not match any in the intent-filter---
        //i.addCategory("edu.usna.mobileos.OtherApps");
        //i.addCategory("edu.usna.mobileos.SomeOtherApps");
        startActivity(Intent.createChooser(i, "Open URL using..."));
    }

    public void dosearch(View view) {
        String query = "Bill the Goat";
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);
    }

    public void changeSettings(View view){
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }



}