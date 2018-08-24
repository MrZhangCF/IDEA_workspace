package demo;

interface HouseSale{
    void sale();
}

class HouseOfJack implements HouseSale{

    @Override
    public void sale() {
        System.out.println("给我100万，房子归你");
    }
}

class SaleProxy implements HouseSale{

    private HouseOfJack jack = new HouseOfJack();

    @Override
    public void sale() {
        System.out.println("现有房源，欢迎选购！");
        jack.sale();
        System.out.println("恭喜这位爷！");
        System.out.println("成功卖出，收取佣金10%，美滋滋！");
    }
}

public class Market {
    public static void main(String[] args) {
        System.out.println("老子有钱，要买房");
        SaleProxy xiaoZhang = new SaleProxy();
        xiaoZhang.sale();
    }
}
