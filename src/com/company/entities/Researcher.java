package com.company.entities;

import com.company.resources.Resource;

import java.util.Random;

public class Researcher extends Midget{
    public Researcher(Gender gender, String name) {
        super(gender, name);
    }

    interface IExperiment {
        void make();
        String getResult();
    }

    public IExperiment research(Resource resource){

        class Experiment implements IExperiment {

            private boolean success = false;

            @Override
            public void make() {
                Random random = new Random();
                System.out.printf("%s исследует %s...", getName(), resource.describe());
                success = random.nextFloat() * 100 > 90;
            }

            @Override
            public String getResult() {
                if (success)
                    return String.format("%s произвел открытие, исследуя %s!", getName(), resource.describe());
                else
                    return "Эксперимент прошел неудачно";
            }
        }

        return new Experiment();
    }

}
