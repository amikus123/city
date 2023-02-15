public class Worker {
    private final String name;
    private int careerLevel;

    private int daysWorkedWithoutPromotion = 0;

    public Worker(String name, int careerLevel) {
        this.name = name;
        this.careerLevel = careerLevel;
    }

    public String getName() {
        return name;
    }

    public void calculateDay(int daysNeededToAdvance) {
        daysWorkedWithoutPromotion++;
        if (daysWorkedWithoutPromotion >= daysNeededToAdvance) {
            careerLevel++;
            daysWorkedWithoutPromotion = 0;
        }
    }

    public int getCareerLevel() {
        return careerLevel;
    }


}
