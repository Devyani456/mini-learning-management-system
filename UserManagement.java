package features;

import models.User;
import util.Utils;

public class UserManagement {

    public User addStudent(String username, String email, String phone, String password) {
        User u = new User(Utils.generateUserId(), username, email, phone, password, "student");
        Utils.addUser(u);
        return u;
    }

    public boolean deleteStudent(String userId) {
        for (int i = 0; i < Utils.userCount; i++) {
            if (Utils.users[i].userId.equals(userId) && Utils.users[i].userType.equals("student")) {
                for (int j = i; j < Utils.userCount - 1; j++) {
                    Utils.users[j] = Utils.users[j + 1];
                }
                Utils.users[--Utils.userCount] = null;
                return true;
            }
        }
        return false;
    }
}
