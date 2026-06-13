package designpatternpracticeshrayansh.observerdesignpattern;

import designpatternpracticeshrayansh.observerdesignpattern.observable.IphoneObservableImpl;
import designpatternpracticeshrayansh.observerdesignpattern.observable.StocksObservable;
import designpatternpracticeshrayansh.observerdesignpattern.observer.EmailAlertObserverImpl;
import designpatternpracticeshrayansh.observerdesignpattern.observer.MobileAlertObserverImpl;
import designpatternpracticeshrayansh.observerdesignpattern.observer.NotificationAlertObserver;

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
