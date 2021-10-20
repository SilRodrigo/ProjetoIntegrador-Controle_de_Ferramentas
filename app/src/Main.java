import com.controller.MenuController;
import com.controller.UserController;
import com.view.Screen;

public class Main {

  public static void main(String[] args) {
    /* Login? */
    String userName = "Default";
    /* loadComponents */
    UserController user = new UserController(userName);
    MenuController menu = new MenuController();
    Screen screen = new Screen(user, menu);
    /* Show Interface */
    while (user.getLogged()) {
      screen.render();
    }
  }
}
