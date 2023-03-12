package main;

import classes.factory.ChildFactory;
import classes.input.AnnualChange;
import classes.input.InputChild;
import classes.result.Database;
import classes.result.Result;
import classes.result.ResultChild;
import classes.result.ResultChildren;
import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path output = Paths.get("output");
        if (!Files.exists(output)) {
            Files.createDirectories(output);
        }

        ChildFactory factory = new ChildFactory();
        int testNumber;

        for (testNumber = 1; testNumber <= Constants.TESTS_NUMBER; testNumber++) {

            Database database = objectMapper.readValue(new File(Constants.TEST_PATH
                    + testNumber + Constants.FILE_EXTENSION), Database.class);
            // Citesc inpututul intr-o baza de date

            Result result = new Result();
            // Creez clasa pentru rezultat

            for (InputChild inputChild : database.getInitialData().getChildren()) {
                ResultChild resultChild = factory.createChild(inputChild);
                if (resultChild.getAge() <= Constants.TEEN_AGE) {
                    database.getResultChildren().add(resultChild);
                }
            }
            // Transform toti copiii de tip input in tip result
            // si ii adaug in baza de date pe cei cu varsta < 19

            database.setBudgetUnit();
            for (ResultChild child : database.getResultChildren()) {
                child.setAssignedBudget(database.getBudgetUnit() * child.getAverageScore());
                database.findRightGifts(child);
            }
            // Calculez bugetul pentru fiecare copil si ii gasim cadourile potrivite

            ArrayList<ResultChild> roundZeroChildren = new ArrayList<>();
            for (ResultChild child : database.getResultChildren()) {
                roundZeroChildren.add(child.deepCopy());
            }
            ResultChildren resultChildren = new ResultChildren(roundZeroChildren);
            // Creez clasa ce se adauga in rezultat

            result.getAnnualChildren().add(resultChildren);
            // Adaug in rezultat prima lista de copii

            int changeNumber;
            for (changeNumber = 0; changeNumber < database.getNumberOfYears(); changeNumber++) {
                resultChildren = new ResultChildren();
                //Resetez copii rezultat

                AnnualChange change = database.getAnnualChanges().get(changeNumber);
                database.applyChange(change);
                // Am aplicat schimbarea pentru toti copiii

                for (ResultChild child : database.getResultChildren()) {
                    database.findRightGifts(child);
                }
                // Am dat cadourile potrivite copiilor

                for (ResultChild child : database.getResultChildren()) {
                    resultChildren.getChildren().add(child.deepCopy());
                }
                result.getAnnualChildren().add(resultChildren);
                // Adaug in rezultat lista de copii de la schimbarea i
            }
            // Fac acelasi lucru pentru fiecare schimbare

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(Constants.OUTPUT_PATH
                    + testNumber + Constants.FILE_EXTENSION), result);
            // Scriu in fisierul JSON rezultatul
        }
        Checker.calculateScore();
    }
}
