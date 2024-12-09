import component.button.Button;
import component.menu.Menu;

public interface UIFactory {

    Button createButton();

    Menu createMenu();
}
