package com.anudeepsamaiya.urbancarnival;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anudeepsamaiya on 3/1/17.
 */

public class ImageProvider {

    private static ImageProvider mInstance;
    private ContentResolver resolver;

    private ImageProvider(ContentResolver resolver) {
        this.resolver = resolver;
    }

    public static synchronized ImageProvider getInstance(ContentResolver resolver) {
        if (mInstance == null) {
            mInstance = new ImageProvider(resolver);
        }
        return mInstance;
    }

    public List<PhotoItem> query() {
        List<PhotoItem> photoItems = new ArrayList<>();

        String[] projections = {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.DATE_TAKEN,
                MediaStore.Images.Media.DATA,
        };

        Cursor cursor = MediaStore.Images.Media.query(resolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projections, null, null,
                MediaStore.Images.Media.DATE_ADDED + " DESC");

        if (cursor.moveToFirst()) {
            int dataColumn = cursor.getColumnIndex(
                    MediaStore.Images.Media.DATA);
            do {
                // Get the field values
                photoItems.add(new PhotoItem(cursor.getString(dataColumn)));
            } while (cursor.moveToNext());
        }
        return photoItems;
    }
}
