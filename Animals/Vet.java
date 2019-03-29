package Animals;

public class Vet {
    //애완동물에게 먹이를 주는 함수. Animal 객체의 hunger 변수에 따라 다르게 작용한다.
    public void feed(Animal pet){
        String petSpecies = pet.getClass().getSimpleName();
        System.out.println("You feed your "+petSpecies);
        if (pet.isHunger()){
            pet.eat();
            pet.beFull(false);
        }
        else{
            System.out.println("This "+petSpecies+ " seems full");
        }
    }
    //This method takes an animal object as a attribute. And call the method of animal object.
    public void giveShot(Animal a) {
        System.out.println("The vet gives a shot for your pet");
        a.makeNoise();
    }
    public void makeDogBark(Dog dog) {
        dog.bark();
    }
}
