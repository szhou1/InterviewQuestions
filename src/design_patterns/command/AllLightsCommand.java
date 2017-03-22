package design_patterns.command;

import java.util.List;

/**
 * Created by szhou on 3/22/17.
 */
public class AllLightsCommand implements Command {

    private List<Light> lights;

    public AllLightsCommand(List<Light> lights) {
        this.lights = lights;
    }


    @Override
    public void execute() {
        for (Light light : lights) {
            if (light.isOn()) {
                light.toggle();
            }
        }
    }
}
