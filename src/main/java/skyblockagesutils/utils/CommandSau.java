package skyblockagesutils.utils;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;

public class CommandSau implements ICommand{

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "sau";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/sau <parameter>";
	}

	@Override
	public List<String> getAliases() {
		List<String> aliases = Lists.<String>newArrayList();
		aliases.add("/sau");
		return aliases;
	}

	@SuppressWarnings("null")
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		switch ( args[0].toLowerCase() ) {
			case "reload":
				ITextComponent component = null;
				component.appendText("reloading configs...");
				sender.sendMessage( component );
				Configs.sync();
				component = null;
				component.appendText("finished reloading!");
				sender.sendMessage( component );
				break;
			
			default:
				break;
		}
		
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@SuppressWarnings("null")
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		List<String> list = null;
		list.add("reload");
		return list;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
