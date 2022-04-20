package nl.stoy.fsfamily.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Dweller {
    private long id;

    private String firstName;
    private String lastName;
    private String gender;

    private List<Long> parentIds;
    private List<Long> partnerIds;

    private Dweller father;
    private Dweller mother;

    public Dweller(long id, String firstName, String lastName, long gender, List<Long> parentIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        if (gender == 1) {
            this.gender = "female";
        } else if (gender == 2) {
            this.gender = "male";
        }

        if (parentIds.get(0) != -1 && parentIds.get(1) != -1) {
            this.parentIds = parentIds;
        }

        this.partnerIds = new ArrayList<>();
    }

    public void addPartner(long partnerId) {
        this.partnerIds.add(partnerId);
    }

    @Override
    public String toString() {
        String str = "";
        if (mother == null && father == null) {
            str = "id = " + id +
                    ", name = " + firstName + " " + lastName + ", gender = " + gender;
        } else {
            str = "id = " + id +
                    ", name = " + firstName + " " + lastName + ", gender = " + gender +
                    ", Father = " + father.getFirstName() + " " +father.getLastName()+
                    ", Mother = " + mother.getFirstName() + " " +mother.getLastName();
        }
        return str;
    }
}
