package android.alex.edu.colorpickercont;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher {

    public static int prevRgb;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;
    private EditText etRed;
    private EditText etGreen;
    private EditText etBlue;
    private boolean byUser = true;
    private boolean userIsCurrentlyScrolling = false;

    private TextView tvForFragmentInitText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();

        initEvents();
    }

    private void initEvents() {
        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

        etGreen.addTextChangedListener(this);
        etBlue.addTextChangedListener(this);
        etRed.addTextChangedListener(this);
    }


    private void initLayout()
    {
        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);
        etRed = (EditText) findViewById(R.id.etRed);
        etBlue = (EditText) findViewById(R.id.etBlue);
        etGreen = (EditText) findViewById(R.id.etGreen);

        tvForFragmentInitText = (TextView) findViewById(R.id.tvForFragmentInitText);
        int initRgb = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());
        tvForFragmentInitText.setTextColor(initRgb);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        this.userIsCurrentlyScrolling = fromUser;

        if (userIsCurrentlyScrolling) {
            etGreen.setText(String.valueOf(sbGreen.getProgress()));
            etBlue.setText(String.valueOf(sbBlue.getProgress()));
            etRed.setText(String.valueOf(sbRed.getProgress()));
        }

        this.userIsCurrentlyScrolling = false;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {
        try {
            int redValue = Integer.valueOf(etRed.getText().toString());
            int greenValue = Integer.valueOf(etGreen.getText().toString());
            int blueValue = Integer.valueOf(etBlue.getText().toString());

            if(!userIsCurrentlyScrolling)
            {
                sbRed.setProgress(redValue);
                sbGreen.setProgress(greenValue);
                sbBlue.setProgress(blueValue);
            }
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
/*
    private void setColor(boolean isText) {
        int rgb = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());

        ColorsFragment colorsFrag = ColorsFragment.newInstance(rgb, isText);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, colorsFrag)
                .commit();
    }
*/
    public void setTextColor(View view)
    {
        boolean isText = true;
        //setColor(isText);
        int rgb = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());

        ColorsFragment colorsFrag = ColorsFragment.newInstance(rgb, isText);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, colorsFrag)
                .commit();

    }

    public void setBackgroundColor(View view)
    {
        boolean isText = false;
        //setColor(isText);
        int rgb = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());

        ColorsFragment colorsFrag = ColorsFragment.newInstance(rgb, isText);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, colorsFrag)
                .commit();

    }
}
