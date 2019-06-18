package com.example.aapnik_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
public EditText e;
public String s;
private Button b;

private Adapter adapter;
private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=findViewById(R.id.et);

        s=e.getText().toString().trim();
        b=findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makecall(s);

            }
        });


    }

    private void makecall(String tag) {
        s=e.getText().toString().trim();

        services service=client.getInstance().create(services.class);
        Call<items> call=service.getLis(s,"stackoverflow");
        call.enqueue(new Callback<items>() {
            @Override
            public void onResponse(Call<items> call, Response<items> response) {
                generatelist(response.body());
            }

            @Override
            public void onFailure(Call<items> call, Throwable t) {
                Toast.makeText(MainActivity.this,"gfgf",Toast.LENGTH_SHORT);
            }
        });
    }

    private void generatelist(items body) {

        rv=findViewById(R.id.rv);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
adapter=new Adapter(MainActivity.this,body.getList());
rv.setLayoutManager(lm);
rv.setAdapter(adapter);



    }
}
