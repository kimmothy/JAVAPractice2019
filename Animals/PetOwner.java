package Animals;

import java.util.ArrayList;

public class PetOwner {
    //이 변수는 PetOwner 객체가 소유한 동물을 의미하며, Animal 타입의 객체를 참조한다.
    private ArrayList<Pet> pets = new ArrayList<Pet>();

    public void buyPet(Object pet){
        String petSpecies = pet.getClass().getSimpleName();
        if (pet instanceof Pet){
            this.pets.add((Pet)pet);
            System.out.println("You bought a cute "+petSpecies);
        }
        else{
            System.out.println("This "+petSpecies+" is not a pet");
        }
    }

    public ArrayList<Pet> getPets(){
        return this.pets;
    }
}
