import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

//main class name /layout goto

public class AllergyScore {
  public static void main(String[] args){
    String layout = ("templates/layout.vtl");

    // input page is where the user enters their information

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/input.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    // output page is where the information is displayed to the user

      get("/output", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/output.vtl");

    // this method changed the sting the user inputs to a usable Integer

        String stringUserInput = request.queryParams("userInput");
        Integer intUserInput = Integer.parseInt(stringUserInput);

    // make sure to let the form know to put this in the output(?)

        String outPut = createScore(intUserInput);
        model.put("outPut", outPut);
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    }

    public static String createScore (Integer intUserInput) {

      Integer eggs = 1;

      while (intUserInput > 0)
      {
        if (intUserInput == 1) {
        System.out.println("eggs");

        }
        else {
          break ;
        }
      }

  String allergyReturn = String.format("You are allergic to %. ", eggs);
  return allergyReturn;
  }
}
