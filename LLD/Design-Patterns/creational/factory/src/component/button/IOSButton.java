package component.button;

public class IOSButton implements Button{
    @Override
    public void changeSize() {
        System.out.println("IOS Button change size");
    }
}
