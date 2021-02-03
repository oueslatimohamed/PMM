package fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myspace.MainActivity;
import com.example.myspace.R;


public class ProfileFragment extends Fragment {
    TextView mScore;
    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActionBar().setTitle("Compte");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        int score = getArguments().getInt("Score");
        mScore = (TextView) view.findViewById(R.id.profile_tv_score);
        mScore.setText(String.valueOf(score));
        Log.i("Score in profile" , String.valueOf(getArguments().getInt("Score")));
        // Inflate the layout for this fragment
        return view;
    }
}