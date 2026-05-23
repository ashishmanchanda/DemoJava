package designpattern.observerdesignpattern;

import designpattern.observerdesignpattern.observable.IphoneObservableImpl;
import designpattern.observerdesignpattern.observable.StocksObservable;
import designpattern.observerdesignpattern.observer.EmailAlertObserverImpl;
import designpattern.observerdesignpattern.observer.MobileAlertObserverImpl;
import designpattern.observerdesignpattern.observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStockObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl( "xyz_username", iphoneStockObservable);
        iphoneStockObservable.add(observer1); iphoneStockObservable.add (observer2); iphoneStockObservable.add(observer3);
        iphoneStockObservable.setStockCount(10);
    }
}
