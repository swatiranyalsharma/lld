interface Notification{
    void send(String message);
}
class SMSNotification implements Notification{
    @Override()
    public void send(String message){
        System.out.println("Sending SMS Notification "+message);
    }
}
class EmailNotification implements Notification{
    @Override()
    public void send(String message){
          System.out.println("Sending Email Notification "+message);
    }
}
class NotificationFactory{
    public static Notification create(String type){
        if(type.equals("SMS")){
            return new SMSNotification();
        }else if(type.equals("Email")){
            return new EmailNotification();
        }else{
            throw new IllegalArgumentException("Invalid Type");
        }
    }
}
class FactoryDemo{
    public static void main(String[] args){
        String type = "Email";
        Notification noti = NotificationFactory.create(type);
        noti.send("By Swati");
    }
}