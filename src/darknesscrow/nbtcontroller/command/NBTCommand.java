package darknesscrow.nbtcontroller.command;


import darknesscrow.nbtcontroller.nbt.NbtHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NBTCommand implements CommandExecutor {
    public NBTCommand() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if (sender.hasPermission("nbtcontroller.command")) {
            if (args.length == 5) {
                String var5 = args[0];
                byte var6 = -1;
                switch(var5.hashCode()) {
                    case -934610812:
                        if (var5.equals("remove")) {
                            var6 = 0;
                        }
                        break;
                    case 96417:
                        if (var5.equals("add")) {
                            var6 = 1;
                        }
                        break;
                    case 113762:
                        if (var5.equals("set")) {
                            var6 = 2;
                        }
                }

                String var7;
                byte var8;
                double percentage;
                String nbt;
                byte var13;
                Player player;
                int enrgy;
                int MaxEnrgy;
                double toSet;

                switch(var6) {
                    case 0:
                        var7 = args[1];
                        var8 = -1;
                        switch(var7.hashCode()) {
                            case -1298713976:
                                if (var7.equals("energy")) {
                                    var8 = 1;
                                }
                                break;
                            case 3321596:
                                if (var7.equals("life")) {
                                    var8 = 0;
                                }
                        }

                        switch(var8) {
                            case 0:

                                try {
                                    percentage = Double.parseDouble(args[2]);
                                } catch (NumberFormatException var25) {
                                    sender.sendMessage("§c'" + args[2] + "' não é um número válido");
                                    return false;
                                }

                                nbt = args[3].toLowerCase();
                                var13 = -1;
                                switch(nbt.hashCode()) {
                                    case -1298713976:
                                        if (nbt.equals("energy")) {
                                            var13 = 2;
                                        }
                                        break;
                                    case -67617556:
                                        if (nbt.equals("maxenergy")) {
                                            var13 = 3;
                                        }
                                        break;
                                    case 3029410:
                                        if (nbt.equals("body")) {
                                            var13 = 0;
                                        }
                                        break;
                                    case 844532998:
                                        if (nbt.equals("maxbody")) {
                                            var13 = 1;
                                        }
                                }

                                switch(var13) {
                                    case 0:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        toSet = (double)(enrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    case 1:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    case 2:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    case 3:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    default:
                                        sender.sendMessage(this.getNBTList());
                                        return false;
                                }
                            case 1:

                                try {
                                    percentage = Double.parseDouble(args[2]);
                                } catch (NumberFormatException var24) {
                                    sender.sendMessage("§c'" + args[2] + "' não é um número válido");
                                    return false;
                                }

                                nbt = args[3].toLowerCase();
                                var13 = -1;
                                switch(nbt.hashCode()) {
                                    case -1298713976:
                                        if (nbt.equals("energy")) {
                                            var13 = 2;
                                        }
                                        break;
                                    case -67617556:
                                        if (nbt.equals("maxenergy")) {
                                            var13 = 3;
                                        }
                                        break;
                                    case 3029410:
                                        if (nbt.equals("body")) {
                                            var13 = 0;
                                        }
                                        break;
                                    case 844532998:
                                        if (nbt.equals("maxbody")) {
                                            var13 = 1;
                                        }
                                }

                                switch(var13) {
                                    case 0:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    case 1:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    case 2:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        toSet = (double)(enrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    case 3:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy - toSet));
                                        return false;
                                    default:
                                        sender.sendMessage(this.getNBTList());
                                        return false;
                                }
                            default:
                                sender.sendMessage(this.getCommandList());
                                return false;
                        }
                    case 1:
                        var7 = args[1];
                        var8 = -1;
                        switch(var7.hashCode()) {
                            case -1298713976:
                                if (var7.equals("energy")) {
                                    var8 = 1;
                                }
                                break;
                            case 3321596:
                                if (var7.equals("life")) {
                                    var8 = 0;
                                }
                        }

                        switch(var8) {
                            case 0:

                                try {
                                    percentage = Double.parseDouble(args[2]);
                                } catch (NumberFormatException var23) {
                                    sender.sendMessage("§c'" + args[2] + "' não é um número válido");
                                    return false;
                                }

                                nbt = args[3].toLowerCase();
                                var13 = -1;
                                switch(nbt.hashCode()) {
                                    case -1298713976:
                                        if (nbt.equals("energy")) {
                                            var13 = 2;
                                        }
                                        break;
                                    case -67617556:
                                        if (nbt.equals("maxenergy")) {
                                            var13 = 3;
                                        }
                                        break;
                                    case 3029410:
                                        if (nbt.equals("body")) {
                                            var13 = 0;
                                        }
                                        break;
                                    case 844532998:
                                        if (nbt.equals("maxbody")) {
                                            var13 = 1;
                                        }
                                }

                                switch(var13) {
                                    case 0:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        toSet = (double)(enrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    case 1:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    case 2:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    case 3:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    default:
                                        sender.sendMessage(this.getNBTList());
                                        return false;
                                }
                            case 1:

                                try {
                                    percentage = Double.parseDouble(args[2]);
                                } catch (NumberFormatException var22) {
                                    sender.sendMessage("§c'" + args[2] + "' não é um número válido");
                                    return false;
                                }

                                nbt = args[3].toLowerCase();
                                var13 = -1;
                                switch(nbt.hashCode()) {
                                    case -1298713976:
                                        if (nbt.equals("energy")) {
                                            var13 = 2;
                                        }
                                        break;
                                    case -67617556:
                                        if (nbt.equals("maxenergy")) {
                                            var13 = 3;
                                        }
                                        break;
                                    case 3029410:
                                        if (nbt.equals("body")) {
                                            var13 = 0;
                                        }
                                        break;
                                    case 844532998:
                                        if (nbt.equals("maxbody")) {
                                            var13 = 1;
                                        }
                                }

                                switch(var13) {
                                    case 0:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    case 1:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    case 2:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        toSet = (double)(enrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    case 3:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)((double)enrgy + toSet));
                                        return false;
                                    default:
                                        sender.sendMessage(this.getNBTList());
                                        return false;
                                }
                            default:
                                sender.sendMessage(this.getCommandList());
                                return false;
                        }
                    case 2:
                        var7 = args[1];
                        var8 = -1;
                        switch(var7.hashCode()) {
                            case -1298713976:
                                if (var7.equals("energy")) {
                                    var8 = 1;
                                }
                                break;
                            case 3321596:
                                if (var7.equals("life")) {
                                    var8 = 0;
                                }
                        }

                        switch(var8) {
                            case 0:

                                try {
                                    percentage = Double.parseDouble(args[2]);
                                } catch (NumberFormatException var21) {
                                    sender.sendMessage("§c'" + args[2] + "' não é um número válido");
                                    return false;
                                }

                                nbt = args[3].toLowerCase();
                                var13 = -1;
                                switch(nbt.hashCode()) {
                                    case -1298713976:
                                        if (nbt.equals("energy")) {
                                            var13 = 2;
                                        }
                                        break;
                                    case -67617556:
                                        if (nbt.equals("maxenergy")) {
                                            var13 = 3;
                                        }
                                        break;
                                    case 3029410:
                                        if (nbt.equals("body")) {
                                            var13 = 0;
                                        }
                                        break;
                                    case 844532998:
                                        if (nbt.equals("maxbody")) {
                                            var13 = 1;
                                        }
                                }

                                switch(var13) {
                                    case 0:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getBdy(player);
                                        toSet = (double)(enrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)toSet);
                                        return false;
                                    case 1:
                                        player = Bukkit.getPlayer(args[4]);
                                        NbtHandler.getInstance().getBdy(player);
                                        toSet = NbtHandler.getInstance().getMaxBdy(player);
                                        toSet = toSet / 100.0D * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)toSet);
                                        return false;
                                    case 2:
                                        player = Bukkit.getPlayer(args[4]);
                                        NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)toSet);
                                        return false;
                                    case 3:
                                        player = Bukkit.getPlayer(args[4]);
                                        NbtHandler.getInstance().getBdy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setBdy(player, (int)toSet);
                                        return false;
                                    default:
                                        sender.sendMessage(this.getNBTList());
                                        return false;
                                }
                            case 1:

                                try {
                                    percentage = Double.parseDouble(args[2]);
                                } catch (NumberFormatException var20) {
                                    sender.sendMessage("§c'" + args[2] + "' não é um número válido");
                                    return false;
                                }

                                nbt = args[3].toLowerCase();
                                var13 = -1;
                                switch(nbt.hashCode()) {
                                    case -1298713976:
                                        if (nbt.equals("energy")) {
                                            var13 = 2;
                                        }
                                        break;
                                    case -67617556:
                                        if (nbt.equals("maxenergy")) {
                                            var13 = 3;
                                        }
                                        break;
                                    case 3029410:
                                        if (nbt.equals("body")) {
                                            var13 = 0;
                                        }
                                        break;
                                    case 844532998:
                                        if (nbt.equals("maxbody")) {
                                            var13 = 1;
                                        }
                                }

                                switch(var13) {
                                    case 0:
                                        player = Bukkit.getPlayer(args[4]);
                                        NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)toSet);
                                        return false;
                                    case 1:
                                        player = Bukkit.getPlayer(args[4]);
                                        NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxBdy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)toSet);
                                        return false;
                                    case 2:
                                        player = Bukkit.getPlayer(args[4]);
                                        enrgy = NbtHandler.getInstance().getEnrgy(player);
                                        toSet = (double)(enrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)toSet);
                                        return false;
                                    case 3:
                                        player = Bukkit.getPlayer(args[4]);
                                        NbtHandler.getInstance().getEnrgy(player);
                                        MaxEnrgy = NbtHandler.getInstance().getMaxEnrgy(player);
                                        toSet = (double)(MaxEnrgy / 100) * percentage;
                                        NbtHandler.getInstance().setEnrgy(player, (int)toSet);
                                        return false;
                                    default:
                                        sender.sendMessage(this.getNBTList());
                                        return false;
                                }
                            default:
                                sender.sendMessage(this.getCommandList());
                                return false;
                        }
                    default:
                        sender.sendMessage(this.getCommandList());
                }
            } else {
                sender.sendMessage(this.getCommandList());
            }
        } else {
            sender.sendMessage("§cVocê não tem permissão para executar esse comando");
        }

        return false;
    }

    public String[] getCommandList() {
        return new String[]{"§6/jrmcnbt remove life <Porcentagem> <Nbt> <Player>", "§6/jrmcnbt add life <Porcentagem> <Nbt> <Player>", "§6/jrmcnbt remove energy <Porcentagem> <Nbt> <Player>", "§6/jrmcnbt add energy <Porcentagem> <Nbt> <Player>", "§6/jrmcnbt set life <Porcentagem> <Nbt> <Player>", "§6/jrmcnbt set energy <Porcentagem> <Nbt> <Player>"};
    }

    public String[] getNBTList() {
        return new String[]{"§bBody = §6Vida", "§bMaxBody = §6Vida Máxima", "§bEnergy = §6Energia", "§bMaxEnergy = §6Energia Máxima"};
    }
}