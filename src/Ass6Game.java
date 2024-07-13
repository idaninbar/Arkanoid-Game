import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import biuoop.GUI;

/**
 * 208765982 Idan Inbar.
 */
public class Ass6Game {
    /**
     * is the main of the class.
     * @param args is the user's input.
     */
    public static void main(String[] args) {
        int counter = 0;
        List<LevelInformation> levelInformation = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            //if the user wants a specific level.
            try {
                int level = Integer.parseInt(args[i]);
                switch (level) {
                    case 1 :
                        levelInformation.add(new DirectHit());
                        break;
                    case 2 :
                        levelInformation.add(new WideEasy());
                        break;
                    case 3 :
                        levelInformation.add(new Green3());
                        break;
                    case 4 :
                        levelInformation.add(new FinalFour());
                        break;
                    default :
                }
            } catch (Exception exception) {
                counter++;
            }
        }
        //eun all the levels
        if (counter == args.length) {
            List<LevelInformation> informationList = Arrays.asList(new DirectHit(),
                    new WideEasy(), new Green3(), new FinalFour());
            levelInformation.addAll(informationList);
        }
        AnimationRunner animationRunner = new AnimationRunner(new GUI("Arknoid", 800, 600));
        GameFlow gameFlow = new GameFlow(animationRunner, animationRunner.getGui().getKeyboardSensor());
        gameFlow.runLevels(levelInformation);
        animationRunner.getGui().close();
    }
}
