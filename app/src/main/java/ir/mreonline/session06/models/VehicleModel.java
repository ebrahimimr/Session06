
package ir.mreonline.session06.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleModel {

    @SerializedName("vehicles")
    @Expose
    private List<Vehicle> vehicles = null;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
