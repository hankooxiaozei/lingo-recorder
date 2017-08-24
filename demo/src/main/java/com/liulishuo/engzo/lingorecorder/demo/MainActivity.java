package com.liulishuo.engzo.lingorecorder.demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.liulishuo.engzo.lingorecorder.demo.audiorecorder.DemoActivity;
import com.liulishuo.engzo.lingorecorder.demo.cumstompop.CustomPopupWindow;
import com.liulishuo.engzo.lingorecorder.demo.customvideoplayer.PlayActivity;
import com.liulishuo.engzo.lingorecorder.demo.videorecorder.PermissionChecker;
import com.liulishuo.engzo.lingorecorder.demo.videorecorder.RecordSettings;
import com.liulishuo.engzo.lingorecorder.demo.videorecorder.ToastUtils;
import com.liulishuo.engzo.lingorecorder.demo.videorecorder.VideoRecordActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Spinner mPreviewSizeRatioSpinner;
    private Spinner mPreviewSizeLevelSpinner;
    private Spinner mEncodingSizeLevelSpinner;
    private Spinner mEncodingBitrateLevelSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreviewSizeRatioSpinner = (Spinner) findViewById(R.id.PreviewSizeRatioSpinner);
        mPreviewSizeLevelSpinner = (Spinner) findViewById(R.id.PreviewSizeLevelSpinner);
        mEncodingSizeLevelSpinner = (Spinner) findViewById(R.id.EncodingSizeLevelSpinner);
        mEncodingBitrateLevelSpinner = (Spinner) findViewById(R.id.EncodingBitrateLevelSpinner);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RecordSettings.PREVIEW_SIZE_RATIO_TIPS_ARRAY);
        mPreviewSizeRatioSpinner.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RecordSettings.PREVIEW_SIZE_LEVEL_TIPS_ARRAY);
        mPreviewSizeLevelSpinner.setAdapter(adapter2);
        mPreviewSizeLevelSpinner.setSelection(3);

        ArrayAdapter<String> adapter3= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RecordSettings.ENCODING_SIZE_LEVEL_TIPS_ARRAY);
        mEncodingSizeLevelSpinner.setAdapter(adapter3);
        mEncodingSizeLevelSpinner.setSelection(10);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RecordSettings.ENCODING_BITRATE_LEVEL_TIPS_ARRAY);
        mEncodingBitrateLevelSpinner.setAdapter(adapter4);
        mEncodingBitrateLevelSpinner.setSelection(2);
    }

    public void onClickCapture(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            jumpToCaptureActivity(VideoRecordActivity.class);
        }
    }
    public void onClickAudio(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            jumpToCaptureActivity(DemoActivity.class);
        }
    }

//    public void onClickRender(View v) {
//        PermissionChecker checker = new PermissionChecker(this);
//        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
//        if (!isPermissionOK) {
//            ToastUtils.s(this, "Some permissions is not approved !!!");
//        } else {
//            jumpToCaptureActivity(RenderActivity.class);
//        }
//    }

    public void onClickPop(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            CustomPopupWindow popupWindow = new CustomPopupWindow.Builder()
                    .setContext(this) //设置 context
                    .setContentView(R.layout.content_ask) //设置布局文件
                    .setwidth(LinearLayout.LayoutParams.WRAP_CONTENT) //设置宽度，由于我已经在布局写好，这里就用 wrap_content就好了
                    .setheight(LinearLayout.LayoutParams.WRAP_CONTENT) //设置高度
                    .setFouse(true)  //设置popupwindow 是否可以获取焦点
                    .setOutSideCancel(true) //设置点击外部取消
                    .setAnimationStyle(R.style.popup_anim_style) //设置popupwindow动画
                    .builder() //
                    .showAtLocation(R.layout.activity_main, Gravity.CENTER,0,0); //设置popupwindow居中显示
        }
    }

    public void onClickVideoPlay(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
//            jumpToCaptureActivity(PlayActivity.class);
        }
    }

    public void onClickImport(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            jumpToImportActivity();
        }
    }

    public void onClickTranscode(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            jumpToTranscodeActivity();
        }
    }
//    public void onVideo1(View v) {
//        PermissionChecker checker = new PermissionChecker(this);
//        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
//        if (!isPermissionOK) {
//            ToastUtils.s(this, "Some permissions is not approved !!!");
//        } else {
//            Intent intent = new Intent(MainActivity.this, DetailMoreTypeActivity.class);
//            startActivity(intent);
//        }
//    }

    public void onVideo2(View view) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            Intent intent = new Intent(MainActivity.this, PlayActivity.class);
            intent.putExtra(PlayActivity.TRANSITION, false);


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Pair pair = new Pair<>(view, PlayActivity.IMG_TRANSITION);
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this, pair);
                ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
            } else {
                startActivity(intent);
                overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            }
        }
    }

    public void onClickScreenRecord(View v) {
        PermissionChecker checker = new PermissionChecker(this);
        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checker.checkPermission();
        if (!isPermissionOK) {
            ToastUtils.s(this, "Some permissions is not approved !!!");
        } else {
            jumpToScreenRecordActivity();
        }
    }

    private void jumpToImportActivity() {
//        Intent intent = new Intent(MainActivity.this, VideoTrimActivity.class);
//        startActivity(intent);
    }

    private void jumpToTranscodeActivity() {
//        Intent intent = new Intent(MainActivity.this, VideoTranscodeActivity.class);
//        startActivity(intent);
    }

    private void jumpToScreenRecordActivity() {
//        Intent intent = new Intent(MainActivity.this, ScreenRecordActivity.class);
//        startActivity(intent);
    }

    public void jumpToCaptureActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        intent.putExtra("PreviewSizeRatio", mPreviewSizeRatioSpinner.getSelectedItemPosition());
        intent.putExtra("PreviewSizeLevel", mPreviewSizeLevelSpinner.getSelectedItemPosition());
        intent.putExtra("EncodingSizeLevel", mEncodingSizeLevelSpinner.getSelectedItemPosition());
        intent.putExtra("EncodingBitrateLevel", mEncodingBitrateLevelSpinner.getSelectedItemPosition());
        startActivity(intent);
    }

//    private String getVersionDescription() {
//        PackageManager packageManager = getPackageManager();
//        try {
//            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
//            return packageInfo.versionName;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return "未知";
//    }

//    protected String getBuildTimeDescription() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(BuildConfig.BUILD_TIMESTAMP);
//    }
}
