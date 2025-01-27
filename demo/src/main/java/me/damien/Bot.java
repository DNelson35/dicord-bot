package me.damien;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Bot {

  private final ShardManager shardManager;

  public Bot() throws LoginException {
    Dotenv dotenv = Dotenv.load();

    String botToken = dotenv.get("BOT_TOKEN");

    DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(botToken);
    builder.setStatus(OnlineStatus.ONLINE);
    builder.setActivity(Activity.watching("in horror of the profanity"));
    shardManager = builder.build();
  }

  public ShardManager getShardManager (){
    return shardManager;
  }

  public static void main(String[] args){
    try {
      Bot bot = new Bot();
    } catch (LoginException e) {
      System.out.println("ERROR: Invalid Token");
    }
  }
}
