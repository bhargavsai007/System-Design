public class Zofer implements NewsSubscriber{
    @Override
    public void readNews(String news, String fromChannel) {
        System.out.println("Zofer has received the news:- "+news+" from "+fromChannel);
    }
}
