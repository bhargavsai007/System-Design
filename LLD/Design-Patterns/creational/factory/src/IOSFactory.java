import component.button.Button;
import component.button.IOSButton;
import component.menu.IOSMenu;
import component.menu.Menu;

public class IOSFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}