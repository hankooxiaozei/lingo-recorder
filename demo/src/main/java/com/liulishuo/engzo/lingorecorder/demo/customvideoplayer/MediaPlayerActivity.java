package com.liulishuo.engzo.lingorecorder.demo.customvideoplayer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.liulishuo.engzo.lingorecorder.demo.R;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MediaPlayerActivity extends Activity {
    private IjkMediaPlayer player;
    //    private  mMediaPlayer;
    private static final String DEFAULT_TEST_FILE = "/storage/emulated/0/Music/test.wav";

    IMediaPlayer.OnPreparedListener mPreparedListener = new IMediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(IMediaPlayer mp) {
            player.start();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        player = new IjkMediaPlayer();

        Button btn_prepare = (Button) findViewById(R.id.btn_prepare);


        btn_prepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // init player
                IjkMediaPlayer.loadLibrariesOnce(null);
                IjkMediaPlayer.native_profileBegin("libijkplayer.so");

                player.setOnPreparedListener(mPreparedListener);
                try {
                    player.setDataSource(DEFAULT_TEST_FILE);
                    player.prepareAsync();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
