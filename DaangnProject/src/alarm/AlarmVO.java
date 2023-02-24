package alarm;

import java.util.Date;

public class AlarmVO {

	private Date alarmCheckDate;
	private Date alarmDate;
	private String alarmType;
	private int alarmCheck;
	private String alarmMassage;
	private String memId2;
	private String memId1;
	private int alarmId;
	
	public AlarmVO() {
		super();
	}

	public Date getAlarmCheckDate() {
		return alarmCheckDate;
	}

	public void setAlarmCheckDate(Date alarmCheckDate) {
		this.alarmCheckDate = alarmCheckDate;
	}

	public Date getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public int getAlarmCheck() {
		return alarmCheck;
	}

	public void setAlarmCheck(int alarmCheck) {
		this.alarmCheck = alarmCheck;
	}

	public String getAlarmMassage() {
		return alarmMassage;
	}

	public void setAlarmMassage(String alarmMassage) {
		this.alarmMassage = alarmMassage;
	}

	public String getMemId2() {
		return memId2;
	}

	public void setMemId2(String memId2) {
		this.memId2 = memId2;
	}

	public String getMemId1() {
		return memId1;
	}

	public void setMemId1(String memId1) {
		this.memId1 = memId1;
	}

	public int getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}

	@Override
	public String toString() {
		return "Alarm [alarmType=" + alarmType + ", alarmCheck=" + alarmCheck + ", alarmMassage=" + alarmMassage
				+ ", memId2=" + memId2 + ", memId1=" + memId1 + ", alarmId=" + alarmId + "]";
	}
	
	
	
	
}
