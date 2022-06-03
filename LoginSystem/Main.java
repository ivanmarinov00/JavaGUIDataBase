package LoginSystem;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        idAndPass idAndPasswords = new idAndPass();
        LoginPage loginPage = new LoginPage(idAndPasswords.getLoginInfo());
    }
}
