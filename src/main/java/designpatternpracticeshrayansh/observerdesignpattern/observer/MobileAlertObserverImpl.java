package designpatternpracticeshrayansh.observerdesignpattern.observer;

import designpatternpracticeshrayansh.observerdesignpattern.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StocksObservable observable;
    public MobileAlertObserverImpl(String emailId, StocksObservable observable){
        this.observable = observable;
        this.userName = emailId;
    }

    @Override
    public void update() { sendMsgOnMobile (userName, "product is in stock hurry up!"); }
    private void sendMsgOnMobile (String userName, String msg){
        System.out.println("mso sent to:" + userName);
    }
}
