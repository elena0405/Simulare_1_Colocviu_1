package ro.pub.cs.systems.eim.practicaltest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private EditText number_count_edit_text;
    private Button ok_button;
    private Button cancel_button;

    private ButtonOnClickListener listener = new ButtonOnClickListener();

    private class ButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();

            if (id == R.id.ok_button) {
                setResult(RESULT_OK, null);
            } else if (id == R.id.cancel_button) {
                setResult(RESULT_CANCELED, null);
            }

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        number_count_edit_text = findViewById(R.id.number_count_edit_text);
        ok_button = findViewById(R.id.ok_button);
        cancel_button = findViewById(R.id.cancel_button);

        ok_button.setOnClickListener(listener);
        cancel_button.setOnClickListener(listener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("number_count_edit_text")) {
            int number = intent.getExtras().getInt("number_count_edit_text");
            number_count_edit_text.setText(String.valueOf(number));
        }
    }
}