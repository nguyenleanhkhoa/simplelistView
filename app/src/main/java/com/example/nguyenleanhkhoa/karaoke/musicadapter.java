package com.example.nguyenleanhkhoa.karaoke;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nguyen le anh khoa on 04/02/2017.
 */

public class musicadapter extends ArrayAdapter<music>{
    Activity context;
    int resource;
    List<music> objects;

    public musicadapter(Activity context, int resource, List<music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtma= (TextView) row.findViewById(R.id.txtma);
        TextView txtten= (TextView) row.findViewById(R.id.txtten);
        TextView txtcasi= (TextView) row.findViewById(R.id.txtcasi);
        ImageButton imglike= (ImageButton) row.findViewById(R.id.imglike);
        ImageButton imgdislike= (ImageButton) row.findViewById(R.id.imgdislike);

        final music music=this.objects.get(position);
        txtma.setText(music.getMa());
        txtten.setText(music.getTen());
        txtcasi.setText(music.getCasi());

        if(music.isThich()){
            imglike.setVisibility(View.INVISIBLE);
            imgdislike.setVisibility(View.VISIBLE);
        }
        else{
            imglike.setVisibility(View.VISIBLE);
            imgdislike.setVisibility(View.INVISIBLE);
        }
        imglike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulythich(music);
            }
        });
        imgdislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyxoa(music);
            }
        });
        return row;
    }

    private void xulyxoa(music music) {
        remove(music);
        music.setThich(false);
    }
    private void xulythich(music music) {
        music.setThich(true);
    }


}
