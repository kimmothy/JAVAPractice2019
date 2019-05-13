package serialize;

import java.io.Serializable;
import java.util.ArrayList;

public class Party implements Serializable {
    private ArrayList<Character> members = new ArrayList<>();

    public void addMember(Character c){
        members.add(c);
    }

    public ArrayList<Character> getMembers() {
        return members;
    }
}
