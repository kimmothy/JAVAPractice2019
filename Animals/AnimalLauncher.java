package Animals;

import java.util.ArrayList;

public class AnimalLauncher {
    public static void main(String[] arg){
        //Instantiate objects for each classes
        PetOwner PO = new PetOwner();
        Vet vet = new Vet();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Hippo hippo = new Hippo();
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Wolf wolf = new Wolf();
        //The petOwner takes every Animals as his/her pet
        PO.buyPet(cat);
        PO.buyPet(dog);
        PO.buyPet(hippo);
        PO.buyPet(lion);
        PO.buyPet(tiger);
        PO.buyPet(wolf);

        ArrayList<Animal> pets = PO.getPets();
        //Vet 클래스와 PetOwner 클래스의 메소드가 각 Animal Objects에 잘 적용되는 지 확인.
        for (Animal a:pets){
            vet.giveShot(a);
        }
        for (Animal a:pets){
            PO.feed(a);
        }
        for (Animal a:pets){
            PO.feed(a);
        }
        //사용되지 않은 Animal 클래스의 다른 메소드 작동 확인
        for (Animal a:pets){
            a.roam();
            a.sleep();
        }

        //Check if the inherited private instance variable can be accessed thorough get/set methods
        cat.setFood("fish");
        dog.setFood("bone");
        lion.setFood("zebra");
        hippo.setFood("plants");
        tiger.setFood("boar");
        wolf.setFood("fresh meat");
        for (Animal a:pets){
            System.out.println(a.getFood());
        }
        System.out.println(cat instanceof Cat);
        System.out.println(cat instanceof Pet);
        System.out.println(cat instanceof Animal);
    }
}
