/*
Tanggal Pengerjaan : 14-08-2019
NIM                : 10116115
Nama               : Aditya Komara Ramadhan
Kelas              : IF-3
 */
package com.corporation.fallen.uas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.MyViewHolder> {
    private List<MahasiswaModel> mahasiswaModels;
    Context context;

    public TemanAdapter(Context context, List<MahasiswaModel> mahasiswaModels){
        this.context = context;
        this.mahasiswaModels = mahasiswaModels;
    }

    @Override
    public TemanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(TemanAdapter.MyViewHolder holder, int position) {
        final MahasiswaModel model = mahasiswaModels.get(position);
        holder.nim.setText(model.getNim().toString());
        holder.nama.setText(model.getNama());
        holder.kls.setText(model.getKls());
        holder.telepon.setText(model.getTelepon().toString());
        holder.email.setText(model.getEmail());
        holder.sm.setText(model.getSm());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", model.getId().toString());
                intent.putExtra("nim", model.getNim().toString());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("kls", model.getKls());
                intent.putExtra("telepon", model.getTelepon().toString());
                intent.putExtra("email", model.getEmail());
                intent.putExtra("sm", model.getSm());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kls, telepon, email, sm;

        public MyViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kls = itemView.findViewById(R.id.tvKls);
            telepon = itemView.findViewById(R.id.tvTelepon);
            email = itemView.findViewById(R.id.tvEmail);
            sm = itemView.findViewById(R.id.tvSm);
        }
    }
}
