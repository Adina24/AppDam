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

public class Nivel5 extends AppCompatActivity {

    HomeWatcher mHomeWatcher;

    TextView tvWord5, tvPloaie, tvZapada, tvGrindina;
    Button button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12, button13, button14, button15, button16,
            button17, button18, button19, button20, button21, button22, button23, button24,
            button25, button26, button27, button28, button29, button30, button31, button32,
            button33, button34, button35, button36, button37, button38, button39, button40,
            button41, button42, button43, button44, button45, button46, button47, button48,
            button49, button50, button51, button52, button53, button54, button55, button56,
            button57, button58, button59, button60, button61, button62, button63, button64,
            button65, button66, button67, button68, button69, button70, button71, button72;
    Button btnCheck5, btnHint5;
    ArrayList<Button> buttons = new ArrayList<>();

    FragmentManager fragmentManager;
    Fragment fragWord5, fragTabel5, fragWords5, fragHint5;

    String str = "", letter = "";
    String ploaie, zapada, grindina;
    int counter = 0, numberOfWords = 3;
    boolean hintUsed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel5);

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
        Intent intent = new Intent(Nivel5.this, MainActivity.class);
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
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        button26 = findViewById(R.id.button26);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29 = findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        button34 = findViewById(R.id.button34);
        button35 = findViewById(R.id.button35);
        button36 = findViewById(R.id.button36);
        button37 = findViewById(R.id.button37);
        button38 = findViewById(R.id.button38);
        button39 = findViewById(R.id.button39);
        button40 = findViewById(R.id.button40);
        button41 = findViewById(R.id.button41);
        button42 = findViewById(R.id.button42);
        button43 = findViewById(R.id.button43);
        button44 = findViewById(R.id.button44);
        button45 = findViewById(R.id.button45);
        button46 = findViewById(R.id.button46);
        button47 = findViewById(R.id.button47);
        button48 = findViewById(R.id.button48);
        button49 = findViewById(R.id.button49);
        button50 = findViewById(R.id.button50);
        button51 = findViewById(R.id.button51);
        button52 = findViewById(R.id.button52);
        button53 = findViewById(R.id.button53);
        button54 = findViewById(R.id.button54);
        button55 = findViewById(R.id.button55);
        button56 = findViewById(R.id.button56);
        button57 = findViewById(R.id.button57);
        button58 = findViewById(R.id.button58);
        button59 = findViewById(R.id.button59);
        button60 = findViewById(R.id.button60);
        button61 = findViewById(R.id.button61);
        button62 = findViewById(R.id.button62);
        button63 = findViewById(R.id.button63);
        button64 = findViewById(R.id.button64);
        button65 = findViewById(R.id.button65);
        button66 = findViewById(R.id.button66);
        button67 = findViewById(R.id.button67);
        button68 = findViewById(R.id.button68);
        button69 = findViewById(R.id.button69);
        button70 = findViewById(R.id.button70);
        button71 = findViewById(R.id.button71);
        button72 = findViewById(R.id.button72);

        btnCheck5 = findViewById(R.id.btnCheck5);
        btnHint5 = findViewById(R.id.btnHint5);

        tvWord5 = findViewById(R.id.tvWord5);
        tvPloaie = findViewById(R.id.tvPloaie);
        tvZapada = findViewById(R.id.tvZapada);
        tvGrindina = findViewById(R.id.tvGrindina);
    }

    protected void readWords() {
        ploaie = tvPloaie.getText().toString().trim();
        zapada = tvZapada.getText().toString().trim();
        grindina = tvGrindina.getText().toString().trim();
    }

    private void initializeFragment() {
        fragmentManager = getSupportFragmentManager();

        fragWord5 = fragmentManager.findFragmentById(R.id.fragWord5);
        fragTabel5 = fragmentManager.findFragmentById(R.id.fragTabel5);
        fragWords5 = fragmentManager.findFragmentById(R.id.fragWords5);
        fragHint5 = fragmentManager.findFragmentById(R.id.fragHint5);

        fragmentManager.beginTransaction().show(fragHint5).show(fragWords5).show(fragTabel5).show(fragWord5).commit();
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
        btnCheck5.setOnClickListener(v -> {
            String newStr = str.concat(letter);
            if (newStr.equals("")) {
                Toast.makeText(getApplicationContext(), "Apasă o tastă!", Toast.LENGTH_SHORT).show();
            } else {
                checkWord(newStr);
            }
        });

        btnHint5.setOnClickListener(v -> {
            if (tvWord5.getText().toString().trim().equals("")) {
                if (!hintUsed) settingsForHint(button65);
                if (!hintUsed) settingsForHint(button48);
                if (!hintUsed) settingsForHint(button72);
                btnHint5.setEnabled(false);
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
        button17.setOnClickListener(v -> setsForButton(button17));
        button18.setOnClickListener(v -> setsForButton(button18));
        button19.setOnClickListener(v -> setsForButton(button19));
        button20.setOnClickListener(v -> setsForButton(button20));
        button21.setOnClickListener(v -> setsForButton(button21));
        button22.setOnClickListener(v -> setsForButton(button22));
        button23.setOnClickListener(v -> setsForButton(button23));
        button24.setOnClickListener(v -> setsForButton(button24));
        button25.setOnClickListener(v -> setsForButton(button25));
        button26.setOnClickListener(v -> setsForButton(button26));
        button27.setOnClickListener(v -> setsForButton(button27));
        button28.setOnClickListener(v -> setsForButton(button28));
        button29.setOnClickListener(v -> setsForButton(button29));
        button30.setOnClickListener(v -> setsForButton(button30));
        button31.setOnClickListener(v -> setsForButton(button31));
        button32.setOnClickListener(v -> setsForButton(button32));
        button33.setOnClickListener(v -> setsForButton(button33));
        button34.setOnClickListener(v -> setsForButton(button34));
        button35.setOnClickListener(v -> setsForButton(button35));
        button36.setOnClickListener(v -> setsForButton(button36));
        button37.setOnClickListener(v -> setsForButton(button37));
        button38.setOnClickListener(v -> setsForButton(button38));
        button39.setOnClickListener(v -> setsForButton(button39));
        button40.setOnClickListener(v -> setsForButton(button40));
        button41.setOnClickListener(v -> setsForButton(button41));
        button42.setOnClickListener(v -> setsForButton(button42));
        button43.setOnClickListener(v -> setsForButton(button43));
        button44.setOnClickListener(v -> setsForButton(button44));
        button45.setOnClickListener(v -> setsForButton(button45));
        button46.setOnClickListener(v -> setsForButton(button46));
        button47.setOnClickListener(v -> setsForButton(button47));
        button48.setOnClickListener(v -> setsForButton(button48));
        button49.setOnClickListener(v -> setsForButton(button49));
        button50.setOnClickListener(v -> setsForButton(button50));
        button51.setOnClickListener(v -> setsForButton(button51));
        button52.setOnClickListener(v -> setsForButton(button52));
        button53.setOnClickListener(v -> setsForButton(button53));
        button54.setOnClickListener(v -> setsForButton(button54));
        button55.setOnClickListener(v -> setsForButton(button55));
        button56.setOnClickListener(v -> setsForButton(button56));
        button57.setOnClickListener(v -> setsForButton(button57));
        button58.setOnClickListener(v -> setsForButton(button58));
        button59.setOnClickListener(v -> setsForButton(button59));
        button60.setOnClickListener(v -> setsForButton(button60));
        button61.setOnClickListener(v -> setsForButton(button61));
        button62.setOnClickListener(v -> setsForButton(button62));
        button63.setOnClickListener(v -> setsForButton(button63));
        button64.setOnClickListener(v -> setsForButton(button64));
        button65.setOnClickListener(v -> setsForButton(button65));
        button66.setOnClickListener(v -> setsForButton(button66));
        button67.setOnClickListener(v -> setsForButton(button67));
        button68.setOnClickListener(v -> setsForButton(button68));
        button69.setOnClickListener(v -> setsForButton(button69));
        button70.setOnClickListener(v -> setsForButton(button70));
        button71.setOnClickListener(v -> setsForButton(button71));
        button72.setOnClickListener(v -> setsForButton(button72));
    }

    private void setsForButton(Button b) {
        b.setTextColor(Color.BLACK);
        buttons.add(b);
        str = tvWord5.getText().toString().trim();
        letter = b.getText().toString().trim();
        tvWord5.setText(str.concat(letter));
    }

    private void checkWord(String s) {

        if (s.equals(zapada)) {
            tvZapada.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(grindina)) {
            tvGrindina.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(ploaie)) {
            tvPloaie.setTextColor(Color.BLACK);
            counter++;
        } else {
            for (int index = 0; index < buttons.size(); index++) {
                Button newButton = buttons.get(index);
                newButton.setTextColor(Color.WHITE);
            }
        }
        buttons = new ArrayList<>();

        if (counter == numberOfWords) {
            Intent intent = new Intent(Nivel5.this, CapitolComplet1.class);
            startActivity(intent);
        }

        tvWord5.setText("");
    }
}