package android.reserver.projectc196v5.ui.assessments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssessmentViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AssessmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Assessments Fragment");
    }

    public LiveData<String> getText() { return mText; }
}