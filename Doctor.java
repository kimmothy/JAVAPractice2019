public class Doctor {
    private boolean worksAtHospital;

    public boolean isWorksAtHospital() {
        return worksAtHospital;
    }

    public void setWorksAtHospital(boolean worksAtHospital) {
        this.worksAtHospital = worksAtHospital;
    }

    public void treatPatient(){
        System.out.println("Doctor treated a patient");
    }
}
