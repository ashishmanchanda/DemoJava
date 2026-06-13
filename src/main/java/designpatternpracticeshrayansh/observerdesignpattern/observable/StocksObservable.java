package designpatternpracticeshrayansh.observerdesignpattern.observable;

import designpatternpracticeshrayansh.observerdesignpattern.observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount (int newStockAdded);
    public int getStockCount() ;
}