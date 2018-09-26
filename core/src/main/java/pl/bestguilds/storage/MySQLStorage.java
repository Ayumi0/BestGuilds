package pl.bestguilds.storage;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.user.User;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Xierip on 2018-09-26.
 * Web: http://xierip.pl
 */
public class MySQLStorage implements Storage {

  private final BestGuildsAPI plugin;
  private final HikariConfig hikariConfig;
  private HikariDataSource hikariDataSource;

  public MySQLStorage(BestGuildsAPI plugin, HikariConfig hikariConfig){

    this.plugin = plugin;
    this.hikariConfig = hikariConfig;
  }

  @Override
  public void connect() throws Exception {
    hikariDataSource = new HikariDataSource(hikariConfig);
    Statement statement = hikariDataSource.getConnection().createStatement();
    //TODO: CREATE TABLES
    ResultSet resultSet = statement.executeQuery("SELECT * FROM bestguilds_guilds");
    while (resultSet.next()){
      //TODO: LOAD GUILDS
    }
    resultSet = statement.executeQuery("SELECT * FROM bestguilds_users");
    while (resultSet.next()){
      //TODO: LOAD USERS
    }
  }

  @Override
  public void disconnect() throws Exception{
    hikariDataSource.close();
  }

  @Override
  public void update(User user, User.UpdateType type, Object... objects) {

  }

  @Override
  public void update(Guild guild, Guild.UpdateType type, Object... objects) {

  }

}
