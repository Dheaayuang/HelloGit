package id.sch.smktelkom_mlg.tugas01.xirpl3007.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    EditText etNP;
    Button bOK;
    TextView tvHasil;
    Spinner spKA, spDari;

    String[][] arDari = {{"SB KOTA-KERTOSONO"}, {"KALIBARU-JEMBER"}, {"SB KOTA-BLITAR"}, {"SURABAYA-PROBOLINGGO"}, {"SB KOTA-BLITAR"}};
    ArrayList<String> listDari = new ArrayList<>();
    ArrayAdapter<String> adapter;

    RadioGroup rgKelas;
    CheckBox cbDW, cbAN, cbBY;
    TextView tvHasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNP = (EditText) findViewById(R.id.editTextNP);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        spKA = (Spinner) findViewById(R.id.spinnerKA);
        spDari = (Spinner) findViewById(R.id.spinnerDari);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listDari);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDari.setAdapter(adapter);

        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);
        cbDW = (CheckBox) findViewById(R.id.checkBoxDW);
        cbAN = (CheckBox) findViewById(R.id.checkBoxAN);
        cbBY = (CheckBox) findViewById(R.id.checkBoxBY);
        tvHasil2 = (TextView) findViewById(R.id.textViewH2);

        spKA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                listDari.clear();
                listDari.addAll(Arrays.asList(arDari[position]));
                adapter.notifyDataSetChanged();
                spDari.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doProcess2();
            }
        });

    }

    private void doProcess() {
        String hasil = null;
        if (rgKelas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgKelas.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Pilihlah kelas kereta api!");
        }


        if (isValid()) {
            String NP = etNP.getText().toString();
            tvHasil.setText("Nama Penumpang         : " + NP + "\nNama Kereta Api           : " + spKA.getSelectedItem().toString() +
                    "\nDari-Ke                            : " + spDari.getSelectedItem().toString()
                    + "\nKelas Kereta Api            : " + hasil);
        }
    }

    private void doProcess2() {
        String Hasil2 = "Jenis Penumpang            : ";
        int startlen = Hasil2.length();
        if (cbDW.isChecked()) Hasil2 += cbDW.getText() + ", ";
        if (cbAN.isChecked()) Hasil2 += cbAN.getText() + ", ";
        if (cbBY.isChecked()) Hasil2 += cbBY.getText();

        if (Hasil2.length() == startlen) Hasil2 += "Silahkan pilih jenis penumpang!";
        tvHasil2.setText(Hasil2);
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
