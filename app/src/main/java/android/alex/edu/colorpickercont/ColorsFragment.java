package android.alex.edu.colorpickercont;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment{

    public static final  String ARG_COLOR = "TheColor";
    public static final  String ARG_IS_TEXT = "IsText";

    private static int prevTextColor = Color.rgb(128, 128, 128);
    private static int prevBackgroundColor = Color.WHITE;

    public static ColorsFragment newInstance(int rgb, boolean isText) {
        ColorsFragment fragment = new ColorsFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, rgb);
        args.putBoolean(ARG_IS_TEXT, isText);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_colors, container, false);

        Bundle args = getArguments();
        int rgb = 0;
        boolean isText = true;
        if (args != null) {
            rgb = args.getInt(ARG_COLOR);
            isText = args.getBoolean(ARG_IS_TEXT);
        }

        FrameLayout colorFrame = (FrameLayout) v.findViewById(R.id.colorsFrame);
        TextView tvText = (TextView) v.findViewById(R.id.tvText);;
        if(isText)
        {
            prevTextColor = rgb;
            tvText.setTextColor(rgb);
            colorFrame.setBackgroundColor(prevBackgroundColor);
        }
        else
        {
            prevBackgroundColor = rgb;
            colorFrame.setBackgroundColor(rgb);
            tvText.setTextColor(prevTextColor);
        }

        return v;
    }
}
