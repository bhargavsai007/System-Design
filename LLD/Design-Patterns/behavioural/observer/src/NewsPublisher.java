public interface NewsPublisher {

    void publishNews(String news);

    void addSubscriber(NewsSubscriber newsSubscriber);

    void removeSubscriber(NewsSubscriber newsSubscriber);

}
