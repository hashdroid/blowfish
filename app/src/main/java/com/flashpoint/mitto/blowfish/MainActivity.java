package com.flashpoint.mitto.blowfish;


//import android.content.Intent;
//import android.provider.Settings;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    // TextView textFile, textFileName, textFolder;
    //String FilePath;

    //private static final int PICKFILE_RESULT_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.upload);

        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                File sdcard= Environment.getExternalStorageDirectory();
                Log.e("hello",sdcard.getPath());


                File inputFile = new File(sdcard,"Hello.txt");
                File encryptedFile = new File(sdcard,"file.encrypted");

                File decryptedFile = new File(sdcard,"DecryptedFile.txt");
                try {
                    TestFileEncryption.encrypt(inputFile, encryptedFile);
                    Toast.makeText(MainActivity.this,"Encrypted successfully",Toast.LENGTH_LONG).show();
                    TestFileEncryption.decrypt(encryptedFile, decryptedFile);
                    Toast.makeText(MainActivity.this,"Decrypted successfully",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
