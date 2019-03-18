package Animals;

public class AnimalLauncher {
    public static void main(String[] arg){
        //Instantiate objects for each classes. The Animal objects are referenced in the array
        PetOwner PO = new PetOwner();
        Vet vet = new Vet();
        Animal[] pets = new Animal[6];
        pets[0] = new Cat();
        pets[1] = new Dog();
        pets[2] = new Hippo();
        pets[3] = new Lion();
        pets[4] = new Tiger();
        pets[5] = new Wolf();
        //Vet 클래스와 PetOwner 클래스의 메소드가 각 Animal Objects에 잘 적용되는 지 확인.
        for (Animal a:pets){
            vet.giveShot(a);
        }
        for (Animal a:pets){
            PO.feed(a);
        }
        //사용되지 않은 Animal 클래스의 다른 메소드 작동 확인
        for (Animal a:pets){
            a.roam();
            a.sleep();
        }

    }
}
