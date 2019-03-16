package OCP.chapter1.inner.anonymous.inner.classes;

public class AnnoInner {
    abstract class SaleTodayOnly {
        abstract int dollarOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarOff();
    }
}
