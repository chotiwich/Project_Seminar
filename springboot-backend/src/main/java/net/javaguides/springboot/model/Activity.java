package net.javaguides.springboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activities")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="activity_name")
	private String activityName;
	
	@Column(name="activity_detail")
	private String activityDetail;
	
	@Column(name="activity_date")
	private String activityDate;
	
	@Column(name="activity_location")
	private String activityLocation;
	
	@Column(name="activity_url")
	private String activityUrl;
	
	public Activity() {
		
	}
	
	public Activity(String activityName, String activityDetail, String activityDate, String activityLocation,
			String activityUrl) {
		super();
		this.activityName = activityName;
		this.activityDetail = activityDetail;
		this.activityDate = activityDate;
		this.activityLocation = activityLocation;
		this.activityUrl = activityUrl;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivity_name(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityDetail() {
		return activityDetail;
	}
	public void setActivity_Detail(String activityDetail) {
		this.activityDetail = activityDetail;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public String getActivityLocation() {
		return activityLocation;
	}
	public void setActivityLocation(String activityLocation) {
		this.activityLocation = activityLocation;
	}
	public String getActivityUrl() {
		return activityUrl;
	}
	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}
	
	
}
