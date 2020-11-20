package th.ac.su.cp.project_horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_login = new Intent(MainActivity.this, showAccount.class);
                login.setBackgroundResource(R.color.newColor);
                startActivity(intent_login);

            }
        });

        final Button create = findViewById(R.id.create_button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_create = new Intent(MainActivity.this,createAccount.class);
                create.setBackgroundResource(R.color.newColor);
                startActivity(intent_create);
            }
        });
    }
}