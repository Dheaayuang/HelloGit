package id.sch.smktelkom_mlg.tugas01.xirpl3007.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNP;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNP = (EditText) findViewById(R.id.editTextNP);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String NP = etNP.getText().toString();
            tvHasil.setText(NP + " memesan");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String NP = etNP.getText().toString();
        if (NP.isEmpty()) {
            etNP.setError("Harap isi nama dahulu!");
            valid = false;
        } else {
            etNP.setError(null);
        }

        return valid;
    }

}
