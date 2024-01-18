//モデルの作成やコードで問題があり、光の明暗の判定しかできない
//今後の展墓として、薬を飲む動作の判定ができるモデルの作成やコードの修正を行いたい

package com.example.newdrug;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class CameraX extends  AppCompatActivity{
    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String [] REQUIRED_PERMISSIONS = new String []{Manifest.permission.CAMERA};

//    private ImageButton imageButton;

    PreviewView mPreviewView;
    TextView tvResults;
    Classifier classifier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        mPreviewView = findViewById(R.id.viewFinder);
        tvResults = findViewById(R.id.tvResults);

        classifier = new Classifier(this);

        if (allPermissionsGranted()){
            startCamera();
        }
        else{
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS,
                    REQUEST_CODE_PERMISSIONS);
        }
    }

    private void startCamera(){
        ListenableFuture<ProcessCameraProvider>
                cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                            bindPreview(cameraProvider);
                        } catch (ExecutionException | InterruptedException e) { }
                    }
                },
                ActivityCompat.getMainExecutor(this)
        );
    }

    void bindPreview(ProcessCameraProvider cameraProvider) {
        ImageCapture.Builder builder = new ImageCapture.Builder();
        ImageCapture imageCapture = builder.build();

        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(mPreviewView.getSurfaceProvider());

        CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(
                CameraSelector.LENS_FACING_BACK).build();
        ImageAnalysis imageAnalysis =
                        new ImageAnalysis.Builder()
                                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                                .build();

        imageAnalysis.setAnalyzer(ActivityCompat.getMainExecutor(this),
                new ImageAnalysis.Analyzer() {
                    @Override
                    public void analyze(@NonNull ImageProxy image) {
                        String result;
                        result = classifier.classify(image);
                        tvResults.setText(result);
                        image.close();
                    }
                });
        imageAnalysis.setAnalyzer(ActivityCompat.getMainExecutor(this),
                new ImageAnalysis.Analyzer() {
                    @Override
                    public void analyze(@NonNull ImageProxy image) {
                        String result = classifier.classify(image);
                        image.close();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResults.setText(result);
                                // 結果からlabel名を取得
                                String labelName = result.split(" ")[0]; // 空白で分割し、最初の要素を取得

                                // label名が 'normal' であるかどうかをチェック
                                if ("normal:".equals(labelName)) {
                                    // 'normal' であれば、新しいアクティビティに遷移する
                                    Intent intent = new Intent(CameraX.this, NormalActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                });
        Camera camera = cameraProvider.bindToLifecycle(this, cameraSelector,
                preview, imageAnalysis, imageCapture);
    }

    private boolean allPermissionsGranted(){
        for(String permission: REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(
                    this, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera();
            } else {
                Toast.makeText(this, "Please, give access to camera",
                        Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
    }
}
