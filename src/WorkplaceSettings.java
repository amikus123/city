import java.util.List;

public record WorkplaceSettings(int daysNeededToAdvance, int initialFunds, int maxEmployeeCount, int monthlyCost,
                                PossibleWorkplacesNames name, List<Integer> salaryList) {
}
