package android.reserver.projectc196v5.Database;

import android.content.Context;
import android.reserver.projectc196v5.DAO.AssessmentDAO;
import android.reserver.projectc196v5.DAO.CourseDAO;
import android.reserver.projectc196v5.DAO.NoteDAO;
import android.reserver.projectc196v5.DAO.TermDAO;
import android.reserver.projectc196v5.Entity.AssessmentEntity;
import android.reserver.projectc196v5.Entity.CourseEntity;
import android.reserver.projectc196v5.Entity.NotesEntity;
import android.reserver.projectc196v5.Entity.TermEntity;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.sql.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {AssessmentEntity.class, CourseEntity.class, TermEntity.class, NotesEntity.class}, version = 1)

public abstract class SchoolManagementDatabase extends RoomDatabase {
    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();
    public abstract NoteDAO noteDAO();
    private static final int NUMBER_OF_THREADS = 4;
    /**
     * The Database write executor.
     */
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile SchoolManagementDatabase INSTANCE;

    static SchoolManagementDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SchoolManagementDatabase.class) {
                if (INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SchoolManagementDatabase.class, "school_management_database.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                /*
                 * Populate the database in the background.
                 * If you want to start with more words, just add them.
                 */

                TermDAO mTermDao = INSTANCE.termDAO();
                CourseDAO mCourseDao = INSTANCE.courseDAO();
                AssessmentDAO mAssessmentDao = INSTANCE.assessmentDAO();
                NoteDAO mNoteDAO = INSTANCE.noteDAO();

                // Start the app with a clean database every time.
                // Not needed if you only populate on creation.
                mTermDao.deleteAllTerms();
                mCourseDao.deleteAllCourses();
                mAssessmentDao.deleteAllAssessments();
                mNoteDAO.deleteAllNotes();

                TermEntity term = new TermEntity(1, "Sample Term", "2022-02-28", "2022-03-02");
                mTermDao.insert(term);

                CourseEntity course = new CourseEntity(1, "Sample Course", "2022-02-28", "2022-03-02", 1, "Antonio Sierra", 1);
                mCourseDao.insert(course);

                AssessmentEntity assessment = new AssessmentEntity(1, "Sample Assessment", "2022-03-02", 1, 1);
                mAssessmentDao.insert(assessment);

                NotesEntity note = new NotesEntity(1, "Sample Name", "Sample Text", 1);
                mNoteDAO.insert(note);
            });
        }
    };
}
