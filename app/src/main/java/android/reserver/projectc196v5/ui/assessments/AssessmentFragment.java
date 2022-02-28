package android.reserver.projectc196v5.ui.assessments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.reserver.projectc196v5.databinding.FragmentAssessmentsBinding;

public class AssessmentFragment extends Fragment {

    private FragmentAssessmentsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AssessmentViewModel assessmentViewModel =
                new ViewModelProvider(this).get(AssessmentViewModel.class);

        binding = FragmentAssessmentsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAssessment;
        assessmentViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}