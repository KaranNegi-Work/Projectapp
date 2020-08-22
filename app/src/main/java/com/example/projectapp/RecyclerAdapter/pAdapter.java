package com.example.projectapp.RecyclerAdapter;
    import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projectapp.R;
import java.util.zip.Inflater;

    public class pAdapter extends RecyclerView.Adapter<pAdapter.pViewHolder> {
        private String[] data;
        public pAdapter(String[] data){
            this.data =data;
        }

        @NonNull
        @Override
        public pViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater lf= LayoutInflater.from(parent.getContext());
            View v= lf.inflate(R.layout.tamplet,parent,false);
            return new pViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull pViewHolder holder, int position) {
            String title=data[position];
            holder.textView.setText(title);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        public class pViewHolder extends RecyclerView.ViewHolder{
            ImageView icon;
            TextView textView;
            public pViewHolder(@NonNull View itemView) {
                super(itemView);
                icon= itemView.findViewById(R.id.imageView);
                textView=itemView.findViewById(R.id.textView);
            }

        }
    }


