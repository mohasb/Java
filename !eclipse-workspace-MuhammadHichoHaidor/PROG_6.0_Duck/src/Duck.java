
public class Duck
{
    private int pounds = 6;
    private float floatability = 2.1F;
    private String name = "generic";
    private long[] feathers = {1,2,3,4,5,6,7};
    private boolean canFly = true;
    private int maxSpeed = 25;
    
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (this.maxSpeed > 25) {
            System.out.println("maxSpeed has to be less than 25");
        }else {
        this.maxSpeed = maxSpeed;
        }
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public long[] getFeathers() {
        return feathers;
    }

    public void setFeathers(long[] feathers) {
        this.feathers = feathers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name == "") {
            System.out.println("You have to put a name");
        }else {
        this.name = name;
        }
    }

    public float getFloatability() {
        return floatability;
    }

    public void setFloatability(float floatability) {
        if (this.floatability <= 0 ) {
            System.out.println("The floatability has to be more than 0");
        }else {
        this.floatability = floatability;
        }
    }

    public int getPounds() {
        return pounds;
    }

    public void setPounds(int pounds) {
        if (this.pounds < 0) {
            System.out.println("The pounds has to be more than 0");
        }else {
        this.pounds = pounds;
        }
    }

    public Duck() {
        System.out.println("type 1 duck");
        this.pounds = 8;
        this.floatability = 2.8f;
        this.name = "Duck with no parameters";
        this.canFly = true;
        this.maxSpeed = 20;
    }
    
    public Duck (boolean fly) {
        fly = false;
        canFly = fly;
        System.out.println("type 2 duck");
        
    }
    
    public Duck(String n, long[] f) {
        if (n.equals("")) {
            System.out.println("You have to put a name");
        }else {
            n = "Duck 2 parameters";
            name = n ;
            feathers= f;
            System.out.println("type 3 duck");
        }
    }
    
    public Duck (int w, float f) {
        if (w < 0 || f <= 0) {
            System.out.println("The pounds has to be more than 0 and the floatablity has to be more than 0");
        }else {
            w = 55;
            f = 2.88f;
        pounds = w;
        floatability = f;
        System.out.println("type 4 duck");
        }
    }
    
    public Duck(float density, int max) {
        if (density <= 0 || max > 25) {
                System.out.println("The density has to be more than 0 and the max has to be less than 25");
        }else {
            density = 5.3f;
            max = 22;
        floatability = density;
        maxSpeed = max;
        System.out.println("type 5 duck");
        }
    }
}
