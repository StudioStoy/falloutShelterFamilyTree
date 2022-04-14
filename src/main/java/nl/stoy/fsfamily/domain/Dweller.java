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
    private List<Long> parentsId;
    private Dweller father;
    private Dweller mother;

    public Dweller(long id, String firstName, String lastName, long gender, List<Long> parentsId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        if (gender == 1) {
            this.gender = "female";
        } else if (gender == 2) {
            this.gender = "male";
        }

        if (parentsId.get(0) != -1 && parentsId.get(1) != -1) {
            this.parentsId = parentsId;
        }
    }

    @Override
    public String toString() {
        return "nl.stoy.fsfamily.domain.Dweller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", parentsId=" + parentsId +
                '}';
    }
}
