package th.ac.su.cp.project_horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import th.ac.su.cp.project_horoscope.Util.AppExecutors;
import th.ac.su.cp.project_horoscope.db.AppDatabase;
import th.ac.su.cp.project_horoscope.model.User;


public class createAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        final Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_cancel = new Intent(createAccount.this, MainActivity.class);
                startActivity(intent_cancel);

            }
        });

        // ทำsavebutton
        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname;
                String lastname;
                String age;
                String gender;

                final User user = new User(0,"pppp","yy","18","Male");
                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(createAccount.this);
                        db.userDao().addUser(user);
                        finish();
                    }
                });

            }
        });
    }
}