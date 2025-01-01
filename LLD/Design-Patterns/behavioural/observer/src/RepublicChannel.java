import java.util.ArrayList;
import java.util.List;

public class RepublicChannel implements NewsPublisher{

    private final List<NewsSubscriber> subscriberList;
    private String news;

    public RepublicChannel() {
        subscriberList = new ArrayList<>();
    }

    @Override
    public void publishNews(String news) {
        this.news = news;
        notifyAllSubscribers();
    }

    @Override
    public void addSubscriber(NewsSubscriber newsSubscriber) {
        subscriberList.add(newsSubscriber);
    }

    @Override
    public void removeSubscriber(NewsSubscriber newsSubscriber) {
        subscriberList.remove(newsSubscriber);
    }

    private void notifyAllSubscribers() {
        subscriberList.forEach(newsSubscriber -> newsSubscriber.readNews(news, getClass().getName()));
    }
}
