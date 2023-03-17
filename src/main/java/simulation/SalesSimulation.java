package simulation;

import entity.Game;
import entity.Player;
import entity.Sale;
import entity.SaleGame;
import repository.SaleRepository;

import java.util.*;

public class SalesSimulation {
    public static void main(String[] args)
    {
        List<Sale> database = new ArrayList<>();

        Player player1 = new Player(1, "1234567890", "Sevval",
                "Yuksek", new Date(), "sevval",
                17);

        Game game1 = new Game(1,"Tetris", 15.25);

        SaleGame saleGame1 = new SaleGame(1, player1, game1.getPrice(), game1);
        database.add(saleGame1);

        SaleRepository repository = new SaleRepository(database);

        //Get
        System.out.println("Get: " + repository.getById(1));

        //Update
        saleGame1.setAmount(18);
        repository.update(saleGame1);
        System.out.println("Update: " + repository.getById(1));

        //Delete
        repository.delete(saleGame1);
        System.out.println("Delete: " + repository.getById(1));
    }
}
