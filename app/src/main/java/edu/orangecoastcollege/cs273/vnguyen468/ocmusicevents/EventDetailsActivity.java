package edu.orangecoastcollege.cs273.vnguyen468.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is loaded after the user clicks an Item on the list. The list will display the details
 * based on what the user selected.
 */
public class EventDetailsActivity extends AppCompatActivity {
    /**
     * Called when the instance is loaded.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("detail");

        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        titleTextView.setText(title);
        detailTextView.setText(details);

        // Use the Asset Manager to retrieve the file.
        AssetManager am = getAssets();
        String imageFileName = title.replace(" ","") + ".jpeg";
        //Use AssetManager to open a stream to the file name.
        try
            {
                InputStream stream = am.open(imageFileName);
                Drawable image = Drawable.createFromStream(stream, title);
                eventImageView.setImageDrawable(image);
            }
        catch (IOException e)
            {
                Log.e("OC Music Events", "Error loading image: " + imageFileName);
            }
    }

    /**
     * This is called when the Go Back Button is clicked.
     * @param v The view.
     */
    protected void goBackToList(View v)
    {
        finish();
    }
}
