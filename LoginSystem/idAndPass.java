package LoginSystem;

import java.util.HashMap;

public class idAndPass {
    HashMap<String , String> loginInfo = new HashMap<>();

    idAndPass(){
        loginInfo.put("Ivan", "pass123");
        loginInfo.put("Stoqn", "Pass");
        loginInfo.put("Brom", "sup");
    }

    protected HashMap<String, String> getLoginInfo () {
        return loginInfo;
    }
}
