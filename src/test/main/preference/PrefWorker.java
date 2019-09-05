package test.main.preference;

import com.zeroc.Ice.Current;
import helper.PreferenceRequest;
import helper.SensorData;
import helper.User;
import support.Preference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrefWorker {
    private static final String APO = "APO";
    private static final String WEATHER = "weather";
    public static List<Preference> preferences;
    public User getUserInfo(String name) {
        Integer medicalType = 0;
        Integer clock = 0;
        Integer apoThreshhold = 0;
        SensorData sensorData = null;
        int weather = 0;
        List<Integer> tempThreshholds = new ArrayList<>();
        boolean apoReached = false;
        boolean tempReached = false;
        for (Preference preference : preferences) {
            if (preference.getName().equals(name)) {
                medicalType = preference.getMedicalCondition();
                List<String> suggestions = preference.getSuggestions();
                for (String suggestion : suggestions) {
                    try {
                        Integer temp = Integer.parseInt(suggestion.split("\\s")[1]);
                        tempThreshholds.add(temp);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        User result = new User(medicalType, tempThreshholds.stream().mapToInt(Integer::intValue).toArray(),
                apoThreshhold, clock, sensorData, weather, apoReached, tempReached);
        return result;
    }

    private static String getSuggestionTemp(String name, Integer tempThreshhold) {
        String result = null;
        Integer distance = Integer.MAX_VALUE;
        for (Preference preference : preferences) {
            if (preference.getName().equals(name)) {
                List<String> suggestions = preference.getSuggestions();
                for (String suggestion : suggestions) {
                    String[] splits = suggestion.split("\\s");
                    try {
                        Integer temp = Integer.parseInt(splits[1]);
                        Integer newDistance = tempThreshhold - temp;
                        if (newDistance < distance && temp <= tempThreshhold) {
                            result = splits[3];
                            distance = tempThreshhold - temp;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return result;
    }

    private static String getSuggestionAPO(String name) {
        String result = null;
        for (Preference preference : preferences) {
            if (preference.getName().equals(name)) {
                List<String> suggestions = preference.getSuggestions();
                for (String suggestion: suggestions){
                    String[] splits = suggestion.split("\\s");
                    String type = splits[1];
                    if (type.equals(APO)){
                        result = splits[3];
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static String getSuggestionWeather(String name, Integer weather) {
        String result = null;
        for (Preference preference : preferences) {
            if (preference.getName().equals(name)) {
                List<String> suggestions = preference.getSuggestions();
                for (String suggestion: suggestions){
                    String[] splits = suggestion.split("\\s");
                    String type = splits[1];
                    if (type.equals(WEATHER)){
                        result = splits[3];
                        break;
                    }
                }
            }
        }
        return result;
    }

    public String getPreference(PreferenceRequest request) {
        String result = null;
        String username = request.username;
        Integer weather = request.weather;
        String value = request.value;
        if (value.isEmpty()){
            result = getSuggestionWeather(username, weather);
        }
        else{
            if (value.equals(APO)) {
                result = getSuggestionAPO(username);
            } else {
                Integer temp = Integer.parseInt(value);
                result = getSuggestionTemp(username, temp);
            }
        }
        return result;
    }

    public static List<Preference> getPreferences() {
        return preferences;
    }

    public static void setPreferences(List<Preference> preferences) {
        PrefWorker.preferences = preferences;
    }
}
