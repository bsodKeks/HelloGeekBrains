package com.als.hellogeekbrains;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, StylesActivity.class);
        startActivity(intent);
        initViews();
        initList();
    }

    private void initList() {
        LinearLayout layoutList = findViewById(R.id.layoutList);
        String[] versions = getResources().getStringArray(R.array.version_names);

        // При помощи этого объекта будем надувать элементы, спрятанные в android_item.xml
        LayoutInflater ltInflater = getLayoutInflater();
        // Получить из ресурсов массив указателей на изображения
        TypedArray imgs =
                getResources().obtainTypedArray(R.array.version_logos);
        for (int i = 0; i < versions.length; i++) {
            String version = versions[i];
            // Достаём элемент из android_item.xml
            View item = ltInflater.inflate(R.layout.android_item, layoutList,
                    false);
            // Находим в этом элементе TextView
            TextView tv = item.findViewById(R.id.textAndroid);
            tv.setText(version);

            // Выбрать по индексу подходящее изображение
            AppCompatImageView imgLogo = item.findViewById(R.id.imageAndroid);
            imgLogo.setImageResource(imgs.getResourceId(i, -1));
            layoutList.addView(item);
        }

    }

    private void initViews() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/19659.ttf");
        TextView tvDescrLang = findViewById(R.id.textVLang);
        tvDescrLang.setTypeface(tf);
        tvDescrLang.setText(getText(R.string.descriptionLanguage));
        AppCompatImageView image = findViewById(R.id.imageView);
        loadImageFromAsset(image, "android.png");
    }

    private void loadImageFromAsset(ImageView image, String fileName) {
        try {
            InputStream ims = getAssets().open(fileName);
            // загружаем как Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // выводим картинку в ImageView
            image.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }

}
