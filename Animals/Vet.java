package Animals;

public class Vet {
    //This method takes an animal object as a attribute. And call the method of animal object.
    public void giveShot(Animal a) {
        System.out.println("The vet gives a shot for your pet");
        a.makeNoise();
    }
    public void makeDogBark(Dog dog) {
        dog.bark();
    }
}
