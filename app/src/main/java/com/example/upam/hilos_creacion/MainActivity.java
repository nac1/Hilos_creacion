package com.example.upam.hilos_creacion;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Handler mhandler=new Handler(Looper.getMainLooper());
        mhandler.post(hacer_algo);

    }


    private Runnable hacer_algo=new Runnable() {
        String tag="sms";
        @Override
        public void run() {

            try {
                Thread.sleep(5000);
                Log.d(tag, "Utilizando Handler");
                Toast.makeText(MainActivity.this,"handles ui"+getTaskId(),Toast.LENGTH_SHORT).show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

























    public void hilo_thread()
    {
        final String tag="sms";

        Thread t=new Thread(){
            public void  run()
            {
                try {
                    Thread.sleep(2000);
                    Log.d(tag, String.valueOf(getId()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }; t.start();
    }



    public void hilo_Runnable()
    {
        final String tag="sms";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Log.d(tag, String.valueOf(getTaskId()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public void Click_Thread(View v)
    {
        hilo_thread();


    }

    public void Click_Runnable(View v)
    {
        hilo_Runnable();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
