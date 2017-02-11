package com.example.nguyenleanhkhoa.karaoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvgoc;
    ArrayList<music>dsbaihatgoc;
    musicadapter adapter;

    ListView lvbaihatthich;
    ArrayList<music>dsbaihatthich;
    musicadapter adapter2;
    TabHost host;
    ImageButton btnlike,btndislike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control();
        setupTabHost();
        baihat();
        event();


    }

    private void event() {
        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equalsIgnoreCase("1")){
                    xulybaihatgoc();
                }
                else{
                    xulybaihatyeuthich();
                }
            }
        });
    }
    private void baihat() {
        dsbaihatgoc.add(new music("1111","abc","cao thai son",false));
        dsbaihatgoc.add(new music("2222","dgqs","trinh thanh binh",false));
        dsbaihatgoc.add(new music("3333","fgsdf","cao thanh van",false));
    }

    private void setupTabHost() {
        host= (TabHost) findViewById(R.id.tabHost);
        host.setup();
        //tab 1
        TabHost.TabSpec tab=host.newTabSpec("1");
        tab.setContent(R.id.tab1);
        tab.setIndicator("music");
        host.addTab(tab);
        //tab2
        tab=host.newTabSpec("2");
        tab.setContent(R.id.tab2);
        tab.setIndicator("like");
        host.addTab(tab);
    }

    private void control() {
        lvgoc= (ListView) findViewById(R.id.listgoc);
        dsbaihatgoc=new ArrayList<>();
        adapter=new musicadapter(MainActivity.this,R.layout.item,dsbaihatgoc);
        lvgoc.setAdapter(adapter);

        lvbaihatthich= (ListView) findViewById(R.id.listthich);
        dsbaihatthich=new ArrayList<>();
        adapter2=new musicadapter(MainActivity.this,R.layout.item,dsbaihatthich);
        lvbaihatthich.setAdapter(adapter2);

        btnlike= (ImageButton) findViewById(R.id.imglike);
        btndislike= (ImageButton) findViewById(R.id.imgdislike);


    }

    private void xulybaihatyeuthich() {
        dsbaihatthich.clear();
        for(music ms:dsbaihatgoc){
            if(ms.isThich()){
                dsbaihatthich.add(ms);
            }
        }
        adapter2.notifyDataSetChanged();
    }

    private void xulybaihatgoc() {
    }
}
