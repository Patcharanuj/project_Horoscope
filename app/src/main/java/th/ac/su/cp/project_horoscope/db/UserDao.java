package th.ac.su.cp.project_horoscope.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import th.ac.su.cp.project_horoscope.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    User[] getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id")
    User getUserById(int id);

    @Insert
    void addUser(User... users);




}
/* @Query("DELETE FROM users")
    void deleteAll();*/