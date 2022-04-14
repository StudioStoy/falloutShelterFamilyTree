package nl.stoy.fsfamily.domain;

import java.util.List;

public class Family {
    private List<Dweller> dwellers;

    public Family(List<Dweller> dwellers) {
        this.dwellers = dwellers;
    }

    public Dweller findById(Long id) {
        for (Dweller dweller : dwellers) {
            if (dweller.getId() == id) {
                return dweller;
            }
        }
        return null;
    }

    public void searchFamily() {
        for (Dweller dweller : dwellers) {
        }
    }
}
