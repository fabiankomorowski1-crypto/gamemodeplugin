package com.fabian.gamemodeplugin;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        
        // Sprawdzamy, czy to gracz
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTylko gracze mogą użyć tej komendy!");
            return true;
        }

        Player player = (Player) sender;

        // Sprawdzamy uprawnienia
        if (!player.hasPermission("gamemode.use")) {
            player.sendMessage("§cNie masz uprawnień do użycia tej komendy!");
            return true;
        }

        // Sprawdzamy, czy podano argument
        if (args.length == 0) {
            player.sendMessage("§cUżycie: /gamemode <0|1|2|3>");
            player.sendMessage("§70 - Survival");
            player.sendMessage("§71 - Creative");
            player.sendMessage("§72 - Adventure");
            player.sendMessage("§73 - Spectator");
            return true;
        }

        GameMode gameMode;
        String modeNumber = args[0];

        try {
            int mode = Integer.parseInt(modeNumber);
            gameMode = parseGameMode(mode);

            if (gameMode == null) {
                player.sendMessage("§cNieprawidłowy tryb gry! Użyj: 0, 1, 2 lub 3");
                return true;
            }
        } catch (NumberFormatException e) {
            player.sendMessage("§cNieprawidłowy argument! Użyj liczby: 0, 1, 2 lub 3");
            return true;
        }

        // Zmieniamy tryb gry
        player.setGameMode(gameMode);
        player.sendMessage("§aZmieniono tryb gry na: §6" + gameMode.toString());

        return true;
    }

    private GameMode parseGameMode(int mode) {
        return switch (mode) {
            case 0 -> GameMode.SURVIVAL;
            case 1 -> GameMode.CREATIVE;
            case 2 -> GameMode.ADVENTURE;
            case 3 -> GameMode.SPECTATOR;
            default -> null;
        };
    }
}
