package com.mark.to_do;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by xuxiantao on 2015/8/15.
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgBack;
    private ImageView mImgDone;
    private ImageView mImgCamera;
    private TextView mTxtSignUp;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        View actionBarView = getLayoutInflater().inflate(R.layout.actionbar_sign_up, null);
        mImgBack = (ImageView) actionBarView.findViewById(R.id.img_back);
        mImgDone = (ImageView) actionBarView.findViewById(R.id.img_done);
        mImgBack.setOnClickListener(this);
        mImgDone.setOnClickListener(this);

        mImgCamera = (ImageView) findViewById(R.id.img_camera);
        mImgCamera.setOnClickListener(this);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(actionBarView);

        mTxtSignUp = (TextView) findViewById(R.id.txt_sign_up);
        mTxtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.img_done:

                break;

            case R.id.img_camera:
                showDialog();
                break;

            case R.id.txt_sign_up:
                Intent loginIntent = new Intent(this, LoginActivity.class);
                startActivity(loginIntent);
                break;

            case R.id.btn_gallery:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galleryIntent.setType("image/*");
                startActivityForResult(Intent.createChooser(galleryIntent, "选择一张照片"), 0);
                break;

            case R.id.btn_camera:
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
                break;

            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }
    }

    private void showDialog() {
        View view = getLayoutInflater().inflate(R.layout.photo_choose_dialog, null);

        Button mBtnGallery = (Button) view.findViewById(R.id.btn_gallery);
        Button mBtnCamera = (Button) view.findViewById(R.id.btn_camera);
        Button mBtnCancel = (Button) view.findViewById(R.id.btn_cancel);
        mBtnGallery.setOnClickListener(this);
        mBtnCamera.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);

        dialog = new Dialog(this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.photo_dialog_anim_style);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();

        wl.width = LayoutParams.MATCH_PARENT;
        wl.height = LayoutParams.WRAP_CONTENT;

        dialog.onWindowAttributesChanged(wl);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}
