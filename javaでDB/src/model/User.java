package model;

import java.io.Serializable;

@SuppressWarnings("static-access")
public class User implements Serializable {
/*	name: ログインユーザの名前
	pass: パスワード
*/

	private static String name;
	private static String pass;

	public User() {}
	public User(String name, String pass) {
		this.name=name;
		this.pass=pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


}
