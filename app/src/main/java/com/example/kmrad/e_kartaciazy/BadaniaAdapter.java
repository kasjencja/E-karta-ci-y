package com.example.kmrad.e_kartaciazy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kmrad on 21.12.2018.
 */

public class BadaniaAdapter extends RecyclerView.Adapter<BadaniaAdapter.ViewHolder>{

    ArrayList<ListaBadan> list = new ArrayList<>();


    BadaniaAdapter(ArrayList<ListaBadan> listaBadanArrayList) {
        this.list = listaBadanArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pojedyncze_badanie, null);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setID(String.valueOf(list.get(position).getIdBadania()));
        holder.setDate(list.get(position).getDataBadania());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;

        @BindView(R.id.text_view_id_badania)
        TextView idBadania;

        @BindView(R.id.button_wybierz)
        Button dataBadania;

        @OnClick(R.id.button_wybierz)
        void onItemBadanieClick(){ zaladujPojedynczeBadanie();}

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        private void setID(String ID) {idBadania.setText(ID);}
        private void setDate(String data) {
            String badanieZDnia = "Badanie z dnia: " + data;
            dataBadania.setText(badanieZDnia);
        }

        void zaladujPojedynczeBadanie(){
            Intent intent = new Intent(context, WidokBadaniaWykonanego.class);
            intent.putExtra("idBadania",idBadania.getText().toString());
            context.startActivity(intent);
        }
    }
}
