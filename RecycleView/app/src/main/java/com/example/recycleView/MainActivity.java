package com.example.simplelist;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> names;
    ArrayList<String> phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        names = new ArrayList<>();
        phones = new ArrayList<>();

        names.add("مریم");
        phones.add("09120000001");

        names.add("حمید");
        phones.add("09350000002");

        names.add("سعید");
        phones.add("09130000003");

        recyclerView.setAdapter(new SimpleAdapter());
    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView tv = new TextView(parent.getContext());
            tv.setPadding(20, 20, 20, 20);
            tv.setTextSize(18);
            return new MyViewHolder(tv);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(names.get(position) + "\n" + phones.get(position));
        }

        @Override
        public int getItemCount() {
            return names.size();
        }
    }
}