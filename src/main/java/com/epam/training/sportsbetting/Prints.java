package com.epam.training.sportsbetting;

import com.epam.training.sportsbetting.domain.*;

import java.util.List;

public class Prints {

    public static void printNotEnoughBalance(Player player) {
        System.out.println("You don't have enought money, your balance is " + player.getBalance() + " " + player.getCurrency());
    }

    public static void printWagerSaved(Wager wager) {
        Outcome wagerOutcome = wager.getOdd().getOutcome();
        Bet wagerBet = wagerOutcome.getBet();
        System.out.println("Wager '" + wagerBet.getDescription() + "="
                + wagerOutcome.getDescription() +
                "' of " + wagerBet.getEvent().getTitle() + " [odd: " +
                wager.getOdd().getValue() + ", amount: " + wager.getAmount() + "] saved!");

    }

    public static int listBetting(List<OutcomeOdd> odds) {
        int bettingNumber = 0;
        Bet oddBet;
        SportEvent oddEvent;
        System.out.println("What are you want to bet on? (choose a number or press q for quit)");
        for( OutcomeOdd odd: odds){
            oddBet = odd.getOutcome().getBet();
            oddEvent = oddBet.getEvent();
            bettingNumber++;
            System.out.println(bettingNumber + ": Sport Event: " +
                    oddEvent.getTitle() + "(start: " +
                    oddEvent.getStartDate() + "), Bet: " +
                    oddBet.getDescription() + ", Outcome: " +
                    odd.getOutcome().getDescription() + ", Actual Odd: " +
                    odd.getValue() + ", Valid between " + odd.getValidFrom() + " and " + odd.getValidUnit());
        }
        return bettingNumber;
    }

    public static void printResults(List<Wager> wagers,Player usedPlayer) {
        System.out.println("Results:");
        Outcome wagerOutcome;
        for(Wager wager : wagers){
            wagerOutcome = wager.getOdd().getOutcome();
            System.out.println("Wager '" +
                    wagerOutcome.getBet().getDescription() + "=" +
                    wagerOutcome.getDescription() + "' of " +
                    wagerOutcome.getBet().getEvent().getTitle() + " [odd: " +
                    wager.getOdd().getValue() + ", amount: " + wager.getAmount() + "], Win: " + wager.isWin());
        }
        System.out.println("Your new balance is " + usedPlayer.getBalance() + " " + usedPlayer.getCurrency());
    }

    public static void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName());
        printBalance(player);
    }

    public static void printBalance(Player player) {
        System.out.println("Your balance is " + player.getBalance() + " " + player.getCurrency());
    }
}
