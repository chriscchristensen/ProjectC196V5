package android.reserver.projectc196v5.DAO;

import android.reserver.projectc196v5.Entity.NotesEntity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NotesEntity note);

    @Delete
    void delete(NotesEntity note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY noteID ASC")
    List<NotesEntity> getAllNotes();
}
