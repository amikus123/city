import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class City {
    private final Map<PossibleWorkplacesNames, Workplace> workplaceMap = new HashMap<>();
    private final Set<PossibleWorkplacesNames> usedWorkplaces = new HashSet();

    private final DefaultSettings defaultSettings = new DefaultSettings();


    public City() throws Exception {
        addCity();
    }

    public void addCity() {
        if (usedWorkplaces.size() == PossibleWorkplacesNames.values().length) {
            System.out.println("Cant add more work places");
        } else {
            PossibleWorkplacesNames newWorkplaceName = PossibleWorkplacesNames.randomNotUsedWorkplace(usedWorkplaces);
            Workplace newWorkplace = new Workplace(defaultSettings.getWorkplaceSettingsMap().get(newWorkplaceName));
            workplaceMap.put(newWorkplaceName, newWorkplace);
        }
    }

    public void processDay() {
        for (Workplace workplace : workplaceMap.values()) {
            workplace.processDay();
        }
    }
}
