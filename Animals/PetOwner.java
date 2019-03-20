package Animals;

import java.util.ArrayList;

public class PetOwner {
    //이 변수는 PetOwner 객체가 소유한 동물을 의미하며, Animal 타입의 객체를 참조한다.
    private ArrayList<Animal> pets = new ArrayList<Animal>();
    //애완동물에게 먹이를 주는 함수. 의 hunger 변수에 따라 다르게 작용한다.
    public void feed(Animal pet){
        String petSpecies = pet.getClass().getSimpleName();
        System.out.println("You feed your "+petSpecies);
        if (pet.isHunger()){
            pet.eat();
            pet.beFull(false);
        }
        else{
            System.out.println("Your pet seems full");
        }
    }

    public void buyPet(Animal pet){
        String petSpecies = pet.getClass().getSimpleName();
        System.out.println("You bought a "+petSpecies);
        this.pets.add(pet);
    }

    public ArrayList<Animal> getPets(){
        return this.pets;
    }
}
