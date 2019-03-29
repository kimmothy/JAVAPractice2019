package Robots;

import Animals.PetOwner;
import Animals.Pet;

import java.util.ArrayList;

public class RobotLauncher {
    static public void main(String arg[]){
        //로봇 객체들 생성
        Robot[] robots = new Robot[2];
        robots[0] = new Agent(110, 24601);
        robots[1] = new RobotDog(110, "Badooki");
        //로봇 메서드에서 정의된 기능들 서브클래스에서 작동하는 지 확인
        for (Robot r:robots){
            r.getVoltage();
            r.initiate();
        }
        //Robot Dog의 객체가 Pet 인터페이스의 기능을 수행하는 지 확인
        PetOwner PO = new PetOwner();
        PO.buyPet(robots[1]);
        ArrayList<Pet> pets = PO.getPets();
        for (Pet p: pets){
            p.play();
            p.beFriendly();
        }

    }
}
