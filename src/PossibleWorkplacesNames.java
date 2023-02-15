import java.util.*;

public enum PossibleWorkplacesNames {
    BANK, BAKERY, SCHOOL, SHOP;
    private static final Random random = new Random();

    public static PossibleWorkplacesNames randomWorkplace() {
        return PossibleWorkplacesNames.values()[random.nextInt(PossibleWorkplacesNames.values().length)];
    }

    public static PossibleWorkplacesNames randomNotUsedWorkplace(Set<PossibleWorkplacesNames> usedWorkplaces) {
        List<PossibleWorkplacesNames> workplacesNotInSet =
                new ArrayList(Arrays.asList(PossibleWorkplacesNames.values()));
        for (PossibleWorkplacesNames setValue : usedWorkplaces) {
            workplacesNotInSet.remove(setValue);
        }
        return workplacesNotInSet.get(random.nextInt(workplacesNotInSet.size()));
    }
}
