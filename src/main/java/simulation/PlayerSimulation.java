package simulation;

import common.CheckIdentityService;
import entity.Player;
import repository.PlayerRepository;

import java.util.*;

public class PlayerSimulation {
    public static void main(String[] args)
    {
        List<Player> database = new ArrayList<>();
        Player player1 = new Player(1, "1234567890","Sevval",
                "Yuksek", new Date(), "sevval", 15);
        database.add(player1);

        PlayerRepository repository = new PlayerRepository(database);

        //Get
        System.out.println("Get: " + repository.getById(1));

        //Validate identity number
        CheckIdentityService checkIdentityService = new CheckIdentityService(repository.getById(1));
        System.out.println("Does the service contain the player identity number of id 1?: " + checkIdentityService.validate());

        //Update
        player1.setFirstName("Cemre");
        repository.update(player1);
        System.out.println("Get: " + repository.getById(1));

        //Delete
        repository.delete(repository.getById(1));
        System.out.println("Deleted: " + repository.getById(1));
    }
}
