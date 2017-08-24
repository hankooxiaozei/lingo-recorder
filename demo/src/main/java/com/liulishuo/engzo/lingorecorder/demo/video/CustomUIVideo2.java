//package com.liulishuo.engzo.lingorecorder.demo.video;
//
//import android.content.Context;
//import android.graphics.SurfaceTexture;
//import android.util.AttributeSet;
//
//import com.liulishuo.engzo.lingorecorder.demo.R;
//import com.shuyu.gsyvideoplayer.utils.Debuger;
//import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by shuyu on 2016/12/7.
// * 注意
// * 这个播放器的demo配置切换到全屏播放器
// * 这只是单纯的作为全屏播放显示，如果需要做大小屏幕切换，请记得在这里耶设置上视频全屏的需要的自定义配置
// */
//
//public class CustomUIVideo2 extends GSYVideoControlView {
//
////startPlayLogic
//// GSYMediaPlayerListener的onBackFullScreen交给manager使用 走clearFullscreenLayout()
//// setSmallVideoTextureView小窗口渲染
//
//
//
//    private List<SwitchVideoModel> mUrlList = new ArrayList<>();
//
////    //记住切换数据源类型
////    private int mType = 0;
//
////    private int mTransformSize = 0;
//
//    //数据源
//    private int mSourcePosition = 0;
//
//    /**
//     * 1.5.0开始加入，如果需要不同布局区分功能，需要重载
//     */
//    public CustomUIVideo2(Context context, Boolean fullFlag) {
//        super(context, fullFlag);
//    }
//
//    public CustomUIVideo2(Context context) {
//        super(context);
//    }
//
//    public CustomUIVideo2(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    @Override
//    protected void init(Context context) {
//        super.init(context);
////        initView();
//    }
//
//    @Override
//    protected void showWifiDialog() {
//
//    }
//
//    @Override
//    protected void showProgressDialog(float deltaX, String seekTime, int seekTimePosition, String totalTime, int totalTimeDuration) {
//
//    }
//
//    @Override
//    protected void dismissProgressDialog() {
//
//    }
//
//    @Override
//    protected void showVolumeDialog(float deltaY, int volumePercent) {
//
//    }
//
//    @Override
//    protected void dismissVolumeDialog() {
//
//    }
//
//    @Override
//    protected void showBrightnessDialog(float percent) {
//
//    }
//
//    @Override
//    protected void dismissBrightnessDialog() {
//
//    }
//
//    @Override
//    protected void onClickUiToggle() {
//
//    }
//
//    @Override
//    protected void hideAllWidget() {
//
//    }
//
//    @Override
//    protected void changeUiToNormal() {
//
//    }
//
//    @Override
//    protected void changeUiToPreparingShow() {
//
//    }
//
//    @Override
//    protected void changeUiToPlayingShow() {
//
//    }
//
//    @Override
//    protected void changeUiToPauseShow() {
//
//    }
//
//    @Override
//    protected void changeUiToError() {
//
//    }
//
//    @Override
//    protected void changeUiToCompleteShow() {
//
//    }
//
//    @Override
//    protected void changeUiToPlayingBufferingShow() {
//
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.custom_video;
//    }
//
//    @Override
//    public void startPlayLogic() {
//        if (mStandardVideoAllCallBack != null) {
//            Debuger.printfLog("onClickStartThumb");
//            mStandardVideoAllCallBack.onClickStartThumb(mOriginUrl, mTitle, StandardGSYVideoPlayer.this);
//        }
//        prepareVideo();
//        startDismissControlViewTimer();
//    }
//
//
//    /**
//     * 需要在尺寸发生变化的时候重新处理
//     */
//    @Override
//    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
//        super.onSurfaceTextureSizeChanged(surface, width, height);
////        resolveTransform();
//    }
//
//    @Override
//    protected void setSmallVideoTextureView() {
//
//    }
//
//    /**
//     * 处理显示逻辑
//     */
//    @Override
//    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//        super.onSurfaceTextureAvailable(surface, width, height);
////        resolveRotateUI();
////        resolveTransform();
//    }
//
//
//    /**
//     * 设置播放URL
//     *
//     * @param url           播放url
//     * @param cacheWithPlay 是否边播边缓存
//     * @param title         title
//     * @return
//     */
//    public boolean setUp(List<SwitchVideoModel> url, boolean cacheWithPlay, String title) {
//        mUrlList = url;
//        return setUp(url.get(mSourcePosition).getUrl(), cacheWithPlay, title);
//    }
//
//    /**
//     * 设置播放URL
//     *
//     * @param url           播放url
//     * @param cacheWithPlay 是否边播边缓存
//     * @param cachePath     缓存路径，如果是M3U8或者HLS，请设置为false
//     * @param title         title
//     * @return
//     */
//    public boolean setUp(List<SwitchVideoModel> url, boolean cacheWithPlay, File cachePath, String title) {
//        mUrlList = url;
//        return setUp(url.get(mSourcePosition).getUrl(), cacheWithPlay, cachePath, title);
//    }
//
//
//    @Override
//    public void onBackFullscreen() {
//
//    }
//}
