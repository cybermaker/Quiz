package qz3282.egci428.com.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewRoute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_route);

        Button startbtn = (Button)findViewById(R.id.startbtn);
        assert startbtn != null;
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(NewRoute.this, Mapsnewroute.class);
                   startActivity(intent);
            }
        });
    }
}
