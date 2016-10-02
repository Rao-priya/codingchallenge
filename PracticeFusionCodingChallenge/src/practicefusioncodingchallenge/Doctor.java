package practicefusioncodingchallenge;

import java.util.ArrayList;
import java.util.List;
import java.lang.Comparable;
import java.util.Comparator;

/**
 * Represents a doctor.
 *
 * @author Priyanka Rao
 */
public class Doctor {
    /**
     * The doctor's speciality - Internal Medicine, Pediatrics, etc.
     */
    String speciality;
    
    /**
     * The doctor's name.
     */
    String name;
    
    /**
     * The doctor's years of practice.
     */
    double experience;
    
    /**
     * The alma mater of the doctor.
     */
    String education;
    
    /**
     * The doctor's practice location (for example, city name).
     */
    String location;
    
    /**
     * A boolean that is true if the doctor is accepting new patients, false
     * otherwise.
     */
    boolean acceptingPatient;
    
    /**
     * A list of health care plan names that the doctor accepts.
     */
    List<String> healthcarePlans = new ArrayList<String>();

    /**
     * Gets the speciality of doctor.
     *
     * @return speciality of a given doctor
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Sets doctor's speciality with given speciality.
     *
     * @param speciality speciality of the doctor
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * Gets doctor's name.
     *
     * @return doctor's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets doctor's name with given name.
     *
     * @param name name of doctor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets doctor's years of experience.
     *
     * @return doctor's experience
     */
    public double getExperience() {
        return experience;
    }

    /**
     * Sets doctor's year of experience with given experience.
     *
     * @param experience doctor's years of experience
     */
    public void setExperience(double experience) {
        this.experience = experience;
    }

    /**
     * Gets doctor's education.
     *
     * @return doctor's education
     */
    public String getEducation() {
        return education;
    }

    /**
     * Sets doctor's education.
     *
     * @param education doctor's education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Gets doctor's location of practice.
     *
     * @return doctor's location of practice
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets doctor's location of practice with given location.
     *
     * @param location doctor's location of practice
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets doctor's accepted health care plans.
     *
     * @return list of health care plan accepted by a doctor
     */
    public List<String> getHealthcarePlans() {
        return this.healthcarePlans;
    }

    /**
     * Sets doctor's health care plan attribute with a given list of health care
     * plan.
     *
     * @param hcPlans list of health care plans accepted by this doctor
     */
    public void setHealthcarePlans(List<String> hcPlans) {
        this.healthcarePlans = hcPlans;
    }

    /**
     * Gets boolean value indicating whether doctor is accepting new patients.
     *
     * @return true if doctor is accepting new patients, false otherwise
     */
    public boolean getAcceptingPatient() {
        return acceptingPatient;
    }

    /**
     * Sets doctor's accepting patient attribute with given value.
     *
     * @param accept sets doctor's acceptingPatient attribute to accept
     */
    public void setAcceptingPatient(boolean accept) {
        this.acceptingPatient = accept;
    }

    public Doctor() {
    }

    /**
     * Compare two {@literal Doctor} objects by name.
     */
    public static Comparator<Doctor> NameComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor doctor1, Doctor doctor2) {
            String doctor1Name = doctor1.getName();
            String doctor2Name = doctor2.getName();
            return doctor1Name.compareTo(doctor2Name);
        }
    };

    /**
     * Compare two {@literal Doctor} objects by years of experience.
     */
    public static Comparator<Doctor> ExperienceComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor doctor1, Doctor doctor2) {
            double doctor1Exp = doctor1.getExperience();
            double doctor2Exp = doctor2.getExperience();
            if (doctor1Exp > doctor2Exp) {
                return 1;
            } else if (doctor1Exp == doctor2Exp) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    /**
     * Compare two {@literal Doctor} objects by location of practice.
     */
    public static Comparator<Doctor> LocationComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor doctor1, Doctor doctor2) {
            String doctor1Location = doctor1.getLocation();
            String doctor2Location = doctor2.getLocation();
            return doctor1Location.compareToIgnoreCase(doctor2Location);
        }
    };

    /**
     * Compare two {@literal Doctor} objects by speciality.
     */
    public static Comparator<Doctor> SpecialityComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor doctor1, Doctor doctor2) {
            String doctor1Speciality = doctor1.getSpeciality();
            String doctor2Speciality = doctor2.getSpeciality();
            return doctor1Speciality.compareToIgnoreCase(doctor2Speciality);
        }
    };

    /**
     * Pretty-prints an instance of {@link Doctor} class
     */
    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Speciality: " + getSpeciality());
        System.out.println("Location: " + getLocation());
        System.out.println("Experience: " + getExperience());
        System.out.println("Accepting new patients: " + getAcceptingPatient());
        System.out.println("Accepted healthcare plans: ");
        for (int i = 0; i < healthcarePlans.size(); i++) {
            System.out.print(healthcarePlans.get(i) + " | ");
        }
        System.out.println();
        System.out.println("--------------------------------------");
    }

    /**
     * Compares two {@link Doctor} instances for equality.
     *
     * @param obj instance of Doctor class
     * @return true if current {@literal Doctor} object and given object are
     * equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Doctor other = (Doctor) obj;

        if ((this.getName() == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (!(this.getSpeciality().equals(other.getSpeciality()))) {
            return false;
        }
        if (!(this.getLocation().equals(other.getLocation()))) {
            return false;
        }
        if (!(this.healthcarePlans.equals(other.healthcarePlans))) {
            return false;
        }
        if (!(this.getEducation().equals(other.getEducation()))) {
            return false;
        }
        if (this.getExperience() != other.getExperience()) {
            return false;
        }
        return true;
    }
}
