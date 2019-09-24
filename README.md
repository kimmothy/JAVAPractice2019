2019년 1학기 자바 프로그래밍 실습 과제 제출용 레퍼지터리
***Repository items***

| PackageName | Date | Classes |
|:--------|:--------|:--------|
| Animals | 2019.03.18 | Animal,Vet,PetOwner,Pet |
| Robots | 2019.03.28 | Robot, RobotDog |
| ... | ... | ... |

There are three important classes in the package Animals
Animal: It's a superclass for every other classes that represents some kind of animal. And it is an abstract class.
        It has four methods sleep, eat, roam and makeNoise which are the common things animals do.
        And it has a instance variable hunger. The type of this variable is boolean.
        This variable is needed when the method eat is called.

Vet: This class is made for configure how polymorphism works. It has only one method giveShot.
     This method get an Animal type object as a parameter. And it calls the method makeNoise of that object.

PetOwner: This class represent someone who owns Animals. It may have only one pet or many of them.
          It contains it's pets in an arraylist which gets Animal type objects in it.
          It has two methods buyPet and feed. The first methods add an animal object to it's arraylist.
          And the second methods call the method eat of the Animal object
     
Pet : It's an interfaces that the animal classes that could be a pet should implement. 

The important classes of Package Robots
Robot: It's a superclass of RobotDog and Agent. It defines the methods that Robots should have
RobotDog: This is a subclass of Robot. And it also implements the interfacre Pet in the Animals Package. It has the methods from Robot class with the method from Pet interface.
