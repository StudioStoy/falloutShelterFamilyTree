package nl.stoy.fsfamily.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Dweller {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private List<Long> parents;

    public Dweller(long id, String firstName, String lastName, long gender, List<Long> parents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        if (gender == 1) {
            this.gender = "female";
        } else if (gender == 2) {
            this.gender = "male";
        }

        if (parents.get(0) != -1 && parents.get(1) != -1) {
            this.parents = parents;
        }
    }

    @Override
    public String toString() {
        return "nl.stoy.fsfamily.domain.Dweller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", parents=" + parents +
                '}';
    }
}
