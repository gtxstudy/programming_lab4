package com.company.entities;

import com.company.Gender;
import com.company.resources.Resource;

import java.util.Random;

public class Researcher extends Midget{
    public Researcher(Gender gender, String name) {
        super(gender, name);
    }

    public void research(Resource resource){
        System.out.printf("%s исследует %s...", getName(), resource.describe());
        Random random = new Random();
        if (random.nextFloat()*100 >90)
            System.out.printf("%s произвел открытие, исследуя %s!", getName(), resource.describe());
    }

}
