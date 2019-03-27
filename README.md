***Repository items***

| PackageName | Date | Classes |
|:--------|:--------|:--------|
| Animals | 2019.03.18 | Animal,Vet,PetOwner |
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