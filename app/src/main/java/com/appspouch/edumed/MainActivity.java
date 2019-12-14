package com.appspouch.edumed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appspouch.edumed.Interface.CategoryItemClick;
import com.appspouch.edumed.model.Category;
import com.appspouch.edumed.viewholder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    protected DatabaseReference reference;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    RecyclerView recyclerView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("Category");

        recyclerView = findViewById(R.id.recyclerView);

        loadData();
    }

    private void loadData()
    {
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(reference,Category.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull final Category model) {
                progressBar.setVisibility(View.GONE);
                holder.textView_disease.setText(model.getdiseaseName());
                holder.ClickMe(new CategoryItemClick() {
                    @Override
                    public void onClick(View view, boolean isLongClick) {
                        Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                        intent.putExtra("itemDetail",model.getdiseaseFacts());
                        intent.putExtra("itemDetail",model.getDiseaseCauses());
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this, ""+model.getdiseaseName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item,parent,false);
                return new CategoryViewHolder(view);
            }
        };
        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }
}
