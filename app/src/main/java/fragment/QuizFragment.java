package fragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myspace.MainActivity;
import com.example.myspace.R;

import java.util.Locale;


public class QuizFragment extends Fragment {
    TextView question;
    RadioGroup answersGrp;
    RadioButton a1, a2, a3, a4;
    Button btnNext;
    ImageView planetImgs;
    int[] images= {
        R.drawable.earth,
        R.drawable.solarsystem,
        R.drawable.planets,
        R.drawable.solarsystem,
        R.drawable.sun,
        R.drawable.mars,
        R.drawable.galaxy,
        R.drawable.molecule,
        R.drawable.mercury,
        R.drawable.sun

    };


    int incrementQuestion = 0;
    int score = 0;
    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActionBar().setTitle("quiz");
    }

    Bundle bundle = new Bundle();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        question = (TextView) view.findViewById(R.id.question);
        answersGrp = (RadioGroup) view.findViewById(R.id.answersGroup);
        a1=(RadioButton) view.findViewById(R.id.answerOne);
        a2=(RadioButton) view.findViewById(R.id.answerTwo);
        a3=(RadioButton) view.findViewById(R.id.answerThree);
        a4=(RadioButton) view.findViewById(R.id.answerFour);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        planetImgs = (ImageView) view.findViewById(R.id.planet_img);
        String []questions = getContext().getResources().getStringArray(R.array.questionss);
        String []answers = getContext().getResources().getStringArray(R.array.answers);
        String []options = getContext().getResources().getStringArray(R.array.options);
        question.setText(questions[incrementQuestion]);
        a1.setText(options[0]);
        a2.setText(options[1]);
        a3.setText(options[2]);
        a4.setText(options[3]);
        planetImgs.setImageResource(images[0]);

        //submit answer and go to next question
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answersGrp.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getContext(), getResources().getString(R.string.choose), Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton userAnswer = (RadioButton) answersGrp.findViewById(answersGrp.getCheckedRadioButtonId());
                String answerText = userAnswer.getText().toString();
//                Toast.makeText(getContext(),answerText,Toast.LENGTH_SHORT).show();
                if(answerText.equals(answers[incrementQuestion])){
                    score ++;
                    Toast.makeText(getContext(),getResources().getString(R.string.toutfait), Toast.LENGTH_SHORT).show();
                }
                else{
                    score --;
                    Toast.makeText(getContext(),getResources().getString(R.string.faux), Toast.LENGTH_SHORT).show();
                }
                incrementQuestion ++;
                if(incrementQuestion<questions.length)
                {
                    question.setText(questions[incrementQuestion]);
                    a1.setText(options[incrementQuestion*4]);
                    a2.setText(options[incrementQuestion*4 +1]);
                    a3.setText(options[incrementQuestion*4 +2]);
                    a4.setText(options[incrementQuestion*4 +3]);
                    planetImgs.setImageResource(images[incrementQuestion]);

                }else if(incrementQuestion == questions.length){   // not working
                    Bundle bundle = new Bundle();
                    ProfileFragment profilefragment = new ProfileFragment();
                    bundle.putInt("Score", score);
                    profilefragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.compteLayout,profilefragment);
                    //fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }
                answersGrp.clearCheck();
            }
        });

        return view;
    }

}