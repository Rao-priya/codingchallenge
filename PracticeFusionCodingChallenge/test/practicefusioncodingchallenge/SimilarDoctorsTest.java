package practicefusioncodingchallenge;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Priyanka Rao
 */
public class SimilarDoctorsTest {

    Doctor keyDoctor;
    List<Doctor> results;
    List<Doctor> allDocs;

    public SimilarDoctorsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.results = null;

        this.allDocs = makeAllDoctorsList();

        this.keyDoctor = new Doctor();
        this.keyDoctor.setName("Susan");
        this.keyDoctor.setEducation("School of Medicine, University of California,Irvine");
        this.keyDoctor.setExperience(5);
        this.keyDoctor.setSpeciality("Pediatrics");
        this.keyDoctor.setLocation("San Jose");
        this.keyDoctor.setAcceptingPatient(true);
        List<String> healthcarePlans = new ArrayList<String>();
        healthcarePlans.add("CIGNA");
        healthcarePlans.add("HealthNet");
        healthcarePlans.add("Anthem Blue Cross of California");
        healthcarePlans.add("BlueShield of California");
        this.keyDoctor.setHealthcarePlans(healthcarePlans);
    }

    /**
     * Tests whether two doctors are similar when null values are passed.
     *
     * @precondition instantiate {@link SimilarDoctors} class
     * @postcondition result a list of similar {@link Doctor}
     * @passcriteria result is null
     *
     */
    @Test
    public void testFindSimilarDoctorforNULL() {
        SimilarDoctors f = new SimilarDoctors(this.allDocs);
        this.results = f.findSimilarDoctors(null, SimilarDoctors.feature.LOCATION);
        assertNull(this.results);
    }

    /**
     * Tests whether two doctors are similar when features list is null.
     *
     * @precondition instantiate {@link SimilarDoctors} class instantiate
     * {@link Doctor} class
     * @postcondition result a list of similar {@link Doctor}
     * @passcriteria result is null
     *
     */
    /*@Test
    public void testFindSimilarDoctorFeautureNULL() {
        SimilarDoctors similarDoctors = new SimilarDoctors(this.allDocs);
        Doctor doctor = new Doctor();
        List<Doctor> result = similarDoctors.findSimilarDoctors(doctor, null);
        assertNull(result);
    }*/

    /**
     * Tests whether two doctors are similar when {@link Doctor} instance and
     * {@code features} are provided.
     *
     * @precondition instantiate {@link SimilarDoctors} class
     * @postcondition result a list of similar {@link Doctor}
     * @passcriteria expected result is same as result
     *
     */
    @Test
    public void testFindSimilarDoctor() {
        List<String> healthcare;

        List<Doctor> expResult = new ArrayList<Doctor>();

        Doctor doctor5 = new Doctor();
        doctor5.setName("James");
        doctor5.setEducation("Standford University");
        doctor5.setExperience(5);
        doctor5.setSpeciality("Pediatrics");
        doctor5.setLocation("San Jose");
        doctor5.acceptingPatient = true;
        healthcare = new ArrayList<String>();
        healthcare.add("CIGNA");
        healthcare.add("HealthNet");
        healthcare.add("Anthem Blue Cross of California");
        healthcare.add("BlueShield of California");
        doctor5.setHealthcarePlans(healthcare);
        expResult.add(doctor5);

        Doctor doctor4 = new Doctor();
        doctor4.setName("Susan");
        doctor4.setEducation("School of Medicine, University of California,Irvine");
        doctor4.setExperience(5);
        doctor4.setSpeciality("Pediatrics");
        doctor4.setLocation("San Jose");
        doctor4.acceptingPatient = true;
        healthcare = new ArrayList<String>();
        healthcare.add("CIGNA");
        healthcare.add("HealthNet");
        healthcare.add("Anthem Blue Cross of California");
        healthcare.add("BlueShield of California");
        doctor4.setHealthcarePlans(healthcare);
        expResult.add(doctor4);

        SimilarDoctors s = new SimilarDoctors(this.allDocs);
        s.priortize(expResult);
        this.results = s.findSimilarDoctors(
                this.keyDoctor, SimilarDoctors.feature.LOCATION,
                SimilarDoctors.feature.SPECIALITY,
                SimilarDoctors.feature.ACCEPTINGNEWPATIENT);
        s.priortize(this.results);
        assertArrayEquals(expResult.toArray(), this.results.toArray());
    }

    /**
     * Tests the function that checks whether the insurance plans of one
     * {@link Doctor} instance is a superset of the other {@link Doctor}
     * instance.
     *
     * @precondition create two {@link Doctor} objects
     * @passcriteria true if one {@code Doctor} object's health insurance
     * plans do not form a superset of the other's plans
     */
    @Test
    public void testIsHealthPlansSupersetTrue() {
        List<String> healthcare = new ArrayList<String>();
        Doctor doctor5 = new Doctor();
        doctor5.setName("James");
        doctor5.setEducation("Standford University");
        doctor5.setExperience(5);
        doctor5.setSpeciality("Pediatrics");
        doctor5.setLocation("San Jose");
        doctor5.acceptingPatient = true;
        healthcare = new ArrayList<String>();
        healthcare.add("CIGNA");
        healthcare.add("HealthNet");
        healthcare.add("Anthem Blue Cross of California");
        healthcare.add("BlueShield of California");
        doctor5.setHealthcarePlans(healthcare);

        Doctor doctor4 = new Doctor();
        doctor4.setName("Susan");
        doctor4.setEducation("School of Medicine, University of California,Irvine");
        doctor4.setExperience(5);
        doctor4.setSpeciality("Pediatrics");
        doctor4.setLocation("San Jose");
        doctor4.acceptingPatient = true;
        healthcare = new ArrayList<String>();
        healthcare.add("CIGNA");
        healthcare.add("HealthNet");
        doctor4.setHealthcarePlans(healthcare);

        SimilarDoctors s = new SimilarDoctors(this.allDocs);
        assertTrue(s.isHealthPlansSuperset(doctor5, doctor4));
    }

    /**
     * Tests the function that checks whether the insurance plans of one
     * {@link Doctor} instance is not a superset of the other {@link Doctor}
     * instance.
     *
     * @precondition create two {@link Doctor} objects
     * @passcriteria true if one {@code Doctor} object's health insurance
     * plans do not not form a superset of the other's plans
     */
    @Test
    public void testIsHealthPlansSupersetFalse() {
        List<String> healthcare = new ArrayList<String>();
        Doctor doctor5 = new Doctor();
        doctor5.setName("James");
        doctor5.setEducation("Standford University");
        doctor5.setExperience(5);
        doctor5.setSpeciality("Pediatrics");
        doctor5.setLocation("San Jose");
        doctor5.acceptingPatient = true;
        healthcare = new ArrayList<String>();
        healthcare.add("CIGNA");
        healthcare.add("HealthNet");
        healthcare.add("Anthem Blue Cross of California");
        healthcare.add("BlueShield of California");
        doctor5.setHealthcarePlans(healthcare);

        Doctor doctor4 = new Doctor();
        doctor4.setName("Susan");
        doctor4.setEducation("School of Medicine, University of California,Irvine");
        doctor4.setExperience(5);
        doctor4.setSpeciality("Pediatrics");
        doctor4.setLocation("San Jose");
        doctor4.acceptingPatient = true;
        healthcare = new ArrayList<String>();
        healthcare.add("CIGNA");
        healthcare.add("HealthNet");
        doctor4.setHealthcarePlans(healthcare);

        SimilarDoctors s = new SimilarDoctors(this.allDocs);
        assertTrue(!s.isHealthPlansSuperset(doctor4, doctor5));
    }

    @After
    public void tearDown() {
    }

    /**
     * Makes a list of various doctors, in which we will search.
     */
    private List<Doctor> makeAllDoctorsList() {
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
        doctor7.setLocation("Santa Clara");
        doctor7.acceptingPatient = true;
        hcPlans = new ArrayList<String>();
        hcPlans.add("CIGNA");
        hcPlans.add("HealthNet");
        doctor7.setHealthcarePlans(hcPlans);
        allDoctors.add(doctor7);

        return allDoctors;
    }
}
