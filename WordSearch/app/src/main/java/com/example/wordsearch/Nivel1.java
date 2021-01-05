package com.example.wordsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Nivel1 extends AppCompatActivity {

    HomeWatcher mHomeWatcher;

    TextView tvWord, tvSud, tvEst, tvVest;
    Button button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12, button13, button14, button15, button16;
    Button btnCheck, btnHint1;
    ArrayList<Button> buttons = new ArrayList<>();

    FragmentManager fragmentManager;
    Fragment fragWord, fragTabel, fragWords, fragHint;

    String str = "", letter = "";

    String sud, est, vest;
    int counter = 0, numberOfWords = 3;
    boolean hintUsed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        findView();
        readWords();
        initializeFragment();
        methodsButtons();

        //bind music service
        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mService != null) {
                    mService.pauseMusic();
                }
            }

            @Override
            public void onHomeLongPressed() {
                if (mService != null) {
                    mService.pauseMusic();
                }
            }
        });

        mHomeWatcher.startWatch();
    }

    private boolean mIsBound = false;
    private MusicService mService;

    private final ServiceConnection serviceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder binder) {
            mService = ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, MusicService.class), serviceConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            unbindService(serviceConnection);
            mIsBound = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mService != null) {
            mService.resumeMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //unbind music service
        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        stopService(music);
        mHomeWatcher.stopWatch();
    }

    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;

        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mService != null) {
                mService.pauseMusic();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Nivel1.this, MainActivity.class);
        startActivity(intent);
    }

    private void findView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);

        btnCheck = findViewById(R.id.btnCheck);
        btnHint1 = findViewById(R.id.btnHint1);

        tvWord = findViewById(R.id.tvWord);
        tvSud = findViewById(R.id.tvSud);
        tvEst = findViewById(R.id.tvEst);
        tvVest = findViewById(R.id.tvVest);
    }

    protected void readWords() {
        sud = tvSud.getText().toString().trim();
        est = tvEst.getText().toString().trim();
        vest = tvVest.getText().toString().trim();
    }

    private void initializeFragment() {
        fragmentManager = getSupportFragmentManager();

        fragWord = fragmentManager.findFragmentById(R.id.fragWord);
        fragTabel = fragmentManager.findFragmentById(R.id.fragTabel);
        fragWords = fragmentManager.findFragmentById(R.id.fragWords);
        fragHint = fragmentManager.findFragmentById(R.id.fragHint);

        fragmentManager.beginTransaction().show(fragHint).show(fragWords).show(fragTabel).show(fragWord).commit();
    }

    private void settingsForHint(Button button) {
        ColorStateList listColors = button.getTextColors();
        int color = listColors.getDefaultColor();
        if (color == Color.WHITE) {
            setsForButton(button);
            hintUsed = true;
        }
    }

    private void methodsButtons() {
        btnCheck.setOnClickListener(v -> {
            String newStr = str.concat(letter);
            if (newStr.equals("")) {
                Toast.makeText(getApplicationContext(), "Apasă o tastă!", Toast.LENGTH_SHORT).show();
            } else {
                checkWord(newStr);
            }
        });

        btnHint1.setOnClickListener(v -> {
            if (tvWord.getText().toString().trim().equals("")) {
                if (!hintUsed) settingsForHint(button1);
                if (!hintUsed) settingsForHint(button16);
                if (!hintUsed) settingsForHint(button13);
                btnHint1.setEnabled(false);
            }
        });

        button1.setOnClickListener(v -> setsForButton(button1));
        button2.setOnClickListener(v -> setsForButton(button2));
        button3.setOnClickListener(v -> setsForButton(button3));
        button4.setOnClickListener(v -> setsForButton(button4));
        button5.setOnClickListener(v -> setsForButton(button5));
        button6.setOnClickListener(v -> setsForButton(button6));
        button7.setOnClickListener(v -> setsForButton(button7));
        button8.setOnClickListener(v -> setsForButton(button8));
        button9.setOnClickListener(v -> setsForButton(button9));
        button10.setOnClickListener(v -> setsForButton(button10));
        button11.setOnClickListener(v -> setsForButton(button11));
        button12.setOnClickListener(v -> setsForButton(button12));
        button13.setOnClickListener(v -> setsForButton(button13));
        button14.setOnClickListener(v -> setsForButton(button14));
        button15.setOnClickListener(v -> setsForButton(button15));
        button16.setOnClickListener(v -> setsForButton(button16));
    }

    private void setsForButton(Button b) {
        b.setTextColor(Color.BLACK);
        buttons.add(b);
        str = tvWord.getText().toString().trim();
        letter = b.getText().toString().trim();
        tvWord.setText(str.concat(letter));
    }

    private void checkWord(String s) {
        if (s.equals(sud)) {
            tvSud.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(est)) {
            tvEst.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(vest)) {
            tvVest.setTextColor(Color.BLACK);
            counter++;
        } else {
            for (int index = 0; index < buttons.size(); index++) {
                Button newButton = buttons.get(index);
                newButton.setTextColor(Color.WHITE);
            }
        }
        buttons = new ArrayList<>();

        if (counter == numberOfWords) {
            Intent intent = new Intent(Nivel1.this, Nivel2.class);
            startActivity(intent);
        }

        tvWord.setText("");
    }
}