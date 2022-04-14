import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Dweller {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private List<Integer> parents;

    public Dweller(long id, String firstName, String lastName, int gender, List<Integer> parents) {
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
}
