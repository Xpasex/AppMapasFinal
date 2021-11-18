package com.example.appmapasfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class Maps2 extends AppCompatActivity {
    private static final int REQUEST_CODE_AUTOCOMPLETE_FROM = 1;
    private static final int REQUEST_CODE_AUTOCOMPLETE_TO  = 2;
    Button btnFro, btnToo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);

        // Initialize the SDK
        Places.initialize(getApplicationContext(), getString(R.string.android_sdk_places_api_key));



        btnFro = (Button) findViewById(R.id.btnFrom);

        btnFro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startAutocomplete(REQUEST_CODE_AUTOCOMPLETE_FROM);
            }
        });
        btnToo = (Button) findViewById(R.id.btnFrom);

        btnToo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startAutocomplete(REQUEST_CODE_AUTOCOMPLETE_TO);
            }
        });



    }

    public void startAutocomplete(int requestCode)
    {
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields).build(this);
        startActivityForResult(intent, requestCode);

    }
}