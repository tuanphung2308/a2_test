//package test.integration;
//
//import com.zeroc.Ice.Current;
//import helper.User;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import main.ContextManager;
//import main.PreferenceRepository;
//import support.Preference;
//import test.unit.main.preference.PrefWorker;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class Stepdefs {
//    private String username;
//    private String actualAnswer;
//    PreferenceRepository preferenceRepository = new PreferenceRepository();
//
//    @Given("^username is \"([^\"]*)\"$")
//    public void today_is(String username) {
//        this.username = username;
//    }
//
//    @When("the Context Manager passes the username to the Preference Repo$")
//    public void i_ask_whether_it_s_Friday_yet() throws Exception {
//        Method method = (PreferenceRepository.class).getDeclaredMethod("readPreference");
//        method.setAccessible(true);
//        List<Preference> results = (List<Preference>) method.invoke(preferenceRepository);
//
//        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
//        communicatorField.setAccessible(true);
//        communicatorField.set(null, com.zeroc.Ice.Util.initialize());
//
//        Method iniPreferenceWorker = (ContextManager.class).getDeclaredMethod("iniPreferenceWorker");
//        iniPreferenceWorker.setAccessible(true);
//        iniPreferenceWorker.invoke(null);
//
//        Field weatherField = (ContextManager.class).getDeclaredField("currentWeather");
//        weatherField.setAccessible(true);
//        weatherField.set(null, 0);
//
//        ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();
//        contextManagerWorkerI.addUser(username, new Current());
//    }
//
//    @Then("^the config should load the config of the user$")
//    public void i_should_be_told() throws Exception{
//        Field field = (ContextManager.class).getDeclaredField("users");
//        field.setAccessible(true);
//        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);
//        assertTrue(users.containsKey(username));
////        assertEquals(expectedAnswer, actualAnswer);
//    }
//
//    @Then("medical condition is {int}")
//    public void medical_condition_is(Integer medicalCondition) throws  Exception{
//        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
//        initMethod.setAccessible(true);
//        PrefWorker.setPreferences((List< Preference >) initMethod.invoke(null));
//
//        PrefWorker prefWorker = new PrefWorker();
//        User user = prefWorker.getUserInfo(username);
//
//        assertEquals(medicalCondition.intValue(), user.medicalConditionType);
//    }
//
//    @Then("^personal preference is (.*?)$")
//    public void cond_is(String personalPref) throws Exception{
//        Method method = (PreferenceRepository.class).getDeclaredMethod("readPreference");
//        method.setAccessible(true);
//        ;
//        List<Preference> results = (List<Preference>) method.invoke(preferenceRepository);
//        for (Preference p : results) {
//            if (username.equals(p.getName())) {
//                assertEquals("Equal", Arrays.asList(personalPref.split(",")), p.getSuggestions());
//            }
//        }
//    }
//}
