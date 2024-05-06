package Loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DialogueNode {
    private String text;
    private List<DialogueNode> options;

    public DialogueNode(String text) {
        this.text = text;
        this.options = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public List<DialogueNode> getOptions() {
        return options;
    }

    public void addOption(DialogueNode option) {
        options.add(option);
    }
}

public class DialogueTree {
    public static void main(String[] args) {
        // Create dialogue nodes
        DialogueNode start = new DialogueNode("Hello, adventurer! Welcome to our village.");
        DialogueNode option1 = new DialogueNode("What can you tell me about this village?");
        DialogueNode option2 = new DialogueNode("Do you have any quests for me?");
        DialogueNode option1Response = new DialogueNode("Our village is known for its friendly people and beautiful surroundings.");
        DialogueNode option2Response = new DialogueNode("Yes, I have a quest for you. A group of goblins has been causing trouble in the nearby forest...");

        // Link dialogue nodes
        start.addOption(option1);
        start.addOption(option2);
        option1.addOption(option1Response);
        option2.addOption(option2Response);

        // Start conversation
        dialogueConversation(start);
    }

    public static void dialogueConversation(DialogueNode currentNode) {
        Scanner scanner = new Scanner(System.in);
        while (currentNode != null) {
            System.out.println(currentNode.getText());
            List<DialogueNode> options = currentNode.getOptions();
            if (!options.isEmpty()) {
                System.out.println("Options:");
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i).getText());
                }
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= options.size()) {
                    currentNode = options.get(choice - 1);
                } else {
                    System.out.println("Invalid choice. Please choose again.");
                }
            } else {
                currentNode = null; // End of conversation
            }
        }
        scanner.close();
    }
}