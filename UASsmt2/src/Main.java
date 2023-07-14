import Model.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Model/Modelj.json"));
            StringBuilder builder = new StringBuilder();
            String jsonLine;

            while ((jsonLine = reader.readLine()) != null) {
                builder.append(jsonLine);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONObject menuObject = jsonObject.getJSONObject("Menu");
            JSONObject popupObject = menuObject.getJSONObject("popup");
            JSONArray menuitemArray = popupObject.getJSONArray("menuitem");

            // Iterate over menuitem entities
            for (int i = 0; i < menuitemArray.length(); i++) {
                JSONObject menuitem = menuitemArray.getJSONObject(i);
                String value = menuitem.getString("value");
                String onclick = menuitem.getString("onclick");

                Model model = new Model();
                model.setMenuitem(value);
                model.setOrientid(onclick);

                // Do something with the Model object
                System.out.println("Menuitem: " + model.getMenuitem());
                System.out.println("Orientid: " + model.getOrientid());
                System.out.println("---------------------");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
