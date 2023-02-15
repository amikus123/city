import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorkerGenerator {
    private static Random rand = new Random();
    private List<String> names = new ArrayList<>(Arrays.asList("John","Robin","Anne","Josh","Emily","Patrick","Haley")) ;
    private int maxLength;

    private int maxCareerLevel;

    public WorkerGenerator( int maxLength, int maxCareerLevel) {
        this.maxLength = maxLength;
        this.maxCareerLevel = maxCareerLevel;
    }

    public List<Worker>  generateWorkers (){
        List<Worker> workers = new ArrayList();
        for(int i=0; i<maxLength;i++){
            workers.add(new Worker(names.get(rand.nextInt(names.size())), rand.nextInt(maxCareerLevel)));
        }
        return workers;
    }
    public Worker generateWorker(){
        return new Worker(names.get(rand.nextInt(names.size())), rand.nextInt(maxCareerLevel));
    }


}
