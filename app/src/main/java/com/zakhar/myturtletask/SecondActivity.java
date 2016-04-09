package com.zakhar.myturtletask;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TURTLE_IMAGE = "Turtle.png";
    private static final String DOLPHIN_IMAGE = "Dolphin.jpg";
    private static final String ANIMAL_POSITION = "animal";

    private Button btnBack;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        btnBack = (Button) findViewById(R.id.btnReturn);
        btnBack.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageBig);

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt(ANIMAL_POSITION);

        InputStream bitmap = null;
        switch (position) {
            case 0:
                try {
                    bitmap = getAssets().open(TURTLE_IMAGE);
                    Bitmap bit = BitmapFactory.decodeStream(bitmap);
                    imageView.setImageBitmap(bit);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bitmap != null)
                        try {
                            bitmap.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
                break;
            case 1:
                try {
                    bitmap = getAssets().open(DOLPHIN_IMAGE);
                    Bitmap bit = BitmapFactory.decodeStream(bitmap);
                    imageView.setImageBitmap(bit);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bitmap != null)
                        try {
                            bitmap.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReturn:
                finish();
                break;
        }
    }
}
