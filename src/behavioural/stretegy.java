package behavioural;

//behavioural design patterns: it defines how object communicates with each other 
// -- Streategy pattern - seperated the stregeies of solving the problme and then call the stregey at run time as per the reqirement. eg 1.google map - bike, car, foor 2. payment - paypal, creadit card, debit card, upi.
//(Strategy lets you swap algorithms at runtime by putting each one behind a common interface, which removes if/else chains and makes adding new behavior easy without touching existing code)

interface PaymentStretegy{
    // Name it after the goal, not the implementation
    void pay(double amount);
}

class Paypal implements PaymentStretegy{
    String paypayId;
    //constructor
    Paypal(String paypalId){
        this.paypayId = paypalId;
    }

    public void pay(double amount){
        System.out.println("paying from paypal stretegy "+amount);
    }
}
class UPI implements PaymentStretegy{
    //constrcutor
    String upiID;
    UPI(String upiId){
        this.upiID = upiId;
    }

    public void pay(double amount){
        System.out.println("paying from upi stretegy "+amount);
    }
}

class ShoppingCart{
  private PaymentStretegy strategy;   // interface type, not UPI or Paypal
    ShoppingCart(PaymentStretegy strategy){
    this.strategy = strategy;
  }
  void checkout(double amount){
    strategy.pay(amount);  //doesn't know which one it is
  }

}
class StretegyDemo{
       public static void main(String[] args){
        double amount = 100;

        // UPI upi = new UPI("hfhg");
        // upi.pay(amount);

        // Paypal paypal = new Paypal("hgf");
        // paypal.pay(amount);
        ShoppingCart sc = new ShoppingCart(new UPI("sranyal6yt"));
        sc.checkout(amount);

        ShoppingCart sc1 = new ShoppingCart(new Paypal("sranyal6yt"));
        sc1.checkout(amount);
   }
}
