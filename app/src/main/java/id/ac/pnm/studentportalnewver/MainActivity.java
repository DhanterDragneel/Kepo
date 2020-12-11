package id.ac.pnm.studentportalnewver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String KEY_NPM = "NPM", npm, npmOut;
    TextView masterNPM;
    Button btnprofil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masterNPM = (TextView) findViewById(R.id.masterNPM);
        Bundle extras = getIntent().getExtras();
        npm = extras.getString(KEY_NPM);
        masterNPM.setText(npm);
        btnprofil = (Button) findViewById(R.id.btnProfil);
        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npm = masterNPM.getText().toString();
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("npmE", npm);
                startActivity(intent);
            }
        });
    }
}
