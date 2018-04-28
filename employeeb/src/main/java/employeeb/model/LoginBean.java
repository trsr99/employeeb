package employeeb.model;

import java.io.Serializable;

public class LoginBean implements Serializable  {

private static final long serialVersionUID = 1L;
private String email,pass;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}


}
