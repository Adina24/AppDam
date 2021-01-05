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

public class Nivel3 extends AppCompatActivity {

    HomeWatcher mHomeWatcher;

    TextView tvWord3, tvTimp, tvTalent, tvRespiratie, tvBani;
    Button button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12, button13, button14, button15, button16,
            button17, button18, button19, button20, button21, button22, button23, button24,
            button25, button26, button27, button28, button29, button30, button31, button32,
            button33, button34, button35, button36, button37, button38, button39, button40,
            button41, button42, button43, button44, button45, button46, button47, button48,
            button49, button50, button51, button52, button53, button54, button55, button56,
            button57, button58, button59, button60, button61, button62, button63, button64,
            button65, button66, button67, button68, button69, button70, button71, button72,
            button73, button74, button75, button76, button77, button78, button79, button80,
            button81, button82, button83, button84, button85, button86, button87, button88,
            button89, button90, button91, button92, button93, button94, button95, button96,
            button97, button98, button99, button100;
    Button btnCheck3, btnHint3;
    ArrayList<Button> buttons = new ArrayList<>();

    FragmentManager fragmentManager;
    Fragment fragWord3, fragTabel3, fragWords3, fragHint3;

    String str = "", letter = "";
    String timp, respiratie, bani, talent;
    int counter = 0, numberOfWords = 4;
    boolean hintUsed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3);

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
        Intent intent = new Intent(Nivel3.this, MainActivity.class);
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
        button73 = findViewById(R.id.button73);
        button74 = findViewById(R.id.button74);
        button75 = findViewById(R.id.button75);
        button76 = findViewById(R.id.button76);
        button77 = findViewById(R.id.button77);
        button78 = findViewById(R.id.button78);
        button79 = findViewById(R.id.button79);
        button80 = findViewById(R.id.button80);
        button81 = findViewById(R.id.button81);
        button82 = findViewById(R.id.button82);
        button83 = findViewById(R.id.button83);
        button84 = findViewById(R.id.button84);
        button85 = findViewById(R.id.button85);
        button86 = findViewById(R.id.button86);
        button87 = findViewById(R.id.button87);
        button88 = findViewById(R.id.button88);
        button89 = findViewById(R.id.button89);
        button90 = findViewById(R.id.button90);
        button91 = findViewById(R.id.button91);
        button92 = findViewById(R.id.button92);
        button93 = findViewById(R.id.button93);
        button94 = findViewById(R.id.button94);
        button95 = findViewById(R.id.button95);
        button96 = findViewById(R.id.button96);
        button97 = findViewById(R.id.button97);
        button98 = findViewById(R.id.button98);
        button99 = findViewById(R.id.button99);
        button100 = findViewById(R.id.button100);

        btnCheck3 = findViewById(R.id.btnCheck3);
        btnHint3 = findViewById(R.id.btnHint3);

        tvWord3 = findViewById(R.id.tvWord3);
        tvTimp = findViewById(R.id.tvTimp);
        tvTalent = findViewById(R.id.tvTalent);
        tvRespiratie = findViewById(R.id.tvRespiratie);
        tvBani = findViewById(R.id.tvBani);
    }

    protected void readWords() {
        timp = tvTimp.getText().toString().trim();
        talent = tvTalent.getText().toString().trim();
        respiratie = tvRespiratie.getText().toString().trim();
        bani = tvBani.getText().toString().trim();
    }

    private void initializeFragment() {
        fragmentManager = getSupportFragmentManager();

        fragWord3 = fragmentManager.findFragmentById(R.id.fragWord3);
        fragTabel3 = fragmentManager.findFragmentById(R.id.fragTabel3);
        fragWords3 = fragmentManager.findFragmentById(R.id.fragWords3);
        fragHint3 = fragmentManager.findFragmentById(R.id.fragHint3);

        fragmentManager.beginTransaction().show(fragHint3).show(fragWords3).show(fragTabel3).show(fragWord3).commit();
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
        btnCheck3.setOnClickListener(v -> {
            String newStr = str.concat(letter);
            if (newStr.equals("")) {
                Toast.makeText(getApplicationContext(), "Apasă o tastă!", Toast.LENGTH_SHORT).show();
            } else {
                checkWord(newStr);
            }
        });

        btnHint3.setOnClickListener(v -> {
            if (tvWord3.getText().toString().trim().equals("")) {
                if (!hintUsed) settingsForHint(button43);
                if (!hintUsed) settingsForHint(button85);
                if (!hintUsed) settingsForHint(button10);
                if (!hintUsed) settingsForHint(button70);
                btnHint3.setEnabled(false);
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
        button73.setOnClickListener(v -> setsForButton(button73));
        button74.setOnClickListener(v -> setsForButton(button74));
        button75.setOnClickListener(v -> setsForButton(button75));
        button76.setOnClickListener(v -> setsForButton(button76));
        button77.setOnClickListener(v -> setsForButton(button77));
        button78.setOnClickListener(v -> setsForButton(button78));
        button79.setOnClickListener(v -> setsForButton(button79));
        button80.setOnClickListener(v -> setsForButton(button80));
        button81.setOnClickListener(v -> setsForButton(button81));
        button82.setOnClickListener(v -> setsForButton(button82));
        button83.setOnClickListener(v -> setsForButton(button83));
        button84.setOnClickListener(v -> setsForButton(button84));
        button85.setOnClickListener(v -> setsForButton(button85));
        button86.setOnClickListener(v -> setsForButton(button86));
        button87.setOnClickListener(v -> setsForButton(button87));
        button88.setOnClickListener(v -> setsForButton(button88));
        button89.setOnClickListener(v -> setsForButton(button89));
        button90.setOnClickListener(v -> setsForButton(button90));
        button91.setOnClickListener(v -> setsForButton(button91));
        button92.setOnClickListener(v -> setsForButton(button92));
        button93.setOnClickListener(v -> setsForButton(button93));
        button94.setOnClickListener(v -> setsForButton(button94));
        button95.setOnClickListener(v -> setsForButton(button95));
        button96.setOnClickListener(v -> setsForButton(button96));
        button97.setOnClickListener(v -> setsForButton(button97));
        button98.setOnClickListener(v -> setsForButton(button98));
        button99.setOnClickListener(v -> setsForButton(button99));
        button100.setOnClickListener(v -> setsForButton(button100));
    }

    private void setsForButton(Button b) {
        b.setTextColor(Color.BLACK);
        buttons.add(b);
        str = tvWord3.getText().toString().trim();
        letter = b.getText().toString().trim();
        tvWord3.setText(str.concat(letter));
    }

    private void checkWord(String s) {

        if (s.equals(timp)) {
            tvTimp.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(bani)) {
            tvBani.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(talent)) {
            tvTalent.setTextColor(Color.BLACK);
            counter++;
        } else if (s.equals(respiratie)) {
            tvRespiratie.setTextColor(Color.BLACK);
            counter++;
        } else {
            for (int index = 0; index < buttons.size(); index++) {
                Button newButton = buttons.get(index);
                newButton.setTextColor(Color.WHITE);
            }
        }
        buttons = new ArrayList<>();

        if (counter == numberOfWords) {
            Intent intent = new Intent(Nivel3.this, Nivel4.class);
            startActivity(intent);
        }

        tvWord3.setText("");
    }
}