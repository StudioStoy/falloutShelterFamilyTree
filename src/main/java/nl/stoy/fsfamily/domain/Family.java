package nl.stoy.fsfamily.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Family {
    private List<Dweller> dwellers;

    public Family(List<Dweller> dwellers) {
        this.dwellers = dwellers;

        this.createFamilyTies();
    }

    public Dweller findById(long id) {
        for (Dweller dweller : dwellers) {
            if (dweller.getId() == id) {
                return dweller;
            }
        }
        return null;
    }

    public List<Dweller> findChildrenByParentId(long id) {
        List<Dweller> children = new ArrayList<>();
        for (Dweller dweller : this.dwellers) {
            boolean isOrphan = dweller.getParentsId() == null;

            if (!isOrphan && dweller.getParentsId().contains(id)) {
                children.add(dweller);
            }
        }

        return children;
    }

    public List<Dweller> findDwellersByName(String name) {
        List<Dweller> foundDwellers = new ArrayList<>();
        for (Dweller dweller : this.dwellers) {
            String dwellerName = dweller.getFirstName().toLowerCase(Locale.ROOT) + " " + dweller.getLastName().toLowerCase(Locale.ROOT);
            if (dwellerName.contains(name)) {
                foundDwellers.add(dweller);
            }
        }

        return foundDwellers;
    }

    private void findParents(long id) {
        Dweller dweller = findById(id);
        if (dweller.getParentsId() != null) {
            dweller.setFather(findById(dweller.getParentsId().get(0)));
            dweller.setMother(findById(dweller.getParentsId().get(1)));
        }
    }

    private void createFamilyTies() {
        for (Dweller dweller : dwellers) {
            findParents(dweller.getId());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        dwellers.forEach(dweller -> stringBuilder.append(dweller).append("\n"));

        return stringBuilder.toString();
    }
}
