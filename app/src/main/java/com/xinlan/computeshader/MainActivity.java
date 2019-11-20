package com.xinlan.computeshader;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES30;
import android.opengl.GLES31;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    View mTestBtn;
    ImageView mImageView;
    Bitmap gakkiBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTestBtn = findViewById(R.id.test_btn);
        mImageView = findViewById(R.id.image_view);

        System.out.println("size = " + GLES31.GL_MAX_COMPUTE_WORK_GROUP_SIZE);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            GLES31.glDispatchCompute(1,1,0);
//        }

        gakkiBitmap = BitmapFactory.decodeResource(getResources() , R.drawable.gakki);
        mImageView.setImageBitmap(gakkiBitmap);

        mTestBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        ProcessTask task = new ProcessTask(){
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                mImageView.setImageBitmap(bitmap);
            }
        };

        task.execute(gakkiBitmap);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
