package com.yey.studio.cutoutscreenadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.yey.studio.cutoutscreenadapter.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 9.0 全屏适配
        binding.btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FullScreenActivity_9.class);
                startActivity(intent);
            }
        });
        // 9.0 带状态栏全屏适配
        binding.btnNotFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StateBarScreenActivity_9.class);
                startActivity(intent);
            }
        });
        // 8.0 全屏适配
        binding.btnFull8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FullScreenActivity_8.class);
                startActivity(intent);
            }
        });
        // 8.0 带状态栏全屏适配
        binding.btnNotFull8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StateBarScreenActivity_8.class);
                startActivity(intent);
            }
        });
        // 为状态栏设置颜色, 不支持5.0以下
        binding.btnStatebarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StateBarColorActivity.class);
                startActivity(intent);
            }
        });
    }
}
