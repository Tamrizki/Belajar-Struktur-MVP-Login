package tam.ttr.loginmvp;

import android.text.TextUtils;

public class LoginPresentImp implements LoginPresenter{

    private LoginView loginView;

    public LoginPresentImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String nama, String password) {
        if (TextUtils.isEmpty(nama) || TextUtils.isEmpty(password))
        {
            loginView.showValidationError();
        }else {
            if (nama.equals("username") && password.equals("password")){
                loginView.loginSuccess();
            }else {
                loginView.loginError();
            }
        }
    }
}
