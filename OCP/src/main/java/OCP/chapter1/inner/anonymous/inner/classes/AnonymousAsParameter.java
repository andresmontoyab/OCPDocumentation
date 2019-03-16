package OCP.chapter1.inner.anonymous.inner.classes;

public class AnonymousAsParameter {
    interface SaleTodayOnly {
        int dollarOff();
    }

    public int pay() {
        return admission(5, new SaleTodayOnly() {
            public int dollarOff() {
                return 3;
            }
        });
    }
    public int admission(int basePrice, SaleTodayOnly saleTodayOnly) {
        return basePrice - saleTodayOnly.dollarOff();
    }
}
