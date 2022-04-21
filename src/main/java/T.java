import dao.Impl.UserDaoImpl;
import dao.UserDao;
import po.User;

public class T {
    public static void main(String[] args) throws Throwable {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectByName("白崎");
        System.out.println(user);
    }
}
