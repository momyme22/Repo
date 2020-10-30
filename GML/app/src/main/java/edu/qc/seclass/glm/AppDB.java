package edu.qc.seclass.glm;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.RoomDatabase;

import java.util.List;

public class AppDB {
    @Entity
    public class User {
        @PrimaryKey(autoGenerate = true)
        public int uid;

        @ColumnInfo(name = "user_name")
        public String userName;

        @ColumnInfo(name = "password")
        public String password;
    }

    @Entity
    public class Groceries{

        @PrimaryKey(autoGenerate = true)
        public int groceryid;

        @PrimaryKey
        @ColumnInfo(name="Category")
        public String cat;

        @PrimaryKey
        @ColumnInfo(name="item")
        public String item;

    }

    @Dao
    public interface UserDao {
        @Query("SELECT * FROM user")
        List<User> getAll();

        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
        List<User> loadAllByIds(int[] userIds);

        @Query("SELECT * FROM user WHERE user_name LIKE :first AND " +
                "password LIKE :last LIMIT 1")
        User findByName(String first, String last);

        @Insert
        void insertAll(User... users);

        @Delete
        void delete(User user);
    }

    @Database(entities = {User.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();
    }
}
