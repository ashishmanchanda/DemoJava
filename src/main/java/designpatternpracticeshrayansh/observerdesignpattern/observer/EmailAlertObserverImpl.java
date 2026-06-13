package designpatternpracticeshrayansh.observerdesignpattern.observer;

import designpatternpracticeshrayansh.observerdesignpattern.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StocksObservable observable;
    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.observable = observable;
        this.emailId = emailId;
    }
        @Override
        public void update() {
            sendMail(emailId, "product is in stock hurry up!");
        }
        private void sendMail (String emailId, String msg){
            System.out.println("mail sent to:" + emailId);
//send the actual email to the end user
        }
}
