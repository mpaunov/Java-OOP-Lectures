package interfacesAndAbstraction;

import interfacesAndAbstraction.CarShop.*;
import interfacesAndAbstraction.SayHello.*;
import interfacesAndAbstraction.borderControl.Citizen;
import interfacesAndAbstraction.borderControl.Identifiable;
import interfacesAndAbstraction.borderControl.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            Identifiable identifiable = tokens.length == 2
                    ? new Robot(tokens[0], tokens[1])
                    : new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            identifiables.add(identifiable);

            line = scanner.nextLine();
        }

        String lastFakeDigits = scanner.nextLine();

        System.out.println(identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(lastFakeDigits))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
