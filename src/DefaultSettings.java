import java.util.*;

public class DefaultSettings {

    private final Map<PossibleWorkplacesNames, List<Integer>> defaultSalaries = generateDefaultSalaries();
    private final Map<PossibleWorkplacesNames, WorkplaceSettings> workplaceSettingsMap = generateWorkplaceSettings();

    public DefaultSettings() throws Exception {
    }

    public Map<PossibleWorkplacesNames, WorkplaceSettings> getWorkplaceSettingsMap() {
        return workplaceSettingsMap;
    }

    private Map<PossibleWorkplacesNames, List<Integer>> generateDefaultSalaries() throws Exception {
        Map<PossibleWorkplacesNames, List<Integer>> defaultSalaries = new HashMap();
        for (PossibleWorkplacesNames name : PossibleWorkplacesNames.values()) {
            switch (name) {
                case BANK:
                    defaultSalaries.put(name, new ArrayList<>(Arrays.asList(100, 200, 300, 400, 500, 600)));
                    break;
                case SCHOOL:
                    defaultSalaries.put(name, new ArrayList<>(Arrays.asList(100, 110, 120, 130, 150, 160)));
                    break;
                case BAKERY:
                    defaultSalaries.put(name, new ArrayList<>(Arrays.asList(10, 140, 265, 300)));
                    break;
                case SHOP:
                    defaultSalaries.put(name, new ArrayList<>(Arrays.asList(100, 150, 300, 310)));
                    break;
                default:
                    throw new Exception("No default salary for some value");
            }
        }

        return defaultSalaries;
    }

    private Map<PossibleWorkplacesNames, WorkplaceSettings> generateWorkplaceSettings() throws Exception {
        Map<PossibleWorkplacesNames, WorkplaceSettings> settingsMap = new HashMap();
        for (PossibleWorkplacesNames name : PossibleWorkplacesNames.values()) {
            switch (name) {
                case BANK:
                    settingsMap.put(name, new WorkplaceSettings(5, 2000, 10, 400, name, defaultSalaries.get(name)));
                    break;
                case SCHOOL:
                    settingsMap.put(name, new WorkplaceSettings(15, 1000, 8, 200, name, defaultSalaries.get(name)));
                    break;
                case BAKERY:
                    settingsMap.put(name, new WorkplaceSettings(12, 500, 5, 100, name, defaultSalaries.get(name)));
                    break;
                case SHOP:
                    settingsMap.put(name, new WorkplaceSettings(7, 1200, 12, 600, name, defaultSalaries.get(name)));
                    break;
                default:
                    throw new Exception("No default salary for some value");
            }
        }
        return settingsMap;
    }


}
