package practicefusioncodingchallenge;

import java.util.ArrayList;
import java.util.Collections;
// import java.util.Comparator;
import java.util.List;
// import com.sun.javafx.scene.control.skin.VirtualFlow;
// import java.lang.reflect.Field;
import java.util.*;

/**
 * SimilarDoctors aims to find a prioritized list of doctors similar to a given
 * doctor based on a set of attributes / features.
 *
 * I have defined similarity as follows:
 *
 * Given two {@link Doctor} objects {@code d1} and {@code d2}, and attributes
 * {@code features}, we consider {@code d1} to be similar to {@code d2} if:
 *
 * <ul>
 * <li>all scalar attributes in {@code features} are equal in {@code d1} and
 * {@code d2},</li>
 * <li>the vector attribute in {@code d1} is a superset of the one in
 * {@code d2}</li>
 * </ul>
 *
 * The result list of similar doctors can be prioritized based on a few
 * attributes (name, location, experience, speciality).
 *
 * @author Priyanka Rao
 * @version 1.0.0
 */
public class SimilarDoctors {

    /**
     * The list of all doctors we know.
     *
     * We will find doctors similar to a doctor from this list. That it is a
     * common "database" of sorts, we can share this field across all instances.
     */
    private static List<Doctor> allDoctors;

    /**
     * Provides a list of allowed features/attributes.
     *
     * You want to search for doctors based on these attributes.
     */
    public enum feature {

        NAME,
        SPECIALITY,
        EXPERIENCE,
        LOCATION,
        HEALTHPLAN,
        ACCEPTINGNEWPATIENT;
    }

    public SimilarDoctors() {
    }

    public SimilarDoctors(List<Doctor> doctorList) {
        this.allDoctors = doctorList;
    }

    /**
     * Finds doctors in the list of all doctors ({@code allDoctors}) that are
     * similar to {@code doctor} based on {@code features}.
     *
     * @param doctor a {@link Doctor} object for which we want to find similar
     * Doctor objects
     * @param features attributes which will be used for determining similarity
     * (a variable argument containing values from {@link feature})
     * @return a list of {@link Doctor} objects similar to {@code doctor} if any
     * were found, null otherwise
     */
    public List<Doctor> findSimilarDoctors(Doctor doctor, feature... features) {
        if (doctor == null || features == null) {
            return null;
        }
        List<Doctor> similarDoctors = new ArrayList<Doctor>();
        for (Doctor doc : allDoctors) {
            if (similar(doc, doctor, features)) {
                similarDoctors.add(doc);
            }
        }
        return similarDoctors;
    }

    /**
     * Compares two doctor objects for similarity based on list of features.
     *
     * Given a set of attributes / features, two {@link Doctor} objects are
     * considered similar if both objects have equivalent values for all the
     * specified attributes. "Equivalent" can mean "equal to" or "a superset of"
     * depending on the attribute. E.g., if the attribute is "speciality",
     * "equivalent" amounts to "equal" whereas if the attribute is
     * "healthplans", then "equivalent" amounts to "is superset of": if one
     * doctor's accepted health insurance plans are a superset of another
     * doctor's, then those two doctors are equivalent (so far as accepted
     * health insurance plans go).
     *
     * ASSUMPTIONS: it does not make a lot of sense to find similarity based on
     * name, so if that is the attribute specified, it is ignored.
     *
     * @param doc1 an instance of {@link Doctor} class
     * @param doc2 an instance of {@link Doctor} class
     * @param features attributes which will be used for determining similarity
     * (a variable argument containing values from {@link feature})
     * @return true if {@code doc1} and {@code doc2} are similar, false
     * otherwise
     */
    boolean similar(Doctor doc1, Doctor doc2, feature... features) {
        for (feature f : features) {
            switch (f) {
                case LOCATION:
                    if (!(doc1.getLocation().equals(doc2.getLocation()))) {
                        return false;
                    }
                    break;
                case SPECIALITY:
                    if (!(doc1.getSpeciality().equals(doc2.getSpeciality()))) {
                        return false;
                    }
                    break;
                case ACCEPTINGNEWPATIENT:
                    if (doc1.getAcceptingPatient() != doc2.getAcceptingPatient()) {
                        return false;
                    }
                    break;
                case HEALTHPLAN:
                    if (!isHealthPlansSuperset(doc1, doc2)) {
                        return false;
                    }
                    break;
                case EXPERIENCE:
                    if (doc1.getExperience() != doc2.getExperience()) {
                        return false;
                    }
                    break;
                case NAME:
                    // It does not make sense to find similarity based on name,
                    // while at the same time, it is overkill to stop
                    // similarity-processing if name is one of the attributes,
                    // so we'll pretend names are always "similar", effectively
                    // making this branch a no-op.
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /**
     * Determines if health insurance plans accepted by {@code doc1} is a
     * superset of those accepted by {@code doc2}.
     *
     * @param doc1 an instance of Doctor class
     * @param doc2 an instance of Doctor class
     * @return true if health plans accepted by {@code doc1} is a superset of
     * those accepted by {@code doc2}, false otherwise
     */
    public boolean isHealthPlansSuperset(Doctor doc1, Doctor doc2) {
        if (doc1 == null || doc2 == null) {
            return false;
        }
        List<String> healthPlansDoctor1 = doc1.getHealthcarePlans();
        List<String> healthPlansDoctor2 = doc2.getHealthcarePlans();
        for (String plan : healthPlansDoctor2) {
            if (!healthPlansDoctor1.contains(plan)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prioritizes a list of doctors.
     *
     * For simplicity's sake, prioritizing is sorting. In this version, we will
     * prioritize by name.
     *
     * @param doctors list of {@link Doctor} objects to prioritize
     */
    public void priortize(List<Doctor> doctors) {
        if (doctors == null || doctors.isEmpty()) {
            return;
        }
        prioritize(doctors, feature.NAME);
    }

    /**
     * Prioritizes a list of doctors based on some attribute.
     *
     * For simplicity's sake, prioritizing is sorting.
     * 
     * NOTE: assume prioritizing based only on name, experience, practice
     * location and speciality,
     *
     * @param doctors list of {@link Doctor} objects to prioritize
     * @param sortBy the scalar attribute by which to sort
     * 
     */
    public void prioritize(List<Doctor> doctors, feature sortBy) {
        if (doctors == null || doctors.isEmpty()) {
            return;
        }

        if (sortBy == null) {
            sortBy = feature.NAME;
        }

        switch (sortBy) {
            case NAME:
                Collections.sort(doctors, Doctor.NameComparator);
                break;
            case EXPERIENCE:
                Collections.sort(doctors, Doctor.ExperienceComparator);
                break;
            case LOCATION:
                Collections.sort(doctors, Doctor.LocationComparator);
                break;
            case SPECIALITY:
                Collections.sort(doctors, Doctor.SpecialityComparator);
                break;
            default:
                // If we got an invalid/unsupported prioritization attribute,
                // we'll just prioritize by name instead - that way we always
                // do something useful.
                Collections.sort(doctors, Doctor.NameComparator);
                break;
        }
    }
}
