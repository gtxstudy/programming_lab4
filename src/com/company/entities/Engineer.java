package com.company.entities;

import com.company.Gender;
import com.company.Device;

import java.util.Random;

public class Engineer extends Midget{
    public Engineer(Gender gender, String name) {
        super(gender, name);
    }

    public void repair(Device device) {
        System.out.printf("%s чинит %s...", getName(), device.describe());
        Random random = new Random();
        if (random.nextFloat()*100 >5)
            System.out.printf("%s починил %s!", getName(), device.describe());
        else
            System.out.printf("%s не удалось починить %s!", getName(), device.describe());
    }

}
