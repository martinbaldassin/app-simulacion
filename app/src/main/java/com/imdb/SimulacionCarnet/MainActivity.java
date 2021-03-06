package com.imdb.SimulacionCarnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Client> clientsQueue = new ArrayList<>();
    private ClientAdapter adapter;
    private int clientCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ClientAdapter(clientsQueue,this);

        ListView listViewClientsQueue = (ListView)findViewById(R.id.listViewClientsQueue);
        listViewClientsQueue.setAdapter(adapter);
        clientCounter = 0;

        Button btnQueueClient = (Button)findViewById(R.id.btnQueueClient);

        btnQueueClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    clientCounter++;
                    clientsQueue.add(new Client(clientCounter));
                    adapter.notifyDataSetChanged();
//                    Toast.makeText(getApplicationContext(), "Cliente en cola de espera...", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Ocurrio un error: " + e.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
