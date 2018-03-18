package com.lingang.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by jason on 17/7/3.
 */

public class CutPictureUtils {

    private Activity activity;

    // 裁剪后图片的宽(X)和高(Y),480 X 480的正方形。
    private static int output_X = 480;
    private static int output_Y = 480;
    /* 请求识别码 */
    public static final int CODE_GALLERY_REQUEST = 0xa0;
    public static final int CODE_CAMERA_REQUEST = 0xa1;
    public static final int CODE_RESULT_REQUEST = 0xa2;
    public static final String IMAGE_FILE_NAME = "temp_head_image.jpg";
    public Uri imageUri;

    public CutPictureUtils(Activity activity) {
        try {
            this.activity = activity;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                File file=new File(Environment.getExternalStorageDirectory(),CutPictureUtils.IMAGE_FILE_NAME);
                this.imageUri = FileProvider.getUriForFile(activity, "com.lingang.fileprovider", file);
                Log.i("TAG","imageUri-->"+imageUri.toString());
            } else {
                this.imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),CutPictureUtils.IMAGE_FILE_NAME));
            }
        } catch (Exception e) {

        }
    }

    /*
    * 剪切图片
    */
    public Uri crop(Activity activity, Uri uri, Uri outUri) {
        // 裁剪图片
        this.activity = activity;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", false); //no face detection
        activity.startActivityForResult(intent, CODE_RESULT_REQUEST);

        return outUri;
    }

    public Bitmap decodeUriAsBitmap(Uri uri) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }
}
