package tam.ttr.loginmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;
    private EditText etUsername, etPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = findViewById(R.id.et_pass);
        etUsername = findViewById(R.id.et_username);
        button = findViewById(R.id.bt_login);

        loginPresenter = new LoginPresentImp((LoginView) this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Please enter valid username and password!", Toast.LENGTH_SHORT);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "You are successfully logged in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
    }
}
