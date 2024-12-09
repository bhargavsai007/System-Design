import component.button.AndroidButton;
import component.button.Button;
import component.menu.AndroidMenu;
import component.menu.Menu;

public class AndroidFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}