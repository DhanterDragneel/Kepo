package id.ac.pnm.studentportalnewver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView npmProfile;
    String npm;
    Button btndtdiri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        npmProfile = (TextView) findViewById(R.id.NPMProfile);
        final Bundle extras = getIntent().getExtras();
        npm = extras.getString("npmE");
        npmProfile.setText(npm);
        btndtdiri = (Button) findViewById(R.id.btndtdiri);
        btndtdiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npm = npmProfile.getText().toString();
                Intent intent = new Intent(Profile.this, DataDiri.class);
                intent.putExtra("npmDtDiri", npm);
                startActivity(intent);
            }
        });
    }
}
