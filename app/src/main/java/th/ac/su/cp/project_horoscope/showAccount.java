package th.ac.su.cp.project_horoscope;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.project_horoscope.Util.AppExecutors;
import th.ac.su.cp.project_horoscope.adapter.UserAdapter;
import th.ac.su.cp.project_horoscope.db.AppDatabase;
import th.ac.su.cp.project_horoscope.model.User;

public class showAccount extends AppCompatActivity {

    private static final String TAG = showAccount.class.getName();
    private RecyclerView mRecyclerView;

    @Override
    protected void onResume(){
        super.onResume();

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(showAccount.this);
                final User[] users = db.userDao().getAllUsers();

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        UserAdapter adapter = new UserAdapter(showAccount.this, users);
                        mRecyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_account);

        mRecyclerView = findViewById(R.id.user_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(showAccount.this));


    }
}