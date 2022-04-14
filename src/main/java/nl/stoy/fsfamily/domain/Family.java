package nl.stoy.fsfamily.domain;

import java.util.ArrayList;
import java.util.List;

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
        for (Dweller dweller : dwellers) {
            boolean isOrphan = false;
            if (dweller.getParentsId() == null) {
                isOrphan = true;
            }

            if (!isOrphan && dweller.getParentsId().contains(id)) {
                children.add(dweller);
            }
        }

        return children;
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
        return ""+dwellers;
    }
}
