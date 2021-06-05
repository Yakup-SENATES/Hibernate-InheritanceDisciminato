import javax.persistence.*;


@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(
		name="Vehicle_Type",
		discriminatorType = DiscriminatorType.STRING
		
		)
public class Vehicle {
	@Id  @GeneratedValue
	private int  vehicleID ;
	
	private String vehicleName;

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	} 
	
	
	
	
}
