package handong.capstone2019s.salesb.domain.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

	private Integer seq;
	
	@Version
	private Integer ver;

	private Date addTime;

	private Date updateTime;

	private Date deleteTime;
    
    private String adminCode;

    private String adminName;
    
    private String adminPass;

    private String adminMail;

    private String adminTel;
    
    public Admin(String adminCode) {
        this.adminCode = adminCode;
    }

}
