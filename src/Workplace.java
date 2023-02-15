import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Workplace {

    private final int daysNeededToAdvance;
    private final int initialFunds;
    private final int maxEmployeeCount;
    private final WorkerGenerator workerGenerator;
    private PossibleWorkplacesNames name;
    private List<Worker> employees;
    private List<Integer> salaryList;
    private int currentFunds;
    private int monthlyCost;


    public Workplace(WorkplaceSettings workplaceSettings) {
        this.daysNeededToAdvance = workplaceSettings.daysNeededToAdvance();
        this.initialFunds = workplaceSettings.initialFunds();
        this.maxEmployeeCount = workplaceSettings.maxEmployeeCount();
        this.name = workplaceSettings.name();
        this.salaryList = workplaceSettings.salaryList();
        this.monthlyCost = workplaceSettings.monthlyCost();
        this.workerGenerator = new WorkerGenerator(maxEmployeeCount, salaryList.size());
        this.employees = workerGenerator.generateWorkers();
    }

    public void processDay() {
        AtomicInteger sum = new AtomicInteger();
        employees.forEach(employee -> {
            if (employee.getCareerLevel() <= salaryList.size()) {
                sum.set(sum.get() + salaryList.get(employee.getCareerLevel()));
                employee.calculateDay(daysNeededToAdvance);
            } else {
                System.out.println("INVALID CAREER LEVEL AT " + getName());
                System.out.println("HE/SHE IS FIRED");
                employees.remove(employee);
                employees.add(workerGenerator.generateWorker());
            }


        });
        double totalChange = sum.get() - monthlyCost;
        currentFunds += totalChange;
        System.out.printf("%s's Monthly revenue after losses: %f%n", name, totalChange);
        if (currentFunds < 0) {
            declareBankruptcy();
        }
    }

    private void declareBankruptcy() {
        System.out.println("I DECLARE");
        System.out.println("BANKRUPTCYYYYYYYYY");
        // reset to base state
        employees.clear();
        employees.addAll(workerGenerator.generateWorkers());
        currentFunds = initialFunds;
    }


    public PossibleWorkplacesNames getName() {
        return name;
    }

    public void setName(PossibleWorkplacesNames name) {
        this.name = name;
    }

    public List<Worker> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Worker> employees) {
        this.employees = employees;
    }

    public List<Integer> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Integer> salaryList) {
        this.salaryList = salaryList;
    }

    public int getCurrentFunds() {
        return currentFunds;
    }

    public void setCurrentFunds(int currentFunds) {
        this.currentFunds = currentFunds;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
}
