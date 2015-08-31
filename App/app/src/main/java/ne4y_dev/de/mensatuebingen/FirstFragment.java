package ne4y_dev.de.mensatuebingen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private int page;
    private String food, student, pupil, guest;
    private Menue m;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, Menue men) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("food", men.getFood());
        args.putString("student", men.getStudentPrice());
        args.putString("pupil", men.getPupilPrice());
        args.putString("guest", men.getGuestPrice());
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        food = getArguments().getString("food");
        student = getArguments().getString("student");
        pupil = getArguments().getString("pupil");
        guest = getArguments().getString("guest");


    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        TextView foodLabel = (TextView) view.findViewById(R.id.food);
        foodLabel.setText(food);

        // Studentenpreis
        TextView studentPrice = (TextView) view.findViewById(R.id.student);
        studentPrice.setText("Studentenpreis: " + student);

        // deactivated on website
        // Schülerpreis
       /* TextView pupilPrice = (TextView) view.findViewById(R.id.pupil);
        pupilPrice.setText("Schülerpreis: " + pupil);*/

        // Gastpreis
        TextView guestPrice = (TextView) view.findViewById(R.id.guest);
        guestPrice.setText("Gastpreis: " + guest);
        return view;
    }
}
