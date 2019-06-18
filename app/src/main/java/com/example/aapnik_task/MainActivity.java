package com.example.aapnik_task;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
public EditText e;
public String s;
private Button b;
private TextView t;


private Adapter adapter;
private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=findViewById(R.id.et);
t=findViewById(R.id.tv4);

/*t.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(t.getText().toString()));
        startActivity(browserIntent);

    }
});*/
        s=e.getText().toString().trim();
        b=findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makecall(s,"activity");

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.activity:
                makecall(s,"activity");
                //Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.creation:

              makecall(s,"creation"); // Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.votes:
                makecall(s,"votes");
               // Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void makecall(String tag,String sort) {
        s=e.getText().toString().trim();

        services service=client.getInstance().create(services.class);
        Call<items> call=service.getLis(s,"stackoverflow",sort);
        call.enqueue(new Callback<items>() {
            @Override
            public void onResponse(Call<items> call, Response<items> response) {
                generatelist(response.body());
            }

            @Override
            public void onFailure(Call<items> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT);
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
