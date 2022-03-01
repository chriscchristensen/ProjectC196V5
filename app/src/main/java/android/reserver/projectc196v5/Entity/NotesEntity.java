package android.reserver.projectc196v5.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")

public class NotesEntity {

    @PrimaryKey
    private int noteID;

    private String noteName;
    private String noteText;
    private int noteCourseId;

    @Override
    public String toString() {
        return "NotesEntity{" +
                "noteID=" + noteID +
                ", noteName=" + noteName + '\'' +
                ", noteText=" + noteText + '\'' +
                ", noteCourseId=" + noteCourseId +
                '}';
    }

    public NotesEntity(int noteID, String noteName, String noteText, int noteCourseId) {
        this.noteID = noteID;
        this.noteName = noteName;
        this.noteText = noteText;
        this.noteCourseId = noteCourseId;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public int getNoteCourseId() {
        return noteCourseId;
    }

    public void setNoteCourseId(int noteCourseId) {
        this.noteCourseId = noteCourseId;
    }
}
