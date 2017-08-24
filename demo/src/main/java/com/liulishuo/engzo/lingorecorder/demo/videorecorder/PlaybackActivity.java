//package com.liulishuo.engzo.lingorecorder.demo.videorecorder;
//
//import android.app.Activity;
//import android.content.ClipData;
//import android.content.ClipboardManager;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.AppCompatImageView;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.VideoView;
//
//import com.liulishuo.engzo.lingorecorder.demo.R;
//import com.qiniu.pili.droid.shortvideo.PLShortVideoTrimmer;
//import com.qiniu.pili.droid.shortvideo.PLShortVideoUploader;
//import com.qiniu.pili.droid.shortvideo.PLUploadProgressListener;
//import com.qiniu.pili.droid.shortvideo.PLUploadResultListener;
//import com.qiniu.pili.droid.shortvideo.PLUploadSetting;
//import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
//
///*用videoview播放用户的回放*/
//public class PlaybackActivity extends Activity implements
//        PLUploadResultListener,
//        PLUploadProgressListener {
//    private static final String MP4_PATH = "MP4_PATH";
//
//    private VideoView mVideoView;
//    private Button mUploadBtn;
//    private PLShortVideoUploader mVideoUploadManager;
//    private ProgressBar mProgressBarDeterminate;
//    private boolean mIsUpload = false;
//    private String mVideoPath;
//    private AppCompatImageView mImageView;
//
//    public static void start(Activity activity, String mp4Path) {
//        Intent intent = new Intent(activity, PlaybackActivity.class);
//        intent.putExtra(MP4_PATH, mp4Path);
//        activity.startActivity(intent);
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_playback);
//
//        PLUploadSetting uploadSetting = new PLUploadSetting();
//
//        mVideoUploadManager = new PLShortVideoUploader(getApplicationContext(), uploadSetting);
//        mVideoUploadManager.setUploadProgressListener(this);
//        mVideoUploadManager.setUploadResultListener(this);
//
//        mUploadBtn = (Button) findViewById(R.id.upload_btn);
//        mImageView = (AppCompatImageView) findViewById(R.id.iv);
//        mUploadBtn.setText(R.string.upload);
//        mUploadBtn.setOnClickListener(new UploadOnClickListener());
//        mProgressBarDeterminate = (ProgressBar) findViewById(R.id.progressBar);
//        mProgressBarDeterminate.setMax(100);
//        mVideoView = (VideoView) findViewById(R.id.video);
//        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                mVideoView.start();
//            }
//        });
//        mVideoPath = getIntent().getStringExtra(MP4_PATH);
//        mVideoView.setVideoPath(mVideoPath);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mVideoView.pause();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mVideoView.start();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mVideoView.stopPlayback();
//    }
//
//    public class UploadOnClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            if (!mIsUpload) {
//                mVideoUploadManager.startUpload(mVideoPath, Config.TOKEN);
//                // TODO: 2017/8/15
//                showBitmap();
//
//
//                mProgressBarDeterminate.setVisibility(View.VISIBLE);
//                mUploadBtn.setText(R.string.cancel_upload);
//                mIsUpload = true;
//            } else {
//                mVideoUploadManager.cancelUpload();
//                mProgressBarDeterminate.setVisibility(View.INVISIBLE);
//                mUploadBtn.setText(R.string.upload);
//                mIsUpload = false;
//            }
//        }
//    }
//
//    private void showBitmap() {
//        // TODO: 2017/8/15
//        PLShortVideoTrimmer mShortVideoTrimmer = new PLShortVideoTrimmer(PlaybackActivity.this, mVideoPath, Config.TRIM_FILE_PATH);
////        long srcDurationMs = mShortVideoTrimmer.getSrcDurationMs();
//        int videoFrameCount = mShortVideoTrimmer.getVideoFrameCount(true);
//        PLVideoFrame videoFrame= mShortVideoTrimmer.getVideoFrameByIndex(0, true);
//        Bitmap bitmap = videoFrame.toBitmap();
//
//        Drawable drawable =new BitmapDrawable(bitmap);
//        mImageView.setBackgroundDrawable(drawable);
//    }
//
//    @Override
//    public void onUploadProgress(String fileName, double percent) {
//        mProgressBarDeterminate.setProgress((int)(percent * 100));
//        if (1.0 == percent) {
//            mProgressBarDeterminate.setVisibility(View.INVISIBLE);
//        }
//    }
//
//    public void copyToClipboard(String filePath) {
//        ClipData clipData = ClipData.newPlainText("VideoFilePath", filePath);
//        ClipboardManager clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
//        clipboardManager.setPrimaryClip(clipData);
//    }
//
//    @Override
//    public void onUploadVideoSuccess(String fileName) {
//        String filePath = "http://" + Config.DOMAIN + "/" + fileName;
//        copyToClipboard(filePath);
//        ToastUtils.l(this, "文件上传成功，" + filePath + "已复制到粘贴板");
//        mUploadBtn.setVisibility(View.INVISIBLE);
//    }
//
//    @Override
//    public void onUploadVideoFailed(int statusCode, String error) {
//        ToastUtils.l(this, "Upload failed, statusCode = " + statusCode + " error = " + error);
//    }
//}