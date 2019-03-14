public class DoctorMain {
    public static void main(String[] arg){
        //Create Objects
        Doctor d = new Doctor();
        FamilyDoctor f = new FamilyDoctor();
        Surgeon s = new Surgeon();

        //Set instance variables
        d.setWorksAtHospital(true);
        f.setWorksAtHospital(false);
        s.setWorksAtHospital(true);

        //Print the 'worksAtHospital' variables
        System.out.println("Do they works at Hospital?");
        System.out.println("Doctor: " + d.isWorksAtHospital());
        System.out.println("Family Doctor: " + f.isWorksAtHospital());
        System.out.println("Surgeon: " + s.isWorksAtHospital());

        //Call the methods
        d.treatPatient();
        f.giveAdvice();
        f.makeHousCall();
        s.makeIncision();
        s.treatPatient();
    }
}
