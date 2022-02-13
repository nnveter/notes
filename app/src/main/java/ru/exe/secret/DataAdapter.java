package ru.exe.secret;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<ViewHolder>{

    LayoutInflater inflater;
    Context context;

    public DataAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v1 = inflater.inflate(R.layout.item, parent, false);
        viewHolder = new ViewHolder(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(MainActivity.title.get(position));
        int in = position;

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.dataAdapter.notifyItemRemoved(in);
                MainActivity.soder.remove(MainActivity.soder.get(in));
                MainActivity.title.remove(MainActivity.title.get(in));
                try {
                    if (context instanceof MainActivity) {
                        FileOutputStream fos = ((MainActivity) context).openFileOutput("title.txt", Context.MODE_PRIVATE);
                        ObjectOutputStream os = new ObjectOutputStream(fos);
                        os.writeObject(MainActivity.title);
                        os.close();
                        fos.close();
                        FileOutputStream fos2 = ((MainActivity) context).openFileOutput("body.txt", Context.MODE_PRIVATE);
                        ObjectOutputStream os2 = new ObjectOutputStream(fos2);
                        os2.writeObject(MainActivity.soder);
                        os2.close();
                        fos2.close();
                    }
                } catch (IOException ignored) { }
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ti = MainActivity.title.get(in);
                MainActivity.so = MainActivity.soder.get(in);
                if (context instanceof MainActivity){
                    ((MainActivity) context).nextAction();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return MainActivity.title.size();
    }

}
