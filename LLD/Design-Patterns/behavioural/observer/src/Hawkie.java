public class Hawkie implements NewsSubscriber{
    @Override
    public void readNews(String news, String fromChannel) {
        System.out.println("Hawkie has received the news:- "+news+" from "+fromChannel);
    }
}
