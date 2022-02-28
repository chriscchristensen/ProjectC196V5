package android.reserver.projectc196v5.Database;


import static java.lang.Thread.sleep;

import android.app.Application;
import android.reserver.projectc196v5.DAO.AssessmentDAO;
import android.reserver.projectc196v5.DAO.CourseDAO;
import android.reserver.projectc196v5.DAO.TermDAO;
import android.reserver.projectc196v5.Entity.AssessmentEntity;
import android.reserver.projectc196v5.Entity.CourseEntity;
import android.reserver.projectc196v5.Entity.TermEntity;

import java.util.List;

public class SchoolManagementRepository {
    private TermDAO mTermDAO;
    private CourseDAO mCourseDAO;
    private AssessmentDAO mAssessmentDAO;
    private List<TermEntity> mAllTerms;
    private List<CourseEntity> mAllCourses;
    private List<AssessmentEntity> mAllAssessments;
    private int termID;

        public SchoolManagementRepository(Application application) {
            SchoolManagementDatabase db=SchoolManagementDatabase.getDatabase(application);
            mTermDAO = db.termDAO();
            mCourseDAO = db.courseDAO();
            mAssessmentDAO = db.assessmentDAO();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    public List<TermEntity> getAllTerms() {
        SchoolManagementDatabase.databaseWriteExecutor.execute(()->{
            mAllTerms = mTermDAO.getAllTerms();
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }

    public List<CourseEntity> getAllCourses() {
        SchoolManagementDatabase.databaseWriteExecutor.execute(()->{
            mAllCourses = mCourseDAO.getAllCourses();
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllCourses;
    }

    public List<AssessmentEntity> getAllAssessments() {
        SchoolManagementDatabase.databaseWriteExecutor.execute(()->{
            mAllAssessments = mAssessmentDAO.getAllAssessments();
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public void insert (TermEntity termEntity) {
        SchoolManagementDatabase.databaseWriteExecutor.execute(()->{
            mTermDAO.insert(termEntity);
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
    }

    public void insert (CourseEntity courseEntity) {
        SchoolManagementDatabase.databaseWriteExecutor.execute(()->{
            mCourseDAO.insert(courseEntity);
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
    }

    public void insert (AssessmentEntity assessmentEntity) {
        SchoolManagementDatabase.databaseWriteExecutor.execute(()->{
            mAssessmentDAO.insert(assessmentEntity);
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
    }

    public void delete (TermEntity termEntity) {
        SchoolManagementDatabase.databaseWriteExecutor.execute(() -> {
            mTermDAO.delete(termEntity);
        });

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete (CourseEntity courseEntity) {
        SchoolManagementDatabase.databaseWriteExecutor.execute(() -> {
            mCourseDAO.delete(courseEntity);
        });

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete (AssessmentEntity assessmentEntity) {
        SchoolManagementDatabase.databaseWriteExecutor.execute(() -> {
            mAssessmentDAO.delete(assessmentEntity);
        });

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
