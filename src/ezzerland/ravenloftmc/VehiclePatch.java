package ezzerland.ravenloftmc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.wimbli.WorldBorder.BorderData;
import com.wimbli.WorldBorder.Config;

public class VehiclePatch extends JavaPlugin implements Listener
{
  public void onEnable() { getServer().getPluginManager().registerEvents(this, this); }

  @EventHandler
  public void enterVehicle(VehicleEnterEvent e)
  {
    BorderData border = Config.Border(e.getVehicle().getLocation().getWorld().getName());
    if ((border != null) && (!border.insideBorder(e.getVehicle().getLocation()))) { e.setCancelled(true); return; }
  }
}