package th.ac.su.cp.project_horoscope.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "users")
public class User {


    @PrimaryKey(autoGenerate = true)
    public final int id;

    @ColumnInfo(name = "first_name")
    public final String firstName;

    @ColumnInfo(name = "last_name")
    public final String lastName;


    public final String age;
    public final String gender;



    public User(int id, String firstName, String lastName, String age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age =age;
        this.gender = gender;

    }
}
