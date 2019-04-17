package Animals;

import Robots.Robot;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class AnimalPetLauncher {
    public static void main(String[] arg){
        //Instantiate objects for each classes. The Animal instances are stored in the array
        Animal[] animals = new Animal[6];
        PetOwner PO = new PetOwner();
        Vet vet = new Vet();
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Hippo();
        animals[3] = new Lion();
        animals[4] = new Tiger();
        animals[5] = new Wolf();

        //The petOwner tries to take every Animals as his/her pet
        for (Animal a:animals){
            PO.buyPet(a);
        }
        //PO가 가진 펫 목록을 불러와 확인해본다. Pet 인터페이스를 구현한 클래스 객체만 담겨있는 것을 알 수 있다. buyPet 메서드가
        //Animal 객체가 Pet 인터페이스를 구현했는지 확인하기 때문이다.
        ArrayList<Pet> pets = PO.getPets();
        for (Pet p:pets){
            System.out.println(p);
        }

        //Vet 클래스와 PetOwner 클래스의 메소드가 각 Animal Objects에 잘 적용되는 지 확인.
        for (Animal a:animals){
            vet.giveShot(a);
        }
        for (Animal a:animals){
            vet.feed(a);
        }
        //사용되지 않은 Animal 클래스의 다른 메소드 작동 확인
        for (Animal a:animals){
            a.roam();
            a.sleep();
        }

        //Check if the inherited private instance variable can be accessed thorough get/set methods
        animals[0].setFood("fish");
        animals[1].setFood("bone");
        animals[2].setFood("zebra");
        animals[3].setFood("plants");
        animals[4].setFood("boar");
        animals[5].setFood("fresh meat");
        for (Animal a:animals){
            System.out.println(a.getFood());
        }
        //객체의 타입을 확인하는 명령어와, 캐스팅 실험. Pet 인터페이스를 구현한 Animal 객체의 Pet 기능 실험.
        for (Animal a:animals){
            if(a instanceof Pet){
                ((Pet) a).play();
                ((Pet) a).beFriendly();
            }
        }



    }
}
