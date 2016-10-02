package practicefusioncodingchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.lang.reflect.Field;
import java.util.*;
import practicefusioncodingchallenge.SimilarDoctors.feature;

/**
 * PracticeFusionCodingChallenge is a demo class for the {@link SimilarDoctors}
 * class.
 *
 * @author Priyanka Rao
 */
public class PracticeFusionCodingChallenge {

    public static void main(String[] args) {
        // Create the list of all doctors first.  We will perform our search
        // on this list.
        List<Doctor> allDoctors = makeAllDoctorsList();

        SimilarDoctors finder = new SimilarDoctors(allDoctors);

        // Next, define a doctor.  We will find a doctor similar to this
        // doctor.
        Doctor myDoctor = new Doctor();
        myDoctor.setName("Perry");
        myDoctor.setEducation("Johns-Hopkins");
        myDoctor.setExperience(7);
        myDoctor.setSpeciality("Pediatrics");
        myDoctor.setLocation("San Jose");
        myDoctor.acceptingPatient = true;
        List<String> hcPlans = new ArrayList<String>();
        hcPlans.add("CIGNA");
        hcPlans.add("HealthNet");
        hcPlans.add("Anthem Blue Cross of California");
        hcPlans.add("BlueShield of California");
        myDoctor.setHealthcarePlans(hcPlans);

        // Next, we find doctors in allDoctors that are similar to myDoctor
        // based on a few features.
        List<Doctor> result = finder.findSimilarDoctors(
                myDoctor, feature.LOCATION, feature.SPECIALITY,
                feature.ACCEPTINGNEWPATIENT);

        // Finally, let's prioritize the result list, and display it.
        if (result != null && (!result.isEmpty())) {
            // Pick an attribute to order by.  Choose from "name",
            // "experience", "location", and "speciality".
            String sortBy = "name";
            finder.prioritize(result, feature.NAME);
            for (Doctor d : result) {
                d.printDetails();
            }
        } else {
            System.out.println("No similar doctors found!");
        }
    }

    /**
     * Makes a list of various doctors, in which we will search.
     *
     * This will be our so-called "database" of doctors in which to search.
     *
     * @return a list of {@link Doctor} objects
     */
    private static List<Doctor> makeAllDoctorsList() {
        List<Doctor> allDoctors = new ArrayList<Doctor>();
        List<String> hcPlans;

        Doctor doctor1 = new Doctor();
        doctor1.setName("Albert");
        doctor1.setEducation("Standford University");
        doctor1.setExperience(10);
        doctor1.acceptingPatient = false;
        doctor1.setSpeciality("Dermatology");
        doctor1.setLocation("San Franciso");
        hcPlans = new ArrayList<String>();
        hcPlans.add("Aethna");
        hcPlans.add("Anthem Blue Cross of California");
        hcPlans.add("BlueShield of California");
        doctor1.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setName("Jennifer");
        doctor2.setEducation("Standford University");
        doctor2.setExperience(12);
        doctor2.acceptingPatient = false;
        doctor2.setSpeciality("Dermatology");
        doctor2.setLocation("Santa Clara");
        hcPlans = new ArrayList<String>();
        hcPlans.add("Aethna");
        hcPlans.add("Anthem Blue Cross of California");
        hcPlans.add("BlueShield of California");
        doctor2.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor2);

        Doctor doctor3 = new Doctor();
        doctor3.setName("Ann");
        doctor3.setEducation("Berkely University");
        doctor3.setExperience(10);
        doctor3.setSpeciality("Family Medicine");
        doctor3.setLocation("San Jose");
        doctor1.acceptingPatient = false;
        hcPlans = new ArrayList<String>();
        hcPlans.add("Anthem Blue Cross of California");
        hcPlans.add("BlueShield of California");
        doctor3.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor3);

        Doctor doctor4 = new Doctor();
        doctor4.setName("Susan");
        doctor4.setEducation("School of Medicine, University of California,Irvine");
        doctor4.setExperience(5);
        doctor4.setSpeciality("Pediatrics");
        doctor4.setLocation("San Jose");
        doctor4.acceptingPatient = true;
        hcPlans = new ArrayList<String>();
        hcPlans.add("CIGNA");
        hcPlans.add("HealthNet");
        hcPlans.add("Anthem Blue Cross of California");
        hcPlans.add("BlueShield of California");
        doctor4.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor4);

        Doctor doctor5 = new Doctor();
        doctor5.setName("James");
        doctor5.setEducation("Standford University");
        doctor5.setExperience(5);
        doctor5.setSpeciality("Pediatrics");
        doctor5.setLocation("San Jose");
        doctor5.acceptingPatient = true;
        hcPlans = new ArrayList<String>();
        hcPlans.add("CIGNA");
        hcPlans.add("HealthNet");
        hcPlans.add("Anthem Blue Cross of California");
        hcPlans.add("BlueShield of California");
        doctor5.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor5);

        Doctor doctor6 = new Doctor();
        doctor6.setName("Asma");
        doctor6.setEducation("San Jose University");
        doctor6.setExperience(2);
        doctor6.setSpeciality("Internal Medicine");
        doctor6.setLocation("San Jose");
        doctor6.acceptingPatient = true;
        hcPlans = new ArrayList<String>();
        hcPlans.add("CIGNA");
        hcPlans.add("HealthNet");
        doctor6.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor6);

        Doctor doctor7 = new Doctor();
        doctor7.setName("Peter");
        doctor7.setEducation("Santa Clara University");
        doctor7.setExperience(7);
        doctor7.setSpeciality("Internal Medicine");
        doctor7.setLocation("Alabama");
        doctor7.acceptingPatient = true;
        hcPlans = new ArrayList<String>();
        hcPlans.add("CIGNA");
        hcPlans.add("HealthNet");
        doctor7.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor7);

        return allDoctors;
    }
}
