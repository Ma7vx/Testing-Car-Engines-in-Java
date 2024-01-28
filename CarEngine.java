
public class CarEngine {
    private static int CC_FROM_HP = 15;
    private static int RADIANS_PER_SECOND = 5252;
    private float engineDisplacement;
    private float horsePower;
    private int numCylinders;
    private int stroke;
    private int boreSize;
    private int speed;
    private int torque;
    private String companyName;
    public CarEngine(){

        engineDisplacement = 0.0f;
        numCylinders = 0;
        stroke = 0;
        boreSize = 0;
        speed = 0;
        torque = 0;
        companyName = "Unknown";
        horsePower = 0.0f;

    }
    public CarEngine(String companyName, int torque, int speed, int boreSize, int stroke, int numCylinders) {

        if (companyName == null) {
            this.companyName = "Unknown";
        } else {
            this.companyName = companyName;
        }


        if (numCylinders < 0) {
            this.numCylinders = 0;
        } else if (numCylinders > 8) {
            this.numCylinders = 8;
        } else {
            this.numCylinders = numCylinders;
        }

        if (stroke < 0) {
            this.stroke = 0;
        } else if (stroke > 100) {
            this.stroke = 100;
        } else {
            this.stroke = stroke;
        }


        if (boreSize < 0) {
            this.boreSize = 0;
        } else if (boreSize > 100) {
            this.boreSize = 100;
        } else {
            this.boreSize = boreSize;
        }


        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }

        if (torque < 0) {
            this.torque = 0;
        } else {
            this.torque = torque;
        }

        engineDisplacement = calculateEngineDisplacement();
        horsePower = calculateHorsePowerFromTorque();
    }
    public void setCompanyName(String companyName) {
        if (companyName == null) {
            this.companyName = "Unknown";
        } else {
            this.companyName = companyName;
        }
    }
    public void setEngineDisplacement() {
        engineDisplacement = calculateEngineDisplacement();
    }
    public void setHorsePower(boolean fromDisplacement) {
        if (fromDisplacement) {
            horsePower = calculateHorsePowerFromEngineDisplacement();
        } else {
            horsePower = calculateHorsePowerFromTorque();
        }
    }
    public void setTorque(int torque) {
        if (torque < 0) {
            this.torque = 0;
        } else {
            this.torque = torque;
        }
        horsePower = calculateHorsePowerFromTorque();
    }
    public void setBoreSize(int boreSize) {
        if (boreSize < 0) {
            this.boreSize = 0;
        } else if (boreSize > 100) {
            this.boreSize = 100;
        } else {
            this.boreSize = boreSize;
        }
        engineDisplacement = calculateEngineDisplacement();
    }
    public void setStroke(int stroke) {
        if (stroke < 0) {
            this.stroke = 0;
        } else if (stroke > 100) {
            this.stroke = 100;
        } else {
            this.stroke = stroke;
        }
        engineDisplacement = calculateEngineDisplacement();
    }
    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
        horsePower = calculateHorsePowerFromTorque();
    }
    public void setNumCylinders(int numCylinders) {
        if (numCylinders < 0) {
            this.numCylinders = 0;
        } else if (numCylinders > 8) {
            this.numCylinders = 8;
        } else {
            this.numCylinders = numCylinders;
        }
        engineDisplacement = calculateEngineDisplacement();
    }
    public String getCompanyName() {
        return companyName;
    }
    public float getEngineDisplacement() {
        return engineDisplacement;
    }
    public int getTorque() {
        return torque;
    }
    public int getBoreSize() {
        return boreSize;
    }
    public int getStroke() {
        return stroke;
    }
    public int getSpeed() {
        return speed;
    }
    public int getNumCylinders() {
        return numCylinders;
    }
    public float getHorsePower() {
        return horsePower;
    }
    private float calculateHorsePowerFromTorque() {
        return (float) torque * speed / RADIANS_PER_SECOND;
    }
    private float calculateEngineDisplacement(){
        return (float) ((3.14 * Math.pow((boreSize / 2), 2) * stroke * numCylinders) / 1000);
    }
    private float calculateHorsePowerFromEngineDisplacement(){
        return (float) engineDisplacement / CC_FROM_HP;
    }
}