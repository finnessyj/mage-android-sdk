package mil.nga.giat.mage.sdk.datastore.location;

import mil.nga.giat.mage.sdk.datastore.common.Geometry;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "location_geometries")
public class LocationGeometry {

	@DatabaseField(generatedId = true)
	private Long pk_id;

	@DatabaseField(canBeNull = false, dataType=DataType.SERIALIZABLE)
	private Geometry geometry;

	public LocationGeometry() {
		// ORMLite needs a no-arg constructor
	}

	public LocationGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Long getPk_id() {
		return pk_id;
	}
	
	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "LocationGeometry [pk_id=" + pk_id + ", geometry=" + getGeometry() + "]";
	}
}