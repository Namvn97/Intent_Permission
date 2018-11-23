package com.example.namp5.intent_permission;

import android.util.Log;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by namp5 on 11/23/2018.
 */

public class PhotoStorage {
    public static final String[] EXTENSIONS = {".jpg", ".png", ".gif"};
    public static void loadPhotos(PhotoAdapter adapter, String path) {
        Log.e("aaa", path);
        File directory = new File(path);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                for (String extension : EXTENSIONS) {
                    if (file.getName().toLowerCase().endsWith(extension)) return true;
                }
                return false;
            }
        });
        for (File file : files) {
            adapter.addPhoto(new Photo(file.getName(), file.getPath()));
        }
    }
}
