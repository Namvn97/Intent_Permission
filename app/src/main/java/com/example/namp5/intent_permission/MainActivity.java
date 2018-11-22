package com.example.namp5.intent_permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_READ_EXT = 1;
    public static final String DEFAULT_PATH = "storage/emulated/0/Download";
    private PhotoAdapter mPhotoAdapter;
    private List<Photo> mPhotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_EXT:
                checkResult(grantResults);
                break;
            default:
                break;
        }
    }
    private void initView (){
        RecyclerView recyclerView = findViewById(R.id.recycler_photos);
        mPhotos = new ArrayList<>();
        mPhotoAdapter = new PhotoAdapter(mPhotos);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mPhotoAdapter);
    }

    private void checkResult(int[] grantResults) {
        if (grantResults.length > 0
                && grantResults[0] != PackageManager.PERMISSION_DENIED) {
            PhotoStorage.loadPhotos(mPhotoAdapter, DEFAULT_PATH);
        } else loadData();
    }
    private void loadData() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && ContextCompat.checkSelfPermission(this, permissions[0])
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, REQUEST_READ_EXT);
        } else {
            PhotoStorage.loadPhotos(mPhotoAdapter, DEFAULT_PATH);
        }
    }
}
