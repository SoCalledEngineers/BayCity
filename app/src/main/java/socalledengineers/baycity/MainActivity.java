package socalledengineers.baycity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DangeruGetter _apiWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _apiWrapper = new DangeruGetter();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v){
            EditText boardName = (EditText) findViewById(R.id.editText);
            String boardNameString = boardName.getText().toString();
            try {
                _apiWrapper.getThreadList(boardNameString, 10);
            }
            catch (IOException e){
                System.out.println("Fetch Error");
            }
            catch(org.json.JSONException e){
                System.out.println("JSON Error");
            }
        }
        });
    }
}
