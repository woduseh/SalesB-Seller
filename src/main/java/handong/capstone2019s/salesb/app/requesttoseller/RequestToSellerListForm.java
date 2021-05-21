package handong.capstone2019s.salesb.app.requesttoseller;

import java.io.Serializable;

public class RequestToSellerListForm implements Serializable {

	/**
	 * SerialVersion 
	 */
	private static final long serialVersionUID = 2L;
	
	private int seq;
	
	private String ver;

	private String client;

	private String thePersonInCharge;

	private String requestName;

	private String requestContents;

	private String addTime;

	private String updateTime;

	private String deleteTime;

    @Override
    public String toString() {
        return "&seq=" + seq
                + "&client=" + client
                + "&thePersonInCharge=" + thePersonInCharge + "&requestName=" + requestName  
                + "&requestContents=" + requestContents + "&addTime=" + addTime
                + "&updateTime=" + updateTime
                + "&deleteTime=" + deleteTime;
    }
}
