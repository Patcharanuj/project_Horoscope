package th.ac.su.cp.project_horoscope.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.project_horoscope.R;
import th.ac.su.cp.project_horoscope.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private User[] mUsers;


    public UserAdapter(Context context, User[] users) {
        this.mContext = context;
        this.mUsers = users;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mUsers[position];
        holder.firstnameTextView.setText(user.firstName);
        holder.lastnameTextView.setText(user.lastName);
        holder.ageTextView.setText(user.age);
        holder.genderTextView.setText(user.gender);




    }


    @Override
    public int getItemCount() {
        return mUsers.length;
    }


     static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstnameTextView;
        TextView lastnameTextView;
        TextView ageTextView;
        TextView genderTextView;

        public MyViewHolder(@NonNull View itemView){
            super (itemView);

            this.firstnameTextView = itemView.findViewById(R.id.firstname_textview);
            this.lastnameTextView = itemView.findViewById(R.id.lastname_textView);
            this.ageTextView = itemView.findViewById(R.id.age_textView);
            this.genderTextView = itemView.findViewById(R.id.gender_textView);
        }


    }
}
