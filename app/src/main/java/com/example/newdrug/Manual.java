// 薬一覧のなぶばーを押したら取説とリダイレクトするためのボタンを表示させるようにする
// 一定時間後にシークバーが消えるようにしたかったけどなんかいい感じになって、切り替えみたいになったから妥協

package com.example.newdrug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Manual extends AppCompatActivity {


    private VideoView videoView;
    private boolean isPlaying = false;
    private boolean isControllerVisible = true;
    private CustomMediaController mediaController;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_chat) {
                // チャット画面に遷移
                Intent intent1 = new Intent(Manual.this, ChatActivity.class);
                startActivity(intent1);
                return true;
            } else if (itemId == R.id.navigation_book) {
                // MedicineListActivityに移動
                startActivity(new Intent(Manual.this, SelectMode.class));
                return true;
            } else if (itemId == R.id.navigation_person) {
                // PersonalInformationActivityに移動
                startActivity(new Intent(Manual.this, AccountManagementActivity.class));
                return true;
            } else if (itemId == R.id.navigation_chat) {
                // ChatActivityに移動
                startActivity(new Intent(Manual.this, ChatActivity.class));
                return true;
            } else if (itemId == R.id.navigation_contact) {
                // NoticeActivityに移動
                startActivity(new Intent(Manual.this, Contact.class));
                return true;
            }
            return false;
        });

        videoView = findViewById(R.id.videoView);

        // ビデオファイルの取得
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.manual_movie);

        // 先頭に戻す
        videoView.seekTo(0);

        // カスタムMediaControllerを設定
        mediaController = new CustomMediaController(this);
        videoView.setMediaController(mediaController);

        // シークバーを非表示にするためのHandler
        handler = new Handler();

        // ビデオのクリックリスナーを設定
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (isControllerVisible) {
                    // シークバーを非表示
                    mediaController.hide();
                    isControllerVisible = false;

                    // タッチされる前にハンドラーのキューをクリア
                    handler.removeCallbacksAndMessages(null);
                } else {
                    // シークバーを表示
                    mediaController.show();
                    isControllerVisible = true;

                    // 一定時間後にシークバーを非表示
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (isControllerVisible) {
                                mediaController.hide();
                                isControllerVisible = false;
                            }
                        }
                    }, 5000); // 5000ミリ秒 (5秒) 後に非表示にする（適宜時間を調整）
                }
                return false;
            }
        });

        // ビデオ再生
        videoView.start();
    }

    // カスタムMediaController
    public class CustomMediaController extends MediaController {

        public CustomMediaController(Manual context) {
            super(context);
        }

        @Override
        public void show(int timeout) {
            super.show(0);
        }

    }
}

