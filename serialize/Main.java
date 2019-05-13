package serialize;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static Party load(){
        try{
            Path p = Paths.get("c:/JavaTest", "CharacterData.ser");
            if (!Files.exists(p)){
                return new Party();
            }
            ObjectInputStream load = new ObjectInputStream(Files.newInputStream(p));
            Party party = (Party) load.readObject();
            return party;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] arg){
        Party party = load();
        Character c1 = new Character("Marx", 27);
        Character c2 = new Character("Lenin", 28);
        Character c3 = new Character("Guevara", 29);
        party.addMember(c1);
        party.addMember(c2);
        party.addMember(c3);
        for (Character c: party.getMembers()){
            System.out.println(c.getName() + c.getAge() + "살");
        }
        try {
            Path p = Paths.get("c:/JavaTest", "CharacterData.ser");
            if (!Files.exists(p)) {
                Files.createFile(p);}
            OutputStream OS = Files.newOutputStream(p);
            ObjectOutputStream OO = new ObjectOutputStream(OS);
            OO.writeObject(party);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("adf");
        }

    }
}
