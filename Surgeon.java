public class Surgeon extends Doctor{
    @Override
    public void treatPatient() {
        System.out.println("Surgeon treats a patient");
    }
    public void makeIncision(){
        System.out.println("Surgeon makes a incision");
    }
}
