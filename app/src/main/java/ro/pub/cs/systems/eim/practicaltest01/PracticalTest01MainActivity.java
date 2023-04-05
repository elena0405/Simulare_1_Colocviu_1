package ro.pub.cs.systems.eim.practicaltest01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private EditText first_edit_text;
    private EditText second_edit_text;
    private Button press_me_button;
    private Button press_me_too_button;
    private Button secondary_activity_button;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int button_id = view.getId();
            int first_number_of_counts = Integer.parseInt(first_edit_text.getText().toString());
            int second_number_of_counts = Integer.parseInt(second_edit_text.getText().toString());

            if (button_id == R.id.press_me_button) {
                first_number_of_counts = first_number_of_counts + 1;
                first_edit_text.setText(String.valueOf(first_number_of_counts));
            } else if (button_id == R.id.press_me_too_button) {
                second_number_of_counts = second_number_of_counts + 1;
                second_edit_text.setText(String.valueOf(second_number_of_counts));
            } else if (button_id == R.id.secondary_activity_button) {
                Intent intent = new Intent(getApplicationContext(),
                                            PracticalTest01SecondaryActivity.class);

                int number = Integer.parseInt(first_edit_text.getText().toString()) +
                                Integer.parseInt(second_edit_text.getText().toString());

                intent.putExtra("number_count_edit_text", number);
                startActivityForResult(intent, 2017);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String first_number_count = first_edit_text.getText().toString();
        String second_number_count = second_edit_text.getText().toString();

        outState.putString("first_edit_text", first_number_count);
        outState.putString("second_edit_text", second_number_count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("first_edit_text")) {
            first_edit_text.setText(savedInstanceState.getString("first_edit_text"));
        } else {
            first_edit_text.setText(String.valueOf(0));
        }

        if (savedInstanceState.containsKey("second_edit_text")) {
            second_edit_text.setText(savedInstanceState.getString("second_edit_text"));
        } else {
            second_edit_text.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        first_edit_text = findViewById(R.id.first_edit_text);
        second_edit_text = findViewById(R.id.second_edit_text);

        press_me_button = findViewById(R.id.press_me_button);
        press_me_too_button = findViewById(R.id.press_me_too_button);
        secondary_activity_button = findViewById(R.id.secondary_activity_button);

        first_edit_text.setText(String.valueOf(0));
        second_edit_text.setText(String.valueOf(0));

        press_me_button.setOnClickListener(buttonClickListener);
        press_me_too_button.setOnClickListener(buttonClickListener);
        secondary_activity_button.setOnClickListener(buttonClickListener);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 2017) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("practicaltest01", "onResume() method was invoked!" );
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("practicaltest01", "onStop() method was invoked!" );
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("practicaltest01", "onStart() method was invoked!" );
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("practicaltest01", "onPause() method was invoked!" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("practicaltest01", "onDestroy() method was invoked!" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("practicaltest01", "onRestart() method was invoked!" );
    }
}