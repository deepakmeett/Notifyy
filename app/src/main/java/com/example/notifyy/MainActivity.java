package com.example.notifyy;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.notifyy.App.CHANNEL_1_ID;
public class MainActivity extends AppCompatActivity {

    EditText editText, editText1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText = findViewById( R.id.title );
        editText1 = findViewById( R.id.message );
        button = findViewById( R.id.button );
        
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = editText.getText().toString();
                String s2 = editText1.getText().toString();
                
                NotificationManagerCompat nmc = NotificationManagerCompat.from( getApplicationContext() );
                Notification not = new NotificationCompat.Builder( getApplicationContext(), CHANNEL_1_ID )
                        .setSmallIcon( R.drawable.ic_android_black_24dp )
                        .setContentTitle( s1 )
                        .setContentText( s2 )
                        .setPriority( NotificationCompat.PRIORITY_HIGH )
                        .setCategory( NotificationCompat.CATEGORY_MESSAGE )
                        .build();
                nmc.notify( 1, not );
            }
        } );
    }
}
